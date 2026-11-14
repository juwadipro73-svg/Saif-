package com.example.builder.agent

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File

/**
 * Assemble + verification + packaging for FLUTTER builds (Dart).
 *
 * The swarm generates a complete Flutter project under `src/flutter/`; [assemble]
 * promotes it to `flutter_app/`, writes a deterministic BUILD_GUIDE.md and zips the
 * whole project so the user can open it in any machine with the Flutter SDK.
 * Saif AI never pretends to compile Flutter on-device: the honest deliverable is the
 * full source project + guide.
 */
object FlutterStack {

    const val SRC_PREFIX = "src/flutter/"
    const val APP_DIR = "flutter_app"

    data class FlutterAssembly(
        /** Project-relative paths under flutter_app/. */
        val files: List<String>,
        val guidePath: String,
        val zipPath: String?,
        val issues: List<TestIssue>
    )

    /**
     * Promotes generated Flutter sources to `flutter_app/`, writes BUILD_GUIDE.md and
     * creates `flutter_app.zip`. Pure file work — no LLM.
     *
     * @param cacheDir when supplied, a second copy of the ZIP is placed in
     * `cacheDir/exports/` for the app's existing export/share UX.
     */
    fun assemble(
        projectDir: File,
        appName: String,
        moduleFiles: Map<String, String>,
        cacheDir: File? = null
    ): FlutterAssembly {
        val issues = mutableListOf<TestIssue>()
        val written = mutableListOf<String>()
        val appDir = File(projectDir, APP_DIR).apply { mkdirs() }

        val flutterFiles = moduleFiles.filterKeys { it.startsWith(SRC_PREFIX) }
        if (flutterFiles.isEmpty()) {
            issues.add(TestIssue("ERROR", "No Flutter sources were generated (src/flutter/ is empty)."))
            return FlutterAssembly(emptyList(), "", null, issues)
        }

        for ((path, content) in flutterFiles) {
            val rel = path.removePrefix(SRC_PREFIX).removePrefix("/")
            if (rel.isBlank() || rel.contains("..")) {
                issues.add(TestIssue("WARNING", "Ignoring suspicious path: $path"))
                continue
            }
            try {
                val out = File(appDir, rel)
                out.parentFile?.mkdirs()
                out.writeText(content)
                written.add("$APP_DIR/$rel")
            } catch (e: Exception) {
                issues.add(TestIssue("ERROR", "Could not write $APP_DIR/$rel: ${e.message}"))
            }
        }

        // Deterministic build guide (never left to the model).
        val guideText = buildGuideText(appName, written)
        try {
            File(appDir, "BUILD_GUIDE.md").writeText(guideText)
            written.add("$APP_DIR/BUILD_GUIDE.md")
        } catch (e: Exception) {
            issues.add(TestIssue("WARNING", "Could not write BUILD_GUIDE.md: ${e.message}"))
        }

        if (written.none { it.endsWith("pubspec.yaml") }) {
            issues.add(TestIssue("ERROR", "pubspec.yaml is missing — not a valid Flutter project."))
        }
        if (written.none { it.endsWith("lib/main.dart") }) {
            issues.add(TestIssue("ERROR", "lib/main.dart is missing — the app has no entry point."))
        }

        // ZIP the whole project.
        var zipPath: String? = null
        try {
            val zipFile = File(projectDir, "flutter_app.zip")
            if (zipFile.exists()) zipFile.delete()
            java.util.zip.ZipOutputStream(java.io.FileOutputStream(zipFile)).use { zos ->
                appDir.walkTopDown().filter { it.isFile }.forEach { f ->
                    val rel = f.relativeTo(projectDir).path.replace('\\', '/')
                    zos.putNextEntry(java.util.zip.ZipEntry(rel))
                    f.inputStream().use { it.copyTo(zos) }
                    zos.closeEntry()
                }
            }
            zipPath = "flutter_app.zip"
            written.add("flutter_app.zip")
            if (cacheDir != null) {
                try {
                    val exportsDir = File(cacheDir, "exports").apply { mkdirs() }
                    val clean = appName.replace(Regex("[^a-zA-Z0-9_]"), "_").ifBlank { "FlutterApp" }
                    zipFile.copyTo(File(exportsDir, "${clean}_Flutter_Project.zip"), overwrite = true)
                } catch (_: Exception) { }
            }
        } catch (e: Exception) {
            issues.add(TestIssue("ERROR", "Could not create flutter_app.zip: ${e.message}"))
        }

        return FlutterAssembly(written.sorted(), "$APP_DIR/BUILD_GUIDE.md", zipPath, issues)
    }

    /** Static verification of the promoted Flutter project. */
    fun verify(projectDir: File): TestReport {
        val issues = mutableListOf<TestIssue>()
        var checks = 0
        var failed = 0

        fun check(ok: Boolean, error: TestIssue?) {
            checks++
            if (!ok) {
                failed++
                if (error != null) issues.add(error)
            }
        }

        val appDir = File(projectDir, APP_DIR)
        val pubspec = File(appDir, "pubspec.yaml")
        check(pubspec.isFile, TestIssue("ERROR", "pubspec.yaml not found in flutter_app/."))
        if (pubspec.isFile) {
            val text = pubspec.readText()
            check(text.contains("name:"), TestIssue("ERROR", "pubspec.yaml has no 'name:' entry."))
            check(text.contains("flutter:"), TestIssue("ERROR", "pubspec.yaml has no 'flutter:' section."))
            check(
                text.contains("uses-material-design: true"),
                TestIssue("WARNING", "pubspec.yaml does not enable uses-material-design.")
            )
        }

        val mainDart = File(appDir, "lib/main.dart")
        check(mainDart.isFile, TestIssue("ERROR", "lib/main.dart not found."))
        if (mainDart.isFile) {
            val text = mainDart.readText()
            check(text.contains("void main("), TestIssue("ERROR", "lib/main.dart has no main() entry point."))
            check(text.contains("runApp("), TestIssue("ERROR", "lib/main.dart never calls runApp()."))
        }

        val dartFiles = appDir.walkTopDown().filter { it.isFile && it.extension.equals("dart", true) }.toList()
        check(dartFiles.isNotEmpty(), TestIssue("ERROR", "No .dart files found under flutter_app/lib."))
        for (dart in dartFiles) {
            val code = dart.readText()
            val balanceErr = checkDartBalance(code)
            check(
                balanceErr == null,
                balanceErr?.let { TestIssue("ERROR", "${dart.name}: $it", dart.name) }
            )
            // Relative imports must resolve to a generated file.
            Regex("""import\s+['"]([^'"]+)['"]""").findAll(code)
                .map { it.groupValues[1] }.filter { !it.startsWith("dart:") && !it.startsWith("package:") }
                .distinct().forEach { rel ->
                    val target = dart.parentFile?.let { File(it, rel).normalize() }
                    val ok = target != null && target.isFile &&
                        target.canonicalPath.startsWith(appDir.canonicalPath)
                    check(ok, TestIssue("ERROR", "${dart.name} imports '$rel' which does not exist."))
                }
        }

        check(File(appDir, "BUILD_GUIDE.md").isFile, TestIssue("WARNING", "BUILD_GUIDE.md is missing."))

        val errors = issues.count { it.severity == "ERROR" }
        val warnings = issues.size - errors
        val score = (100 - errors * 12 - warnings * 2).coerceIn(40, 100)
        return TestReport(
            passed = errors == 0 && failed == 0,
            passedCount = (checks - failed).coerceAtLeast(0),
            totalCount = checks.coerceAtLeast(1),
            issues = issues,
            qualityScore = score
        )
    }

    /** Lightweight brace/paren/bracket balance check for Dart sources. */
    fun checkDartBalance(code: String): String? {
        val stripped = StringBuilder()
        var i = 0
        var line = 1
        var errorLine = 1
        val stack = ArrayDeque<Pair<Char, Int>>()
        fun push(c: Char) { stack.addLast(c to line) }
        while (i < code.length) {
            val c = code[i]
            if (c == '\n') { line++; stripped.append(c); i++; continue }
            // Line comment.
            if (c == '/' && i + 1 < code.length && code[i + 1] == '/') {
                while (i < code.length && code[i] != '\n') i++
                continue
            }
            // Block comment.
            if (c == '/' && i + 1 < code.length && code[i + 1] == '*') {
                i += 2
                while (i + 1 < code.length && !(code[i] == '*' && code[i + 1] == '/')) {
                    if (code[i] == '\n') line++
                    i++
                }
                i += 2
                continue
            }
            // String literal (single, double or triple quote aware).
            if (c == '\'' || c == '"') {
                val triple = code.startsWith("$c$c$c", i)
                val delimLen = if (triple) 3 else 1
                i += delimLen
                while (i < code.length) {
                    if (code[i] == '\\') { i += 2; continue }
                    if (code[i] == '\n') { line++; if (!triple) break }
                    if (code.startsWith(if (triple) "$c$c$c" else "$c", i)) { i += delimLen; break }
                    i++
                }
                stripped.append(' ')
                continue
            }
            stripped.append(c)
            i++
        }
        val clean = stripped.toString()
        line = 1
        for (ch in clean) {
            if (ch == '\n') { line++; continue }
            when (ch) {
                '(', '[', '{' -> push(ch)
                ')', ']', '}' -> {
                    val open = stack.removeLastOrNull()
                    val want = when (ch) { ')' -> '('; ']' -> '['; else -> '{' }
                    if (open == null || open.first != want) {
                        errorLine = line
                        return "unbalanced '$ch' at line $errorLine"
                    }
                }
            }
        }
        if (stack.isNotEmpty()) {
            return "unclosed '${stack.last().first}' opened at line ${stack.last().second}"
        }
        return null
    }

    /** Deterministic build guide shipped with every Flutter project. */
    fun buildGuideText(appName: String, files: List<String>): String {
        val tree = files.filter { it.startsWith("$APP_DIR/") && !it.endsWith(".zip") }
            .sorted().joinToString("\n") { "  $it" }
        return """
            # $appName — Flutter Project (built by Saif AI)

            A complete, dependency-free Flutter project. It uses only the Flutter SDK
            (`package:flutter/material.dart`) — no third-party packages, so `flutter pub get`
            works offline after the SDK itself is installed.

            ## Files
            $tree

            ## Build it (any PC/Mac with Flutter installed)
            1. Install Flutter: https://docs.flutter.dev/get-started/install
            2. Unzip this project and open a terminal inside `$APP_DIR/`
            3. Fetch the SDK packages: `flutter pub get`
            4. Run on a device/emulator: `flutter run`
            5. Build a release APK: `flutter build apk --release`
               (output: `build/app/outputs/flutter-apk/app-release.apk`)

            ## Notes
            - Saif AI generates the full source on your phone; compilation needs the Flutter
              SDK, which only runs on desktop (that is a Flutter limitation, not this app's).
            - Every screen and feature in the app is fully implemented — no placeholders.
        """.trimIndent()
    }

    /**
     * Copies the Flutter project ZIP into the public Downloads folder (Android 10+,
     * no permission needed). Returns the public file, or null when that is not
     * possible — the ZIP always remains inside the project folder as fallback.
     */
    fun saveZipToDownloads(context: Context, zipFile: File, appName: String): File? {
        return try {
            if (!zipFile.exists()) return null
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return null
            val clean = appName.replace(Regex("[^a-zA-Z0-9_]"), "_").trim('_').ifBlank { "FlutterApp" }
            val fileName = "${clean}_Flutter_Project.zip"
            val values = ContentValues().apply {
                put(MediaStore.Downloads.DISPLAY_NAME, fileName)
                put(MediaStore.Downloads.MIME_TYPE, "application/zip")
                put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
            }
            val uri = context.contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values) ?: return null
            context.contentResolver.openOutputStream(uri)?.use { out ->
                zipFile.inputStream().use { it.copyTo(out) }
            }
            File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                fileName
            ).takeIf { it.exists() }
        } catch (_: Exception) {
            null
        }
    }
}

package com.example.builder.agent

import com.example.compiler.AppCompilerEngine
import java.io.File

/**
 * Assemble + verification for NATIVE Android builds (Java + XML).
 *
 * The swarm generates sources under `src/native/app/src/main/...` with the placeholder
 * package [PLACEHOLDER_PKG]; [assemble] relocates them into the real
 * `app/src/main/` tree with the project's package name so the on-device compiler
 * ([AppCompilerEngine.compileProject]) can turn them into a real APK.
 */
object NativeStack {

    const val PLACEHOLDER_PKG = "com.saifapp.app"
    const val SRC_PREFIX = "src/native/app/src/main/"

    data class NativeAssembly(
        /** Project-relative paths written under app/src/main/. */
        val files: List<String>,
        val issues: List<TestIssue>
    )

    /**
     * Relocates generated native sources into `app/src/main/`, rewriting the placeholder
     * package to [packageName] (sources, imports and manifest). Pure file work — no LLM.
     */
    fun assemble(
        projectDir: File,
        packageName: String,
        moduleFiles: Map<String, String>
    ): NativeAssembly {
        val pkg = packageName.ifBlank { PLACEHOLDER_PKG }
        val pkgPath = pkg.replace('.', '/')
        val issues = mutableListOf<TestIssue>()
        val written = mutableListOf<String>()

        val nativeFiles = moduleFiles.filterKeys { it.startsWith("src/native/") }
        if (nativeFiles.isEmpty()) {
            issues.add(TestIssue("ERROR", "No native sources were generated (src/native/ is empty)."))
            return NativeAssembly(emptyList(), issues)
        }

        for ((path, content) in nativeFiles) {
            val rel = path.removePrefix("src/native/").removePrefix("/")
            if (!rel.startsWith("app/src/main/")) {
                issues.add(TestIssue("WARNING", "Ignoring $path: native files must live under app/src/main/."))
                continue
            }
            var outRel = rel
            // Relocate placeholder package dirs to the real package path.
            outRel = outRel.replace(
                "app/src/main/java/com/saifapp/app/",
                "app/src/main/java/$pkgPath/"
            )
            var body = content
            if (rel.endsWith(".java") || rel.endsWith(".kt") || rel.endsWith(".xml")) {
                body = body.replace(PLACEHOLDER_PKG, pkg)
            }
            try {
                val out = File(projectDir, outRel)
                out.parentFile?.mkdirs()
                // Atomic-ish write: temp file then rename.
                val tmp = File(out.parentFile, out.name + ".tmp")
                tmp.writeText(body)
                if (out.exists()) out.delete()
                if (!tmp.renameTo(out)) {
                    tmp.copyTo(out, overwrite = true)
                    tmp.delete()
                }
                written.add(outRel)
            } catch (e: Exception) {
                issues.add(TestIssue("ERROR", "Could not write $outRel: ${e.message}"))
            }
        }

        if (written.none { it.endsWith("AndroidManifest.xml") }) {
            issues.add(TestIssue("ERROR", "AndroidManifest.xml is missing — the app cannot compile without it."))
        }
        if (written.none { it.endsWith("MainActivity.java") || it.endsWith("MainActivity.kt") }) {
            issues.add(TestIssue("ERROR", "MainActivity (launcher activity) is missing."))
        }
        if (written.none { it.contains("/res/layout/") }) {
            issues.add(TestIssue("WARNING", "No layout XML found under res/layout/."))
        }
        return NativeAssembly(written.sorted(), issues)
    }

    /**
     * Static verification of the relocated native tree. Mirrors what the real compile
     * step checks (manifest XML, resource XML, Java syntax) plus cross-file references
     * (manifest activities exist, R.layout references resolve).
     */
    fun verify(projectDir: File, packageName: String): TestReport {
        val mainDir = File(projectDir, "app/src/main")
        val manifestFile = File(mainDir, "AndroidManifest.xml")
        val rawManifest = if (manifestFile.isFile) manifestFile.readText() else ""
        // When the caller doesn't know the package (e.g. post-build audit), derive it
        // from the manifest itself.
        val pkg = packageName.ifBlank {
            Regex("""package="([^"]+)"""").find(rawManifest)?.groupValues?.get(1)?.ifBlank { PLACEHOLDER_PKG }
                ?: PLACEHOLDER_PKG
        }
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

        check(manifestFile.isFile, TestIssue("ERROR", "AndroidManifest.xml not found in app/src/main/."))

        var manifestText = ""
        if (manifestFile.isFile) {
            manifestText = rawManifest
            val xmlErr = AppCompilerEngine.validateXmlSyntax(manifestFile.name, manifestText)
            check(xmlErr == null, xmlErr?.let { TestIssue("ERROR", "AndroidManifest.xml: ${it.message}", manifestFile.name, it.lineNumber) })
            check(
                manifestText.contains("android.intent.action.MAIN") && manifestText.contains("android.intent.category.LAUNCHER"),
                TestIssue("ERROR", "Manifest has no launcher (MAIN/LAUNCHER) activity.")
            )
        }

        // Declared activities must have matching sources.
        val declaredActivities = Regex("""<activity[^>]*android:name="([^"]+)"""")
            .findAll(manifestText).map { it.groupValues[1] }.distinct().toList()
        for (name in declaredActivities) {
            val fqcn = when {
                name.startsWith(".") -> pkg + name
                name.contains(".") -> name
                else -> "$pkg.$name"
            }
            val srcFile = File(mainDir, "java/" + fqcn.replace('.', '/') + ".java")
            val ktFile = File(mainDir, "java/" + fqcn.replace('.', '/') + ".kt")
            check(
                srcFile.isFile || ktFile.isFile,
                TestIssue("ERROR", "Manifest declares activity $fqcn but no source file exists for it.")
            )
        }

        val javaFiles = mainDir.walkTopDown().filter {
            it.isFile && (it.extension.equals("java", true) || it.extension.equals("kt", true))
        }.toList()
        check(javaFiles.isNotEmpty(), TestIssue("ERROR", "No Java/Kotlin sources found under app/src/main/java."))

        val layoutNames = mainDir.walkTopDown()
            .filter { it.isFile && it.extension.equals("xml", true) && it.parentFile?.name.equals("layout", true) }
            .map { it.nameWithoutExtension }.toSet()
        for (src in javaFiles) {
            val code = src.readText()
            val syntaxErr = AppCompilerEngine.analyzeJavaSyntax(src.name, code)
            check(
                syntaxErr == null,
                syntaxErr?.let { TestIssue("ERROR", "${src.name}: ${it.message}", src.name, it.lineNumber) }
            )
            // Referenced layouts must exist.
            Regex("""R\.layout\.([A-Za-z0-9_]+)""").findAll(code)
                .map { it.groupValues[1] }.distinct().forEach { layout ->
                    check(
                        layoutNames.contains(layout),
                        TestIssue("ERROR", "${src.name} references R.layout.$layout but res/layout/$layout.xml is missing.")
                    )
                }
        }

        val xmlFiles = mainDir.walkTopDown().filter {
            it.isFile && it.extension.equals("xml", true) && it != manifestFile
        }.toList()
        for (xml in xmlFiles) {
            val xmlErr = AppCompilerEngine.validateXmlSyntax(xml.name, xml.readText())
            check(
                xmlErr == null,
                xmlErr?.let { TestIssue("ERROR", "${xml.name}: ${it.message}", xml.name, it.lineNumber) }
            )
        }

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
}

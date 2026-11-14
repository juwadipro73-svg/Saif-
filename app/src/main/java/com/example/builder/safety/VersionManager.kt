package com.example.builder.safety

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.File

data class VersionMetadata(
    val versionNumber: Int,
    val timestamp: Long,
    val prompt: String,
    val summary: String,
    val changedFiles: List<String>,
    val testPassedCount: Int = 0,
    val testTotalCount: Int = 0
)

/**
 * Manages atomic commits and project version history under projects/<App>/.saif/versions/
 * Retains the last 15 versions and provides instantaneous rollback and undo.
 */
object VersionManager {
    private const val TAG = "VersionManager"
    private const val MAX_VERSIONS = 15

    /**
     * Atomically commits a new HTML document to disk:
     * 1. Validates with HtmlGuard
     * 2. Writes to temporary file first
     * 3. Upon passing validation, atomically moves into index.html and assets/index.html
     * 4. Saves a version archive under .saif/versions/vNNNN/
     * 5. Keeps index.prev.html for backwards compatibility
     */
    fun commitAtomic(
        projectDir: File,
        htmlContent: String,
        prompt: String,
        summary: String,
        changedFiles: List<String> = listOf("index.html"),
        testPassedCount: Int = 0,
        testTotalCount: Int = 0
    ): Result<Int> {
        val guardResult = HtmlGuard.validate(htmlContent)
        if (!guardResult.isValid) {
            val err = guardResult.issues.joinToString("\n• ")
            Log.e(TAG, "Atomic commit rejected by HtmlGuard:\n• $err")
            return Result.failure(IllegalStateException("Validation failed:\n• $err"))
        }

        val rootHtml = File(projectDir, "index.html")
        val assetsDir = File(projectDir, "app/src/main/assets").apply { mkdirs() }
        val assetHtml = File(assetsDir, "index.html")

        // Keep previous version as index.prev.html
        if (rootHtml.exists() && rootHtml.length() > 50) {
            try {
                val prevContent = rootHtml.readText()
                File(projectDir, "index.prev.html").writeText(prevContent)
                File(assetsDir, "index.prev.html").writeText(prevContent)
            } catch (e: Exception) {
                Log.w(TAG, "Could not write index.prev.html backup: ${e.message}")
            }
        }

        // Write to temp file first
        val tempFile = File(projectDir, "index.html.tmp")
        try {
            tempFile.writeText(htmlContent)

            // Atomic rename / copy
            tempFile.copyTo(rootHtml, overwrite = true)
            tempFile.copyTo(assetHtml, overwrite = true)
            tempFile.delete()
        } catch (e: Exception) {
            tempFile.delete()
            return Result.failure(e)
        }

        // Save version archive
        val nextVersionNum = getNextVersionNumber(projectDir)
        saveVersionArchive(
            projectDir = projectDir,
            versionNum = nextVersionNum,
            htmlContent = htmlContent,
            prompt = prompt,
            summary = summary,
            changedFiles = changedFiles,
            testPassed = testPassedCount,
            testTotal = testTotalCount
        )

        return Result.success(nextVersionNum)
    }

    private fun getVersionsDir(projectDir: File): File {
        return File(projectDir, ".saif/versions").apply { mkdirs() }
    }

    private fun getNextVersionNumber(projectDir: File): Int {
        val versionsDir = getVersionsDir(projectDir)
        val existing = versionsDir.listFiles()?.filter { it.isDirectory && it.name.startsWith("v") } ?: emptyList()
        val maxNum = existing.mapNotNull { it.name.removePrefix("v").toIntOrNull() }.maxOrNull() ?: 0
        return maxNum + 1
    }

    private fun saveVersionArchive(
        projectDir: File,
        versionNum: Int,
        htmlContent: String,
        prompt: String,
        summary: String,
        changedFiles: List<String>,
        testPassed: Int,
        testTotal: Int
    ) {
        try {
            val vDir = File(getVersionsDir(projectDir), String.format("v%04d", versionNum)).apply { mkdirs() }
            File(vDir, "index.html").writeText(htmlContent)

            val meta = JSONObject().apply {
                put("versionNumber", versionNum)
                put("timestamp", System.currentTimeMillis())
                put("prompt", prompt)
                put("summary", summary)
                put("changedFiles", org.json.JSONArray(changedFiles))
                put("testPassedCount", testPassed)
                put("testTotalCount", testTotal)
            }
            File(vDir, "meta.json").writeText(meta.toString(2))

            // Prune to retain last MAX_VERSIONS
            pruneVersions(projectDir)
        } catch (e: Exception) {
            Log.w(TAG, "Failed saving version archive: ${e.message}")
        }
    }

    /**
     * Commits a NATIVE build: the relocated `app/src/main/` tree is snapshotted into the
     * version archive (sources were already written atomically by the assembler).
     */
    fun commitNativeAtomic(
        projectDir: File,
        prompt: String,
        summary: String,
        changedFiles: List<String>,
        testPassedCount: Int = 0,
        testTotalCount: Int = 0
    ): Result<Int> {
        return try {
            val nextVersionNum = getNextVersionNumber(projectDir)
            val vDir = File(getVersionsDir(projectDir), String.format("v%04d", nextVersionNum)).apply { mkdirs() }
            val srcMain = File(projectDir, "app/src/main")
            if (srcMain.isDirectory) {
                copyTree(srcMain, File(vDir, "app/src/main"))
            }
            writeMetaJson(vDir, nextVersionNum, prompt, summary, changedFiles, testPassedCount, testTotalCount, "native")
            pruneVersions(projectDir)
            Result.success(nextVersionNum)
        } catch (e: Exception) {
            Log.e(TAG, "Native commit failed: ${e.message}", e)
            Result.failure(e)
        }
    }

    /**
     * Commits a FLUTTER build: the `flutter_app/` source tree plus the project ZIP are
     * snapshotted into the version archive.
     */
    fun commitFlutterAtomic(
        projectDir: File,
        prompt: String,
        summary: String,
        changedFiles: List<String>,
        testPassedCount: Int = 0,
        testTotalCount: Int = 0
    ): Result<Int> {
        return try {
            val nextVersionNum = getNextVersionNumber(projectDir)
            val vDir = File(getVersionsDir(projectDir), String.format("v%04d", nextVersionNum)).apply { mkdirs() }
            val appDir = File(projectDir, "flutter_app")
            if (appDir.isDirectory) {
                copyTree(appDir, File(vDir, "flutter_app"))
            }
            File(projectDir, "flutter_app.zip").takeIf { it.isFile }?.copyTo(File(vDir, "flutter_app.zip"), overwrite = true)
            writeMetaJson(vDir, nextVersionNum, prompt, summary, changedFiles, testPassedCount, testTotalCount, "flutter")
            pruneVersions(projectDir)
            Result.success(nextVersionNum)
        } catch (e: Exception) {
            Log.e(TAG, "Flutter commit failed: ${e.message}", e)
            Result.failure(e)
        }
    }

    private fun copyTree(src: File, dst: File) {
        src.walkTopDown().forEach { f ->
            val rel = f.relativeTo(src).path
            if (rel.isBlank()) return@forEach
            val out = File(dst, rel)
            if (f.isDirectory) out.mkdirs() else {
                out.parentFile?.mkdirs()
                f.copyTo(out, overwrite = true)
            }
        }
    }

    private fun writeMetaJson(
        vDir: File,
        versionNum: Int,
        prompt: String,
        summary: String,
        changedFiles: List<String>,
        testPassed: Int,
        testTotal: Int,
        stack: String
    ) {
        val meta = JSONObject().apply {
            put("versionNumber", versionNum)
            put("timestamp", System.currentTimeMillis())
            put("stack", stack)
            put("prompt", prompt)
            put("summary", summary)
            put("changedFiles", org.json.JSONArray(changedFiles))
            put("testPassedCount", testPassed)
            put("testTotalCount", testTotal)
        }
        File(vDir, "meta.json").writeText(meta.toString(2))
    }

    private fun pruneVersions(projectDir: File) {
        val versionsDir = getVersionsDir(projectDir)
        val existing = versionsDir.listFiles()?.filter { it.isDirectory && it.name.startsWith("v") }?.sortedBy { it.name } ?: return
        if (existing.size > MAX_VERSIONS) {
            val toDelete = existing.take(existing.size - MAX_VERSIONS)
            for (dir in toDelete) {
                dir.deleteRecursively()
            }
        }
    }

    fun listVersions(projectDir: File): List<VersionMetadata> {
        val versionsDir = getVersionsDir(projectDir)
        val dirs = versionsDir.listFiles()?.filter { it.isDirectory && it.name.startsWith("v") }?.sortedByDescending { it.name } ?: emptyList()
        val list = mutableListOf<VersionMetadata>()

        for (dir in dirs) {
            val metaFile = File(dir, "meta.json")
            if (metaFile.exists()) {
                try {
                    val json = JSONObject(metaFile.readText())
                    val filesArr = json.optJSONArray("changedFiles")
                    val files = mutableListOf<String>()
                    if (filesArr != null) {
                        for (i in 0 until filesArr.length()) files.add(filesArr.getString(i))
                    }
                    list.add(
                        VersionMetadata(
                            versionNumber = json.optInt("versionNumber"),
                            timestamp = json.optLong("timestamp"),
                            prompt = json.optString("prompt"),
                            summary = json.optString("summary"),
                            changedFiles = files,
                            testPassedCount = json.optInt("testPassedCount", 0),
                            testTotalCount = json.optInt("testTotalCount", 0)
                        )
                    )
                } catch (ignored: Exception) {}
            }
        }
        return list
    }

    fun restoreVersion(projectDir: File, versionNum: Int): Boolean {
        val vDir = File(getVersionsDir(projectDir), String.format("v%04d", versionNum))
        val vHtml = File(vDir, "index.html")
        if (!vHtml.exists()) return false

        val htmlContent = vHtml.readText()
        val rootHtml = File(projectDir, "index.html")
        val assetHtml = File(projectDir, "app/src/main/assets/index.html")

        rootHtml.writeText(htmlContent)
        assetHtml.writeText(htmlContent)
        return true
    }

    fun restorePrevious(projectDir: File): Boolean {
        val prev = File(projectDir, "index.prev.html")
        if (!prev.exists() || prev.length() < 50) return false
        val content = prev.readText()
        File(projectDir, "index.html").writeText(content)
        File(projectDir, "app/src/main/assets/index.html").writeText(content)
        return true
    }
}

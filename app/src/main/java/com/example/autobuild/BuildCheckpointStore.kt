package com.example.autobuild

import android.content.Context
import com.example.util.ProjectChatHistoryManager
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.security.MessageDigest

/**
 * Advance Auto-Builder — persistent per-project checkpoint.
 *
 * Stored at projects/<App>/.saif/autobuild.json so work survives app restarts, days of gap,
 * and process death. It records:
 * - every user prompt (append-only history),
 * - hashes of all generated files (to detect "peeche ka feature bigadna" / regressions),
 * - frozen files the user did NOT ask to touch (continue-forward rule),
 * - last quality score + findings (so background continuation knows what to fix next).
 *
 * All core APIs are [File]-based and unit-testable; only the small helpers need a [Context].
 */
data class BuildCheckpoint(
    val appName: String = "Project",
    val status: String = BuildCheckpointStore.STATUS_IDLE,
    val lastPhase: String = "",
    val promptHistory: List<String> = emptyList(),
    val completedTaskIds: List<String> = emptyList(),
    val fileHashes: Map<String, String> = emptyMap(),
    val passedProbes: List<String> = emptyList(),
    val lastPassedCount: Int = 0,
    val lastTotalCount: Int = 0,
    val frozenFiles: List<String> = emptyList(),
    val lastScore: Int = 0,
    val lastFindings: List<String> = emptyList(),
    val autoRoundsUsed: Int = 0,
    val lastActiveAt: Long = 0L,
    val lastError: String? = null
)

object BuildCheckpointStore {
    const val STATUS_IDLE = "IDLE"
    const val STATUS_RUNNING = "RUNNING"
    const val STATUS_NEEDS_CONTINUE = "NEEDS_CONTINUE"
    const val STATUS_DONE = "DONE"
    const val STATUS_FAILED = "FAILED"

    const val FILE_NAME = "autobuild.json"
    private const val STALE_RUNNING_MS = 45 * 60 * 1000L
    private const val MAX_PROMPT_HISTORY = 30
    private const val MAX_PROMPT_CHARS = 2000

    fun sanitize(appName: String): String =
        appName.replace(Regex("[^a-zA-Z0-9_]"), "_").ifBlank { "Project" }

    fun projectDirFor(context: Context, appName: String): File =
        File(context.filesDir, "projects/${sanitize(appName)}")

    fun checkpointFile(projectDir: File): File =
        File(projectDir, ".saif/$FILE_NAME")

    fun default(appName: String): BuildCheckpoint =
        BuildCheckpoint(appName = appName.ifBlank { "Project" })

    fun load(projectDir: File): BuildCheckpoint {
        return try {
            val file = checkpointFile(projectDir)
            if (!file.exists()) return default(projectDir.name)
            fromJson(JSONObject(file.readText()), projectDir.name)
        } catch (_: Exception) {
            default(projectDir.name)
        }
    }

    fun save(projectDir: File, checkpoint: BuildCheckpoint) {
        val file = checkpointFile(projectDir)
        file.parentFile?.mkdirs()
        val tmp = File(file.parentFile, "$FILE_NAME.tmp")
        tmp.writeText(toJson(checkpoint).toString(2))
        tmp.copyTo(file, overwrite = true)
        tmp.delete()
    }

    fun update(projectDir: File, transform: (BuildCheckpoint) -> BuildCheckpoint) {
        try {
            save(projectDir, transform(load(projectDir)))
        } catch (_: Exception) {
        }
    }

    fun appendPrompt(projectDir: File, appName: String, prompt: String) {
        update(projectDir) { cp ->
            // Fresh checkpoints (never written before) adopt the real project name instead of
            // the directory-derived placeholder; existing ones keep their stored name.
            val base = if (cp.promptHistory.isEmpty() && cp.lastActiveAt == 0L) cp.copy(appName = appName) else cp
            base.copy(
                promptHistory = (base.promptHistory + prompt.take(MAX_PROMPT_CHARS)).takeLast(MAX_PROMPT_HISTORY),
                lastActiveAt = System.currentTimeMillis()
            )
        }
    }

    /**
     * True when the project has unfinished business: explicitly marked for continuation,
     * failed, or stuck in RUNNING long enough that the process must have died.
     */
    fun hasPendingWork(projectDir: File): Boolean {
        return try {
            val cp = load(projectDir)
            when (cp.status) {
                STATUS_NEEDS_CONTINUE, STATUS_FAILED -> true
                STATUS_RUNNING -> System.currentTimeMillis() - cp.lastActiveAt > STALE_RUNNING_MS
                else -> false
            }
        } catch (_: Exception) {
            false
        }
    }

    // ------------------------------------------------------------------
    // File tracking + regression detection.
    // ------------------------------------------------------------------

    fun sha256Of(file: File): String? {
        return try {
            val digest = MessageDigest.getInstance("SHA-256")
            file.inputStream().use { stream ->
                val buffer = ByteArray(32 * 1024)
                while (true) {
                    val read = stream.read(buffer)
                    if (read <= 0) break
                    digest.update(buffer, 0, read)
                }
            }
            digest.digest().joinToString("") { "%02x".format(it) }
        } catch (_: Exception) {
            null
        }
    }

    fun trackedFiles(projectDir: File): List<File> {
        val out = mutableListOf<File>()
        try {
            val root = File(projectDir, "index.html")
            if (root.exists() && root.isFile) out.add(root)
            val src = File(projectDir, "src")
            if (src.exists() && src.isDirectory) {
                src.walkTopDown().filterTo(out) { it.isFile }
            }
        } catch (_: Exception) {
        }
        return out
    }

    fun relPath(projectDir: File, file: File): String {
        return try {
            file.relativeTo(projectDir).path.replace('\\', '/')
        } catch (_: Exception) {
            file.name
        }
    }

    fun snapshotHashes(projectDir: File): Map<String, String> {
        val map = mutableMapOf<String, String>()
        for (file in trackedFiles(projectDir)) {
            val hash = sha256Of(file) ?: continue
            map[relPath(projectDir, file)] = hash
        }
        return map
    }

    /** Files whose content changed (or vanished) compared to a previous snapshot. */
    fun detectChangedFiles(projectDir: File, oldHashes: Map<String, String>): List<String> {
        if (oldHashes.isEmpty()) return emptyList()
        val now = snapshotHashes(projectDir)
        return oldHashes.keys.filter { path -> oldHashes[path] != now[path] }
    }

    /**
     * Continue-forward rule: every tracked file the user's prompt does NOT mention is frozen.
     * Generation prompts are told to keep frozen files working and untouched.
     */
    fun frozenFilesFor(projectDir: File, prompt: String): Set<String> {
        val lower = prompt.lowercase()
        return trackedFiles(projectDir)
            .map { relPath(projectDir, it) }
            .filter { rel ->
                val base = rel.substringAfterLast('/').lowercase()
                val stem = base.substringBefore('.')
                val mentioned = lower.contains(base) || (stem.length >= 4 && lower.contains(stem)) ||
                    lower.contains("sab") || lower.contains("everything") ||
                    lower.contains("scratch") || lower.contains("reset") ||
                    lower.contains("poora") || lower.contains("redesign")
                !mentioned
            }
            .toSet()
    }

    // ------------------------------------------------------------------
    // Context helpers.
    // ------------------------------------------------------------------

    /**
     * Full project-chat transcript (newest last, capped) so a resumed session — even days
     * later — sees everything that was discussed and built before.
     */
    fun recentChatContext(context: Context, appName: String, maxChars: Int = 4000): String {
        return try {
            val messages = ProjectChatHistoryManager.getMessages(context, appName).takeLast(12)
            if (messages.isEmpty()) return ""
            buildString {
                appendLine("RECENT PROJECT CHAT (oldest first, do not contradict it):")
                for (message in messages) {
                    val who = if (message.sender == "user") "USER" else "SAIF"
                    appendLine("$who: ${message.content.take(600)}")
                }
            }.take(maxChars)
        } catch (_: Exception) {
            ""
        }
    }

    fun listProjectDirs(context: Context): List<File> {
        return try {
            File(context.filesDir, "projects").listFiles()
                ?.filter { it.isDirectory }
                ?: emptyList()
        } catch (_: Exception) {
            emptyList()
        }
    }

    // ------------------------------------------------------------------
    // JSON serialization.
    // ------------------------------------------------------------------

    fun toJson(cp: BuildCheckpoint): JSONObject {
        return JSONObject().apply {
            put("appName", cp.appName)
            put("status", cp.status)
            put("lastPhase", cp.lastPhase)
            put("promptHistory", JSONArray(cp.promptHistory))
            put("completedTaskIds", JSONArray(cp.completedTaskIds))
            val hashes = JSONObject()
            cp.fileHashes.forEach { (path, hash) -> hashes.put(path, hash) }
            put("fileHashes", hashes)
            put("passedProbes", JSONArray(cp.passedProbes))
            put("lastPassedCount", cp.lastPassedCount)
            put("lastTotalCount", cp.lastTotalCount)
            put("frozenFiles", JSONArray(cp.frozenFiles))
            put("lastScore", cp.lastScore)
            put("lastFindings", JSONArray(cp.lastFindings))
            put("autoRoundsUsed", cp.autoRoundsUsed)
            put("lastActiveAt", cp.lastActiveAt)
            if (cp.lastError != null) put("lastError", cp.lastError)
        }
    }

    fun fromJson(json: JSONObject, fallbackName: String): BuildCheckpoint {
        fun strList(key: String): List<String> {
            val arr = json.optJSONArray(key) ?: return emptyList()
            return (0 until arr.length()).mapNotNull { arr.optString(it).takeIf { s -> s.isNotEmpty() } }
        }
        val hashes = mutableMapOf<String, String>()
        val hashesObj = json.optJSONObject("fileHashes")
        if (hashesObj != null) {
            val keys = hashesObj.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                hashes[key] = hashesObj.optString(key)
            }
        }
        return BuildCheckpoint(
            appName = json.optString("appName", fallbackName),
            status = json.optString("status", STATUS_IDLE),
            lastPhase = json.optString("lastPhase", ""),
            promptHistory = strList("promptHistory"),
            completedTaskIds = strList("completedTaskIds"),
            fileHashes = hashes,
            passedProbes = strList("passedProbes"),
            lastPassedCount = json.optInt("lastPassedCount", 0),
            lastTotalCount = json.optInt("lastTotalCount", 0),
            frozenFiles = strList("frozenFiles"),
            lastScore = json.optInt("lastScore", 0),
            lastFindings = strList("lastFindings"),
            autoRoundsUsed = json.optInt("autoRoundsUsed", 0),
            lastActiveAt = json.optLong("lastActiveAt", 0L),
            lastError = json.optString("lastError", null)
        )
    }
}

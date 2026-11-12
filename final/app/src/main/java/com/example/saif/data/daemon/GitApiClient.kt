/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.daemon

import android.content.Context
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Thin wrapper over the `git` binary that ships with the device shell.
 *
 * Every call is best-effort: when git is missing or the working copy is not a repository the
 * function returns false instead of pretending the operation succeeded.
 */
object GitApiClient {

    data class GitStatusResult(
        val branch: String = "main",
        val hasChanges: Boolean = false,
        val modified: List<String> = emptyList()
    )

    private fun runGit(workingDir: File?, vararg args: String): Pair<Int, String> {
        return try {
            val builder = ProcessBuilder(listOf("git") + args.toList()).redirectErrorStream(true)
            workingDir?.let { if (it.isDirectory) builder.directory(it) }
            val process = builder.start()
            val output = process.inputStream.bufferedReader().readText()
            val finished = process.waitFor(20, TimeUnit.SECONDS)
            if (!finished) {
                process.destroyForcibly()
                return 124 to output
            }
            process.exitValue() to output
        } catch (error: Exception) {
            -1 to (error.localizedMessage ?: "git is not available")
        }
    }

    fun getStatus(context: Context, repoDir: File): GitStatusResult {
        val (code, out) = runGit(repoDir, "status", "--porcelain=v1", "--branch")
        if (code != 0) return GitStatusResult()
        val lines = out.lines().filter { it.isNotBlank() }
        val branch = lines.firstOrNull { it.startsWith("##") }
            ?.removePrefix("##")
            ?.trim()
            ?.substringBefore("...")
            ?.substringBefore(' ')
            .orEmpty()
            .ifBlank { "main" }
        val changed = lines.filterNot { it.startsWith("##") }.map { it.drop(3) }
        return GitStatusResult(branch = branch, hasChanges = changed.isNotEmpty(), modified = changed)
    }

    fun cloneRepo(context: Context, url: String, targetDir: File): Boolean {
        if (url.isBlank()) return false
        targetDir.parentFile?.mkdirs()
        val (code, _) = runGit(targetDir.parentFile, "clone", "--depth", "1", url, targetDir.absolutePath)
        return code == 0
    }

    /**
     * Writes git identity (and optionally pull/remote settings) either for the repository at
     * [projectPath] or, when [isGlobal] is set, for the current user's `~/.gitconfig`.
     */
    fun setConfig(
        projectPath: String,
        userName: String,
        userEmail: String,
        pullRebase: Boolean? = null,
        remoteUrl: String? = null,
        isGlobal: Boolean = true
    ): Boolean {
        val repoDir = File(projectPath).takeIf { it.isDirectory }
        val scope = if (isGlobal || repoDir == null) arrayOf("--global") else arrayOf()
        if (userName.isNotBlank()) {
            val (code, _) = runGit(repoDir, *(scope + arrayOf("config", "user.name", userName)))
            if (code != 0) return false
        }
        if (userEmail.isNotBlank()) {
            val (code, _) = runGit(repoDir, *(scope + arrayOf("config", "user.email", userEmail)))
            if (code != 0) return false
        }
        pullRebase?.let { rebase ->
            runGit(repoDir, *(scope + arrayOf("config", "pull.rebase", if (rebase) "true" else "false")))
        }
        remoteUrl?.takeIf { it.isNotBlank() }?.let { url ->
            if (repoDir != null) runGit(repoDir, "remote", "set-url", "origin", url)
        }
        return true
    }
}

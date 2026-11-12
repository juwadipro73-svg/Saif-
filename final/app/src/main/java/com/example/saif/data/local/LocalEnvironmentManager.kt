/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.local

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit

/**
 * Progress of the workspace tooling. This build ships no downloaded root filesystem, so the
 * observable sequence is short: [Success] (or [Error]) right away. The richer variants are kept
 * because the terminal settings screen renders them when a provider does need a download.
 */
sealed class LocalInstallerState {
    abstract val progressFraction: Float

    data class Downloading(
        val progress: Float = 0f,
        val bytesDownloaded: Long = 0L,
        val totalBytes: Long = 0L,
        val currentPackageName: String = "",
        val speedText: String = ""
    ) : LocalInstallerState() {
        override val progressFraction: Float get() = progress
    }

    data class Extracting(
        val progress: Float = 0f,
        val extractedFilesCount: Int = 0
    ) : LocalInstallerState() {
        override val progressFraction: Float get() = progress
    }

    data class Configuring(val step: String = "Configuring tools") : LocalInstallerState() {
        override val progressFraction: Float get() = 0.9f
        val stepDescription: String get() = step
    }

    data class Verifying(val check: String = "shell") : LocalInstallerState() {
        override val progressFraction: Float get() = 0.95f
        val testName: String get() = check
    }

    data object Success : LocalInstallerState() {
        override val progressFraction: Float get() = 1f
    }

    data class Error(val message: String) : LocalInstallerState() {
        override val progressFraction: Float get() = 0f
        val errorMessage: String get() = message
    }
}

/** Result of one workspace command. */
data class WorkspaceCommandResult(val output: String, val exitCode: Int)

/**
 * The workspace shell.
 *
 * SAIF AI does not ship a Linux root filesystem any more, so commands run in the Android
 * app sandbox through `/system/bin/sh` (toybox). That covers file inspection, grep, git
 * plumbing and small scripts; anything that needs a real distribution is reported as
 * unsupported instead of pretending to work.
 */
object LocalEnvironmentManager {

    private val _installerState = MutableStateFlow<LocalInstallerState>(LocalInstallerState.Success)
    val installerState: StateFlow<LocalInstallerState> = _installerState.asStateFlow()

    fun workspaceDir(context: Context): File =
        File(context.filesDir, "workspace").apply { mkdirs() }

    fun uploadsDir(context: Context): File =
        File(context.filesDir, "uploads").apply { mkdirs() }

    fun isInstalled(context: Context): Boolean = workspaceDir(context).isDirectory

    /** No bundled Linux rootfs in this build. */
    fun isUbuntuInstalled(@Suppress("UNUSED_PARAMETER") context: Context): Boolean = false

    fun hasVerifiedEnvironment(context: Context): Boolean = isInstalled(context)

    fun isTermuxPackage(@Suppress("UNUSED_PARAMETER") context: Context): Boolean = false

    fun getBinDir(context: Context): File =
        File(context.filesDir, "bin").apply { mkdirs() }

    /** Nothing to download: the shell is part of Android. */
    fun ensureInstalledInBackground(context: Context) {
        _installerState.value = LocalInstallerState.Success
        workspaceDir(context)
        uploadsDir(context)
    }

    fun retryBackgroundInstall(context: Context) = ensureInstalledInBackground(context)

    fun cancelBackgroundInstall(@Suppress("UNUSED_PARAMETER") context: Context) {
        _installerState.value = LocalInstallerState.Error("Install cancelled")
    }

    fun ensureGlibcEnvironment(@Suppress("UNUSED_PARAMETER") context: Context) = Unit

    fun ensureClaudeWrapper(@Suppress("UNUSED_PARAMETER") context: Context) = Unit

    /** Synchronous helper kept for call sites that already run off the main thread. */
    fun executeCommand(context: Context, command: String): String =
        runCommandBlocking(context, command, 60L, null).output

    /**
     * Runs [command] in the workspace directory and streams each output line to [onOutputLine].
     * `/root/workspace` and `/root/uploads` are rewritten to the app's real directories so the
     * same prompts work on a device without a Linux install.
     */
    suspend fun executeCommand(
        command: String,
        context: Context,
        timeoutSeconds: Long = 180L,
        onOutputLine: ((String) -> Unit)? = null
    ): WorkspaceCommandResult = withContext(Dispatchers.IO) {
        runCommandBlocking(context, command, timeoutSeconds, onOutputLine)
    }

    private fun runCommandBlocking(
        context: Context,
        command: String,
        timeoutSeconds: Long,
        onOutputLine: ((String) -> Unit)?
    ): WorkspaceCommandResult {
        val workspace = workspaceDir(context)
        val uploads = uploadsDir(context)
        val rewritten = command
            .replace("/root/workspace", workspace.absolutePath)
            .replace("/root/uploads", uploads.absolutePath)
            .replace(Regex("(?<![\\w/])~/"), workspace.absolutePath + "/")
        val output = StringBuilder()
        return try {
            val process = ProcessBuilder("/system/bin/sh", "-c", rewritten)
                .directory(workspace)
                .redirectErrorStream(true)
                .apply {
                    environment()["HOME"] = workspace.absolutePath
                    environment()["PATH"] = "/system/bin:/system/xbin"
                }
                .start()
            BufferedReader(InputStreamReader(process.inputStream)).use { reader ->
                val deadline = System.currentTimeMillis() + timeoutSeconds * 1000
                while (true) {
                    val line = reader.readLine() ?: break
                    output.appendLine(line)
                    onOutputLine?.invoke(line)
                    if (System.currentTimeMillis() > deadline) {
                        process.destroyForcibly()
                        output.appendLine("[timed out after ${timeoutSeconds}s]")
                        return WorkspaceCommandResult(output.toString(), 124)
                    }
                }
            }
            val finished = process.waitFor(timeoutSeconds, TimeUnit.SECONDS)
            if (!finished) {
                process.destroyForcibly()
                return WorkspaceCommandResult(output.appendLine("[timed out]").toString(), 124)
            }
            WorkspaceCommandResult(output.toString(), process.exitValue())
        } catch (error: Exception) {
            WorkspaceCommandResult("Command failed: ${error.localizedMessage}", 127)
        }
    }
}

object AuthenticatedWorkspace {
    fun ensureStarted(context: Context) {
        LocalEnvironmentManager.ensureInstalledInBackground(context)
    }

    /** Nothing is signed in to the workspace: the local shell has no account. */
    fun onSignedOut() = Unit
}

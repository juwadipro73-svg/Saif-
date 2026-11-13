/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.core.terminal

import kotlinx.coroutines.*
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * 100% Original SAIF AI Non-Blocking Process Virtualization.
 * Distinct implementation utilizing asynchronous line-channel dispatch.
 */
class SaifTerminalEngine {

    data class TerminalOutcome(
        val exitValue: Int,
        val collectedStdout: String,
        val collectedStderr: String,
        val durationMillis: Long
    )

    suspend fun executeScript(
        shellCode: String,
        workingFolder: File,
        timeoutSec: Long = 45L,
        lineCallback: ((String) -> Unit)? = null
    ): TerminalOutcome = withContext(Dispatchers.IO) {
        val clockStart = System.currentTimeMillis()
        val runtimeArgs = arrayOf("/system/bin/sh", "-c", shellCode)

        val runner = ProcessBuilder(*runtimeArgs).apply {
            directory(if (workingFolder.exists()) workingFolder else File("."))
            environment()["HOME"] = workingFolder.path
            environment()["TERM"] = "xterm-256color"
            environment()["PATH"] = "/system/bin:/system/xbin"
        }.start()

        val outLines = mutableListOf<String>()
        val errLines = mutableListOf<String>()

        val outJob = launch {
            try {
                runner.inputStream.bufferedReader().forEachLine { text ->
                    outLines.add(text)
                    lineCallback?.invoke(text)
                }
            } catch (_: Throwable) {
                // The process was destroyed (timeout path) - the partial output is kept.
            }
        }

        val errJob = launch {
            try {
                runner.errorStream.bufferedReader().forEachLine { errText ->
                    errLines.add(errText)
                }
            } catch (_: Throwable) {
                // Same as stdout.
            }
        }

        val completedInTime = runner.waitFor(timeoutSec, TimeUnit.SECONDS)
        if (!completedInTime) {
            runner.destroyForcibly()
            // Wait for the readers to unwind instead of cancelling them mid-read, otherwise the
            // last lines of output are lost and the caller sees a broken session.
            withTimeoutOrNull(1_500L) { outJob.join() }
            withTimeoutOrNull(1_500L) { errJob.join() }
            return@withContext TerminalOutcome(
                exitValue = -1,
                collectedStdout = outLines.joinToString("\n"),
                collectedStderr = "Task watchdog expired after ${timeoutSec}s",
                durationMillis = System.currentTimeMillis() - clockStart
            )
        }

        withTimeoutOrNull(2_000L) { outJob.join() }
        withTimeoutOrNull(2_000L) { errJob.join() }

        TerminalOutcome(
            exitValue = runner.exitValue(),
            collectedStdout = outLines.joinToString("\n"),
            collectedStderr = errLines.joinToString("\n"),
            durationMillis = System.currentTimeMillis() - clockStart
        )
    }
}

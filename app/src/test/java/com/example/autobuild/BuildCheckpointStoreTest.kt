package com.example.autobuild

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File
import java.nio.file.Files

/**
 * Checkpoint persistence tests. Robolectric (not plain JVM) because the store
 * uses org.json, which is an Android stub on local unit tests.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class BuildCheckpointStoreTest {

    private fun tempProjectDir(): File {
        val dir = Files.createTempDirectory("autobuild-test").toFile()
        File(dir, "index.html").writeText("<html><body>hello</body></html>")
        File(dir, "src").mkdirs()
        File(dir, "src/app.js").writeText("console.log(1)")
        return dir
    }

    @Test
    fun `save and load round-trips the checkpoint`() {
        val dir = tempProjectDir()
        val cp = BuildCheckpoint(
            appName = "DemoApp",
            status = BuildCheckpointStore.STATUS_NEEDS_CONTINUE,
            lastPhase = "S5_SANDBOX",
            promptHistory = listOf("game banao", "aur accha karo"),
            completedTaskIds = listOf("task_1_tokens"),
            plannedTaskIds = listOf("task_1_tokens", "task_2_state"),
            planSignature = "deadbeef12345678",
            fileHashes = mapOf("index.html" to "abc123"),
            passedProbes = listOf("#app-root"),
            lastPassedCount = 12,
            lastTotalCount = 15,
            frozenFiles = listOf("src/app.js"),
            lastScore = 74,
            lastFindings = listOf("Add more features"),
            autoRoundsUsed = 2,
            lastActiveAt = 123456789L,
            lastError = null
        )
        BuildCheckpointStore.save(dir, cp)
        val loaded = BuildCheckpointStore.load(dir)
        assertEquals(cp, loaded)
    }

    @Test
    fun `pending work detection covers continue failed and stale running`() {
        val dir = tempProjectDir()
        BuildCheckpointStore.save(dir, BuildCheckpointStore.default("A"))
        assertFalse(BuildCheckpointStore.hasPendingWork(dir))

        BuildCheckpointStore.update(dir) { it.copy(status = BuildCheckpointStore.STATUS_NEEDS_CONTINUE) }
        assertTrue(BuildCheckpointStore.hasPendingWork(dir))

        BuildCheckpointStore.update(dir) { it.copy(status = BuildCheckpointStore.STATUS_FAILED) }
        assertTrue(BuildCheckpointStore.hasPendingWork(dir))

        BuildCheckpointStore.update(dir) {
            it.copy(status = BuildCheckpointStore.STATUS_RUNNING, lastActiveAt = System.currentTimeMillis() - 60 * 60 * 1000L)
        }
        assertTrue(BuildCheckpointStore.hasPendingWork(dir))

        BuildCheckpointStore.update(dir) {
            it.copy(status = BuildCheckpointStore.STATUS_RUNNING, lastActiveAt = System.currentTimeMillis())
        }
        assertFalse(BuildCheckpointStore.hasPendingWork(dir))

        BuildCheckpointStore.update(dir) { it.copy(status = BuildCheckpointStore.STATUS_DONE) }
        assertFalse(BuildCheckpointStore.hasPendingWork(dir))
    }

    @Test
    fun `frozen files exclude whatever the prompt mentions`() {
        val dir = tempProjectDir()
        val frozen = BuildCheckpointStore.frozenFilesFor(dir, "game me naya level jodo")
        assertTrue(frozen.contains("index.html"))
        assertTrue(frozen.contains("src/app.js"))

        val mentioned = BuildCheckpointStore.frozenFilesFor(dir, "src/app.js me sound fix karo")
        assertFalse(mentioned.contains("src/app.js"))
        assertTrue(mentioned.contains("index.html"))
    }

    @Test
    fun `hash snapshot detects changed files`() {
        val dir = tempProjectDir()
        val before = BuildCheckpointStore.snapshotHashes(dir)
        assertEquals(2, before.size)
        assertTrue(BuildCheckpointStore.detectChangedFiles(dir, before).isEmpty())

        File(dir, "src/app.js").writeText("console.log(2)")
        val changed = BuildCheckpointStore.detectChangedFiles(dir, before)
        assertEquals(listOf("src/app.js"), changed)
    }

    @Test
    fun `prompt history appends and caps`() {
        val dir = tempProjectDir()
        repeat(35) { BuildCheckpointStore.appendPrompt(dir, "CapApp", "prompt $it") }
        val loaded = BuildCheckpointStore.load(dir)
        assertEquals("CapApp", loaded.appName)
        assertEquals(30, loaded.promptHistory.size)
        assertEquals("prompt 34", loaded.promptHistory.last())
    }
}

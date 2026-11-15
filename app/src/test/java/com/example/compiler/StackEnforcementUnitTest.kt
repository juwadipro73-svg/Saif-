package com.example.compiler

import com.example.autobuild.AutoIconForge
import com.example.autobuild.IdeaExpander
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

/**
 * Plain JVM tests for chat stack enforcement ("bola native, banaya HTML" must be
 * impossible) and for the auto-icon category plumbing.
 */
class StackEnforcementUnitTest {

    @get:Rule
    val tmp = TemporaryFolder()

    private fun write(dir: File, rel: String, body: String = "x") {
        val f = File(dir, rel)
        f.parentFile?.mkdirs()
        f.writeText(body)
    }

    // ------------------------------------------------------------------
    // Tree inspection
    // ------------------------------------------------------------------

    @Test
    fun `native tree is recognized`() {
        val dir = tmp.newFolder("treeNative")
        write(dir, "app/src/main/AndroidManifest.xml", "<manifest/>")
        write(dir, "app/src/main/java/com/x/MainActivity.java", "class MainActivity {}")
        val st = LinuxApkBuildBridge.inspectStackTree(dir)
        assertTrue(st.hasManifest)
        assertEquals(1, st.javaCount)
        assertFalse(st.hasHtmlEntry)
        assertFalse(st.hasPubspec)
    }

    @Test
    fun `html tree is recognized`() {
        val dir = tmp.newFolder("treeHtml")
        write(dir, "index.html", "<html></html>")
        val st = LinuxApkBuildBridge.inspectStackTree(dir)
        assertTrue(st.hasHtmlEntry)
        assertFalse(st.hasManifest)
        assertEquals(0, st.javaCount)
    }

    @Test
    fun `flutter tree is recognized`() {
        val dir = tmp.newFolder("treeFlutter")
        write(dir, "pubspec.yaml", "name: demo")
        write(dir, "lib/main.dart", "void main() {}")
        val st = LinuxApkBuildBridge.inspectStackTree(dir)
        assertTrue(st.hasPubspec)
        assertTrue(st.hasMainDart)
    }

    // ------------------------------------------------------------------
    // Mismatch verdicts
    // ------------------------------------------------------------------

    @Test
    fun `native request with html-only tree is rejected with guidance`() {
        val st = LinuxApkBuildBridge.StackTreeStatus(
            hasManifest = false, javaCount = 0, hasHtmlEntry = true,
            hasPubspec = false, hasMainDart = false
        )
        val err = LinuxApkBuildBridge.stackMismatchError("NATIVE", st)
        assertTrue("expected STACK_MISMATCH, got: $err", err != null && err.startsWith("STACK_MISMATCH"))
        assertTrue(err!!.contains("HTML"))
        assertTrue(err.contains("AndroidManifest.xml"))
    }

    @Test
    fun `native request with native tree passes`() {
        val st = LinuxApkBuildBridge.StackTreeStatus(
            hasManifest = true, javaCount = 3, hasHtmlEntry = false,
            hasPubspec = false, hasMainDart = false
        )
        assertNull(LinuxApkBuildBridge.stackMismatchError("NATIVE", st))
        assertNull(LinuxApkBuildBridge.stackMismatchError("native", st))
    }

    @Test
    fun `flutter request without dart project is rejected`() {
        val st = LinuxApkBuildBridge.StackTreeStatus(
            hasManifest = false, javaCount = 0, hasHtmlEntry = true,
            hasPubspec = false, hasMainDart = false
        )
        val err = LinuxApkBuildBridge.stackMismatchError("FLUTTER", st)
        assertTrue("expected STACK_MISMATCH, got: $err", err != null && err.startsWith("STACK_MISMATCH"))
        assertTrue(err!!.contains("pubspec.yaml"))
    }

    @Test
    fun `flutter request with dart project passes`() {
        val st = LinuxApkBuildBridge.StackTreeStatus(
            hasManifest = false, javaCount = 0, hasHtmlEntry = false,
            hasPubspec = true, hasMainDart = true
        )
        assertNull(LinuxApkBuildBridge.stackMismatchError("FLUTTER", st))
    }

    @Test
    fun `html and blank requests never mismatch`() {
        val st = LinuxApkBuildBridge.StackTreeStatus(
            hasManifest = false, javaCount = 0, hasHtmlEntry = true,
            hasPubspec = false, hasMainDart = false
        )
        assertNull(LinuxApkBuildBridge.stackMismatchError("HTML", st))
        assertNull(LinuxApkBuildBridge.stackMismatchError("", st))
    }

    // ------------------------------------------------------------------
    // Auto-icon plumbing
    // ------------------------------------------------------------------

    @Test
    fun `category detection matches app kinds`() {
        assertEquals("music", IdeaExpander.detectCategory("Gaana music player with songs"))
        assertEquals("game", IdeaExpander.detectCategory("car racing game 3d"))
        assertEquals("chat", IdeaExpander.detectCategory("chat messenger friends talk"))
        assertEquals("finance", IdeaExpander.detectCategory("expense budget money tracker"))
        assertEquals("food", IdeaExpander.detectCategory("pizza recipe food delivery"))
    }

    @Test
    fun `ai icon prompt bans text and names the glyph`() {
        val prompt = AutoIconForge.aiIconPrompt("Gaana", "music")
        assertTrue(prompt.contains("Gaana"))
        assertTrue(prompt.contains("musical note"))
        assertTrue(prompt.contains("no text"))
    }
}

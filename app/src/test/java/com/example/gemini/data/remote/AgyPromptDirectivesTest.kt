package com.example.gemini.data.remote

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/** Directives that travel with every Antigravity (hub) turn. */
class AgyPromptDirectivesTest {

    @Test
    fun `blank input is returned untouched`() {
        assertEquals("  ", AgyPromptDirectives.compile("  "))
    }

    @Test
    fun `rules and the user text are both present`() {
        val out = AgyPromptDirectives.compile("add a dark mode toggle")
        assertTrue(out.contains(AgyPromptDirectives.EDIT_RULE))
        assertTrue(out.contains(AgyPromptDirectives.FINISH_RULE))
        assertTrue(out.contains(AgyPromptDirectives.DOWNLOAD_RULE))
        assertTrue(out.trimEnd().endsWith("add a dark mode toggle"))
    }

    @Test
    fun `the small-edit rule exists so tiny changes stay fast`() {
        assertTrue(AgyPromptDirectives.EDIT_RULE.contains("small change"))
        assertTrue(AgyPromptDirectives.EDIT_RULE.contains("Never rebuild"))
    }

    @Test
    fun `native asks are pinned to a native tree`() {
        val out = AgyPromptDirectives.compile("native android app banao with login")
        assertTrue(out.lowercase().contains("native"))
        assertTrue(out.contains("AndroidManifest.xml"))
        assertFalse(out.contains("HTML/WebView wrapper") && out.contains("STACK: this request is a FLUTTER"))
    }

    @Test
    fun `flutter asks are pinned to a dart project`() {
        val out = AgyPromptDirectives.compile("make a flutter app for notes")
        assertTrue(out.contains("FLUTTER"))
        assertTrue(out.contains("pubspec.yaml"))
    }

    @Test
    fun `plain chat carries no stack pin`() {
        assertNull(AgyPromptDirectives.stackRule("what is the capital of India?"))
        val out = AgyPromptDirectives.compile("hello there")
        assertFalse(out.contains("STACK:"))
        assertNotNull(out)
    }
}

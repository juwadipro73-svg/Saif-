package com.example.builder.agent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The user's format rules: whatever they name wins (ZIP / APK / website / video / document),
 * and when they name nothing the default is an APK for an app, a Chrome link for a site and an
 * MP4 link for a video.
 */
class DeliverableFormatTest {

    // ---------------- explicit asks ----------------

    @Test
    fun `zip and source asks resolve to ZIP`() {
        assertEquals(DeliverableFormat.ZIP, DeliverableFormat.detect("project ka zip do"))
        assertEquals(DeliverableFormat.ZIP, DeliverableFormat.detect("mujhe source code chahiye"))
        assertEquals(DeliverableFormat.ZIP, DeliverableFormat.detect("give me the source files of my app"))
        assertEquals(DeliverableFormat.ZIP, DeliverableFormat.resolve("app banao aur zip bhi de do"))
    }

    @Test
    fun `apk ask resolves to APK`() {
        assertEquals(DeliverableFormat.APK, DeliverableFormat.detect("installable apk do"))
        assertEquals(DeliverableFormat.APK, DeliverableFormat.resolve("todo app banao, apk chahiye"))
    }

    @Test
    fun `website asks resolve to WEBSITE`() {
        assertEquals(DeliverableFormat.WEBSITE, DeliverableFormat.detect("website banao"))
        assertEquals(DeliverableFormat.WEBSITE, DeliverableFormat.detect("landing page banao"))
        assertEquals(DeliverableFormat.WEBSITE, DeliverableFormat.resolve("ek site banao jo chrome me khule"))
    }

    @Test
    fun `video, document, image and audio asks are honored`() {
        assertEquals(DeliverableFormat.VIDEO, DeliverableFormat.detect("make a video of the sunset"))
        assertEquals(DeliverableFormat.VIDEO, DeliverableFormat.detect("mp4 bana do"))
        assertEquals(DeliverableFormat.DOCUMENT, DeliverableFormat.detect("pdf report banao"))
        assertEquals(DeliverableFormat.IMAGE, DeliverableFormat.detect("poster png me chahiye"))
        assertEquals(DeliverableFormat.AUDIO, DeliverableFormat.detect("mp3 voiceover banao"))
    }

    @Test
    fun `zip beats apk when both are named`() {
        assertEquals(DeliverableFormat.ZIP, DeliverableFormat.detect("apk nahi, zip of the source code"))
    }

    // ---------------- defaults ----------------

    @Test
    fun `app request without a format defaults to APK`() {
        assertNull(DeliverableFormat.detect("make a todo app"))
        assertEquals(DeliverableFormat.APK, DeliverableFormat.resolve("make a todo app"))
        assertEquals(DeliverableFormat.APK, DeliverableFormat.resolve("native android app banao"))
        assertEquals(DeliverableFormat.APK, DeliverableFormat.resolve("flutter notes app banao"))
    }

    @Test
    fun `website request without an explicit format still becomes a live link`() {
        assertEquals(DeliverableFormat.WEBSITE, DeliverableFormat.resolve("make a portfolio website"))
    }

    // ---------------- rules ----------------

    @Test
    fun `casual chat gets no format rule`() {
        assertFalse(DeliverableFormat.isBuildRequest("what is kotlin?"))
        assertEquals("", DeliverableFormat.ruleFor("hello, how are you"))
    }

    @Test
    fun `app build rule asks for an apk download link`() {
        val rule = DeliverableFormat.ruleFor("make a todo app")
        assertTrue(rule.contains("APK"))
        assertTrue(rule.contains("⬇️ **Download link:**"))
    }

    @Test
    fun `zip rule forbids substituting an apk`() {
        val rule = DeliverableFormat.ruleFor("project ka zip do")
        assertTrue(rule.contains(".zip"))
        assertTrue(rule.contains("Do not substitute an APK"))
    }

    @Test
    fun `website rule asks for a chrome live link`() {
        val rule = DeliverableFormat.ruleFor("website banao")
        assertTrue(rule.contains("Chrome"))
        assertTrue(rule.contains("saif-web-link"))
        assertTrue(rule.contains("🌐 **Live link:**"))
    }

    @Test
    fun `video rule asks for an mp4 link`() {
        val rule = DeliverableFormat.ruleFor("make a promo video")
        assertTrue(rule.contains(".mp4"))
        assertTrue(rule.contains("Download link"))
    }

    @Test
    fun `defaults rule states every fallback`() {
        val defaults = DeliverableFormat.DEFAULTS_RULE
        assertTrue(defaults.contains("APK"))
        assertTrue(defaults.contains("Chrome"))
        assertTrue(defaults.contains("mp4"))
        assertTrue(defaults.contains("wins over these defaults"))
    }
}

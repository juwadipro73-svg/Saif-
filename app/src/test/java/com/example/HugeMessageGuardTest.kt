package com.example

import com.example.util.HugeMessageGuard
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** Locks the "chat must not die at link-time" guarantees (request: link-time crash). */
class HugeMessageGuardTest {

    @Test
    fun smallMessagesPassThroughUntouched() {
        val msg = "hello\n\n⬇️ **Download link:** [app.apk](https://x/y.apk)"
        assertEquals(msg, HugeMessageGuard.sanitize(msg))
    }

    @Test
    fun giantMessagesGetCappedButKeepHeadAndTail() {
        val huge = "FIRST-LINE-KEEP\n" + "x".repeat(1_000_000) + "\nLAST-LINE-KEEP"
        val out = HugeMessageGuard.sanitize(huge)
        assertTrue(out.length < 400_000)
        assertTrue(out.startsWith("FIRST-LINE-KEEP"))
        assertTrue(out.endsWith("LAST-LINE-KEEP"))
        assertTrue(out.contains("hidden to keep the chat responsive"))
    }

    @Test
    fun downloadLinksSurviveEvenWhenTheySitInTheMiddle() {
        val mid = "\n⬇️ **Download link:** [Download MyApp APK](https://example.com/my.apk)\n"
        val huge = "start\n" + "y".repeat(500_000) + mid + "z".repeat(500_000) + "\nend"
        val out = HugeMessageGuard.sanitize(huge)
        assertTrue("middle link must be rescued: ${out.takeLast(400)}", out.contains("https://example.com/my.apk"))
    }

    @Test
    fun storageCapIsLargerThanDisplayCap() {
        assertTrue(HugeMessageGuard.MAX_STORED_CHARS > HugeMessageGuard.MAX_DISPLAY_CHARS)
        assertFalse(HugeMessageGuard.isTooHeavyToHighlight(1_000))
        assertTrue(HugeMessageGuard.isTooHeavyToHighlight(200_000))
    }
}

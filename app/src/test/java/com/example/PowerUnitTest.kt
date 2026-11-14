package com.example

import com.example.agyext.AntigravityCustomApiAgentEngine
import com.example.compiler.OnDeviceApkBuildManager
import com.example.gemini.domain.model.bindingQuotaFraction
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the power upgrade: tolerant build-marker parsing (no raw code dumps
 * in chat), format-on-demand routing, live quota math and the raised output budget.
 */
class PowerUnitTest {

    // --- Tolerant <saif-apk> parsing ---

    @Test
    fun closedMarkerParses() {
        val block = OnDeviceApkBuildManager.extractSaifApkBlock(
            "Here it is:\n<saif-apk name=\"Calc\"><html>x</html></saif-apk>\nDone"
        )
        assertNotNull(block)
        assertTrue(block!!.first.contains("</saif-apk>"))
        assertTrue(block.second.contains("name=\"Calc\""))
        assertEquals("<html>x</html>", block.third)
    }

    @Test
    fun unclosedMarkerTakesRestOfReply() {
        val block = OnDeviceApkBuildManager.extractSaifApkBlock(
            "Building...\n<saif-apk name=\"Big App\"><html><body>half-written"
        )
        assertNotNull(block)
        assertTrue(block!!.second.contains("Big App"))
        assertTrue(block.third.contains("half-written"))
        // Removing the tag must remove the whole code dump from the visible reply.
        assertEquals("Building...", "Building...\n<saif-apk name=\"Big App\"><html><body>half-written".replace(block.first, "").trim())
    }

    @Test
    fun missingMarkerReturnsNull() {
        assertNull(OnDeviceApkBuildManager.extractSaifApkBlock("Just a plain chat answer."))
        assertNull(OnDeviceApkBuildManager.extractSaifApkBlock(""))
        val empty = OnDeviceApkBuildManager.extractSaifApkBlock("<saif-apk name=\"Empty\"></saif-apk>")
        assertNotNull(empty)
        assertTrue(empty!!.third.isBlank())
    }

    // --- Format-on-demand routing ---

    @Test
    fun explicitFormatAttrWins() {
        assertEquals("zip", OnDeviceApkBuildManager.resolveBuildFormat("build me an app", "<saif-apk name=\"A\" format=\"zip\""))
        assertEquals("html", OnDeviceApkBuildManager.resolveBuildFormat("build me an app", "<saif-apk format=\"html\" name=\"A\""))
        assertEquals("apk", OnDeviceApkBuildManager.resolveBuildFormat("give zip", "<saif-apk name=\"A\" format=\"apk\""))
    }

    @Test
    fun userWordsDecideWithoutAttr() {
        assertEquals("zip", OnDeviceApkBuildManager.resolveBuildFormat("send me the zip file", "<saif-apk name=\"A\""))
        assertEquals("html", OnDeviceApkBuildManager.resolveBuildFormat("give me the html file", "<saif-apk name=\"A\""))
        assertEquals("apk", OnDeviceApkBuildManager.resolveBuildFormat("build me an app", "<saif-apk name=\"A\""))
    }

    // --- Live quota math ---

    @Test
    fun bindingQuotaIsTheMinimum() {
        assertEquals(0.2f, bindingQuotaFraction(0.8f, 0.2f))
        assertEquals(0.8f, bindingQuotaFraction(0.8f, null))
        assertEquals(0.3f, bindingQuotaFraction(null, 0.3f))
        assertNull(bindingQuotaFraction(null, null))
    }

    // --- Raised budgets (compile-time constants) ---

    @Test
    fun outputBudgetIsHighDetail() {
        assertTrue(AntigravityCustomApiAgentEngine.OUTPUT_MAX_TOKENS >= 16384)
    }

    @Test
    fun buildRuleBansCodeDumpsAndTeachesFormats() {
        val rule = OnDeviceApkBuildManager.CHAT_APK_BUILD_RULE
        assertTrue(rule.contains("NEVER paste", ignoreCase = true))
        assertTrue(rule.contains("format=\"zip\"", ignoreCase = true))
        assertTrue(rule.contains("<saif-apk", ignoreCase = true))
    }
}

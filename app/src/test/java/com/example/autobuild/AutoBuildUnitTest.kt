package com.example.autobuild

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the Advance Auto-Builder's pure logic (no Android APIs).
 */
class AutoBuildUnitTest {

    private fun richHtml(): String = buildString {
        append("<!DOCTYPE html><html><head>")
        append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">")
        append("<style>@keyframes fade{from{opacity:0}to{opacity:1}}.x{animation:fade 1s;transition:all .3s}</style>")
        append("</head><body>")
        repeat(8) { append("<button id=\"b$it\">Action $it</button>") }
        append("<script>localStorage.setItem('k','v');</script>")
        append("<div>" + "lorem ipsum dolor sit amet ".repeat(3000) + "</div>")
        append("</body></html>")
    }.also { check(it.length > 70 * 1024) { "fixture must exceed 60KB" } }

    @Test
    fun `perfect build scores S grade without improvement`() {
        val audit = DeepQualityAudit.audit(
            specFeatures = 12,
            screens = 5,
            html = richHtml(),
            passedCount = 20,
            totalCount = 20,
            jsErrors = emptyList(),
            failedProbes = emptyList(),
            blankScreen = false,
            horizontalOverflow = false,
            smallTapTargets = 0
        )
        assertTrue(audit.score >= 95)
        assertEquals("S", audit.grade)
        assertTrue(audit.mustFix.isEmpty())
        assertFalse(audit.needsImprovement())
    }

    @Test
    fun `blank screen forces critical fix and low score`() {
        val audit = DeepQualityAudit.audit(
            specFeatures = 12,
            screens = 4,
            html = richHtml(),
            passedCount = 10,
            totalCount = 20,
            jsErrors = listOf("JS Error: boom at line 3"),
            failedProbes = listOf("#missing"),
            blankScreen = true,
            horizontalOverflow = false,
            smallTapTargets = 0
        )
        assertTrue(audit.needsImprovement())
        assertTrue(audit.mustFix.any { it.contains("blank", ignoreCase = true) })
        assertTrue(audit.mustFix.any { it.contains("boom") })
        assertTrue(audit.score < 65)
    }

    @Test
    fun `thin app is pushed to expand features`() {
        val audit = DeepQualityAudit.audit(
            specFeatures = 2,
            screens = 1,
            html = "<html><head></head><body><button>Hi</button></body></html>",
            passedCount = 5,
            totalCount = 10,
            jsErrors = emptyList(),
            failedProbes = emptyList(),
            blankScreen = false,
            horizontalOverflow = false,
            smallTapTargets = 0
        )
        assertTrue(audit.score < DeepQualityAudit.TARGET_SCORE)
        assertTrue(audit.needsImprovement())
        assertTrue(audit.mustFix.any { it.contains("thin", ignoreCase = true) || it.contains("features") })
    }

    @Test
    fun `improvement prompt enforces continue-forward rules`() {
        val audit = DeepQualityAudit.audit(
            specFeatures = 3, screens = 2, html = "<html><body>x</body></html>",
            passedCount = 4, totalCount = 10, jsErrors = listOf("e1"),
            failedProbes = emptyList(), blankScreen = false,
            horizontalOverflow = false, smallTapTargets = 0
        )
        val prompt = DeepQualityAudit.improvementPrompt(audit)
        assertTrue(prompt.contains("Keep EVERY existing feature working"))
        assertTrue(prompt.contains("zero console errors"))
        assertTrue(prompt.contains("e1"))
    }

    @Test
    fun `category detection matches Hinglish prompts`() {
        assertEquals("game", IdeaExpander.detectCategory("cricket game banao"))
        assertEquals("music", IdeaExpander.detectCategory("gana sunne wala app"))
        assertEquals("finance", IdeaExpander.detectCategory("kharcha hisaab budget"))
        assertEquals("study", IdeaExpander.detectCategory("exam padhai notes"))
        assertEquals("app", IdeaExpander.detectCategory("xyz random thing"))
    }

    @Test
    fun `advance packs are never empty`() {
        assertTrue(IdeaExpander.advancePackFor("game").size >= 5)
        assertTrue(IdeaExpander.advancePackFor("unknown-category").size >= 5)
        assertTrue(IdeaExpander.universalAdvancePack().size >= 5)
    }

    @Test
    fun `heuristic brief guarantees rich offline spec`() {
        val brief = IdeaExpander.heuristicBrief("TestApp", "game banao")
        assertTrue(brief.mustFeatures.size >= 10)
        assertTrue(brief.wowFeatures.size >= 3)
        assertTrue(brief.screens.size >= 4)
        val guidance = IdeaExpander.toGuidance(brief)
        assertTrue(guidance.contains("MUST features"))
        assertTrue(guidance.contains("AMBITION RULE"))
    }
}

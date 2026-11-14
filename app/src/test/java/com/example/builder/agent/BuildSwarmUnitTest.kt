package com.example.builder.agent

import com.example.autobuild.BuildCheckpointStore
import com.example.builder.safety.HtmlGuard
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the build swarm: unlimited project size, dynamic task fan-out,
 * delta plans (resume instead of scratch rebuilds) and truncation detection.
 */
class BuildSwarmUnitTest {

    private fun richSpec(): AppSpec = AppSpec(
        appName = "BigApp",
        vision = "A big high-end app",
        archetype = "app",
        targetUser = "Mobile User",
        features = (1..12).map { i ->
            FeatureSpec(id = "feat_$i", title = "Feature $i", priority = "MUST", acceptance = "works", domProbes = listOf("#f$i"))
        },
        screens = listOf("home", "game", "stats", "settings", "profile"),
        dataModel = "SaifStore",
        designSystem = DesignTokens("dark", "#8B5CF6", "#38BDF8", "#0A0D14", "#131826", "#F1F5F9"),
        animationList = emptyList()
    )

    // ------------------------------------------------------------------
    // No size limit
    // ------------------------------------------------------------------

    @Test
    fun `multi megabyte documents pass the size guard`() {
        val big = buildString {
            append("<!DOCTYPE html><html><head><meta name=\"viewport\" content=\"width=device-width\"></head><body><div>")
            append("x".repeat(3 * 1024 * 1024))
            append("</div><script>try{localStorage.setItem('k','v')}catch(e){}</script></body></html>")
        }
        val result = HtmlGuard.validate(big)
        assertTrue("3MB app must be allowed, got: ${result.issues}", result.isValid)
    }

    @Test
    fun `guard still rejects empty and broken documents`() {
        assertFalse(HtmlGuard.validate("").isValid)
        assertFalse(HtmlGuard.validate("<!DOCTYPE html><html><head></head><body><script>var x=1;</body></html>").isValid)
    }

    @Test
    fun `length truncation is detected for every provider`() {
        assertTrue(BuildAgent.isLengthTruncation("length"))
        assertTrue(BuildAgent.isLengthTruncation("MAX_TOKENS"))
        assertTrue(BuildAgent.isLengthTruncation("max_tokens"))
        assertFalse(BuildAgent.isLengthTruncation("stop"))
        assertFalse(BuildAgent.isLengthTruncation("end_turn"))
        assertFalse(BuildAgent.isLengthTruncation(null))
        assertFalse(BuildAgent.isLengthTruncation(""))
    }

    // ------------------------------------------------------------------
    // Dynamic fan-out for big tasks
    // ------------------------------------------------------------------

    @Test
    fun `big specs fan out to many tasks with one task per screen`() {
        val tasks = BuildAgent.fullTasksFor(richSpec())
        assertTrue("expected swarm-sized plan, got ${tasks.size}", tasks.size > 6)
        val screenTasks = tasks.filter { it.targetFiles.any { f -> f.startsWith("src/screens/") } }
        assertEquals(5, screenTasks.size)
        assertTrue(tasks.any { "src/features/engine.js" in it.targetFiles })
        assertTrue(tasks.any { "src/main.js" in it.targetFiles })
        // Task ids stay unique so resume bookkeeping works.
        assertEquals(tasks.size, tasks.map { it.id }.distinct().size)
    }

    @Test
    fun `small specs still get a complete plan`() {
        val tasks = BuildAgent.fullTasksFor(richSpec().copy(features = emptyList(), screens = listOf("main")))
        assertTrue(tasks.size >= 6)
        assertTrue(tasks.any { "src/main.js" in it.targetFiles })
    }

    // ------------------------------------------------------------------
    // Delta plans: follow-ups continue, never rebuild from scratch
    // ------------------------------------------------------------------

    @Test
    fun `follow-up on a working app is a delta request`() {
        assertTrue(BuildAgent.isDeltaRequest(true, BuildIntent.ADD_FEATURE, "button ka color badlo"))
        assertTrue(BuildAgent.isDeltaRequest(true, BuildIntent.FIX_BUG, "fix the crash on login"))
        assertFalse(BuildAgent.isDeltaRequest(true, BuildIntent.ADD_FEATURE, "sab kuch dobara banao"))
        assertFalse(BuildAgent.isDeltaRequest(true, BuildIntent.RESET, "reset karo"))
        assertFalse(BuildAgent.isDeltaRequest(false, BuildIntent.NEW_APP, "game banao"))
    }

    @Test
    fun `rebuild detection ignores negations and word fragments`() {
        assertTrue(BuildAgent.promptMentionsEverything("sab kuch dobara banao"))
        assertTrue(BuildAgent.promptMentionsEverything("rebuild everything from scratch"))
        assertFalse(BuildAgent.promptMentionsEverything("purana wala sabr se thik karo"))
        assertFalse(BuildAgent.promptMentionsEverything("never remove or redesign anything, just fix the bug"))
        assertFalse(BuildAgent.promptMentionsEverything("dobara mat banao, sirf color badlo"))
        assertFalse(
            BuildAgent.promptMentionsEverything(
                "Continue improving this app.\nCONTINUE-FORWARD RULES (strict):\n1. Keep EVERY existing feature working — never remove or redesign unless asked."
            )
        )
    }

    @Test
    fun `delta plan touches only what the request needs`() {
        val frozen = setOf("src/tokens.css", "src/base.css", "src/state.js", "src/ui.js", "src/components.css", "src/main.js")
        val tasks = BuildAgent.deltaTasksFor("button ka color badlo", frozen)
        // Untouched base files are skipped; exactly one targeted task does the change.
        assertEquals(1, tasks.size)
        assertTrue(tasks[0].id.startsWith("task_delta_"))
        assertEquals("src/components.css", tasks[0].targetFiles.first())
    }

    @Test
    fun `delta plan honors an explicitly named file`() {
        val tasks = BuildAgent.deltaTasksFor("update src/state.js to add sound toggle", emptySet())
        assertTrue(tasks.any { "src/state.js" in it.targetFiles })
    }

    @Test
    fun `createTaskPlan routes new apps to full plans and follow-ups to delta plans`() {
        val full = BuildAgent.createTaskPlan(richSpec(), isExistingApp = false, BuildIntent.NEW_APP, "game banao", emptySet())
        assertTrue(full.size > 6)
        val delta = BuildAgent.createTaskPlan(richSpec(), isExistingApp = true, BuildIntent.ADD_FEATURE, "add sound", setOf("src/main.js"))
        assertTrue(delta.size < full.size)
        assertTrue(delta.any { it.id.startsWith("task_delta_") })
    }

    // ------------------------------------------------------------------
    // Plan signatures for resume matching
    // ------------------------------------------------------------------

    @Test
    fun `plan signature is stable and order independent`() {
        val a = listOf("t1" to "src/a.js", "t2" to "src/b.js")
        val b = listOf("t2" to "src/b.js", "t1" to "src/a.js")
        assertEquals(BuildCheckpointStore.planSignatureFor(a), BuildCheckpointStore.planSignatureFor(b))
        assertNotEquals(
            BuildCheckpointStore.planSignatureFor(a),
            BuildCheckpointStore.planSignatureFor(listOf("t1" to "src/a.js", "t2" to "src/CHANGED.js"))
        )
    }
}

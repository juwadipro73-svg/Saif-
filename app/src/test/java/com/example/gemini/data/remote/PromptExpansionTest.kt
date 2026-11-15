package com.example.gemini.data.remote

import com.example.gemini.ui.browser.BrowserExtension
import com.example.gemini.ui.browser.BrowserExtensionManager
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

class PromptExpansionTest {
    @get:Rule val temporary = TemporaryFolder()
    @After fun clear() { CustomSlashCommands.commands.clear(); BrowserExtensionManager.instance.extensions.clear() }

    private fun plugin(id: String, tools: Int): File {
        val dir = temporary.newFolder(id)
        File(dir, "skills").mkdirs()
        File(dir, "skills/upload.md").writeText("# Upload")
        val skill = com.example.gemini.ui.browser.ExtensionSkill("upload", "Upload", "", File(dir, "skills/upload.md").absolutePath, null)
        BrowserExtensionManager.instance.extensions.add(BrowserExtension(id, id, "1", "", toolCount = tools, skillCount = 1, dirPath = dir.absolutePath, skills = listOf(skill)))
        return dir
    }

    @Test fun pluginWithToolsAsksForMcpOnlyIfTheTaskNeedsIt() {
        val dir = plugin("yt", tools = 2)
        val sent = PromptExpansion.expand("/plu:yt:upload my video")
        assertTrue(sent.contains(File(dir, "skills/upload.md").absolutePath))
        assertTrue(sent.contains("Check whether the task depends on them"))
        assertTrue(sent.contains("\"extension_yt\""))
        assertEquals("/plu:yt:upload my video", PromptExpansion.collapse(sent))
    }

    @Test fun mentionsOtherPluginsSkillsForDependencies() {
        plugin("yt", tools = 2)
        val notes = plugin("notes", tools = 0)
        val sent = PromptExpansion.expand("/plu:yt:upload")
        assertTrue(sent.contains("depends on another custom SAIF AI plugin"))
        assertTrue(sent.contains("notes (${File(notes, "skills").absolutePath}/)"))
        assertFalse(PromptExpansion.expand("/plu:yt").substringAfter("Other installed plugins with skills:").contains("yt ("))
    }

    @Test fun skillOnlyPluginNeverAsksForMcp() {
        plugin("notes", tools = 0)
        val sent = PromptExpansion.expand("/plu:notes:upload")
        assertTrue(sent.contains("no tools of its own"))
        assertFalse(sent.contains("MCP settings"))
    }

    @Test fun customCommandExpandsAndCollapsesBack() {
        CustomSlashCommands.save(CustomSlashCommand("review", expansion = "Review the diff carefully."))
        val sent = PromptExpansion.expand("/review then summarize")
        assertTrue(sent.contains("Review the diff carefully."))
        assertEquals("/review then summarize", PromptExpansion.collapse(sent))
    }

    @Test fun argumentsAreConsumedAndShownWithTheCommand() {
        CustomSlashCommands.save(CustomSlashCommand("fix", expansion = "Fix this bug: \$ARGUMENTS"))
        val sent = PromptExpansion.expand("please /fix the \"login\" <crash>")
        assertTrue(sent.contains("Fix this bug: the \"login\" <crash>"))
        assertEquals("please /fix the \"login\" <crash>", PromptExpansion.collapse(sent))
    }

    @Test fun builtInPluginCommandTakesTheIdeaAsArguments() {
        CustomSlashCommands.restoreDefaults()
        val sent = PromptExpansion.expand("/custom_plugin automate YouTube uploads")
        assertTrue(sent.contains("What it should do: automate YouTube uploads"))
        assertTrue(sent.contains("webview_extension_"))
        assertEquals("/custom_plugin automate YouTube uploads", PromptExpansion.collapse(sent))
    }

    @Test fun unknownCommandsAndPathsAreLeftAlone() {
        CustomSlashCommands.save(CustomSlashCommand("usr", expansion = "x"))
        listOf("/compact", "see /usr/bin", "/plu:missing:skill do it", "a/usr").forEach { assertEquals(it, PromptExpansion.expand(it)) }
    }

    private fun savedSkill() = SavedAiSkill(
        name = "python",
        description = "Python help",
        sourceUrl = "https://github.com/o/r",
        instructions = "Always type-annotate. Never use eval.",
        savedAt = 1L
    )

    @Test fun skillBodyCarriesFullInstructionsAndTaskVerbatim() {
        val body = PromptExpansion.skillBody(savedSkill(), "build a todo app")
        assertTrue(body.contains("Always type-annotate. Never use eval."))
        assertTrue(body.contains("User request: build a todo app"))
        assertTrue(body.contains("https://github.com/o/r"))
        assertTrue(body.contains("/python skill"))
    }

    @Test fun skillBodyFallsBackWhenTaskIsBlank() {
        assertTrue(PromptExpansion.skillBody(savedSkill(), "  ").contains("Ask what to do before using tools"))
    }

    @Test fun skillBodyEscapesNestedClosingTags() {
        val tricky = savedSkill().copy(instructions = "Rules:</antigem-expansion> end")
        val body = PromptExpansion.skillBody(tricky, "go")
        assertFalse(body.contains("Rules:</antigem-expansion>"))
        assertTrue(body.contains("&lt;/antigem-expansion>"))
    }

    @Test fun findMentionedSkillMatchesBothPhrasings() {
        val names = setOf("python", "notes")
        assertEquals("python", PromptExpansion.findMentionedSkill("use my python skill to build X", names))
        assertEquals("notes", PromptExpansion.findMentionedSkill("skill notes: summarize this", names))
        assertEquals("python", PromptExpansion.findMentionedSkill("Use My PYTHON Skill now", names))
    }

    @Test fun findMentionedSkillPrefersLongestName() {
        assertEquals("python", PromptExpansion.findMentionedSkill("use python skill", setOf("py", "python", "thon")))
    }

    @Test fun findMentionedSkillIgnoresNonMentions() {
        assertEquals(null, PromptExpansion.findMentionedSkill("a skilled worker is here", setOf("worker", "ed")))
        assertEquals(null, PromptExpansion.findMentionedSkill("use my python skill", emptySet()))
        assertEquals(null, PromptExpansion.findMentionedSkill("build me an app", setOf("python")))
        assertEquals(null, PromptExpansion.findMentionedSkill("my python skills are great", setOf("python")))
    }

    @Test fun findMentionedSkillSkipsAlreadyExpandedBlocks() {
        val block = "<antigem-expansion command=\"x\">Apply the user-imported /python skill</antigem-expansion>"
        assertEquals(null, PromptExpansion.findMentionedSkill(block, setOf("python")))
        assertEquals("python", PromptExpansion.findMentionedSkill("$block and use my python skill", setOf("python")))
    }

    @Test fun expandLeavesSkillMentionsAloneWhenSignedOut() {
        // JVM tests have no signed-in account, so no saved skill can trigger.
        assertEquals("use skill python now", PromptExpansion.expand("use skill python now"))
        assertEquals("please /python now", PromptExpansion.expand("please /python now"))
    }
}

package com.example.gemini.data.remote

import com.example.gemini.ui.browser.BrowserExtension
import com.example.gemini.ui.browser.BrowserExtensionManager

/**
 * Turns `/plu:<plugin>[:<skill>]` and custom slash commands into instructions for the model when a message is sent.
 * Each expansion is wrapped in an `<antigem-expansion command="…">` block; [collapse] puts the command back for
 * display, so the chat shows what the user typed even after the history is reloaded from the backend.
 */
object PromptExpansion {
    private const val TAG = "antigem-expansion"
    // `/plu:<plugin>:` with no skill after the colon (left by the picker) counts as `/plu:<plugin>`
    private val TOKEN = Regex("(?<=^|\\s)/(plu:[A-Za-z0-9_-]+(?::[A-Za-z0-9._-]*)?|[A-Za-z0-9][A-Za-z0-9_-]{0,47})(?=\\s|$)")
    private val BLOCK = Regex("<$TAG command=\"([^\"]*)\">[\\s\\S]*?</$TAG>")

    /**
     * Expansion body for a saved GitHub skill: the downloaded rules verbatim plus the user's
     * separate task. Shared by leading /command, mid-text /command and skill-mention triggers.
     * Pure logic, covered by unit tests.
     */
    fun skillBody(skill: SavedAiSkill, task: String): String {
        val safeRules = skill.instructions.replace("</$TAG>", "&lt;/$TAG>", ignoreCase = true)
        val safeTask = task.replace("</$TAG>", "&lt;/$TAG>", ignoreCase = true)
        return """
            Apply the user-imported /${skill.name} skill (source: ${skill.sourceUrl}) to this request.
            Skill instructions:
            $safeRules

            User request: ${safeTask.ifBlank { "No task was provided yet. Ask what to do before using tools." }}
            Follow the skill's tone and workflow within the available tools and permissions. If you need a file,
            workspace, credential or other missing input, ask the user rather than claiming it already exists.
        """.trimIndent()
    }

    private fun phraseMatchOutsideBlocks(text: String, name: String): MatchResult? {
        val blocked = BLOCK.findAll(text).map { it.range }.toList()
        val rx = Regex(
            """\b(skill\s+${Regex.escape(name)}|${Regex.escape(name)}\s+skill)\b""",
            RegexOption.IGNORE_CASE
        )
        return rx.findAll(text).firstOrNull { m -> blocked.none { m.range.first in it } }
    }

    /**
     * Names the saved skill a message asks for WITHOUT a slash ("use my python skill",
     * "skill notes: ..."). Longest name wins; matches inside already-expanded blocks don't
     * count, so expansion never nests. Pure logic, covered by unit tests.
     */
    fun findMentionedSkill(text: String, names: Set<String>): String? {
        if (names.isEmpty() || !text.contains("skill", ignoreCase = true)) return null
        return names.sortedByDescending { it.length }
            .firstOrNull { phraseMatchOutsideBlocks(text, it) != null }
    }

    /**
     * Expands explicit skill mentions without a slash ("use my python skill") in place, so a
     * downloaded skill is actually used instead of silently ignored. Collapse restores the phrase.
     */
    fun expandSkillMentions(text: String): String {
        val visible = SavedAiSkills.visibleSkills()
        if (visible.isEmpty()) return text
        var working = text
        val byName = visible.associateBy { it.name.lowercase() }
        repeat(5) {
            val name = findMentionedSkill(working, byName.keys) ?: return@repeat
            val skill = byName[name.lowercase()] ?: return@repeat
            val at = phraseMatchOutsideBlocks(working, name) ?: return@repeat
            working = working.replaceRange(at.range, block(at.value, skillBody(skill, collapse(working))))
        }
        return working
    }

    fun expand(text: String): String {
        // A slash-less message can still name a saved skill ("use my python skill").
        if (!text.contains('/')) return expandSkillMentions(text)
        // A leading /command gives the engine the downloaded rules AND the user's separate task;
        // mid-text /commands and plain skill mentions expand further below. The block preserves
        // exactly what was typed so the chat history still shows the original message.
        SkillSlashParsing.parse(text)?.let { invocation ->
            SavedAiSkills.find(invocation.command)?.let { skill ->
                return block(text.trim(), skillBody(skill, invocation.task))
            }
        }
        val working = expandSkillMentions(text)
        val blocked = BLOCK.findAll(working).map { it.range }.toList()
        val out = StringBuilder()
        var last = 0
        for (match in TOKEN.findAll(working)) {
            if (match.range.first < last) continue
            // Never expand a /token that sits inside an already-expanded block.
            if (blocked.any { match.range.first in it }) continue
            val token = match.groupValues[1]
            if (token.startsWith("plu:")) {
                val parts = token.removePrefix("plu:").split(':')
                val skill = parts.getOrNull(1)?.ifBlank { null }
                val guide = pluginGuide(parts[0], skill) ?: continue
                // The chat shows the command without the dangling colon
                out.append(working, last, match.range.first).append(block(if (skill == null) "/plu:${parts[0]}" else match.value, guide))
                last = match.range.last + 1
                continue
            }
            // Mid-text /skill tokens trigger saved skills too (the composer already highlights
            // them as commands) — the skill body goes in place of the token.
            SavedAiSkills.find(token)?.let { skill ->
                out.append(working, last, match.range.first)
                val task = collapse(working.substring(match.range.last + 1)).trim()
                out.append(block(match.value, skillBody(skill, task)))
                last = match.range.last + 1
                return@let
            } ?: run {
                val command = CustomSlashCommands.find(token) ?: return@run
                out.append(working, last, match.range.first)
                // $ARGUMENTS commands consume the rest of the line: the expansion is complete.
                if (expandCustomCommand(working, match, command, out)) return out.toString()
                last = match.range.last + 1
            }
            continue
        }
        if (last == 0) {
            val builtin = com.example.slash.SaifSlashCommandRegistry.expandBuiltInCommandIfMatched(working)
            if (builtin != null) return builtin
            return working
        }
        return out.append(working, last, working.length).toString()
    }

    /** Appends one custom-command expansion; returns true when it consumed the rest of the line. */
    private fun expandCustomCommand(
        text: String,
        match: MatchResult,
        command: CustomSlashCommand,
        out: StringBuilder
    ): Boolean {
        val plugin = command.pluginId.takeIf { it.isNotBlank() }?.let { pluginGuide(it, command.skill.ifBlank { null }) }
        if (command.expansion.contains("\$ARGUMENTS")) {
            // The command takes the rest of the message as its arguments
            val args = text.substring(match.range.last + 1).trim()
            val body = listOfNotNull(plugin, command.expansion.replace("\$ARGUMENTS", args)).joinToString("\n\n")
            out.append(block(if (args.isEmpty()) match.value else "${match.value} $args", body))
            return true
        }
        out.append(block(match.value, listOfNotNull(plugin, command.expansion.takeIf { it.isNotBlank() }).joinToString("\n\n")))
        return false
    }

    /** Where [text] (as the user typed it) has a command that expands: an enabled plugin's `/plu:` or a custom command. For highlighting. */
    fun commandRanges(text: String): List<IntRange> {
        if (!text.contains('/')) return emptyList()
        return TOKEN.findAll(text).filter { match ->
            val token = match.groupValues[1]
            if (token.startsWith("plu:")) enabledPlugin(token.removePrefix("plu:").substringBefore(':')) != null
            else CustomSlashCommands.find(token) != null || SavedAiSkills.find(token) != null
        }.map { it.range }.toList()
    }

    fun collapse(text: String): String =
        if (!text.contains("<$TAG ")) text else BLOCK.replace(text) { unescape(it.groupValues[1]) }

    private fun block(command: String, body: String) = "<$TAG command=\"${escape(command)}\">\n$body\n</$TAG>"

    private fun enabledPlugin(id: String): BrowserExtension? =
        BrowserExtensionManager.instance.extensions.firstOrNull { it.isEnabled && it.id.equals(id, ignoreCase = true) }

    /** A short note telling the model where the plugin's skill is and how to reach its tools. Null if the plugin is unknown. */
    private fun pluginGuide(pluginId: String, skillName: String?): String? {
        val plugin = enabledPlugin(pluginId) ?: return null
        val server = BrowserExtensionManager.instance.mcpServerName(plugin.id)
        val lines = mutableListOf<String>()
        // Skill paths come from the IDE bridge's plugin list, i.e. as the agents see them
        val skill = skillName?.let { name -> plugin.skills.firstOrNull { it.name == name } }
        if (skill != null) {
            val name = skill.name
            lines += "The user wants you to use the custom SAIF AI plugin \"${plugin.name}\" (id: ${plugin.id}) and its skill \"$name\"."
            lines += "- Read the skill file fully before acting: ${skill.path}"
            skill.detailDir?.let { lines += "- Its detail files are in $it/ — open them only when the skill refers to them." }
            lines += "- If you cannot read that file but have the MCP server \"$server\", call its get_skill tool with name \"$name\" instead."
        } else {
            lines += "The user wants you to use the custom SAIF AI plugin \"${plugin.name}\" (id: ${plugin.id})" + (if (plugin.description.isNotBlank()) ": ${plugin.description}" else ".")
            val skills = plugin.skills.map { it.name }
            val skillsDir = plugin.skills.firstOrNull()?.path?.substringBeforeLast('/')
            if (skillsDir != null) lines += "- Its skills (guides) are in $skillsDir/: ${skills.take(30).joinToString(", ")}${if (skills.size > 30) ", …" else ""}. Read the one that matches the task before acting."
        }
        // The skill text arrives either way; only the plugin's own tools need its MCP server
        lines += if (plugin.toolCount > 0) {
            "- The plugin's own tools come from the MCP server \"$server\". Check whether the task depends on them. If it does and you don't have that server's tools, stop and ask the user to enable it in MCP settings → Custom SAIF AI Plugin MCP. If it doesn't, do the task with the tools you already have."
        } else {
            "- This plugin has no tools of its own: follow its instructions with the tools you already have."
        }
        // A plugin may build on another one (its skill or tools say so); point at the other plugins' skills
        val others = BrowserExtensionManager.instance.extensions.filter { it.isEnabled && it.id != plugin.id && it.skills.isNotEmpty() }
        if (others.isNotEmpty()) {
            val listed = others.take(10).joinToString("; ") { other -> "${other.id} (${other.skills.first().path.substringBeforeLast('/')}/)" }
            lines += "- If this plugin depends on another custom SAIF AI plugin, also read that plugin's matching skill before using it. Other installed plugins with skills: $listed${if (others.size > 10) "; …" else ""}."
        }
        return lines.joinToString("\n")
    }

    /** `/plu` picker rows: enabled plugins for `plu:<query>`, then one plugin's skills for `plu:<plugin>:<query>`. */
    fun pluginSuggestions(afterExt: String): List<SlashCommandItem> {
        val plugins = BrowserExtensionManager.instance.extensions.filter { it.isEnabled && (it.toolCount > 0 || it.skillCount > 0) }
        val colon = afterExt.indexOf(':')
        if (colon < 0) {
            return plugins.filter { afterExt.isBlank() || it.id.contains(afterExt, true) || it.name.contains(afterExt, true) || it.folderName.contains(afterExt, true) }
                .map { p ->
                    val counts = listOfNotNull("${p.toolCount} tools".takeIf { p.toolCount > 0 }, "${p.skillCount} skills".takeIf { p.skillCount > 0 }).joinToString(" · ")
                    // A plugin with skills ends in ':' so picking it keeps the picker open on its skills
                    SlashCommandItem(p.id, if (p.skillCount > 0) "/plu:${p.id}:" else "/plu:${p.id}", listOf(p.name, counts, p.description).filter { it.isNotBlank() }.joinToString(" · "), "plugin", path = p.iconPath)
                }
        }
        val plugin = plugins.firstOrNull { it.id.equals(afterExt.substring(0, colon), ignoreCase = true) } ?: return emptyList()
        val query = afterExt.substring(colon + 1)
        val whole = SlashCommandItem(plugin.id, "/plu:${plugin.id}", "Use ${plugin.name} without a specific skill", "plugin", path = plugin.iconPath)
        val skills = plugin.skills
            .filter { query.isBlank() || it.name.contains(query, true) || it.title.contains(query, true) || it.description.contains(query, true) }
            .map { SlashCommandItem(it.name, "/plu:${plugin.id}:${it.name}", it.description.ifBlank { it.title }, "plugin", pluginName = plugin.name, path = plugin.iconPath) }
        return if (query.isBlank()) listOf(whole) + skills else skills
    }

    /** The `/plu` entry point and the user's custom commands, shown in the normal `/` list. */
    fun baseSlashItems(): List<SlashCommandItem> =
        SavedAiSkills.suggestions("") + CustomSlashCommands.slashItems() +
            SlashCommandItem("plu", "/plu:", "Use a custom plugin and its skills", "plugin")

    private fun escape(value: String) = value.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;")
    private fun unescape(value: String) = value.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&amp;", "&")
}

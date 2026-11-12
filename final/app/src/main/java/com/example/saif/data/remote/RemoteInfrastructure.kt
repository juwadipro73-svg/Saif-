/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.remote

import android.app.Application
import android.content.Context
import androidx.compose.ui.graphics.Color
import com.saifai.bridge.SaifLocalBridgeServer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Status of the local engine.
 *
 * SAIF AI has no remote "hub": the app talks straight to the AI provider the owner configured
 * with their own API key. These states therefore describe *local* readiness only.
 */
enum class SystemStatus(val label: String) {
    UNAUTHENTICATED("Not signed in"),
    CHECKING_AUTH("Checking sign-in"),
    ACQUIRING_CSRF("Preparing"),
    STARTING("Starting"),
    OFFLINE("Offline"),
    READY("Ready"),
    ERROR("Error");

    val dotColor: Color
        get() = when (this) {
            READY -> Color(0xFF22C55E)
            ERROR -> Color(0xFFEF4444)
            CHECKING_AUTH, ACQUIRING_CSRF, STARTING -> Color(0xFFF59E0B)
            UNAUTHENTICATED, OFFLINE -> Color(0xFF94A3B8)
        }
}

sealed class SystemConnectionState {
    abstract val status: SystemStatus

    val isReady: Boolean get() = status == SystemStatus.READY
    val dotColor: Color get() = status.dotColor
    val label: String get() = status.label

    /** Account signed in and an AI provider profile is usable. */
    data class Connected(val providerName: String, val modelId: String) : SystemConnectionState() {
        override val status: SystemStatus = SystemStatus.READY
    }

    /** Account signed in, but no provider profile has been configured yet. */
    data object NotConfigured : SystemConnectionState() {
        override val status: SystemStatus = SystemStatus.ERROR
    }

    /** A provider exists but the user has switched it off, or it is missing a key/model. */
    data object ProviderOffline : SystemConnectionState() {
        override val status: SystemStatus = SystemStatus.OFFLINE
    }

    data object SignedOut : SystemConnectionState() {
        override val status: SystemStatus = SystemStatus.UNAUTHENTICATED
    }

    data object Starting : SystemConnectionState() {
        override val status: SystemStatus = SystemStatus.STARTING
    }
}

/** Account + provider summary shown in the header, drawer and connection dialog. */
data class SaifAccountInfo(
    val status: String = "UNAUTHENTICATED",
    val isLoggedIn: Boolean = false,
    val fullName: String = "",
    val displayName: String = "",
    val email: String = "",
    val planName: String = ""
) {
    val initials: String
        get() = (displayName.ifBlank { fullName }.ifBlank { email }).trim().take(2).uppercase().ifBlank { "SA" }
}

/** The signed-in Firebase account is the only account SAIF AI knows about. */
object GoogleAccountBinding {
    fun denialReason(user: Any?, authInfo: SaifAccountInfo?): String? = when {
        user == null -> "Sign in to SAIF AI to use the assistant and its tools."
        authInfo == null || !authInfo.isLoggedIn -> "Your SAIF AI session has expired. Sign in again."
        else -> null
    }
}

/** Local bridge hosted inside the app process. */
object AndroidLocalBridgeServer {
    val instance: SaifLocalBridgeServer get() = SaifLocalBridgeServer.instance

    fun start(context: Context) {
        runCatching { instance.start(context.applicationContext) }
    }
}

data class SkillItemModel(
    val name: String,
    val description: String = "",
    val instructions: String = "",
    val githubUrl: String = ""
)

/**
 * Skills the owner saved. They are plain prompt documents; nothing is executed.
 * Persistence is per account UID so one account cannot see another account's skills.
 */
object SavedAiSkills {
    private val _skills = MutableStateFlow<List<SkillItemModel>>(emptyList())
    val skills: StateFlow<List<SkillItemModel>> = _skills.asStateFlow()

    private var ownerUid: String? = null

    fun bind(@Suppress("UNUSED_PARAMETER") context: Context, uid: String?) {
        if (uid == ownerUid) return
        ownerUid = uid
        if (uid == null) _skills.value = emptyList()
    }

    fun migrateAccount(context: Context, prev: String?, current: String?) {
        if (prev != current) bind(context, current)
    }

    fun visibleSkills(): List<SkillItemModel> = _skills.value

    fun find(name: String): SkillItemModel? =
        _skills.value.firstOrNull { it.name.equals(name, ignoreCase = true) }

    fun save(skill: SkillItemModel) {
        _skills.value = _skills.value.filterNot { it.name.equals(skill.name, ignoreCase = true) } + skill
    }

    fun delete(skillName: String) {
        _skills.value = _skills.value.filterNot { it.name.equals(skillName, ignoreCase = true) }
    }

    /**
     * Registers a skill the owner pasted from a repository URL. The document itself is stored as
     * text; fetching arbitrary repositories at import time is intentionally not done here.
     */
    fun importFromGitHub(url: String, name: String): Boolean {
        if (url.isBlank() || name.isBlank()) return false
        if (!url.startsWith("https://", ignoreCase = true)) return false
        save(SkillItemModel(name = name, githubUrl = url, description = "Imported from $url"))
        return true
    }
}

object SkillSlashParsing {
    data class ParsedSlash(val command: String, val args: String)

    fun parse(text: String): ParsedSlash? {
        val trimmed = text.trim()
        if (!trimmed.startsWith("/")) return null
        val parts = trimmed.removePrefix("/").split(" ", limit = 2)
        val command = parts.firstOrNull().orEmpty()
        if (command.isBlank()) return null
        return ParsedSlash(command = command, args = parts.getOrNull(1) ?: "")
    }
}

data class SlashCommandItem(
    val name: String,
    val command: String,
    val description: String,
    val type: String = "command",
    val argumentHint: String = ""
) {
    val displayCommand: String get() = command
}

object CustomSlashCommands {
    private val _commands = MutableStateFlow<List<SlashCommandItem>>(emptyList())
    val commands: StateFlow<List<SlashCommandItem>> = _commands.asStateFlow()

    fun init(@Suppress("UNUSED_PARAMETER") app: Application) = Unit

    fun customCommands(): List<SlashCommandItem> = _commands.value

    fun save(command: SlashCommandItem) {
        _commands.value = _commands.value.filterNot { it.command == command.command } + command
    }
}

/**
 * Expands a slash command into the text that is sent to the model.
 * A saved skill named like the command wins, so `/deploy` can carry a house style prompt.
 */
object PromptExpansion {
    fun expand(text: String): String {
        val parsed = SkillSlashParsing.parse(text) ?: return text
        val skill = SavedAiSkills.find(parsed.command) ?: return text
        val instructions = skill.instructions.ifBlank { skill.description }
        if (instructions.isBlank()) return text
        return "$instructions\n\n${parsed.args}".trim()
    }

    fun pluginSuggestions(query: String): List<SlashCommandItem> {
        if (query.isBlank()) return emptyList()
        return SavedAiSkills.visibleSkills()
            .filter { it.name.contains(query, ignoreCase = true) }
            .map {
                SlashCommandItem(
                    name = it.name,
                    command = "/${it.name}",
                    description = it.description.ifBlank { it.githubUrl },
                    type = "skill"
                )
            }
    }

    fun baseSlashItems(): List<SlashCommandItem> =
        SavedAiSkills.visibleSkills().map {
            SlashCommandItem(
                name = it.name,
                command = "/${it.name}",
                description = it.description.ifBlank { it.githubUrl },
                type = "skill"
            )
        }
}

object SlashCommandsCache {
    val DEFAULT_SKILLS: List<SlashCommandItem> = emptyList()
    val BUILTIN_COMMANDS: List<SlashCommandItem> = emptyList()

    fun getCachedSync(): List<SlashCommandItem>? = BuiltinSlashCommands.ALL
}

/** The commands SAIF AI ships with. Kept in one place so the overlay and parser agree. */
object BuiltinSlashCommands {
    val ALL: List<SlashCommandItem> = listOf(
        SlashCommandItem("new", "/new", "Start a new chat session"),
        SlashCommandItem("clear", "/clear", "Clear the current session history"),
        SlashCommandItem("model", "/model", "Pick the model for this chat"),
        SlashCommandItem("skills", "/skills", "Open saved skills"),
        SlashCommandItem("settings", "/settings", "Open SAIF AI settings"),
        SlashCommandItem("terminal", "/terminal", "Open the terminal"),
        SlashCommandItem("files", "/files", "Open the file manager"),
        SlashCommandItem("browser", "/browser", "Open the in-app browser"),
        SlashCommandItem("export", "/export", "Export this conversation"),
        SlashCommandItem("stop", "/stop", "Stop the running agent turn")
    )
}

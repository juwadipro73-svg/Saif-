/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.settings

enum class SettingsSection(val title: String, val subtitle: String) {
    GENERAL("General", "AI provider, approvals and account"),
    APPEARANCE("Appearance", "Theme and chat density"),
    VOICE("Voice & Kabir Authority", "Speech input and spoken replies"),
    WORKSPACE("Workspace Shell", "Terminal, files and local tools"),
    WEBVIEW_EXTENSIONS("Web Extensions", "Extensions bundled with SAIF AI"),
    SLASH_COMMANDS("Slash Commands", "Commands available in the composer"),
    AI_SKILLS("AI Skills", "Saved skills you can invoke with /"),
    MCP("Model Context Protocol (MCP)", "Local tool bridge over loopback")
}

val ENGINE_SETTINGS_SECTIONS: List<SettingsSection> = SettingsSection.entries

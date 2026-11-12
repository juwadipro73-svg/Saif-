/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.drawer

/**
 * Turns a stored profile picture reference into something Coil can load.
 *
 * Returns null for blank/unsupported values so the caller can fall back to the initial letter.
 */
fun parseProfileAvatarModel(profilePictureUrl: String?): Any? {
    val value = profilePictureUrl?.trim().orEmpty()
    if (value.isEmpty()) return null
    return when {
        value.startsWith("https://", ignoreCase = true) -> value
        value.startsWith("http://", ignoreCase = true) -> value
        value.startsWith("content://", ignoreCase = true) -> android.net.Uri.parse(value)
        value.startsWith("file://", ignoreCase = true) -> android.net.Uri.parse(value)
        value.startsWith("/") && java.io.File(value).exists() -> java.io.File(value)
        else -> null
    }
}

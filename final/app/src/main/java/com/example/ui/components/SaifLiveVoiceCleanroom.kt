/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui.components

import android.content.Context
import android.widget.Toast
import com.example.utils.TTSManager

/**
 * SAIF AI live voice session holder, backed by the app's own text-to-speech engine.
 */
object SaifLiveSession {
    @Volatile var pendingScreenShare: Boolean = false
}

/**
 * Starts a cleanroom SAIF AI voice session with Kabir voice authority.
 */
fun startNormal(context: Context, isLightMode: Boolean = false, onStarted: () -> Unit = {}) {
    Toast.makeText(context, "SAIF AI Kabir Voice Active", Toast.LENGTH_SHORT).show()
    TTSManager.init(context)
    TTSManager.speak("SAIF AI ready.", context)
    onStarted()
}

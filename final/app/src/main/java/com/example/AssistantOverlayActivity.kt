/* Copyright (c) SAIF AI. All rights reserved. */

package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

class AssistantOverlayActivity : ComponentActivity() {
    override fun onCreate(initialSavedState: Bundle?) {
        super.onCreate(initialSavedState)
        androidx.core.view.WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Text(text = "SAIF Voice Assistant", modifier = Modifier)
        }
    }

    override fun onDestroy() /* Activity teardown */ {
        super.onDestroy()
    }
}

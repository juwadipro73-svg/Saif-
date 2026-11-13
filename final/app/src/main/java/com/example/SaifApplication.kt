/* Copyright (c) SAIF AI. All rights reserved. */

package com.example

import android.app.Application
import com.example.data.local.ProviderSettingsManager
import com.saifai.engine.SaifEngineBootstrap

class SaifApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProviderSettingsManager.init(this)

        // Anti-tampering: verify the installed APK at startup. A repackaged or re-signed build
        // is detected here and reported, so the release binary stays honest.
        runCatching {
            val report = com.example.security.AppIntegrity.inspect(this)
            if (!report.healthy) {
                android.util.Log.w("SaifIntegrity", "Integrity check failed: $report")
            }
        }

        // The launcher icon rotates through its palette every two hours.
        runCatching { com.saifai.brand.DynamicAppIcon.start(this) }

        // Initialize SAIF AI Sovereign Engine & Memory
        SaifEngineBootstrap.initialize(this)
        com.example.util.SaifMemoryCore.init(this)
        com.example.utils.TTSManager.init(this)
    }
}

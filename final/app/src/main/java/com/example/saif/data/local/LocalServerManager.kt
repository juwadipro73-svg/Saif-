/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.local

import android.content.Context
import com.saifai.bridge.SaifLocalBridgeServer

/**
 * Owns the local HTTP bridge the workspace, browser tabs and builder talk to.
 *
 * The server is a plain loopback socket served by SAIF AI itself; it never leaves the device.
 */
object LocalServerManager {

    @Volatile
    private var started = false

    fun startServer(context: Context) {
        runCatching { SaifLocalBridgeServer.instance.start(context.applicationContext) }
        started = true
    }

    fun stopServer() {
        runCatching { SaifLocalBridgeServer.instance.stop() }
        started = false
    }

    fun restartServer(context: Context) {
        stopServer()
        startServer(context)
    }

    fun isRunning(): Boolean = started
}

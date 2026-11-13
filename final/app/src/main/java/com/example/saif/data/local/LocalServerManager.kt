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
        // Install the terminal build commands (`saif-build-apk`, `saif-apk-link`) so a project
        // written in the terminal can be compiled on the device. Without this the terminal
        // commands pointed at a bridge that was never running.
        runCatching {
            val bridge = SaifLocalBridgeServer.instance
            com.example.compiler.LinuxApkBuildBridge.installLinuxCliTools(
                context.applicationContext,
                bridge.port,
                bridge.deviceId
            )
        }
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

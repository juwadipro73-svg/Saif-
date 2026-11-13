/* Copyright (c) SAIF AI. All rights reserved. */

package com.saifai.bridge

import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import java.io.*
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.security.SecureRandom
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors

/**
 * SAIF AI's local download and execution bridge.
 *
 * It only listens on the device loopback interface and hands out short-lived tokens for
 * files the app itself produced.
 */
class SaifLocalBridgeServer private constructor() {

    companion object /* SAIF Local Bridge Server */ {
        private const val TAG = "SaifLocalBridgeServer"
        val instance: SaifLocalBridgeServer by lazy { SaifLocalBridgeServer() }
    }

    data class DownloadEntry(
        val token:
        String,
        val file: File,
        val fileName:
        String,
        val mimeType:
        String,
        val createdAt:
        Long = System.currentTimeMillis()
    )

    private val secureRandom = SecureRandom()
    private val registeredDownloads = ConcurrentHashMap<String, DownloadEntry>()

    /**
     * The device id the terminal CLI uses to authenticate against the bridge.
     * It is generated on the device and never leaves it.
     */
    @Volatile
    var deviceId: String = ""
        private set

    /** The application context, kept so the request handlers can reach the compiler. */
    @Volatile
    private var appContext: Context? = null

    @Volatile
    var isRunning:
        Boolean = false
        private set

    @Volatile
    var port: Int = 8767
        private set

    private var serverSocket:
        ServerSocket? = null
    private val serverScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    @Synchronized
    fun start(appContext: Context) {
        if (isRunning) { return }
        try {
            this.appContext = appContext.applicationContext
            if (deviceId.isBlank()) {
                val bytes = ByteArray(16)
                secureRandom.nextBytes(bytes)
                deviceId = bytes.joinToString("") { "%02x".format(it) }
            }
            val s = ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"))
            serverSocket = s
            port = s.localPort
            isRunning = true
            Log.i(TAG, "SAIF AI Local Bridge Server listening on 127.0.0.1:$port")

            serverScope.launch(Dispatchers.IO) {
                while (isRunning && !s.isClosed) {
                    try {
                        val client = s.accept()
                        launch { handleClientSocket(client) }
                    } catch (err: Exception) {
                        break
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed starting SAIF AI Bridge Server", e)
        }
    }

    @Synchronized
    fun stop() {
        isRunning = false
        runCatching { serverSocket?.close() }
        serverSocket = null
        registeredDownloads.clear()
    }

    fun registerDownloadFile(context: Context, file: File, desiredFileName: String? = null): String {
        start(context)
        val rawName = (desiredFileName?.takeIf { it.isNotBlank() } ?: file.name)
            .replace(Regex("[^A-Za-z0-9._-]"), "_")
            .ifBlank { "saif_app.apk" }

        val ext = rawName.substringAfterLast('.', file.extension).lowercase(java.util.Locale.ROOT)
        val mime = when (ext) {
            "apk" ->
            "application/vnd.android.package-archive"
            "zip" ->
            "application/zip"
            "mp4" ->
            "video/mp4"
            else ->
            "application/octet-stream"
        }

        val tokenBytes = ByteArray(16)
        secureRandom.nextBytes(tokenBytes)
        val token = tokenBytes.joinToString("") { "%02x".format(it) }

        val entry = DownloadEntry(token, file, rawName, mime)
        registeredDownloads[token] = entry

        return "http://127.0.0.1:$port/download/$token/$rawName"
    }

    private fun handleClientSocket(socket: Socket) {
        try {
            socket.use { s ->
                val input = BufferedReader(InputStreamReader(s.getInputStream()))
                val output = BufferedOutputStream(s.getOutputStream())
                val requestLine = input.readLine() ?: return

                val parts = requestLine.split(" ")
                if (parts.size < 2) return
                val method = parts[0].uppercase()
                val uri = parts[1]

                // ---- Builder API ----------------------------------------------------
                // These are the endpoints the terminal CLI (`saif-build-apk`, `saif-apk-link`)
                // talks to. Without them a project written in the terminal could never be
                // compiled, which is exactly the "build does not work with a custom API"
                // problem: the CLI pointed at an endpoint that did not exist.
                if (method == "POST" && uri.startsWith("/api/builder/")) {
                    val headers = readHeaders(input)
                    val body = readBody(input, headers)
                    val response = handleBuilderRequest(uri, body)
                    writeJson(output, response.second, response.first)
                    return
                }

                if (uri.startsWith("/download/")) {
                    val segments = uri.removePrefix("/download/").split("/")
                    val token = segments.firstOrNull().orEmpty()
                    val entry = registeredDownloads[token]

                    if (entry != null && entry.file.exists()) {
                        val length = entry.file.length()
                        val header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: ${entry.mimeType}\r\n" +
                                "Content-Length: $length\r\n" +
                                "Content-Disposition: attachment; filename=\"${entry.fileName}\"\r\n" +
                                "Connection: close\r\n\r\n"
                        output.write(header.toByteArray(Charsets.UTF_8))

                        FileInputStream(entry.file).use { fis ->
                            val buffer = ByteArray(32768)
                            var read = fis.read(buffer)
                            while (read != -1) {
                                output.write(buffer, 0, read)
                                read = fis.read(buffer)
                            }
                        }
                        output.flush()
                        return
                    }
                }

                // Default 404
                val notFound = "HTTP/1.1 404 Not Found\r\nContent-Length: 0\r\nConnection: close\r\n\r\n"
                output.write(notFound.toByteArray(Charsets.UTF_8))
                output.flush()
            }
        } catch (err: Exception) {}
    }

    /** Reads the HTTP headers up to the blank line. */
    private fun readHeaders(input: BufferedReader): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        while (true) {
            val line = input.readLine() ?: break
            if (line.isEmpty()) break
            val idx = line.indexOf(':')
            if (idx > 0) {
                headers[line.substring(0, idx).trim().lowercase()] = line.substring(idx + 1).trim()
            }
        }
        return headers
    }

    /** Reads the request body according to its Content-Length header. */
    private fun readBody(input: BufferedReader, headers: Map<String, String>): String {
        val length = headers["content-length"]?.toIntOrNull() ?: 0
        if (length <= 0) return ""
        val buffer = CharArray(length)
        var read = 0
        while (read < length) {
            val count = input.read(buffer, read, length - read)
            if (count <= 0) break
            read += count
        }
        return String(buffer, 0, read)
    }

    /** Writes a JSON response with the given HTTP status code. */
    private fun writeJson(output: BufferedOutputStream, json: String, statusCode: Int) {
        val reason = when (statusCode) {
            200 -> "OK"
            400 -> "Bad Request"
            401 -> "Unauthorized"
            404 -> "Not Found"
            500 -> "Internal Server Error"
            else -> "OK"
        }
        val bytes = json.toByteArray(Charsets.UTF_8)
        val header = "HTTP/1.1 $statusCode $reason\r\n" +
                "Content-Type: application/json; charset=utf-8\r\n" +
                "Content-Length: ${bytes.size}\r\n" +
                "Connection: close\r\n\r\n"
        output.write(header.toByteArray(Charsets.UTF_8))
        output.write(bytes)
        output.flush()
    }

    /**
     * Handles the builder endpoints.
     *
     * @return the HTTP status code and the JSON body.
     */
    private fun handleBuilderRequest(uri: String, body: String): Pair<Int, String> {
        val appContext = this.appContext ?: return 500 to
                """{"success":false,"error":"App context is not available."}"""

        return when {
            uri.startsWith("/api/builder/compile-apk") -> {
                val json = runCatching { org.json.JSONObject(body) }.getOrElse {
                    return 400 to """{"success":false,"error":"Invalid JSON body."}"""
                }
                val result = runCatching {
                    com.example.compiler.LinuxApkBuildBridge.compileLinuxDirectoryToApk(appContext, json)
                }.getOrElse { error ->
                    org.json.JSONObject()
                        .put("success", false)
                        .put("error", error.localizedMessage ?: "Build failed.")
                }
                200 to result.toString()
            }

            uri.startsWith("/api/builder/publish-file") -> {
                val json = runCatching { org.json.JSONObject(body) }.getOrElse {
                    return 400 to """{"success":false,"error":"Invalid JSON body."}"""
                }
                val result = runCatching {
                    com.example.compiler.LinuxApkBuildBridge.publishLinuxFile(appContext, json)
                }.getOrElse { error ->
                    org.json.JSONObject()
                        .put("success", false)
                        .put("error", error.localizedMessage ?: "Publish failed.")
                }
                200 to result.toString()
            }

            else -> 404 to """{"success":false,"error":"Unknown endpoint: $uri"}"""
        }
    }
}

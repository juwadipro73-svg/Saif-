package com.example.live

/**
 * Provider failure classification for retry/fallback logic.
 * (Moved here when the Video Studio window was removed from the app; the live voice
 * turn loop is the remaining user of this classification.)
 */
enum class ProviderFailureKind { TRANSIENT, QUOTA, AUTH, INVALID_RESPONSE, UNSUPPORTED, UNKNOWN }

object ProviderFailure {
    fun classify(message: String?): ProviderFailureKind {
        val m = (message ?: "").lowercase()
        return when {
            "429" in m || "quota" in m || "rate limit" in m || "resource_exhausted" in m -> ProviderFailureKind.QUOTA
            "401" in m || "403" in m || "api key" in m || "unauthorized" in m -> ProviderFailureKind.AUTH
            "timeout" in m || "timed out" in m || "unable to resolve" in m || "connection" in m || "503" in m || "502" in m || "500" in m -> ProviderFailureKind.TRANSIENT
            "400" in m && ("unsupported" in m || "unknown parameter" in m) -> ProviderFailureKind.UNSUPPORTED
            "json" in m || "parse" in m -> ProviderFailureKind.INVALID_RESPONSE
            else -> ProviderFailureKind.UNKNOWN
        }
    }

    fun isRetryable(kind: ProviderFailureKind) =
        kind == ProviderFailureKind.TRANSIENT || kind == ProviderFailureKind.INVALID_RESPONSE
}

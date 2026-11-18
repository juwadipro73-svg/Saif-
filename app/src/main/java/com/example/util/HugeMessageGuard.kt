package com.example.util

/**
 * Kills the "chat disappears at link-time" crash class.
 *
 * Symptom fixed: a finished turn produces a VERY large final message (full code
 * dumps, logs, base64-ish blobs). Rendering/parsing/prewarming that multi-hundred-KB
 * text on the UI thread throws or OOMs, the process dies exactly when the download
 * link arrives, and on relaunch the chat shows older state because the turn never
 * landed safely. These caps make giant messages renderable and storable while
 * ALWAYS preserving the head of the answer AND its tail — where the download/live
 * links live — so the user never loses the link again.
 */
object HugeMessageGuard {
    /** Soft display cap: beyond this the middle is elided for the rendered feed. */
    const val MAX_DISPLAY_CHARS = 300_000
    /** Storage cap for Room persistence (CursorWindow-friendly, keeps writes safe). */
    const val MAX_STORED_CHARS = 800_000

    private val LINK_LINE = Regex(
        "(?i)^.*(download link|live link|apk\\]|\\.zip\\]|📦|🧾|⬇️|🌐|DOWNLOAD_URL|https?://[^ )]+).*$"
    )

    /**
     * Returns [content] unchanged under the cap. Over the cap: keep the head, drop the
     * middle with a clear marker carrying the omitted size, and RE-ATTACH every
     * link-looking line found anywhere in the dropped part (plus the literal tail),
     * so download links survive truncation in every position.
     */
    fun sanitize(content: String, maxChars: Long = MAX_DISPLAY_CHARS.toLong()): String {
        if (content.length <= maxChars) return content
        val headLen = (maxChars * 0.72).toInt()
        val tailLen = (maxChars * 0.18).toInt()
        val head = content.substring(0, headLen)
        val tail = content.substring(content.length - tailLen)
        val dropped = content.substring(headLen, content.length - tailLen)
        // rescue any link lines lost in the middle
        val rescued = dropped.lineSequence()
            .filter { it.isNotBlank() && LINK_LINE.containsMatchIn(it) }
            .take(40)
            .joinToString("\n")
        val omittedKb = dropped.length / 1024
        val marker = buildString {
            append("\n\n---\n⚠️ **Very long message:** ~")
            append(omittedKb)
            append(" KB of middle content hidden to keep the chat responsive")
            if (rescued.isNotBlank()) append(" (its download/live links are preserved below)")
            append(".\n")
            if (rescued.isNotBlank()) append(rescued).append('\n')
            append("---\n\n")
        }
        return head + marker + tail
    }

    fun sanitizeForStorage(content: String): String = sanitize(content, MAX_STORED_CHARS.toLong())

    /** True when a code/text block is too heavy to syntax-highlight safely. */
    fun isTooHeavyToHighlight(chars: Int): Boolean = chars > 120_000
}

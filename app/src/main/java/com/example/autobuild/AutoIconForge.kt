package com.example.autobuild

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Shader
import android.util.Log
import com.example.llm.ImageGen
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import kotlin.math.min

/**
 * Advance Auto-Builder — automatic app-icon forging.
 *
 * Every new project gets a launcher icon matched to its category, with zero taps:
 * 1. Preferred: AI-generated icon art through the user's own provider key ([ImageGen]).
 * 2. Fallback: a procedural premium icon (gradient + category glyph) drawn on-device,
 *    so icons work fully offline too.
 *
 * The icon lands at projects/<App>/app_icon.png, which [com.example.util.ProjectDataManager]
 * loads into the project and the APK compiler embeds. Icons the user set manually are
 * NEVER overwritten (they have no auto meta stamp).
 */
object AutoIconForge {
    private const val TAG = "AutoIconForge"
    const val ICON_FILE = "app_icon.png"
    private const val META_FILE = ".saif/icon_meta.json"
    const val SOURCE_AI = "ai"
    const val SOURCE_PROCEDURAL = "procedural"

    data class IconResult(
        val created: Boolean,
        val category: String,
        val source: String
    )

    private val PALETTES: Map<String, Pair<String, String>> = mapOf(
        "game" to ("#7C3AED" to "#DB2777"),
        "music" to ("#9333EA" to "#06B6D4"),
        "fitness" to ("#F97316" to "#EF4444"),
        "finance" to ("#059669" to "#0EA5E9"),
        "photo" to ("#EC4899" to "#8B5CF6"),
        "chat" to ("#0EA5E9" to "#6366F1"),
        "shop" to ("#F59E0B" to "#EF4444"),
        "travel" to ("#0284C7" to "#34D399"),
        "study" to ("#4F46E5" to "#A855F7"),
        "health" to ("#DC2626" to "#F97316"),
        "food" to ("#EA580C" to "#FACC15"),
        "video" to ("#BE123C" to "#7C3AED"),
        "app" to ("#6D28D9" to "#0EA5E9")
    )

    private val GLYPH_WORDS: Map<String, String> = mapOf(
        "game" to "game controller",
        "music" to "musical note",
        "fitness" to "flexed heart-pulse",
        "finance" to "coin with growth bars",
        "photo" to "camera",
        "chat" to "speech bubble",
        "shop" to "shopping bag",
        "travel" to "paper plane",
        "study" to "open book",
        "health" to "medical cross",
        "food" to "chef cloche",
        "video" to "play button",
        "app" to "lightning bolt"
    )

    suspend fun ensureIcon(
        context: Context,
        projectDir: File,
        appName: String,
        vision: String,
        featuresText: String,
        provider: String,
        apiKey: String,
        model: String
    ): IconResult {
        val category = IdeaExpander.detectCategory("$appName $vision $featuresText")
        val iconFile = File(projectDir, ICON_FILE)
        val metaFile = File(projectDir, META_FILE)

        // Never touch a user-set icon (existing PNG without our auto stamp).
        if (iconFile.exists() && iconFile.length() > 1024) {
            val stamped = try {
                val src = JSONObject(metaFile.readText()).optString("source")
                src == SOURCE_AI || src == SOURCE_PROCEDURAL
            } catch (_: Exception) {
                false
            }
            if (!stamped) return IconResult(created = false, category = category, source = "existing-user")
        }

        var bitmap: Bitmap? = null
        var source = SOURCE_PROCEDURAL

        // 1) AI generation through the user's own key.
        if (ImageGen.canGenerate(provider, apiKey)) {
            try {
                val art = ImageGen.generate(
                    prompt = aiIconPrompt(appName, category),
                    aspect = "1:1",
                    provider = provider,
                    apiKey = apiKey,
                    activeModel = model
                ).getOrNull()
                val decoded = art?.let { decodeSquare(it, 1024) }
                if (decoded != null) {
                    bitmap = decoded
                    source = SOURCE_AI
                }
            } catch (e: Exception) {
                Log.w(TAG, "AI icon failed, using procedural: ${e.message}")
            }
        }

        // 2) Procedural fallback — always works offline.
        if (bitmap == null) {
            bitmap = try {
                drawProceduralIcon(category, 1024)
            } catch (e: Exception) {
                Log.e(TAG, "Procedural icon failed: ${e.message}")
                null
            }
        }
        if (bitmap == null) return IconResult(created = false, category = category, source = "failed")

        return try {
            FileOutputStream(iconFile).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            metaFile.parentFile?.mkdirs()
            metaFile.writeText(
                JSONObject().apply {
                    put("category", category)
                    put("source", source)
                    put("appName", appName)
                    put("createdAt", System.currentTimeMillis())
                }.toString(2)
            )
            IconResult(created = true, category = category, source = source)
        } catch (e: Exception) {
            Log.e(TAG, "Saving icon failed: ${e.message}")
            IconResult(created = false, category = category, source = "failed")
        } finally {
            try {
                bitmap.recycle()
            } catch (_: Exception) {
            }
        }
    }

    fun aiIconPrompt(appName: String, category: String): String {
        val palette = PALETTES[category] ?: PALETTES.getValue("app")
        val glyph = GLYPH_WORDS[category] ?: "lightning bolt"
        val c1 = palette.first
        val c2 = palette.second
        return "Premium flat mobile app icon for the '$appName' $category app: one bold centered $glyph symbol in white, " +
            "smooth $c1 to $c2 gradient background, soft long shadow, modern minimal vector style, " +
            "perfectly centered, no text, no letters, no words, square 1:1"
    }

    private fun decodeSquare(bytes: ByteArray, size: Int): Bitmap? {
        return try {
            val raw = BitmapFactory.decodeByteArray(bytes, 0, bytes.size) ?: return null
            val side = min(raw.width, raw.height)
            if (side <= 0) return null
            val cropped = Bitmap.createBitmap(raw, (raw.width - side) / 2, (raw.height - side) / 2, side, side)
            val scaled = Bitmap.createScaledBitmap(cropped, size, size, true)
            if (cropped != raw) {
                try {
                    cropped.recycle()
                } catch (_: Exception) {
                }
            }
            try {
                raw.recycle()
            } catch (_: Exception) {
            }
            scaled
        } catch (e: Exception) {
            Log.w(TAG, "Icon decode failed: ${e.message}")
            null
        }
    }

    // ------------------------------------------------------------------
    // Procedural icon painter.
    // ------------------------------------------------------------------

    fun drawProceduralIcon(category: String, size: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val palette = PALETTES[category] ?: PALETTES.getValue("app")
        val c1 = Color.parseColor(palette.first)
        val c2 = Color.parseColor(palette.second)

        val bg = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = LinearGradient(0f, 0f, size.toFloat(), size.toFloat(), c1, c2, Shader.TileMode.CLAMP)
        }
        canvas.drawRect(0f, 0f, size.toFloat(), size.toFloat(), bg)

        // Soft decorative circles.
        val deco = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            alpha = 26
        }
        val s = size.toFloat()
        canvas.drawCircle(s * 0.85f, s * 0.12f, s * 0.30f, deco)
        canvas.drawCircle(s * 0.10f, s * 0.92f, s * 0.24f, deco)

        val glyph = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.FILL
            alpha = 242
        }
        val glyphStroke = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = s * 0.045f
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
            alpha = 242
        }

        when (category) {
            "game" -> drawGamepad(canvas, s, glyph)
            "music" -> drawMusicNote(canvas, s, glyph, glyphStroke)
            "fitness" -> drawHeartPulse(canvas, s, glyphStroke)
            "finance" -> drawFinance(canvas, s, glyph, glyphStroke)
            "photo" -> drawCamera(canvas, s, glyph, glyphStroke)
            "chat" -> drawChatBubble(canvas, s, glyph)
            "shop" -> drawShoppingBag(canvas, s, glyph, glyphStroke)
            "travel" -> drawPaperPlane(canvas, s, glyph)
            "study" -> drawBook(canvas, s, glyph)
            "health" -> drawMedicalCross(canvas, s, glyph)
            "food" -> drawCloche(canvas, s, glyph, glyphStroke)
            "video" -> drawPlay(canvas, s, glyph, glyphStroke)
            else -> drawBolt(canvas, s, glyph)
        }

        // Subtle inner ring for a finished look.
        val ring = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = s * 0.012f
            alpha = 70
        }
        canvas.drawRoundRect(RectF(s * 0.06f, s * 0.06f, s * 0.94f, s * 0.94f), s * 0.22f, s * 0.22f, ring)
        return bitmap
    }

    private fun drawGamepad(canvas: Canvas, s: Float, paint: Paint) {
        canvas.drawRoundRect(RectF(s * 0.18f, s * 0.36f, s * 0.82f, s * 0.68f), s * 0.14f, s * 0.14f, paint)
        val hole = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.parseColor("#4C1D95"); style = Paint.Style.FILL }
        // D-pad
        canvas.drawRect(s * 0.27f, s * 0.44f, s * 0.31f, s * 0.60f, hole)
        canvas.drawRect(s * 0.23f, s * 0.50f, s * 0.35f, s * 0.54f, hole)
        // Buttons
        canvas.drawCircle(s * 0.66f, s * 0.48f, s * 0.028f, hole)
        canvas.drawCircle(s * 0.73f, s * 0.56f, s * 0.028f, hole)
    }

    private fun drawMusicNote(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        canvas.drawLine(s * 0.62f, s * 0.28f, s * 0.62f, s * 0.62f, stroke)
        canvas.drawLine(s * 0.62f, s * 0.28f, s * 0.78f, s * 0.34f, stroke)
        canvas.drawCircle(s * 0.50f, s * 0.64f, s * 0.11f, fill)
        canvas.drawLine(s * 0.50f, s * 0.64f, s * 0.50f, s * 0.36f, stroke)
        canvas.drawLine(s * 0.50f, s * 0.36f, s * 0.62f, s * 0.28f, stroke)
    }

    private fun drawHeartPulse(canvas: Canvas, s: Float, stroke: Paint) {
        val heart = Path().apply {
            moveTo(s * 0.50f, s * 0.72f)
            cubicTo(s * 0.18f, s * 0.52f, s * 0.28f, s * 0.26f, s * 0.50f, s * 0.40f)
            cubicTo(s * 0.72f, s * 0.26f, s * 0.82f, s * 0.52f, s * 0.50f, s * 0.72f)
            close()
        }
        canvas.drawPath(heart, Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.FILL
            alpha = 242
        })
        val pulse = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#C2410C")
            style = Paint.Style.STROKE
            strokeWidth = s * 0.035f
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
        }
        val line = Path().apply {
            moveTo(s * 0.34f, s * 0.52f)
            lineTo(s * 0.44f, s * 0.52f)
            lineTo(s * 0.48f, s * 0.44f)
            lineTo(s * 0.54f, s * 0.60f)
            lineTo(s * 0.58f, s * 0.52f)
            lineTo(s * 0.68f, s * 0.52f)
        }
        canvas.drawPath(line, pulse)
    }

    private fun drawFinance(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        canvas.drawCircle(s * 0.50f, s * 0.42f, s * 0.17f, fill)
        canvas.drawCircle(s * 0.50f, s * 0.42f, s * 0.12f, stroke)
        // Growth bars
        canvas.drawRect(s * 0.30f, s * 0.62f, s * 0.38f, s * 0.74f, fill)
        canvas.drawRect(s * 0.42f, s * 0.56f, s * 0.50f, s * 0.74f, fill)
        canvas.drawRect(s * 0.54f, s * 0.48f, s * 0.62f, s * 0.74f, fill)
        // Trend arrow
        val arrow = Path().apply {
            moveTo(s * 0.64f, s * 0.52f)
            lineTo(s * 0.74f, s * 0.42f)
            lineTo(s * 0.70f, s * 0.42f)
            moveTo(s * 0.74f, s * 0.42f)
            lineTo(s * 0.74f, s * 0.48f)
        }
        canvas.drawPath(arrow, stroke)
    }

    private fun drawCamera(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        canvas.drawRoundRect(RectF(s * 0.22f, s * 0.36f, s * 0.78f, s * 0.70f), s * 0.08f, s * 0.08f, fill)
        canvas.drawCircle(s * 0.50f, s * 0.53f, s * 0.12f, stroke)
        canvas.drawCircle(s * 0.50f, s * 0.53f, s * 0.05f, fill)
        canvas.drawRoundRect(RectF(s * 0.40f, s * 0.28f, s * 0.60f, s * 0.36f), s * 0.03f, s * 0.03f, fill)
    }

    private fun drawChatBubble(canvas: Canvas, s: Float, paint: Paint) {
        canvas.drawRoundRect(RectF(s * 0.22f, s * 0.30f, s * 0.78f, s * 0.62f), s * 0.10f, s * 0.10f, paint)
        val tail = Path().apply {
            moveTo(s * 0.34f, s * 0.60f)
            lineTo(s * 0.30f, s * 0.74f)
            lineTo(s * 0.46f, s * 0.60f)
            close()
        }
        canvas.drawPath(tail, paint)
        val dot = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.parseColor("#0369A1") }
        canvas.drawCircle(s * 0.40f, s * 0.46f, s * 0.028f, dot)
        canvas.drawCircle(s * 0.50f, s * 0.46f, s * 0.028f, dot)
        canvas.drawCircle(s * 0.60f, s * 0.46f, s * 0.028f, dot)
    }

    private fun drawShoppingBag(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        val bag = Path().apply {
            moveTo(s * 0.32f, s * 0.36f)
            lineTo(s * 0.68f, s * 0.36f)
            lineTo(s * 0.62f, s * 0.72f)
            lineTo(s * 0.38f, s * 0.72f)
            close()
        }
        canvas.drawPath(bag, fill)
        canvas.drawArc(RectF(s * 0.40f, s * 0.24f, s * 0.60f, s * 0.46f), 180f, 180f, false, stroke)
    }

    private fun drawPaperPlane(canvas: Canvas, s: Float, paint: Paint) {
        val plane = Path().apply {
            moveTo(s * 0.24f, s * 0.52f)
            lineTo(s * 0.78f, s * 0.30f)
            lineTo(s * 0.56f, s * 0.74f)
            lineTo(s * 0.50f, s * 0.56f)
            close()
        }
        canvas.drawPath(plane, paint)
        val wing = Path().apply {
            moveTo(s * 0.50f, s * 0.56f)
            lineTo(s * 0.78f, s * 0.30f)
            lineTo(s * 0.56f, s * 0.56f)
            close()
        }
        canvas.drawPath(wing, Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            alpha = 140
        })
    }

    private fun drawBook(canvas: Canvas, s: Float, paint: Paint) {
        canvas.drawRoundRect(RectF(s * 0.26f, s * 0.30f, s * 0.49f, s * 0.70f), s * 0.03f, s * 0.03f, paint)
        canvas.drawRoundRect(RectF(s * 0.51f, s * 0.30f, s * 0.74f, s * 0.70f), s * 0.03f, s * 0.03f, paint)
        val line = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#4338CA")
            strokeWidth = s * 0.02f
        }
        var y = 0.40f
        while (y < 0.64f) {
            canvas.drawLine(s * 0.31f, s * y, s * 0.44f, s * y, line)
            canvas.drawLine(s * 0.56f, s * y, s * 0.69f, s * y, line)
            y += 0.07f
        }
    }

    private fun drawMedicalCross(canvas: Canvas, s: Float, paint: Paint) {
        canvas.drawRoundRect(RectF(s * 0.42f, s * 0.26f, s * 0.58f, s * 0.74f), s * 0.05f, s * 0.05f, paint)
        canvas.drawRoundRect(RectF(s * 0.26f, s * 0.42f, s * 0.74f, s * 0.58f), s * 0.05f, s * 0.05f, paint)
    }

    private fun drawCloche(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        canvas.drawArc(RectF(s * 0.26f, s * 0.36f, s * 0.74f, s * 0.68f), 180f, 180f, true, fill)
        canvas.drawLine(s * 0.24f, s * 0.68f, s * 0.76f, s * 0.68f, stroke)
        canvas.drawCircle(s * 0.50f, s * 0.34f, s * 0.03f, fill)
    }

    private fun drawPlay(canvas: Canvas, s: Float, fill: Paint, stroke: Paint) {
        canvas.drawCircle(s * 0.50f, s * 0.50f, s * 0.24f, stroke)
        val tri = Path().apply {
            moveTo(s * 0.44f, s * 0.38f)
            lineTo(s * 0.62f, s * 0.50f)
            lineTo(s * 0.44f, s * 0.62f)
            close()
        }
        canvas.drawPath(tri, fill)
    }

    private fun drawBolt(canvas: Canvas, s: Float, paint: Paint) {
        val bolt = Path().apply {
            moveTo(s * 0.56f, s * 0.22f)
            lineTo(s * 0.36f, s * 0.56f)
            lineTo(s * 0.50f, s * 0.56f)
            lineTo(s * 0.44f, s * 0.78f)
            lineTo(s * 0.64f, s * 0.44f)
            lineTo(s * 0.50f, s * 0.44f)
            close()
        }
        canvas.drawPath(bolt, paint)
    }
}

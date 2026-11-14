package com.example.autobuild

import android.util.Log
import com.example.llm.LlmGateway
import com.example.llm.LlmRequest
import com.example.llm.LlmRole
import org.json.JSONObject

/**
 * Advance Auto-Builder — Idea expansion engine.
 *
 * Turns a tiny one-line idea ("cricket game banao") into a rich, ambitious product brief so the
 * finished project is bigger and better than the user expected. Works in two layers:
 * 1. LLM expansion (when a provider key + network is available).
 * 2. Deterministic heuristic brief + static "advance packs" (always available, offline).
 */
data class IdeaBrief(
    val vision: String,
    val audience: String,
    val mustFeatures: List<String>,
    val wowFeatures: List<String>,
    val screens: List<String>,
    val designDirection: String,
    val advancedHooks: List<String>
)

object IdeaExpander {
    private const val TAG = "IdeaExpander"

    // ------------------------------------------------------------------
    // Category detection (shared with AutoIconForge).
    // ------------------------------------------------------------------

    private val CATEGORY_KEYWORDS: List<Pair<String, List<String>>> = listOf(
        "game" to listOf("game", "khel", "puzzle", "quiz", "ludo", "chess", "snake", "arcade", "score", "level", "racing", "cricket", "football", "player vs", "multiplayer", "shooter", "runner", "board game", "card game"),
        "music" to listOf("music", "song", "gana", "audio player", "dj", "radio", "lyrics", "sargam", "guitar", "piano", "beats", "playlist"),
        "fitness" to listOf("fitness", "gym", "workout", "exercise", "yoga", "run", "steps", "calories", "weight", "diet"),
        "finance" to listOf("finance", "money", "budget", "expense", "kharcha", "emi", "loan", "bank", "paise", "salary", "investment", "sip"),
        "photo" to listOf("photo", "camera", "gallery", "image", "picture", "wallpaper", "editor", "filter", "selfie"),
        "chat" to listOf("chat", "message", "talk", "friend", "social", "comment", "community", "baat"),
        "shop" to listOf("shop", "store", "cart", "dukaan", "buy", "sell", "order", "product", "bazaar", "market"),
        "travel" to listOf("travel", "trip", "tour", "hotel", "flight", "yatra", "ghumo", "map ", "places", "ticket"),
        "study" to listOf("study", "school", "exam", "padhai", "notes", "quiz", "course", "learn", "student", "teacher", "class", "homework"),
        "health" to listOf("health", "doctor", "medicine", "dawai", "hospital", "symptom", "sehat", "patient", "appointment"),
        "food" to listOf("food", "recipe", "khana", "restaurant", "cooking", "kitchen", "meal", "dish", "hotel menu", "dhaba"),
        "video" to listOf("video", "movie", "film", "reels", "youtube", "cinema", "watch", "stream")
    )

    fun detectCategory(text: String): String {
        val lower = text.lowercase()
        var best = "app"
        var bestScore = 0
        for ((category, words) in CATEGORY_KEYWORDS) {
            var score = 0
            for (word in words) {
                if (lower.contains(word)) score++
            }
            if (score > bestScore) {
                bestScore = score
                best = category
            }
        }
        return best
    }

    // ------------------------------------------------------------------
    // Static advance packs: advanced capabilities injected when a spec is thin.
    // ------------------------------------------------------------------

    private val ADVANCE_PACKS: Map<String, List<String>> = mapOf(
        "game" to listOf(
            "Multiple difficulty levels (easy / medium / hard) with adaptive challenge",
            "Local leaderboard + personal best records with dates",
            "Daily challenges and achievement badges with unlock animations",
            "Pause / resume with state restore even after app restart",
            "Sound effects + haptic feedback with in-app mute controls",
            "2-player pass-and-play mode on the same phone",
            "Game statistics dashboard (wins, streaks, accuracy graphs)"
        ),
        "music" to listOf(
            "Playlists with create / rename / reorder and favourites",
            "Sleep timer and playback speed controls",
            "Recently played history with quick resume",
            "Offline-first library that works without internet",
            "Beautiful now-playing screen with animated visualizer",
            "Search across titles with instant filtering"
        ),
        "fitness" to listOf(
            "Workout plans for beginner / intermediate / advanced",
            "Progress charts (weekly volume, streaks, personal records)",
            "Rest timer with sound + vibration alerts",
            "Exercise library with step-by-step form guidance",
            "Streak calendar and achievement badges",
            "Offline-first: everything works without internet"
        ),
        "finance" to listOf(
            "Income vs expense dashboard with monthly charts",
            "Category budgets with overspend warnings",
            "Recurring transactions (salary, EMI, subscriptions)",
            "Search + filters by date, category and amount",
            "Data export / backup and restore",
            "Savings goals with progress rings"
        ),
        "photo" to listOf(
            "Favourites / albums organisation with search",
            "Built-in filters and quick edits (crop, rotate, brightness)",
            "Slideshow mode with transitions",
            "Details view with metadata",
            "Offline-first gallery that never needs internet"
        ),
        "chat" to listOf(
            "Multiple conversations with unread badges",
            "Search across all messages",
            "Favourites / pinned messages",
            "Typing-style animated responses and message status ticks",
            "Chat export and backup"
        ),
        "shop" to listOf(
            "Product catalogue with categories, search and filters",
            "Cart with quantity controls and bill summary",
            "Order history with reorder in one tap",
            "Wishlist / favourites",
            "Discount coupons and price sorting"
        ),
        "travel" to listOf(
            "Trip planner with day-wise itinerary",
            "Saved places with categories and notes",
            "Budget tracker per trip with charts",
            "Packing checklist with progress",
            "Offline access to saved trips"
        ),
        "study" to listOf(
            "Smart revision with spaced-repetition reminders",
            "Chapter-wise progress tracking with streaks",
            "Flashcards with flip animations",
            "Mock tests with timer and score analysis",
            "Doubt notes with search"
        ),
        "health" to listOf(
            "Medicine reminders with time slots",
            "Health readings log with trend charts",
            "Appointment tracker with upcoming alerts",
            "Emergency info card always one tap away",
            "Reports / prescription organiser"
        ),
        "food" to listOf(
            "Recipe book with categories, search and favourites",
            "Step-by-step cooking mode with timers",
            "Ingredient checklist with servings scaler",
            "Weekly meal planner",
            "Shopping list generated from recipes"
        ),
        "video" to listOf(
            "Continue-watching with resume positions",
            "Watchlist and favourites",
            "Categories with search and filters",
            "Playback speed + sleep timer",
            "Watch history with clear option"
        )
    )

    private val DEFAULT_PACK: List<String> = listOf(
        "Dashboard with search, filters and favourites",
        "Detailed statistics with animated charts",
        "Dark / light theme switcher",
        "First-run guided tour with empty states",
        "Offline-first with automatic local backup",
        "Data export and share"
    )

    fun advancePackFor(category: String): List<String> =
        ADVANCE_PACKS[category] ?: DEFAULT_PACK

    fun universalAdvancePack(): List<String> = listOf(
        "Works fully offline with local data persistence",
        "Animated statistics dashboard with charts",
        "Dark / light OLED-friendly theme switcher",
        "Guided first-run tour + helpful empty states",
        "Global search with instant results",
        "Achievement / streak system to keep users returning",
        "One-tap data backup, export and share",
        "Haptic touch feedback + subtle sound effects with mute control"
    )

    // ------------------------------------------------------------------
    // LLM expansion with deterministic fallback.
    // ------------------------------------------------------------------

    suspend fun expand(
        appName: String,
        prompt: String,
        provider: String,
        apiKey: String,
        model: String
    ): IdeaBrief {
        if (apiKey.isBlank()) return heuristicBrief(appName, prompt)
        return try {
            val system = """
                You are a world-class product visionary for SAIF AI. A user gave a tiny raw idea.
                Expand it into an AMBITIOUS but buildable mobile-app brief that goes far beyond what
                they asked for. Reply with ONLY valid JSON, no markdown:
                {"vision":"...","audience":"...","mustFeatures":["...8 to 14 items..."],"wowFeatures":["...3 to 5 surprising delights..."],"screens":["...4 to 7..."],"designDirection":"...","advancedHooks":["..."]}
            """.trimIndent()
            val req = LlmRequest(
                prompt = "App name: $appName\nRaw idea: $prompt",
                systemPrompt = system,
                mode = "coding",
                jsonMode = true
            )
            val text = LlmGateway.call(LlmRole.PLANNER, provider, apiKey, model, req).getOrNull()?.text.orEmpty()
            parseBriefJson(text) ?: heuristicBrief(appName, prompt)
        } catch (e: Exception) {
            Log.w(TAG, "Idea expansion fell back to heuristic: ${e.message}")
            heuristicBrief(appName, prompt)
        }
    }

    private fun parseBriefJson(raw: String): IdeaBrief? {
        return try {
            val clean = raw.trim().removePrefix("```json").removePrefix("```").removeSuffix("```").trim()
            val start = clean.indexOf('{')
            val end = clean.lastIndexOf('}')
            if (start == -1 || end <= start) return null
            val json = JSONObject(clean.substring(start, end + 1))
            fun strArray(key: String): List<String> {
                val arr = json.optJSONArray(key) ?: return emptyList()
                return (0 until arr.length()).mapNotNull { arr.optString(it).takeIf { s -> s.isNotBlank() } }
            }
            val must = strArray("mustFeatures")
            if (must.size < 4) return null
            IdeaBrief(
                vision = json.optString("vision", ""),
                audience = json.optString("audience", "Mobile users"),
                mustFeatures = must,
                wowFeatures = strArray("wowFeatures"),
                screens = strArray("screens").ifEmpty { listOf("home", "main", "stats", "settings") },
                designDirection = json.optString("designDirection", ""),
                advancedHooks = strArray("advancedHooks")
            )
        } catch (e: Exception) {
            Log.w(TAG, "Brief JSON parse failed: ${e.message}")
            null
        }
    }

    /**
     * Deterministic offline brief: guarantees at least 10 must-features and 3 wow-features
     * even with no network / no API key.
     */
    fun heuristicBrief(appName: String, prompt: String): IdeaBrief {
        val category = detectCategory("$appName $prompt")
        val pack = advancePackFor(category)
        val universal = universalAdvancePack()
        val must = (pack.take(6) + universal.take(4)).distinct()
        val wow = listOf(
            "Delightful launch animation personalised for $appName",
            "Smart suggestions based on how the user actually uses the app",
            "Celebration moments (confetti, level-ups) for real achievements"
        )
        val screens = when (category) {
            "game" -> listOf("home", "play", "leaderboard", "achievements", "settings")
            "study" -> listOf("home", "learn", "revise", "progress", "settings")
            "fitness" -> listOf("home", "workout", "plans", "progress", "settings")
            "finance" -> listOf("home", "add", "budgets", "insights", "settings")
            "shop" -> listOf("home", "catalogue", "cart", "orders", "settings")
            else -> listOf("home", "main", "stats", "favourites", "settings")
        }
        return IdeaBrief(
            vision = "A premium, powerful $category experience for '$appName' built from: $prompt",
            audience = "Everyday mobile users",
            mustFeatures = must,
            wowFeatures = wow,
            screens = screens,
            designDirection = "Premium mobile-first $category aesthetic, unique palette, rich motion, 44px touch targets",
            advancedHooks = universal.take(4)
        )
    }

    /**
     * Renders the brief as strict guidance text injected into the spec architect prompt.
     */
    fun toGuidance(brief: IdeaBrief): String {
        return buildString {
            appendLine("EXPANDED PRODUCT BRIEF (follow it strictly, exceed it where possible):")
            appendLine("Vision: ${brief.vision}")
            appendLine("Audience: ${brief.audience}")
            appendLine("Design: ${brief.designDirection}")
            appendLine("Screens: ${brief.screens.joinToString(", ")}")
            appendLine("MUST features (implement ALL):")
            brief.mustFeatures.forEach { appendLine("- $it") }
            if (brief.wowFeatures.isNotEmpty()) {
                appendLine("WOW delights (implement at least 2):")
                brief.wowFeatures.forEach { appendLine("- $it") }
            }
            if (brief.advancedHooks.isNotEmpty()) {
                appendLine("Advanced hooks:")
                brief.advancedHooks.forEach { appendLine("- $it") }
            }
            appendLine("AMBITION RULE: a short user idea must still produce a deep, complete, premium app. Never deliver a thin demo.")
        }.trim()
    }
}

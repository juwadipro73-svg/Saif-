package com.example.autobuild

/**
 * Advance Auto-Builder — deep quality auditor.
 *
 * Scores every build 0-100 from deterministic signals (sandbox results, spec richness,
 * document depth) and produces actionable fix instructions for the automatic
 * improvement rounds. Pure Kotlin: no Android dependencies, fully unit-tested.
 */
data class QualityAudit(
    val score: Int,
    val grade: String,
    val strengths: List<String>,
    val findings: List<String>,
    val mustFix: List<String>,
    val featureCount: Int,
    val screenCount: Int
) {
    fun needsImprovement(): Boolean = score < DeepQualityAudit.TARGET_SCORE || mustFix.isNotEmpty()
}

object DeepQualityAudit {
    const val TARGET_SCORE = 82
    private const val MIN_FEATURES = 8
    private const val MIN_SCREENS = 3

    fun audit(
        specFeatures: Int,
        screens: Int,
        html: String,
        passedCount: Int,
        totalCount: Int,
        jsErrors: List<String>,
        failedProbes: List<String>,
        blankScreen: Boolean,
        horizontalOverflow: Boolean,
        smallTapTargets: Int
    ): QualityAudit {
        var score = 100
        val strengths = mutableListOf<String>()
        val findings = mutableListOf<String>()
        val mustFix = mutableListOf<String>()

        // ---- Sandbox results (heaviest weight) ----
        if (totalCount > 0) {
            val passRate = passedCount.toDouble() / totalCount.toDouble()
            when {
                passRate >= 1.0 -> strengths.add("All $totalCount sandbox checks passed")
                passRate >= 0.8 -> {
                    score -= 8
                    findings.add("Sandbox pass rate ${passedCount}/${totalCount} — close, needs a final touch")
                }
                else -> {
                    score -= 22
                    mustFix.add("Raise sandbox verification from ${passedCount}/${totalCount} to 100% without breaking existing features")
                }
            }
        }

        if (jsErrors.isEmpty()) {
            strengths.add("Zero JavaScript runtime errors")
        } else {
            score -= (jsErrors.size * 8).coerceAtMost(24)
            mustFix.add("Fix JavaScript errors: ${jsErrors.take(2).joinToString(" | ")}")
        }

        if (failedProbes.isEmpty()) {
            strengths.add("All expected UI elements present in DOM")
        } else {
            score -= (failedProbes.size * 5).coerceAtMost(20)
            mustFix.add("These expected elements are missing from the app, add them: ${failedProbes.take(5).joinToString(", ")}")
        }

        if (blankScreen) {
            score -= 30
            mustFix.add("CRITICAL: the app opens to a blank screen — render real visible content immediately on load")
        }

        if (horizontalOverflow) {
            score -= 5
            findings.add("Horizontal overflow on mobile viewport — constrain wide elements")
        }

        if (smallTapTargets > 0) {
            score -= smallTapTargets.coerceAtMost(5)
            findings.add("$smallTapTargets tap targets smaller than 38px — grow to 44px minimum")
        }

        // ---- Spec richness ----
        when {
            specFeatures >= MIN_FEATURES -> strengths.add("$specFeatures features specified")
            specFeatures >= 4 -> {
                score -= 10
                mustFix.add("Only $specFeatures features exist — expand to at least $MIN_FEATURES deep, working capabilities (offline mode, stats, themes, achievements, search, favourites)")
            }
            else -> {
                score -= 20
                mustFix.add("Only $specFeatures features exist — this is too thin. Expand to at least $MIN_FEATURES deep, working capabilities (offline mode, stats, themes, achievements, search, favourites)")
            }
        }

        if (screens >= MIN_SCREENS) {
            strengths.add("$screens screens/tabs")
        } else {
            score -= 5
            findings.add("Only $screens screens — add at least $MIN_SCREENS for a complete app feel")
        }

        // ---- Document depth ----
        val sizeKb = html.length / 1024
        when {
            sizeKb >= 60 -> strengths.add("Rich app bundle (~${sizeKb}KB)")
            sizeKb >= 25 -> findings.add("App bundle is moderate (~${sizeKb}KB) — deepen interactions and content")
            html.isNotBlank() -> {
                score -= 12
                mustFix.add("App bundle is too thin (~${sizeKb}KB) — expand into a full premium experience with real content and interactions")
            }
            else -> {
                score -= 25
                mustFix.add("CRITICAL: no app document was produced — generate the complete app")
            }
        }

        val lower = html.lowercase()
        if (lower.contains("localstorage") || lower.contains("indexeddb")) {
            strengths.add("Local persistence present")
        } else if (html.isNotBlank()) {
            score -= 5
            findings.add("No local persistence detected — save user data with localStorage")
        }

        if (lower.contains("@keyframes") || lower.contains("animation:") || lower.contains("transition:")) {
            strengths.add("Animations and motion present")
        } else if (html.isNotBlank()) {
            score -= 5
            findings.add("No animations detected — add entrances, transitions and micro-interactions")
        }

        val buttonCount = Regex("<button", RegexOption.IGNORE_CASE).findAll(html).count() +
            Regex("role=[\"']button[\"']", RegexOption.IGNORE_CASE).findAll(html).count()
        if (buttonCount >= 5) {
            strengths.add("$buttonCount interactive controls")
        } else if (html.isNotBlank()) {
            score -= 5
            findings.add("Only $buttonCount interactive controls — add more working actions")
        }

        if (!lower.contains("viewport")) {
            score -= 3
            findings.add("Missing viewport meta tag for mobile scaling")
        }

        val finalScore = score.coerceIn(0, 100)
        val grade = when {
            finalScore >= 95 -> "S"
            finalScore >= 82 -> "A"
            finalScore >= 65 -> "B"
            finalScore >= 45 -> "C"
            else -> "D"
        }
        return QualityAudit(
            score = finalScore,
            grade = grade,
            strengths = strengths,
            findings = findings,
            mustFix = mustFix.take(6),
            featureCount = specFeatures,
            screenCount = screens
        )
    }

    /**
     * Builds the continue-forward improvement prompt for the next automatic pass.
     */
    fun improvementPrompt(audit: QualityAudit): String {
        return buildString {
            appendLine("Continue improving this app (current quality ${audit.score}/100, grade ${audit.grade}).")
            appendLine("CONTINUE-FORWARD RULES (strict):")
            appendLine("1. Keep EVERY existing feature working exactly as before — never remove or redesign unless asked below.")
            appendLine("2. Only ADD the missing quality listed below, surgically, with minimal changes to existing code.")
            appendLine("3. The app must still run with zero console errors after your changes.")
            appendLine("Fix now:")
            audit.mustFix.forEach { appendLine("- $it") }
            audit.findings.take(4).forEach { appendLine("- Polish: $it") }
        }.trim()
    }
}

/* Copyright (c) SAIF AI. All rights reserved. */

package com.saifai.brand

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

/**
 * The dynamic app icon.
 *
 * SAIF AI does not ship a static PNG launcher icon. Instead the adaptive icon is tinted at
 * runtime from a palette that rotates every [ROTATION_INTERVAL_MS] (two hours by default) so the
 * launcher icon slowly changes colour through the day without ever re-compiling the APK.
 *
 * The rotation is deterministic: it is derived from the current wall clock, so the icon always
 * shows the same colour for every device and after every reboot - no state has to be persisted
 * and no work has to be scheduled.
 *
 * Only the adaptive (API 26+) icon is tinted. On older launchers the static fallback is used.
 */
object DynamicAppIcon {

    /** Two hours. */
    const val ROTATION_INTERVAL_MS: Long = 2L * 60L * 60L * 1000L

    /**
     * The palette the icon rotates through. Each entry is (background top, background bottom,
     * foreground tint, spark tint).
     */
    data class Palette(
        val top: Int,
        val bottom: Int,
        val foreground: Int,
        val spark: Int
    )

    private val PALETTES = listOf(
        Palette(Color.parseColor("#FF6D8BFF"), Color.parseColor("#FF3D2E8F"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFC7D2FE")),
        Palette(Color.parseColor("#FF2DD4BF"), Color.parseColor("#FF0F766E"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFCCFBF1")),
        Palette(Color.parseColor("#FFFB7185"), Color.parseColor("#FF9F1239"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFFECDD3")),
        Palette(Color.parseColor("#FFFBBF24"), Color.parseColor("#FFB45309"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFFEF3C7")),
        Palette(Color.parseColor("#FF34D399"), Color.parseColor("#FF065F46"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFD1FAE5")),
        Palette(Color.parseColor("#FFA78BFA"), Color.parseColor("#FF5B21B6"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFEDE9FE")),
        Palette(Color.parseColor("#FF38BDF8"), Color.parseColor("#FF0C4A6E"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFE0F2FE")),
        Palette(Color.parseColor("#FFFB7185"), Color.parseColor("#FF4C1D95"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFFBCFE8"))
    )

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val _currentSlot = MutableStateFlow(currentSlotIndex())
    val currentSlot: StateFlow<Int> = _currentSlot.asStateFlow()

    /** The palette currently shown. */
    val currentPalette: Palette
        get() = PALETTES[_currentSlot.value % PALETTES.size]

    /**
     * The index of the palette slot for the given wall-clock time. Two hours per slot, anchored on
     * the local midnight so the icon changes at a predictable time of day.
     */
    fun slotIndexFor(nowMs: Long): Int {
        val cal = Calendar.getInstance()
        cal.timeInMillis = nowMs
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        val midnight = cal.timeInMillis
        val elapsed = (nowMs - midnight).coerceAtLeast(0L)
        return ((elapsed / ROTATION_INTERVAL_MS).toInt())
    }

    private fun currentSlotIndex(): Int = slotIndexFor(System.currentTimeMillis())

    /**
     * Starts the background rotation. Safe to call more than once.
     */
    fun start(context: Context) {
        val appContext = context.applicationContext
        scope.launch {
            while (true) {
                val slot = currentSlotIndex()
                if (slot != _currentSlot.value) {
                    _currentSlot.value = slot
                    applyPalette(appContext)
                }
                // Wake up a little before the next boundary so the switch is never late.
                val msToNext = millisUntilNextSlot()
                kotlinx.coroutines.delay(msToNext.coerceAtLeast(30_000L))
            }
        }
    }

    private fun millisUntilNextSlot(): Long {
        val now = System.currentTimeMillis()
        val slot = slotIndexFor(now)
        val nextBoundary = now - (now % ROTATION_INTERVAL_MS) + ROTATION_INTERVAL_MS
        return nextBoundary - now
    }

    /**
     * Applies the current palette to the installed adaptive icon. Failures are ignored: a launcher
     * that refuses the update keeps showing the previous icon, which is perfectly acceptable.
     */
    fun applyPalette(context: Context) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.Q) return
        val packageManager = context.packageManager
        val packageName = context.packageName
        val palette = currentPalette
        runCatching {
            val appInfo = packageManager.getApplicationInfo(packageName, 0)
            val resources = packageManager.getResourcesForApplication(appInfo)
            val drawable = resources.getDrawable(
                resources.getIdentifier("ic_launcher", "mipmap", packageName),
                null
            )
            if (drawable is AdaptiveIconDrawable) {
                val background = drawable.background.mutate()
                DrawableCompat.setTint(background, palette.top)
                val foreground = drawable.foreground.mutate()
                DrawableCompat.setTint(foreground, palette.foreground)
                drawable.setBounds(0, 0, 108, 108)
                // API 29+: replaces the icon the launcher shows for this package.
                packageManager.setApplicationIconSetting(packageName, drawable)
            }
        }
    }

    /**
     * The tint the in-app brand mark should use, so the icon on the home screen and the icon inside
     * the app always agree.
     */
    fun brandAccent(): Int = currentPalette.top

    /** Package manager helper that stays available below API 29. */
    @Suppress("unused")
    private fun legacySetIcon(packageManager: PackageManager, packageName: String, drawable: android.graphics.drawable.Drawable) {
        runCatching {
            val activity = packageManager.getLaunchIntentForPackage(packageName)
            activity?.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}

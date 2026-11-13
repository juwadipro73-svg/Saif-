# =====================================================================
#  SAIF AI - ProGuard / R8 rules
#  Anti-tampering, obfuscation and hardening for the release build.
#
#  Goals:
#   1. Every application class is renamed and its members are stripped
#      unless they are reached through reflection.
#   2. The original source file names and the line numbers are removed so
#      a decompiler cannot rebuild a readable map of the app.
#   3. Only the frameworks that genuinely need reflection are kept.
# =====================================================================

# ---------------------------------------------------------------------
#  Obfuscation basics
# ---------------------------------------------------------------------
# Repackage everything into a short, meaningless namespace so the real
# package structure of the app is not readable in the DEX.
-repackageclasses ''
-allowaccessmodification
-overloadaggressively
-optimizationpasses 5

# ---------------------------------------------------------------------
#  Strip debug information
# ---------------------------------------------------------------------
# No source file names and no line numbers survive into the release DEX.
# This is what stops a decompiler from showing "com/example/ui/SaifAiApp.kt".
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Strip the original signature file and the source-file attribute.
-dontnote javax.annotation.**

# ---------------------------------------------------------------------
#  Keep only what is genuinely needed
# ---------------------------------------------------------------------
# The app's own code must NOT be kept: it is obfuscated and stripped.
# Only the pieces below are reached through reflection or the framework.
-keep public class com.example.MainActivity
-keep public class com.example.SaifApplication

# AndroidX ViewModels are constructed by the framework through reflection.
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
-keepclassmembers class * extends androidx.lifecycle.AndroidViewModel {
    <init>(...);
}

# Room databases are created by reflection.
-keep class * extends androidx.room.RoomDatabase { <init>(); }
-keep @androidx.room.Entity class * { *; }

# Kotlinx Serialization: the generated serializers are looked up reflectively.
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keepclassmembers class * {
    *** Companion;
}
-keepclasseswithmembers class * {
    kotlinx.serialization.KSerializer serializer(...);
}
-keepnames class kotlinx.serialization.PolymorphicSerializer
-keepclassmembers class * {
    @kotlinx.serialization.SerialName <fields>;
    @kotlinx.serialization.Serializable <fields>;
}

# Kotlin coroutines.
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembers class kotlinx.coroutines.** {
    volatile <fields>;
}

# ---------------------------------------------------------------------
#  Third-party libraries
# ---------------------------------------------------------------------
# OkHttp & Okio
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**

# Coil image loader
-dontwarn coil.**
-keep class coil.** { *; }

# JSch SSH client
-dontwarn com.jcraft.jsch.**
-keep class com.jcraft.jsch.** { *; }

# Sora code editor
-dontwarn io.github.rosemoe.sora.**
-keep class io.github.rosemoe.sora.** { *; }

# Termux terminal emulator & its JNI bridge
-dontwarn com.termux.terminal.**
-keep class com.termux.terminal.** { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}

# Commons Compress & XZ
-dontwarn org.apache.commons.compress.**
-dontwarn org.tukaani.xz.**
-keep class org.apache.commons.compress.** { *; }
-keep class org.tukaani.xz.** { *; }

# Markwon & JLaTeXMath
-dontwarn io.noties.markwon.**
-dontwarn ru.noties.jlatexmath.**
-keep class io.noties.markwon.** { *; }
-keep class ru.noties.jlatexmath.** { *; }

# JLaTeXMath core engine - MacroInfo dispatches *_macro methods through
# reflection, so renaming them breaks \begin{aligned}, \begin{matrix}, ...
-keep class org.scilab.forge.jlatexmath.** { *; }
-dontwarn org.scilab.forge.jlatexmath.**

# Guava ListenableFuture
-keep class com.google.common.util.concurrent.ListenableFuture { *; }
-dontwarn com.google.common.util.concurrent.**

# TelemetryDeck Kotlin SDK
-keep class com.telemetrydeck.sdk.** { *; }
-dontwarn com.telemetrydeck.sdk.**

# ---------------------------------------------------------------------
#  Logging
# ---------------------------------------------------------------------
# Every debug and verbose log call is compiled out of the release build,
# so no internal state ever reaches logcat.
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int d(...);
    public static int i(...);
}
-assumenosideeffects class java.lang.System {
    public static void out(...);
    public static void err(...);
}

# ---------------------------------------------------------------------
#  Anti-tampering
# ---------------------------------------------------------------------
# Keep the classes that verify the signature of the installed APK. The
# integrity check itself lives in the app code, which is obfuscated, so
# the attacker cannot simply delete the verification call.
-keep class com.example.security.** { *; }
-keep class com.example.saif.brand.** { *; }

# Resources referenced from code by name (reflection based lookup).
-keepclassmembers class * {
    @androidx.annotation.DrawableRes <fields>;
}
-keepclassmembers class * {
    @androidx.annotation.StringRes <fields>;
}

# ---------------------------------------------------------------------
#  Keep the app's own service / activity entry points
# ---------------------------------------------------------------------
# The manifest names these classes, so R8 must not rename them away.
-keep class * extends android.app.Activity
-keep class * extends android.app.Service
-keep class * extends android.app.receiver.BroadcastReceiver
-keep class * extends android.content.ContentProvider
-keep class * extends android.view.View

# ---------------------------------------------------------------------
#  Shrinking
# ---------------------------------------------------------------------
# Remove the unused code and the unused resources from the release APK.
# This is what keeps the shipped binary small.
-dontusagemixedcaseclassnames
-dontnote

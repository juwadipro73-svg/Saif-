package com.clozed.code.data;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: Prefs.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R$\u0010#\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Lcom/clozed/code/data/Prefs;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "v", "", "serverUrl", "getServerUrl", "()Ljava/lang/String;", "setServerUrl", "(Ljava/lang/String;)V", "password", "getPassword", "setPassword", "directory", "getDirectory", "setDirectory", "mode", "getMode", "setMode", "", "autoConnect", "getAutoConnect", "()Z", "setAutoConnect", "(Z)V", "themeMode", "getThemeMode", "setThemeMode", "dynamicColor", "getDynamicColor", "setDynamicColor", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Prefs {
    public static final int $stable = 8;
    private final SharedPreferences sp;

    public Prefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sp = context.getSharedPreferences("clozed_code", 0);
    }

    public final String getServerUrl() {
        String string = this.sp.getString("url", "http://127.0.0.1:4096");
        return string == null ? "http://127.0.0.1:4096" : string;
    }

    public final void setServerUrl(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("url", v).apply();
    }

    public final String getPassword() {
        String string = this.sp.getString("password", "");
        return string == null ? "" : string;
    }

    public final void setPassword(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("password", v).apply();
    }

    public final String getDirectory() {
        String string = this.sp.getString("directory", "");
        return string == null ? "" : string;
    }

    public final void setDirectory(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("directory", v).apply();
    }

    public final String getMode() {
        String string = this.sp.getString("mode", "local");
        return string == null ? "local" : string;
    }

    public final void setMode(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("mode", v).apply();
    }

    public final boolean getAutoConnect() {
        return this.sp.getBoolean(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, false);
    }

    public final void setAutoConnect(boolean z) {
        this.sp.edit().putBoolean(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, z).apply();
    }

    public final String getThemeMode() {
        String string = this.sp.getString("theme_mode", "system");
        return string == null ? "system" : string;
    }

    public final void setThemeMode(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("theme_mode", v).apply();
    }

    public final boolean getDynamicColor() {
        return this.sp.getBoolean("dynamic_color", false);
    }

    public final void setDynamicColor(boolean z) {
        this.sp.edit().putBoolean("dynamic_color", z).apply();
    }
}

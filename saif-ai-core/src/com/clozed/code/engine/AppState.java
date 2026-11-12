package com.clozed.code.engine;

import kotlin.Metadata;

/* compiled from: AgentService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/AppState;", "", "<init>", "()V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AppState {
    private static volatile boolean foreground;
    public static final AppState INSTANCE = new AppState();
    public static final int $stable = 8;

    private AppState() {
    }

    public final boolean getForeground() {
        return foreground;
    }

    public final void setForeground(boolean z) {
        foreground = z;
    }
}

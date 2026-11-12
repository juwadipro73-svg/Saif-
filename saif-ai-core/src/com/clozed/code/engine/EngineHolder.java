package com.clozed.code.engine;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/clozed/code/engine/EngineHolder;", "", "<init>", "()V", "engine", "Lcom/clozed/code/engine/LocalBackend;", "getEngine", "()Lcom/clozed/code/engine/LocalBackend;", "setEngine", "(Lcom/clozed/code/engine/LocalBackend;)V", "get", "context", "Landroid/content/Context;", "dir", "Ljava/io/File;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class EngineHolder {
    private static volatile LocalBackend engine;
    public static final EngineHolder INSTANCE = new EngineHolder();
    public static final int $stable = 8;

    private EngineHolder() {
    }

    public final LocalBackend getEngine() {
        return engine;
    }

    public final void setEngine(LocalBackend localBackend) {
        engine = localBackend;
    }

    public final synchronized LocalBackend get(Context context, File dir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Context applicationContext = context.getApplicationContext();
        Llm.INSTANCE.setAppContext(applicationContext);
        Notifier notifier = Notifier.INSTANCE;
        Intrinsics.checkNotNull(applicationContext);
        notifier.ensureChannels(applicationContext);
        dir.mkdirs();
        LocalBackend localBackend = engine;
        if (localBackend != null) {
            localBackend.setDefaultDir(dir);
            return localBackend;
        }
        LocalBackend localBackend2 = new LocalBackend(applicationContext, dir);
        engine = localBackend2;
        return localBackend2;
    }
}

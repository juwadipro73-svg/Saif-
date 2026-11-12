package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend", f = "LocalBackend.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {1073, 1132, 1186, 1246, 1263}, m = "step", n = {"this", "s", "host", "reason", "agent", "provider", "modelId", NotificationCompat.CATEGORY_MESSAGE, "cands", "tools", "final", "this", "s", "host", "reason", "agent", "provider", "modelId", NotificationCompat.CATEGORY_MESSAGE, "cands", "tools", "turns", "catModel", "req", "acc", "toolParts", "sync", "final", "ci", "emptyTries", "slimLeft", "this", "s", "host", "reason", "agent", "provider", "modelId", NotificationCompat.CATEGORY_MESSAGE, "cands", "tools", "turns", "catModel", "req", "acc", "toolParts", "sync", "final", "ci", "emptyTries", "slimLeft", "this", "s", "host", "agent", NotificationCompat.CATEGORY_MESSAGE, "tools", "catModel", "acc", "toolParts", "c", "tp"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$step$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$step$1(LocalBackend localBackend, Continuation<? super LocalBackend$step$1> continuation) {
        super(continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object step;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        step = this.this$0.step(null, null, false, null, this);
        return step;
    }
}

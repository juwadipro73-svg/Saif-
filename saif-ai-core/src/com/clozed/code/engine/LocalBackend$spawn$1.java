package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend", f = "LocalBackend.kt", i = {0, 0, 0, 0, 0}, l = {1278}, m = "spawn", n = {"this", "host", "onUndo", "sub", "steps"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$spawn$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$spawn$1(LocalBackend localBackend, Continuation<? super LocalBackend$spawn$1> continuation) {
        super(continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object spawn;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        spawn = this.this$0.spawn(null, null, null, null, null, this);
        return spawn;
    }
}

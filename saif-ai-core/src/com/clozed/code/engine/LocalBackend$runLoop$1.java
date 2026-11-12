package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend", f = "LocalBackend.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3}, l = {991, 995, 997, 1000}, m = "runLoop", n = {"this", "s", "this", "s", "steps", "this", "s", "steps", "this", "s"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$runLoop$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$runLoop$1(LocalBackend localBackend, Continuation<? super LocalBackend$runLoop$1> continuation) {
        super(continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runLoop = this.this$0.runLoop(null, this);
        return runLoop;
    }
}

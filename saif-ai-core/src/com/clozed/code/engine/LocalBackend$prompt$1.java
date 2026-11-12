package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend", f = "LocalBackend.kt", i = {0, 0, 2, 2, 3, 3, 3, 3}, l = {522, 529, 535, 559}, m = "prompt", n = {"this", "s", "this", "id", "this", "id", "s", "t"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$prompt$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$prompt$1(LocalBackend localBackend, Continuation<? super LocalBackend$prompt$1> continuation) {
        super(continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.prompt(null, null, null, this);
    }
}

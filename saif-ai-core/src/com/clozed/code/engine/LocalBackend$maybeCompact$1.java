package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend", f = "LocalBackend.kt", i = {0}, l = {1342}, m = "maybeCompact", n = {"s"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$maybeCompact$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$maybeCompact$1(LocalBackend localBackend, Continuation<? super LocalBackend$maybeCompact$1> continuation) {
        super(continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object maybeCompact;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        maybeCompact = this.this$0.maybeCompact(null, this);
        return maybeCompact;
    }
}

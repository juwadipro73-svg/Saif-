package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Llm.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.Llm", f = "Llm.kt", i = {0, 0}, l = {151, 154}, m = "waitForNetwork", n = {"this", "waited"}, s = {"L$0", "J$0"})
/* loaded from: /tmp/classes3.dex */
public final class Llm$waitForNetwork$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Llm this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Llm$waitForNetwork$1(Llm llm, Continuation<? super Llm$waitForNetwork$1> continuation) {
        super(continuation);
        this.this$0 = llm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForNetwork;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitForNetwork = this.this$0.waitForNetwork(this);
        return waitForNetwork;
    }
}

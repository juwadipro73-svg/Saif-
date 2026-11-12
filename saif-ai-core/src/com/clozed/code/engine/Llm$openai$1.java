package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Llm.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.Llm", f = "Llm.kt", i = {0}, l = {336}, m = "openai", n = {"onChange"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class Llm$openai$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Llm this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Llm$openai$1(Llm llm, Continuation<? super Llm$openai$1> continuation) {
        super(continuation);
        this.this$0 = llm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object openai;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        openai = this.this$0.openai(null, null, null, this);
        return openai;
    }
}

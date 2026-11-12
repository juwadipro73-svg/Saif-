package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Llm.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.Llm", f = "Llm.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {164, ByteCode.ANEWARRAY, ByteCode.ANEWARRAY}, m = "stream", n = {"this", "req", "acc", "onChange", "failFast", "attempt", "offlineWaits", "this", "req", "acc", "onChange", "failFast", "attempt", "offlineWaits", "this", "req", "acc", "onChange", "failFast", "attempt", "offlineWaits"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1"})
/* loaded from: /tmp/classes3.dex */
public final class Llm$stream$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Llm this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Llm$stream$1(Llm llm, Continuation<? super Llm$stream$1> continuation) {
        super(continuation);
        this.this$0 = llm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stream(null, null, null, false, this);
    }
}

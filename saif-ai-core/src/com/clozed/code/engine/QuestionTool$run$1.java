package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tools.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.QuestionTool", f = "Tools.kt", i = {0, 0, 0, 0, 0}, l = {624}, m = "run", n = {"c", "qs", "sb", "q", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: /tmp/classes3.dex */
public final class QuestionTool$run$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuestionTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTool$run$1(QuestionTool questionTool, Continuation<? super QuestionTool$run$1> continuation) {
        super(continuation);
        this.this$0 = questionTool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run(null, null, this);
    }
}

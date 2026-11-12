package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Diagnostics.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.DiagnosticsTool", f = "Diagnostics.kt", i = {}, l = {330}, m = "run", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class DiagnosticsTool$run$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiagnosticsTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsTool$run$1(DiagnosticsTool diagnosticsTool, Continuation<? super DiagnosticsTool$run$1> continuation) {
        super(continuation);
        this.this$0 = diagnosticsTool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run(null, null, this);
    }
}

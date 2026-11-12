package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.Llm$stream$2", f = "Llm.kt", i = {}, l = {165, 165}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class Llm$stream$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StepAcc $acc;
    final /* synthetic */ Function0<Unit> $onChange;
    final /* synthetic */ LlmRequest $req;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Llm$stream$2(LlmRequest llmRequest, StepAcc stepAcc, Function0<Unit> function0, Continuation<? super Llm$stream$2> continuation) {
        super(2, continuation);
        this.$req = llmRequest;
        this.$acc = stepAcc;
        this.$onChange = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Llm$stream$2(this.$req, this.$acc, this.$onChange, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Llm$stream$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        if (r7 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r7 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.clozed.code.engine.LlmRequest r7 = r6.$req
            com.clozed.code.engine.CatProvider r7 = r7.getProvider()
            java.lang.String r7 = r7.getKind()
            java.lang.String r1 = "anthropic"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
            if (r7 == 0) goto L44
            com.clozed.code.engine.Llm r7 = com.clozed.code.engine.Llm.INSTANCE
            com.clozed.code.engine.LlmRequest r1 = r6.$req
            com.clozed.code.engine.StepAcc r2 = r6.$acc
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r6.$onChange
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r3
            java.lang.Object r7 = com.clozed.code.engine.Llm.access$anthropic(r7, r1, r2, r4, r5)
            if (r7 != r0) goto L58
            goto L57
        L44:
            com.clozed.code.engine.Llm r7 = com.clozed.code.engine.Llm.INSTANCE
            com.clozed.code.engine.LlmRequest r1 = r6.$req
            com.clozed.code.engine.StepAcc r3 = r6.$acc
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r6.$onChange
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r2
            java.lang.Object r7 = com.clozed.code.engine.Llm.access$openai(r7, r1, r3, r4, r5)
            if (r7 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm$stream$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.clozed.code;

import com.clozed.code.data.AgentOpt;
import com.clozed.code.data.Backend;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$switchAgent$1", f = "AppViewModel.kt", i = {}, l = {463, 464}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$switchAgent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AgentOpt $a;
    final /* synthetic */ Backend $client;
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$switchAgent$1(Backend backend, String str, AgentOpt agentOpt, AppViewModel appViewModel, Continuation<? super AppViewModel$switchAgent$1> continuation) {
        super(2, continuation);
        this.$client = backend;
        this.$id = str;
        this.$a = agentOpt;
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$switchAgent$1(this.$client, this.$id, this.$a, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$switchAgent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        if (r2 == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            r27 = this;
            r1 = r27
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L24
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r28)     // Catch: java.lang.Exception -> L22
            r2 = r28
            goto L4d
        L16:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L1e:
            kotlin.ResultKt.throwOnFailure(r28)     // Catch: java.lang.Exception -> L22
            goto L3d
        L22:
            r0 = move-exception
            goto L91
        L24:
            kotlin.ResultKt.throwOnFailure(r28)
            com.clozed.code.data.Backend r2 = r1.$client     // Catch: java.lang.Exception -> L22
            java.lang.String r5 = r1.$id     // Catch: java.lang.Exception -> L22
            com.clozed.code.data.AgentOpt r6 = r1.$a     // Catch: java.lang.Exception -> L22
            java.lang.String r6 = r6.getId()     // Catch: java.lang.Exception -> L22
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Exception -> L22
            r1.label = r4     // Catch: java.lang.Exception -> L22
            java.lang.Object r2 = r2.switchAgent(r5, r6, r7)     // Catch: java.lang.Exception -> L22
            if (r2 != r0) goto L3d
            goto L4c
        L3d:
            com.clozed.code.data.Backend r2 = r1.$client     // Catch: java.lang.Exception -> L22
            java.lang.String r5 = r1.$id     // Catch: java.lang.Exception -> L22
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L22
            r1.label = r3     // Catch: java.lang.Exception -> L22
            java.lang.Object r2 = r2.session(r5, r6)     // Catch: java.lang.Exception -> L22
            if (r2 != r0) goto L4d
        L4c:
            return r0
        L4d:
            r15 = r2
            com.clozed.code.data.SessionInfo r15 = (com.clozed.code.data.SessionInfo) r15     // Catch: java.lang.Exception -> L22
            if (r15 == 0) goto L89
            com.clozed.code.AppViewModel r0 = r1.this$0     // Catch: java.lang.Exception -> L22
            kotlinx.coroutines.flow.MutableStateFlow r0 = com.clozed.code.AppViewModel.access$get_state$p(r0)     // Catch: java.lang.Exception -> L22
        L58:
            java.lang.Object r2 = r0.getValue()     // Catch: java.lang.Exception -> L22
            r5 = r2
            com.clozed.code.UiState r5 = (com.clozed.code.UiState) r5     // Catch: java.lang.Exception -> L22
            r25 = 523775(0x7fdff, float:7.33965E-40)
            r26 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            com.clozed.code.UiState r3 = com.clozed.code.UiState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch: java.lang.Exception -> L22
            boolean r2 = r0.compareAndSet(r2, r3)     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L58
        L89:
            com.clozed.code.AppViewModel r0 = r1.this$0     // Catch: java.lang.Exception -> L22
            r2 = 0
            r3 = 0
            com.clozed.code.AppViewModel.scheduleMessages$default(r0, r2, r4, r3)     // Catch: java.lang.Exception -> L22
            goto L96
        L91:
            com.clozed.code.AppViewModel r2 = r1.this$0
            com.clozed.code.AppViewModel.access$fail(r2, r0)
        L96:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel$switchAgent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

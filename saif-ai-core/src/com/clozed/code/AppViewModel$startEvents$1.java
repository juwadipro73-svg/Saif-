package com.clozed.code;

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
@DebugMetadata(c = "com.clozed.code.AppViewModel$startEvents$1", f = "AppViewModel.kt", i = {0, 1}, l = {227, 232}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$startEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Backend $client;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$startEvents$1(Backend backend, AppViewModel appViewModel, Continuation<? super AppViewModel$startEvents$1> continuation) {
        super(2, continuation);
        this.$client = backend;
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppViewModel$startEvents$1 appViewModel$startEvents$1 = new AppViewModel$startEvents$1(this.$client, this.this$0, continuation);
        appViewModel$startEvents$1.L$0 = obj;
        return appViewModel$startEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$startEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
    
        if (r0.collect(new com.clozed.code.AppViewModel$startEvents$1.AnonymousClass1<>(), r29) == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(2000, r29) == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a5, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b A[Catch: Exception -> 0x002b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:10:0x003b, B:33:0x0027), top: B:32:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a3 -> B:6:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            r29 = this;
            r1 = r29
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L2d
            if (r0 == r4) goto L22
            if (r0 != r3) goto L1a
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r30)
            r5 = r0
            goto La6
        L1a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L22:
            java.lang.Object r0 = r1.L$0
            r5 = r0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r30)     // Catch: java.lang.Exception -> L2b
            goto L5c
        L2b:
            r0 = move-exception
            goto L58
        L2d:
            kotlin.ResultKt.throwOnFailure(r30)
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            r5 = r0
        L35:
            boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r5)
            if (r0 == 0) goto Lc7
            com.clozed.code.data.Backend r0 = r1.$client     // Catch: java.lang.Exception -> L2b
            kotlinx.coroutines.flow.Flow r0 = r0.events()     // Catch: java.lang.Exception -> L2b
            com.clozed.code.AppViewModel$startEvents$1$1 r6 = new com.clozed.code.AppViewModel$startEvents$1$1     // Catch: java.lang.Exception -> L2b
            com.clozed.code.AppViewModel r7 = r1.this$0     // Catch: java.lang.Exception -> L2b
            r6.<init>()     // Catch: java.lang.Exception -> L2b
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6     // Catch: java.lang.Exception -> L2b
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Exception -> L2b
            r1.L$0 = r5     // Catch: java.lang.Exception -> L2b
            r1.label = r4     // Catch: java.lang.Exception -> L2b
            java.lang.Object r0 = r0.collect(r6, r7)     // Catch: java.lang.Exception -> L2b
            if (r0 != r2) goto L5c
            goto La5
        L58:
            boolean r6 = r0 instanceof java.util.concurrent.CancellationException
            if (r6 != 0) goto Lc6
        L5c:
            com.clozed.code.AppViewModel r0 = r1.this$0
            kotlinx.coroutines.flow.MutableStateFlow r6 = com.clozed.code.AppViewModel.access$get_state$p(r0)
        L62:
            java.lang.Object r0 = r6.getValue()
            r7 = r0
            com.clozed.code.UiState r7 = (com.clozed.code.UiState) r7
            r27 = 524271(0x7ffef, float:7.3466E-40)
            r28 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            com.clozed.code.UiState r7 = com.clozed.code.UiState.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r0 = r6.compareAndSet(r0, r7)
            if (r0 == 0) goto L62
            r0 = r1
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r1.L$0 = r5
            r1.label = r3
            r6 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r0 != r2) goto La6
        La5:
            return r2
        La6:
            com.clozed.code.AppViewModel r0 = r1.this$0
            r0.refreshSessions()
            com.clozed.code.AppViewModel r0 = r1.this$0
            kotlinx.coroutines.flow.StateFlow r0 = r0.getState()
            java.lang.Object r0 = r0.getValue()
            com.clozed.code.UiState r0 = (com.clozed.code.UiState) r0
            java.lang.String r0 = r0.getCurrentId()
            if (r0 == 0) goto L35
            com.clozed.code.AppViewModel r0 = r1.this$0
            r6 = 0
            r7 = 0
            com.clozed.code.AppViewModel.scheduleMessages$default(r0, r6, r4, r7)
            goto L35
        Lc6:
            throw r0
        Lc7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel$startEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

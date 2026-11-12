package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lorg/json/JSONObject;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$events$1", f = "LocalBackend.kt", i = {0}, l = {702, 703}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
final class LocalBackend$events$1 extends SuspendLambda implements Function2<FlowCollector<? super JSONObject>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$events$1(LocalBackend localBackend, Continuation<? super LocalBackend$events$1> continuation) {
        super(2, continuation);
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalBackend$events$1 localBackend$events$1 = new LocalBackend$events$1(this.this$0, continuation);
        localBackend$events$1.L$0 = obj;
        return localBackend$events$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JSONObject> flowCollector, Continuation<? super Unit> continuation) {
        return ((LocalBackend$events$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, r7, r6) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r1.emit(r7, r6) == r0) goto L15;
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
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4a
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r4 = "type"
            java.lang.String r5 = "server.connected"
            org.json.JSONObject r7 = r7.put(r4, r5)
            java.lang.String r4 = "put(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.emit(r7, r4)
            if (r7 != r0) goto L4a
            goto L60
        L4a:
            com.clozed.code.engine.LocalBackend r7 = r6.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r7 = com.clozed.code.engine.LocalBackend.access$getBus$p(r7)
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r7, r3)
            if (r7 != r0) goto L61
        L60:
            return r0
        L61:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend$events$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

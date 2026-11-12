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
@DebugMetadata(c = "com.clozed.code.AppViewModel$refreshSessions$1", f = "AppViewModel.kt", i = {1}, l = {272, 273}, m = "invokeSuspend", n = {"list"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$refreshSessions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Backend $client;
    Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$refreshSessions$1(AppViewModel appViewModel, Backend backend, Continuation<? super AppViewModel$refreshSessions$1> continuation) {
        super(2, continuation);
        this.this$0 = appViewModel;
        this.$client = backend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$refreshSessions$1(this.this$0, this.$client, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$refreshSessions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:2)|(1:(1:(9:6|7|8|9|10|11|(6:12|(2:13|(2:15|(2:17|18)(1:29))(2:30|31))|19|(1:21)|22|(1:25)(1:24))|26|27)(2:36|37))(2:38|39))(4:48|(1:49)|52|(2:54|44))|40|41|42|(6:45|10|11|(7:12|(3:13|(0)(0)|29)|19|(0)|22|(0)(0)|24)|26|27)|44|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b3 A[Catch: Exception -> 0x0028, TryCatch #2 {Exception -> 0x0028, blocks: (B:11:0x0091, B:12:0x009a, B:13:0x00ad, B:15:0x00b3, B:19:0x00ca, B:21:0x00ce, B:22:0x00d2, B:35:0x008d, B:38:0x0022, B:40:0x0076, B:52:0x0068), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce A[Catch: Exception -> 0x0028, TryCatch #2 {Exception -> 0x0028, blocks: (B:11:0x0091, B:12:0x009a, B:13:0x00ad, B:15:0x00b3, B:19:0x00ca, B:21:0x00ce, B:22:0x00d2, B:35:0x008d, B:38:0x0022, B:40:0x0076, B:52:0x0068), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0115 A[LOOP:0: B:12:0x009a->B:24:0x0115, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0157 A[EDGE_INSN: B:25:0x0157->B:26:0x0157 BREAK  A[LOOP:0: B:12:0x009a->B:24:0x0115], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel$refreshSessions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.clozed.code;

import com.clozed.code.engine.LocalBackend;
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
@DebugMetadata(c = "com.clozed.code.AppViewModel$setProviderEnabled$1", f = "AppViewModel.kt", i = {}, l = {609, 610}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$setProviderEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $on;
    Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$setProviderEnabled$1(LocalBackend localBackend, String str, boolean z, AppViewModel appViewModel, Continuation<? super AppViewModel$setProviderEnabled$1> continuation) {
        super(2, continuation);
        this.$engine = localBackend;
        this.$id = str;
        this.$on = z;
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$setProviderEnabled$1(this.$engine, this.$id, this.$on, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$setProviderEnabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0075 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:7:0x0014, B:9:0x0070, B:11:0x0075, B:12:0x0079, B:16:0x00a8, B:18:0x00c5, B:20:0x00cd, B:21:0x00d5, B:23:0x00de, B:24:0x00ed, B:25:0x0102, B:32:0x00f2, B:34:0x00cb, B:37:0x0022, B:38:0x004e, B:40:0x0060, B:45:0x002c), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00de A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:7:0x0014, B:9:0x0070, B:11:0x0075, B:12:0x0079, B:16:0x00a8, B:18:0x00c5, B:20:0x00cd, B:21:0x00d5, B:23:0x00de, B:24:0x00ed, B:25:0x0102, B:32:0x00f2, B:34:0x00cb, B:37:0x0022, B:38:0x004e, B:40:0x0060, B:45:0x002c), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:7:0x0014, B:9:0x0070, B:11:0x0075, B:12:0x0079, B:16:0x00a8, B:18:0x00c5, B:20:0x00cd, B:21:0x00d5, B:23:0x00de, B:24:0x00ed, B:25:0x0102, B:32:0x00f2, B:34:0x00cb, B:37:0x0022, B:38:0x004e, B:40:0x0060, B:45:0x002c), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel$setProviderEnabled$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

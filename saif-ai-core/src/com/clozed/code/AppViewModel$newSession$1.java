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
@DebugMetadata(c = "com.clozed.code.AppViewModel$newSession$1", f = "AppViewModel.kt", i = {0, 1}, l = {300, 302, 307}, m = "invokeSuspend", n = {"s", "s"}, s = {"L$0", "L$0"})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$newSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Backend $client;
    final /* synthetic */ String $directory;
    final /* synthetic */ String $portSource;
    final /* synthetic */ String $portWhat;
    final /* synthetic */ String $title;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$newSession$1(String str, AppViewModel appViewModel, Backend backend, String str2, String str3, String str4, Continuation<? super AppViewModel$newSession$1> continuation) {
        super(2, continuation);
        this.$directory = str;
        this.this$0 = appViewModel;
        this.$client = backend;
        this.$title = str2;
        this.$portSource = str3;
        this.$portWhat = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$newSession$1(this.$directory, this.this$0, this.$client, this.$title, this.$portSource, this.$portWhat, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$newSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0158, code lost:
    
        if (r2 == r0) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0137 A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:18:0x00d4, B:19:0x00da, B:22:0x0120, B:24:0x0137, B:31:0x0035, B:33:0x0077, B:42:0x003f, B:44:0x0051, B:45:0x005c), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, com.clozed.code.data.SessionInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel$newSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

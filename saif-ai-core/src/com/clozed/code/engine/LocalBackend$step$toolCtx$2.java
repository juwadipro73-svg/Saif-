package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "q", "o", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$step$toolCtx$2", f = "LocalBackend.kt", i = {}, l = {1234}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$step$toolCtx$2 extends SuspendLambda implements Function3<String, List<? extends String>, Continuation<? super String>, Object> {
    final /* synthetic */ Sess $host;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$step$toolCtx$2(LocalBackend localBackend, Sess sess, Continuation<? super LocalBackend$step$toolCtx$2> continuation) {
        super(3, continuation);
        this.this$0 = localBackend;
        this.$host = sess;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(String str, List<? extends String> list, Continuation<? super String> continuation) {
        return invoke2(str, (List<String>) list, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, List<String> list, Continuation<? super String> continuation) {
        LocalBackend$step$toolCtx$2 localBackend$step$toolCtx$2 = new LocalBackend$step$toolCtx$2(this.this$0, this.$host, continuation);
        localBackend$step$toolCtx$2.L$0 = str;
        localBackend$step$toolCtx$2.L$1 = list;
        return localBackend$step$toolCtx$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object askUser;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.L$0;
        List list = (List) this.L$1;
        this.L$0 = null;
        this.label = 1;
        askUser = this.this$0.askUser(this.$host, str, list, this);
        return askUser == coroutine_suspended ? coroutine_suspended : askUser;
    }
}

package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "a", "", "r", "", "m"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$step$toolCtx$1", f = "LocalBackend.kt", i = {}, l = {1233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$step$toolCtx$1 extends SuspendLambda implements Function4<String, List<? extends String>, String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Sess $host;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$step$toolCtx$1(LocalBackend localBackend, Sess sess, Continuation<? super LocalBackend$step$toolCtx$1> continuation) {
        super(4, continuation);
        this.this$0 = localBackend;
        this.$host = sess;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String str, List<? extends String> list, String str2, Continuation<? super Unit> continuation) {
        return invoke2(str, (List<String>) list, str2, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, List<String> list, String str2, Continuation<? super Unit> continuation) {
        LocalBackend$step$toolCtx$1 localBackend$step$toolCtx$1 = new LocalBackend$step$toolCtx$1(this.this$0, this.$host, continuation);
        localBackend$step$toolCtx$1.L$0 = str;
        localBackend$step$toolCtx$1.L$1 = list;
        localBackend$step$toolCtx$1.L$2 = str2;
        return localBackend$step$toolCtx$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object permit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            List list = (List) this.L$1;
            String str2 = (String) this.L$2;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            permit = this.this$0.permit(this.$host, str, list, str2, this);
            if (permit == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

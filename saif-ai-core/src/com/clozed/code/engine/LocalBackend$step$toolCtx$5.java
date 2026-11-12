package com.clozed.code.engine;

import com.clozed.code.engine.MPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "<unused var>", "p", "a"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$step$toolCtx$5", f = "LocalBackend.kt", i = {}, l = {1237}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$step$toolCtx$5 extends SuspendLambda implements Function4<String, String, String, Continuation<? super String>, Object> {
    final /* synthetic */ Sess $host;
    final /* synthetic */ Sess $s;
    final /* synthetic */ MPart.ToolP $tp;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$step$toolCtx$5(LocalBackend localBackend, Sess sess, Sess sess2, MPart.ToolP toolP, Continuation<? super LocalBackend$step$toolCtx$5> continuation) {
        super(4, continuation);
        this.this$0 = localBackend;
        this.$s = sess;
        this.$host = sess2;
        this.$tp = toolP;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(String str, String str2, String str3, Continuation<? super String> continuation) {
        LocalBackend$step$toolCtx$5 localBackend$step$toolCtx$5 = new LocalBackend$step$toolCtx$5(this.this$0, this.$s, this.$host, this.$tp, continuation);
        localBackend$step$toolCtx$5.L$0 = str2;
        localBackend$step$toolCtx$5.L$1 = str3;
        return localBackend$step$toolCtx$5.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MPart.ToolP toolP, List list) {
        toolP.getUndo().addAll(list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object spawn;
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
        String str2 = (String) this.L$1;
        LocalBackend localBackend = this.this$0;
        Sess sess = this.$s;
        Sess sess2 = this.$host;
        final MPart.ToolP toolP = this.$tp;
        this.L$0 = null;
        this.label = 1;
        spawn = localBackend.spawn(sess, sess2, str, str2, new Function1() { // from class: com.clozed.code.engine.LocalBackend$step$toolCtx$5$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = LocalBackend$step$toolCtx$5.invokeSuspend$lambda$0(MPart.ToolP.this, (List) obj2);
                return invokeSuspend$lambda$0;
            }
        }, this);
        return spawn == coroutine_suspended ? coroutine_suspended : spawn;
    }
}

package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.GrepTool$run$2", f = "Tools.kt", i = {0, 0, 0, 1}, l = {367, 387}, m = "invokeSuspend", n = {"$this$withContext", "pattern", "target", "limit"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: /tmp/classes3.dex */
final class GrepTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrepTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super GrepTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GrepTool$run$2 grepTool$run$2 = new GrepTool$run$2(this.$a, this.$c, continuation);
        grepTool$run$2.L$0 = obj;
        return grepTool$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GrepTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0067, code lost:
    
        if (r9 == r0) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0190  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.GrepTool$run$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

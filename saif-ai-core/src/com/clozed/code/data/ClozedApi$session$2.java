package com.clozed.code.data;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/clozed/code/data/SessionInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$session$2", f = "Api.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$session$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SessionInfo>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ ClozedApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClozedApi$session$2(ClozedApi clozedApi, String str, Continuation<? super ClozedApi$session$2> continuation) {
        super(2, continuation);
        this.this$0 = clozedApi;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClozedApi$session$2(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SessionInfo> continuation) {
        return ((ClozedApi$session$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String enc;
        JSONObject optJSONObject;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ClozedApi clozedApi = this.this$0;
        enc = clozedApi.enc(this.$id);
        JSONObject call$default = ClozedApi.call$default(clozedApi, "GET", "/api/session/" + enc, null, 4, null);
        if (call$default == null || (optJSONObject = call$default.optJSONObject("data")) == null) {
            return null;
        }
        return ModelsKt.parseSession(optJSONObject);
    }
}

package com.clozed.code.data;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/clozed/code/data/SessionInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$createSession$2", f = "Api.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$createSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SessionInfo>, Object> {
    final /* synthetic */ String $directory;
    int label;
    final /* synthetic */ ClozedApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClozedApi$createSession$2(String str, ClozedApi clozedApi, Continuation<? super ClozedApi$createSession$2> continuation) {
        super(2, continuation);
        this.$directory = str;
        this.this$0 = clozedApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClozedApi$createSession$2(this.$directory, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SessionInfo> continuation) {
        return ((ClozedApi$createSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JSONObject call;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        JSONObject jSONObject = new JSONObject();
        String str = this.$directory;
        if (str != null && !StringsKt.isBlank(str)) {
            jSONObject.put("location", new JSONObject().put("directory", StringsKt.trim((CharSequence) this.$directory).toString()));
        }
        call = this.this$0.call("POST", "/api/session", jSONObject);
        Intrinsics.checkNotNull(call);
        JSONObject jSONObject2 = call.getJSONObject("data");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
        return ModelsKt.parseSession(jSONObject2);
    }
}

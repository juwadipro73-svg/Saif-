package com.clozed.code.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/clozed/code/data/ChatItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$messages$2", f = "Api.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$messages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ChatItem>>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ ClozedApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClozedApi$messages$2(ClozedApi clozedApi, String str, Continuation<? super ClozedApi$messages$2> continuation) {
        super(2, continuation);
        this.this$0 = clozedApi;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClozedApi$messages$2(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ChatItem>> continuation) {
        return ((ClozedApi$messages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String enc;
        JSONArray jSONArray;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ClozedApi clozedApi = this.this$0;
        enc = clozedApi.enc(this.$id);
        JSONObject call$default = ClozedApi.call$default(clozedApi, "GET", "/api/session/" + enc + "/message?order=desc&limit=120", null, 4, null);
        if (call$default == null || (jSONArray = call$default.optJSONArray("data")) == null) {
            jSONArray = new JSONArray();
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        while (true) {
            length--;
            if (-1 >= length) {
                return ModelsKt.parseMessages(jSONArray2);
            }
            jSONArray2.put(jSONArray.get(length));
        }
    }
}

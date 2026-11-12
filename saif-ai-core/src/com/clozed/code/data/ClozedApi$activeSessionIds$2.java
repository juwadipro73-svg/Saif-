package com.clozed.code.data;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$activeSessionIds$2", f = "Api.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$activeSessionIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<String>>, Object> {
    int label;
    final /* synthetic */ ClozedApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClozedApi$activeSessionIds$2(ClozedApi clozedApi, Continuation<? super ClozedApi$activeSessionIds$2> continuation) {
        super(2, continuation);
        this.this$0 = clozedApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClozedApi$activeSessionIds$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<String>> continuation) {
        return ((ClozedApi$activeSessionIds$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator<String> keys;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        JSONObject call$default = ClozedApi.call$default(this.this$0, "GET", "/api/session/active", null, 4, null);
        JSONObject optJSONObject = call$default != null ? call$default.optJSONObject("data") : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNull(next);
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }
}

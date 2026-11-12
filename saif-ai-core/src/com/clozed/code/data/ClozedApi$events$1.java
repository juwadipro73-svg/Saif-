package com.clozed.code.data;

import java.net.HttpURLConnection;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.json.JSONObject;
import org.mozilla.classfile.ByteCode;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/json/JSONObject;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$events$1", f = "Api.kt", i = {}, l = {ByteCode.MULTIANEWARRAY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$events$1 extends SuspendLambda implements Function2<ProducerScope<? super JSONObject>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClozedApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClozedApi$events$1(ClozedApi clozedApi, Continuation<? super ClozedApi$events$1> continuation) {
        super(2, continuation);
        this.this$0 = clozedApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClozedApi$events$1 clozedApi$events$1 = new ClozedApi$events$1(this.this$0, continuation);
        clozedApi$events$1.L$0 = obj;
        return clozedApi$events$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super JSONObject> producerScope, Continuation<? super Unit> continuation) {
        return ((ClozedApi$events$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final HttpURLConnection open;
        final Job launch$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            open = this.this$0.open("GET", "/api/event", 0);
            open.setRequestProperty("Accept", "text/event-stream");
            launch$default = BuildersKt__Builders_commonKt.launch$default(producerScope, Dispatchers.getIO(), null, new ClozedApi$events$1$job$1(open, producerScope, null), 2, null);
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.clozed.code.data.ClozedApi$events$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ClozedApi$events$1.invokeSuspend$lambda$0(Job.this, open);
                    return invokeSuspend$lambda$0;
                }
            }, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Job job, HttpURLConnection httpURLConnection) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}

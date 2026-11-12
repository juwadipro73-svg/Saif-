package com.clozed.code.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.data.ClozedApi$events$1$job$1", f = "Api.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class ClozedApi$events$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<JSONObject> $$this$callbackFlow;
    final /* synthetic */ HttpURLConnection $conn;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClozedApi$events$1$job$1(HttpURLConnection httpURLConnection, ProducerScope<? super JSONObject> producerScope, Continuation<? super ClozedApi$events$1$job$1> continuation) {
        super(2, continuation);
        this.$conn = httpURLConnection;
        this.$$this$callbackFlow = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClozedApi$events$1$job$1(this.$conn, this.$$this$callbackFlow, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClozedApi$events$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int responseCode;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            responseCode = this.$conn.getResponseCode();
        } catch (Exception e) {
            this.$$this$callbackFlow.close(e);
        }
        if (200 > responseCode || responseCode >= 300) {
            throw new ApiException("Event stream HTTP " + this.$conn.getResponseCode());
        }
        InputStream inputStream = this.$conn.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        ProducerScope<JSONObject> producerScope = this.$$this$callbackFlow;
        try {
            BufferedReader bufferedReader2 = bufferedReader;
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                if (StringsKt.startsWith$default(readLine, "data:", false, 2, (Object) null)) {
                    sb.append(StringsKt.trim((CharSequence) StringsKt.removePrefix(readLine, (CharSequence) "data:")).toString());
                } else if (readLine.length() == 0 && sb.length() > 0) {
                    try {
                        producerScope.mo3076trySendJP2dKIU(new JSONObject(sb.toString()));
                    } catch (Exception unused) {
                    }
                    sb.setLength(0);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
            SendChannel.DefaultImpls.close$default(this.$$this$callbackFlow, null, 1, null);
            return Unit.INSTANCE;
        } finally {
        }
    }
}

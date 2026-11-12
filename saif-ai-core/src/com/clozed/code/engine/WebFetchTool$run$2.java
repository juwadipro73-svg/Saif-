package com.clozed.code.engine;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.WebFetchTool$run$2", f = "Tools.kt", i = {0}, l = {527}, m = "invokeSuspend", n = {"url"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
final class WebFetchTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFetchTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super WebFetchTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebFetchTool$run$2(this.$a, this.$c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((WebFetchTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String optStr;
        String str;
        String optStr2;
        Integer optIntOrNull;
        byte[] readNBytesCompat;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            optStr = ToolsKt.optStr(this.$a, "url");
            if (optStr == null) {
                throw new ToolError("url is required");
            }
            if (!StringsKt.startsWith$default(optStr, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(optStr, "https://", false, 2, (Object) null)) {
                throw new ToolError("URL must start with http:// or https://");
            }
            Function4<String, List<String>, String, Continuation<? super Unit>, Object> permit = this.$c.getPermit();
            List<String> listOf = CollectionsKt.listOf(optStr);
            this.L$0 = optStr;
            this.label = 1;
            if (permit.invoke("webfetch", listOf, null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = optStr;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        optStr2 = ToolsKt.optStr(this.$a, "format");
        if (optStr2 == null) {
            optStr2 = "markdown";
        }
        optIntOrNull = ToolsKt.optIntOrNull(this.$a, "timeout");
        int coerceIn = RangesKt.coerceIn(optIntOrNull != null ? optIntOrNull.intValue() : 30, 1, 120) * 1000;
        URLConnection openConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(coerceIn);
        httpURLConnection.setReadTimeout(coerceIn);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko); compatible; ClozedCode-User/1.0; +https://clozedcode.app");
        httpURLConnection.setRequestProperty("Accept", Intrinsics.areEqual(optStr2, "html") ? "text/html,*/*;q=0.5" : "text/markdown,text/plain,text/html;q=0.8,*/*;q=0.1");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                throw new ToolError("HTTP " + responseCode + " for " + str);
            }
            String contentType = httpURLConnection.getContentType();
            if (contentType == null) {
                contentType = "";
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                InputStream inputStream2 = inputStream;
                Intrinsics.checkNotNull(inputStream2);
                readNBytesCompat = ToolsKt.readNBytesCompat(inputStream2, 3000000);
                CloseableKt.closeFinally(inputStream, null);
                String str2 = new String(readNBytesCompat, Charsets.UTF_8);
                boolean z = StringsKt.contains((CharSequence) contentType, (CharSequence) "html", true) || StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) str2).toString(), "<", false, 2, (Object) null);
                if (!Intrinsics.areEqual(optStr2, "html") && z) {
                    str2 = WebFetchTool.INSTANCE.htmlToMarkdown(str2);
                }
                if (str2.length() > 400000) {
                    str2 = StringsKt.take(str2, 400000) + "\n… [truncated " + (str2.length() - 400000) + " chars]";
                }
                return str2;
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }
}

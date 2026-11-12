package com.clozed.code.engine;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.io.File;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0014\u0010\u001e\u001a\u00020\u00102\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002J\u000e\u0010\"\u001a\u00020#H\u0082@¢\u0006\u0002\u0010$J6\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0+2\b\b\u0002\u0010,\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010-J,\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b022\u0006\u00103\u001a\u000204H\u0002J*\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020/2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#08H\u0082@¢\u0006\u0002\u00109J,\u0010:\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0+H\u0082@¢\u0006\u0002\u0010;J,\u0010<\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020#0+H\u0082@¢\u0006\u0002\u0010;J\u0016\u0010=\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010>R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/clozed/code/engine/Llm;", "", "<init>", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "USER_AGENT", "", "QUOTA_WORDS", "", "SHORT_LIMIT_WORDS", "hasQuotaWord", "", NotificationCompat.CATEGORY_MESSAGE, "limitKindFor", "", "code", "cleanError", "raw", "b64", "path", "OPENAI_EFFORT", "", "thinkingBudget", "effort", "isOnline", "looksOffline", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "waitForNetwork", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream", "req", "Lcom/clozed/code/engine/LlmRequest;", "acc", "Lcom/clozed/code/engine/StepAcc;", "onChange", "Lkotlin/Function0;", "failFast", "(Lcom/clozed/code/engine/LlmRequest;Lcom/clozed/code/engine/StepAcc;Lkotlin/jvm/functions/Function0;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "Ljava/net/HttpURLConnection;", "url", "headers", "", "body", "Lorg/json/JSONObject;", "readSse", "conn", "onData", "Lkotlin/Function1;", "(Ljava/net/HttpURLConnection;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openai", "(Lcom/clozed/code/engine/LlmRequest;Lcom/clozed/code/engine/StepAcc;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anthropic", "complete", "(Lcom/clozed/code/engine/LlmRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Llm {
    public static final String USER_AGENT = "ClozedCode/1.0 (Clozed Code; Android)";
    private static volatile Context appContext;
    public static final Llm INSTANCE = new Llm();
    private static final List<String> QUOTA_WORDS = CollectionsKt.listOf((Object[]) new String[]{"quota", "insufficient", "credit", "billing", "balance", "exceeded your current", "resource_exhausted", "exhausted", "payment", "usage limit", "spend limit", "daily limit", "per day", "free tier", "plan limit"});
    private static final List<String> SHORT_LIMIT_WORDS = CollectionsKt.listOf((Object[]) new String[]{"per minute", "per min", "retry in", "try again in", "tokens per min", "requests per min"});
    private static final Set<String> OPENAI_EFFORT = SetsKt.setOf((Object[]) new String[]{"openai", "google", "groq", "xai", "openrouter", "github-models"});
    public static final int $stable = 8;

    private Llm() {
    }

    public final Context getAppContext() {
        return appContext;
    }

    public final void setAppContext(Context context) {
        appContext = context;
    }

    public final boolean hasQuotaWord(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        String lowerCase = msg.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = QUOTA_WORDS;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int limitKindFor(int r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            java.util.List<java.lang.String> r0 = com.clozed.code.engine.Llm.SHORT_LIMIT_WORDS
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L25
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L25
            goto L5a
        L25:
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5a
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r5 = r9
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default(r5, r1, r4, r3, r6)
            if (r1 == 0) goto L29
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "per day"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.contains$default(r0, r1, r4, r3, r6)
            if (r1 != 0) goto L5a
            java.lang.String r1 = "daily"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r1, r4, r3, r6)
            if (r0 != 0) goto L5a
            r0 = r2
            goto L5b
        L5a:
            r0 = r4
        L5b:
            r1 = 402(0x192, float:5.63E-43)
            if (r8 != r1) goto L60
            return r2
        L60:
            r1 = 429(0x1ad, float:6.01E-43)
            if (r8 == r1) goto L6c
            r5 = 403(0x193, float:5.65E-43)
            if (r8 == r5) goto L6c
            r5 = 400(0x190, float:5.6E-43)
            if (r8 != r5) goto L75
        L6c:
            boolean r9 = r7.hasQuotaWord(r9)
            if (r9 == 0) goto L75
            if (r0 != 0) goto L75
            return r2
        L75:
            if (r8 != r1) goto L78
            return r3
        L78:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.limitKindFor(int, java.lang.String):int");
    }

    public final String cleanError(String raw) {
        List<String> groupValues;
        String str;
        Intrinsics.checkNotNullParameter(raw, "raw");
        String obj = StringsKt.trim((CharSequence) raw).toString();
        if (!StringsKt.startsWith$default(obj, "<", false, 2, (Object) null)) {
            return obj;
        }
        String str2 = obj;
        MatchResult find$default = Regex.find$default(new Regex("<title>(.*?)</title>", (Set<? extends RegexOption>) SetsKt.setOf((Object[]) new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL})), str2, 0, 2, null);
        String obj2 = (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) ? null : StringsKt.trim((CharSequence) str).toString();
        String str3 = "";
        String obj3 = StringsKt.trim((CharSequence) new Regex("\\s+").replace(new Regex("<[^>]+>").replace(new Regex("<(script|style)[^>]*>.*?</\\1>", (Set<? extends RegexOption>) SetsKt.setOf((Object[]) new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL})).replace(str2, ""), " "), " ")).toString();
        String str4 = obj2;
        if (str4 != null && !StringsKt.isBlank(str4) && !StringsKt.startsWith$default(obj3, obj2, false, 2, (Object) null)) {
            str3 = obj2 + " ";
        }
        return str3 + StringsKt.take(obj3, 160);
    }

    private final String b64(String path) {
        try {
            return Base64.encodeToString(FilesKt.readBytes(new File(path)), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    private final int thinkingBudget(String effort) {
        if (Intrinsics.areEqual(effort, "low")) {
            return 2048;
        }
        if (Intrinsics.areEqual(effort, "high")) {
            return AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        }
        return 8192;
    }

    private final boolean isOnline() {
        NetworkCapabilities networkCapabilities;
        Context context = appContext;
        if (context == null) {
            return true;
        }
        try {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(12);
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean looksOffline(Exception e) {
        String message;
        return (e instanceof UnknownHostException) || (e instanceof ConnectException) || (e instanceof NoRouteToHostException) || ((message = e.getMessage()) != null && StringsKt.contains((CharSequence) message, (CharSequence) "Unable to resolve host", true)) || !isOnline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(3000, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(1500, r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005e -> B:17:0x0061). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object waitForNetwork(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.clozed.code.engine.Llm$waitForNetwork$1
            if (r0 == 0) goto L14
            r0 = r10
            com.clozed.code.engine.Llm$waitForNetwork$1 r0 = (com.clozed.code.engine.Llm$waitForNetwork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.clozed.code.engine.Llm$waitForNetwork$1 r0 = new com.clozed.code.engine.Llm$waitForNetwork$1
            r0.<init>(r9, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L74
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L35:
            long r5 = r0.J$0
            java.lang.Object r2 = r0.L$0
            com.clozed.code.engine.Llm r2 = (com.clozed.code.engine.Llm) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L61
        L3f:
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = 0
            r2 = r9
        L45:
            boolean r10 = r2.isOnline()
            if (r10 != 0) goto L66
            r7 = 1200000(0x124f80, double:5.92879E-318)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 >= 0) goto L66
            r0.L$0 = r2
            r0.J$0 = r5
            r0.label = r4
            r7 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r10 != r1) goto L61
            goto L73
        L61:
            r10 = 3000(0xbb8, float:4.204E-42)
            long r7 = (long) r10
            long r5 = r5 + r7
            goto L45
        L66:
            r10 = 0
            r0.L$0 = r10
            r0.label = r3
            r2 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r10 != r1) goto L74
        L73:
            return r1
        L74:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.waitForNetwork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object stream$default(Llm llm, LlmRequest llmRequest, StepAcc stepAcc, Function0 function0, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return llm.stream(llmRequest, stepAcc, function0, z, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(1:(1:(2:11|12)(2:66|67))(2:68|69))(5:70|71|72|17|18))(1:76)|13|14|(3:16|17|18)|20))|77|6|(0)(0)|13|14|(0)|20|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e7, code lost:
    
        r23 = r13;
        r13 = r1;
        r1 = r11;
        r11 = r9;
        r9 = r23;
        r23 = r12;
        r12 = r4;
        r4 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f5, code lost:
    
        r1 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0213 -> B:12:0x021f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stream(com.clozed.code.engine.LlmRequest r25, com.clozed.code.engine.StepAcc r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, boolean r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.stream(com.clozed.code.engine.LlmRequest, com.clozed.code.engine.StepAcc, kotlin.jvm.functions.Function0, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final HttpURLConnection open(String url, Map<String, String> headers, JSONObject body) {
        URLConnection openConnection = new URL(url).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(600000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "text/event-stream");
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            String jSONObject = body.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            return httpURLConnection;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readSse(HttpURLConnection httpURLConnection, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new Llm$readSse$2(httpURLConnection, function1, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object openai(com.clozed.code.engine.LlmRequest r24, final com.clozed.code.engine.StepAcc r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.openai(com.clozed.code.engine.LlmRequest, com.clozed.code.engine.StepAcc, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.clozed.code.engine.CallAcc, T] */
    public static final Unit openai$lambda$19(StepAcc stepAcc, Function0 function0, HashMap hashMap, String data) {
        JSONObject optJSONObject;
        T t;
        JSONArray jSONArray;
        String optString;
        String str;
        HashMap hashMap2 = hashMap;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data, "[DONE]")) {
            return Unit.INSTANCE;
        }
        try {
            JSONObject jSONObject = new JSONObject(data);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("error");
            int i = 0;
            if (optJSONObject2 != null) {
                String optString2 = optJSONObject2.optString("message", "provider error");
                Llm llm = INSTANCE;
                int optInt = optJSONObject2.optInt("code", 0);
                Intrinsics.checkNotNull(optString2);
                int limitKindFor = llm.limitKindFor(optInt, optString2);
                throw new LlmException(optString2, false, false, (limitKindFor == 0 && llm.hasQuotaWord(optString2)) ? 1 : limitKindFor, false, 20, null);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("usage");
            if (optJSONObject3 != null) {
                int optInt2 = optJSONObject3.optInt("prompt_tokens", 0);
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("prompt_tokens_details");
                int optInt3 = optJSONObject4 != null ? optJSONObject4.optInt("cached_tokens", 0) : 0;
                stepAcc.setCacheRead(optInt3);
                stepAcc.setInTokens(RangesKt.coerceAtLeast(optInt2 - optInt3, 0));
                stepAcc.setOutTokens(optJSONObject3.optInt("completion_tokens", stepAcc.getOutTokens()));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("choices");
            if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return Unit.INSTANCE;
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("delta");
            if (optJSONObject5 != null) {
                String optString3 = optJSONObject5.optString("content", "");
                Intrinsics.checkNotNull(optString3);
                if (optString3.length() > 0 && !Intrinsics.areEqual(optString3, "null")) {
                    stepAcc.getText().append(optString3);
                }
                String optString4 = optJSONObject5.optString("reasoning_content", optJSONObject5.optString("reasoning", ""));
                Intrinsics.checkNotNull(optString4);
                if (optString4.length() > 0 && !Intrinsics.areEqual(optString4, "null")) {
                    stepAcc.getReasoning().append(optString4);
                }
                JSONArray optJSONArray2 = optJSONObject5.optJSONArray("tool_calls");
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    int i2 = 0;
                    while (i2 < length) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        int i3 = (!jSONObject2.has("index") || jSONObject2.isNull("index")) ? i : 1;
                        int optInt4 = i3 != 0 ? jSONObject2.optInt("index", i) : -1;
                        JSONObject optJSONObject6 = jSONObject2.optJSONObject("function");
                        String optString5 = jSONObject2.optString("id", "");
                        Object obj = null;
                        if (Intrinsics.areEqual(optString5, "null")) {
                            optString5 = null;
                        }
                        if (optString5 == null) {
                            optString5 = "";
                        }
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        if (i3 != 0) {
                            t = (CallAcc) hashMap2.get(Integer.valueOf(optInt4));
                        } else if (StringsKt.isBlank(optString5)) {
                            t = (CallAcc) CollectionsKt.lastOrNull((List) stepAcc.getCalls());
                        } else {
                            Iterator<T> it = stepAcc.getCalls().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (Intrinsics.areEqual(((CallAcc) next).getId(), optString5)) {
                                    obj = next;
                                    break;
                                }
                            }
                            t = (CallAcc) obj;
                        }
                        objectRef.element = t;
                        if (objectRef.element == 0) {
                            String str2 = optString5;
                            if (StringsKt.isBlank(str2)) {
                                jSONArray = optJSONArray2;
                                str2 = "call_" + System.nanoTime() + "_" + stepAcc.getCalls().size();
                            } else {
                                jSONArray = optJSONArray2;
                            }
                            String str3 = str2;
                            if (optJSONObject6 == null || (str = optJSONObject6.optString("name", "")) == null) {
                                str = "";
                            }
                            objectRef.element = new CallAcc(str3, str);
                            if (i3 != 0) {
                                hashMap.put(Integer.valueOf(optInt4), objectRef.element);
                            }
                            stepAcc.getCalls().add(objectRef.element);
                        } else {
                            jSONArray = optJSONArray2;
                        }
                        JSONObject optJSONObject7 = jSONObject2.optJSONObject("extra_content");
                        if (optJSONObject7 != null) {
                            ((CallAcc) objectRef.element).setExtra(optJSONObject7.toString());
                        }
                        if (optJSONObject6 != null && (optString = optJSONObject6.optString("arguments", "")) != null && !Intrinsics.areEqual(optString, "null")) {
                            ((CallAcc) objectRef.element).getArgs().append(optString);
                        }
                        i2++;
                        hashMap2 = hashMap;
                        optJSONArray2 = jSONArray;
                        i = 0;
                    }
                }
            }
            String optString6 = optJSONObject.optString("finish_reason", "");
            Intrinsics.checkNotNull(optString6);
            if (optString6.length() > 0 && !Intrinsics.areEqual(optString6, "null")) {
                stepAcc.setFinish(optString6);
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
    
        if ((r7 != null ? r7.getThink() : null) != null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object anthropic(com.clozed.code.engine.LlmRequest r23, final com.clozed.code.engine.StepAcc r24, kotlin.jvm.functions.Function0<kotlin.Unit> r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.anthropic(com.clozed.code.engine.LlmRequest, com.clozed.code.engine.StepAcc, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit anthropic$lambda$35(HashMap hashMap, StepAcc stepAcc, HashMap hashMap2, Function0 function0, String data) {
        String optString;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String str;
        int i;
        int i2;
        String optString2;
        CallAcc callAcc;
        StringBuilder args;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JSONObject jSONObject2 = new JSONObject(data);
            String optString3 = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (optString3 != null) {
                String str2 = "";
                switch (optString3.hashCode()) {
                    case -1228685952:
                        if (optString3.equals("message_delta")) {
                            JSONObject optJSONObject3 = jSONObject2.optJSONObject("delta");
                            if (optJSONObject3 != null && (optString = optJSONObject3.optString("stop_reason")) != null) {
                                if (StringsKt.isBlank(optString) || Intrinsics.areEqual(optString, "null")) {
                                    optString = null;
                                }
                                if (optString != null) {
                                    if (Intrinsics.areEqual(optString, "tool_use")) {
                                        optString = "tool_calls";
                                    } else if (Intrinsics.areEqual(optString, "end_turn")) {
                                        optString = "stop";
                                    }
                                    stepAcc.setFinish(optString);
                                }
                            }
                            JSONObject optJSONObject4 = jSONObject2.optJSONObject("usage");
                            if (optJSONObject4 != null) {
                                stepAcc.setOutTokens(optJSONObject4.optInt("output_tokens", stepAcc.getOutTokens()));
                                break;
                            }
                        }
                        break;
                    case -1214396886:
                        if (optString3.equals("message_start") && (optJSONObject = jSONObject2.optJSONObject("message")) != null && (optJSONObject2 = optJSONObject.optJSONObject("usage")) != null) {
                            stepAcc.setInTokens(optJSONObject2.optInt("input_tokens", 0));
                            stepAcc.setCacheRead(optJSONObject2.optInt("cache_read_input_tokens", 0));
                            stepAcc.setCacheWrite(optJSONObject2.optInt("cache_creation_input_tokens", 0));
                            break;
                        }
                        break;
                    case 96784904:
                        if (optString3.equals("error")) {
                            JSONObject optJSONObject5 = jSONObject2.optJSONObject("error");
                            if (optJSONObject5 == null || (str = optJSONObject5.optString("message")) == null) {
                                str = "Anthropic error";
                            }
                            String str3 = str;
                            JSONObject optJSONObject6 = jSONObject2.optJSONObject("error");
                            if (optJSONObject6 != null && (optString2 = optJSONObject6.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) != null) {
                                str2 = optString2;
                            }
                            if (Intrinsics.areEqual(str2, "rate_limit_error")) {
                                i = 2;
                            } else {
                                if (!INSTANCE.hasQuotaWord(str3) || Intrinsics.areEqual(str2, "overloaded_error")) {
                                    i2 = 0;
                                    throw new LlmException(str3, Intrinsics.areEqual(str2, "overloaded_error"), false, i2, false, 20, null);
                                }
                                i = 1;
                            }
                            i2 = i;
                            throw new LlmException(str3, Intrinsics.areEqual(str2, "overloaded_error"), false, i2, false, 20, null);
                        }
                        break;
                    case 1521756864:
                        if (optString3.equals("content_block_delta")) {
                            int optInt = jSONObject2.optInt("index");
                            JSONObject optJSONObject7 = jSONObject2.optJSONObject("delta");
                            if (optJSONObject7 != null) {
                                String optString4 = optJSONObject7.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                                if (optString4 != null) {
                                    switch (optString4.hashCode()) {
                                        case -2114712026:
                                            if (optString4.equals("text_delta")) {
                                                stepAcc.getText().append(optJSONObject7.optString("text"));
                                                break;
                                            }
                                            break;
                                        case -573591447:
                                            if (optString4.equals("thinking_delta")) {
                                                String optString5 = optJSONObject7.optString("thinking");
                                                stepAcc.getReasoning().append(optString5);
                                                JSONObject jSONObject3 = (JSONObject) hashMap2.get(Integer.valueOf(optInt));
                                                if (jSONObject3 != null) {
                                                    jSONObject3.put("thinking", jSONObject3.optString("thinking") + optString5);
                                                    break;
                                                }
                                            }
                                            break;
                                        case -538519242:
                                            if (optString4.equals("input_json_delta") && (callAcc = (CallAcc) hashMap.get(Integer.valueOf(optInt))) != null && (args = callAcc.getArgs()) != null) {
                                                args.append(optJSONObject7.optString("partial_json"));
                                                break;
                                            }
                                            break;
                                        case -290239119:
                                            if (optString4.equals("signature_delta") && (jSONObject = (JSONObject) hashMap2.get(Integer.valueOf(optInt))) != null) {
                                                jSONObject.put("signature", optJSONObject7.optString("signature"));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                        break;
                    case 1536045930:
                        if (optString3.equals("content_block_start")) {
                            int optInt2 = jSONObject2.optInt("index");
                            JSONObject optJSONObject8 = jSONObject2.optJSONObject("content_block");
                            if (optJSONObject8 != null && Intrinsics.areEqual(optJSONObject8.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "tool_use")) {
                                String optString6 = optJSONObject8.optString("id");
                                Intrinsics.checkNotNullExpressionValue(optString6, "optString(...)");
                                String optString7 = optJSONObject8.optString("name");
                                Intrinsics.checkNotNullExpressionValue(optString7, "optString(...)");
                                CallAcc callAcc2 = new CallAcc(optString6, optString7);
                                hashMap.put(Integer.valueOf(optInt2), callAcc2);
                                stepAcc.getCalls().add(callAcc2);
                                break;
                            } else if (optJSONObject8 != null && Intrinsics.areEqual(optJSONObject8.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "thinking")) {
                                Integer valueOf = Integer.valueOf(optInt2);
                                JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "thinking").put("thinking", "").put("signature", "");
                                stepAcc.getThinkBlocks().add(put);
                                hashMap2.put(valueOf, put);
                                break;
                            } else if (optJSONObject8 != null && Intrinsics.areEqual(optJSONObject8.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "redacted_thinking")) {
                                stepAcc.getThinkBlocks().add(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "redacted_thinking").put("data", optJSONObject8.optString("data")));
                                break;
                            }
                        }
                        break;
                }
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object complete(com.clozed.code.engine.LlmRequest r10, kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.clozed.code.engine.Llm$complete$1
            if (r0 == 0) goto L14
            r0 = r11
            com.clozed.code.engine.Llm$complete$1 r0 = (com.clozed.code.engine.Llm$complete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.clozed.code.engine.Llm$complete$1 r0 = new com.clozed.code.engine.Llm$complete$1
            r0.<init>(r9, r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r6.L$0
            com.clozed.code.engine.StepAcc r10 = (com.clozed.code.engine.StepAcc) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L56
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            kotlin.ResultKt.throwOnFailure(r11)
            com.clozed.code.engine.StepAcc r3 = new com.clozed.code.engine.StepAcc
            r3.<init>()
            com.clozed.code.engine.Llm$$ExternalSyntheticLambda2 r4 = new com.clozed.code.engine.Llm$$ExternalSyntheticLambda2
            r4.<init>()
            r6.L$0 = r3
            r6.label = r2
            r5 = 0
            r7 = 8
            r8 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r10 = stream$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L55
            return r0
        L55:
            r10 = r3
        L56:
            java.lang.StringBuilder r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.CharSequence r10 = kotlin.text.StringsKt.trim(r10)
            java.lang.String r10 = r10.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Llm.complete(com.clozed.code.engine.LlmRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

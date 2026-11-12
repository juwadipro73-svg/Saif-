package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONObject;

/* compiled from: Mcp.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J!\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0002¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0086@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/clozed/code/engine/McpClient;", "", "name", "", "url", "headersText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "headers", "", "hasUserAuth", "", "sessionId", "initialized", "nextId", "", "lock", "Lkotlinx/coroutines/sync/Mutex;", "post", "Lorg/json/JSONObject;", "body", "waitId", "(Lorg/json/JSONObject;Ljava/lang/Integer;)Lorg/json/JSONObject;", "postOnce", "rpc", "method", "params", "ensure", "", "withSession", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "listTools", "", "Lcom/clozed/code/engine/McpToolDef;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", NotificationCompat.CATEGORY_CALL, "tool", "args", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class McpClient {
    public static final int $stable = 8;
    private final boolean hasUserAuth;
    private final Map<String, String> headers;
    private boolean initialized;
    private final Mutex lock;
    private final String name;
    private int nextId;
    private String sessionId;
    private final String url;

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public McpClient(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "headersText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r9.<init>()
            r9.name = r10
            r9.url = r11
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.util.List r10 = kotlin.text.StringsKt.lines(r12)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r10 = r10.iterator()
        L29:
            boolean r12 = r10.hasNext()
            r0 = 0
            r1 = 0
            r2 = 1
            if (r12 == 0) goto La9
            java.lang.Object r12 = r10.next()
            java.lang.String r12 = (java.lang.String) r12
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r7 = 6
            r8 = 0
            r4 = 58
            r5 = 0
            r6 = 0
            int r4 = kotlin.text.StringsKt.indexOf$default(r3, r4, r5, r6, r7, r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = r4
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 <= 0) goto L53
            goto L54
        L53:
            r4 = r1
        L54:
            if (r4 == 0) goto L5b
            int r1 = r4.intValue()
            goto L7a
        L5b:
            r7 = 6
            r8 = 0
            r4 = 61
            r5 = 0
            r6 = 0
            int r3 = kotlin.text.StringsKt.indexOf$default(r3, r4, r5, r6, r7, r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L73
            goto L74
        L73:
            r3 = r1
        L74:
            if (r3 == 0) goto La3
            int r1 = r3.intValue()
        L7a:
            java.lang.String r0 = r12.substring(r0, r1)
            java.lang.String r3 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            int r1 = r1 + r2
            java.lang.String r12 = r12.substring(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.CharSequence r12 = kotlin.text.StringsKt.trim(r12)
            java.lang.String r12 = r12.toString()
            kotlin.Pair r1 = kotlin.TuplesKt.to(r0, r12)
        La3:
            if (r1 == 0) goto L29
            r11.add(r1)
            goto L29
        La9:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Map r10 = kotlin.collections.MapsKt.toMap(r11)
            r9.headers = r10
            java.util.Set r10 = r10.keySet()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            boolean r11 = r10 instanceof java.util.Collection
            if (r11 == 0) goto Lc8
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto Lc8
        Lc6:
            r10 = r0
            goto Le1
        Lc8:
            java.util.Iterator r10 = r10.iterator()
        Lcc:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lc6
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "authorization"
            boolean r11 = kotlin.text.StringsKt.equals(r11, r12, r2)
            if (r11 == 0) goto Lcc
            r10 = r2
        Le1:
            r9.hasUserAuth = r10
            r9.nextId = r2
            kotlinx.coroutines.sync.Mutex r10 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r0, r2, r1)
            r9.lock = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpClient.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    private final JSONObject post(JSONObject body, Integer waitId) {
        try {
            return postOnce(body, waitId);
        } catch (McpUnauthorized unused) {
            if (McpOAuth.INSTANCE.refresh(this.url)) {
                try {
                    return postOnce(body, waitId);
                } catch (McpUnauthorized unused2) {
                    throw new McpException("HTTP 401: login required (tap Login under this server in Settings)");
                }
            }
            throw new McpException("HTTP 401: login required (tap Login under this server in Settings)");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0147, code lost:
    
        if (r4.length() <= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0149, code lost:
    
        r0 = new org.json.JSONObject(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0153, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cf, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r9, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d5, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final org.json.JSONObject postOnce(org.json.JSONObject r13, java.lang.Integer r14) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpClient.postOnce(org.json.JSONObject, java.lang.Integer):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject rpc(String method, JSONObject params) {
        int i = this.nextId;
        this.nextId = i + 1;
        JSONObject put = new JSONObject().put("jsonrpc", "2.0").put("id", i).put("method", method);
        if (params != null) {
            put.put("params", params);
        }
        Intrinsics.checkNotNull(put);
        JSONObject post = post(put, Integer.valueOf(i));
        if (post == null) {
            throw new McpException("Empty response (" + method + ")");
        }
        JSONObject optJSONObject = post.optJSONObject("error");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("message", "MCP error");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            throw new McpException(optString);
        }
        JSONObject optJSONObject2 = post.optJSONObject("result");
        return optJSONObject2 == null ? new JSONObject() : optJSONObject2;
    }

    private final void ensure() {
        if (this.initialized) {
            return;
        }
        rpc("initialize", new JSONObject().put("protocolVersion", "2025-03-26").put("capabilities", new JSONObject()).put("clientInfo", new JSONObject().put("name", "clozed-code").put("version", "1.0")));
        JSONObject put = new JSONObject().put("jsonrpc", "2.0").put("method", "notifications/initialized");
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        post(put, null);
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T withSession(Function0<? extends T> block) {
        try {
            ensure();
            return block.invoke();
        } catch (McpSessionExpired unused) {
            this.initialized = false;
            this.sessionId = null;
            ensure();
            return block.invoke();
        }
    }

    public final Object listTools(Continuation<? super List<McpToolDef>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new McpClient$listTools$2(this, null), continuation);
    }

    public final Object call(String str, JSONObject jSONObject, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new McpClient$call$2(this, str, jSONObject, null), continuation);
    }
}

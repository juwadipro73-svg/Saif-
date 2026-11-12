package com.clozed.code.data;

import android.util.Base64;
import androidx.core.app.NotificationCompat;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001d\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0096@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010!J\u0016\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J\u001e\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001b2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J,\u0010+\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001b2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J&\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001bH\u0096@¢\u0006\u0002\u0010\u0019J\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001bH\u0096@¢\u0006\u0002\u0010\u0019J\u001e\u0010:\u001a\u00020%2\u0006\u00102\u001a\u00020\u00032\u0006\u0010;\u001a\u000207H\u0096@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020%2\u0006\u00102\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010(J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001bH\u0096@¢\u0006\u0002\u0010\u0019J\u001e\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00120EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/clozed/code/data/ClozedApi;", "Lcom/clozed/code/data/Backend;", "baseUrl", "", "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "base", "open", "Ljava/net/HttpURLConnection;", "method", "path", "readTimeoutMs", "", "errorText", "code", "text", NotificationCompat.CATEGORY_CALL, "Lorg/json/JSONObject;", "body", "enc", "kotlin.jvm.PlatformType", "s", "(Ljava/lang/String;)Ljava/lang/String;", "info", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessions", "", "Lcom/clozed/code/data/SessionInfo;", "activeSessionIds", "", "session", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "directory", "deleteSession", "", "renameSession", "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", "Lcom/clozed/code/data/ChatItem;", "prompt", "images", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupt", "permissions", "Lcom/clozed/code/data/PermissionReq;", "replyPermission", "sessionId", "requestId", "decision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "models", "Lcom/clozed/code/data/ModelOpt;", "agents", "Lcom/clozed/code/data/AgentOpt;", "switchModel", "m", "(Ljava/lang/String;Lcom/clozed/code/data/ModelOpt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchAgent", "agentId", "integrations", "Lcom/clozed/code/data/IntegrationOpt;", "connectKey", "integrationId", "key", "events", "Lkotlinx/coroutines/flow/Flow;", "Companion", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ClozedApi implements Backend {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String base;
    private final String password;

    public ClozedApi(String baseUrl, String password) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(password, "password");
        this.password = password;
        this.base = INSTANCE.normalize(baseUrl);
    }

    /* compiled from: Api.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/clozed/code/data/ClozedApi$Companion;", "", "<init>", "()V", "normalize", "", "url", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String normalize(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            String trimEnd = StringsKt.trimEnd(StringsKt.trim((CharSequence) url).toString(), '/');
            if (trimEnd.length() == 0) {
                trimEnd = "127.0.0.1:4096";
            }
            return (StringsKt.startsWith$default(trimEnd, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(trimEnd, "https://", false, 2, (Object) null)) ? trimEnd : "http://" + trimEnd;
        }
    }

    static /* synthetic */ HttpURLConnection open$default(ClozedApi clozedApi, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 30000;
        }
        return clozedApi.open(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpURLConnection open(String method, String path, int readTimeoutMs) {
        URLConnection openConnection = new URL(this.base + path).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(readTimeoutMs);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        if (this.password.length() > 0) {
            byte[] bytes = ("opencode:" + this.password).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            httpURLConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(bytes, 2));
        }
        return httpURLConnection;
    }

    private final String errorText(int code, String text) {
        String str;
        try {
            str = new JSONObject(text).optString("message");
        } catch (Exception unused) {
            str = "";
        }
        if (code == 401) {
            return "Unauthorized — wrong password, or the server requires a password";
        }
        Intrinsics.checkNotNull(str);
        return !StringsKt.isBlank(str) ? str : "HTTP " + code;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JSONObject call$default(ClozedApi clozedApi, String str, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        return clozedApi.call(str, str2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
    
        if (r3 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject call(java.lang.String r8, java.lang.String r9, org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.data.ClozedApi.call(java.lang.String, java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String enc(String s) {
        return URLEncoder.encode(s, "UTF-8");
    }

    @Override // com.clozed.code.data.Backend
    public Object info(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$info$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object sessions(Continuation<? super List<SessionInfo>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$sessions$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object activeSessionIds(Continuation<? super Set<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$activeSessionIds$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object session(String str, Continuation<? super SessionInfo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$session$2(this, str, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object createSession(String str, Continuation<? super SessionInfo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$createSession$2(str, this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object deleteSession(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$deleteSession$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object renameSession(String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$renameSession$2(this, str, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object messages(String str, Continuation<? super List<? extends ChatItem>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$messages$2(this, str, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object prompt(String str, String str2, List<String> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$prompt$2(this, str, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object interrupt(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$interrupt$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object permissions(String str, Continuation<? super List<PermissionReq>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$permissions$2(this, str, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object replyPermission(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$replyPermission$2(this, str, str2, str3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object models(Continuation<? super List<ModelOpt>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$models$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object agents(Continuation<? super List<AgentOpt>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$agents$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object switchModel(String str, ModelOpt modelOpt, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$switchModel$2(modelOpt, this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object switchAgent(String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$switchAgent$2(this, str, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object integrations(Continuation<? super List<IntegrationOpt>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$integrations$2(this, null), continuation);
    }

    @Override // com.clozed.code.data.Backend
    public Object connectKey(String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ClozedApi$connectKey$2(this, str, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Flow<JSONObject> events() {
        return FlowKt.callbackFlow(new ClozedApi$events$1(this, null));
    }
}

package com.clozed.code.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* compiled from: McpOAuth.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0005J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J&\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J \u0010-\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J$\u00100\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00069"}, d2 = {"Lcom/clozed/code/engine/McpOAuth;", "", "<init>", "()V", "REDIRECT_URI", "", "sp", "Landroid/content/SharedPreferences;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/clozed/code/engine/McpAuthEvent;", "getEvents", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "init", "", "ctx", "Landroid/content/Context;", "tokKey", "url", "load", "Lorg/json/JSONObject;", "isLoggedIn", "", "logout", "accessToken", "refresh", "saveTokens", "r", "base", "fallbackRefresh", "begin", "serverUrl", "name", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRedirect", "uri", "Landroid/net/Uri;", "origin", "u", "Ljava/net/URL;", "discover", "Lcom/clozed/code/engine/OAuthDisc;", "getJson", "send", "contentType", "body", "postForm", "form", "", "b64", "b", "", "randomString", "bytes", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class McpOAuth {
    public static final String REDIRECT_URI = "clozedcode://oauth/mcp";
    private static SharedPreferences sp;
    public static final McpOAuth INSTANCE = new McpOAuth();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final MutableSharedFlow<McpAuthEvent> events = SharedFlowKt.MutableSharedFlow$default(0, 8, null, 5, null);
    public static final int $stable = 8;

    private McpOAuth() {
    }

    public final MutableSharedFlow<McpAuthEvent> getEvents() {
        return events;
    }

    public final synchronized void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (sp == null) {
            sp = ctx.getApplicationContext().getSharedPreferences("mcp_oauth", 0);
        }
    }

    private final String tokKey(String url) {
        return "tok." + url;
    }

    private final JSONObject load(String url) {
        String string;
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null && (string = sharedPreferences.getString(tokKey(url), null)) != null) {
            try {
                return new JSONObject(string);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean isLoggedIn(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return load(url) != null;
    }

    public final void logout(String url) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        Intrinsics.checkNotNullParameter(url, "url");
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (remove = edit.remove(tokKey(url))) == null) {
            return;
        }
        remove.apply();
    }

    public final String accessToken(String url) {
        String optString;
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject load = load(url);
        if (load == null) {
            return null;
        }
        long optLong = load.optLong("exp", 0L);
        if (optLong > 0 && System.currentTimeMillis() > optLong - 30000) {
            String optString2 = load.optString("refresh");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            if (!StringsKt.isBlank(optString2) && refresh(url)) {
                JSONObject load2 = load(url);
                if (load2 == null || (optString = load2.optString("access")) == null) {
                    return null;
                }
                String str = optString;
                return StringsKt.isBlank(str) ? null : str;
            }
        }
        String optString3 = load.optString("access");
        return StringsKt.isBlank(optString3) ? null : optString3;
    }

    public final synchronized boolean refresh(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject load = load(url);
        if (load == null) {
            return false;
        }
        String optString = load.optString("refresh");
        Intrinsics.checkNotNull(optString);
        if (StringsKt.isBlank(optString)) {
            return false;
        }
        LinkedHashMap linkedMapOf = MapsKt.linkedMapOf(TuplesKt.to("grant_type", "refresh_token"), TuplesKt.to("refresh_token", optString), TuplesKt.to("client_id", load.optString("clientId")), TuplesKt.to("resource", url));
        String optString2 = load.optString("clientSecret");
        Intrinsics.checkNotNull(optString2);
        if (StringsKt.isBlank(optString2)) {
            optString2 = null;
        }
        if (optString2 != null) {
            linkedMapOf.put("client_secret", optString2);
        }
        try {
            String string = load.getString("tokenEndpoint");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            JSONObject postForm = postForm(string, linkedMapOf);
            String optString3 = postForm.optString("access_token");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
            if (StringsKt.isBlank(optString3)) {
                return false;
            }
            saveTokens(url, postForm, load, optString);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveTokens(String url, JSONObject r, JSONObject base, String fallbackRefresh) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        long optLong = r.optLong("expires_in", 0L);
        long currentTimeMillis = optLong > 0 ? System.currentTimeMillis() + (optLong * 1000) : 0L;
        JSONObject put = new JSONObject().put("access", r.getString("access_token"));
        String optString = r.optString("refresh_token");
        if (!StringsKt.isBlank(optString)) {
            fallbackRefresh = optString;
        }
        JSONObject put2 = put.put("refresh", fallbackRefresh).put("exp", currentTimeMillis).put("tokenEndpoint", base.getString("tokenEndpoint")).put("clientId", base.optString("clientId")).put("clientSecret", base.optString("clientSecret"));
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(tokKey(url), put2.toString())) == null) {
            return;
        }
        putString.apply();
    }

    public final Object begin(Context context, String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new McpOAuth$begin$2(str, str2, context, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final boolean handleRedirect(Uri uri) {
        if (uri == null || !Intrinsics.areEqual(uri.getScheme(), "clozedcode") || !Intrinsics.areEqual(uri.getHost(), "oauth")) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new McpOAuth$handleRedirect$1(uri, null), 3, null);
        return true;
    }

    private final String origin(URL u) {
        String str;
        String protocol = u.getProtocol();
        String host = u.getHost();
        if (u.getPort() != -1) {
            str = ":" + u.getPort();
        } else {
            str = "";
        }
        return protocol + "://" + host + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01bd A[LOOP:1: B:44:0x01b7->B:46:0x01bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0170 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.clozed.code.engine.OAuthDisc discover(java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpOAuth.discover(java.lang.String):com.clozed.code.engine.OAuthDisc");
    }

    private final JSONObject getJson(String url) {
        JSONObject jSONObject;
        try {
            URLConnection openConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                httpURLConnection.setRequestProperty("Accept", "application/json");
                int responseCode = httpURLConnection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    jSONObject = null;
                } else {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String readText = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        jSONObject = new JSONObject(readText);
                    } finally {
                    }
                }
                return jSONObject;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        if (r3 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject send(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "OAuth HTTP "
            java.net.URL r1 = new java.net.URL
            r1.<init>(r7)
            java.net.URLConnection r7 = r1.openConnection()
            java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r1)
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> Lcc
            r1 = 15000(0x3a98, float:2.102E-41)
            r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> Lcc
            r1 = 30000(0x7530, float:4.2039E-41)
            r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> Lcc
            r1 = 1
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r1 = "Content-Type"
            r7.setRequestProperty(r1, r8)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r8 = "Accept"
            java.lang.String r1 = "application/json"
            r7.setRequestProperty(r8, r1)     // Catch: java.lang.Throwable -> Lcc
            java.io.OutputStream r8 = r7.getOutputStream()     // Catch: java.lang.Throwable -> Lcc
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch: java.lang.Throwable -> Lcc
            r1 = r8
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch: java.lang.Throwable -> Lc5
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> Lc5
            byte[] r9 = r9.getBytes(r2)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)     // Catch: java.lang.Throwable -> Lc5
            r1.write(r9)     // Catch: java.lang.Throwable -> Lc5
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            r9 = 0
            kotlin.io.CloseableKt.closeFinally(r8, r9)     // Catch: java.lang.Throwable -> Lcc
            int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> Lcc
            r1 = 300(0x12c, float:4.2E-43)
            r2 = 200(0xc8, float:2.8E-43)
            if (r2 > r8) goto L5f
            if (r8 >= r1) goto L5f
            java.io.InputStream r3 = r7.getInputStream()     // Catch: java.lang.Throwable -> Lcc
            goto L63
        L5f:
            java.io.InputStream r3 = r7.getErrorStream()     // Catch: java.lang.Throwable -> Lcc
        L63:
            if (r3 == 0) goto L95
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> Lcc
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lcc
            r5.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lcc
            java.io.Reader r5 = (java.io.Reader) r5     // Catch: java.lang.Throwable -> Lcc
            boolean r3 = r5 instanceof java.io.BufferedReader     // Catch: java.lang.Throwable -> Lcc
            if (r3 == 0) goto L75
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch: java.lang.Throwable -> Lcc
            goto L7d
        L75:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lcc
            r4 = 8192(0x2000, float:1.148E-41)
            r3.<init>(r5, r4)     // Catch: java.lang.Throwable -> Lcc
            r5 = r3
        L7d:
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch: java.lang.Throwable -> Lcc
            r3 = r5
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch: java.lang.Throwable -> L8e
            java.io.Reader r3 = (java.io.Reader) r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r3)     // Catch: java.lang.Throwable -> L8e
            kotlin.io.CloseableKt.closeFinally(r5, r9)     // Catch: java.lang.Throwable -> Lcc
            if (r3 != 0) goto L97
            goto L95
        L8e:
            r8 = move-exception
            throw r8     // Catch: java.lang.Throwable -> L90
        L90:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r8)     // Catch: java.lang.Throwable -> Lcc
            throw r9     // Catch: java.lang.Throwable -> Lcc
        L95:
            java.lang.String r3 = ""
        L97:
            if (r2 > r8) goto La4
            if (r8 >= r1) goto La4
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lcc
            r8.<init>(r3)     // Catch: java.lang.Throwable -> Lcc
            r7.disconnect()
            return r8
        La4:
            com.clozed.code.engine.McpException r9 = new com.clozed.code.engine.McpException     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r1 = kotlin.text.StringsKt.take(r3, r2)     // Catch: java.lang.Throwable -> Lcc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = " "
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lcc
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Lcc
            throw r9     // Catch: java.lang.Throwable -> Lcc
        Lc5:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> Lc7
        Lc7:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)     // Catch: java.lang.Throwable -> Lcc
            throw r0     // Catch: java.lang.Throwable -> Lcc
        Lcc:
            r8 = move-exception
            r7.disconnect()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpOAuth.send(java.lang.String, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject postForm(String url, Map<String, String> form) {
        return send(url, "application/x-www-form-urlencoded", CollectionsKt.joinToString$default(form.entrySet(), "&", null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.McpOAuth$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence postForm$lambda$16;
                postForm$lambda$16 = McpOAuth.postForm$lambda$16((Map.Entry) obj);
                return postForm$lambda$16;
            }
        }, 30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence postForm$lambda$16(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return URLEncoder.encode((String) it.getKey(), "UTF-8") + "=" + URLEncoder.encode((String) it.getValue(), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b64(byte[] b) {
        String encodeToString = Base64.encodeToString(b, 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String randomString(int bytes) {
        byte[] bArr = new byte[bytes];
        new SecureRandom().nextBytes(bArr);
        return b64(bArr);
    }
}

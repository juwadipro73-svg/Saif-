package com.clozed.code.engine;

import android.content.SharedPreferences;
import android.net.Uri;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: McpOAuth.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpOAuth$handleRedirect$1", f = "McpOAuth.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class McpOAuth$handleRedirect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpOAuth$handleRedirect$1(Uri uri, Continuation<? super McpOAuth$handleRedirect$1> continuation) {
        super(2, continuation);
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new McpOAuth$handleRedirect$1(this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((McpOAuth$handleRedirect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SharedPreferences sharedPreferences;
        String queryParameter;
        JSONObject postForm;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            sharedPreferences = McpOAuth.sp;
            String queryParameter2 = this.$uri.getQueryParameter("state");
            String str = "";
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            String string = sharedPreferences != null ? sharedPreferences.getString("pend." + queryParameter2, null) : null;
            if (sharedPreferences != null && string != null) {
                sharedPreferences.edit().remove("pend." + queryParameter2).apply();
                JSONObject jSONObject = new JSONObject(string);
                String string2 = jSONObject.getString("serverUrl");
                try {
                    queryParameter = this.$uri.getQueryParameter("error");
                } catch (Exception e) {
                    MutableSharedFlow<McpAuthEvent> events = McpOAuth.INSTANCE.getEvents();
                    Intrinsics.checkNotNull(string2);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    Intrinsics.checkNotNull(message);
                    events.tryEmit(new McpAuthEvent(string2, false, message));
                }
                if (queryParameter != null) {
                    sharedPreferences.edit().remove("client." + jSONObject.optString("authEndpoint")).apply();
                    String queryParameter3 = this.$uri.getQueryParameter("error_description");
                    if (queryParameter3 != null) {
                        str = queryParameter3;
                    }
                    throw new McpException(StringsKt.trim((CharSequence) ("Login rejected: " + queryParameter + " " + str)).toString());
                }
                String queryParameter4 = this.$uri.getQueryParameter("code");
                if (queryParameter4 == null) {
                    throw new McpException("The redirect contained no code");
                }
                LinkedHashMap linkedMapOf = MapsKt.linkedMapOf(TuplesKt.to("grant_type", "authorization_code"), TuplesKt.to("code", queryParameter4), TuplesKt.to("redirect_uri", McpOAuth.REDIRECT_URI), TuplesKt.to("client_id", jSONObject.getString("clientId")), TuplesKt.to("code_verifier", jSONObject.getString("verifier")), TuplesKt.to("resource", string2));
                String optString = jSONObject.optString("clientSecret");
                Intrinsics.checkNotNull(optString);
                String str2 = StringsKt.isBlank(optString) ? null : optString;
                if (str2 != null) {
                    linkedMapOf.put("client_secret", str2);
                }
                McpOAuth mcpOAuth = McpOAuth.INSTANCE;
                String string3 = jSONObject.getString("tokenEndpoint");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                postForm = mcpOAuth.postForm(string3, linkedMapOf);
                String optString2 = postForm.optString("access_token");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                if (StringsKt.isBlank(optString2)) {
                    throw new McpException("The token response has no access_token");
                }
                McpOAuth mcpOAuth2 = McpOAuth.INSTANCE;
                Intrinsics.checkNotNull(string2);
                mcpOAuth2.saveTokens(string2, postForm, jSONObject, "");
                McpOAuth.INSTANCE.getEvents().tryEmit(new McpAuthEvent(string2, true, "Logged in"));
                return Unit.INSTANCE;
            }
            McpOAuth.INSTANCE.getEvents().tryEmit(new McpAuthEvent("", false, "Login session not found, tap Login again"));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

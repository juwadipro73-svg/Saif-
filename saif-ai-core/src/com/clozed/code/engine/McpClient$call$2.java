package com.clozed.code.engine;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mcp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpClient$call$2", f = "Mcp.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class McpClient$call$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $args;
    final /* synthetic */ String $tool;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ McpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpClient$call$2(McpClient mcpClient, String str, JSONObject jSONObject, Continuation<? super McpClient$call$2> continuation) {
        super(2, continuation);
        this.this$0 = mcpClient;
        this.$tool = str;
        this.$args = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new McpClient$call$2(this.this$0, this.$tool, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((McpClient$call$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        final String str;
        final McpClient mcpClient;
        final JSONObject jSONObject;
        Object withSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.lock;
            McpClient mcpClient2 = this.this$0;
            str = this.$tool;
            JSONObject jSONObject2 = this.$args;
            this.L$0 = mutex;
            this.L$1 = mcpClient2;
            this.L$2 = str;
            this.L$3 = jSONObject2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mcpClient = mcpClient2;
            jSONObject = jSONObject2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jSONObject = (JSONObject) this.L$3;
            str = (String) this.L$2;
            mcpClient = (McpClient) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            withSession = mcpClient.withSession(new Function0() { // from class: com.clozed.code.engine.McpClient$call$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String invokeSuspend$lambda$2$lambda$1;
                    invokeSuspend$lambda$2$lambda$1 = McpClient$call$2.invokeSuspend$lambda$2$lambda$1(McpClient.this, str, jSONObject);
                    return invokeSuspend$lambda$2$lambda$1;
                }
            });
            return (String) withSession;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$2$lambda$1(McpClient mcpClient, String str, JSONObject jSONObject) {
        JSONObject rpc;
        String str2;
        rpc = mcpClient.rpc("tools/call", new JSONObject().put("name", str).put("arguments", jSONObject));
        StringBuilder sb = new StringBuilder();
        JSONArray optJSONArray = rpc.optJSONArray("content");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            String optString = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (optString != null) {
                int hashCode = optString.hashCode();
                if (hashCode != -341064690) {
                    if (hashCode != 3556653) {
                        if (hashCode == 100313435 && optString.equals("image")) {
                            sb.append("[image " + jSONObject2.optString("mimeType") + "]\n");
                        }
                    } else if (optString.equals("text")) {
                        sb.append(jSONObject2.optString("text")).append('\n');
                    }
                } else if (optString.equals("resource")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("resource");
                    if (optJSONObject == null || (str2 = optJSONObject.optString("text")) == null) {
                        str2 = "[resource]";
                    }
                    sb.append(str2).append('\n');
                }
            }
            sb.append(jSONObject2.toString()).append('\n');
        }
        if (sb.length() == 0 && rpc.has("structuredContent")) {
            sb.append(rpc.get("structuredContent").toString());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        String obj = StringsKt.trim((CharSequence) sb2).toString();
        if (!rpc.optBoolean("isError", false)) {
            return obj;
        }
        String str3 = obj;
        if (str3.length() == 0) {
            str3 = "MCP tool error";
        }
        throw new ToolError(str3);
    }
}

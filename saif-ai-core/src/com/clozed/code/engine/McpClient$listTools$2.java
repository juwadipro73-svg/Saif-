package com.clozed.code.engine;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/clozed/code/engine/McpToolDef;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpClient$listTools$2", f = "Mcp.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class McpClient$listTools$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<McpToolDef>>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ McpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpClient$listTools$2(McpClient mcpClient, Continuation<? super McpClient$listTools$2> continuation) {
        super(2, continuation);
        this.this$0 = mcpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new McpClient$listTools$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<McpToolDef>> continuation) {
        return ((McpClient$listTools$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        final McpClient mcpClient;
        Object withSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.lock;
            McpClient mcpClient2 = this.this$0;
            this.L$0 = mutex;
            this.L$1 = mcpClient2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mcpClient = mcpClient2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mcpClient = (McpClient) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            withSession = mcpClient.withSession(new Function0() { // from class: com.clozed.code.engine.McpClient$listTools$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ArrayList invokeSuspend$lambda$2$lambda$1;
                    invokeSuspend$lambda$2$lambda$1 = McpClient$listTools$2.invokeSuspend$lambda$2$lambda$1(McpClient.this);
                    return invokeSuspend$lambda$2$lambda$1;
                }
            });
            return (ArrayList) withSession;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList invokeSuspend$lambda$2$lambda$1(McpClient mcpClient) {
        JSONObject rpc;
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i = 0;
        do {
            rpc = mcpClient.rpc("tools/list", str != null ? new JSONObject().put("cursor", str) : null);
            JSONArray optJSONArray = rpc.optJSONArray("tools");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                JSONObject optJSONObject = jSONObject.optJSONObject("inputSchema");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object");
                }
                if (!optJSONObject.has(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                    optJSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object");
                }
                if (!optJSONObject.has("properties")) {
                    optJSONObject.put("properties", new JSONObject());
                }
                String string = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String optString = jSONObject.optString("description");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                Intrinsics.checkNotNull(optJSONObject);
                arrayList.add(new McpToolDef(string, optString, optJSONObject));
            }
            str = rpc.optString("nextCursor");
            Intrinsics.checkNotNull(str);
            if (StringsKt.isBlank(str) || Intrinsics.areEqual(str, "null")) {
                str = null;
            }
            if (str == null) {
                break;
            }
            i++;
        } while (i < 10);
        return arrayList;
    }
}

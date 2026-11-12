package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Mcp.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/clozed/code/engine/McpTool;", "Lcom/clozed/code/engine/Tool;", "server", "", "def", "Lcom/clozed/code/engine/McpToolDef;", "client", "Lcom/clozed/code/engine/McpClient;", "<init>", "(Ljava/lang/String;Lcom/clozed/code/engine/McpToolDef;Lcom/clozed/code/engine/McpClient;)V", "name", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class McpTool implements Tool {
    public static final int $stable = 8;
    private final McpClient client;
    private final McpToolDef def;
    private final String description;
    private final String name;
    private final JSONObject schema;
    private final String server;

    public McpTool(String server, McpToolDef def, McpClient client) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(def, "def");
        Intrinsics.checkNotNullParameter(client, "client");
        this.server = server;
        this.def = def;
        this.client = client;
        this.name = StringsKt.take(new Regex("[^A-Za-z0-9_-]").replace(server + "_" + def.getName(), "_"), 64);
        String take = StringsKt.take(def.getDescription(), 1500);
        this.description = ((Object) (StringsKt.isBlank(take) ? def.getName() : take)) + "\n(MCP server: " + server + ")";
        this.schema = def.getSchema();
    }

    @Override // com.clozed.code.engine.Tool
    public String getName() {
        return this.name;
    }

    @Override // com.clozed.code.engine.Tool
    public String getDescription() {
        return this.description;
    }

    @Override // com.clozed.code.engine.Tool
    public JSONObject getSchema() {
        return this.schema;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.clozed.code.engine.Tool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object run(org.json.JSONObject r9, com.clozed.code.engine.ToolCtx r10, kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.clozed.code.engine.McpTool$run$1
            if (r0 == 0) goto L14
            r0 = r11
            com.clozed.code.engine.McpTool$run$1 r0 = (com.clozed.code.engine.McpTool$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.clozed.code.engine.McpTool$run$1 r0 = new com.clozed.code.engine.McpTool$run$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            return r11
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            java.lang.Object r9 = r0.L$1
            org.json.JSONObject r9 = (org.json.JSONObject) r9
            java.lang.Object r10 = r0.L$0
            com.clozed.code.engine.McpTool r10 = (com.clozed.code.engine.McpTool) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto La2
        L41:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.functions.Function4 r10 = r10.getPermit()
            java.lang.String r11 = r8.server
            com.clozed.code.engine.McpToolDef r2 = r8.def
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r11 = r5.append(r11)
            java.lang.String r5 = ":"
            java.lang.StringBuilder r11 = r11.append(r5)
            java.lang.StringBuilder r11 = r11.append(r2)
            java.lang.String r11 = r11.toString()
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r11)
            com.clozed.code.engine.McpToolDef r2 = r8.def
            java.lang.String r2 = r2.getName()
            java.lang.String r5 = r8.server
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "MCP tool "
            r6.<init>(r7)
            java.lang.StringBuilder r2 = r6.append(r2)
            java.lang.String r6 = " ("
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = ")"
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.String r4 = "mcp"
            java.lang.Object r10 = r10.invoke(r4, r11, r2, r0)
            if (r10 != r1) goto La1
            goto Lb7
        La1:
            r10 = r8
        La2:
            com.clozed.code.engine.McpClient r11 = r10.client
            com.clozed.code.engine.McpToolDef r10 = r10.def
            java.lang.String r10 = r10.getName()
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r11.call(r10, r9, r0)
            if (r9 != r1) goto Lb8
        Lb7:
            return r1
        Lb8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpTool.run(org.json.JSONObject, com.clozed.code.engine.ToolCtx, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

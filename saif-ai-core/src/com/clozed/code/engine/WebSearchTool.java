package com.clozed.code.engine;

import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/clozed/code/engine/WebSearchTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "client", "Lcom/clozed/code/engine/McpClient;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class WebSearchTool implements Tool {
    public static final int $stable;
    private static final McpClient client;
    private static final JSONObject schema;
    public static final WebSearchTool INSTANCE = new WebSearchTool();
    private static final String name = "websearch";
    private static final String description = "Search the web. Use this for current information beyond your knowledge cutoff.\n\nThe current year is " + Calendar.getInstance().get(1) + ". Use this year when searching for recent information or current events.";

    private WebSearchTool() {
    }

    static {
        JSONObject sStr;
        JSONObject objSchema;
        List listOf = CollectionsKt.listOf("query");
        sStr = ExtensionsKt.sStr("Websearch query");
        objSchema = ExtensionsKt.objSchema(listOf, TuplesKt.to("query", sStr));
        schema = objSchema;
        client = new McpClient("exa", "https://mcp.exa.ai/mcp", "");
        $stable = 8;
    }

    @Override // com.clozed.code.engine.Tool
    public String getName() {
        return name;
    }

    @Override // com.clozed.code.engine.Tool
    public String getDescription() {
        return description;
    }

    @Override // com.clozed.code.engine.Tool
    public JSONObject getSchema() {
        return schema;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
    
        if (r10 != r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        if (r9.invoke("websearch", r10, null, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.clozed.code.engine.Tool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object run(org.json.JSONObject r8, com.clozed.code.engine.ToolCtx r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.clozed.code.engine.WebSearchTool$run$1
            if (r0 == 0) goto L14
            r0 = r10
            com.clozed.code.engine.WebSearchTool$run$1 r0 = (com.clozed.code.engine.WebSearchTool$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.clozed.code.engine.WebSearchTool$run$1 r0 = new com.clozed.code.engine.WebSearchTool$run$1
            r0.<init>(r7, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            java.lang.String r6 = "query"
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            goto L92
        L30:
            r8 = move-exception
            goto La0
        L32:
            r8 = move-exception
            goto Lb9
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6d
        L45:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r8.has(r6)
            if (r10 == 0) goto Lba
            boolean r10 = r8.isNull(r6)
            if (r10 != 0) goto Lba
            java.lang.String r8 = r8.optString(r6)
            kotlin.jvm.functions.Function4 r9 = r9.getPermit()
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r8)
            r0.L$0 = r8
            r0.label = r5
            java.lang.String r2 = "websearch"
            java.lang.Object r9 = r9.invoke(r2, r10, r3, r0)
            if (r9 != r1) goto L6d
            goto L91
        L6d:
            com.clozed.code.engine.McpClient r9 = com.clozed.code.engine.WebSearchTool.client     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            java.lang.String r10 = "web_search_exa"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            r2.<init>()     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            org.json.JSONObject r8 = r2.put(r6, r8)     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            java.lang.String r2 = "numResults"
            r5 = 8
            org.json.JSONObject r8 = r8.put(r2, r5)     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            java.lang.String r2 = "put(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            r0.L$0 = r3     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            r0.label = r4     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            java.lang.Object r10 = r9.call(r10, r8, r0)     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            if (r10 != r1) goto L92
        L91:
            return r1
        L92:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L30 com.clozed.code.engine.ToolError -> L32
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r8 = kotlin.text.StringsKt.isBlank(r10)
            if (r8 == 0) goto L9f
            java.lang.String r8 = "No search results found. Please try a different query."
            return r8
        L9f:
            return r10
        La0:
            com.clozed.code.engine.ToolError r9 = new com.clozed.code.engine.ToolError
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Web search failed: "
            r10.<init>(r0)
            java.lang.StringBuilder r8 = r10.append(r8)
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        Lb9:
            throw r8
        Lba:
            com.clozed.code.engine.ToolError r8 = new com.clozed.code.engine.ToolError
            java.lang.String r9 = "query is required"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.WebSearchTool.run(org.json.JSONObject, com.clozed.code.engine.ToolCtx, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

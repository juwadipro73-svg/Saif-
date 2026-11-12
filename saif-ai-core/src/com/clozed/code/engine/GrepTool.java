package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/GrepTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class GrepTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final GrepTool INSTANCE = new GrepTool();
    private static final String name = "grep";
    private static final String description = "Search file contents using a regular expression or literal text matching. Use it to locate specific code, symbols, or text patterns, and narrow searches with `path` or `include`. Returns matching file paths, line numbers, and line previews.";

    private GrepTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sStr2;
        JSONObject sStr3;
        JSONObject sBool;
        JSONObject sBool2;
        JSONObject sInt;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf("pattern");
        sStr = ToolsKt.sStr("Regular expression or literal text to match in file contents.");
        sStr2 = ToolsKt.sStr("File or directory to search. Defaults to the current working directory.");
        sStr3 = ToolsKt.sStr("Glob pattern to filter files (for example, \"*.js\" or \"*.{ts,tsx}\")");
        sBool = ToolsKt.sBool("Treat `pattern` as exact text instead of a regular expression (default: false).");
        sBool2 = ToolsKt.sBool("Use case-sensitive matching (default: true).");
        sInt = ToolsKt.sInt("Maximum number of matching lines to return (default: 100)");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("pattern", sStr), TuplesKt.to("path", sStr2), TuplesKt.to("include", sStr3), TuplesKt.to("literal", sBool), TuplesKt.to("caseSensitive", sBool2), TuplesKt.to("limit", sInt));
        schema = sObj;
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

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GrepTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

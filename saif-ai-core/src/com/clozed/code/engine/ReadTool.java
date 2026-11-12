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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/ReadTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ReadTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final ReadTool INSTANCE = new ReadTool();
    private static final String name = "read";
    private static final String description = "Read the contents of a file or directory. Each text line is prefixed by its 1-based line number as <line>: <content>. The prefix is for reference and is not part of the file content. Directory entries are returned one per line. Use offset and limit to read large files or directories in sections. Prefer one larger read over many small slices, and use grep to find specific content in large files.";

    private ReadTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sInt;
        JSONObject sInt2;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf("path");
        sStr = ToolsKt.sStr("File or directory to read");
        sInt = ToolsKt.sInt("The line or directory entry to start reading from (1-based)");
        sInt2 = ToolsKt.sInt("The maximum number of lines or directory entries to read (defaults to and capped at 2000)");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("path", sStr), TuplesKt.to("offset", sInt), TuplesKt.to("limit", sInt2));
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
        return BuildersKt.withContext(Dispatchers.getIO(), new ReadTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

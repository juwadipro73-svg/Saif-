package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/TaskTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class TaskTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final TaskTool INSTANCE = new TaskTool();
    private static final String name = "task";
    private static final String description = "Launch a subagent to handle a self-contained task and return its final report. Use agent \"explore\" for read-only codebase searches and questions, or \"general\" for multi-step work. The subagent starts with no memory of this conversation, so include all the context it needs in the prompt.";

    private TaskTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sStr2;
        JSONObject sStr3;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"description", "prompt"});
        sStr = ToolsKt.sStr("A short (3-5 words) description of the task");
        sStr2 = ToolsKt.sStr("The complete task for the subagent to perform");
        sStr3 = ToolsKt.sStr("Subagent to use: explore or general (default general)");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("description", sStr), TuplesKt.to("prompt", sStr2), TuplesKt.to("agent", sStr3));
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
        String optStr;
        String optStr2;
        String optStr3;
        optStr = ToolsKt.optStr(jSONObject, "prompt");
        if (optStr == null) {
            throw new ToolError("prompt is required");
        }
        Function4<String, String, String, Continuation<? super String>, Object> spawn = toolCtx.getSpawn();
        optStr2 = ToolsKt.optStr(jSONObject, "description");
        if (optStr2 == null) {
            optStr2 = "subtask";
        }
        optStr3 = ToolsKt.optStr(jSONObject, "agent");
        if (optStr3 == null) {
            optStr3 = "general";
        }
        return spawn.invoke(optStr2, optStr, optStr3, continuation);
    }
}

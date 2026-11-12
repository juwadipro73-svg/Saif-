package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/TodoTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class TodoTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final TodoTool INSTANCE = new TodoTool();
    private static final String name = "todowrite";
    private static final String description = "Create and update a todo list for the current session. The user sees it as your working plan.\n\nUse it proactively when a task has 3 or more distinct steps, or when the user gives several tasks or asks for a todo list. Skip it for a single simple task or a purely conversational request. When in doubt, use it.\n\n- Send the full list on every call; it replaces the previous one.\n- Mark items `in_progress` when you start them and `completed` as soon as they're actually done.\n- Only call it when the list changes.";

    private TodoTool() {
    }

    static {
        JSONObject jSONObject;
        jSONObject = ToolsKt.todoSchema();
        schema = jSONObject;
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
        JSONArray optJSONArray = jSONObject.optJSONArray("todos");
        if (optJSONArray == null) {
            throw new ToolError("todos is required");
        }
        toolCtx.getSetTodos().invoke(optJSONArray);
        int i = 0;
        Iterable until = RangesKt.until(0, optJSONArray.length());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator it = until.iterator();
            while (it.hasNext()) {
                if (!Intrinsics.areEqual(optJSONArray.getJSONObject(((IntIterator) it).nextInt()).optString(NotificationCompat.CATEGORY_STATUS), "completed") && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return "Todo list updated: " + optJSONArray.length() + " items, " + i + " remaining.";
    }
}

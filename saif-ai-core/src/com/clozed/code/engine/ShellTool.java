package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/clozed/code/engine/ShellTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "truncate", "s", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ShellTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final ShellTool INSTANCE = new ShellTool();
    private static final String name = "shell";
    private static final String description = "Execute a shell command and return its output. Commands run on Android using /system/bin/sh (toybox); tools such as git, python or node are only available if installed. Quote file paths containing spaces or special characters. Prefer dedicated tools over shell commands when possible. When output is large it is truncated. Commands accept an optional timeout, background commands return immediately and you are notified when they finish.";

    private ShellTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sStr2;
        JSONObject sInt;
        JSONObject sBool;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf("command");
        sStr = ToolsKt.sStr("Shell command string to execute");
        sStr2 = ToolsKt.sStr("Working directory to execute the command in. Defaults to the current working directory.");
        sInt = ToolsKt.sInt("Timeout in milliseconds. Set to 0 to disable the timeout. Defaults to 120000.");
        sBool = ToolsKt.sBool("Run the command in the background and return immediately. You will be notified when it completes. DO NOT poll for completion.");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("command", sStr), TuplesKt.to("workdir", sStr2), TuplesKt.to("timeout", sInt), TuplesKt.to("background", sBool));
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

    public final String truncate(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (s.length() <= 30000) {
            return s;
        }
        return StringsKt.take(s, 15000) + "\n… [truncated " + (s.length() - 30000) + " chars] …\n" + StringsKt.takeLast(s, 15000);
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ShellTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

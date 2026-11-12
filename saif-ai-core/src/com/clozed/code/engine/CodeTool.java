package com.clozed.code.engine;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* compiled from: CodeMode.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/clozed/code/engine/CodeTool;", "Lcom/clozed/code/engine/Tool;", "inner", "", "<init>", "(Ljava/util/List;)V", "name", "", "getName", "()Ljava/lang/String;", "sig", "t", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "prep", "src", "text", "cx", "Lorg/mozilla/javascript/Context;", "scope", "Lorg/mozilla/javascript/Scriptable;", "r", "", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class CodeTool implements Tool {
    public static final int $stable = 8;
    private final List<Tool> inner;
    private final String name;
    private final JSONObject schema;

    /* JADX WARN: Multi-variable type inference failed */
    public CodeTool(List<? extends Tool> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
        this.name = "execute";
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object").put("properties", new JSONObject().put("code", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "string").put("description", "JavaScript source to run"))).put("required", new JSONArray((Collection) CollectionsKt.listOf("code")));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        this.schema = put;
    }

    @Override // com.clozed.code.engine.Tool
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
    
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String sig(com.clozed.code.engine.Tool r16) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.CodeTool.sig(com.clozed.code.engine.Tool):java.lang.String");
    }

    @Override // com.clozed.code.engine.Tool
    public String getDescription() {
        StringBuilder sb = new StringBuilder("Run a JavaScript program that calls several tools in ONE step. Use it for loops, conditionals and batching, for example reading many files, searching then editing each hit, or processing results before answering.\n\nRules:\n- Every tool is a synchronous function on the global `tools` object. Call it with ONE object argument; it returns the tool's text output (a string) and throws an Error if the tool fails or is denied.\n- Use `return value` to give back a result (objects are JSON-encoded). `console.log(...)` output is also returned.\n- `await` and `async` are accepted but not needed. `Promise.all([...])` just returns the array.\n- No require/import, network, timers or file access except through tools. Limits: 60 tool calls, 3 minutes.\n- Permissions still apply: edits and shell commands can ask the user.\n\nAvailable tools:\n");
        Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            sb.append(sig((Tool) it.next())).append('\n');
        }
        return sb.toString();
    }

    @Override // com.clozed.code.engine.Tool
    public JSONObject getSchema() {
        return this.schema;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prep(String src) {
        return new Regex("\\basync\\s+(?=function\\b|\\(|[A-Za-z_$])").replace(new Regex("\\bawait\\s+").replace(src, ""), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String text(Context cx, Scriptable scope, Object r) {
        String context;
        if (r == null || r == Undefined.instance) {
            return "undefined";
        }
        if (r instanceof CharSequence) {
            return r.toString();
        }
        if ((r instanceof Number) || (r instanceof Boolean)) {
            String context2 = Context.toString(r);
            Intrinsics.checkNotNullExpressionValue(context2, "toString(...)");
            return context2;
        }
        try {
            Object stringify = NativeJSON.stringify(cx, scope, r, null, 2);
            context = stringify instanceof String ? (String) stringify : null;
            if (context == null) {
                context = Context.toString(r);
            }
        } catch (Exception unused) {
            context = Context.toString(r);
        }
        Intrinsics.checkNotNull(context);
        return context;
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CodeTool$run$2(jSONObject, this, toolCtx, null), continuation);
    }
}

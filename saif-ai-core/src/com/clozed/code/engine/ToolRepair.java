package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.mozilla.javascript.ES6Iterator;

/* compiled from: CodeMode.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J&\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/clozed/code/engine/ToolRepair;", "", "<init>", "()V", "repairArgs", "Lorg/json/JSONObject;", "args", "schema", "repair", ES6Iterator.VALUE_PROPERTY, "depth", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ToolRepair {
    public static final int $stable = 0;
    public static final ToolRepair INSTANCE = new ToolRepair();

    private ToolRepair() {
    }

    public final JSONObject repairArgs(JSONObject args, JSONObject schema) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Object repair = repair(args, schema, 0);
        JSONObject jSONObject = repair instanceof JSONObject ? (JSONObject) repair : null;
        return jSONObject == null ? args : jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0146, code lost:
    
        if (r9 == null) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object repair(java.lang.Object r8, org.json.JSONObject r9, int r10) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.ToolRepair.repair(java.lang.Object, org.json.JSONObject, int):java.lang.Object");
    }
}

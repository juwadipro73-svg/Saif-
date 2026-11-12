package com.clozed.code.engine;

import androidx.core.os.EnvironmentCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u0004\u0018\u00010\u0012R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\t\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR!\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\fj\b\u0012\u0004\u0012\u00020'`\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010¨\u0006*"}, d2 = {"Lcom/clozed/code/engine/StepAcc;", "", "<init>", "()V", "text", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getText", "()Ljava/lang/StringBuilder;", "reasoning", "getReasoning", "calls", "Ljava/util/ArrayList;", "Lcom/clozed/code/engine/CallAcc;", "Lkotlin/collections/ArrayList;", "getCalls", "()Ljava/util/ArrayList;", "finish", "", "getFinish", "()Ljava/lang/String;", "setFinish", "(Ljava/lang/String;)V", "inTokens", "", "getInTokens", "()I", "setInTokens", "(I)V", "outTokens", "getOutTokens", "setOutTokens", "cacheRead", "getCacheRead", "setCacheRead", "cacheWrite", "getCacheWrite", "setCacheWrite", "thinkBlocks", "Lorg/json/JSONObject;", "getThinkBlocks", "thinkJson", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class StepAcc {
    public static final int $stable = 8;
    private int cacheRead;
    private int cacheWrite;
    private int inTokens;
    private int outTokens;
    private final StringBuilder text = new StringBuilder();
    private final StringBuilder reasoning = new StringBuilder();
    private final ArrayList<CallAcc> calls = new ArrayList<>();
    private String finish = EnvironmentCompat.MEDIA_UNKNOWN;
    private final ArrayList<JSONObject> thinkBlocks = new ArrayList<>();

    public final StringBuilder getText() {
        return this.text;
    }

    public final StringBuilder getReasoning() {
        return this.reasoning;
    }

    public final ArrayList<CallAcc> getCalls() {
        return this.calls;
    }

    public final String getFinish() {
        return this.finish;
    }

    public final void setFinish(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.finish = str;
    }

    public final int getInTokens() {
        return this.inTokens;
    }

    public final void setInTokens(int i) {
        this.inTokens = i;
    }

    public final int getOutTokens() {
        return this.outTokens;
    }

    public final void setOutTokens(int i) {
        this.outTokens = i;
    }

    public final int getCacheRead() {
        return this.cacheRead;
    }

    public final void setCacheRead(int i) {
        this.cacheRead = i;
    }

    public final int getCacheWrite() {
        return this.cacheWrite;
    }

    public final void setCacheWrite(int i) {
        this.cacheWrite = i;
    }

    public final ArrayList<JSONObject> getThinkBlocks() {
        return this.thinkBlocks;
    }

    public final String thinkJson() {
        ArrayList<JSONObject> arrayList = this.thinkBlocks;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            JSONObject jSONObject = (JSONObject) obj;
            String optString = jSONObject.optString("signature");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            if (optString.length() > 0 || Intrinsics.areEqual(jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "redacted_thinking")) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection) arrayList3).toString();
    }
}

package com.clozed.code.engine;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\rR!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000fj\b\u0012\u0004\u0012\u00020\u0003`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\rR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\rR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\rR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/clozed/code/engine/Msg;", "", "id", "", "role", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getRole", "getText", "setText", "(Ljava/lang/String;)V", "parts", "Ljava/util/ArrayList;", "Lcom/clozed/code/engine/MPart;", "Lkotlin/collections/ArrayList;", "getParts", "()Ljava/util/ArrayList;", "kind", "getKind", "setKind", "images", "getImages", "think", "getThink", "setThink", "llmText", "getLlmText", "setLlmText", "model", "getModel", "setModel", "error", "getError", "setError", "completed", "", "getCompleted", "()Z", "setCompleted", "(Z)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Msg {
    public static final int $stable = 8;
    private boolean completed;
    private String error;
    private final String id;
    private final ArrayList<String> images;
    private String kind;
    private String llmText;
    private String model;
    private final ArrayList<MPart> parts;
    private final String role;
    private String text;
    private String think;
    private long time;

    public Msg(String id, String role, String text) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = id;
        this.role = role;
        this.text = text;
        this.parts = new ArrayList<>();
        this.kind = "";
        this.images = new ArrayList<>();
        this.model = "";
        this.time = System.currentTimeMillis();
    }

    public /* synthetic */ Msg(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final ArrayList<MPart> getParts() {
        return this.parts;
    }

    public final String getKind() {
        return this.kind;
    }

    public final void setKind(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.kind = str;
    }

    public final ArrayList<String> getImages() {
        return this.images;
    }

    public final String getThink() {
        return this.think;
    }

    public final void setThink(String str) {
        this.think = str;
    }

    public final String getLlmText() {
        return this.llmText;
    }

    public final void setLlmText(String str) {
        this.llmText = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.model = str;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final void setCompleted(boolean z) {
        this.completed = z;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}

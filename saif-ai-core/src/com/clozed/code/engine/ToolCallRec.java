package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/clozed/code/engine/ToolCallRec;", "", "id", "", "name", "args", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getArgs", "getExtra", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class ToolCallRec {
    public static final int $stable = 0;
    private final String args;
    private final String extra;
    private final String id;
    private final String name;

    public static /* synthetic */ ToolCallRec copy$default(ToolCallRec toolCallRec, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCallRec.id;
        }
        if ((i & 2) != 0) {
            str2 = toolCallRec.name;
        }
        if ((i & 4) != 0) {
            str3 = toolCallRec.args;
        }
        if ((i & 8) != 0) {
            str4 = toolCallRec.extra;
        }
        return toolCallRec.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getArgs() {
        return this.args;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final ToolCallRec copy(String id, String name, String args, String extra) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return new ToolCallRec(id, name, args, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallRec)) {
            return false;
        }
        ToolCallRec toolCallRec = (ToolCallRec) other;
        return Intrinsics.areEqual(this.id, toolCallRec.id) && Intrinsics.areEqual(this.name, toolCallRec.name) && Intrinsics.areEqual(this.args, toolCallRec.args) && Intrinsics.areEqual(this.extra, toolCallRec.extra);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.args.hashCode()) * 31;
        String str = this.extra;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ToolCallRec(id=" + this.id + ", name=" + this.name + ", args=" + this.args + ", extra=" + this.extra + ")";
    }

    public ToolCallRec(String id, String name, String args, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        this.id = id;
        this.name = name;
        this.args = args;
        this.extra = str;
    }

    public /* synthetic */ ToolCallRec(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4);
    }

    public final String getArgs() {
        return this.args;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}

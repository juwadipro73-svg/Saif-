package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/engine/PermRule;", "", "action", "", "pattern", "decision", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getPattern", "getDecision", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class PermRule {
    public static final int $stable = 0;
    private final String action;
    private final String decision;
    private final String pattern;

    public static /* synthetic */ PermRule copy$default(PermRule permRule, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = permRule.action;
        }
        if ((i & 2) != 0) {
            str2 = permRule.pattern;
        }
        if ((i & 4) != 0) {
            str3 = permRule.decision;
        }
        return permRule.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    public final PermRule copy(String action, String pattern, String decision) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(decision, "decision");
        return new PermRule(action, pattern, decision);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermRule)) {
            return false;
        }
        PermRule permRule = (PermRule) other;
        return Intrinsics.areEqual(this.action, permRule.action) && Intrinsics.areEqual(this.pattern, permRule.pattern) && Intrinsics.areEqual(this.decision, permRule.decision);
    }

    public int hashCode() {
        return (((this.action.hashCode() * 31) + this.pattern.hashCode()) * 31) + this.decision.hashCode();
    }

    public String toString() {
        return "PermRule(action=" + this.action + ", pattern=" + this.pattern + ", decision=" + this.decision + ")";
    }

    public PermRule(String action, String pattern, String decision) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(decision, "decision");
        this.action = action;
        this.pattern = pattern;
        this.decision = decision;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getPattern() {
        return this.pattern;
    }
}

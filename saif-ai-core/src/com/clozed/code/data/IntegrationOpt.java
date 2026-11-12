package com.clozed.code.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/clozed/code/data/IntegrationOpt;", "", "id", "", "name", "supportsKey", "", "connected", "enabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getId", "()Ljava/lang/String;", "getName", "getSupportsKey", "()Z", "getConnected", "getEnabled", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class IntegrationOpt {
    public static final int $stable = 0;
    private final boolean connected;
    private final boolean enabled;
    private final String id;
    private final String name;
    private final boolean supportsKey;

    public static /* synthetic */ IntegrationOpt copy$default(IntegrationOpt integrationOpt, String str, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = integrationOpt.id;
        }
        if ((i & 2) != 0) {
            str2 = integrationOpt.name;
        }
        if ((i & 4) != 0) {
            z = integrationOpt.supportsKey;
        }
        if ((i & 8) != 0) {
            z2 = integrationOpt.connected;
        }
        if ((i & 16) != 0) {
            z3 = integrationOpt.enabled;
        }
        boolean z4 = z3;
        boolean z5 = z;
        return integrationOpt.copy(str, str2, z5, z2, z4);
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
    public final boolean getSupportsKey() {
        return this.supportsKey;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final IntegrationOpt copy(String id, String name, boolean supportsKey, boolean connected, boolean enabled) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new IntegrationOpt(id, name, supportsKey, connected, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntegrationOpt)) {
            return false;
        }
        IntegrationOpt integrationOpt = (IntegrationOpt) other;
        return Intrinsics.areEqual(this.id, integrationOpt.id) && Intrinsics.areEqual(this.name, integrationOpt.name) && this.supportsKey == integrationOpt.supportsKey && this.connected == integrationOpt.connected && this.enabled == integrationOpt.enabled;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.supportsKey)) * 31) + Boolean.hashCode(this.connected)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "IntegrationOpt(id=" + this.id + ", name=" + this.name + ", supportsKey=" + this.supportsKey + ", connected=" + this.connected + ", enabled=" + this.enabled + ")";
    }

    public IntegrationOpt(String id, String name, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.supportsKey = z;
        this.connected = z2;
        this.enabled = z3;
    }

    public /* synthetic */ IntegrationOpt(String str, String str2, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, z2, (i & 16) != 0 ? true : z3);
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSupportsKey() {
        return this.supportsKey;
    }
}

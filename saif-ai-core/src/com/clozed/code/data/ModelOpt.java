package com.clozed.code.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/data/ModelOpt;", "", "providerId", "", "id", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProviderId", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class ModelOpt {
    public static final int $stable = 0;
    private final String id;
    private final String name;
    private final String providerId;

    public static /* synthetic */ ModelOpt copy$default(ModelOpt modelOpt, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelOpt.providerId;
        }
        if ((i & 2) != 0) {
            str2 = modelOpt.id;
        }
        if ((i & 4) != 0) {
            str3 = modelOpt.name;
        }
        return modelOpt.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelOpt copy(String providerId, String id, String name) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ModelOpt(providerId, id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelOpt)) {
            return false;
        }
        ModelOpt modelOpt = (ModelOpt) other;
        return Intrinsics.areEqual(this.providerId, modelOpt.providerId) && Intrinsics.areEqual(this.id, modelOpt.id) && Intrinsics.areEqual(this.name, modelOpt.name);
    }

    public int hashCode() {
        return (((this.providerId.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "ModelOpt(providerId=" + this.providerId + ", id=" + this.id + ", name=" + this.name + ")";
    }

    public ModelOpt(String providerId, String id, String name) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.providerId = providerId;
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProviderId() {
        return this.providerId;
    }
}

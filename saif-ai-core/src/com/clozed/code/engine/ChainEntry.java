package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/ChainEntry;", "", "providerId", "", "modelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getProviderId", "()Ljava/lang/String;", "getModelId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class ChainEntry {
    public static final int $stable = 0;
    private final String modelId;
    private final String providerId;

    public static /* synthetic */ ChainEntry copy$default(ChainEntry chainEntry, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chainEntry.providerId;
        }
        if ((i & 2) != 0) {
            str2 = chainEntry.modelId;
        }
        return chainEntry.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    public final ChainEntry copy(String providerId, String modelId) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new ChainEntry(providerId, modelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChainEntry)) {
            return false;
        }
        ChainEntry chainEntry = (ChainEntry) other;
        return Intrinsics.areEqual(this.providerId, chainEntry.providerId) && Intrinsics.areEqual(this.modelId, chainEntry.modelId);
    }

    public int hashCode() {
        return (this.providerId.hashCode() * 31) + this.modelId.hashCode();
    }

    public String toString() {
        return "ChainEntry(providerId=" + this.providerId + ", modelId=" + this.modelId + ")";
    }

    public ChainEntry(String providerId, String modelId) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        this.providerId = providerId;
        this.modelId = modelId;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getProviderId() {
        return this.providerId;
    }
}

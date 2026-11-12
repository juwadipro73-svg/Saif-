package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u0006,"}, d2 = {"Lcom/clozed/code/engine/CatModel;", "", "id", "", "name", "context", "", "reasoning", "", "costIn", "", "costOut", "costCacheRead", "costCacheWrite", "maxOutput", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZDDDDI)V", "getId", "()Ljava/lang/String;", "getName", "getContext", "()I", "getReasoning", "()Z", "getCostIn", "()D", "getCostOut", "getCostCacheRead", "getCostCacheWrite", "getMaxOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class CatModel {
    public static final int $stable = 0;
    private final int context;
    private final double costCacheRead;
    private final double costCacheWrite;
    private final double costIn;
    private final double costOut;
    private final String id;
    private final int maxOutput;
    private final String name;
    private final boolean reasoning;

    public static /* synthetic */ CatModel copy$default(CatModel catModel, String str, String str2, int i, boolean z, double d, double d2, double d3, double d4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = catModel.id;
        }
        return catModel.copy(str, (i3 & 2) != 0 ? catModel.name : str2, (i3 & 4) != 0 ? catModel.context : i, (i3 & 8) != 0 ? catModel.reasoning : z, (i3 & 16) != 0 ? catModel.costIn : d, (i3 & 32) != 0 ? catModel.costOut : d2, (i3 & 64) != 0 ? catModel.costCacheRead : d3, (i3 & 128) != 0 ? catModel.costCacheWrite : d4, (i3 & 256) != 0 ? catModel.maxOutput : i2);
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
    public final int getContext() {
        return this.context;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getReasoning() {
        return this.reasoning;
    }

    /* renamed from: component5, reason: from getter */
    public final double getCostIn() {
        return this.costIn;
    }

    /* renamed from: component6, reason: from getter */
    public final double getCostOut() {
        return this.costOut;
    }

    /* renamed from: component7, reason: from getter */
    public final double getCostCacheRead() {
        return this.costCacheRead;
    }

    /* renamed from: component8, reason: from getter */
    public final double getCostCacheWrite() {
        return this.costCacheWrite;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMaxOutput() {
        return this.maxOutput;
    }

    public final CatModel copy(String id, String name, int context, boolean reasoning, double costIn, double costOut, double costCacheRead, double costCacheWrite, int maxOutput) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CatModel(id, name, context, reasoning, costIn, costOut, costCacheRead, costCacheWrite, maxOutput);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatModel)) {
            return false;
        }
        CatModel catModel = (CatModel) other;
        return Intrinsics.areEqual(this.id, catModel.id) && Intrinsics.areEqual(this.name, catModel.name) && this.context == catModel.context && this.reasoning == catModel.reasoning && Double.compare(this.costIn, catModel.costIn) == 0 && Double.compare(this.costOut, catModel.costOut) == 0 && Double.compare(this.costCacheRead, catModel.costCacheRead) == 0 && Double.compare(this.costCacheWrite, catModel.costCacheWrite) == 0 && this.maxOutput == catModel.maxOutput;
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.context)) * 31) + Boolean.hashCode(this.reasoning)) * 31) + Double.hashCode(this.costIn)) * 31) + Double.hashCode(this.costOut)) * 31) + Double.hashCode(this.costCacheRead)) * 31) + Double.hashCode(this.costCacheWrite)) * 31) + Integer.hashCode(this.maxOutput);
    }

    public String toString() {
        return "CatModel(id=" + this.id + ", name=" + this.name + ", context=" + this.context + ", reasoning=" + this.reasoning + ", costIn=" + this.costIn + ", costOut=" + this.costOut + ", costCacheRead=" + this.costCacheRead + ", costCacheWrite=" + this.costCacheWrite + ", maxOutput=" + this.maxOutput + ")";
    }

    public CatModel(String id, String name, int i, boolean z, double d, double d2, double d3, double d4, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.context = i;
        this.reasoning = z;
        this.costIn = d;
        this.costOut = d2;
        this.costCacheRead = d3;
        this.costCacheWrite = d4;
        this.maxOutput = i2;
    }

    public /* synthetic */ CatModel(String str, String str2, int i, boolean z, double d, double d2, double d3, double d4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, z, (i3 & 16) != 0 ? 0.0d : d, (i3 & 32) != 0 ? 0.0d : d2, (i3 & 64) != 0 ? 0.0d : d3, (i3 & 128) != 0 ? 0.0d : d4, (i3 & 256) != 0 ? 0 : i2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getContext() {
        return this.context;
    }

    public final boolean getReasoning() {
        return this.reasoning;
    }

    public final double getCostIn() {
        return this.costIn;
    }

    public final double getCostOut() {
        return this.costOut;
    }

    public final double getCostCacheRead() {
        return this.costCacheRead;
    }

    public final double getCostCacheWrite() {
        return this.costCacheWrite;
    }

    public final int getMaxOutput() {
        return this.maxOutput;
    }
}

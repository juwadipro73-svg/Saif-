package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/clozed/code/engine/CatProvider;", "", "id", "", "name", "kind", "api", "env", "models", "", "Lcom/clozed/code/engine/CatModel;", "custom", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getId", "()Ljava/lang/String;", "getName", "getKind", "getApi", "getEnv", "getModels", "()Ljava/util/List;", "getCustom", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class CatProvider {
    public static final int $stable = 8;
    private final String api;
    private final boolean custom;
    private final String env;
    private final String id;
    private final String kind;
    private final List<CatModel> models;
    private final String name;

    public static /* synthetic */ CatProvider copy$default(CatProvider catProvider, String str, String str2, String str3, String str4, String str5, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catProvider.id;
        }
        if ((i & 2) != 0) {
            str2 = catProvider.name;
        }
        if ((i & 4) != 0) {
            str3 = catProvider.kind;
        }
        if ((i & 8) != 0) {
            str4 = catProvider.api;
        }
        if ((i & 16) != 0) {
            str5 = catProvider.env;
        }
        if ((i & 32) != 0) {
            list = catProvider.models;
        }
        if ((i & 64) != 0) {
            z = catProvider.custom;
        }
        List list2 = list;
        boolean z2 = z;
        String str6 = str5;
        String str7 = str3;
        return catProvider.copy(str, str2, str7, str4, str6, list2, z2);
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
    public final String getKind() {
        return this.kind;
    }

    /* renamed from: component4, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    public final List<CatModel> component6() {
        return this.models;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCustom() {
        return this.custom;
    }

    public final CatProvider copy(String id, String name, String kind, String api, String env, List<CatModel> models, boolean custom) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(models, "models");
        return new CatProvider(id, name, kind, api, env, models, custom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatProvider)) {
            return false;
        }
        CatProvider catProvider = (CatProvider) other;
        return Intrinsics.areEqual(this.id, catProvider.id) && Intrinsics.areEqual(this.name, catProvider.name) && Intrinsics.areEqual(this.kind, catProvider.kind) && Intrinsics.areEqual(this.api, catProvider.api) && Intrinsics.areEqual(this.env, catProvider.env) && Intrinsics.areEqual(this.models, catProvider.models) && this.custom == catProvider.custom;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.kind.hashCode()) * 31) + this.api.hashCode()) * 31) + this.env.hashCode()) * 31) + this.models.hashCode()) * 31) + Boolean.hashCode(this.custom);
    }

    public String toString() {
        return "CatProvider(id=" + this.id + ", name=" + this.name + ", kind=" + this.kind + ", api=" + this.api + ", env=" + this.env + ", models=" + this.models + ", custom=" + this.custom + ")";
    }

    public CatProvider(String id, String name, String kind, String api, String env, List<CatModel> models, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(models, "models");
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.api = api;
        this.env = env;
        this.models = models;
        this.custom = z;
    }

    public /* synthetic */ CatProvider(String str, String str2, String str3, String str4, String str5, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, list, (i & 64) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getApi() {
        return this.api;
    }

    public final String getEnv() {
        return this.env;
    }

    public final List<CatModel> getModels() {
        return this.models;
    }

    public final boolean getCustom() {
        return this.custom;
    }
}

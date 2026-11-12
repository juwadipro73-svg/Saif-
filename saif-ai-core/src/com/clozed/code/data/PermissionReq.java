package com.clozed.code.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003JS\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lcom/clozed/code/data/PermissionReq;", "", "id", "", "sessionId", "action", "resources", "", "message", "options", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getSessionId", "getAction", "getResources", "()Ljava/util/List;", "getMessage", "getOptions", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class PermissionReq {
    public static final int $stable = 8;
    private final String action;
    private final String id;
    private final String message;
    private final List<String> options;
    private final List<String> resources;
    private final String sessionId;

    public static /* synthetic */ PermissionReq copy$default(PermissionReq permissionReq, String str, String str2, String str3, List list, String str4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = permissionReq.id;
        }
        if ((i & 2) != 0) {
            str2 = permissionReq.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = permissionReq.action;
        }
        if ((i & 8) != 0) {
            list = permissionReq.resources;
        }
        if ((i & 16) != 0) {
            str4 = permissionReq.message;
        }
        if ((i & 32) != 0) {
            list2 = permissionReq.options;
        }
        String str5 = str4;
        List list3 = list2;
        return permissionReq.copy(str, str2, str3, list, str5, list3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final List<String> component4() {
        return this.resources;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component6() {
        return this.options;
    }

    public final PermissionReq copy(String id, String sessionId, String action, List<String> resources, String message, List<String> options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PermissionReq(id, sessionId, action, resources, message, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionReq)) {
            return false;
        }
        PermissionReq permissionReq = (PermissionReq) other;
        return Intrinsics.areEqual(this.id, permissionReq.id) && Intrinsics.areEqual(this.sessionId, permissionReq.sessionId) && Intrinsics.areEqual(this.action, permissionReq.action) && Intrinsics.areEqual(this.resources, permissionReq.resources) && Intrinsics.areEqual(this.message, permissionReq.message) && Intrinsics.areEqual(this.options, permissionReq.options);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.action.hashCode()) * 31) + this.resources.hashCode()) * 31;
        String str = this.message;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "PermissionReq(id=" + this.id + ", sessionId=" + this.sessionId + ", action=" + this.action + ", resources=" + this.resources + ", message=" + this.message + ", options=" + this.options + ")";
    }

    public PermissionReq(String id, String sessionId, String action, List<String> resources, String str, List<String> options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(options, "options");
        this.id = id;
        this.sessionId = sessionId;
        this.action = action;
        this.resources = resources;
        this.message = str;
        this.options = options;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getAction() {
        return this.action;
    }

    public final List<String> getResources() {
        return this.resources;
    }

    public final String getMessage() {
        return this.message;
    }

    public /* synthetic */ PermissionReq(String str, String str2, String str3, List list, String str4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<String> getOptions() {
        return this.options;
    }
}

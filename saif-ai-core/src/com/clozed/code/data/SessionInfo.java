package com.clozed.code.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006)"}, d2 = {"Lcom/clozed/code/data/SessionInfo;", "", "id", "", "title", "updated", "", "directory", "cost", "", "model", "agent", "tokens", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;DLjava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTitle", "getUpdated", "()J", "getDirectory", "getCost", "()D", "getModel", "getAgent", "getTokens", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class SessionInfo {
    public static final int $stable = 0;
    private final String agent;
    private final double cost;
    private final String directory;
    private final String id;
    private final String model;
    private final String title;
    private final long tokens;
    private final long updated;

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, long j, String str3, double d, String str4, String str5, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = sessionInfo.title;
        }
        if ((i & 4) != 0) {
            j = sessionInfo.updated;
        }
        if ((i & 8) != 0) {
            str3 = sessionInfo.directory;
        }
        if ((i & 16) != 0) {
            d = sessionInfo.cost;
        }
        if ((i & 32) != 0) {
            str4 = sessionInfo.model;
        }
        if ((i & 64) != 0) {
            str5 = sessionInfo.agent;
        }
        if ((i & 128) != 0) {
            j2 = sessionInfo.tokens;
        }
        String str6 = str3;
        long j3 = j;
        return sessionInfo.copy(str, str2, j3, str6, d, str4, str5, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUpdated() {
        return this.updated;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDirectory() {
        return this.directory;
    }

    /* renamed from: component5, reason: from getter */
    public final double getCost() {
        return this.cost;
    }

    /* renamed from: component6, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTokens() {
        return this.tokens;
    }

    public final SessionInfo copy(String id, String title, long updated, String directory, double cost, String model, String agent, long tokens) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new SessionInfo(id, title, updated, directory, cost, model, agent, tokens);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) other;
        return Intrinsics.areEqual(this.id, sessionInfo.id) && Intrinsics.areEqual(this.title, sessionInfo.title) && this.updated == sessionInfo.updated && Intrinsics.areEqual(this.directory, sessionInfo.directory) && Double.compare(this.cost, sessionInfo.cost) == 0 && Intrinsics.areEqual(this.model, sessionInfo.model) && Intrinsics.areEqual(this.agent, sessionInfo.agent) && this.tokens == sessionInfo.tokens;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.updated)) * 31;
        String str = this.directory;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.cost)) * 31;
        String str2 = this.model;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agent;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.tokens);
    }

    public String toString() {
        return "SessionInfo(id=" + this.id + ", title=" + this.title + ", updated=" + this.updated + ", directory=" + this.directory + ", cost=" + this.cost + ", model=" + this.model + ", agent=" + this.agent + ", tokens=" + this.tokens + ")";
    }

    public SessionInfo(String id, String title, long j, String str, double d, String str2, String str3, long j2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = id;
        this.title = title;
        this.updated = j;
        this.directory = str;
        this.cost = d;
        this.model = str2;
        this.agent = str3;
        this.tokens = j2;
    }

    public /* synthetic */ SessionInfo(String str, String str2, long j, String str3, double d, String str4, String str5, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, d, str4, str5, (i & 128) != 0 ? 0L : j2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final double getCost() {
        return this.cost;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getAgent() {
        return this.agent;
    }

    public final long getTokens() {
        return this.tokens;
    }
}

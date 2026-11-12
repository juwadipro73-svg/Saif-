package com.clozed.code;

import com.clozed.code.data.AgentOpt;
import com.clozed.code.data.ChatItem;
import com.clozed.code.data.IntegrationOpt;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.data.PermissionReq;
import com.clozed.code.data.SessionInfo;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0004\b \u0010!J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eHÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bHÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bHÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bHÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bHÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eHÆ\u0003J\u0081\u0002\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eHÆ\u0001J\u0013\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-¨\u0006T"}, d2 = {"Lcom/clozed/code/UiState;", "", "screen", "Lcom/clozed/code/Screen;", "connecting", "", "error", "", "serverVersion", "live", "sessions", "", "Lcom/clozed/code/data/SessionInfo;", "busy", "", "loadingSessions", "currentId", "current", "items", "Lcom/clozed/code/data/ChatItem;", "permissions", "Lcom/clozed/code/data/PermissionReq;", "models", "Lcom/clozed/code/data/ModelOpt;", "agents", "Lcom/clozed/code/data/AgentOpt;", "integrations", "Lcom/clozed/code/data/IntegrationOpt;", "message", "local", "autoApprove", "fetching", "<init>", "(Lcom/clozed/code/Screen;ZLjava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/Set;ZLjava/lang/String;Lcom/clozed/code/data/SessionInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/util/Set;)V", "getScreen", "()Lcom/clozed/code/Screen;", "getConnecting", "()Z", "getError", "()Ljava/lang/String;", "getServerVersion", "getLive", "getSessions", "()Ljava/util/List;", "getBusy", "()Ljava/util/Set;", "getLoadingSessions", "getCurrentId", "getCurrent", "()Lcom/clozed/code/data/SessionInfo;", "getItems", "getPermissions", "getModels", "getAgents", "getIntegrations", "getMessage", "getLocal", "getAutoApprove", "getFetching", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class UiState {
    public static final int $stable = 8;
    private final List<AgentOpt> agents;
    private final boolean autoApprove;
    private final Set<String> busy;
    private final boolean connecting;
    private final SessionInfo current;
    private final String currentId;
    private final String error;
    private final Set<String> fetching;
    private final List<IntegrationOpt> integrations;
    private final List<ChatItem> items;
    private final boolean live;
    private final boolean loadingSessions;
    private final boolean local;
    private final String message;
    private final List<ModelOpt> models;
    private final List<PermissionReq> permissions;
    private final Screen screen;
    private final String serverVersion;
    private final List<SessionInfo> sessions;

    public UiState() {
        this(null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524287, null);
    }

    public static /* synthetic */ UiState copy$default(UiState uiState, Screen screen, boolean z, String str, String str2, boolean z2, List list, Set set, boolean z3, String str3, SessionInfo sessionInfo, List list2, List list3, List list4, List list5, List list6, String str4, boolean z4, boolean z5, Set set2, int i, Object obj) {
        Set set3;
        boolean z6;
        Screen screen2 = (i & 1) != 0 ? uiState.screen : screen;
        boolean z7 = (i & 2) != 0 ? uiState.connecting : z;
        String str5 = (i & 4) != 0 ? uiState.error : str;
        String str6 = (i & 8) != 0 ? uiState.serverVersion : str2;
        boolean z8 = (i & 16) != 0 ? uiState.live : z2;
        List list7 = (i & 32) != 0 ? uiState.sessions : list;
        Set set4 = (i & 64) != 0 ? uiState.busy : set;
        boolean z9 = (i & 128) != 0 ? uiState.loadingSessions : z3;
        String str7 = (i & 256) != 0 ? uiState.currentId : str3;
        SessionInfo sessionInfo2 = (i & 512) != 0 ? uiState.current : sessionInfo;
        List list8 = (i & 1024) != 0 ? uiState.items : list2;
        List list9 = (i & 2048) != 0 ? uiState.permissions : list3;
        List list10 = (i & 4096) != 0 ? uiState.models : list4;
        List list11 = (i & 8192) != 0 ? uiState.agents : list5;
        Screen screen3 = screen2;
        List list12 = (i & 16384) != 0 ? uiState.integrations : list6;
        String str8 = (i & 32768) != 0 ? uiState.message : str4;
        boolean z10 = (i & 65536) != 0 ? uiState.local : z4;
        boolean z11 = (i & 131072) != 0 ? uiState.autoApprove : z5;
        if ((i & 262144) != 0) {
            z6 = z11;
            set3 = uiState.fetching;
        } else {
            set3 = set2;
            z6 = z11;
        }
        return uiState.copy(screen3, z7, str5, str6, z8, list7, set4, z9, str7, sessionInfo2, list8, list9, list10, list11, list12, str8, z10, z6, set3);
    }

    /* renamed from: component1, reason: from getter */
    public final Screen getScreen() {
        return this.screen;
    }

    /* renamed from: component10, reason: from getter */
    public final SessionInfo getCurrent() {
        return this.current;
    }

    public final List<ChatItem> component11() {
        return this.items;
    }

    public final List<PermissionReq> component12() {
        return this.permissions;
    }

    public final List<ModelOpt> component13() {
        return this.models;
    }

    public final List<AgentOpt> component14() {
        return this.agents;
    }

    public final List<IntegrationOpt> component15() {
        return this.integrations;
    }

    /* renamed from: component16, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getLocal() {
        return this.local;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getAutoApprove() {
        return this.autoApprove;
    }

    public final Set<String> component19() {
        return this.fetching;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getConnecting() {
        return this.connecting;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final String getServerVersion() {
        return this.serverVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getLive() {
        return this.live;
    }

    public final List<SessionInfo> component6() {
        return this.sessions;
    }

    public final Set<String> component7() {
        return this.busy;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getLoadingSessions() {
        return this.loadingSessions;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCurrentId() {
        return this.currentId;
    }

    public final UiState copy(Screen screen, boolean connecting, String error, String serverVersion, boolean live, List<SessionInfo> sessions, Set<String> busy, boolean loadingSessions, String currentId, SessionInfo current, List<? extends ChatItem> items, List<PermissionReq> permissions, List<ModelOpt> models, List<AgentOpt> agents, List<IntegrationOpt> integrations, String message, boolean local, boolean autoApprove, Set<String> fetching) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(sessions, "sessions");
        Intrinsics.checkNotNullParameter(busy, "busy");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(agents, "agents");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(fetching, "fetching");
        return new UiState(screen, connecting, error, serverVersion, live, sessions, busy, loadingSessions, currentId, current, items, permissions, models, agents, integrations, message, local, autoApprove, fetching);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiState)) {
            return false;
        }
        UiState uiState = (UiState) other;
        return this.screen == uiState.screen && this.connecting == uiState.connecting && Intrinsics.areEqual(this.error, uiState.error) && Intrinsics.areEqual(this.serverVersion, uiState.serverVersion) && this.live == uiState.live && Intrinsics.areEqual(this.sessions, uiState.sessions) && Intrinsics.areEqual(this.busy, uiState.busy) && this.loadingSessions == uiState.loadingSessions && Intrinsics.areEqual(this.currentId, uiState.currentId) && Intrinsics.areEqual(this.current, uiState.current) && Intrinsics.areEqual(this.items, uiState.items) && Intrinsics.areEqual(this.permissions, uiState.permissions) && Intrinsics.areEqual(this.models, uiState.models) && Intrinsics.areEqual(this.agents, uiState.agents) && Intrinsics.areEqual(this.integrations, uiState.integrations) && Intrinsics.areEqual(this.message, uiState.message) && this.local == uiState.local && this.autoApprove == uiState.autoApprove && Intrinsics.areEqual(this.fetching, uiState.fetching);
    }

    public int hashCode() {
        int hashCode = ((this.screen.hashCode() * 31) + Boolean.hashCode(this.connecting)) * 31;
        String str = this.error;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.serverVersion;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.live)) * 31) + this.sessions.hashCode()) * 31) + this.busy.hashCode()) * 31) + Boolean.hashCode(this.loadingSessions)) * 31;
        String str3 = this.currentId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SessionInfo sessionInfo = this.current;
        int hashCode5 = (((((((((((hashCode4 + (sessionInfo == null ? 0 : sessionInfo.hashCode())) * 31) + this.items.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.models.hashCode()) * 31) + this.agents.hashCode()) * 31) + this.integrations.hashCode()) * 31;
        String str4 = this.message;
        return ((((((hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.local)) * 31) + Boolean.hashCode(this.autoApprove)) * 31) + this.fetching.hashCode();
    }

    public String toString() {
        return "UiState(screen=" + this.screen + ", connecting=" + this.connecting + ", error=" + this.error + ", serverVersion=" + this.serverVersion + ", live=" + this.live + ", sessions=" + this.sessions + ", busy=" + this.busy + ", loadingSessions=" + this.loadingSessions + ", currentId=" + this.currentId + ", current=" + this.current + ", items=" + this.items + ", permissions=" + this.permissions + ", models=" + this.models + ", agents=" + this.agents + ", integrations=" + this.integrations + ", message=" + this.message + ", local=" + this.local + ", autoApprove=" + this.autoApprove + ", fetching=" + this.fetching + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiState(Screen screen, boolean z, String str, String str2, boolean z2, List<SessionInfo> sessions, Set<String> busy, boolean z3, String str3, SessionInfo sessionInfo, List<? extends ChatItem> items, List<PermissionReq> permissions, List<ModelOpt> models, List<AgentOpt> agents, List<IntegrationOpt> integrations, String str4, boolean z4, boolean z5, Set<String> fetching) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(sessions, "sessions");
        Intrinsics.checkNotNullParameter(busy, "busy");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(agents, "agents");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(fetching, "fetching");
        this.screen = screen;
        this.connecting = z;
        this.error = str;
        this.serverVersion = str2;
        this.live = z2;
        this.sessions = sessions;
        this.busy = busy;
        this.loadingSessions = z3;
        this.currentId = str3;
        this.current = sessionInfo;
        this.items = items;
        this.permissions = permissions;
        this.models = models;
        this.agents = agents;
        this.integrations = integrations;
        this.message = str4;
        this.local = z4;
        this.autoApprove = z5;
        this.fetching = fetching;
    }

    public /* synthetic */ UiState(Screen screen, boolean z, String str, String str2, boolean z2, List list, Set set, boolean z3, String str3, SessionInfo sessionInfo, List list2, List list3, List list4, List list5, List list6, String str4, boolean z4, boolean z5, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Screen.Connect : screen, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? SetsKt.emptySet() : set, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : sessionInfo, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2, (i & 2048) != 0 ? CollectionsKt.emptyList() : list3, (i & 4096) != 0 ? CollectionsKt.emptyList() : list4, (i & 8192) != 0 ? CollectionsKt.emptyList() : list5, (i & 16384) != 0 ? CollectionsKt.emptyList() : list6, (i & 32768) != 0 ? null : str4, (i & 65536) != 0 ? false : z4, (i & 131072) != 0 ? false : z5, (i & 262144) != 0 ? SetsKt.emptySet() : set2);
    }

    public final Screen getScreen() {
        return this.screen;
    }

    public final boolean getConnecting() {
        return this.connecting;
    }

    public final String getError() {
        return this.error;
    }

    public final String getServerVersion() {
        return this.serverVersion;
    }

    public final boolean getLive() {
        return this.live;
    }

    public final List<SessionInfo> getSessions() {
        return this.sessions;
    }

    public final Set<String> getBusy() {
        return this.busy;
    }

    public final boolean getLoadingSessions() {
        return this.loadingSessions;
    }

    public final String getCurrentId() {
        return this.currentId;
    }

    public final SessionInfo getCurrent() {
        return this.current;
    }

    public final List<ChatItem> getItems() {
        return this.items;
    }

    public final List<PermissionReq> getPermissions() {
        return this.permissions;
    }

    public final List<ModelOpt> getModels() {
        return this.models;
    }

    public final List<AgentOpt> getAgents() {
        return this.agents;
    }

    public final List<IntegrationOpt> getIntegrations() {
        return this.integrations;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getLocal() {
        return this.local;
    }

    public final boolean getAutoApprove() {
        return this.autoApprove;
    }

    public final Set<String> getFetching() {
        return this.fetching;
    }
}

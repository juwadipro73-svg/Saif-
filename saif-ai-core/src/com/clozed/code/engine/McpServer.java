package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/clozed/code/engine/McpServer;", "", "name", "", "url", "headers", "enabled", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getUrl", "getHeaders", "getEnabled", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final /* data */ class McpServer {
    public static final int $stable = 0;
    private final boolean enabled;
    private final String headers;
    private final String name;
    private final String url;

    public static /* synthetic */ McpServer copy$default(McpServer mcpServer, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mcpServer.name;
        }
        if ((i & 2) != 0) {
            str2 = mcpServer.url;
        }
        if ((i & 4) != 0) {
            str3 = mcpServer.headers;
        }
        if ((i & 8) != 0) {
            z = mcpServer.enabled;
        }
        return mcpServer.copy(str, str2, str3, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHeaders() {
        return this.headers;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final McpServer copy(String name, String url, String headers, boolean enabled) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new McpServer(name, url, headers, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpServer)) {
            return false;
        }
        McpServer mcpServer = (McpServer) other;
        return Intrinsics.areEqual(this.name, mcpServer.name) && Intrinsics.areEqual(this.url, mcpServer.url) && Intrinsics.areEqual(this.headers, mcpServer.headers) && this.enabled == mcpServer.enabled;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.url.hashCode()) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "McpServer(name=" + this.name + ", url=" + this.url + ", headers=" + this.headers + ", enabled=" + this.enabled + ")";
    }

    public McpServer(String name, String url, String headers, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.name = name;
        this.url = url;
        this.headers = headers;
        this.enabled = z;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getHeaders() {
        return this.headers;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }
}

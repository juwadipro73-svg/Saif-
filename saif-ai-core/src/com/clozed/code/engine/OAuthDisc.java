package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: McpOAuth.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/clozed/code/engine/OAuthDisc;", "", "authEndpoint", "", "tokenEndpoint", "registrationEndpoint", "scopes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthEndpoint", "()Ljava/lang/String;", "getTokenEndpoint", "getRegistrationEndpoint", "getScopes", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class OAuthDisc {
    private final String authEndpoint;
    private final String registrationEndpoint;
    private final String scopes;
    private final String tokenEndpoint;

    public OAuthDisc(String authEndpoint, String tokenEndpoint, String str, String str2) {
        Intrinsics.checkNotNullParameter(authEndpoint, "authEndpoint");
        Intrinsics.checkNotNullParameter(tokenEndpoint, "tokenEndpoint");
        this.authEndpoint = authEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.registrationEndpoint = str;
        this.scopes = str2;
    }

    public final String getAuthEndpoint() {
        return this.authEndpoint;
    }

    public final String getRegistrationEndpoint() {
        return this.registrationEndpoint;
    }

    public final String getScopes() {
        return this.scopes;
    }

    public final String getTokenEndpoint() {
        return this.tokenEndpoint;
    }
}

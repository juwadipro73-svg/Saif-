package com.clozed.code.engine;

import com.clozed.code.data.PermissionReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/clozed/code/engine/PendingPerm;", "", "req", "Lcom/clozed/code/data/PermissionReq;", "reply", "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(Lcom/clozed/code/data/PermissionReq;Lkotlinx/coroutines/CompletableDeferred;)V", "getReq", "()Lcom/clozed/code/data/PermissionReq;", "getReply", "()Lkotlinx/coroutines/CompletableDeferred;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class PendingPerm {
    private final CompletableDeferred<String> reply;
    private final PermissionReq req;

    public PendingPerm(PermissionReq req, CompletableDeferred<String> reply) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.req = req;
        this.reply = reply;
    }

    public final CompletableDeferred<String> getReply() {
        return this.reply;
    }

    public final PermissionReq getReq() {
        return this.req;
    }
}

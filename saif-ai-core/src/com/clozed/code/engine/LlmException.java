package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/clozed/code/engine/LlmException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "retryable", "", "offline", "limitKind", "", "timeout", "<init>", "(Ljava/lang/String;ZZIZ)V", "getRetryable", "()Z", "getOffline", "getLimitKind", "()I", "getTimeout", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class LlmException extends Exception {
    public static final int $stable = 0;
    private final int limitKind;
    private final boolean offline;
    private final boolean retryable;
    private final boolean timeout;

    public /* synthetic */ LlmException(String str, boolean z, boolean z2, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z3);
    }

    public final boolean getRetryable() {
        return this.retryable;
    }

    public final boolean getOffline() {
        return this.offline;
    }

    public final int getLimitKind() {
        return this.limitKind;
    }

    public final boolean getTimeout() {
        return this.timeout;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LlmException(String message, boolean z, boolean z2, int i, boolean z3) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.retryable = z;
        this.offline = z2;
        this.limitKind = i;
        this.timeout = z3;
    }
}

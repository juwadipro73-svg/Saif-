package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Ignore.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/clozed/code/engine/IgnoreRule;", "", "base", "", "regex", "Lkotlin/text/Regex;", "negate", "", "dirOnly", "<init>", "(Ljava/lang/String;Lkotlin/text/Regex;ZZ)V", "getBase", "()Ljava/lang/String;", "getRegex", "()Lkotlin/text/Regex;", "getNegate", "()Z", "getDirOnly", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class IgnoreRule {
    private final String base;
    private final boolean dirOnly;
    private final boolean negate;
    private final Regex regex;

    public IgnoreRule(String base, Regex regex, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(regex, "regex");
        this.base = base;
        this.regex = regex;
        this.negate = z;
        this.dirOnly = z2;
    }

    public final String getBase() {
        return this.base;
    }

    public final boolean getDirOnly() {
        return this.dirOnly;
    }

    public final boolean getNegate() {
        return this.negate;
    }

    public final Regex getRegex() {
        return this.regex;
    }
}

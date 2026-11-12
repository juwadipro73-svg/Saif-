package com.clozed.code.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PermissionsUi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/ui/PermRow;", "", "title", "", "why", "granted", "", "button", "grant", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getWhy", "getGranted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getButton", "getGrant", "()Lkotlin/jvm/functions/Function0;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class PermRow {
    private final String button;
    private final Function0<Unit> grant;
    private final Boolean granted;
    private final String title;
    private final String why;

    public PermRow(String title, String why, Boolean bool, String button, Function0<Unit> grant) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(why, "why");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(grant, "grant");
        this.title = title;
        this.why = why;
        this.granted = bool;
        this.button = button;
        this.grant = grant;
    }

    public final String getButton() {
        return this.button;
    }

    public final Function0<Unit> getGrant() {
        return this.grant;
    }

    public final Boolean getGranted() {
        return this.granted;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getWhy() {
        return this.why;
    }
}

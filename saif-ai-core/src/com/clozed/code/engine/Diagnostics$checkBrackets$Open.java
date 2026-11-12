package com.clozed.code.engine;

import kotlin.Metadata;

/* compiled from: Diagnostics.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"com/clozed/code/engine/Diagnostics$checkBrackets$Open", "", "ch", "", "line", "", "col", "<init>", "(CII)V", "getCh", "()C", "getLine", "()I", "getCol", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Diagnostics$checkBrackets$Open {
    private final char ch;
    private final int col;
    private final int line;

    public Diagnostics$checkBrackets$Open(char c, int i, int i2) {
        this.ch = c;
        this.line = i;
        this.col = i2;
    }

    public final char getCh() {
        return this.ch;
    }

    public final int getCol() {
        return this.col;
    }

    public final int getLine() {
        return this.line;
    }
}

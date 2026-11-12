package com.clozed.code.engine;

import kotlin.Metadata;

/* compiled from: Diagnostics.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/clozed/code/engine/Diagnostics$checkBrackets$Resume", "", "delim", "", "triple", "", "depth", "", "<init>", "(CZI)V", "getDelim", "()C", "getTriple", "()Z", "getDepth", "()I", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Diagnostics$checkBrackets$Resume {
    private final char delim;
    private final int depth;
    private final boolean triple;

    public Diagnostics$checkBrackets$Resume(char c, boolean z, int i) {
        this.delim = c;
        this.triple = z;
        this.depth = i;
    }

    public final char getDelim() {
        return this.delim;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final boolean getTriple() {
        return this.triple;
    }
}

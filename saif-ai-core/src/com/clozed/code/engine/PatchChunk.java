package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/clozed/code/engine/PatchChunk;", "", "header", "", "lines", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getHeader", "()Ljava/lang/String;", "getLines", "()Ljava/util/List;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class PatchChunk {
    private final String header;
    private final List<String> lines;

    public PatchChunk(String str, List<String> lines) {
        Intrinsics.checkNotNullParameter(lines, "lines");
        this.header = str;
        this.lines = lines;
    }

    public final String getHeader() {
        return this.header;
    }

    public final List<String> getLines() {
        return this.lines;
    }
}

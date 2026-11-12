package com.clozed.code.engine;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/clozed/code/engine/FileChange;", "", "file", "Ljava/io/File;", "before", "", "after", "<init>", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getBefore", "()Ljava/lang/String;", "getAfter", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class FileChange {
    private final String after;
    private final String before;
    private final File file;

    public FileChange(File file, String str, String str2) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.before = str;
        this.after = str2;
    }

    public final String getAfter() {
        return this.after;
    }

    public final String getBefore() {
        return this.before;
    }

    public final File getFile() {
        return this.file;
    }
}

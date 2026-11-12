package com.clozed.code.engine;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/clozed/code/engine/Skill;", "", "name", "", "description", "dir", "Ljava/io/File;", "file", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V", "getName", "()Ljava/lang/String;", "getDescription", "getDir", "()Ljava/io/File;", "getFile", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Skill {
    public static final int $stable = 8;
    private final String description;
    private final File dir;
    private final File file;
    private final String name;

    public Skill(String name, String description, File dir, File file) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(file, "file");
        this.name = name;
        this.description = description;
        this.dir = dir;
        this.file = file;
    }

    public final String getDescription() {
        return this.description;
    }

    public final File getDir() {
        return this.dir;
    }

    public final File getFile() {
        return this.file;
    }

    public final String getName() {
        return this.name;
    }
}

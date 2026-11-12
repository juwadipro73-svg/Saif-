package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/PatchOp;", "", "<init>", "()V", "Add", "Delete", "Update", "Lcom/clozed/code/engine/PatchOp$Add;", "Lcom/clozed/code/engine/PatchOp$Delete;", "Lcom/clozed/code/engine/PatchOp$Update;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public abstract class PatchOp {
    public /* synthetic */ PatchOp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Extensions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/PatchOp$Add;", "Lcom/clozed/code/engine/PatchOp;", "path", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getContent", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Add extends PatchOp {
        public static final int $stable = 0;
        private final String content;
        private final String path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Add(String path, String content) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(content, "content");
            this.path = path;
            this.content = content;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getPath() {
            return this.path;
        }
    }

    private PatchOp() {
    }

    /* compiled from: Extensions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/clozed/code/engine/PatchOp$Delete;", "Lcom/clozed/code/engine/PatchOp;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Delete extends PatchOp {
        public static final int $stable = 0;
        private final String path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Delete(String path) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
        }

        public final String getPath() {
            return this.path;
        }
    }

    /* compiled from: Extensions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/clozed/code/engine/PatchOp$Update;", "Lcom/clozed/code/engine/PatchOp;", "path", "", "moveTo", "chunks", "", "Lcom/clozed/code/engine/PatchChunk;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "getMoveTo", "getChunks", "()Ljava/util/List;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Update extends PatchOp {
        public static final int $stable = 8;
        private final List<PatchChunk> chunks;
        private final String moveTo;
        private final String path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(String path, String str, List<PatchChunk> chunks) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            this.path = path;
            this.moveTo = str;
            this.chunks = chunks;
        }

        public final List<PatchChunk> getChunks() {
            return this.chunks;
        }

        public final String getMoveTo() {
            return this.moveTo;
        }

        public final String getPath() {
            return this.path;
        }
    }
}

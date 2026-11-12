package com.clozed.code.data;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/clozed/code/data/ChatItem;", "", "id", "", "getId", "()Ljava/lang/String;", "User", "Assistant", "Notice", "Shell", "Lcom/clozed/code/data/ChatItem$Assistant;", "Lcom/clozed/code/data/ChatItem$Notice;", "Lcom/clozed/code/data/ChatItem$Shell;", "Lcom/clozed/code/data/ChatItem$User;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public interface ChatItem {
    String getId();

    /* compiled from: Models.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/clozed/code/data/ChatItem$User;", "Lcom/clozed/code/data/ChatItem;", "id", "", "text", "fileCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getText", "getFileCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class User implements ChatItem {
        public static final int $stable = 0;
        private final int fileCount;
        private final String id;
        private final String text;

        public static /* synthetic */ User copy$default(User user, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = user.id;
            }
            if ((i2 & 2) != 0) {
                str2 = user.text;
            }
            if ((i2 & 4) != 0) {
                i = user.fileCount;
            }
            return user.copy(str, str2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFileCount() {
            return this.fileCount;
        }

        public final User copy(String id, String text, int fileCount) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            return new User(id, text, fileCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof User)) {
                return false;
            }
            User user = (User) other;
            return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.text, user.text) && this.fileCount == user.fileCount;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.fileCount);
        }

        public String toString() {
            return "User(id=" + this.id + ", text=" + this.text + ", fileCount=" + this.fileCount + ")";
        }

        public User(String id, String text, int i) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            this.id = id;
            this.text = text;
            this.fileCount = i;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        @Override // com.clozed.code.data.ChatItem
        public String getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: Models.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lcom/clozed/code/data/ChatItem$Assistant;", "Lcom/clozed/code/data/ChatItem;", "id", "", "blocks", "", "Lcom/clozed/code/data/Block;", "model", "streaming", "", "error", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getBlocks", "()Ljava/util/List;", "getModel", "getStreaming", "()Z", "getError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class Assistant implements ChatItem {
        public static final int $stable = 8;
        private final List<Block> blocks;
        private final String error;
        private final String id;
        private final String model;
        private final boolean streaming;

        public static /* synthetic */ Assistant copy$default(Assistant assistant, String str, List list, String str2, boolean z, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = assistant.id;
            }
            if ((i & 2) != 0) {
                list = assistant.blocks;
            }
            if ((i & 4) != 0) {
                str2 = assistant.model;
            }
            if ((i & 8) != 0) {
                z = assistant.streaming;
            }
            if ((i & 16) != 0) {
                str3 = assistant.error;
            }
            String str4 = str3;
            String str5 = str2;
            return assistant.copy(str, list, str5, z, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final List<Block> component2() {
            return this.blocks;
        }

        /* renamed from: component3, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getStreaming() {
            return this.streaming;
        }

        /* renamed from: component5, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final Assistant copy(String id, List<? extends Block> blocks, String model, boolean streaming, String error) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(blocks, "blocks");
            Intrinsics.checkNotNullParameter(model, "model");
            return new Assistant(id, blocks, model, streaming, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Assistant)) {
                return false;
            }
            Assistant assistant = (Assistant) other;
            return Intrinsics.areEqual(this.id, assistant.id) && Intrinsics.areEqual(this.blocks, assistant.blocks) && Intrinsics.areEqual(this.model, assistant.model) && this.streaming == assistant.streaming && Intrinsics.areEqual(this.error, assistant.error);
        }

        public int hashCode() {
            int hashCode = ((((((this.id.hashCode() * 31) + this.blocks.hashCode()) * 31) + this.model.hashCode()) * 31) + Boolean.hashCode(this.streaming)) * 31;
            String str = this.error;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Assistant(id=" + this.id + ", blocks=" + this.blocks + ", model=" + this.model + ", streaming=" + this.streaming + ", error=" + this.error + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Assistant(String id, List<? extends Block> blocks, String model, boolean z, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(blocks, "blocks");
            Intrinsics.checkNotNullParameter(model, "model");
            this.id = id;
            this.blocks = blocks;
            this.model = model;
            this.streaming = z;
            this.error = str;
        }

        @Override // com.clozed.code.data.ChatItem
        public String getId() {
            return this.id;
        }

        public final List<Block> getBlocks() {
            return this.blocks;
        }

        public final String getModel() {
            return this.model;
        }

        public final boolean getStreaming() {
            return this.streaming;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* compiled from: Models.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/clozed/code/data/ChatItem$Notice;", "Lcom/clozed/code/data/ChatItem;", "id", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class Notice implements ChatItem {
        public static final int $stable = 0;
        private final String id;
        private final String text;

        public static /* synthetic */ Notice copy$default(Notice notice, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notice.id;
            }
            if ((i & 2) != 0) {
                str2 = notice.text;
            }
            return notice.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Notice copy(String id, String text) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            return new Notice(id, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notice)) {
                return false;
            }
            Notice notice = (Notice) other;
            return Intrinsics.areEqual(this.id, notice.id) && Intrinsics.areEqual(this.text, notice.text);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Notice(id=" + this.id + ", text=" + this.text + ")";
        }

        public Notice(String id, String text) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            this.id = id;
            this.text = text;
        }

        @Override // com.clozed.code.data.ChatItem
        public String getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: Models.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/clozed/code/data/ChatItem$Shell;", "Lcom/clozed/code/data/ChatItem;", "id", "", "command", NotificationCompat.CATEGORY_STATUS, "output", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getCommand", "getStatus", "getOutput", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class Shell implements ChatItem {
        public static final int $stable = 0;
        private final String command;
        private final String id;
        private final String output;
        private final String status;

        public static /* synthetic */ Shell copy$default(Shell shell, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = shell.id;
            }
            if ((i & 2) != 0) {
                str2 = shell.command;
            }
            if ((i & 4) != 0) {
                str3 = shell.status;
            }
            if ((i & 8) != 0) {
                str4 = shell.output;
            }
            return shell.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCommand() {
            return this.command;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component4, reason: from getter */
        public final String getOutput() {
            return this.output;
        }

        public final Shell copy(String id, String command, String status, String output) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(output, "output");
            return new Shell(id, command, status, output);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Shell)) {
                return false;
            }
            Shell shell = (Shell) other;
            return Intrinsics.areEqual(this.id, shell.id) && Intrinsics.areEqual(this.command, shell.command) && Intrinsics.areEqual(this.status, shell.status) && Intrinsics.areEqual(this.output, shell.output);
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.command.hashCode()) * 31) + this.status.hashCode()) * 31) + this.output.hashCode();
        }

        public String toString() {
            return "Shell(id=" + this.id + ", command=" + this.command + ", status=" + this.status + ", output=" + this.output + ")";
        }

        public Shell(String id, String command, String status, String output) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(output, "output");
            this.id = id;
            this.command = command;
            this.status = status;
            this.output = output;
        }

        public final String getCommand() {
            return this.command;
        }

        @Override // com.clozed.code.data.ChatItem
        public String getId() {
            return this.id;
        }

        public final String getOutput() {
            return this.output;
        }

        public final String getStatus() {
            return this.status;
        }
    }
}

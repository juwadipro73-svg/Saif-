package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/MPart;", "", "<init>", "()V", "Text", "Reasoning", "ToolP", "Lcom/clozed/code/engine/MPart$Reasoning;", "Lcom/clozed/code/engine/MPart$Text;", "Lcom/clozed/code/engine/MPart$ToolP;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public abstract class MPart {
    public static final int $stable = 0;

    public /* synthetic */ MPart(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/clozed/code/engine/MPart$Text;", "Lcom/clozed/code/engine/MPart;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Text extends MPart {
        public static final int $stable = 8;
        private String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }

    private MPart() {
    }

    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/clozed/code/engine/MPart$Reasoning;", "Lcom/clozed/code/engine/MPart;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Reasoning extends MPart {
        public static final int $stable = 8;
        private String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reasoning(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }

    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u000eR=\u0010\u0015\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00170\u0016j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/clozed/code/engine/MPart$ToolP;", "Lcom/clozed/code/engine/MPart;", "callId", "", "name", "args", NotificationCompat.CATEGORY_STATUS, "output", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getStatus", "setStatus", "getOutput", "setOutput", "undo", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "getUndo", "()Ljava/util/ArrayList;", "extra", "getExtra", "setExtra", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class ToolP extends MPart {
        public static final int $stable = 8;
        private String args;
        private final String callId;
        private String extra;
        private String name;
        private String output;
        private String status;
        private final ArrayList<Pair<String, String>> undo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToolP(String callId, String name, String args, String status, String output) {
            super(null);
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(output, "output");
            this.callId = callId;
            this.name = name;
            this.args = args;
            this.status = status;
            this.output = output;
            this.undo = new ArrayList<>();
        }

        public final String getArgs() {
            return this.args;
        }

        public final String getCallId() {
            return this.callId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOutput() {
            return this.output;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setArgs(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.args = str;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final void setOutput(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.output = str;
        }

        public final void setStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.status = str;
        }

        public final ArrayList<Pair<String, String>> getUndo() {
            return this.undo;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }
    }
}

package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/LlmTurn;", "", "<init>", "()V", "User", "Assistant", "ToolResult", "Lcom/clozed/code/engine/LlmTurn$Assistant;", "Lcom/clozed/code/engine/LlmTurn$ToolResult;", "Lcom/clozed/code/engine/LlmTurn$User;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public abstract class LlmTurn {
    public static final int $stable = 0;

    public /* synthetic */ LlmTurn(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Llm.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/engine/LlmTurn$User;", "Lcom/clozed/code/engine/LlmTurn;", "text", "", "images", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getImages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class User extends LlmTurn {
        public static final int $stable = 8;
        private final List<String> images;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ User copy$default(User user, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = user.text;
            }
            if ((i & 2) != 0) {
                list = user.images;
            }
            return user.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final List<String> component2() {
            return this.images;
        }

        public final User copy(String text, List<String> images) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(images, "images");
            return new User(text, images);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof User)) {
                return false;
            }
            User user = (User) other;
            return Intrinsics.areEqual(this.text, user.text) && Intrinsics.areEqual(this.images, user.images);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.images.hashCode();
        }

        public String toString() {
            return "User(text=" + this.text + ", images=" + this.images + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public User(String text, List<String> images) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(images, "images");
            this.text = text;
            this.images = images;
        }

        public /* synthetic */ User(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<String> getImages() {
            return this.images;
        }

        public final String getText() {
            return this.text;
        }
    }

    private LlmTurn() {
    }

    /* compiled from: Llm.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/clozed/code/engine/LlmTurn$Assistant;", "Lcom/clozed/code/engine/LlmTurn;", "text", "", "calls", "", "Lcom/clozed/code/engine/ToolCallRec;", "think", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getCalls", "()Ljava/util/List;", "getThink", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class Assistant extends LlmTurn {
        public static final int $stable = 8;
        private final List<ToolCallRec> calls;
        private final String text;
        private final String think;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Assistant copy$default(Assistant assistant, String str, List list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = assistant.text;
            }
            if ((i & 2) != 0) {
                list = assistant.calls;
            }
            if ((i & 4) != 0) {
                str2 = assistant.think;
            }
            return assistant.copy(str, list, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final List<ToolCallRec> component2() {
            return this.calls;
        }

        /* renamed from: component3, reason: from getter */
        public final String getThink() {
            return this.think;
        }

        public final Assistant copy(String text, List<ToolCallRec> calls, String think) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(calls, "calls");
            return new Assistant(text, calls, think);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Assistant)) {
                return false;
            }
            Assistant assistant = (Assistant) other;
            return Intrinsics.areEqual(this.text, assistant.text) && Intrinsics.areEqual(this.calls, assistant.calls) && Intrinsics.areEqual(this.think, assistant.think);
        }

        public int hashCode() {
            int hashCode = ((this.text.hashCode() * 31) + this.calls.hashCode()) * 31;
            String str = this.think;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Assistant(text=" + this.text + ", calls=" + this.calls + ", think=" + this.think + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Assistant(String text, List<ToolCallRec> calls, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(calls, "calls");
            this.text = text;
            this.calls = calls;
            this.think = str;
        }

        public /* synthetic */ Assistant(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? null : str2);
        }

        public final List<ToolCallRec> getCalls() {
            return this.calls;
        }

        public final String getText() {
            return this.text;
        }

        public final String getThink() {
            return this.think;
        }
    }

    /* compiled from: Llm.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/clozed/code/engine/LlmTurn$ToolResult;", "Lcom/clozed/code/engine/LlmTurn;", "callId", "", "name", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallId", "()Ljava/lang/String;", "getName", "getContent", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class ToolResult extends LlmTurn {
        public static final int $stable = 0;
        private final String callId;
        private final String content;
        private final String name;

        public static /* synthetic */ ToolResult copy$default(ToolResult toolResult, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toolResult.callId;
            }
            if ((i & 2) != 0) {
                str2 = toolResult.name;
            }
            if ((i & 4) != 0) {
                str3 = toolResult.content;
            }
            return toolResult.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCallId() {
            return this.callId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public final ToolResult copy(String callId, String name, String content) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            return new ToolResult(callId, name, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolResult)) {
                return false;
            }
            ToolResult toolResult = (ToolResult) other;
            return Intrinsics.areEqual(this.callId, toolResult.callId) && Intrinsics.areEqual(this.name, toolResult.name) && Intrinsics.areEqual(this.content, toolResult.content);
        }

        public int hashCode() {
            return (((this.callId.hashCode() * 31) + this.name.hashCode()) * 31) + this.content.hashCode();
        }

        public String toString() {
            return "ToolResult(callId=" + this.callId + ", name=" + this.name + ", content=" + this.content + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToolResult(String callId, String name, String content) {
            super(null);
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            this.callId = callId;
            this.name = name;
            this.content = content;
        }

        public final String getCallId() {
            return this.callId;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getName() {
            return this.name;
        }
    }
}

package com.clozed.code.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Markdown.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/clozed/code/ui/Part;", "", "code", "", "text", "", "lang", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getCode", "()Z", "getText", "()Ljava/lang/String;", "getLang", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final /* data */ class Part {
    private final boolean code;
    private final String lang;
    private final String text;

    public static /* synthetic */ Part copy$default(Part part, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = part.code;
        }
        if ((i & 2) != 0) {
            str = part.text;
        }
        if ((i & 4) != 0) {
            str2 = part.lang;
        }
        return part.copy(z, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    public final Part copy(boolean code, String text, String lang) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new Part(code, text, lang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Part)) {
            return false;
        }
        Part part = (Part) other;
        return this.code == part.code && Intrinsics.areEqual(this.text, part.text) && Intrinsics.areEqual(this.lang, part.lang);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.code) * 31) + this.text.hashCode()) * 31) + this.lang.hashCode();
    }

    public String toString() {
        return "Part(code=" + this.code + ", text=" + this.text + ", lang=" + this.lang + ")";
    }

    public Part(boolean z, String text, String lang) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.code = z;
        this.text = text;
        this.lang = lang;
    }

    public final boolean getCode() {
        return this.code;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getText() {
        return this.text;
    }
}

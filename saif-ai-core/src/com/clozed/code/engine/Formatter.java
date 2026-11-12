package com.clozed.code.engine;

import java.io.File;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: Diagnostics.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/clozed/code/engine/Formatter;", "", "<init>", "()V", "forNewFile", "", "file", "Ljava/io/File;", "text", "pretty", "s", "prettyArray", "indentJson", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Formatter {
    public static final int $stable = 0;
    public static final Formatter INSTANCE = new Formatter();

    private Formatter() {
    }

    public final String forNewFile(File file, String text) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(text, "text");
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "json") && Diagnostics.INSTANCE.check(file, text).isEmpty() && !StringsKt.isBlank(text)) {
            try {
                String obj = StringsKt.trim((CharSequence) text).toString();
                text = StringsKt.startsWith$default(obj, "[", false, 2, (Object) null) ? prettyArray(obj) : pretty(obj);
            } catch (Exception unused) {
            }
        }
        if (text.length() <= 0 || StringsKt.endsWith$default(text, "\n", false, 2, (Object) null)) {
            return text;
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"json", "kt", "java", "xml", "md", "js", "ts", "py", "gradle", "kts", "yml", "yaml", "txt", "css", "html"});
        String lowerCase2 = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return of.contains(lowerCase2) ? text + "\n" : text;
    }

    private final String pretty(String s) {
        return indentJson(s);
    }

    private final String prettyArray(String s) {
        return indentJson(s);
    }

    private final String indentJson(String s) {
        int i;
        StringBuilder sb = new StringBuilder();
        Ref.IntRef intRef = new Ref.IntRef();
        int i2 = 0;
        boolean z = false;
        while (i2 < s.length()) {
            char charAt = s.charAt(i2);
            if (z) {
                sb.append(charAt);
                if (charAt == '\\' && (i = i2 + 1) < s.length()) {
                    sb.append(s.charAt(i));
                    i2 = i;
                } else if (charAt == '\"') {
                    z = false;
                }
            } else if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                if (charAt == '\"') {
                    sb.append(charAt);
                    z = true;
                } else if (charAt == ',') {
                    sb.append(charAt);
                    indentJson$nl(sb, intRef);
                } else if (charAt != ':') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    sb.append(charAt);
                                }
                            }
                        }
                        intRef.element--;
                        indentJson$nl(sb, intRef);
                        sb.append(charAt);
                    }
                    char c = charAt != '{' ? ']' : '}';
                    int i3 = i2 + 1;
                    while (i3 < s.length() && CharsKt.isWhitespace(s.charAt(i3))) {
                        i3++;
                    }
                    if (i3 >= s.length() || s.charAt(i3) != c) {
                        sb.append(charAt);
                        intRef.element++;
                        indentJson$nl(sb, intRef);
                    } else {
                        sb.append(charAt).append(c);
                        i2 = i3;
                    }
                } else {
                    sb.append(": ");
                }
            }
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private static final void indentJson$nl(StringBuilder sb, Ref.IntRef intRef) {
        sb.append('\n');
        int i = intRef.element;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }
}

package com.clozed.code.engine;

import android.util.Xml;
import com.clozed.code.engine.Diagnostics;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Diagnostics.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J*\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/clozed/code/engine/Diagnostics;", "", "<init>", "()V", "BRACKET_LANGS", "", "", "SINGLE_QUOTE_STRING", "TEMPLATE_LANGS", "HASH_COMMENT", "REGEX_LANGS", "check", "", "Lcom/clozed/code/engine/Diagnostics$Issue;", "file", "Ljava/io/File;", "text", "report", "before", "after", "rel", "checkJson", "checkXml", "checkBrackets", "src", "ext", "Issue", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Diagnostics {
    public static final Diagnostics INSTANCE = new Diagnostics();
    private static final Set<String> BRACKET_LANGS = SetsKt.setOf((Object[]) new String[]{"kt", "kts", "java", "js", "jsx", "ts", "tsx", "mjs", "cjs", "c", "h", "cpp", "cc", "hpp", "cs", "go", "rs", "swift", "dart", "php", "gradle", "groovy", "scala", "css", "scss", "py"});
    private static final Set<String> SINGLE_QUOTE_STRING = SetsKt.setOf((Object[]) new String[]{"js", "jsx", "ts", "tsx", "mjs", "cjs", "css", "scss", "php", "py", "gradle", "groovy", "dart"});
    private static final Set<String> TEMPLATE_LANGS = SetsKt.setOf((Object[]) new String[]{"kt", "kts", "gradle", "groovy", "scala", "js", "jsx", "ts", "tsx", "mjs", "cjs", "dart", "swift"});
    private static final Set<String> HASH_COMMENT = SetsKt.setOf("py");
    private static final Set<String> REGEX_LANGS = SetsKt.setOf((Object[]) new String[]{"js", "jsx", "ts", "tsx", "mjs", "cjs"});
    public static final int $stable = 8;

    /* compiled from: Diagnostics.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/clozed/code/engine/Diagnostics$Issue;", "", "line", "", "col", "message", "", "<init>", "(IILjava/lang/String;)V", "getLine", "()I", "getCol", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final /* data */ class Issue {
        public static final int $stable = 0;
        private final int col;
        private final int line;
        private final String message;

        public static /* synthetic */ Issue copy$default(Issue issue, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = issue.line;
            }
            if ((i3 & 2) != 0) {
                i2 = issue.col;
            }
            if ((i3 & 4) != 0) {
                str = issue.message;
            }
            return issue.copy(i, i2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLine() {
            return this.line;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCol() {
            return this.col;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Issue copy(int line, int col, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Issue(line, col, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Issue)) {
                return false;
            }
            Issue issue = (Issue) other;
            return this.line == issue.line && this.col == issue.col && Intrinsics.areEqual(this.message, issue.message);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.line) * 31) + Integer.hashCode(this.col)) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Issue(line=" + this.line + ", col=" + this.col + ", message=" + this.message + ")";
        }

        public Issue(int i, int i2, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.line = i;
            this.col = i2;
            this.message = message;
        }

        public final int getCol() {
            return this.col;
        }

        public final int getLine() {
            return this.line;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    private Diagnostics() {
    }

    public final List<Issue> check(File file, String text) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(text, "text");
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        try {
            if (Intrinsics.areEqual(lowerCase, "json")) {
                return checkJson(text);
            }
            if (!Intrinsics.areEqual(lowerCase, "xml") && !Intrinsics.areEqual(lowerCase, "svg")) {
                return BRACKET_LANGS.contains(lowerCase) ? checkBrackets(text, lowerCase) : CollectionsKt.emptyList();
            }
            return checkXml(text);
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final String report(File file, String before, String after, String rel) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(after, "after");
        Intrinsics.checkNotNullParameter(rel, "rel");
        List<Issue> check = check(file, after);
        if (check.isEmpty()) {
            return null;
        }
        List<Issue> check2 = before != null ? check(file, before) : CollectionsKt.emptyList();
        if (before == null || check.size() > check2.size()) {
            return "\n\n⚠ Syntax check: possible problems in " + rel + "\n" + CollectionsKt.joinToString$default(CollectionsKt.take(check, 6), "\n", null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.Diagnostics$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence report$lambda$0;
                    report$lambda$0 = Diagnostics.report$lambda$0((Diagnostics.Issue) obj);
                    return report$lambda$0;
                }
            }, 30, null) + "\nRe-read the file around those lines and fix them. (This is a lightweight check; ignore it only if it is clearly a false alarm.)";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence report$lambda$0(Issue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "  line " + it.getLine() + ":" + it.getCol() + "  " + it.getMessage();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.clozed.code.engine.Diagnostics$checkJson$P] */
    private final List<Issue> checkJson(final String text) {
        Integer intOrNull;
        if (StringsKt.isBlank(text)) {
            return CollectionsKt.emptyList();
        }
        ?? r0 = new Object(text) { // from class: com.clozed.code.engine.Diagnostics$checkJson$P
            private int i;
            private final String s;

            {
                Intrinsics.checkNotNullParameter(text, "s");
                this.s = text;
            }

            public final String getS() {
                return this.s;
            }

            public final int getI() {
                return this.i;
            }

            public final void setI(int i) {
                this.i = i;
            }

            public final Pair<Integer, Integer> pos(int at) {
                int min = Math.min(at, this.s.length());
                int i = 1;
                int i2 = 1;
                for (int i3 = 0; i3 < min; i3++) {
                    if (this.s.charAt(i3) == '\n') {
                        i++;
                        i2 = 1;
                    } else {
                        i2++;
                    }
                }
                return TuplesKt.to(Integer.valueOf(i), Integer.valueOf(i2));
            }

            public final Void fail(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                Pair<Integer, Integer> pos = pos(this.i);
                throw new IllegalStateException(pos.component1().intValue() + ":" + pos.component2().intValue() + ":" + msg);
            }

            public final void ws() {
                while (this.i < this.s.length() && StringsKt.contains$default((CharSequence) " \t\r\n", this.s.charAt(this.i), false, 2, (Object) null)) {
                    this.i++;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:51:0x00e0, code lost:
            
                fail("expected ':' after key");
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
            
                throw new kotlin.KotlinNothingValueException();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void value(int r6) {
                /*
                    Method dump skipped, instructions count: 402
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Diagnostics$checkJson$P.value(int):void");
            }

            public final void lit(String w) {
                Intrinsics.checkNotNullParameter(w, "w");
                if (StringsKt.startsWith$default(this.s, w, this.i, false, 4, (Object) null)) {
                    this.i += w.length();
                } else {
                    fail("invalid literal");
                    throw new KotlinNothingValueException();
                }
            }

            public final void num() {
                int i = this.i;
                if (i < this.s.length() && this.s.charAt(this.i) == '-') {
                    this.i++;
                }
                while (this.i < this.s.length() && (Character.isDigit(this.s.charAt(this.i)) || StringsKt.contains$default((CharSequence) ".eE+-", this.s.charAt(this.i), false, 2, (Object) null))) {
                    this.i++;
                }
                int i2 = this.i;
                if (i2 != i) {
                    String substring = this.s.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (StringsKt.toDoubleOrNull(substring) != null) {
                        return;
                    }
                }
                this.i = i;
                Character orNull = StringsKt.getOrNull(this.s, i);
                fail("unexpected character '" + (orNull != null ? orNull.charValue() : ' ') + "'");
                throw new KotlinNothingValueException();
            }

            public final void str() {
                this.i++;
                while (this.i < this.s.length()) {
                    char charAt = this.s.charAt(this.i);
                    if (charAt == '\"') {
                        this.i++;
                        return;
                    } else {
                        if (charAt == '\n') {
                            fail("newline inside string");
                            throw new KotlinNothingValueException();
                        }
                        if (charAt == '\\') {
                            this.i++;
                        }
                        this.i++;
                    }
                }
                fail("unterminated string");
                throw new KotlinNothingValueException();
            }
        };
        try {
            r0.value(0);
            r0.ws();
            if (r0.getI() < text.length()) {
                r0.fail("unexpected content after the JSON value (missing comma?)");
                throw new KotlinNothingValueException();
            }
            return CollectionsKt.emptyList();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "1:1:invalid";
            }
            String str = message;
            int i = 1;
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 3, 2, (Object) null);
            Integer intOrNull2 = StringsKt.toIntOrNull((String) split$default.get(0));
            int intValue = intOrNull2 != null ? intOrNull2.intValue() : 1;
            String str2 = (String) CollectionsKt.getOrNull(split$default, 1);
            if (str2 != null && (intOrNull = StringsKt.toIntOrNull(str2)) != null) {
                i = intOrNull.intValue();
            }
            return CollectionsKt.listOf(new Issue(intValue, i, "Invalid JSON: " + (2 < split$default.size() ? split$default.get(2) : "syntax error")));
        }
    }

    private final List<Issue> checkXml(String text) {
        if (StringsKt.isBlank(text)) {
            return CollectionsKt.emptyList();
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(new StringReader(text));
            do {
            } while (newPullParser.next() != 1);
            return CollectionsKt.emptyList();
        } catch (XmlPullParserException e) {
            int coerceAtLeast = RangesKt.coerceAtLeast(e.getLineNumber(), 1);
            int coerceAtLeast2 = RangesKt.coerceAtLeast(e.getColumnNumber(), 1);
            String message = e.getMessage();
            if (message == null) {
                message = "syntax error";
            }
            return CollectionsKt.listOf(new Issue(coerceAtLeast, coerceAtLeast2, "Invalid XML: " + StringsKt.take(message, 160)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03c0  */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.clozed.code.engine.Diagnostics.Issue> checkBrackets(java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.Diagnostics.checkBrackets(java.lang.String, java.lang.String):java.util.List");
    }

    private static final void checkBrackets$adv(String str, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3) {
        if (str.charAt(intRef.element) == '\n') {
            intRef2.element++;
            intRef3.element = 1;
        } else {
            intRef3.element++;
        }
        intRef.element++;
    }

    private static final boolean checkBrackets$scanString(Ref.IntRef intRef, int i, String str, ArrayList<Diagnostics$checkBrackets$Open> arrayList, Ref.IntRef intRef2, Ref.IntRef intRef3, ArrayList<Diagnostics$checkBrackets$Resume> arrayList2, char c, boolean z, boolean z2) {
        while (intRef.element < i) {
            char charAt = str.charAt(intRef.element);
            if (charAt == '\\' && !z) {
                checkBrackets$adv(str, intRef, intRef2, intRef3);
                if (intRef.element < i) {
                    checkBrackets$adv(str, intRef, intRef2, intRef3);
                }
            } else {
                if (z) {
                    if (StringsKt.startsWith$default(str, "\"\"\"", intRef.element, false, 4, (Object) null) || (StringsKt.startsWith$default(str, "'''", intRef.element, false, 4, (Object) null) && c == '\'')) {
                        for (int i2 = 0; i2 < 3; i2++) {
                            checkBrackets$adv(str, intRef, intRef2, intRef3);
                        }
                        return false;
                    }
                } else if (charAt == c) {
                    checkBrackets$adv(str, intRef, intRef2, intRef3);
                    return false;
                }
                if (!z && charAt == '\n' && c != '`') {
                    return false;
                }
                if (z2 && charAt == '$' && intRef.element + 1 < i && str.charAt(intRef.element + 1) == '{') {
                    checkBrackets$adv(str, intRef, intRef2, intRef3);
                    checkBrackets$adv(str, intRef, intRef2, intRef3);
                    arrayList.add(new Diagnostics$checkBrackets$Open('{', intRef2.element, intRef3.element - 2));
                    arrayList2.add(new Diagnostics$checkBrackets$Resume(c, z, arrayList.size()));
                    return true;
                }
                checkBrackets$adv(str, intRef, intRef2, intRef3);
            }
        }
        return false;
    }
}

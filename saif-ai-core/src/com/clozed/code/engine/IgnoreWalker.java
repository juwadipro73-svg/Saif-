package com.clozed.code.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Ignore.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0002J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/clozed/code/engine/IgnoreWalker;", "", "root", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "rootPath", "", "hardSkip", "", "globToRegex", "g", "parseLine", "Lcom/clozed/code/engine/IgnoreRule;", "raw", "base", "load", "", "dir", "ignored", "", "f", "isDir", "rules", "walk", "Lkotlin/sequences/Sequence;", "start", "hidden", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class IgnoreWalker {
    public static final int $stable = 8;
    private final Set<String> hardSkip;
    private final String rootPath;

    public IgnoreWalker(File root) {
        Intrinsics.checkNotNullParameter(root, "root");
        String canonicalPath = root.getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
        this.rootPath = canonicalPath;
        this.hardSkip = SetsKt.setOf((Object[]) new String[]{".git", "node_modules", ".gradle", ".idea", "__pycache__", ".acside", ".cxx", ".svn", ".hg"});
    }

    private final String globToRegex(String g) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < g.length()) {
            char charAt = g.charAt(i3);
            String str = g;
            if (StringsKt.startsWith$default(str, "**/", i3, false, 4, (Object) null)) {
                sb.append("(?:.*/)?");
                i3 += 3;
            } else {
                if (StringsKt.startsWith$default(str, "/**", i3, false, 4, (Object) null) && (i2 = i3 + 3) == str.length()) {
                    sb.append("(?:/.*)?");
                } else {
                    if (StringsKt.startsWith$default(str, "**", i3, false, 4, (Object) null)) {
                        sb.append(".*");
                    } else {
                        if (charAt == '*') {
                            sb.append("[^/]*");
                        } else if (charAt == '?') {
                            sb.append("[^/]");
                        } else if (charAt == '[') {
                            String str2 = str;
                            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, ']', i3 + 1, false, 4, (Object) null);
                            if (indexOf$default > i3) {
                                i2 = indexOf$default + 1;
                                sb.append((CharSequence) str2, i3, i2);
                            } else {
                                sb.append("\\[");
                            }
                        } else if (charAt != '\\' || (i = i3 + 1) >= str.length()) {
                            sb.append(Regex.INSTANCE.escape(String.valueOf(charAt)));
                        } else {
                            sb.append(Regex.INSTANCE.escape(String.valueOf(str.charAt(i))));
                        }
                        i3++;
                    }
                    i3 += 2;
                }
                i3 = i2;
            }
            g = str;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final IgnoreRule parseLine(String raw, String base) {
        boolean z;
        String obj = StringsKt.trimEnd((CharSequence) raw).toString();
        if (!StringsKt.isBlank(obj) && !StringsKt.startsWith$default(obj, "#", false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(obj, "!", false, 2, (Object) null)) {
                obj = obj.substring(1);
                Intrinsics.checkNotNullExpressionValue(obj, "substring(...)");
                z = true;
            } else {
                if (StringsKt.startsWith$default(obj, "\\#", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "\\!", false, 2, (Object) null)) {
                    obj = obj.substring(1);
                    Intrinsics.checkNotNullExpressionValue(obj, "substring(...)");
                }
                z = false;
            }
            boolean endsWith$default = StringsKt.endsWith$default(obj, "/", false, 2, (Object) null);
            String trimEnd = StringsKt.trimEnd(obj, '/');
            String str = trimEnd;
            if (str.length() == 0) {
                return null;
            }
            boolean contains$default = StringsKt.contains$default((CharSequence) str, '/', false, 2, (Object) null);
            String globToRegex = globToRegex(StringsKt.removePrefix(trimEnd, (CharSequence) "/"));
            try {
                return new IgnoreRule(base, new Regex((contains$default ? new StringBuilder("^").append(globToRegex) : new StringBuilder("^(?:.*/)?").append(globToRegex)).append("$").toString()), z, endsWith$default);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<IgnoreRule> load(File dir) {
        String removePrefix;
        if (Intrinsics.areEqual(dir.getCanonicalPath(), this.rootPath)) {
            removePrefix = "";
        } else {
            String canonicalPath = dir.getCanonicalPath();
            Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
            removePrefix = StringsKt.removePrefix(canonicalPath, (CharSequence) (this.rootPath + "/"));
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(dir, ".gitignore");
            if (file.isFile() && file.length() < 512000) {
                Iterator it = FilesKt.readLines$default(file, null, 1, null).iterator();
                while (it.hasNext()) {
                    IgnoreRule parseLine = parseLine((String) it.next(), removePrefix);
                    if (parseLine != null) {
                        arrayList.add(parseLine);
                    }
                }
            }
            if (removePrefix.length() == 0) {
                File file2 = new File(dir, ".git/info/exclude");
                if (file2.isFile()) {
                    Iterator it2 = FilesKt.readLines$default(file2, null, 1, null).iterator();
                    while (it2.hasNext()) {
                        IgnoreRule parseLine2 = parseLine((String) it2.next(), "");
                        if (parseLine2 != null) {
                            arrayList.add(parseLine2);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ignored(File f, boolean isDir, List<IgnoreRule> rules) {
        String str;
        if (rules.isEmpty()) {
            return false;
        }
        String path = f.getPath();
        Intrinsics.checkNotNull(path);
        if (!StringsKt.startsWith$default(path, this.rootPath + "/", false, 2, (Object) null)) {
            return false;
        }
        String removePrefix = StringsKt.removePrefix(path, (CharSequence) (this.rootPath + "/"));
        boolean z = false;
        for (IgnoreRule ignoreRule : rules) {
            if (!ignoreRule.getDirOnly() || isDir) {
                if (ignoreRule.getBase().length() == 0) {
                    str = removePrefix;
                } else {
                    if (StringsKt.startsWith$default(removePrefix, ignoreRule.getBase() + "/", false, 2, (Object) null)) {
                        str = StringsKt.removePrefix(removePrefix, (CharSequence) (ignoreRule.getBase() + "/"));
                    }
                }
                if (ignoreRule.getRegex().matches(str)) {
                    z = !ignoreRule.getNegate();
                }
            }
        }
        return z;
    }

    public static /* synthetic */ Sequence walk$default(IgnoreWalker ignoreWalker, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ignoreWalker.walk(file, z);
    }

    public final Sequence<File> walk(File start, boolean hidden) {
        Intrinsics.checkNotNullParameter(start, "start");
        return SequencesKt.sequence(new IgnoreWalker$walk$1(start, this, hidden, null));
    }
}

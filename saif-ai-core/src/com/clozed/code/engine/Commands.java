package com.clozed.code.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b¨\u0006\u0014"}, d2 = {"Lcom/clozed/code/engine/Commands;", "", "<init>", "()V", "discover", "", "Lcom/clozed/code/engine/CustomCommand;", "workdir", "Ljava/io/File;", "appFiles", "expand", "", "template", "args", "save", "", "name", "description", "body", "delete", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Commands {
    public static final int $stable = 0;
    public static final Commands INSTANCE = new Commands();

    private Commands() {
    }

    public final List<CustomCommand> discover(File workdir, File appFiles) {
        Intrinsics.checkNotNullParameter(workdir, "workdir");
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        List listOf = CollectionsKt.listOf((Object[]) new File[]{new File(workdir, ".clozed/command"), new File(workdir, ".clozed/commands"), new File(workdir, ".opencode/command"), new File(workdir, ".opencode/commands"), new File(workdir, ".claude/commands"), new File(appFiles, "commands")});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            File[] listFiles = ((File) it.next()).listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.isFile()) {
                        Intrinsics.checkNotNull(file);
                        if (Intrinsics.areEqual(FilesKt.getExtension(file), "md")) {
                            arrayList.add(file);
                        }
                    }
                }
                List<File> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.clozed.code.engine.Commands$discover$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((File) t).getName(), ((File) t2).getName());
                    }
                });
                if (sortedWith != null) {
                    for (File file2 : sortedWith) {
                        try {
                            Intrinsics.checkNotNull(file2);
                            Pair<Map<String, String>, String> parseFrontmatter = ExtensionsKt.parseFrontmatter(FilesKt.readText$default(file2, null, 1, null));
                            Map<String, String> component1 = parseFrontmatter.component1();
                            String component2 = parseFrontmatter.component2();
                            String nameWithoutExtension = FilesKt.getNameWithoutExtension(file2);
                            if (!linkedHashMap.containsKey(nameWithoutExtension)) {
                                LinkedHashMap linkedHashMap2 = linkedHashMap;
                                String str = component1.get("description");
                                if (str == null) {
                                    str = "";
                                }
                                linkedHashMap2.put(nameWithoutExtension, new CustomCommand(nameWithoutExtension, str, component1.get("agent"), StringsKt.trim((CharSequence) component2).toString()));
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(values);
    }

    public final String expand(String template, String args) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = args;
        List<String> split = new Regex("\\s+").split(StringsKt.trim((CharSequence) str).toString(), 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        String str2 = template;
        boolean z = StringsKt.contains$default((CharSequence) str2, (CharSequence) "$ARGUMENTS", false, 2, (Object) null) || new Regex("\\$[1-9]").containsMatchIn(str2);
        String replace$default = StringsKt.replace$default(template, "$ARGUMENTS", StringsKt.trim((CharSequence) str).toString(), false, 4, (Object) null);
        for (int i = 9; i > 0; i--) {
            int i2 = i - 1;
            replace$default = StringsKt.replace$default(replace$default, "$" + i, (String) ((i2 < 0 || i2 >= arrayList2.size()) ? "" : arrayList2.get(i2)), false, 4, (Object) null);
        }
        if (z || StringsKt.isBlank(str)) {
            return replace$default;
        }
        return replace$default + "\n\n" + StringsKt.trim((CharSequence) str).toString();
    }

    public final void save(File appFiles, String name, String description, String body) {
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(body, "body");
        String lowerCase = StringsKt.removePrefix(StringsKt.trim((CharSequence) name).toString(), (CharSequence) "/").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String trim = StringsKt.trim(new Regex("[^a-z0-9_-]+").replace(lowerCase, "-"), '-');
        if (trim.length() == 0) {
            trim = "command";
        }
        File file = new File(appFiles, "commands");
        file.mkdirs();
        FilesKt.writeText$default(new File(file, trim + ".md"), "---\ndescription: " + StringsKt.replace$default(description, "\n", " ", false, 4, (Object) null) + "\n---\n\n" + body + "\n", null, 2, null);
    }

    public final void delete(File appFiles, String name) {
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        Intrinsics.checkNotNullParameter(name, "name");
        new File(appFiles, "commands/" + name + ".md").delete();
    }
}

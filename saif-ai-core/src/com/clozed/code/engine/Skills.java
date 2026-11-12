package com.clozed.code.engine;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ&\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f¨\u0006\u0019"}, d2 = {"Lcom/clozed/code/engine/Skills;", "", "<init>", "()V", "installBundled", "", "ctx", "Landroid/content/Context;", "copyAsset", "am", "Landroid/content/res/AssetManager;", "path", "", "dest", "Ljava/io/File;", "discover", "", "Lcom/clozed/code/engine/Skill;", "workdir", "appFiles", "save", "name", "description", "body", "delete", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Skills {
    public static final int $stable = 0;
    public static final Skills INSTANCE = new Skills();

    private Skills() {
    }

    public final void installBundled(Context ctx) {
        AssetManager assets;
        String[] list;
        LinkedHashSet linkedHashSet;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            assets = ctx.getAssets();
            list = assets.list("skills");
        } catch (Exception unused) {
        }
        if (list == null) {
            return;
        }
        File file = new File(ctx.getFilesDir(), "skills/.bundled");
        if (file.isFile()) {
            List readLines$default = FilesKt.readLines$default(file, null, 1, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : readLines$default) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            linkedHashSet = CollectionsKt.toMutableSet(arrayList);
        } else {
            linkedHashSet = new LinkedHashSet();
        }
        for (String str : list) {
            if (!linkedHashSet.contains(str)) {
                File file2 = new File(ctx.getFilesDir(), "skills/" + str);
                if (!file2.exists()) {
                    Intrinsics.checkNotNull(assets);
                    try {
                        copyAsset(assets, "skills/" + str, file2);
                    } catch (Exception unused2) {
                        return;
                    }
                }
                Intrinsics.checkNotNull(str);
                linkedHashSet.add(str);
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FilesKt.writeText$default(file, CollectionsKt.joinToString$default(linkedHashSet, "\n", null, null, 0, null, null, 62, null), null, 2, null);
    }

    private final void copyAsset(AssetManager am, String path, File dest) {
        String[] list = am.list(path);
        if (list == null || list.length == 0) {
            File parentFile = dest.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream open = am.open(path);
            try {
                InputStream inputStream = open;
                open = new FileOutputStream(dest);
                try {
                    Intrinsics.checkNotNull(inputStream);
                    long copyTo$default = ByteStreamsKt.copyTo$default(inputStream, open, 0, 2, null);
                    CloseableKt.closeFinally(open, null);
                    Long.valueOf(copyTo$default);
                    CloseableKt.closeFinally(open, null);
                } finally {
                }
            } finally {
            }
        } else {
            dest.mkdirs();
            for (String str : list) {
                INSTANCE.copyAsset(am, path + "/" + str, new File(dest, str));
            }
        }
    }

    public final List<Skill> discover(File workdir, File appFiles) {
        Intrinsics.checkNotNullParameter(workdir, "workdir");
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        List listOf = CollectionsKt.listOf((Object[]) new File[]{new File(workdir, ".clozed/skills"), new File(workdir, ".clozed/skill"), new File(workdir, ".opencode/skills"), new File(workdir, ".opencode/skill"), new File(workdir, ".claude/skills"), new File(workdir, ".agents/skills"), new File(appFiles, "skills")});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            File[] listFiles = ((File) it.next()).listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        arrayList.add(file);
                    }
                }
                List<File> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.clozed.code.engine.Skills$discover$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((File) t).getName(), ((File) t2).getName());
                    }
                });
                if (sortedWith != null) {
                    for (File file2 : sortedWith) {
                        File file3 = new File(file2, "SKILL.md");
                        if (file3.isFile()) {
                            try {
                                Map<String, String> component1 = ExtensionsKt.parseFrontmatter(FilesKt.readText$default(file3, null, 1, null)).component1();
                                String str = component1.get("name");
                                if (str == null) {
                                    str = file2.getName();
                                }
                                Intrinsics.checkNotNull(str);
                                String obj = StringsKt.trim((CharSequence) str).toString();
                                if (obj.length() > 0 && !linkedHashMap.containsKey(obj)) {
                                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                                    String str2 = component1.get("description");
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    Intrinsics.checkNotNull(file2);
                                    linkedHashMap2.put(obj, new Skill(obj, str2, file2, file3));
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(values);
    }

    public final void save(File appFiles, String name, String description, String body) {
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(body, "body");
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String trim = StringsKt.trim(new Regex("[^a-z0-9]+").replace(lowerCase, "-"), '-');
        if (trim.length() == 0) {
            trim = "skill";
        }
        String str = trim;
        File file = new File(appFiles, "skills/" + str);
        file.mkdirs();
        FilesKt.writeText$default(new File(file, "SKILL.md"), "---\nname: " + str + "\ndescription: " + StringsKt.replace$default(description, "\n", " ", false, 4, (Object) null) + "\n---\n\n" + body + "\n", null, 2, null);
    }

    public final void delete(File appFiles, String name) {
        Intrinsics.checkNotNullParameter(appFiles, "appFiles");
        Intrinsics.checkNotNullParameter(name, "name");
        FilesKt.deleteRecursively(new File(appFiles, "skills/" + name));
    }
}

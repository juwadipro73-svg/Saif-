package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001aG\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\r0\f\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\rH\u0002¢\u0006\u0002\u0010\u000e\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015H\u0002\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004\u001a\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002\u001a \u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0004H\u0000\u001a\u001e\u0010\"\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010#\u001a\u0010\u0010$\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0019H\u0002\u001a&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190&2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0002\u001a\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004\u001a \u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0015H\u0002\u001a\u0014\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002\u001a\b\u00104\u001a\u00020\u0001H\u0002\u001a\b\u00105\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"sStr", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "d", "", "(Ljava/lang/String;)Lorg/json/JSONObject;", "sInt", "sBool", "sObj", "required", "", "props", "", "Lkotlin/Pair;", "(Ljava/util/List;[Lkotlin/Pair;)Lorg/json/JSONObject;", "optStr", "k", "optIntOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "optBoolOr", "", "SKIP_DIRS", "", "resolvePath", "Ljava/io/File;", "c", "Lcom/clozed/code/engine/ToolCtx;", "p", "rel", "f", "planGuard", "", "tool", "guardExternal", "(Lcom/clozed/code/engine/ToolCtx;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "looksBinary", "walk", "Lkotlin/sequences/Sequence;", "start", "hidden", "globToRegex", "Lkotlin/text/Regex;", "glob", "matchGlob", "re", "relPath", "hasSlash", "readNBytesCompat", "", "Ljava/io/InputStream;", "max", "todoSchema", "questionSchema", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ToolsKt {
    private static final Set<String> SKIP_DIRS = SetsKt.setOf((Object[]) new String[]{".git", "node_modules", ".gradle", ".idea", "__pycache__", ".acside"});

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject sStr(String str) {
        return new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "string").put("description", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject sInt(String str) {
        return new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "integer").put("description", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject sBool(String str) {
        return new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "boolean").put("description", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject sObj(List<String> list, Pair<String, ? extends JSONObject>... pairArr) {
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends JSONObject> pair : pairArr) {
            jSONObject.put(pair.getFirst(), pair.getSecond());
        }
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object").put("properties", jSONObject).put("required", new JSONArray((Collection) list));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String optStr(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer optIntOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Integer.valueOf(jSONObject.optInt(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean optBoolOr(JSONObject jSONObject, String str, boolean z) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? z : jSONObject.optBoolean(str, z);
    }

    public static final File resolvePath(ToolCtx c, String p) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        File file = new File(p);
        if (!file.isAbsolute()) {
            file = new File(c.getWorkdir(), p);
        }
        File canonicalFile = file.getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(canonicalFile, "getCanonicalFile(...)");
        return canonicalFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String rel(ToolCtx toolCtx, File file) {
        String canonicalPath = toolCtx.getWorkdir().getCanonicalPath();
        if (Intrinsics.areEqual(file.getPath(), canonicalPath)) {
            return ".";
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        if (StringsKt.startsWith$default(path, canonicalPath + "/", false, 2, (Object) null)) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            return StringsKt.removePrefix(path2, (CharSequence) (canonicalPath + "/"));
        }
        String path3 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
        return path3;
    }

    public static final void planGuard(ToolCtx c, File f, String tool) {
        Object obj;
        String canonicalPath;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(tool, "tool");
        Iterator<T> it = c.getReadOnly().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            File file = (File) obj;
            if (Intrinsics.areEqual(f.getPath(), file.getPath())) {
                break;
            }
            String path = f.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            if (StringsKt.startsWith$default(path, file.getPath() + "/", false, 2, (Object) null)) {
                break;
            }
        }
        File file2 = (File) obj;
        if (file2 != null) {
            throw new ToolError(file2.getPath() + " is a read-only source project. Write the ported code into the current project instead.");
        }
        if (Intrinsics.areEqual(c.getAgent(), "plan")) {
            File planDir = c.getPlanDir();
            if (planDir == null || (canonicalPath = planDir.getCanonicalPath()) == null) {
                throw new ToolError("Plan mode: files cannot be modified");
            }
            if (Intrinsics.areEqual(f.getPath(), canonicalPath)) {
                return;
            }
            String path2 = f.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            if (!StringsKt.startsWith$default(path2, canonicalPath + "/", false, 2, (Object) null)) {
                throw new ToolError("Cannot use " + tool + " to modify files outside the Plan directory: " + canonicalPath);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object guardExternal(ToolCtx toolCtx, File file, Continuation<? super Unit> continuation) {
        List<File> trusted = toolCtx.getTrusted();
        if (!(trusted instanceof Collection) || !trusted.isEmpty()) {
            for (File file2 : trusted) {
                if (!Intrinsics.areEqual(file.getPath(), file2.getCanonicalPath())) {
                    String path = file.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    if (StringsKt.startsWith$default(path, file2.getCanonicalPath() + "/", false, 2, (Object) null)) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        String canonicalPath = toolCtx.getWorkdir().getCanonicalPath();
        if (!Intrinsics.areEqual(file.getPath(), canonicalPath)) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            if (!StringsKt.startsWith$default(path2, canonicalPath + "/", false, 2, (Object) null)) {
                Object invoke = toolCtx.getPermit().invoke("external_directory", CollectionsKt.listOf(file.getPath()), "Access outside the project folder", continuation);
                return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean looksBinary(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[4096];
            int read = fileInputStream.read(bArr);
            for (int i = 0; i < read; i++) {
                if (bArr[i] == 0) {
                    CloseableKt.closeFinally(fileInputStream, null);
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
            return false;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence<File> walk(ToolCtx toolCtx, File file, boolean z) {
        File canonicalFile = toolCtx.getWorkdir().getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(canonicalFile, "getCanonicalFile(...)");
        return new IgnoreWalker(canonicalFile).walk(file, z);
    }

    public static final Regex globToRegex(String glob) {
        int i;
        Intrinsics.checkNotNullParameter(glob, "glob");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < glob.length()) {
            char charAt = glob.charAt(i2);
            String str = glob;
            if (StringsKt.startsWith$default(str, "**/", i2, false, 4, (Object) null)) {
                sb.append("(?:.*/)?");
                i2 += 3;
            } else if (StringsKt.startsWith$default(str, "**", i2, false, 4, (Object) null)) {
                sb.append(".*");
                i2 += 2;
            } else {
                if (charAt == '*') {
                    sb.append("[^/]*");
                } else if (charAt == '?') {
                    sb.append("[^/]");
                } else {
                    if (charAt == '{') {
                        sb.append("(?:");
                        i = i3 + 1;
                        Integer.valueOf(i3);
                    } else if (charAt == '}' && i3 > 0) {
                        sb.append(")");
                        i = i3 - 1;
                        Integer.valueOf(i3);
                    } else if (charAt == ',' && i3 > 0) {
                        sb.append("|");
                    } else if (StringsKt.contains$default((CharSequence) ".()+^$|\\[]}", charAt, false, 2, (Object) null)) {
                        sb.append("\\").append(charAt);
                    } else {
                        sb.append(charAt);
                    }
                    i3 = i;
                }
                i2++;
            }
            glob = str;
        }
        return new Regex("^" + ((Object) sb) + "$");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean matchGlob(Regex regex, String str, boolean z) {
        if (!z) {
            str = StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
        }
        return regex.matches(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] readNBytesCompat(InputStream inputStream, int i) {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (byteArrayOutputStream.size() < i && (read = inputStream.read(bArr)) >= 0) {
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject todoSchema() {
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object").put("properties", new JSONObject().put("todos", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "array").put("description", "The updated todo list").put("items", sObj(CollectionsKt.listOf((Object[]) new String[]{"content", NotificationCompat.CATEGORY_STATUS}), TuplesKt.to("content", sStr("Brief description of the task")), TuplesKt.to(NotificationCompat.CATEGORY_STATUS, sStr("Current status of the task: pending, in_progress, completed, cancelled")))))).put("required", new JSONArray((Collection) CollectionsKt.listOf("todos")));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject questionSchema() {
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object").put("properties", new JSONObject().put("questions", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "array").put("description", "Questions to ask").put("items", sObj(CollectionsKt.listOf("question"), TuplesKt.to("question", sStr("The question to ask")), TuplesKt.to("header", sStr("Very short title")), TuplesKt.to("options", new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "array").put("items", sObj(CollectionsKt.listOf("label"), TuplesKt.to("label", sStr("Short choice label")), TuplesKt.to("description", sStr("What this choice means"))))))))).put("required", new JSONArray((Collection) CollectionsKt.listOf("questions")));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }
}

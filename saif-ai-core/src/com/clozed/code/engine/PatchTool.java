package com.clozed.code.engine;

import com.clozed.code.engine.PatchOp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J,\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J&\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fH\u0002J\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/clozed/code/engine/PatchTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "parse", "", "Lcom/clozed/code/engine/PatchOp;", "text", "seek", "", "lines", "old", "from", "applyUpdate", "path", "original", "chunks", "Lcom/clozed/code/engine/PatchChunk;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class PatchTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final PatchTool INSTANCE = new PatchTool();
    private static final String name = "patch";
    private static final String description = "Use the `patch` tool to edit files. Your patch language is a stripped-down, file-oriented diff format designed to be easy to parse and safe to apply.\n\n*** Begin Patch\n[ one or more file sections ]\n*** End Patch\n\nEach operation starts with one of three headers:\n*** Add File: <path> - create a new file. Every following line is a + line (the initial contents).\n*** Delete File: <path> - remove an existing file. Nothing follows.\n*** Update File: <path> - patch an existing file in place (optionally followed by `*** Move to: <new path>`).\n\nFor Update, each hunk starts with `@@` (optionally followed by a line of context such as a function signature). Lines inside a hunk start with ' ' (unchanged context), '-' (removed) or '+' (added). Include about 3 lines of context before and after each change so it can be located uniquely.\n\nExample:\n*** Begin Patch\n*** Add File: hello.txt\n+Hello world\n*** Update File: src/app.py\n*** Move to: src/main.py\n@@ def greet():\n-print(\"Hi\")\n+print(\"Hello, world!\")\n*** Delete File: obsolete.txt\n*** End Patch\n\nYou must include a header with your intended action (Add/Delete/Update) and prefix new lines with `+` even when creating a new file. All changes are validated first; if any hunk fails, nothing is written. File paths may be relative to the working directory.";

    private PatchTool() {
    }

    static {
        JSONObject sStr;
        JSONObject objSchema;
        List listOf = CollectionsKt.listOf("patchText");
        sStr = ExtensionsKt.sStr("The full patch text that describes all changes to be made");
        objSchema = ExtensionsKt.objSchema(listOf, TuplesKt.to("patchText", sStr));
        schema = objSchema;
        $stable = 8;
    }

    @Override // com.clozed.code.engine.Tool
    public String getName() {
        return name;
    }

    @Override // com.clozed.code.engine.Tool
    public String getDescription() {
        return description;
    }

    @Override // com.clozed.code.engine.Tool
    public JSONObject getSchema() {
        return schema;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [T, java.util.ArrayList] */
    public final List<PatchOp> parse(String text) {
        List list;
        String str;
        String str2;
        int i;
        int i2;
        int i3 = 1;
        String str3 = "\n";
        List split$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(text, "\r\n", "\n", false, 4, (Object) null), new String[]{"\n"}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) it.next()).toString(), "*** Begin Patch")) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            throw new ToolError("Patch must start with '*** Begin Patch'");
        }
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + 1;
        while (i5 < split$default.size()) {
            String str4 = (String) split$default.get(i5);
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) str4).toString(), "*** End Patch")) {
                break;
            }
            int i6 = 2;
            if (StringsKt.startsWith$default(str4, "*** Add File:", false, 2, (Object) null)) {
                String obj = StringsKt.trim((CharSequence) StringsKt.removePrefix(str4, (CharSequence) "*** Add File:")).toString();
                i5++;
                ArrayList arrayList2 = new ArrayList();
                while (i5 < split$default.size() && !StringsKt.startsWith$default((String) split$default.get(i5), "*** ", false, 2, (Object) null)) {
                    String str5 = (String) split$default.get(i5);
                    if (StringsKt.startsWith$default(str5, "+", false, 2, (Object) null)) {
                        String substring = str5.substring(i3);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        arrayList2.add(substring);
                    } else {
                        if (str5.length() != 0) {
                            throw new ToolError("Add File lines must start with '+': " + str5);
                        }
                        arrayList2.add("");
                    }
                    i5++;
                }
                while (!arrayList2.isEmpty() && ((CharSequence) CollectionsKt.last((List) arrayList2)).length() == 0 && (i5 >= split$default.size() || StringsKt.startsWith$default((String) split$default.get(i5), "*** ", false, 2, (Object) null))) {
                    arrayList2.remove(arrayList2.size() - i3);
                }
                arrayList.add(new PatchOp.Add(obj, CollectionsKt.joinToString$default(arrayList2, str3, null, null, 0, null, null, 62, null) + str3));
            } else if (StringsKt.startsWith$default(str4, "*** Delete File:", false, 2, (Object) null)) {
                arrayList.add(new PatchOp.Delete(StringsKt.trim((CharSequence) StringsKt.removePrefix(str4, (CharSequence) "*** Delete File:")).toString()));
                i5++;
            } else {
                if (StringsKt.startsWith$default(str4, "*** Update File:", false, 2, (Object) null)) {
                    String obj2 = StringsKt.trim((CharSequence) StringsKt.removePrefix(str4, (CharSequence) "*** Update File:")).toString();
                    int i7 = i5 + 1;
                    if (i7 >= split$default.size() || !StringsKt.startsWith$default((String) split$default.get(i7), "*** Move to:", false, 2, (Object) null)) {
                        str = null;
                    } else {
                        String obj3 = StringsKt.trim((CharSequence) StringsKt.removePrefix((String) split$default.get(i7), (CharSequence) "*** Move to:")).toString();
                        i7 = i5 + 2;
                        str = obj3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = new ArrayList();
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    while (true) {
                        if (i7 >= split$default.size()) {
                            str2 = str3;
                            break;
                        }
                        if (StringsKt.startsWith$default((String) split$default.get(i7), "*** ", false, i6, (Object) null)) {
                            str2 = str3;
                            i = 2;
                            if (!StringsKt.startsWith$default((String) split$default.get(i7), "*** End of File", false, 2, (Object) null)) {
                                break;
                            }
                        } else {
                            str2 = str3;
                            i = 2;
                        }
                        String str6 = (String) split$default.get(i7);
                        List list2 = split$default;
                        if (StringsKt.startsWith$default(str6, "@@", false, i, (Object) null)) {
                            parse$flush(booleanRef, objectRef2, arrayList3, objectRef);
                            String obj4 = StringsKt.trim((CharSequence) StringsKt.removePrefix(str6, (CharSequence) "@@")).toString();
                            int length = obj4.length();
                            T t = obj4;
                            if (length == 0) {
                                t = 0;
                            }
                            objectRef.element = t;
                            booleanRef.element = true;
                            i2 = 2;
                        } else {
                            i2 = 2;
                            if (!StringsKt.startsWith$default(str6, "*** End of File", false, 2, (Object) null)) {
                                if (StringsKt.startsWith$default(str6, "+", false, 2, (Object) null) || StringsKt.startsWith$default(str6, "-", false, 2, (Object) null) || StringsKt.startsWith$default(str6, " ", false, 2, (Object) null)) {
                                    booleanRef.element = true;
                                    ((ArrayList) objectRef2.element).add(str6);
                                } else {
                                    if (str6.length() != 0) {
                                        throw new ToolError("Unexpected line in hunk (must start with ' ', '+', '-' or '@@'): " + str6);
                                    }
                                    if (booleanRef.element) {
                                        ((ArrayList) objectRef2.element).add(" ");
                                    }
                                }
                            }
                        }
                        i7++;
                        i6 = i2;
                        str3 = str2;
                        split$default = list2;
                    }
                    list = split$default;
                    parse$flush(booleanRef, objectRef2, arrayList3, objectRef);
                    arrayList.add(new PatchOp.Update(obj2, str, arrayList3));
                    i3 = 1;
                    i5 = i7;
                    str3 = str2;
                } else {
                    list = split$default;
                    i5++;
                }
                split$default = list;
            }
        }
        if (arrayList.isEmpty()) {
            throw new ToolError("Patch contains no operations");
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.util.ArrayList] */
    private static final void parse$flush(Ref.BooleanRef booleanRef, Ref.ObjectRef<ArrayList<String>> objectRef, ArrayList<PatchChunk> arrayList, Ref.ObjectRef<String> objectRef2) {
        if (booleanRef.element && !objectRef.element.isEmpty()) {
            arrayList.add(new PatchChunk(objectRef2.element, objectRef.element));
        }
        objectRef.element = new ArrayList();
        booleanRef.element = false;
    }

    private static final boolean seek$at(List<String> list, List<String> list2, int i, Function2<? super String, ? super String, Boolean> function2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!function2.invoke(list2.get(i + i2), list.get(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private final int seek(List<String> lines, List<String> old, int from) {
        for (Function2 function2 : CollectionsKt.listOf((Object[]) new Function2[]{new Function2() { // from class: com.clozed.code.engine.PatchTool$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                boolean seek$lambda$2;
                seek$lambda$2 = PatchTool.seek$lambda$2((String) obj, (String) obj2);
                return Boolean.valueOf(seek$lambda$2);
            }
        }, new Function2() { // from class: com.clozed.code.engine.PatchTool$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                boolean seek$lambda$3;
                seek$lambda$3 = PatchTool.seek$lambda$3((String) obj, (String) obj2);
                return Boolean.valueOf(seek$lambda$3);
            }
        }, new Function2() { // from class: com.clozed.code.engine.PatchTool$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                boolean seek$lambda$4;
                seek$lambda$4 = PatchTool.seek$lambda$4((String) obj, (String) obj2);
                return Boolean.valueOf(seek$lambda$4);
            }
        }})) {
            int size = lines.size() - old.size();
            if (from <= size) {
                int i = from;
                while (!seek$at(old, lines, i, function2)) {
                    if (i != size) {
                        i++;
                    }
                }
                return i;
            }
            int min = Math.min(from, (lines.size() - old.size()) + 1);
            for (int i2 = 0; i2 < min; i2++) {
                if (seek$at(old, lines, i2, function2)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean seek$lambda$2(String a, String b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return Intrinsics.areEqual(a, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean seek$lambda$3(String a, String b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return Intrinsics.areEqual(StringsKt.trimEnd((CharSequence) a).toString(), StringsKt.trimEnd((CharSequence) b).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean seek$lambda$4(String a, String b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return Intrinsics.areEqual(StringsKt.trim((CharSequence) a).toString(), StringsKt.trim((CharSequence) b).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String applyUpdate(java.lang.String r19, java.lang.String r20, java.util.List<com.clozed.code.engine.PatchChunk> r21) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.PatchTool.applyUpdate(java.lang.String, java.lang.String, java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence applyUpdate$lambda$11(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "  " + it;
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PatchTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

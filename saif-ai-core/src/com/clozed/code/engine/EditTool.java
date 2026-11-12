package com.clozed.code.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J*\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00160\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/clozed/code/engine/EditTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "norm", "s", "indexesOf", "", "", "hay", "needle", "findRanges", "Lkotlin/Pair;", "content", "old", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class EditTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final EditTool INSTANCE = new EditTool();
    private static final String name = "edit";
    private static final String description = "Edit the contents of a file by finding and replacing exact text. When editing text from Read output, preserve the exact indentation (tabs or spaces) and omit the line-number prefix, such as `1: `. Never include the prefix in oldString or newString. The file's existing CRLF or LF line endings are matched and preserved. If there is no exact match, the edit retries while ignoring typographic quote, dash, and space variants, then trailing whitespace on each line. The edit fails if oldString is not found. By default, oldString must identify a UNIQUE location. Multiple matches FAIL unless replaceAll is true. Add more surrounding context to disambiguate, or set replaceAll to true to replace every occurrence.";

    private EditTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sStr2;
        JSONObject sStr3;
        JSONObject sBool;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"path", "oldString", "newString"});
        sStr = ToolsKt.sStr("File to edit");
        sStr2 = ToolsKt.sStr("Exact text to find and replace");
        sStr3 = ToolsKt.sStr("Text to replace oldString with (must differ from oldString)");
        sBool = ToolsKt.sBool("Whether to replace every occurrence of oldString. When false, oldString must match exactly once. Defaults to false.");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("path", sStr), TuplesKt.to("oldString", sStr2), TuplesKt.to("newString", sStr3), TuplesKt.to("replaceAll", sBool));
        schema = sObj;
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

    private final String norm(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == 160 || charAt == 8201 || charAt == 8239) {
                charAt = ' ';
            } else if (charAt == 8211 || charAt == 8212) {
                charAt = '-';
            } else if (charAt == 8216 || charAt == 8217) {
                charAt = '\'';
            } else if (charAt == 8220 || charAt == 8221) {
                charAt = Typography.quote;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private final List<Integer> indexesOf(String hay, String needle) {
        ArrayList arrayList = new ArrayList();
        String str = hay;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, needle, 0, false, 6, (Object) null);
        while (indexOf$default >= 0) {
            arrayList.add(Integer.valueOf(indexOf$default));
            indexOf$default = StringsKt.indexOf$default((CharSequence) str, needle, indexOf$default + needle.length(), false, 4, (Object) null);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<Integer, Integer>> findRanges(String content, String old) {
        List<Integer> indexesOf = indexesOf(content, old);
        if (indexesOf.isEmpty()) {
            List<Integer> indexesOf2 = indexesOf(norm(content), norm(old));
            if (indexesOf2.isEmpty()) {
                List split$default = StringsKt.split$default((CharSequence) content, new String[]{"\n"}, false, 0, 6, (Object) null);
                List split$default2 = StringsKt.split$default((CharSequence) old, new String[]{"\n"}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
                Iterator it = split$default2.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringsKt.trimEnd((CharSequence) it.next()).toString());
                }
                ArrayList arrayList2 = arrayList;
                int[] iArr = new int[split$default.size()];
                int size = split$default.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = i;
                    i += ((String) split$default.get(i2)).length() + 1;
                }
                ArrayList arrayList3 = new ArrayList();
                int i3 = 0;
                while (arrayList2.size() + i3 <= split$default.size()) {
                    int size2 = arrayList2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            arrayList3.add(TuplesKt.to(Integer.valueOf(iArr[i3]), Integer.valueOf(iArr[(arrayList2.size() + i3) - 1] + ((String) split$default.get((arrayList2.size() + i3) - 1)).length())));
                            i3 += arrayList2.size();
                            break;
                        }
                        if (!Intrinsics.areEqual(StringsKt.trimEnd((CharSequence) split$default.get(i3 + i4)).toString(), arrayList2.get(i4))) {
                            i3++;
                            break;
                        }
                        i4++;
                    }
                }
                return arrayList3;
            }
            List<Integer> list = indexesOf2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue = ((Number) it2.next()).intValue();
                arrayList4.add(TuplesKt.to(Integer.valueOf(intValue), Integer.valueOf(intValue + old.length())));
            }
            return arrayList4;
        }
        List<Integer> list2 = indexesOf;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it3 = list2.iterator();
        while (it3.hasNext()) {
            int intValue2 = ((Number) it3.next()).intValue();
            arrayList5.add(TuplesKt.to(Integer.valueOf(intValue2), Integer.valueOf(intValue2 + old.length())));
        }
        return arrayList5;
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

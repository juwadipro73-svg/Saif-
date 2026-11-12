package com.clozed.code.engine;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a\u001d\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\r\u001aG\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102*\u0010\u0011\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00010\u0012\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0001H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"parseFrontmatter", "Lkotlin/Pair;", "", "", "src", "wildcard", "", "pattern", "text", "sStr", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "d", "(Ljava/lang/String;)Lorg/json/JSONObject;", "objSchema", "required", "", "props", "", "(Ljava/util/List;[Lkotlin/Pair;)Lorg/json/JSONObject;", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ExtensionsKt {
    public static final Pair<Map<String, String>, String> parseFrontmatter(String src) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(src, "src");
        String replace$default = StringsKt.replace$default(src, "\r\n", "\n", false, 4, (Object) null);
        if (!StringsKt.startsWith$default(replace$default, "---\n", false, 2, (Object) null)) {
            return TuplesKt.to(MapsKt.emptyMap(), replace$default);
        }
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) replace$default, "\n---", 4, false, 4, (Object) null);
        if (indexOf$default2 < 0) {
            return TuplesKt.to(MapsKt.emptyMap(), replace$default);
        }
        String substring = replace$default.substring(4, indexOf$default2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = replace$default.substring(indexOf$default2 + 4);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String trimStart = StringsKt.trimStart(substring2, '\n');
        HashMap hashMap = new HashMap();
        for (String str : StringsKt.lines(substring)) {
            if (!StringsKt.startsWith$default(str, " ", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "\t", false, 2, (Object) null) && (indexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null)) > 0) {
                String substring3 = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                String obj = StringsKt.trim((CharSequence) substring3).toString();
                String substring4 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                hashMap.put(obj, StringsKt.trim(StringsKt.trim((CharSequence) substring4).toString(), Typography.quote, '\''));
            }
        }
        return TuplesKt.to(hashMap, trimStart);
    }

    public static final boolean wildcard(String pattern, String text) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(text, "text");
        StringBuilder sb = new StringBuilder("^");
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            char charAt = pattern.charAt(i);
            if (charAt == '*') {
                sb.append(".*");
            } else if (charAt == '?') {
                sb.append(".");
            } else {
                sb.append(Regex.INSTANCE.escape(String.valueOf(charAt)));
            }
        }
        sb.append("$");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return new Regex(sb2, RegexOption.DOT_MATCHES_ALL).matches(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject sStr(String str) {
        return new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "string").put("description", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject objSchema(List<String> list, Pair<String, ? extends JSONObject>... pairArr) {
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends JSONObject> pair : pairArr) {
            jSONObject.put(pair.getFirst(), pair.getSecond());
        }
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "object").put("properties", jSONObject).put("required", new JSONArray((Collection) list));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }
}

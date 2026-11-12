package com.clozed.code.engine;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProviderBackup.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/clozed/code/engine/ProviderBackup;", "", "<init>", "()V", "FORMAT", "", "export", "ctx", "Landroid/content/Context;", "import", "", "text", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderBackup {
    public static final int $stable = 0;
    private static final String FORMAT = "clozed-providers";
    public static final ProviderBackup INSTANCE = new ProviderBackup();

    private ProviderBackup() {
    }

    public final String export(Context ctx) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        String str = "[]";
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        boolean z = false;
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("engine_providers", 0);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Intrinsics.checkNotNull(key);
            if (StringsKt.startsWith$default(key, "key.", false, 2, (Object) null) && (value instanceof String) && !StringsKt.isBlank((CharSequence) value)) {
                jSONObject.put(StringsKt.removePrefix(key, (CharSequence) "key."), value);
            } else if (StringsKt.startsWith$default(key, "enabled.", false, 2, (Object) null) && (value instanceof Boolean)) {
                jSONObject2.put(StringsKt.removePrefix(key, (CharSequence) "enabled."), ((Boolean) value).booleanValue());
            } else if (StringsKt.startsWith$default(key, "fetched.", false, 2, (Object) null) && (value instanceof String)) {
                String removePrefix = StringsKt.removePrefix(key, (CharSequence) "fetched.");
                try {
                    jSONArray4 = new JSONArray((String) value);
                } catch (Exception unused) {
                    jSONArray4 = new JSONArray();
                }
                jSONObject3.put(removePrefix, jSONArray4);
            }
        }
        try {
            String string = sharedPreferences.getString("custom", "[]");
            if (string == null) {
                string = "[]";
            }
            jSONArray = new JSONArray(string);
        } catch (Exception unused2) {
            jSONArray = new JSONArray();
        }
        JSONObject jSONObject4 = new JSONObject();
        Map<String, ?> all2 = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all2, "getAll(...)");
        for (Map.Entry<String, ?> entry2 : all2.entrySet()) {
            String key2 = entry2.getKey();
            Object value2 = entry2.getValue();
            Intrinsics.checkNotNull(key2);
            if (StringsKt.startsWith$default(key2, "keys.", z, 2, (Object) null)) {
                if (value2 instanceof String) {
                    String removePrefix2 = StringsKt.removePrefix(key2, (CharSequence) "keys.");
                    try {
                        jSONArray3 = new JSONArray((String) value2);
                    } catch (Exception unused3) {
                        jSONArray3 = new JSONArray();
                    }
                    jSONObject4.put(removePrefix2, jSONArray3);
                }
                z = false;
            }
        }
        try {
            String string2 = sharedPreferences.getString("chain", "[]");
            if (string2 != null) {
                str = string2;
            }
            jSONArray2 = new JSONArray(str);
        } catch (Exception unused4) {
            jSONArray2 = new JSONArray();
        }
        JSONObject put = new JSONObject().put("format", FORMAT).put("version", 1).put("exportedAt", System.currentTimeMillis());
        String string3 = sharedPreferences.getString("active_provider", "");
        String jSONObject5 = put.put("active", string3 != null ? string3 : "").put("custom", jSONArray).put("keys", jSONObject).put("enabled", jSONObject2).put("fetched", jSONObject3).put("allKeys", jSONObject4).put("chain", jSONArray2).put("autoSwitch", sharedPreferences.getBoolean("auto_switch", true)).toString(2);
        Intrinsics.checkNotNullExpressionValue(jSONObject5, "toString(...)");
        return jSONObject5;
    }

    /* renamed from: import, reason: not valid java name */
    public final int m1288import(Context ctx, String text) {
        JSONArray jSONArray;
        String string;
        String str = "[]";
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            JSONObject jSONObject = new JSONObject(StringsKt.trim((CharSequence) text).toString());
            if (!Intrinsics.areEqual(jSONObject.optString("format"), FORMAT)) {
                throw new IllegalArgumentException("This is not a Clozed Code provider backup");
            }
            SharedPreferences sharedPreferences = ctx.getSharedPreferences("engine_providers", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                String string2 = sharedPreferences.getString("custom", "[]");
                if (string2 != null) {
                    str = string2;
                }
                jSONArray = new JSONArray(str);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    linkedHashMap.put(optJSONObject.optString("id"), optJSONObject);
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("custom");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length2 = optJSONArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("id");
                    Intrinsics.checkNotNull(optString);
                    if (!StringsKt.isBlank(optString)) {
                        String optString2 = optJSONObject2.optString("name");
                        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                        if (!StringsKt.isBlank(optString2)) {
                            String optString3 = optJSONObject2.optString("api");
                            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                            if (!StringsKt.isBlank(optString3)) {
                                linkedHashMap.put(optString, optJSONObject2);
                                linkedHashSet.add(optString);
                            }
                        }
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            Collection values = linkedHashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                jSONArray2.put((JSONObject) it.next());
            }
            edit.putString("custom", jSONArray2.toString());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("keys");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString4 = optJSONObject3.optString(next);
                    Intrinsics.checkNotNull(optString4);
                    if (!StringsKt.isBlank(optString4)) {
                        edit.putString("key." + next, optString4).remove("keys." + next);
                        linkedHashSet.add(next);
                    }
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("allKeys");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "keys(...)");
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONArray optJSONArray2 = optJSONObject4.optJSONArray(next2);
                    if (optJSONArray2 != null) {
                        IntRange until = RangesKt.until(0, optJSONArray2.length());
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                        Iterator<Integer> it2 = until.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(optJSONArray2.optString(((IntIterator) it2).nextInt()));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : arrayList) {
                            String str2 = (String) obj;
                            Intrinsics.checkNotNull(str2);
                            if (!StringsKt.isBlank(str2)) {
                                arrayList2.add(obj);
                            }
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = arrayList3;
                        if (!arrayList4.isEmpty()) {
                            edit.putString("keys." + next2, new JSONArray((Collection) arrayList4).toString()).putString("key." + next2, (String) CollectionsKt.first((List) arrayList3));
                            linkedHashSet.add(next2);
                        }
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("chain");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                edit.putString("chain", optJSONArray3.toString());
            }
            if (jSONObject.has("autoSwitch")) {
                edit.putBoolean("auto_switch", jSONObject.optBoolean("autoSwitch", true));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("enabled");
            if (optJSONObject5 != null) {
                Iterator<String> keys3 = optJSONObject5.keys();
                Intrinsics.checkNotNullExpressionValue(keys3, "keys(...)");
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    edit.putBoolean("enabled." + next3, optJSONObject5.optBoolean(next3, true));
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("fetched");
            if (optJSONObject6 != null) {
                Iterator<String> keys4 = optJSONObject6.keys();
                Intrinsics.checkNotNullExpressionValue(keys4, "keys(...)");
                while (keys4.hasNext()) {
                    String next4 = keys4.next();
                    JSONArray optJSONArray4 = optJSONObject6.optJSONArray(next4);
                    if (optJSONArray4 != null) {
                        edit.putString("fetched." + next4, optJSONArray4.toString());
                    }
                }
            }
            String optString5 = jSONObject.optString("active");
            Intrinsics.checkNotNull(optString5);
            if (!StringsKt.isBlank(optString5) && ((string = sharedPreferences.getString("active_provider", "")) == null || StringsKt.isBlank(string))) {
                edit.putString("active_provider", optString5);
            }
            edit.apply();
            return linkedHashSet.size();
        } catch (Exception unused2) {
            throw new IllegalArgumentException("This is not a valid backup");
        }
    }
}

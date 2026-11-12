package com.clozed.code.engine;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\u0019\u001a\u00020\u0018J\u001c\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020&H\u0002J&\u0010'\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018J$\u0010+\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0018\u0018\u00010,2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010-\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010.\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u001bJ\u0006\u00100\u001a\u00020)J\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u000bJ\u0014\u00106\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002050\u000bJ\f\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ4\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010=\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010?\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u000eJ\u0010\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010G\u001a\u00020\u0018J\u0016\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018J\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\u0019\u001a\u00020\u0018J\u001c\u0010K\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bJ\u001c\u0010L\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bJ\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010P\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\fJ\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u000bJ\u0014\u0010W\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020V0\u000bJ\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u000bJ\u0014\u0010Z\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020Y0\u000bJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00180\\J\u000e\u0010]\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\u0018J\u0006\u0010_\u001a\u00020\u001bR\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u00101\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u0013R(\u0010A\u001a\u0004\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010R\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010C\"\u0004\bT\u0010E¨\u0006`"}, d2 = {"Lcom/clozed/code/engine/ProviderStore;", "", "ctx", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "catalog", "", "Lcom/clozed/code/engine/CatProvider;", "v", "", "voiceDone", "getVoiceDone", "()Z", "setVoiceDone", "(Z)V", "autoApprove", "getAutoApprove", "setAutoApprove", "keys", "", "id", "saveKeys", "", "list", "keyFor", "setKey", "key", "addKey", "removeKeyAt", "index", "", "keyTag", "exhMap", "Lorg/json/JSONObject;", "markExhausted", "until", "", "reason", "exhaustedInfo", "Lkotlin/Pair;", "isKeyExhausted", "clearExhausted", "clearAllExhausted", "nextMidnight", "autoSwitch", "getAutoSwitch", "setAutoSwitch", "chain", "Lcom/clozed/code/engine/ChainEntry;", "saveChain", "customProviders", "addCustom", "name", "kind", "api", "models", "removeCustom", "isEnabled", "setEnabled", DebugKt.DEBUG_PROPERTY_VALUE_ON, "activeProvider", "getActiveProvider", "()Ljava/lang/String;", "setActiveProvider", "(Ljava/lang/String;)V", "lastModel", "providerId", "setLastModel", "modelId", "fetchedModels", "setFetched", "setCustomModels", "catalogWithFetched", "all", "provider", "isConnected", "p", "defaultEffort", "getDefaultEffort", "setDefaultEffort", "mcpServers", "Lcom/clozed/code/engine/McpServer;", "saveMcpServers", "rules", "Lcom/clozed/code/engine/PermRule;", "saveRules", "savedAllows", "", "saveAllow", "action", "clearAllows", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderStore {
    public static final int $stable = 8;
    private final List<CatProvider> catalog;
    private final SharedPreferences sp;

    public ProviderStore(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.sp = ctx.getSharedPreferences("engine_providers", 0);
        this.catalog = Catalog.INSTANCE.load(ctx);
        McpOAuth.INSTANCE.init(ctx);
    }

    public final boolean getVoiceDone() {
        return this.sp.getBoolean("voice_done", true);
    }

    public final void setVoiceDone(boolean z) {
        this.sp.edit().putBoolean("voice_done", z).apply();
    }

    public final boolean getAutoApprove() {
        return this.sp.getBoolean("auto_approve", false);
    }

    public final void setAutoApprove(boolean z) {
        this.sp.edit().putBoolean("auto_approve", z).apply();
    }

    public final List<String> keys(String id) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(id, "id");
        String string = this.sp.getString("keys." + id, null);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    arrayList.add(jSONArray.getString(((IntIterator) it).nextInt()));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    String str = (String) obj;
                    Intrinsics.checkNotNull(str);
                    if (!StringsKt.isBlank(str)) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            } catch (Exception unused) {
                return CollectionsKt.emptyList();
            }
        }
        String string2 = this.sp.getString("key." + id, null);
        if (string2 != null) {
            String str2 = StringsKt.isBlank(string2) ? null : string2;
            if (str2 != null && (listOf = CollectionsKt.listOf(str2)) != null) {
                return listOf;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void saveKeys(String id, List<String> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(list, "list");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        List distinct = CollectionsKt.distinct(arrayList2);
        SharedPreferences.Editor putString = this.sp.edit().putString("keys." + id, new JSONArray((Collection) distinct).toString());
        String str = "key." + id;
        String str2 = (String) CollectionsKt.firstOrNull(distinct);
        if (str2 == null) {
            str2 = "";
        }
        putString.putString(str, str2).apply();
    }

    public final String keyFor(String id) {
        Object obj;
        Intrinsics.checkNotNullParameter(id, "id");
        List<String> keys = keys(id);
        Iterator<T> it = keys.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!isKeyExhausted(id, (String) obj)) {
                break;
            }
        }
        String str = (String) obj;
        return str == null ? (String) CollectionsKt.firstOrNull((List) keys) : str;
    }

    public final void setKey(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        String obj = StringsKt.trim((CharSequence) key).toString();
        if (!StringsKt.isBlank(obj)) {
            saveKeys(id, CollectionsKt.plus((Collection) CollectionsKt.listOf(obj), (Iterable) CollectionsKt.drop(keys(id), 1)));
            return;
        }
        Iterator<T> it = keys(id).iterator();
        while (it.hasNext()) {
            clearExhausted(id, (String) it.next());
        }
        saveKeys(id, CollectionsKt.emptyList());
    }

    public final void addKey(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = key;
        if (StringsKt.isBlank(str)) {
            return;
        }
        saveKeys(id, CollectionsKt.plus((Collection<? extends String>) keys(id), StringsKt.trim((CharSequence) str).toString()));
    }

    public final void removeKeyAt(String id, int index) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) keys(id));
        if (index < 0 || index >= mutableList.size()) {
            return;
        }
        clearExhausted(id, mutableList.get(index));
        mutableList.remove(index);
        saveKeys(id, mutableList);
    }

    private final String keyTag(String id, String key) {
        return id + "|" + key.hashCode();
    }

    private final JSONObject exhMap() {
        String str = "{}";
        try {
            String string = this.sp.getString("exhausted", "{}");
            if (string != null) {
                str = string;
            }
            return new JSONObject(str);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public final void markExhausted(String id, String key, long until, String reason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(reason, "reason");
        JSONObject exhMap = exhMap();
        exhMap.put(keyTag(id, key), new JSONObject().put("u", until).put("r", StringsKt.take(reason, 160)));
        this.sp.edit().putString("exhausted", exhMap.toString()).apply();
    }

    public final Pair<Long, String> exhaustedInfo(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject optJSONObject = exhMap().optJSONObject(keyTag(id, key));
        if (optJSONObject == null) {
            return null;
        }
        long optLong = optJSONObject.optLong("u", 0L);
        if (optLong > System.currentTimeMillis()) {
            return TuplesKt.to(Long.valueOf(optLong), optJSONObject.optString("r"));
        }
        return null;
    }

    public final boolean isKeyExhausted(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        return exhaustedInfo(id, key) != null;
    }

    public final void clearExhausted(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject exhMap = exhMap();
        if (exhMap.has(keyTag(id, key))) {
            exhMap.remove(keyTag(id, key));
            this.sp.edit().putString("exhausted", exhMap.toString()).apply();
        }
    }

    public final void clearAllExhausted() {
        this.sp.edit().remove("exhausted").apply();
    }

    public final long nextMidnight() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final boolean getAutoSwitch() {
        return this.sp.getBoolean("auto_switch", true);
    }

    public final void setAutoSwitch(boolean z) {
        this.sp.edit().putBoolean("auto_switch", z).apply();
    }

    public final List<ChainEntry> chain() {
        String string = this.sp.getString("chain", "[]");
        try {
            JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String string2 = jSONArray.getJSONObject(nextInt).getString("p");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = jSONArray.getJSONObject(nextInt).getString("m");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                arrayList.add(new ChainEntry(string2, string3));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final void saveChain(List<ChainEntry> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (ChainEntry chainEntry : CollectionsKt.distinct(list)) {
            jSONArray.put(new JSONObject().put("p", chainEntry.getProviderId()).put("m", chainEntry.getModelId()));
        }
        this.sp.edit().putString("chain", jSONArray.toString()).apply();
    }

    public final List<CatProvider> customProviders() {
        String string = this.sp.getString("custom", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONArray optJSONArray = jSONObject.optJSONArray("models");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            IntRange until = RangesKt.until(0, optJSONArray.length());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String string2 = optJSONArray.getString(nextInt);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = optJSONArray.getString(nextInt);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                arrayList2.add(new CatModel(string2, string3, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0, 496, null));
            }
            String string4 = jSONObject.getString("id");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String string5 = jSONObject.getString("name");
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String optString = jSONObject.optString("kind", "openai");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            String string6 = jSONObject.getString("api");
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            arrayList.add(new CatProvider(string4, string5, optString, string6, "", arrayList2, true));
        }
        return arrayList;
    }

    public final String addCustom(String name, String kind, String api, List<String> models, String key) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(key, "key");
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = "custom-" + StringsKt.trim(new Regex("[^a-z0-9]+").replace(lowerCase, "-"), '-');
        String string = this.sp.getString("custom", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (!Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("id"), str)) {
                jSONArray2.put(jSONArray.getJSONObject(i));
            }
        }
        JSONObject put = new JSONObject().put("id", str).put("name", name).put("kind", kind).put("api", StringsKt.trimEnd(StringsKt.trim((CharSequence) api).toString(), '/'));
        ArrayList arrayList = new ArrayList();
        for (Object obj : models) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        jSONArray2.put(put.put("models", new JSONArray((Collection) arrayList3)));
        this.sp.edit().putString("custom", jSONArray2.toString()).apply();
        saveKeys(str, StringsKt.isBlank(key) ? CollectionsKt.emptyList() : CollectionsKt.listOf(key));
        return str;
    }

    public final void removeCustom(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        String string = this.sp.getString("custom", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (!Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("id"), id)) {
                jSONArray2.put(jSONArray.getJSONObject(i));
            }
        }
        this.sp.edit().putString("custom", jSONArray2.toString()).remove("key." + id).remove("keys." + id).apply();
    }

    public final boolean isEnabled(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.sp.getBoolean("enabled." + id, true);
    }

    public final void setEnabled(String id, boolean on) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.sp.edit().putBoolean("enabled." + id, on).apply();
    }

    public final String getActiveProvider() {
        String string = this.sp.getString("active_provider", null);
        if (string == null || StringsKt.isBlank(string)) {
            return null;
        }
        return string;
    }

    public final void setActiveProvider(String str) {
        SharedPreferences.Editor edit = this.sp.edit();
        if (str == null) {
            str = "";
        }
        edit.putString("active_provider", str).apply();
    }

    public final String lastModel(String providerId) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        String string = this.sp.getString("last_model." + providerId, null);
        if (string == null || StringsKt.isBlank(string)) {
            return null;
        }
        return string;
    }

    public final void setLastModel(String providerId, String modelId) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        this.sp.edit().putString("last_model." + providerId, modelId).apply();
    }

    public final List<String> fetchedModels(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        String string = this.sp.getString("fetched." + id, null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArray.getString(((IntIterator) it).nextInt()));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final void setFetched(String id, List<String> models) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(models, "models");
        this.sp.edit().putString("fetched." + id, new JSONArray((Collection) CollectionsKt.distinct(models)).toString()).apply();
    }

    public final void setCustomModels(String id, List<String> models) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(models, "models");
        String string = this.sp.getString("custom", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (Intrinsics.areEqual(jSONObject.getString("id"), id)) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : models) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(StringsKt.trim((CharSequence) it.next()).toString());
                }
                jSONObject.put("models", new JSONArray((Collection) CollectionsKt.distinct(arrayList3)));
            }
        }
        this.sp.edit().putString("custom", jSONArray.toString()).apply();
    }

    private final List<CatProvider> catalogWithFetched() {
        List<CatProvider> list = this.catalog;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (CatProvider catProvider : list) {
            List<String> fetchedModels = fetchedModels(catProvider.getId());
            if (!fetchedModels.isEmpty()) {
                List<CatModel> models = catProvider.getModels();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(models, 10));
                Iterator<T> it = models.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((CatModel) it.next()).getId());
                }
                Set set = CollectionsKt.toSet(arrayList2);
                List<CatModel> models2 = catProvider.getModels();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : fetchedModels) {
                    if (!set.contains((String) obj)) {
                        arrayList3.add(obj);
                    }
                }
                ArrayList<String> arrayList4 = arrayList3;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                for (String str : arrayList4) {
                    arrayList5.add(new CatModel(str, str, 0, false, 0.0d, 0.0d, 0.0d, 0.0d, 0, 496, null));
                }
                catProvider = CatProvider.copy$default(catProvider, null, null, null, null, null, CollectionsKt.plus((Collection) models2, (Iterable) arrayList5), false, 95, null);
            }
            arrayList.add(catProvider);
        }
        return arrayList;
    }

    public final List<CatProvider> all() {
        return CollectionsKt.plus((Collection) customProviders(), (Iterable) catalogWithFetched());
    }

    public final CatProvider provider(String id) {
        Object obj;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = all().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CatProvider) obj).getId(), id)) {
                break;
            }
        }
        return (CatProvider) obj;
    }

    public final boolean isConnected(CatProvider p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return !keys(p.getId()).isEmpty() || p.getCustom();
    }

    public final String getDefaultEffort() {
        String string = this.sp.getString("effort", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        return string == null ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : string;
    }

    public final void setDefaultEffort(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sp.edit().putString("effort", v).apply();
    }

    public final List<McpServer> mcpServers() {
        String string = this.sp.getString("mcp", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        IntRange until = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = jSONArray.getJSONObject(((IntIterator) it).nextInt());
            String string2 = jSONObject.getString("name");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String optString = jSONObject.optString("headers");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            arrayList.add(new McpServer(string2, string3, optString, jSONObject.optBoolean("enabled", true)));
        }
        return arrayList;
    }

    public final void saveMcpServers(List<McpServer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (McpServer mcpServer : list) {
            jSONArray.put(new JSONObject().put("name", mcpServer.getName()).put("url", mcpServer.getUrl()).put("headers", mcpServer.getHeaders()).put("enabled", mcpServer.getEnabled()));
        }
        this.sp.edit().putString("mcp", jSONArray.toString()).apply();
    }

    public final List<PermRule> rules() {
        String string = this.sp.getString("rules", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        IntRange until = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = jSONArray.getJSONObject(((IntIterator) it).nextInt());
            String string2 = jSONObject.getString("action");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = jSONObject.getString("pattern");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = jSONObject.getString("decision");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(new PermRule(string2, string3, string4));
        }
        return arrayList;
    }

    public final void saveRules(List<PermRule> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (PermRule permRule : list) {
            jSONArray.put(new JSONObject().put("action", permRule.getAction()).put("pattern", permRule.getPattern()).put("decision", permRule.getDecision()));
        }
        this.sp.edit().putString("rules", jSONArray.toString()).apply();
    }

    public final Set<String> savedAllows() {
        Set<String> stringSet = this.sp.getStringSet("allow", SetsKt.emptySet());
        return stringSet == null ? SetsKt.emptySet() : stringSet;
    }

    public final void saveAllow(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.sp.edit().putStringSet("allow", SetsKt.plus(savedAllows(), action)).apply();
    }

    public final void clearAllows() {
        this.sp.edit().remove("allow").apply();
    }
}

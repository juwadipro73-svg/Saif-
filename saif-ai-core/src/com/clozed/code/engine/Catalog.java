package com.clozed.code.engine;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clozed/code/engine/Catalog;", "", "<init>", "()V", "cache", "", "Lcom/clozed/code/engine/CatProvider;", "load", "ctx", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Catalog {
    private static List<CatProvider> cache;
    public static final Catalog INSTANCE = new Catalog();
    public static final int $stable = 8;

    private Catalog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<CatProvider> load(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        List<CatProvider> list = cache;
        if (list != null) {
            return list;
        }
        InputStream open = ctx.getAssets().open("providers.json");
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            JSONArray jSONArray = new JSONArray(readText);
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int length = jSONArray.length();
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONArray jSONArray2 = jSONObject.getJSONArray("models");
                ArrayList arrayList2 = new ArrayList(jSONArray2.length());
                int length2 = jSONArray2.length();
                int i3 = i;
                while (i3 < length2) {
                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i3);
                    String string = jSONArray3.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = jSONArray3.getString(1);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    int optInt = jSONArray3.optInt(2, i);
                    JSONArray jSONArray4 = jSONArray;
                    boolean z = jSONArray3.optInt(3, i) == 1 ? 1 : i;
                    i = 0;
                    arrayList2.add(new CatModel(string, string2, optInt, z, jSONArray3.optDouble(4, 0.0d), jSONArray3.optDouble(5, 0.0d), jSONArray3.optDouble(6, 0.0d), jSONArray3.optDouble(7, 0.0d), jSONArray3.optInt(8, 0)));
                    i3++;
                    jSONArray = jSONArray4;
                    i2 = i2;
                }
                String string3 = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String string5 = jSONObject.getString("kind");
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = jSONObject.getString("api");
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                String optString = jSONObject.optString("env");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                arrayList.add(new CatProvider(string3, string4, string5, string6, optString, arrayList2, false, 64, null));
                i2++;
                jSONArray = jSONArray;
            }
            ArrayList arrayList3 = arrayList;
            cache = arrayList3;
            return arrayList3;
        } finally {
        }
    }
}

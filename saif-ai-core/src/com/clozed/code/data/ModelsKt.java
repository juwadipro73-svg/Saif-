package com.clozed.code.data;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.clozed.code.data.Block;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002\u001a\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00052\u0006\u0010\r\u001a\u00020\u000e\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"str", "", "Lorg/json/JSONObject;", "key", "SUMMARY_KEYS", "", "parseSession", "Lcom/clozed/code/data/SessionInfo;", "o", "parsePermission", "Lcom/clozed/code/data/PermissionReq;", "parseModels", "Lcom/clozed/code/data/ModelOpt;", "arr", "Lorg/json/JSONArray;", "parseAgents", "Lcom/clozed/code/data/AgentOpt;", "parseIntegrations", "Lcom/clozed/code/data/IntegrationOpt;", "toolOutput", "state", "parseTool", "Lcom/clozed/code/data/Block$Tool;", "parseMessages", "Lcom/clozed/code/data/ChatItem;", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ModelsKt {
    private static final List<String> SUMMARY_KEYS = CollectionsKt.listOf((Object[]) new String[]{"command", "filePath", "path", "pattern", "url", "query", "description", "prompt"});

    public static final String str(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!jSONObject.has(key) || jSONObject.isNull(key)) {
            return null;
        }
        return jSONObject.optString(key);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0059, code lost:
    
        if (r1 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.clozed.code.data.SessionInfo parseSession(org.json.JSONObject r18) {
        /*
            r0 = r18
            java.lang.String r1 = "o"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "model"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            java.lang.String r2 = "id"
            r3 = 0
            if (r1 == 0) goto L3c
            java.lang.String r4 = "providerID"
            java.lang.String r4 = str(r1, r4)
            java.lang.String r1 = str(r1, r2)
            if (r1 != 0) goto L20
            r1 = r3
            goto L3a
        L20:
            if (r4 != 0) goto L23
            goto L3a
        L23:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = "/"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r1 = r1.toString()
        L3a:
            r12 = r1
            goto L3d
        L3c:
            r12 = r3
        L3d:
            java.lang.String r5 = r0.getString(r2)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            java.lang.String r1 = "title"
            java.lang.String r1 = str(r0, r1)
            if (r1 == 0) goto L5b
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 != 0) goto L58
            goto L59
        L58:
            r1 = r3
        L59:
            if (r1 != 0) goto L5d
        L5b:
            java.lang.String r1 = "Untitled session"
        L5d:
            r6 = r1
            java.lang.String r1 = "time"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            r7 = 0
            if (r1 == 0) goto L6e
            java.lang.String r2 = "updated"
            long r7 = r1.optLong(r2, r7)
        L6e:
            java.lang.String r1 = "location"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 == 0) goto L7c
            java.lang.String r2 = "directory"
            java.lang.String r3 = str(r1, r2)
        L7c:
            r9 = r3
            java.lang.String r1 = "cost"
            r2 = 0
            double r10 = r0.optDouble(r1, r2)
            java.lang.String r1 = "agent"
            java.lang.String r13 = str(r0, r1)
            com.clozed.code.data.SessionInfo r4 = new com.clozed.code.data.SessionInfo
            r14 = 0
            r16 = 128(0x80, float:1.8E-43)
            r17 = 0
            r4.<init>(r5, r6, r7, r9, r10, r12, r13, r14, r16, r17)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.data.ModelsKt.parseSession(org.json.JSONObject):com.clozed.code.data.SessionInfo");
    }

    public static final PermissionReq parsePermission(JSONObject o) {
        Intrinsics.checkNotNullParameter(o, "o");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = o.optJSONArray("resources");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i);
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                arrayList.add(optString);
            }
        }
        String string = o.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String optString2 = o.optString("sessionID");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
        String optString3 = o.optString("action");
        Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
        return new PermissionReq(string, optString2, optString3, arrayList, str(o, "message"), null, 32, null);
    }

    public static final List<ModelOpt> parseModels(JSONArray arr) {
        Intrinsics.checkNotNullParameter(arr, "arr");
        ArrayList arrayList = new ArrayList();
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = arr.optJSONObject(i);
            if (optJSONObject != null && (!optJSONObject.has("enabled") || optJSONObject.optBoolean("enabled", true))) {
                String optString = optJSONObject.optString("providerID");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String optString2 = optJSONObject.optString("id");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                String str = str(optJSONObject, "name");
                if (str == null) {
                    str = optJSONObject.optString("id");
                }
                Intrinsics.checkNotNull(str);
                arrayList.add(new ModelOpt(optString, optString2, str));
            }
        }
        return arrayList;
    }

    public static final List<AgentOpt> parseAgents(JSONArray arr) {
        Intrinsics.checkNotNullParameter(arr, "arr");
        ArrayList arrayList = new ArrayList();
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = arr.optJSONObject(i);
            if (optJSONObject != null && !optJSONObject.optBoolean("hidden", false) && !Intrinsics.areEqual(optJSONObject.optString("mode"), "subagent")) {
                String optString = optJSONObject.optString("id");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String str = str(optJSONObject, "name");
                if (str == null) {
                    str = optJSONObject.optString("id");
                }
                Intrinsics.checkNotNull(str);
                arrayList.add(new AgentOpt(optString, str, str(optJSONObject, "description")));
            }
        }
        return arrayList;
    }

    public static final List<IntegrationOpt> parseIntegrations(JSONArray arr) {
        boolean z;
        Intrinsics.checkNotNullParameter(arr, "arr");
        ArrayList arrayList = new ArrayList();
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = arr.optJSONObject(i);
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("methods");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    boolean z2 = false;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (Intrinsics.areEqual(optJSONObject2 != null ? optJSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) : null, "key")) {
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    z = false;
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("connections");
                boolean z3 = (optJSONArray2 != null ? optJSONArray2.length() : 0) > 0;
                String optString = optJSONObject.optString("id");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String str = str(optJSONObject, "name");
                if (str == null) {
                    str = optJSONObject.optString("id");
                }
                String str2 = str;
                Intrinsics.checkNotNull(str2);
                arrayList.add(new IntegrationOpt(optString, str2, z, z3, false, 16, null));
            }
        }
        return arrayList;
    }

    private static final String toolOutput(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        JSONArray optJSONArray = jSONObject.optJSONArray("content");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (Intrinsics.areEqual(optString, "text")) {
                        sb.append(optJSONObject.optString("text")).append('\n');
                    } else if (Intrinsics.areEqual(optString, "file")) {
                        StringBuilder append = sb.append("[file] ");
                        String str = str(optJSONObject, "name");
                        if (str == null) {
                            str = optJSONObject.optString("uri");
                        }
                        append.append(str).append('\n');
                    }
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("error");
        if (optJSONObject2 != null) {
            sb.append("Error: ").append(optJSONObject2.optString("message")).append('\n');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        String obj = StringsKt.trim((CharSequence) sb2).toString();
        if (obj.length() <= 6000) {
            return obj;
        }
        return StringsKt.take(obj, 6000) + "\n… (truncated)";
    }

    private static final Block.Tool parseTool(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject = jSONObject.optJSONObject("state");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String optString = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS, "running");
        Object opt = optJSONObject.opt("input");
        String str4 = "";
        if (opt instanceof JSONObject) {
            Iterator<String> it = SUMMARY_KEYS.iterator();
            while (it.hasNext()) {
                String str5 = str((JSONObject) opt, it.next());
                if (str5 != null && !StringsKt.isBlank(str5)) {
                    str4 = StringsKt.take((String) CollectionsKt.first((List) StringsKt.lines(str5)), 140);
                    break;
                }
            }
            try {
                String jSONObject2 = ((JSONObject) opt).toString(2);
                Intrinsics.checkNotNull(jSONObject2);
                str3 = jSONObject2;
            } catch (Exception unused) {
                str3 = ((JSONObject) opt).toString();
                Intrinsics.checkNotNull(str3);
            }
        } else if (opt instanceof String) {
            str3 = (String) opt;
        } else {
            str = "";
            str2 = str;
            String optString2 = jSONObject.optString("id");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            String optString3 = jSONObject.optString("name", "tool");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
            Intrinsics.checkNotNull(optString);
            return new Block.Tool(optString2, optString3, optString, str, str2, toolOutput(optJSONObject));
        }
        str2 = str3;
        str = str4;
        String optString22 = jSONObject.optString("id");
        Intrinsics.checkNotNullExpressionValue(optString22, "optString(...)");
        String optString32 = jSONObject.optString("name", "tool");
        Intrinsics.checkNotNullExpressionValue(optString32, "optString(...)");
        Intrinsics.checkNotNull(optString);
        return new Block.Tool(optString22, optString32, optString, str, str2, toolOutput(optJSONObject));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0039. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<com.clozed.code.data.ChatItem> parseMessages(org.json.JSONArray r19) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.data.ModelsKt.parseMessages(org.json.JSONArray):java.util.List");
    }
}

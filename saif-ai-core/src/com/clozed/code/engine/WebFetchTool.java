package com.clozed.code.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/clozed/code/engine/WebFetchTool;", "Lcom/clozed/code/engine/Tool;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "entities", "s", "htmlToMarkdown", "html", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class WebFetchTool implements Tool {
    public static final int $stable;
    private static final JSONObject schema;
    public static final WebFetchTool INSTANCE = new WebFetchTool();
    private static final String name = "webfetch";
    private static final String description = "Fetch content from an HTTP or HTTPS URL and return it as text, markdown, or HTML. Markdown is the default. Use a more targeted tool when one is available. This tool is read-only.";

    private WebFetchTool() {
    }

    static {
        JSONObject sStr;
        JSONObject sStr2;
        JSONObject sInt;
        JSONObject sObj;
        List listOf = CollectionsKt.listOf("url");
        sStr = ToolsKt.sStr("The HTTP or HTTPS URL to fetch content from");
        sStr2 = ToolsKt.sStr("The format to return the content in: text, markdown, or html. Defaults to markdown.");
        sInt = ToolsKt.sInt("Optional timeout in seconds (maximum: 120)");
        sObj = ToolsKt.sObj(listOf, TuplesKt.to("url", sStr), TuplesKt.to("format", sStr2), TuplesKt.to("timeout", sInt));
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

    private final String entities(String s) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(s, "&nbsp;", " ", false, 4, (Object) null), "&lt;", "<", false, 4, (Object) null), "&gt;", ">", false, 4, (Object) null), "&quot;", "\"", false, 4, (Object) null), "&#39;", "'", false, 4, (Object) null), "&amp;", "&", false, 4, (Object) null);
    }

    public final String htmlToMarkdown(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        Set of = SetsKt.setOf((Object[]) new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL});
        List<String> lines = StringsKt.lines(entities(new Regex("<[^>]+>").replace(new Regex("</(p|div|tr|ul|ol|section|article|header|footer)>|<br\\s*/?>", RegexOption.IGNORE_CASE).replace(new Regex("<li[^>]*>", RegexOption.IGNORE_CASE).replace(new Regex("<code[^>]*>(.*?)</code>", (Set<? extends RegexOption>) of).replace(new Regex("<pre[^>]*>(.*?)</pre>", (Set<? extends RegexOption>) of).replace(new Regex("<a [^>]*href=\"([^\"]*)\"[^>]*>(.*?)</a>", (Set<? extends RegexOption>) of).replace(new Regex("<h([1-6])[^>]*>(.*?)</h\\1>", (Set<? extends RegexOption>) of).replace(new Regex("<!--.*?-->", (Set<? extends RegexOption>) of).replace(new Regex("<(script|style|noscript|svg)[^>]*>.*?</\\1>", (Set<? extends RegexOption>) of).replace(html, ""), ""), new Function1() { // from class: com.clozed.code.engine.WebFetchTool$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence htmlToMarkdown$lambda$0;
                htmlToMarkdown$lambda$0 = WebFetchTool.htmlToMarkdown$lambda$0((MatchResult) obj);
                return htmlToMarkdown$lambda$0;
            }
        }), new Function1() { // from class: com.clozed.code.engine.WebFetchTool$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence htmlToMarkdown$lambda$1;
                htmlToMarkdown$lambda$1 = WebFetchTool.htmlToMarkdown$lambda$1((MatchResult) obj);
                return htmlToMarkdown$lambda$1;
            }
        }), new Function1() { // from class: com.clozed.code.engine.WebFetchTool$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence htmlToMarkdown$lambda$2;
                htmlToMarkdown$lambda$2 = WebFetchTool.htmlToMarkdown$lambda$2((MatchResult) obj);
                return htmlToMarkdown$lambda$2;
            }
        }), new Function1() { // from class: com.clozed.code.engine.WebFetchTool$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence htmlToMarkdown$lambda$3;
                htmlToMarkdown$lambda$3 = WebFetchTool.htmlToMarkdown$lambda$3((MatchResult) obj);
                return htmlToMarkdown$lambda$3;
            }
        }), "\n- "), "\n"), "")));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        Iterator<T> it = lines.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trimEnd((CharSequence) it.next()).toString());
        }
        return StringsKt.trim((CharSequence) new Regex("\n{3,}").replace(CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null), "\n\n")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence htmlToMarkdown$lambda$0(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return "\n\n" + StringsKt.repeat("#", Integer.parseInt(m.getGroupValues().get(1))) + " " + ((Object) m.getGroupValues().get(2)) + "\n\n";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence htmlToMarkdown$lambda$1(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return "[" + new Regex("<[^>]+>").replace(m.getGroupValues().get(2), "") + "](" + ((Object) m.getGroupValues().get(1)) + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence htmlToMarkdown$lambda$2(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return "\n```\n" + new Regex("<[^>]+>").replace(m.getGroupValues().get(1), "") + "\n```\n";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence htmlToMarkdown$lambda$3(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return "`" + ((Object) m.getGroupValues().get(1)) + "`";
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WebFetchTool$run$2(jSONObject, toolCtx, null), continuation);
    }
}

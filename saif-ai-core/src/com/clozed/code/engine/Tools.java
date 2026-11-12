package com.clozed.code.engine;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/clozed/code/engine/Tools;", "", "<init>", "()V", "all", "", "Lcom/clozed/code/engine/Tool;", "getAll", "()Ljava/util/List;", "forAgent", "agent", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Tools {
    public static final Tools INSTANCE = new Tools();
    private static final List<Tool> all = CollectionsKt.listOf((Object[]) new Tool[]{ReadTool.INSTANCE, GlobTool.INSTANCE, GrepTool.INSTANCE, EditTool.INSTANCE, WriteTool.INSTANCE, PatchTool.INSTANCE, ShellTool.INSTANCE, WebFetchTool.INSTANCE, WebSearchTool.INSTANCE, DiagnosticsTool.INSTANCE, TodoTool.INSTANCE, QuestionTool.INSTANCE, TaskTool.INSTANCE});
    public static final int $stable = 8;

    private Tools() {
    }

    public final List<Tool> getAll() {
        return all;
    }

    public final List<Tool> forAgent(String agent) {
        Intrinsics.checkNotNullParameter(agent, "agent");
        int hashCode = agent.hashCode();
        if (hashCode != -1309148525) {
            if (hashCode != -80148248) {
                if (hashCode == 3443497 && agent.equals("plan")) {
                    return all;
                }
            } else if (agent.equals("general")) {
                List<Tool> list = all;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!SetsKt.setOf((Object[]) new String[]{"task", "question", "todowrite"}).contains(((Tool) obj).getName())) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        } else if (agent.equals("explore")) {
            List<Tool> list2 = all;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (SetsKt.setOf((Object[]) new String[]{"read", "glob", "grep", "webfetch", "websearch", "diagnostics"}).contains(((Tool) obj2).getName())) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        return all;
    }
}

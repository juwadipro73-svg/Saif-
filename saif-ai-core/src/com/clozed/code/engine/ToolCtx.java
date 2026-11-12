package com.clozed.code.engine;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001Bû\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012c\u0010\u0006\u001a_\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012L\u0010\u0010\u001aH\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011\u00128\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0019\u0012[\u0010\u001b\u001aW\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u00126\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+Rp\u0010\u0006\u001a_\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-RY\u0010\u0010\u001aH\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100RC\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105Rh\u0010\u001b\u001aW\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\n\n\u0002\u0010.\u001a\u0004\b6\u0010-RA\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u001f\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<¨\u0006>"}, d2 = {"Lcom/clozed/code/engine/ToolCtx;", "", "workdir", "Ljava/io/File;", "sessionId", "", "permit", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "action", "", "resources", "message", "Lkotlin/coroutines/Continuation;", "", "ask", "Lkotlin/Function3;", "question", "options", "recordUndo", "Lkotlin/Function2;", "path", "before", "setTodos", "Lkotlin/Function1;", "Lorg/json/JSONArray;", "spawn", "description", "prompt", "agent", "background", "command", "dir", "planDir", "nested", "trusted", "readOnly", "<init>", "(Ljava/io/File;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/io/File;Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;)V", "getWorkdir", "()Ljava/io/File;", "getSessionId", "()Ljava/lang/String;", "getPermit", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "getAsk", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getRecordUndo", "()Lkotlin/jvm/functions/Function2;", "getSetTodos", "()Lkotlin/jvm/functions/Function1;", "getSpawn", "getBackground", "getAgent", "getPlanDir", "getNested", "getTrusted", "()Ljava/util/List;", "getReadOnly", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ToolCtx {
    public static final int $stable = 8;
    private final String agent;
    private final Function3<String, List<String>, Continuation<? super String>, Object> ask;
    private final Function2<String, File, String> background;
    private final Function1<File, String> nested;
    private final Function4<String, List<String>, String, Continuation<? super Unit>, Object> permit;
    private final File planDir;
    private final List<File> readOnly;
    private final Function2<String, String, Unit> recordUndo;
    private final String sessionId;
    private final Function1<JSONArray, Unit> setTodos;
    private final Function4<String, String, String, Continuation<? super String>, Object> spawn;
    private final List<File> trusted;
    private final File workdir;

    /* JADX WARN: Multi-variable type inference failed */
    public ToolCtx(File workdir, String sessionId, Function4<? super String, ? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> permit, Function3<? super String, ? super List<String>, ? super Continuation<? super String>, ? extends Object> ask, Function2<? super String, ? super String, Unit> recordUndo, Function1<? super JSONArray, Unit> setTodos, Function4<? super String, ? super String, ? super String, ? super Continuation<? super String>, ? extends Object> spawn, Function2<? super String, ? super File, String> background, String agent, File file, Function1<? super File, String> nested, List<? extends File> trusted, List<? extends File> readOnly) {
        Intrinsics.checkNotNullParameter(workdir, "workdir");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(permit, "permit");
        Intrinsics.checkNotNullParameter(ask, "ask");
        Intrinsics.checkNotNullParameter(recordUndo, "recordUndo");
        Intrinsics.checkNotNullParameter(setTodos, "setTodos");
        Intrinsics.checkNotNullParameter(spawn, "spawn");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(nested, "nested");
        Intrinsics.checkNotNullParameter(trusted, "trusted");
        Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        this.workdir = workdir;
        this.sessionId = sessionId;
        this.permit = permit;
        this.ask = ask;
        this.recordUndo = recordUndo;
        this.setTodos = setTodos;
        this.spawn = spawn;
        this.background = background;
        this.agent = agent;
        this.planDir = file;
        this.nested = nested;
        this.trusted = trusted;
        this.readOnly = readOnly;
    }

    public final File getWorkdir() {
        return this.workdir;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Function4<String, List<String>, String, Continuation<? super Unit>, Object> getPermit() {
        return this.permit;
    }

    public final Function3<String, List<String>, Continuation<? super String>, Object> getAsk() {
        return this.ask;
    }

    public final Function2<String, String, Unit> getRecordUndo() {
        return this.recordUndo;
    }

    public final Function1<JSONArray, Unit> getSetTodos() {
        return this.setTodos;
    }

    public final Function4<String, String, String, Continuation<? super String>, Object> getSpawn() {
        return this.spawn;
    }

    public final Function2<String, File, String> getBackground() {
        return this.background;
    }

    public /* synthetic */ ToolCtx(File file, String str, Function4 function4, Function3 function3, Function2 function2, Function1 function1, Function4 function42, Function2 function22, String str2, File file2, Function1 function12, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, str, function4, function3, function2, function1, function42, function22, (i & 256) != 0 ? "build" : str2, (i & 512) != 0 ? null : file2, (i & 1024) != 0 ? new Function1() { // from class: com.clozed.code.engine.ToolCtx.1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : function12, (i & 2048) != 0 ? CollectionsKt.emptyList() : list, (i & 4096) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final String getAgent() {
        return this.agent;
    }

    public final File getPlanDir() {
        return this.planDir;
    }

    public final Function1<File, String> getNested() {
        return this.nested;
    }

    public final List<File> getTrusted() {
        return this.trusted;
    }

    public final List<File> getReadOnly() {
        return this.readOnly;
    }
}

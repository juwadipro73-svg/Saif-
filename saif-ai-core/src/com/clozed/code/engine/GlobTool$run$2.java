package com.clozed.code.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.GlobTool$run$2", f = "Tools.kt", i = {0, 0, 0}, l = {329}, m = "invokeSuspend", n = {"$this$withContext", "pattern", "root"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /tmp/classes3.dex */
final class GlobTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super GlobTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobTool$run$2 globTool$run$2 = new GlobTool$run$2(this.$a, this.$c, continuation);
        globTool$run$2.L$0 = obj;
        return globTool$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GlobTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        String optStr;
        String optStr2;
        Object guardExternal;
        File file;
        String optStr3;
        Integer optIntOrNull;
        boolean optBoolOr;
        Sequence<File> walk;
        boolean matchGlob;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            optStr = ToolsKt.optStr(this.$a, "pattern");
            if (optStr == null) {
                throw new ToolError("pattern is required");
            }
            ToolCtx toolCtx = this.$c;
            optStr2 = ToolsKt.optStr(this.$a, "path");
            if (optStr2 == null) {
                optStr2 = ".";
            }
            File resolvePath = ToolsKt.resolvePath(toolCtx, optStr2);
            this.L$0 = coroutineScope;
            this.L$1 = optStr;
            this.L$2 = resolvePath;
            this.label = 1;
            guardExternal = ToolsKt.guardExternal(this.$c, resolvePath, this);
            if (guardExternal == coroutine_suspended) {
                return coroutine_suspended;
            }
            file = resolvePath;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$2;
            optStr = (String) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (file.isDirectory()) {
            optIntOrNull = ToolsKt.optIntOrNull(this.$a, "limit");
            int coerceIn = RangesKt.coerceIn(optIntOrNull != null ? optIntOrNull.intValue() : 100, 1, 1000);
            Regex globToRegex = ToolsKt.globToRegex(optStr);
            boolean contains$default = StringsKt.contains$default((CharSequence) optStr, '/', false, 2, (Object) null);
            ArrayList arrayList = new ArrayList();
            ToolCtx toolCtx2 = this.$c;
            optBoolOr = ToolsKt.optBoolOr(this.$a, "hidden", false);
            walk = ToolsKt.walk(toolCtx2, file, optBoolOr);
            for (File file2 : walk) {
                JobKt.ensureActive(coroutineScope.getCoroutineContext());
                String path = FilesKt.relativeTo(file2, file).getPath();
                Intrinsics.checkNotNull(path);
                matchGlob = ToolsKt.matchGlob(globToRegex, path, contains$default);
                if (matchGlob) {
                    arrayList.add(file2);
                }
                if (arrayList.size() >= 5000) {
                    break;
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() > 1) {
                CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.clozed.code.engine.GlobTool$run$2$invokeSuspend$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
                    }
                });
            }
            if (arrayList.isEmpty()) {
                return "No files matched.";
            }
            final ToolCtx toolCtx3 = this.$c;
            return CollectionsKt.joinToString$default(CollectionsKt.take(arrayList, coerceIn), "\n", null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.GlobTool$run$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    CharSequence invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = GlobTool$run$2.invokeSuspend$lambda$1(ToolCtx.this, (File) obj2);
                    return invokeSuspend$lambda$1;
                }
            }, 30, null) + (arrayList.size() > coerceIn ? "\n(showing " + coerceIn + " of " + arrayList.size() + " matches)" : "");
        }
        optStr3 = ToolsKt.optStr(this.$a, "path");
        throw new ToolError("Not a directory: " + optStr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$1(ToolCtx toolCtx, File file) {
        String rel;
        rel = ToolsKt.rel(toolCtx, file);
        return rel;
    }
}

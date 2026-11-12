package com.clozed.code.engine;

import com.clozed.code.engine.Diagnostics;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Diagnostics.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.DiagnosticsTool$run$2", f = "Diagnostics.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class DiagnosticsTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super DiagnosticsTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiagnosticsTool$run$2(this.$a, this.$c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((DiagnosticsTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        JSONArray optJSONArray = this.$a.optJSONArray("paths");
        if (optJSONArray == null) {
            throw new ToolError("paths is required");
        }
        StringBuilder sb = new StringBuilder();
        int min = Math.min(optJSONArray.length(), 30);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            ToolCtx toolCtx = this.$c;
            String optString = optJSONArray.optString(i2);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            File resolvePath = ToolsKt.resolvePath(toolCtx, optString);
            if (resolvePath.isFile()) {
                List<Diagnostics.Issue> check = Diagnostics.INSTANCE.check(resolvePath, FilesKt.readText$default(resolvePath, null, 1, null));
                if (check.isEmpty()) {
                    sb.append("OK  ").append(optJSONArray.optString(i2)).append('\n');
                } else {
                    i += check.size();
                    sb.append("ISSUES  ").append(optJSONArray.optString(i2)).append('\n');
                    for (Diagnostics.Issue issue : CollectionsKt.take(check, 8)) {
                        sb.append("  line " + issue.getLine() + ":" + issue.getCol() + "  " + issue.getMessage() + "\n");
                    }
                }
            } else {
                sb.append(optJSONArray.optString(i2)).append(": not found\n");
            }
        }
        sb.append(i == 0 ? "No syntax problems found." : i + " possible problem(s).");
        return sb.toString();
    }
}

package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.PatchTool$run$2", f = "Extensions.kt", i = {0, 0, 0, 1, 1, 1}, l = {220, 223}, m = "invokeSuspend", n = {"changes", "summary", "base", "changes", "summary", "base"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: /tmp/classes3.dex */
final class PatchTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PatchTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super PatchTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PatchTool$run$2(this.$a, this.$c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PatchTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x025d, code lost:
    
        r12 = r10.getPermit();
        r11 = kotlin.collections.CollectionsKt.listOf(r11.getFile().getPath());
        r16.L$0 = r8;
        r16.L$1 = r9;
        r16.L$2 = r2;
        r16.L$3 = r10;
        r16.L$4 = r5;
        r16.label = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0281, code lost:
    
        if (r12.invoke("external_directory", r11, "Patch touches a file outside the project folder", r16) != r1) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0285, code lost:
    
        r11 = r8;
        r8 = r10;
        r10 = r9;
        r9 = r2;
        r2 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0285 -> B:34:0x028a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.PatchTool$run$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

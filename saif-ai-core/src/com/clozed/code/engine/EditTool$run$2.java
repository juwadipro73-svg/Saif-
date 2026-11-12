package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.EditTool$run$2", f = "Tools.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {287, 300}, m = "invokeSuspend", n = {"path", "old", "new", "f", "all", "old", "new", "f", "content", "ranges"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: /tmp/classes3.dex */
final class EditTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super EditTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditTool$run$2(this.$a, this.$c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((EditTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x009c, code lost:
    
        if (r11 == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0188 A[LOOP:0: B:10:0x0182->B:12:0x0188, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01d4 A[LOOP:1: B:15:0x01ca->B:17:0x01d4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0204 A[LOOP:2: B:20:0x01fe->B:22:0x0204, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x016c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.EditTool$run$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

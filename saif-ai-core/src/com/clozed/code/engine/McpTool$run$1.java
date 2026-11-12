package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mcp.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpTool", f = "Mcp.kt", i = {0, 0}, l = {ByteCode.CHECKCAST, ByteCode.INSTANCEOF}, m = "run", n = {"this", "a"}, s = {"L$0", "L$1"})
/* loaded from: /tmp/classes3.dex */
public final class McpTool$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ McpTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpTool$run$1(McpTool mcpTool, Continuation<? super McpTool$run$1> continuation) {
        super(continuation);
        this.this$0 = mcpTool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run(null, null, this);
    }
}

package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mcp.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpManager", f = "Mcp.kt", i = {0, 0, 0, 0}, l = {216}, m = "tools", n = {"this", "out", "s", "key"}, s = {"L$0", "L$1", "L$3", "L$4"})
/* loaded from: /tmp/classes3.dex */
public final class McpManager$tools$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ McpManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpManager$tools$1(McpManager mcpManager, Continuation<? super McpManager$tools$1> continuation) {
        super(continuation);
        this.this$0 = mcpManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tools(this);
    }
}

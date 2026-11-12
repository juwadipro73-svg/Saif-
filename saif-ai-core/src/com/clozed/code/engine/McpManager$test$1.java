package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mcp.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.McpManager", f = "Mcp.kt", i = {}, l = {232}, m = "test", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class McpManager$test$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ McpManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpManager$test$1(McpManager mcpManager, Continuation<? super McpManager$test$1> continuation) {
        super(continuation);
        this.this$0 = mcpManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.test(null, this);
    }
}

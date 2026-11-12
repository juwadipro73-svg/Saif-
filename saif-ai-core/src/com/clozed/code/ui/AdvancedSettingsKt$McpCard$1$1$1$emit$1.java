package com.clozed.code.ui;

import com.clozed.code.engine.McpAuthEvent;
import com.clozed.code.ui.AdvancedSettingsKt$McpCard$1$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.AdvancedSettingsKt$McpCard$1$1$1", f = "AdvancedSettings.kt", i = {}, l = {131}, m = "emit", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvancedSettingsKt$McpCard$1$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdvancedSettingsKt$McpCard$1$1$1$emit$1(AdvancedSettingsKt$McpCard$1$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super AdvancedSettingsKt$McpCard$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((McpAuthEvent) null, (Continuation<? super Unit>) this);
    }
}

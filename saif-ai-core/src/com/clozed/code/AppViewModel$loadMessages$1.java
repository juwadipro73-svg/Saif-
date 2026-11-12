package com.clozed.code;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel", f = "AppViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {398, 399}, m = "loadMessages", n = {"this", "client", "id", "this", "id", "items"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$loadMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$loadMessages$1(AppViewModel appViewModel, Continuation<? super AppViewModel$loadMessages$1> continuation) {
        super(continuation);
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadMessages;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadMessages = this.this$0.loadMessages(this);
        return loadMessages;
    }
}

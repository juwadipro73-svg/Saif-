package com.clozed.code;

import com.clozed.code.data.Backend;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$send$1", f = "AppViewModel.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Backend $client;
    final /* synthetic */ String $id;
    final /* synthetic */ List<String> $images;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$send$1(AppViewModel appViewModel, String str, Backend backend, String str2, List<String> list, Continuation<? super AppViewModel$send$1> continuation) {
        super(2, continuation);
        this.this$0 = appViewModel;
        this.$id = str;
        this.$client = backend;
        this.$text = str2;
        this.$images = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$send$1(this.this$0, this.$id, this.$client, this.$text, this.$images, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$send$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HashMap hashMap;
        MutableStateFlow mutableStateFlow;
        Object value;
        UiState uiState;
        HashMap hashMap2;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        UiState uiState2;
        HashMap hashMap3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                hashMap2 = this.this$0.sending;
                hashMap2.put(this.$id, Boxing.boxLong(System.currentTimeMillis()));
                mutableStateFlow2 = this.this$0._state;
                String str = this.$id;
                do {
                    value2 = mutableStateFlow2.getValue();
                    uiState2 = (UiState) value2;
                } while (!mutableStateFlow2.compareAndSet(value2, UiState.copy$default(uiState2, null, false, null, null, false, null, SetsKt.plus(uiState2.getBusy(), str), false, null, null, null, null, null, null, null, null, false, false, null, 524223, null)));
                this.label = 1;
                if (this.$client.prompt(this.$id, StringsKt.trim((CharSequence) this.$text).toString(), this.$images, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            hashMap3 = this.this$0.sending;
            hashMap3.remove(this.$id);
            this.this$0.scheduleMessages(true);
        } catch (Exception e) {
            hashMap = this.this$0.sending;
            hashMap.remove(this.$id);
            mutableStateFlow = this.this$0._state;
            String str2 = this.$id;
            do {
                value = mutableStateFlow.getValue();
                uiState = (UiState) value;
            } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, SetsKt.minus(uiState.getBusy(), str2), false, null, null, null, null, null, null, null, null, false, false, null, 524223, null)));
            this.this$0.fail(e);
        }
        return Unit.INSTANCE;
    }
}

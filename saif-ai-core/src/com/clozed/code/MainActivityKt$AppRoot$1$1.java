package com.clozed.code;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.MainActivityKt$AppRoot$1$1", f = "MainActivity.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class MainActivityKt$AppRoot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnackbarHostState $snackbar;
    final /* synthetic */ State<UiState> $state$delegate;
    final /* synthetic */ AppViewModel $vm;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$AppRoot$1$1(State<UiState> state, SnackbarHostState snackbarHostState, AppViewModel appViewModel, Continuation<? super MainActivityKt$AppRoot$1$1> continuation) {
        super(2, continuation);
        this.$state$delegate = state;
        this.$snackbar = snackbarHostState;
        this.$vm = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$AppRoot$1$1(this.$state$delegate, this.$snackbar, this.$vm, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$AppRoot$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UiState AppRoot$lambda$0;
        AppViewModel appViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppRoot$lambda$0 = MainActivityKt.AppRoot$lambda$0(this.$state$delegate);
            String message = AppRoot$lambda$0.getMessage();
            if (message != null) {
                SnackbarHostState snackbarHostState = this.$snackbar;
                AppViewModel appViewModel2 = this.$vm;
                this.L$0 = appViewModel2;
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(snackbarHostState, message, (String) null, false, (SnackbarDuration) null, this, 14, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                appViewModel = appViewModel2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        appViewModel = (AppViewModel) this.L$0;
        ResultKt.throwOnFailure(obj);
        appViewModel.consumeMessage();
        return Unit.INSTANCE;
    }
}

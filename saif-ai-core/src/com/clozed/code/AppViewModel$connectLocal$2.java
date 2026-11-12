package com.clozed.code;

import com.clozed.code.engine.LocalBackend;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$connectLocal$2", f = "AppViewModel.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$connectLocal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dir;
    final /* synthetic */ String $directory;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$connectLocal$2(AppViewModel appViewModel, String str, String str2, Continuation<? super AppViewModel$connectLocal$2> continuation) {
        super(2, continuation);
        this.this$0 = appViewModel;
        this.$directory = str;
        this.$dir = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$connectLocal$2(this.this$0, this.$directory, this.$dir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$connectLocal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        UiState uiState;
        String message;
        Object withContext;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new AppViewModel$connectLocal$2$engine$1(this.this$0, this.$dir, null), this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
            LocalBackend localBackend = (LocalBackend) withContext;
            this.this$0.local = localBackend;
            this.this$0.api = localBackend;
            this.this$0.getPrefs().setMode("local");
            this.this$0.getPrefs().setDirectory(StringsKt.trim((CharSequence) this.$directory).toString());
            this.this$0.getPrefs().setAutoConnect(true);
            mutableStateFlow2 = this.this$0._state;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, UiState.copy$default((UiState) value2, Screen.Sessions, false, null, "on-device", false, null, null, false, null, null, null, null, null, null, null, null, true, localBackend.getStore().getAutoApprove(), null, 327668, null)));
            this.this$0.startEvents(localBackend);
            this.this$0.refreshSessions();
            this.this$0.loadPickers();
        } catch (Exception e) {
            if (!(e instanceof CancellationException)) {
                mutableStateFlow = this.this$0._state;
                do {
                    value = mutableStateFlow.getValue();
                    uiState = (UiState) value;
                    message = e.getMessage();
                    if (message == null) {
                        message = "Could not start";
                    }
                } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, message, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524281, null)));
            } else {
                throw e;
            }
        }
        return Unit.INSTANCE;
    }
}

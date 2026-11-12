package com.clozed.code;

import com.clozed.code.data.ClozedApi;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$connect$2", f = "AppViewModel.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"client"}, s = {"L$0"})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$connect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $directory;
    final /* synthetic */ String $password;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$connect$2(String str, String str2, AppViewModel appViewModel, String str3, Continuation<? super AppViewModel$connect$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$password = str2;
        this.this$0 = appViewModel;
        this.$directory = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$connect$2(this.$url, this.$password, this.this$0, this.$directory, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$connect$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        UiState uiState;
        String message;
        Object info;
        ClozedApi clozedApi;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ClozedApi clozedApi2 = new ClozedApi(this.$url, this.$password);
                this.L$0 = clozedApi2;
                this.label = 1;
                info = clozedApi2.info(this);
                if (info == coroutine_suspended) {
                    return coroutine_suspended;
                }
                clozedApi = clozedApi2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                clozedApi = (ClozedApi) this.L$0;
                ResultKt.throwOnFailure(obj);
                info = obj;
            }
            String str = (String) info;
            this.this$0.api = clozedApi;
            this.this$0.local = null;
            this.this$0.getPrefs().setMode("remote");
            this.this$0.getPrefs().setServerUrl(ClozedApi.INSTANCE.normalize(this.$url));
            this.this$0.getPrefs().setPassword(this.$password);
            this.this$0.getPrefs().setDirectory(this.$directory);
            this.this$0.getPrefs().setAutoConnect(true);
            mutableStateFlow2 = this.this$0._state;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, UiState.copy$default((UiState) value2, Screen.Sessions, false, null, str, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524276, null)));
            this.this$0.startEvents(clozedApi);
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
                        message = "Could not connect";
                    }
                } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, message, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524281, null)));
            } else {
                throw e;
            }
        }
        return Unit.INSTANCE;
    }
}

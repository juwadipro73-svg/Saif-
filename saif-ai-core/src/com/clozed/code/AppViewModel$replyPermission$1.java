package com.clozed.code;

import com.clozed.code.data.Backend;
import com.clozed.code.data.PermissionReq;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$replyPermission$1", f = "AppViewModel.kt", i = {}, l = {439}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$replyPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Backend $client;
    final /* synthetic */ String $decision;
    final /* synthetic */ PermissionReq $req;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$replyPermission$1(Backend backend, PermissionReq permissionReq, String str, AppViewModel appViewModel, Continuation<? super AppViewModel$replyPermission$1> continuation) {
        super(2, continuation);
        this.$client = backend;
        this.$req = permissionReq;
        this.$decision = str;
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$replyPermission$1(this.$client, this.$req, this.$decision, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$replyPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        UiState uiState;
        ArrayList arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Backend backend = this.$client;
                String sessionId = this.$req.getSessionId();
                AppViewModel appViewModel = this.this$0;
                if (StringsKt.isBlank(sessionId) && (sessionId = appViewModel.getState().getValue().getCurrentId()) == null) {
                    sessionId = "";
                }
                this.label = 1;
                if (backend.replyPermission(sessionId, this.$req.getId(), this.$decision, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            mutableStateFlow = this.this$0._state;
            PermissionReq permissionReq = this.$req;
            do {
                value = mutableStateFlow.getValue();
                uiState = (UiState) value;
                List<PermissionReq> permissions = uiState.getPermissions();
                arrayList = new ArrayList();
                for (Object obj2 : permissions) {
                    if (!Intrinsics.areEqual(((PermissionReq) obj2).getId(), permissionReq.getId())) {
                        arrayList.add(obj2);
                    }
                }
            } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, null, false, null, null, null, arrayList, null, null, null, null, false, false, null, 522239, null)));
            AppViewModel.scheduleMessages$default(this.this$0, false, 1, null);
        } catch (Exception e) {
            this.this$0.fail(e);
        }
        return Unit.INSTANCE;
    }
}

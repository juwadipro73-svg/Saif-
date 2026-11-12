package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.McpOAuth;
import com.clozed.code.engine.McpServer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1", f = "AdvancedSettings.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ McpServer $s;
    final /* synthetic */ MutableState<Map<String, String>> $status$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1(McpServer mcpServer, Context context, MutableState<Map<String, String>> mutableState, Continuation<? super AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$s = mcpServer;
        this.$ctx = context;
        this.$status$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1(this.$s, this.$ctx, this.$status$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map McpCard$lambda$12;
        Map McpCard$lambda$122;
        Map McpCard$lambda$123;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableState<Map<String, String>> mutableState = this.$status$delegate;
                McpCard$lambda$122 = AdvancedSettingsKt.McpCard$lambda$12(mutableState);
                mutableState.setValue(MapsKt.plus(McpCard$lambda$122, TuplesKt.to(this.$s.getName(), "testing…")));
                this.label = 1;
                if (McpOAuth.INSTANCE.begin(this.$ctx, this.$s.getUrl(), this.$s.getName(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MutableState<Map<String, String>> mutableState2 = this.$status$delegate;
            McpCard$lambda$123 = AdvancedSettingsKt.McpCard$lambda$12(mutableState2);
            mutableState2.setValue(MapsKt.plus(McpCard$lambda$123, TuplesKt.to(this.$s.getName(), "Log in in the browser, then come back")));
        } catch (Exception e) {
            MutableState<Map<String, String>> mutableState3 = this.$status$delegate;
            McpCard$lambda$12 = AdvancedSettingsKt.McpCard$lambda$12(mutableState3);
            mutableState3.setValue(MapsKt.plus(McpCard$lambda$12, TuplesKt.to(this.$s.getName(), "✗ " + e.getMessage())));
        }
        return Unit.INSTANCE;
    }
}

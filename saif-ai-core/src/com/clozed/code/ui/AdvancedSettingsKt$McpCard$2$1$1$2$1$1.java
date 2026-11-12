package com.clozed.code.ui;

import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.LocalBackend;
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
@DebugMetadata(c = "com.clozed.code.ui.AdvancedSettingsKt$McpCard$2$1$1$2$1$1", f = "AdvancedSettings.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$2$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ McpServer $s;
    final /* synthetic */ MutableState<Map<String, String>> $status$delegate;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedSettingsKt$McpCard$2$1$1$2$1$1(McpServer mcpServer, LocalBackend localBackend, MutableState<Map<String, String>> mutableState, Continuation<? super AdvancedSettingsKt$McpCard$2$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$s = mcpServer;
        this.$engine = localBackend;
        this.$status$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvancedSettingsKt$McpCard$2$1$1$2$1$1(this.$s, this.$engine, this.$status$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvancedSettingsKt$McpCard$2$1$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map McpCard$lambda$12;
        Map McpCard$lambda$122;
        String name;
        MutableState<Map<String, String>> mutableState;
        Exception e;
        Map map;
        String str;
        MutableState<Map<String, String>> mutableState2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState<Map<String, String>> mutableState3 = this.$status$delegate;
            McpCard$lambda$12 = AdvancedSettingsKt.McpCard$lambda$12(mutableState3);
            mutableState3.setValue(MapsKt.plus(McpCard$lambda$12, TuplesKt.to(this.$s.getName(), "testing…")));
            MutableState<Map<String, String>> mutableState4 = this.$status$delegate;
            McpCard$lambda$122 = AdvancedSettingsKt.McpCard$lambda$12(mutableState4);
            name = this.$s.getName();
            try {
                this.L$0 = mutableState4;
                this.L$1 = McpCard$lambda$122;
                this.L$2 = name;
                this.L$3 = mutableState4;
                this.L$4 = McpCard$lambda$122;
                this.L$5 = name;
                this.label = 1;
                Object test = this.$engine.getMcp().test(this.$s, this);
                if (test == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState4;
                map = McpCard$lambda$122;
                str = name;
                obj = test;
                mutableState2 = mutableState;
            } catch (Exception e2) {
                mutableState = mutableState4;
                e = e2;
                map = McpCard$lambda$122;
                str2 = "✗ " + e.getMessage();
                str = name;
                McpCard$lambda$122 = map;
                mutableState2 = mutableState;
                mutableState2.setValue(MapsKt.plus(McpCard$lambda$122, TuplesKt.to(str, str2)));
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$5;
            McpCard$lambda$122 = (Map) this.L$4;
            mutableState2 = (MutableState) this.L$3;
            name = (String) this.L$2;
            map = (Map) this.L$1;
            mutableState = (MutableState) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                e = e3;
                str2 = "✗ " + e.getMessage();
                str = name;
                McpCard$lambda$122 = map;
                mutableState2 = mutableState;
                mutableState2.setValue(MapsKt.plus(McpCard$lambda$122, TuplesKt.to(str, str2)));
                return Unit.INSTANCE;
            }
        }
        str2 = "✓ " + obj + " tools";
        mutableState2.setValue(MapsKt.plus(McpCard$lambda$122, TuplesKt.to(str, str2)));
        return Unit.INSTANCE;
    }
}

package com.clozed.code.ui;

import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.McpAuthEvent;
import com.clozed.code.engine.McpOAuth;
import com.clozed.code.engine.McpServer;
import com.clozed.code.engine.ProviderStore;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.AdvancedSettingsKt$McpCard$1$1", f = "AdvancedSettings.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ MutableState<Integer> $loginTick$delegate;
    final /* synthetic */ MutableState<List<McpServer>> $servers$delegate;
    final /* synthetic */ MutableState<Map<String, String>> $status$delegate;
    final /* synthetic */ ProviderStore $store;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedSettingsKt$McpCard$1$1(LocalBackend localBackend, MutableState<Integer> mutableState, MutableState<List<McpServer>> mutableState2, MutableState<Map<String, String>> mutableState3, ProviderStore providerStore, Continuation<? super AdvancedSettingsKt$McpCard$1$1> continuation) {
        super(2, continuation);
        this.$engine = localBackend;
        this.$loginTick$delegate = mutableState;
        this.$servers$delegate = mutableState2;
        this.$status$delegate = mutableState3;
        this.$store = providerStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvancedSettingsKt$McpCard$1$1(this.$engine, this.$loginTick$delegate, this.$servers$delegate, this.$status$delegate, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvancedSettingsKt$McpCard$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvancedSettings.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.clozed.code.ui.AdvancedSettingsKt$McpCard$1$1$1, reason: invalid class name */
    /* loaded from: /tmp/classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ LocalBackend $engine;
        final /* synthetic */ MutableState<Integer> $loginTick$delegate;
        final /* synthetic */ MutableState<List<McpServer>> $servers$delegate;
        final /* synthetic */ MutableState<Map<String, String>> $status$delegate;
        final /* synthetic */ ProviderStore $store;

        AnonymousClass1(LocalBackend localBackend, MutableState<Integer> mutableState, MutableState<List<McpServer>> mutableState2, MutableState<Map<String, String>> mutableState3, ProviderStore providerStore) {
            this.$engine = localBackend;
            this.$loginTick$delegate = mutableState;
            this.$servers$delegate = mutableState2;
            this.$status$delegate = mutableState3;
            this.$store = providerStore;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.clozed.code.engine.McpAuthEvent r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
            /*
                Method dump skipped, instructions count: 409
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.AdvancedSettingsKt$McpCard$1$1.AnonymousClass1.emit(com.clozed.code.engine.McpAuthEvent, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((McpAuthEvent) obj, (Continuation<? super Unit>) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (McpOAuth.INSTANCE.getEvents().collect(new AnonymousClass1(this.$engine, this.$loginTick$delegate, this.$servers$delegate, this.$status$delegate, this.$store), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}

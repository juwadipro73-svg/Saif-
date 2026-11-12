package com.clozed.code.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.ChatScreenKt$ChatScreen$3$1", f = "ChatScreen.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$ChatScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $follow$delegate;
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatScreenKt$ChatScreen$3$1(LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super ChatScreenKt$ChatScreen$3$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$follow$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatScreenKt$ChatScreen$3$1(this.$listState, this.$follow$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatScreenKt$ChatScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$listState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$3$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ChatScreenKt$ChatScreen$3$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            final MutableState<Boolean> mutableState = this.$follow$delegate;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$3$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair<Boolean, Boolean>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<Boolean, Boolean> pair, Continuation<? super Unit> continuation) {
                    boolean booleanValue = pair.component1().booleanValue();
                    boolean booleanValue2 = pair.component2().booleanValue();
                    if (booleanValue) {
                        ChatScreenKt.ChatScreen$lambda$14(mutableState, !booleanValue2);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.to(Boolean.valueOf(lazyListState.isScrollInProgress()), Boolean.valueOf(lazyListState.getCanScrollForward()));
    }
}

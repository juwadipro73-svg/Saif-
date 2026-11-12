package com.clozed.code.ui;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.ChatItem;
import com.clozed.code.data.PermissionReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$ChatScreen$7 implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<String> $input$delegate;
    final /* synthetic */ ChatItem $lastItem;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ UiState $state;
    final /* synthetic */ boolean $trailingIndicator;
    final /* synthetic */ AppViewModel $vm;
    final /* synthetic */ boolean $working;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$7(LazyListState lazyListState, UiState uiState, ColorScheme colorScheme, MutableState<String> mutableState, boolean z, ChatItem chatItem, AppViewModel appViewModel, boolean z2) {
        this.$listState = lazyListState;
        this.$state = uiState;
        this.$cs = colorScheme;
        this.$input$delegate = mutableState;
        this.$working = z;
        this.$lastItem = chatItem;
        this.$vm = appViewModel;
        this.$trailingIndicator = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
        invoke(paddingValues, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaddingValues pad, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(pad, "pad");
        ComposerKt.sourceInformation(composer, "C274@14181L2885,269@13935L3131:ChatScreen.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pad) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090446608, i2, -1, "com.clozed.code.ui.ChatScreen.<anonymous> (ChatScreen.kt:269)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), pad);
            float f = 12;
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.m826constructorimpl(f), Dp.m826constructorimpl(4), Dp.m826constructorimpl(f), Dp.m826constructorimpl(8));
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
            LazyListState lazyListState = this.$listState;
            Arrangement.Vertical vertical2 = vertical;
            composer.startReplaceGroup(926220783);
            ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(this.$state) | composer.changed(this.$cs) | composer.changed(this.$input$delegate) | composer.changed(this.$working) | composer.changedInstance(this.$lastItem) | composer.changedInstance(this.$vm) | composer.changed(this.$trailingIndicator);
            final UiState uiState = this.$state;
            final boolean z = this.$trailingIndicator;
            final ColorScheme colorScheme = this.$cs;
            final MutableState<String> mutableState = this.$input$delegate;
            final boolean z2 = this.$working;
            final ChatItem chatItem = this.$lastItem;
            final AppViewModel appViewModel = this.$vm;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$7$lambda$6;
                        invoke$lambda$7$lambda$6 = ChatScreenKt$ChatScreen$7.invoke$lambda$7$lambda$6(UiState.this, z, colorScheme, mutableState, z2, chatItem, appViewModel, (LazyListScope) obj);
                        return invoke$lambda$7$lambda$6;
                    }
                };
                composer.updateRememberedValue(function1);
                rememberedValue = function1;
            }
            composer.endReplaceGroup();
            LazyDslKt.LazyColumn(padding, lazyListState, paddingValues, false, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) rememberedValue, composer, 24960, 488);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(UiState uiState, boolean z, final ColorScheme colorScheme, MutableState mutableState, final boolean z2, final ChatItem chatItem, final AppViewModel appViewModel, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        LazyListScope lazyListScope2;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (uiState.getItems().isEmpty()) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(321930272, true, new ChatScreenKt$ChatScreen$7$1$1$1(colorScheme, mutableState)), 3, (Object) null);
        } else {
            lazyListScope = LazyColumn;
        }
        final List<ChatItem> items = uiState.getItems();
        final Function1 function1 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object invoke$lambda$7$lambda$6$lambda$0;
                invoke$lambda$7$lambda$6$lambda$0 = ChatScreenKt$ChatScreen$7.invoke$lambda$7$lambda$6$lambda$0((ChatItem) obj);
                return invoke$lambda$7$lambda$6$lambda$0;
            }
        };
        final ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$1 chatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$1 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ChatItem chatItem2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ChatItem) obj);
            }
        };
        lazyListScope.items(items.size(), new Function1<Integer, Object>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(items.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(items.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r4 != null ? r4.getId() : null) != false) goto L40;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r30, int r31, androidx.compose.runtime.Composer r32, int r33) {
                /*
                    Method dump skipped, instructions count: 345
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$4.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }));
        final List<PermissionReq> permissions = uiState.getPermissions();
        final Function1 function12 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object invoke$lambda$7$lambda$6$lambda$2;
                invoke$lambda$7$lambda$6$lambda$2 = ChatScreenKt$ChatScreen$7.invoke$lambda$7$lambda$6$lambda$2((PermissionReq) obj);
                return invoke$lambda$7$lambda$6$lambda$2;
            }
        };
        final ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$5 chatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$5 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(PermissionReq permissionReq) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((PermissionReq) obj);
            }
        };
        lazyListScope.items(permissions.size(), new Function1<Integer, Object>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$6
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(permissions.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$7
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(permissions.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$invoke$lambda$7$lambda$6$$inlined$items$default$8
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final PermissionReq permissionReq = (PermissionReq) permissions.get(i);
                composer.startReplaceGroup(499380334);
                ComposerKt.sourceInformation(composer, "C:ChatScreen.kt#qn8u0p");
                if (Intrinsics.areEqual(permissionReq.getAction(), "question")) {
                    composer.startReplaceGroup(-2062100093);
                    ComposerKt.sourceInformation(composer, "317@16618L31,317@16590L60");
                    composer.startReplaceGroup(-2062099226);
                    ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(appViewModel) | composer.changedInstance(permissionReq);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        final AppViewModel appViewModel2 = appViewModel;
                        rememberedValue = (Function1) new Function1<String, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$1$1$5$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                AppViewModel.this.replyPermission(permissionReq, it);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    ChatScreenKt.QuestionCard(permissionReq, (Function1) rememberedValue, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-2062097467);
                    ComposerKt.sourceInformation(composer, "318@16702L31,318@16672L62");
                    composer.startReplaceGroup(-2062096538);
                    ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(appViewModel) | composer.changedInstance(permissionReq);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        final AppViewModel appViewModel3 = appViewModel;
                        rememberedValue2 = (Function1) new Function1<String, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$1$1$5$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                AppViewModel.this.replyPermission(permissionReq, it);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    ChatScreenKt.PermissionCard(permissionReq, (Function1) rememberedValue2, composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (z) {
            lazyListScope2 = lazyListScope;
            LazyListScope.item$default(lazyListScope2, "working-indicator", (Object) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1412getLambda5$app_release(), 2, (Object) null);
        } else {
            lazyListScope2 = lazyListScope;
        }
        LazyListScope.item$default(lazyListScope2, "bottom-anchor", (Object) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1413getLambda6$app_release(), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invoke$lambda$7$lambda$6$lambda$0(ChatItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invoke$lambda$7$lambda$6$lambda$2(PermissionReq it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "perm-" + it.getId();
    }
}

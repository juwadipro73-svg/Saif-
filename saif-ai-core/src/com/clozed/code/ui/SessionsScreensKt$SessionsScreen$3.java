package com.clozed.code.ui;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.SessionInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class SessionsScreensKt$SessionsScreen$3 implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<SessionInfo> $deleting$delegate;
    final /* synthetic */ boolean $needsKey;
    final /* synthetic */ MutableState<SessionInfo> $renaming$delegate;
    final /* synthetic */ UiState $state;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$3(UiState uiState, boolean z, AppViewModel appViewModel, MutableState<SessionInfo> mutableState, MutableState<SessionInfo> mutableState2) {
        this.$state = uiState;
        this.$needsKey = z;
        this.$vm = appViewModel;
        this.$renaming$delegate = mutableState;
        this.$deleting$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
        invoke(paddingValues, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaddingValues pad, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(pad, "pad");
        ComposerKt.sourceInformation(composer, "C275@12803L1367,271@12598L1572:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pad) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1072315435, i2, -1, "com.clozed.code.ui.SessionsScreen.<anonymous> (SessionsScreens.kt:271)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), pad);
            float f = 16;
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.m826constructorimpl(f), Dp.m826constructorimpl(4), Dp.m826constructorimpl(f), Dp.m826constructorimpl(96));
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
            composer.startReplaceGroup(-2043130618);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(this.$state) | composer.changed(this.$needsKey) | composer.changedInstance(this.$vm);
            final boolean z = this.$needsKey;
            final UiState uiState = this.$state;
            final AppViewModel appViewModel = this.$vm;
            final MutableState<SessionInfo> mutableState = this.$renaming$delegate;
            final MutableState<SessionInfo> mutableState2 = this.$deleting$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$6$lambda$5;
                        invoke$lambda$6$lambda$5 = SessionsScreensKt$SessionsScreen$3.invoke$lambda$6$lambda$5(z, uiState, appViewModel, mutableState, mutableState2, (LazyListScope) obj);
                        return invoke$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(function1);
                rememberedValue = function1;
            }
            composer.endReplaceGroup();
            LazyDslKt.LazyColumn(padding, (LazyListState) null, paddingValues, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) rememberedValue, composer, 24960, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(final boolean z, final UiState uiState, final AppViewModel appViewModel, final MutableState mutableState, final MutableState mutableState2, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1461541494, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C276@12824L17:SessionsScreens.kt#qn8u0p");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461541494, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:276)");
                }
                SessionsScreensKt.StatusPill(UiState.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, (Object) null);
        if (z) {
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1048680197, true, new SessionsScreensKt$SessionsScreen$3$1$1$2(appViewModel)), 3, (Object) null);
        }
        if (uiState.getSessions().isEmpty()) {
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(255662564, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i) {
                    Composer composer2 = composer;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation(composer2, "C280@12998L805:SessionsScreens.kt#qn8u0p");
                    if ((i & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(255662564, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:280)");
                        }
                        Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m826constructorimpl(64), 0.0f, 0.0f, 13, (Object) null);
                        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
                        UiState uiState2 = UiState.this;
                        boolean z2 = z;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, centerHorizontally, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composer3 = Updater.constructor-impl(composer2);
                        Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                            composer3.updateRememberedValue(Integer.valueOf(hashCode));
                            composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -564098818, "C:SessionsScreens.kt#qn8u0p");
                        if (uiState2.getLoadingSessions()) {
                            composer2.startReplaceGroup(1228729630);
                            ComposerKt.sourceInformation(composer2, "285@13302L19");
                            LogoMotionKt.m1504ClozedLoaderorJrPs(Dp.m826constructorimpl(72), null, composer2, 6, 2);
                            composer2.endReplaceGroup();
                        } else if (!z2) {
                            composer2.startReplaceGroup(-564011368);
                            ComposerKt.sourceInformation(composer2, "287@13438L10,287@13396L65,290@13619L11,291@13703L10,288@13490L265");
                            TextKt.Text-Nvy7gAk("No sessions", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium(), composer, 6, 0, 131070);
                            TextKt.Text-Nvy7gAk("Tap “New session” below to start.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131066);
                            composer2 = composer;
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-563612553);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), 3, (Object) null);
            lazyListScope = LazyColumn;
        } else {
            lazyListScope = LazyColumn;
        }
        final List<SessionInfo> sessions = uiState.getSessions();
        final Function1 function1 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object invoke$lambda$6$lambda$5$lambda$0;
                invoke$lambda$6$lambda$5$lambda$0 = SessionsScreensKt$SessionsScreen$3.invoke$lambda$6$lambda$5$lambda$0((SessionInfo) obj);
                return invoke$lambda$6$lambda$5$lambda$0;
            }
        };
        final SessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$1 sessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$1 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(SessionInfo sessionInfo) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((SessionInfo) obj);
            }
        };
        lazyListScope.items(sessions.size(), new Function1<Integer, Object>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(sessions.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(sessions.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$invoke$lambda$6$lambda$5$$inlined$items$default$4
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
                final SessionInfo sessionInfo = (SessionInfo) sessions.get(i);
                composer.startReplaceGroup(-460966645);
                ComposerKt.sourceInformation(composer, "C*300@14005L24,301@14062L16,302@14111L16,298@13910L236:SessionsScreens.kt#qn8u0p");
                boolean contains = uiState.getBusy().contains(sessionInfo.getId());
                composer.startReplaceGroup(-153414396);
                ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(appViewModel) | composer.changed(sessionInfo);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    final AppViewModel appViewModel2 = appViewModel;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$5$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AppViewModel.this.openSession(sessionInfo.getId());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-153412580);
                ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changed = composer.changed(sessionInfo);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    final MutableState mutableState3 = mutableState;
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$5$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState3.setValue(SessionInfo.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-153411012);
                ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changed2 = composer.changed(sessionInfo);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    final MutableState mutableState4 = mutableState2;
                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$5$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState4.setValue(SessionInfo.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                SessionsScreensKt.SessionRow(sessionInfo, contains, function0, function02, (Function0) rememberedValue3, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invoke$lambda$6$lambda$5$lambda$0(SessionInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }
}

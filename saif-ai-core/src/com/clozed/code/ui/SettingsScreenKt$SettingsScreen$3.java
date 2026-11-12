package com.clozed.code.ui;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.IntegrationOpt;
import com.clozed.code.engine.CatProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$SettingsScreen$3 implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ List<IntegrationOpt> $available;
    final /* synthetic */ MutableState<Boolean> $confirmDisconnect$delegate;
    final /* synthetic */ List<IntegrationOpt> $connected;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Map<String, CatProvider> $customs;
    final /* synthetic */ State<Boolean> $dynamic$delegate;
    final /* synthetic */ MutableState<CustomEdit> $editor$delegate;
    final /* synthetic */ MutableState<IntegrationOpt> $keyTarget$delegate;
    final /* synthetic */ MutableState<IntegrationOpt> $manageKeysFor$delegate;
    final /* synthetic */ MutableState<IntegrationOpt> $removeCustomFor$delegate;
    final /* synthetic */ MutableState<IntegrationOpt> $removeKeyFor$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ UiState $state;
    final /* synthetic */ State<String> $themeMode$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsScreen$3(ColorScheme colorScheme, List<IntegrationOpt> list, UiState uiState, Map<String, CatProvider> map, AppViewModel appViewModel, List<IntegrationOpt> list2, State<String> state, State<Boolean> state2, Context context, MutableState<CustomEdit> mutableState, MutableState<IntegrationOpt> mutableState2, MutableState<IntegrationOpt> mutableState3, MutableState<IntegrationOpt> mutableState4, MutableState<IntegrationOpt> mutableState5, MutableState<Boolean> mutableState6, MutableState<Boolean> mutableState7) {
        this.$cs = colorScheme;
        this.$connected = list;
        this.$state = uiState;
        this.$customs = map;
        this.$vm = appViewModel;
        this.$available = list2;
        this.$themeMode$delegate = state;
        this.$dynamic$delegate = state2;
        this.$ctx = context;
        this.$editor$delegate = mutableState;
        this.$manageKeysFor$delegate = mutableState2;
        this.$keyTarget$delegate = mutableState3;
        this.$removeCustomFor$delegate = mutableState4;
        this.$removeKeyFor$delegate = mutableState5;
        this.$showAdd$delegate = mutableState6;
        this.$confirmDisconnect$delegate = mutableState7;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
        invoke(paddingValues, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaddingValues pad, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(pad, "pad");
        ComposerKt.sourceInformation(composer, "C120@5529L8048,116@5325L8252:SettingsScreen.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pad) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(833862160, i2, -1, "com.clozed.code.ui.SettingsScreen.<anonymous> (SettingsScreen.kt:116)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), pad);
            float f = 16;
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.m826constructorimpl(f), Dp.m826constructorimpl(0), Dp.m826constructorimpl(f), Dp.m826constructorimpl(40));
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
            composer.startReplaceGroup(342148709);
            ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changed = composer.changed(this.$cs) | composer.changedInstance(this.$connected) | composer.changedInstance(this.$state) | composer.changedInstance(this.$customs) | composer.changedInstance(this.$vm) | composer.changedInstance(this.$available) | composer.changed(this.$themeMode$delegate) | composer.changed(this.$dynamic$delegate) | composer.changedInstance(this.$ctx);
            final List<IntegrationOpt> list = this.$connected;
            final UiState uiState = this.$state;
            final AppViewModel appViewModel = this.$vm;
            final ColorScheme colorScheme = this.$cs;
            final Map<String, CatProvider> map = this.$customs;
            final MutableState<CustomEdit> mutableState = this.$editor$delegate;
            final MutableState<IntegrationOpt> mutableState2 = this.$manageKeysFor$delegate;
            final MutableState<IntegrationOpt> mutableState3 = this.$keyTarget$delegate;
            final MutableState<IntegrationOpt> mutableState4 = this.$removeCustomFor$delegate;
            final MutableState<IntegrationOpt> mutableState5 = this.$removeKeyFor$delegate;
            final List<IntegrationOpt> list2 = this.$available;
            final MutableState<Boolean> mutableState6 = this.$showAdd$delegate;
            final State<String> state = this.$themeMode$delegate;
            final State<Boolean> state2 = this.$dynamic$delegate;
            final Context context = this.$ctx;
            final MutableState<Boolean> mutableState7 = this.$confirmDisconnect$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$10$lambda$9;
                        invoke$lambda$10$lambda$9 = SettingsScreenKt$SettingsScreen$3.invoke$lambda$10$lambda$9(list, uiState, appViewModel, colorScheme, map, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, list2, mutableState6, state, state2, context, mutableState7, (LazyListScope) obj);
                        return invoke$lambda$10$lambda$9;
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
    public static final Unit invoke$lambda$10$lambda$9(final List list, final UiState uiState, final AppViewModel appViewModel, final ColorScheme colorScheme, final Map map, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, List list2, MutableState mutableState6, final State state, final State state2, final Context context, final MutableState mutableState7, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        LazyListScope lazyListScope2;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1488getLambda3$app_release(), 3, (Object) null);
        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1314979612, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C126@5928L10,124@5705L377:SettingsScreen.kt#qn8u0p");
                if ((i & 17) != 16 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314979612, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:124)");
                    }
                    float f = 4;
                    TextKt.Text-Nvy7gAk("Add several providers at once. Turn ON the toggle of the provider you want to work with - the other keys stay saved. \"Fetch models\" loads new models.", PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.m826constructorimpl(f), Dp.m826constructorimpl(f)), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 54, 0, 131064);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 3, (Object) null);
        if (list.isEmpty()) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1451314368, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation(composer, "C132@6206L51,132@6295L295,132@6179L411:SettingsScreen.kt#qn8u0p");
                    if ((i & 17) != 16 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451314368, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:132)");
                        }
                        CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(colorScheme.getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, composer, CardDefaults.$stable << 12, 14);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        final UiState uiState2 = uiState;
                        final ColorScheme colorScheme2 = colorScheme;
                        CardKt.Card(fillMaxWidth$default, (Shape) null, cardColors, (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(2084469426, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$2.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                                invoke(columnScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope Card, Composer composer2, int i2) {
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                ComposerKt.sourceInformation(composer2, "C133@6321L247:SettingsScreen.kt#qn8u0p");
                                if ((i2 & 17) != 16 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2084469426, i2, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:133)");
                                    }
                                    TextKt.Text-Nvy7gAk(UiState.this.getIntegrations().isEmpty() ? "Loading…" : "No provider connected yet. Add one below.", PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16)), colorScheme2.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 48, 0, 262136);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composer, 54), composer, 196614, 26);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), 3, (Object) null);
        } else {
            lazyListScope = LazyColumn;
        }
        final Function1 function1 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object invoke$lambda$10$lambda$9$lambda$0;
                invoke$lambda$10$lambda$9$lambda$0 = SettingsScreenKt$SettingsScreen$3.invoke$lambda$10$lambda$9$lambda$0((IntegrationOpt) obj);
                return invoke$lambda$10$lambda$9$lambda$0;
            }
        };
        final SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$1 settingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$1 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(IntegrationOpt integrationOpt) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((IntegrationOpt) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:93:0x00d1, code lost:
            
                if (r1 == null) goto L40;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r20, int r21, androidx.compose.runtime.Composer r22, int r23) {
                /*
                    Method dump skipped, instructions count: 704
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$invoke$lambda$10$lambda$9$$inlined$items$default$4.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }));
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(747007389, true, new SettingsScreenKt$SettingsScreen$3$1$1$5(list2, uiState, mutableState6, mutableState)), 3, (Object) null);
        if (uiState.getLocal()) {
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(807518519, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$6
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation(composer, "C181@8826L22:SettingsScreen.kt#qn8u0p");
                    if ((i & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(807518519, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:181)");
                    }
                    ProviderBackupUiKt.ProviderBackupCard(AppViewModel.this, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, (Object) null);
        }
        if (uiState.getLocal()) {
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1491getLambda6$app_release(), 3, (Object) null);
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-2130727441, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$7
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation(composer, "C186@9062L18:SettingsScreen.kt#qn8u0p");
                    if ((i & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2130727441, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:186)");
                    }
                    AutoSwitchUiKt.AutoSwitchCard(AppViewModel.this, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, (Object) null);
        }
        if (uiState.getLocal()) {
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1492getLambda7$app_release(), 3, (Object) null);
            LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1596267632, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SettingsScreen.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8$1, reason: invalid class name */
                /* loaded from: /tmp/classes3.dex */
                public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ UiState $state;
                    final /* synthetic */ AppViewModel $vm;

                    AnonymousClass1(UiState uiState, AppViewModel appViewModel) {
                        this.$state = uiState;
                        this.$vm = appViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C199@9663L25,194@9341L374:SettingsScreen.kt#qn8u0p");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1130783696, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:194)");
                            }
                            boolean autoApprove = this.$state.getAutoApprove();
                            boolean autoApprove2 = this.$state.getAutoApprove();
                            composer.startReplaceGroup(-1184256310);
                            ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
                            boolean changedInstance = composer.changedInstance(this.$vm);
                            final AppViewModel appViewModel = this.$vm;
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: CONSTRUCTOR (r1v2 'rememberedValue' java.lang.Object) = (r0v3 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:200) call: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8$1$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8.1.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 29 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r0 = "C199@9663L25,194@9341L374:SettingsScreen.kt#qn8u0p"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
                                    r0 = r10 & 3
                                    r1 = 2
                                    if (r0 != r1) goto L15
                                    boolean r0 = r9.getSkipping()
                                    if (r0 != 0) goto L11
                                    goto L15
                                L11:
                                    r9.skipToGroupEnd()
                                    return
                                L15:
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L24
                                    r0 = -1
                                    java.lang.String r1 = "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:194)"
                                    r2 = 1130783696(0x436663d0, float:230.3899)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
                                L24:
                                    com.clozed.code.UiState r10 = r8.$state
                                    boolean r2 = r10.getAutoApprove()
                                    com.clozed.code.UiState r10 = r8.$state
                                    boolean r4 = r10.getAutoApprove()
                                    r10 = -1184256310(0xffffffffb969aeca, float:-2.2285726E-4)
                                    r9.startReplaceGroup(r10)
                                    java.lang.String r10 = "CC(remember):SettingsScreen.kt#9igjgp"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r9, r10)
                                    com.clozed.code.AppViewModel r10 = r8.$vm
                                    boolean r10 = r9.changedInstance(r10)
                                    com.clozed.code.AppViewModel r0 = r8.$vm
                                    java.lang.Object r1 = r9.rememberedValue()
                                    if (r10 != 0) goto L51
                                    androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
                                    java.lang.Object r10 = r10.getEmpty()
                                    if (r1 != r10) goto L59
                                L51:
                                    com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8$1$$ExternalSyntheticLambda0 r1 = new com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8$1$$ExternalSyntheticLambda0
                                    r1.<init>(r0)
                                    r9.updateRememberedValue(r1)
                                L59:
                                    r3 = r1
                                    kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                                    r9.endReplaceGroup()
                                    r6 = 54
                                    r7 = 0
                                    java.lang.String r0 = "Auto-approve all permissions"
                                    java.lang.String r1 = "Risky: edits and shell commands run without asking"
                                    r5 = r9
                                    com.clozed.code.ui.SettingsScreenKt.access$SwitchRow(r0, r1, r2, r3, r4, r5, r6, r7)
                                    boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r9 == 0) goto L73
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L73:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$8.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, boolean z) {
                                appViewModel.setAutoApprove(z);
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer composer, int i) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            ComposerKt.sourceInformation(composer, "C193@9315L422,193@9302L435:SettingsScreen.kt#qn8u0p");
                            if ((i & 17) != 16 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1596267632, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:193)");
                                }
                                SettingsScreenKt.SettingsCard(ComposableLambdaKt.rememberComposableLambda(1130783696, true, new AnonymousClass1(UiState.this, appViewModel), composer, 54), composer, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer.skipToGroupEnd();
                        }
                    }), 3, (Object) null);
                    lazyListScope2 = LazyColumn;
                } else {
                    lazyListScope2 = LazyColumn;
                }
                if (uiState.getLocal()) {
                    PermissionsUiKt.backgroundSettings(lazyListScope2, appViewModel);
                }
                if (uiState.getLocal()) {
                    AdvancedSettingsKt.advancedSettings(lazyListScope2, appViewModel);
                }
                LazyListScope.item$default(lazyListScope2, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1493getLambda8$app_release(), 3, (Object) null);
                LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-388937057, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: SettingsScreen.kt */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1, reason: invalid class name */
                    /* loaded from: /tmp/classes3.dex */
                    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ ColorScheme $cs;
                        final /* synthetic */ State<Boolean> $dynamic$delegate;
                        final /* synthetic */ State<String> $themeMode$delegate;
                        final /* synthetic */ AppViewModel $vm;

                        AnonymousClass1(ColorScheme colorScheme, AppViewModel appViewModel, State<String> state, State<Boolean> state2) {
                            this.$cs = colorScheme;
                            this.$vm = appViewModel;
                            this.$themeMode$delegate = state;
                            this.$dynamic$delegate = state2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            boolean SettingsScreen$lambda$3;
                            ComposerKt.sourceInformation(composer, "C212@10104L10,212@10068L58,214@10301L423,214@10245L479,224@10815L44,229@11130L26,225@10884L299:SettingsScreen.kt#qn8u0p");
                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1438998017, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:212)");
                                }
                                TextKt.Text-Nvy7gAk("Theme", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 6, 0, 131070);
                                SegmentedButtonKt.SingleChoiceSegmentedButtonRow-uFdPcIQ(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ComposableLambdaKt.rememberComposableLambda(203826068, true, new C00041(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("system", "System"), TuplesKt.to("light", "Light"), TuplesKt.to("dark", "Dark")}), this.$vm, this.$themeMode$delegate), composer, 54), composer, 390, 2);
                                if (Build.VERSION.SDK_INT >= 31) {
                                    DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, this.$cs.getOutlineVariant-0d7_KjU(), composer, 0, 3);
                                    SettingsScreen$lambda$3 = SettingsScreenKt.SettingsScreen$lambda$3(this.$dynamic$delegate);
                                    composer.startReplaceGroup(-1184209365);
                                    ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
                                    boolean changedInstance = composer.changedInstance(this.$vm);
                                    final AppViewModel appViewModel = this.$vm;
                                    Object rememberedValue = composer.rememberedValue();
                                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0103: CONSTRUCTOR (r5v8 'rememberedValue' java.lang.Object) = (r2v17 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:230) call: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9.1.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 35 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 295
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: SettingsScreen.kt */
                                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                                    /* renamed from: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: /tmp/classes3.dex */
                                    public static final class C00041 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
                                        final /* synthetic */ List<Pair<String, String>> $opts;
                                        final /* synthetic */ State<String> $themeMode$delegate;
                                        final /* synthetic */ AppViewModel $vm;

                                        C00041(List<Pair<String, String>> list, AppViewModel appViewModel, State<String> state) {
                                            this.$opts = list;
                                            this.$vm = appViewModel;
                                            this.$themeMode$delegate = state;
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
                                            invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, int i) {
                                            String SettingsScreen$lambda$2;
                                            SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow = singleChoiceSegmentedButtonRowScope;
                                            Composer composer2 = composer;
                                            Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
                                            ComposerKt.sourceInformation(composer2, "C*218@10516L24,219@10606L23,220@10661L15,216@10396L280:SettingsScreen.kt#qn8u0p");
                                            int i2 = (i & 6) == 0 ? i | (composer2.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2) : i;
                                            if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(203826068, i2, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:215)");
                                                }
                                                List<Pair<String, String>> list = this.$opts;
                                                final AppViewModel appViewModel = this.$vm;
                                                State<String> state = this.$themeMode$delegate;
                                                int i3 = 0;
                                                for (Object obj : list) {
                                                    int i4 = i3 + 1;
                                                    if (i3 < 0) {
                                                        CollectionsKt.throwIndexOverflow();
                                                    }
                                                    Pair pair = (Pair) obj;
                                                    final String str = (String) pair.component1();
                                                    final String str2 = (String) pair.component2();
                                                    SettingsScreen$lambda$2 = SettingsScreenKt.SettingsScreen$lambda$2(state);
                                                    boolean areEqual = Intrinsics.areEqual(SettingsScreen$lambda$2, str);
                                                    composer2.startReplaceGroup(844329959);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):SettingsScreen.kt#9igjgp");
                                                    boolean changedInstance = composer2.changedInstance(appViewModel) | composer2.changed(str);
                                                    Object rememberedValue = composer2.rememberedValue();
                                                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = 
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009e: CONSTRUCTOR (r5v2 'rememberedValue' java.lang.Object) = (r11v1 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]), (r4v1 'str' java.lang.String A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel, java.lang.String):void (m)] (LINE:219) call: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1$1$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel, java.lang.String):void type: CONSTRUCTOR in method: com.clozed.code.ui.SettingsScreenKt.SettingsScreen.3.1.1.9.1.1.invoke(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                            	... 35 more
                                                            */
                                                        /*
                                                            Method dump skipped, instructions count: 262
                                                            To view this dump add '--comments-level debug' option
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$9.AnonymousClass1.C00041.invoke(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, androidx.compose.runtime.Composer, int):void");
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: private */
                                                    public static final Unit invoke$lambda$2$lambda$1$lambda$0(AppViewModel appViewModel, String str) {
                                                        appViewModel.setThemeMode(str);
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* JADX INFO: Access modifiers changed from: private */
                                                public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, boolean z) {
                                                    appViewModel.setDynamicColor(z);
                                                    return Unit.INSTANCE;
                                                }
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                                invoke(lazyItemScope, composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope item, Composer composer, int i) {
                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                ComposerKt.sourceInformation(composer, "C211@10046L1177,211@10033L1190:SettingsScreen.kt#qn8u0p");
                                                if ((i & 17) != 16 || !composer.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-388937057, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:211)");
                                                    }
                                                    SettingsScreenKt.SettingsCard(ComposableLambdaKt.rememberComposableLambda(-1438998017, true, new AnonymousClass1(colorScheme, appViewModel, state, state2), composer, 54), composer, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer.skipToGroupEnd();
                                            }
                                        }), 3, (Object) null);
                                        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1494getLambda9$app_release(), 3, (Object) null);
                                        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1524881503, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* compiled from: SettingsScreen.kt */
                                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                                            /* renamed from: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10$1, reason: invalid class name */
                                            /* loaded from: /tmp/classes3.dex */
                                            public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                                                final /* synthetic */ MutableState<Boolean> $confirmDisconnect$delegate;
                                                final /* synthetic */ ColorScheme $cs;
                                                final /* synthetic */ Context $ctx;
                                                final /* synthetic */ UiState $state;
                                                final /* synthetic */ AppViewModel $vm;

                                                AnonymousClass1(UiState uiState, AppViewModel appViewModel, ColorScheme colorScheme, Context context, MutableState<Boolean> mutableState) {
                                                    this.$state = uiState;
                                                    this.$vm = appViewModel;
                                                    this.$cs = colorScheme;
                                                    this.$ctx = context;
                                                    this.$confirmDisconnect$delegate = mutableState;
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                    invoke(composer, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer, int i) {
                                                    String str;
                                                    AnonymousClass1 anonymousClass1;
                                                    Composer composer2 = composer;
                                                    ComposerKt.sourceInformation(composer2, "C239@11433L66,255@12473L45,254@12395L28,253@12345L419:SettingsScreen.kt#qn8u0p");
                                                    if ((i & 3) != 2 || !composer2.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1720024833, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:239)");
                                                        }
                                                        SettingsScreenKt.InfoRow("Mode", this.$state.getLocal() ? "On-device" : "Remote server", composer2, 6);
                                                        if (this.$state.getLocal()) {
                                                            composer2.startReplaceGroup(1944639865);
                                                            ComposerKt.sourceInformation(composer2, "241@11563L83,243@11745L440");
                                                            String directory = this.$vm.getPrefs().getDirectory();
                                                            if (StringsKt.isBlank(directory)) {
                                                                directory = "App's private workspace";
                                                            }
                                                            SettingsScreenKt.InfoRow("Project folder", directory, composer2, 6);
                                                            if (Build.VERSION.SDK_INT >= 30) {
                                                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                                                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                                                final Context context = this.$ctx;
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                                                                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                                                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                                                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default);
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
                                                                Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                                                                    composer3.updateRememberedValue(Integer.valueOf(hashCode));
                                                                    composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                                                }
                                                                Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                                                RowScope rowScope = RowScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer2, -2032206616, "C244@11922L10,244@11856L87,245@12004L27,245@11976L179:SettingsScreen.kt#qn8u0p");
                                                                str = "CC(remember):SettingsScreen.kt#9igjgp";
                                                                TextKt.Text-Nvy7gAk("Storage access", RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131068);
                                                                composer2 = composer;
                                                                composer2.startReplaceGroup(-896834581);
                                                                ComposerKt.sourceInformation(composer2, str);
                                                                boolean changedInstance = composer2.changedInstance(context);
                                                                Object rememberedValue = composer2.rememberedValue();
                                                                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                                                    rememberedValue = 
                                                                    /*  JADX ERROR: Method code generation error
                                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01c0: CONSTRUCTOR (r2v13 'rememberedValue' java.lang.Object) = (r7v3 'context' android.content.Context A[DONT_INLINE]) A[MD:(android.content.Context):void (m)] (LINE:246) call: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10$1$$ExternalSyntheticLambda0.<init>(android.content.Context):void type: CONSTRUCTOR in method: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10.1.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                        	... 41 more
                                                                        */
                                                                    /*
                                                                        Method dump skipped, instructions count: 644
                                                                        To view this dump add '--comments-level debug' option
                                                                    */
                                                                    throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$10.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                                                                }

                                                                /* JADX INFO: Access modifiers changed from: private */
                                                                public static final Unit invoke$lambda$3$lambda$2$lambda$1(Context context) {
                                                                    ComponentsKt.openAllFilesAccess(context);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: Access modifiers changed from: private */
                                                                public static final Unit invoke$lambda$5$lambda$4(MutableState mutableState) {
                                                                    SettingsScreenKt.SettingsScreen$lambda$24(mutableState, true);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                                                invoke(lazyItemScope, composer, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(LazyItemScope item, Composer composer, int i) {
                                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                                ComposerKt.sourceInformation(composer, "C238@11411L1371,238@11398L1384:SettingsScreen.kt#qn8u0p");
                                                                if ((i & 17) != 16 || !composer.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1524881503, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:238)");
                                                                    }
                                                                    SettingsScreenKt.SettingsCard(ComposableLambdaKt.rememberComposableLambda(1720024833, true, new AnonymousClass1(UiState.this, appViewModel, colorScheme, context, mutableState7), composer, 54), composer, 6);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer.skipToGroupEnd();
                                                            }
                                                        }), 3, (Object) null);
                                                        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1469getLambda12$app_release(), 3, (Object) null);
                                                        LazyListScope.item$default(LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1634141347, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$11
                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                                                invoke(lazyItemScope, composer, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(LazyItemScope item, Composer composer, int i) {
                                                                String str = "";
                                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                                ComposerKt.sourceInformation(composer, "C267@12961L156,270@13147L406,270@13134L419:SettingsScreen.kt#qn8u0p");
                                                                if ((i & 17) != 16 || !composer.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1634141347, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:267)");
                                                                    }
                                                                    composer.startReplaceGroup(1516057742);
                                                                    ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
                                                                    Context context2 = context;
                                                                    Object rememberedValue = composer.rememberedValue();
                                                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                                                        try {
                                                                            String str2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                                                                            if (str2 != null) {
                                                                                str = str2;
                                                                            }
                                                                        } catch (Exception unused) {
                                                                        }
                                                                        composer.updateRememberedValue(str);
                                                                        rememberedValue = str;
                                                                    }
                                                                    final String str3 = (String) rememberedValue;
                                                                    composer.endReplaceGroup();
                                                                    final ColorScheme colorScheme2 = colorScheme;
                                                                    SettingsScreenKt.SettingsCard(ComposableLambdaKt.rememberComposableLambda(584080387, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$3$1$1$11.1
                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                                            invoke(composer2, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(Composer composer2, int i2) {
                                                                            String str4;
                                                                            ComposerKt.sourceInformation(composer2, "C271@13169L67,274@13463L10,272@13257L278:SettingsScreen.kt#qn8u0p");
                                                                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(584080387, i2, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:271)");
                                                                                }
                                                                                if (StringsKt.isBlank(str3)) {
                                                                                    str4 = "—";
                                                                                } else {
                                                                                    str4 = "v" + str3;
                                                                                }
                                                                                SettingsScreenKt.InfoRow("Clozed Code", str4, composer2, 6);
                                                                                TextKt.Text-Nvy7gAk("On-device AI coding agent. Bring your own API key; your keys stay on this device and are sent only to the provider you choose.", (Modifier) null, colorScheme2.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 131066);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer2.skipToGroupEnd();
                                                                        }
                                                                    }, composer, 54), composer, 6);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer.skipToGroupEnd();
                                                            }
                                                        }), 3, (Object) null);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: private */
                                                    public static final Object invoke$lambda$10$lambda$9$lambda$0(IntegrationOpt it) {
                                                        Intrinsics.checkNotNullParameter(it, "it");
                                                        return "prov-" + it.getId();
                                                    }
                                                }

package com.clozed.code.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sheets.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SheetsKt$PickerSheet$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ String $emptyText;
    final /* synthetic */ List<T> $filtered;
    final /* synthetic */ Function3<Function0<Unit>, Composer, Integer, Unit> $header;
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function1<T, String> $label;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<T, Unit> $onPick;
    final /* synthetic */ MutableState<String> $query$delegate;
    final /* synthetic */ Function1<T, String> $sub;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SheetsKt$PickerSheet$1(String str, Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0, List<? extends T> list, ColorScheme colorScheme, String str2, List<? extends T> list2, Function1<? super T, Unit> function1, Function1<? super T, String> function12, Function1<? super T, String> function13, MutableState<String> mutableState) {
        this.$title = str;
        this.$header = function3;
        this.$onDismiss = function0;
        this.$items = list;
        this.$cs = colorScheme;
        this.$emptyText = str2;
        this.$filtered = list2;
        this.$onPick = function1;
        this.$label = function12;
        this.$sub = function13;
        this.$query$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope ModalBottomSheet, Composer composer, int i) {
        Function0<Unit> function0;
        String PickerSheet$lambda$1;
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C57@2327L2024:Sheets.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669182977, i, -1, "com.clozed.code.ui.PickerSheet.<anonymous> (Sheets.kt:57)");
        }
        Modifier modifier = PaddingKt.padding-VpY3zN4$default(WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.Companion), Dp.m826constructorimpl(20), 0.0f, 2, (Object) null);
        String str = this.$title;
        Function3<Function0<Unit>, Composer, Integer, Unit> function3 = this.$header;
        Function0<Unit> function02 = this.$onDismiss;
        List<T> list = this.$items;
        final ColorScheme colorScheme = this.$cs;
        String str2 = this.$emptyText;
        final List<T> list2 = this.$filtered;
        final Function1<T, Unit> function1 = this.$onPick;
        final Function1<T, String> function12 = this.$label;
        final Function1<T, String> function13 = this.$sub;
        final MutableState<String> mutableState = this.$query$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0 constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composer2 = Updater.constructor-impl(composer);
        Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
            composer2.updateRememberedValue(Integer.valueOf(hashCode));
            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -648993872, "C58@2444L10,58@2410L101:Sheets.kt#qn8u0p");
        TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m826constructorimpl(12), 7, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 48, 0, 131068);
        composer.startReplaceGroup(1364540025);
        ComposerKt.sourceInformation(composer, "59@2532L17");
        if (function3 == null) {
            function0 = function02;
        } else {
            function0 = function02;
            function3.invoke(function0, composer, 0);
        }
        composer.endReplaceGroup();
        if (list.isEmpty()) {
            composer.startReplaceGroup(-648878305);
            ComposerKt.sourceInformation(composer, "61@2601L91");
            TextKt.Text-Nvy7gAk(str2, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(24), 1, (Object) null), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 48, 0, 262136);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-648703651);
            ComposerKt.sourceInformation(composer, "64@2800L14,63@2730L383,70@3174L1153,70@3130L1197");
            PickerSheet$lambda$1 = SheetsKt.PickerSheet$lambda$1(mutableState);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(28));
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.m826constructorimpl(8), 7, (Object) null);
            composer.startReplaceGroup(1364548598);
            ComposerKt.sourceInformation(composer, "CC(remember):Sheets.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$8$lambda$1$lambda$0;
                        invoke$lambda$8$lambda$1$lambda$0 = SheetsKt$PickerSheet$1.invoke$lambda$8$lambda$1$lambda$0(mutableState, (String) obj);
                        return invoke$lambda$8$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            final Function0<Unit> function03 = function0;
            OutlinedTextFieldKt.OutlinedTextField(PickerSheet$lambda$1, (Function1) rememberedValue, modifier2, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$SheetsKt.INSTANCE.m1495getLambda1$app_release(), ComposableSingletons$SheetsKt.INSTANCE.m1496getLambda2$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, shape, (TextFieldColors) null, composer, 113246640, 12582912, 0, 6159992);
            Modifier modifier3 = SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(460), 1, (Object) null);
            composer.startReplaceGroup(1364561705);
            ComposerKt.sourceInformation(composer, "CC(remember):Sheets.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(list2) | composer.changed(function1) | composer.changed(function03) | composer.changed(function12) | composer.changed(function13) | composer.changed(colorScheme);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                Function1 function14 = new Function1() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$8$lambda$7$lambda$6;
                        invoke$lambda$8$lambda$7$lambda$6 = SheetsKt$PickerSheet$1.invoke$lambda$8$lambda$7$lambda$6(list2, function1, function03, colorScheme, function12, function13, (LazyListScope) obj);
                        return invoke$lambda$8$lambda$7$lambda$6;
                    }
                };
                composer.updateRememberedValue(function14);
                rememberedValue2 = function14;
            }
            composer.endReplaceGroup();
            LazyDslKt.LazyColumn(modifier3, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) rememberedValue2, composer, 6, 510);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$1$lambda$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7$lambda$6(final List list, final Function1 function1, final Function0 function0, final ColorScheme colorScheme, final Function1 function12, final Function1 function13, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final SheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$1 sheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$1 = new Function1() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(T t) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((SheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$1) obj);
            }
        };
        LazyColumn.items(list.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
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
                final Object obj = list.get(i);
                composer.startReplaceGroup(-1237020531);
                ComposerKt.sourceInformation(composer, "C*72@3246L1041:Sheets.kt#qn8u0p");
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier = Modifier.Companion;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composer2 = Updater.constructor-impl(composer);
                Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1355716013, "C76@3431L29,73@3283L886,88@4198L63:Sheets.kt#qn8u0p");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-510452767);
                ComposerKt.sourceInformation(composer, "CC(remember):Sheets.kt#9igjgp");
                boolean changed = composer.changed(function1) | composer.changedInstance(obj) | composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    final Function1 function14 = function1;
                    final Function0 function02 = function0;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: com.clozed.code.ui.SheetsKt$PickerSheet$1$1$2$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function14.invoke(obj);
                            function02.invoke();
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier2 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) rememberedValue, 15, (Object) null), Dp.m826constructorimpl(4), Dp.m826constructorimpl(12));
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier2);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composer3 = Updater.constructor-impl(composer);
                Updater.set-impl(composer3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                    composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                    composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1079066931, "C79@3648L10,79@3608L109:Sheets.kt#qn8u0p");
                TextKt.Text-Nvy7gAk((String) function12.invoke(obj), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 24960, 110590);
                String str = (String) function13.invoke(obj);
                composer.startReplaceGroup(796481334);
                ComposerKt.sourceInformation(composer, "83@3958L10,82@3858L247");
                if (!StringsKt.isBlank(str)) {
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 24960, 110586);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, Color.copy-wmQWz5c$default(colorScheme.getOutlineVariant-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer, 0, 3);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}

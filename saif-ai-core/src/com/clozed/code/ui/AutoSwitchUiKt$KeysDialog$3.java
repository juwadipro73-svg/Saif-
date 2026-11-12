package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoSwitchUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AutoSwitchUiKt$KeysDialog$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ List<AppViewModel.KeyEntry> $entries;
    final /* synthetic */ MutableState<String> $key$delegate;
    final /* synthetic */ String $providerId;
    final /* synthetic */ MutableIntState $rev$delegate;
    final /* synthetic */ MutableState<Boolean> $show$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoSwitchUiKt$KeysDialog$3(ColorScheme colorScheme, List<AppViewModel.KeyEntry> list, AppViewModel appViewModel, String str, MutableIntState mutableIntState, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Context context) {
        this.$cs = colorScheme;
        this.$entries = list;
        this.$vm = appViewModel;
        this.$providerId = str;
        this.$rev$delegate = mutableIntState;
        this.$key$delegate = mutableState;
        this.$show$delegate = mutableState2;
        this.$ctx = context;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String KeysDialog$lambda$5;
        boolean KeysDialog$lambda$8;
        int i2;
        PasswordVisualTransformation passwordVisualTransformation;
        final MutableState<String> mutableState;
        final MutableState<Boolean> mutableState2;
        final MutableState<String> mutableState3;
        String KeysDialog$lambda$52;
        Composer composer2;
        final MutableIntState mutableIntState;
        String untilText;
        ComposerKt.sourceInformation(composer, "C71@3186L21,71@3155L2688:AutoSwitchUi.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2146340788, i, -1, "com.clozed.code.ui.KeysDialog.<anonymous> (AutoSwitchUi.kt:71)");
        }
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(6));
        final ColorScheme colorScheme = this.$cs;
        List<AppViewModel.KeyEntry> list = this.$entries;
        AppViewModel appViewModel = this.$vm;
        String str = this.$providerId;
        MutableIntState mutableIntState2 = this.$rev$delegate;
        MutableState<String> mutableState4 = this.$key$delegate;
        MutableState<Boolean> mutableState5 = this.$show$delegate;
        final Context context = this.$ctx;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
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
        Composer composer3 = Updater.constructor-impl(composer);
        Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode));
            composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1500096971, "C74@3521L10,72@3278L311,97@4914L12,96@4846L343,102@5206L623:AutoSwitchUi.kt#qn8u0p");
        String str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
        AppViewModel appViewModel2 = appViewModel;
        String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
        String str4 = str;
        MutableIntState mutableIntState3 = mutableIntState2;
        String str5 = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
        int i3 = 1;
        TextKt.Text-Nvy7gAk("The key at the top is used first. When its credit / limit is finished, the app flags it and switches to the next key automatically. The flag clears by itself the next day.", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131066);
        Composer composer4 = composer;
        composer4.startReplaceGroup(-782885735);
        ComposerKt.sourceInformation(composer4, "76@3672L10,76@3629L65");
        if (list.isEmpty()) {
            TextKt.Text-Nvy7gAk("No keys yet.", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131070);
            composer4 = composer;
        }
        composer4.endReplaceGroup();
        composer4.startReplaceGroup(-782881097);
        ComposerKt.sourceInformation(composer4, "*78@3764L982,94@4767L44");
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AppViewModel.KeyEntry keyEntry = (AppViewModel.KeyEntry) obj;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
            String str6 = str2;
            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, str6);
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, fillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            String str7 = str3;
            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, str7);
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor2);
            } else {
                composer4.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer4);
            Updater.set-impl(composer5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer5.updateRememberedValue(Integer.valueOf(hashCode2));
                composer5.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, -236794805, "C79@3867L653,90@4566L43,90@4611L113,90@4545L179:AutoSwitchUi.kt#qn8u0p");
            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            String str8 = str5;
            ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, str8);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, 0);
            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, str6);
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, weight$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, str7);
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor3);
            } else {
                composer4.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer4);
            Updater.set-impl(composer6, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer6.updateRememberedValue(Integer.valueOf(hashCode3));
                composer6.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer6, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, -1101349236, "C80@3976L10,80@3925L72:AutoSwitchUi.kt#qn8u0p");
            str5 = str8;
            final int i6 = i4;
            TextKt.Text-Nvy7gAk(i5 + ".  " + keyEntry.getHint(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131070);
            if (keyEntry.getExhaustedUntil() != null) {
                composer.startReplaceGroup(-1101227965);
                ComposerKt.sourceInformation(composer, "84@4242L10,82@4090L225");
                untilText = AutoSwitchUiKt.untilText(keyEntry.getExhaustedUntil().longValue());
                TextKt.Text-Nvy7gAk("⛔ Limit reached - " + untilText, (Modifier) null, colorScheme.getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1100939851);
                ComposerKt.sourceInformation(composer, "87@4423L10,87@4385L79");
                TextKt.Text-Nvy7gAk("✓ Ready", (Modifier) null, colorScheme.getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131066);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.startReplaceGroup(-1947279638);
            ComposerKt.sourceInformation(composer2, "CC(remember):AutoSwitchUi.kt#9igjgp");
            final AppViewModel appViewModel3 = appViewModel2;
            final String str9 = str4;
            boolean changedInstance = composer2.changedInstance(appViewModel3) | composer2.changed(str9) | composer2.changed(i6);
            Object rememberedValue = composer2.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                mutableIntState = mutableIntState3;
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$15$lambda$4$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$15$lambda$4$lambda$3$lambda$2$lambda$1 = AutoSwitchUiKt$KeysDialog$3.invoke$lambda$15$lambda$4$lambda$3$lambda$2$lambda$1(AppViewModel.this, str9, i6, mutableIntState);
                        return invoke$lambda$15$lambda$4$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            } else {
                mutableIntState = mutableIntState3;
            }
            composer2.endReplaceGroup();
            IconButtonKt.IconButton((Function0) rememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-2077748336, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$1$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                    invoke(composer7, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer7, int i7) {
                    ComposerKt.sourceInformation(composer7, "C91@4641L57:AutoSwitchUi.kt#qn8u0p");
                    if ((i7 & 3) == 2 && composer7.getSkipping()) {
                        composer7.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2077748336, i7, -1, "com.clozed.code.ui.KeysDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AutoSwitchUi.kt:91)");
                    }
                    IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Remove key", (Modifier) null, colorScheme.getError-0d7_KjU(), composer7, 48, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 1572864, 62);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, colorScheme.getOutlineVariant-0d7_KjU(), composer, 0, 3);
            composer4 = composer;
            appViewModel2 = appViewModel3;
            str4 = str9;
            mutableIntState3 = mutableIntState;
            i4 = i5;
            str3 = str7;
            str2 = str6;
            i3 = 1;
        }
        String str10 = str2;
        final AppViewModel appViewModel4 = appViewModel2;
        final String str11 = str4;
        final MutableIntState mutableIntState4 = mutableIntState3;
        String str12 = str3;
        composer4.endReplaceGroup();
        KeysDialog$lambda$5 = AutoSwitchUiKt.KeysDialog$lambda$5(mutableState4);
        KeysDialog$lambda$8 = AutoSwitchUiKt.KeysDialog$lambda$8(mutableState5);
        if (KeysDialog$lambda$8) {
            passwordVisualTransformation = VisualTransformation.INSTANCE.getNone();
            i2 = 1;
        } else {
            i2 = 1;
            passwordVisualTransformation = new PasswordVisualTransformation((char) 0, 1, null);
        }
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i2, (Object) null);
        composer4.startReplaceGroup(-782843955);
        ComposerKt.sourceInformation(composer4, "CC(remember):AutoSwitchUi.kt#9igjgp");
        Object rememberedValue2 = composer4.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            mutableState = mutableState4;
            rememberedValue2 = new Function1() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invoke$lambda$15$lambda$6$lambda$5;
                    invoke$lambda$15$lambda$6$lambda$5 = AutoSwitchUiKt$KeysDialog$3.invoke$lambda$15$lambda$6$lambda$5(mutableState, (String) obj2);
                    return invoke$lambda$15$lambda$6$lambda$5;
                }
            };
            composer4.updateRememberedValue(rememberedValue2);
        } else {
            mutableState = mutableState4;
        }
        composer4.endReplaceGroup();
        MutableState<String> mutableState6 = mutableState;
        OutlinedTextFieldKt.OutlinedTextField(KeysDialog$lambda$5, (Function1) rememberedValue2, fillMaxWidth$default2, false, false, (TextStyle) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1383getLambda3$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, passwordVisualTransformation, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8241080);
        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str10);
        int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, str12);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer composer7 = Updater.constructor-impl(composer);
        Updater.set-impl(composer7, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer7.getInserting() || !Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(hashCode4))) {
            composer7.updateRememberedValue(Integer.valueOf(hashCode4));
            composer7.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
        }
        Updater.set-impl(composer7, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 982911568, "C103@5301L16,103@5319L38,103@5280L77,104@5399L52,104@5378L92,107@5596L50,105@5491L320:AutoSwitchUi.kt#qn8u0p");
        composer.startReplaceGroup(-1769408336);
        ComposerKt.sourceInformation(composer, "CC(remember):AutoSwitchUi.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            mutableState2 = mutableState5;
            rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$15$lambda$14$lambda$8$lambda$7;
                    invoke$lambda$15$lambda$14$lambda$8$lambda$7 = AutoSwitchUiKt$KeysDialog$3.invoke$lambda$15$lambda$14$lambda$8$lambda$7(mutableState2);
                    return invoke$lambda$15$lambda$14$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        } else {
            mutableState2 = mutableState5;
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1620306421, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$1$3$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope3, Composer composer8, Integer num) {
                invoke(rowScope3, composer8, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer8, int i7) {
                boolean KeysDialog$lambda$82;
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer8, "C103@5321L34:AutoSwitchUi.kt#qn8u0p");
                if ((i7 & 17) == 16 && composer8.getSkipping()) {
                    composer8.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620306421, i7, -1, "com.clozed.code.ui.KeysDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AutoSwitchUi.kt:103)");
                }
                KeysDialog$lambda$82 = AutoSwitchUiKt.KeysDialog$lambda$8(mutableState2);
                TextKt.Text-Nvy7gAk(KeysDialog$lambda$82 ? "Hide" : "Show", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer8, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 805306374, 510);
        composer.startReplaceGroup(-1769405164);
        ComposerKt.sourceInformation(composer, "CC(remember):AutoSwitchUi.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(context);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            mutableState3 = mutableState6;
            rememberedValue4 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$15$lambda$14$lambda$11$lambda$10;
                    invoke$lambda$15$lambda$14$lambda$11$lambda$10 = AutoSwitchUiKt$KeysDialog$3.invoke$lambda$15$lambda$14$lambda$11$lambda$10(context, mutableState3);
                    return invoke$lambda$15$lambda$14$lambda$11$lambda$10;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        } else {
            mutableState3 = mutableState6;
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue4, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1384getLambda4$app_release(), composer, 805306368, 510);
        KeysDialog$lambda$52 = AutoSwitchUiKt.KeysDialog$lambda$5(mutableState3);
        boolean z = !StringsKt.isBlank(KeysDialog$lambda$52);
        composer.startReplaceGroup(-1769398862);
        ComposerKt.sourceInformation(composer, "CC(remember):AutoSwitchUi.kt#9igjgp");
        boolean changedInstance3 = composer.changedInstance(appViewModel4) | composer.changed(str11);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$3$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$15$lambda$14$lambda$13$lambda$12;
                    invoke$lambda$15$lambda$14$lambda$13$lambda$12 = AutoSwitchUiKt$KeysDialog$3.invoke$lambda$15$lambda$14$lambda$13$lambda$12(AppViewModel.this, str11, mutableState3, mutableIntState4);
                    return invoke$lambda$15$lambda$14$lambda$13$lambda$12;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        ButtonKt.FilledTonalButton((Function0) rememberedValue5, (Modifier) null, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1385getLambda5$app_release(), composer, 805306368, 506);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit invoke$lambda$15$lambda$4$lambda$3$lambda$2$lambda$1(AppViewModel appViewModel, String str, int i, MutableIntState mutableIntState) {
        int KeysDialog$lambda$1;
        appViewModel.removeApiKeyAt(str, i);
        KeysDialog$lambda$1 = AutoSwitchUiKt.KeysDialog$lambda$1(mutableIntState);
        mutableIntState.setIntValue(KeysDialog$lambda$1 + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$6$lambda$5(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14$lambda$8$lambda$7(MutableState mutableState) {
        boolean KeysDialog$lambda$8;
        KeysDialog$lambda$8 = AutoSwitchUiKt.KeysDialog$lambda$8(mutableState);
        AutoSwitchUiKt.KeysDialog$lambda$9(mutableState, !KeysDialog$lambda$8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14$lambda$11$lambda$10(Context context, MutableState mutableState) {
        String pasteFromClipboard = ComponentsKt.pasteFromClipboard(context);
        if (pasteFromClipboard != null) {
            mutableState.setValue(StringsKt.trim((CharSequence) pasteFromClipboard).toString());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14$lambda$13$lambda$12(AppViewModel appViewModel, String str, MutableState mutableState, MutableIntState mutableIntState) {
        String KeysDialog$lambda$5;
        int KeysDialog$lambda$1;
        KeysDialog$lambda$5 = AutoSwitchUiKt.KeysDialog$lambda$5(mutableState);
        appViewModel.addApiKey(str, KeysDialog$lambda$5);
        mutableState.setValue("");
        KeysDialog$lambda$1 = AutoSwitchUiKt.KeysDialog$lambda$1(mutableIntState);
        mutableIntState.setIntValue(KeysDialog$lambda$1 + 1);
        return Unit.INSTANCE;
    }
}

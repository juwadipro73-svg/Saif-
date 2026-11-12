package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$KeyDialog$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ String $hint;
    final /* synthetic */ MutableState<String> $key$delegate;
    final /* synthetic */ MutableState<Boolean> $show$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$KeyDialog$4(String str, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Context context) {
        this.$hint = str;
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
        String KeyDialog$lambda$74;
        boolean KeyDialog$lambda$77;
        final MutableState<Boolean> mutableState;
        ComposerKt.sourceInformation(composer, "C481@21746L880:SettingsScreen.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-442807277, i, -1, "com.clozed.code.ui.KeyDialog.<anonymous> (SettingsScreen.kt:481)");
        }
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(4));
        String str = this.$hint;
        final MutableState<String> mutableState2 = this.$key$delegate;
        MutableState<Boolean> mutableState3 = this.$show$delegate;
        final Context context = this.$ctx;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Modifier modifier = Modifier.Companion;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
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
        ComposerKt.sourceInformationMarkerStart(composer, 2105689134, "C483@21889L12,482@21821L339,488@22177L234:SettingsScreen.kt#qn8u0p");
        KeyDialog$lambda$74 = SettingsScreenKt.KeyDialog$lambda$74(mutableState2);
        KeyDialog$lambda$77 = SettingsScreenKt.KeyDialog$lambda$77(mutableState3);
        PasswordVisualTransformation none = KeyDialog$lambda$77 ? VisualTransformation.INSTANCE.getNone() : new PasswordVisualTransformation((char) 0, 1, null);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(1314852842);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$8$lambda$1$lambda$0;
                    invoke$lambda$8$lambda$1$lambda$0 = SettingsScreenKt$KeyDialog$4.invoke$lambda$8$lambda$1$lambda$0(mutableState2, (String) obj);
                    return invoke$lambda$8$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        OutlinedTextFieldKt.OutlinedTextField(KeyDialog$lambda$74, (Function1) rememberedValue, fillMaxWidth$default, false, false, (TextStyle) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1476getLambda19$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, none, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8241080);
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
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
        Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
        }
        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -483864952, "C489@22224L16,489@22242L38,489@22203L77,490@22322L52,490@22301L92:SettingsScreen.kt#qn8u0p");
        composer.startReplaceGroup(2062601933);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            mutableState = mutableState3;
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$4$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$8$lambda$7$lambda$3$lambda$2;
                    invoke$lambda$8$lambda$7$lambda$3$lambda$2 = SettingsScreenKt$KeyDialog$4.invoke$lambda$8$lambda$7$lambda$3$lambda$2(mutableState);
                    return invoke$lambda$8$lambda$7$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        } else {
            mutableState = mutableState3;
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(581205034, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$4$1$2$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer4, Integer num) {
                invoke(rowScope2, composer4, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer4, int i2) {
                boolean KeyDialog$lambda$772;
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer4, "C489@22244L34:SettingsScreen.kt#qn8u0p");
                if ((i2 & 17) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(581205034, i2, -1, "com.clozed.code.ui.KeyDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:489)");
                }
                KeyDialog$lambda$772 = SettingsScreenKt.KeyDialog$lambda$77(mutableState);
                TextKt.Text-Nvy7gAk(KeyDialog$lambda$772 ? "Hide" : "Show", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 805306374, 510);
        composer.startReplaceGroup(2062605105);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$4$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$8$lambda$7$lambda$6$lambda$5;
                    invoke$lambda$8$lambda$7$lambda$6$lambda$5 = SettingsScreenKt$KeyDialog$4.invoke$lambda$8$lambda$7$lambda$6$lambda$5(context, mutableState2);
                    return invoke$lambda$8$lambda$7$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1478getLambda20$app_release(), composer, 805306368, 510);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(1314870262);
        ComposerKt.sourceInformation(composer, "493@22521L10,493@22565L11,493@22468L126");
        if (str != null) {
            TextKt.Text-Nvy7gAk("Currently saved: " + str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
        }
        composer.endReplaceGroup();
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
    public static final Unit invoke$lambda$8$lambda$7$lambda$3$lambda$2(MutableState mutableState) {
        boolean KeyDialog$lambda$77;
        KeyDialog$lambda$77 = SettingsScreenKt.KeyDialog$lambda$77(mutableState);
        SettingsScreenKt.KeyDialog$lambda$78(mutableState, !KeyDialog$lambda$77);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7$lambda$6$lambda$5(Context context, MutableState mutableState) {
        String pasteFromClipboard = ComponentsKt.pasteFromClipboard(context);
        if (pasteFromClipboard != null) {
            mutableState.setValue(StringsKt.trim((CharSequence) pasteFromClipboard).toString());
        }
        return Unit.INSTANCE;
    }
}

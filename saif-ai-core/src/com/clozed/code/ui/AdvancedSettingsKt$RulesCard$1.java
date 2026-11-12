package com.clozed.code.ui;

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
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
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
import androidx.compose.ui.text.style.TextOverflow;
import com.clozed.code.engine.PermRule;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$RulesCard$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<List<PermRule>> $rules$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ ProviderStore $store;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$RulesCard$1(MutableState<List<PermRule>> mutableState, ProviderStore providerStore, MutableState<Boolean> mutableState2) {
        this.$rules$delegate = mutableState;
        this.$store = providerStore;
        this.$showAdd$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        List RulesCard$lambda$35;
        List RulesCard$lambda$352;
        long j;
        final MutableState<List<PermRule>> mutableState;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C220@10858L190,235@12027L18,235@11999L179:AdvancedSettings.kt#qn8u0p");
        if ((i & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2088674484, i, -1, "com.clozed.code.ui.RulesCard.<anonymous> (AdvancedSettings.kt:220)");
            }
            AdvancedSettingsKt.Hint("Allow/ask/deny by file or command. * works as a wildcard in patterns. The last matching rule wins. Permissions from the project folder's clozed.json (or opencode.json) are also read.", composer2, 6);
            composer2.startReplaceGroup(-1727196503);
            ComposerKt.sourceInformation(composer2, "221@11078L21");
            RulesCard$lambda$35 = AdvancedSettingsKt.RulesCard$lambda$35(this.$rules$delegate);
            if (RulesCard$lambda$35.isEmpty()) {
                AdvancedSettingsKt.Hint("No rules yet.", composer2, 6);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1727193845);
            ComposerKt.sourceInformation(composer2, "*224@11242L738");
            RulesCard$lambda$352 = AdvancedSettingsKt.RulesCard$lambda$35(this.$rules$delegate);
            ProviderStore providerStore = this.$store;
            MutableState<List<PermRule>> mutableState2 = this.$rules$delegate;
            int i2 = 0;
            int i3 = 0;
            for (Object obj : RulesCard$lambda$352) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PermRule permRule = (PermRule) obj;
                composer2.startReplaceGroup(-1727193459);
                ComposerKt.sourceInformation(composer2, "223@11202L11,223@11162L67");
                if (i3 > 0) {
                    DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), composer2, 0, 3);
                }
                composer2.endReplaceGroup();
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier = Modifier.Companion;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i2));
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
                ComposerKt.sourceInformationMarkerStart(composer2, 1628858360, "C225@11312L522,232@11872L52,232@11851L115:AdvancedSettings.kt#qn8u0p");
                Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, i2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i2));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, weight$default);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                    composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                    composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1228471583, "C226@11418L10,226@11362L126,228@11585L10,227@11509L307:AdvancedSettings.kt#qn8u0p");
                final ProviderStore providerStore2 = providerStore;
                MutableState<List<PermRule>> mutableState3 = mutableState2;
                int i5 = i2;
                final int i6 = i3;
                TextKt.Text-Nvy7gAk(permRule.getAction() + "  " + permRule.getPattern(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer, 0, 24960, 110590);
                String upperCase = permRule.getDecision().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                TextStyle labelSmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall();
                String decision = permRule.getDecision();
                if (Intrinsics.areEqual(decision, "deny")) {
                    composer.startReplaceGroup(1761497441);
                    ComposerKt.sourceInformation(composer, "229@11684L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError-0d7_KjU();
                } else if (Intrinsics.areEqual(decision, "allow")) {
                    composer.startReplaceGroup(1761498851);
                    ComposerKt.sourceInformation(composer, "229@11728L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer.startReplaceGroup(1761500228);
                    ComposerKt.sourceInformation(composer, "229@11771L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary-0d7_KjU();
                }
                composer.endReplaceGroup();
                TextKt.Text-Nvy7gAk(upperCase, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, labelSmall, composer, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.startReplaceGroup(1160939793);
                ComposerKt.sourceInformation(composer, "CC(remember):AdvancedSettings.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(providerStore2) | composer.changed(i6);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    mutableState = mutableState3;
                    rememberedValue = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$RulesCard$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$5$lambda$4$lambda$3$lambda$2;
                            invoke$lambda$5$lambda$4$lambda$3$lambda$2 = AdvancedSettingsKt$RulesCard$1.invoke$lambda$5$lambda$4$lambda$3$lambda$2(mutableState, i6, providerStore2);
                            return invoke$lambda$5$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                } else {
                    mutableState = mutableState3;
                }
                composer.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1350getLambda18$app_release(), composer, 1572864, 62);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                providerStore = providerStore2;
                mutableState2 = mutableState;
                i3 = i4;
                i2 = i5;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1727165487);
            ComposerKt.sourceInformation(composer2, "CC(remember):AdvancedSettings.kt#9igjgp");
            final MutableState<Boolean> mutableState4 = this.$showAdd$delegate;
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$RulesCard$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$7$lambda$6;
                        invoke$lambda$7$lambda$6 = AdvancedSettingsKt$RulesCard$1.invoke$lambda$7$lambda$6(mutableState4);
                        return invoke$lambda$7$lambda$6;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            ButtonKt.FilledTonalButton((Function0) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1351getLambda19$app_release(), composer, 805306422, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4$lambda$3$lambda$2(MutableState mutableState, int i, ProviderStore providerStore) {
        List RulesCard$lambda$35;
        RulesCard$lambda$35 = AdvancedSettingsKt.RulesCard$lambda$35(mutableState);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : RulesCard$lambda$35) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i2 != i) {
                arrayList.add(obj);
            }
            i2 = i3;
        }
        AdvancedSettingsKt.RulesCard$save$40(providerStore, mutableState, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(MutableState mutableState) {
        AdvancedSettingsKt.RulesCard$lambda$39(mutableState, true);
        return Unit.INSTANCE;
    }
}

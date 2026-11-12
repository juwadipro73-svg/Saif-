package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import com.clozed.code.engine.ChainEntry;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoSwitchUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AutoSwitchUiKt$AutoSwitchCard$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ List<ChainEntry> $chain;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<Boolean> $on$delegate;
    final /* synthetic */ MutableState<Boolean> $picking$delegate;
    final /* synthetic */ MutableIntState $rev$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoSwitchUiKt$AutoSwitchCard$1(ColorScheme colorScheme, List<ChainEntry> list, AppViewModel appViewModel, MutableState<Boolean> mutableState, MutableIntState mutableIntState, MutableState<Boolean> mutableState2) {
        this.$cs = colorScheme;
        this.$chain = list;
        this.$vm = appViewModel;
        this.$on$delegate = mutableState;
        this.$rev$delegate = mutableIntState;
        this.$picking$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope Card, Composer composer, int i) {
        boolean AutoSwitchCard$lambda$15;
        final MutableState<Boolean> mutableState;
        boolean AutoSwitchCard$lambda$152;
        final MutableIntState mutableIntState;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C131@6562L3545:AutoSwitchUi.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1761263432, i, -1, "com.clozed.code.ui.AutoSwitchCard.<anonymous> (AutoSwitchUi.kt:131)");
        }
        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
        final ColorScheme colorScheme = this.$cs;
        List<ChainEntry> list = this.$chain;
        AppViewModel appViewModel = this.$vm;
        MutableState<Boolean> mutableState2 = this.$on$delegate;
        MutableIntState mutableIntState2 = this.$rev$delegate;
        final MutableState<Boolean> mutableState3 = this.$picking$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
        ComposerKt.sourceInformationMarkerStart(composer, 323879069, "C132@6659L727:AutoSwitchUi.kt#qn8u0p");
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1916001257, "C133@6807L475,140@7338L33,140@7299L73:AutoSwitchUi.kt#qn8u0p");
        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, weight$default);
        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composer4 = Updater.constructor-impl(composer);
        Updater.set-impl(composer4, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
            composer4.updateRememberedValue(Integer.valueOf(hashCode3));
            composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
        }
        Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 446253846, "C134@6923L10,134@6857L87,137@7192L10,135@6965L299:AutoSwitchUi.kt#qn8u0p");
        List<ChainEntry> list2 = list;
        String str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
        MutableIntState mutableIntState3 = mutableIntState2;
        String str2 = "C89@4557L9:Column.kt#2w3rfo";
        String str3 = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
        String str4 = "C101@5233L9:Row.kt#2w3rfo";
        String str5 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
        final AppViewModel appViewModel2 = appViewModel;
        String str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
        TextKt.Text-Nvy7gAk("Auto-switch when a limit is reached", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
        TextKt.Text-Nvy7gAk("All keys of the chosen model are tried first (the next key when one is finished). Then the order below: first provider/model, then second, third...", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131066);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AutoSwitchCard$lambda$15 = AutoSwitchUiKt.AutoSwitchCard$lambda$15(mutableState2);
        composer.startReplaceGroup(215304632);
        ComposerKt.sourceInformation(composer, "CC(remember):AutoSwitchUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(appViewModel2);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            mutableState = mutableState2;
            rememberedValue = new Function1() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$19$lambda$3$lambda$2$lambda$1;
                    invoke$lambda$19$lambda$3$lambda$2$lambda$1 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$3$lambda$2$lambda$1(AppViewModel.this, mutableState, ((Boolean) obj).booleanValue());
                    return invoke$lambda$19$lambda$3$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        } else {
            mutableState = mutableState2;
        }
        composer.endReplaceGroup();
        SwitchKt.Switch(AutoSwitchCard$lambda$15, (Function1) rememberedValue, (Modifier) null, (Function2) null, false, (SwitchColors) null, (MutableInteractionSource) null, composer, 0, 124);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-1929191998);
        ComposerKt.sourceInformation(composer, "143@7425L44,144@7531L10,144@7486L67,174@9414L394,183@10015L10,181@9825L258");
        AutoSwitchCard$lambda$152 = AutoSwitchUiKt.AutoSwitchCard$lambda$15(mutableState);
        if (AutoSwitchCard$lambda$152) {
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, colorScheme.getOutlineVariant-0d7_KjU(), composer, 0, 3);
            String str7 = "CC(remember):AutoSwitchUi.kt#9igjgp";
            TextKt.Text-Nvy7gAk("Fallback order", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 6, 0, 131070);
            Composer composer5 = composer;
            composer5.startReplaceGroup(-1929188965);
            ComposerKt.sourceInformation(composer5, "148@7739L10,146@7613L198");
            if (list2.isEmpty()) {
                TextKt.Text-Nvy7gAk("No fallback yet. Add a provider + model below.", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131066);
                composer5 = composer;
            }
            composer5.endReplaceGroup();
            composer5.startReplaceGroup(-1929178655);
            ComposerKt.sourceInformation(composer5, "*153@7962L1417");
            int i2 = 0;
            for (Object obj : list2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChainEntry chainEntry = (ChainEntry) obj;
                boolean providerExhausted = appViewModel2.providerExhausted(chainEntry.getProviderId());
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                String str8 = str6;
                ComposerKt.sourceInformationMarkerStart(composer5, 844473419, str8);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer5, 48);
                String str9 = str5;
                ComposerKt.sourceInformationMarkerStart(composer5, -1159599143, str9);
                int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer5, fillMaxWidth$default2);
                Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                String str10 = str;
                ComposerKt.sourceInformationMarkerStart(composer5, -553112988, str10);
                if (!(composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer5.startReusableNode();
                if (composer5.getInserting()) {
                    composer5.createNode(constructor4);
                } else {
                    composer5.useNode();
                }
                Composer composer6 = Updater.constructor-impl(composer5);
                Updater.set-impl(composer6, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode4))) {
                    composer6.updateRememberedValue(Integer.valueOf(hashCode4));
                    composer6.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
                }
                Updater.set-impl(composer6, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                String str11 = str4;
                ComposerKt.sourceInformationMarkerStart(composer5, 1456264949, str11);
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer5, 447479617, "C154@8065L568,163@8696L136,163@8658L221,166@8956L136,166@8904L239,169@9189L57,169@9248L109,169@9168L189:AutoSwitchUi.kt#qn8u0p");
                Modifier weight$default2 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
                String str12 = str3;
                ComposerKt.sourceInformationMarkerStart(composer5, 1341605231, str12);
                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, 0);
                ComposerKt.sourceInformationMarkerStart(composer5, -1159599143, str9);
                int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composer5.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer5, weight$default2);
                Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer5, -553112988, str10);
                if (!(composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer5.startReusableNode();
                if (composer5.getInserting()) {
                    composer5.createNode(constructor5);
                } else {
                    composer5.useNode();
                }
                Composer composer7 = Updater.constructor-impl(composer5);
                Updater.set-impl(composer7, columnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer7, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer7.getInserting() || !Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(hashCode5))) {
                    composer7.updateRememberedValue(Integer.valueOf(hashCode5));
                    composer7.apply(Integer.valueOf(hashCode5), setCompositeKeyHash5);
                }
                Updater.set-impl(composer7, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                String str13 = str2;
                ComposerKt.sourceInformationMarkerStart(composer5, 2093002350, str13);
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer5, -1607832310, "C155@8197L10,155@8123L95,158@8392L10,156@8247L360:AutoSwitchUi.kt#qn8u0p");
                str3 = str12;
                final int i4 = i2;
                final AppViewModel appViewModel3 = appViewModel2;
                TextKt.Text-Nvy7gAk(i3 + ".  " + appViewModel2.providerName(chainEntry.getProviderId()), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131070);
                TextKt.Text-Nvy7gAk(chainEntry.getModelId() + (providerExhausted ? "  ·  ⛔ limit reached" : ""), (Modifier) null, providerExhausted ? colorScheme.getError-0d7_KjU() : colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 24960, 110586);
                composer5 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                boolean z = i4 > 0;
                composer5.startReplaceGroup(-262640802);
                String str14 = str7;
                ComposerKt.sourceInformation(composer5, str14);
                final List<ChainEntry> list3 = list2;
                boolean changedInstance2 = composer5.changedInstance(list3) | composer5.changed(i4) | composer5.changedInstance(appViewModel3);
                Object rememberedValue2 = composer5.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    mutableIntState = mutableIntState3;
                    rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$19$lambda$13$lambda$12$lambda$6$lambda$5;
                            invoke$lambda$19$lambda$13$lambda$12$lambda$6$lambda$5 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$13$lambda$12$lambda$6$lambda$5(list3, i4, appViewModel3, mutableIntState);
                            return invoke$lambda$19$lambda$13$lambda$12$lambda$6$lambda$5;
                        }
                    };
                    composer5.updateRememberedValue(rememberedValue2);
                } else {
                    mutableIntState = mutableIntState3;
                }
                composer5.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue2, (Modifier) null, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1386getLambda6$app_release(), composer5, 1572864, 58);
                boolean z2 = i4 < CollectionsKt.getLastIndex(list3);
                composer5.startReplaceGroup(-262632482);
                ComposerKt.sourceInformation(composer5, str14);
                boolean changedInstance3 = composer5.changedInstance(list3) | composer5.changed(i4) | composer5.changedInstance(appViewModel3);
                Object rememberedValue3 = composer5.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$19$lambda$13$lambda$12$lambda$8$lambda$7;
                            invoke$lambda$19$lambda$13$lambda$12$lambda$8$lambda$7 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$13$lambda$12$lambda$8$lambda$7(list3, i4, appViewModel3, mutableIntState);
                            return invoke$lambda$19$lambda$13$lambda$12$lambda$8$lambda$7;
                        }
                    };
                    composer5.updateRememberedValue(rememberedValue3);
                }
                composer5.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue3, (Modifier) null, z2, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1387getLambda7$app_release(), composer5, 1572864, 58);
                composer5.startReplaceGroup(-262625105);
                ComposerKt.sourceInformation(composer5, str14);
                boolean changedInstance4 = composer5.changedInstance(appViewModel3) | composer5.changedInstance(list3) | composer5.changed(i4);
                Object rememberedValue4 = composer5.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$19$lambda$13$lambda$12$lambda$11$lambda$10;
                            invoke$lambda$19$lambda$13$lambda$12$lambda$11$lambda$10 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$13$lambda$12$lambda$11$lambda$10(list3, i4, appViewModel3, mutableIntState);
                            return invoke$lambda$19$lambda$13$lambda$12$lambda$11$lambda$10;
                        }
                    };
                    composer5.updateRememberedValue(rememberedValue4);
                }
                composer5.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue4, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1864996167, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$1$2$1$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer8, Integer num) {
                        invoke(composer8, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer8, int i5) {
                        ComposerKt.sourceInformation(composer8, "C170@9278L53:AutoSwitchUi.kt#qn8u0p");
                        if ((i5 & 3) == 2 && composer8.getSkipping()) {
                            composer8.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1864996167, i5, -1, "com.clozed.code.ui.AutoSwitchCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AutoSwitchUi.kt:170)");
                        }
                        IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Remove", (Modifier) null, colorScheme.getError-0d7_KjU(), composer8, 48, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer5, 54), composer5, 1572864, 62);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                list2 = list3;
                mutableIntState3 = mutableIntState;
                str7 = str14;
                appViewModel2 = appViewModel3;
                i2 = i3;
                str2 = str13;
                str4 = str11;
                str6 = str8;
                str = str10;
                str5 = str9;
            }
            final AppViewModel appViewModel4 = appViewModel2;
            final MutableIntState mutableIntState4 = mutableIntState3;
            String str15 = str4;
            String str16 = str7;
            composer5.endReplaceGroup();
            Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer5, 844473419, str6);
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontal2, Alignment.Companion.getTop(), composer5, 6);
            ComposerKt.sourceInformationMarkerStart(composer5, -1159599143, str5);
            int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer5.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer5, modifier2);
            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer5, -553112988, str);
            if (!(composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(constructor6);
            } else {
                composer5.useNode();
            }
            Composer composer8 = Updater.constructor-impl(composer5);
            Updater.set-impl(composer8, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer8.getInserting() || !Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(hashCode6))) {
                composer8.updateRememberedValue(Integer.valueOf(hashCode6));
                composer8.apply(Integer.valueOf(hashCode6), setCompositeKeyHash6);
            }
            Updater.set-impl(composer8, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer5, 1456264949, str15);
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer5, -1913346014, "C175@9520L18,175@9492L194,179@9728L31,179@9707L83:AutoSwitchUi.kt#qn8u0p");
            composer5.startReplaceGroup(215374441);
            ComposerKt.sourceInformation(composer5, str16);
            Object rememberedValue5 = composer5.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$19$lambda$18$lambda$15$lambda$14;
                        invoke$lambda$19$lambda$18$lambda$15$lambda$14 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$18$lambda$15$lambda$14(mutableState3);
                        return invoke$lambda$19$lambda$18$lambda$15$lambda$14;
                    }
                };
                composer5.updateRememberedValue(rememberedValue5);
            }
            composer5.endReplaceGroup();
            ButtonKt.FilledTonalButton((Function0) rememberedValue5, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1388getLambda8$app_release(), composer, 805306374, 510);
            composer.startReplaceGroup(215381110);
            ComposerKt.sourceInformation(composer, str16);
            boolean changedInstance5 = composer.changedInstance(appViewModel4);
            Object rememberedValue6 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$AutoSwitchCard$1$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$19$lambda$18$lambda$17$lambda$16;
                        invoke$lambda$19$lambda$18$lambda$17$lambda$16 = AutoSwitchUiKt$AutoSwitchCard$1.invoke$lambda$19$lambda$18$lambda$17$lambda$16(AppViewModel.this, mutableIntState4);
                        return invoke$lambda$19$lambda$18$lambda$17$lambda$16;
                    }
                };
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) rememberedValue6, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1389getLambda9$app_release(), composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk("If every key / provider has reached its limit, the app will stop and tell you. Flags clear automatically the next day.", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131066);
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
    public static final Unit invoke$lambda$19$lambda$3$lambda$2$lambda$1(AppViewModel appViewModel, MutableState mutableState, boolean z) {
        AutoSwitchUiKt.AutoSwitchCard$lambda$16(mutableState, z);
        appViewModel.setAutoSwitch(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$13$lambda$12$lambda$6$lambda$5(List list, int i, AppViewModel appViewModel, MutableIntState mutableIntState) {
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(i - 1, (ChainEntry) mutableList.remove(i));
        AutoSwitchUiKt.AutoSwitchCard$update(appViewModel, mutableIntState, mutableList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$13$lambda$12$lambda$8$lambda$7(List list, int i, AppViewModel appViewModel, MutableIntState mutableIntState) {
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(i + 1, (ChainEntry) mutableList.remove(i));
        AutoSwitchUiKt.AutoSwitchCard$update(appViewModel, mutableIntState, mutableList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$13$lambda$12$lambda$11$lambda$10(List list, int i, AppViewModel appViewModel, MutableIntState mutableIntState) {
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.remove(i);
        Unit unit = Unit.INSTANCE;
        AutoSwitchUiKt.AutoSwitchCard$update(appViewModel, mutableIntState, mutableList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$18$lambda$15$lambda$14(MutableState mutableState) {
        AutoSwitchUiKt.AutoSwitchCard$lambda$20(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$19$lambda$18$lambda$17$lambda$16(AppViewModel appViewModel, MutableIntState mutableIntState) {
        int AutoSwitchCard$lambda$12;
        appViewModel.resetLimitFlags();
        AutoSwitchCard$lambda$12 = AutoSwitchUiKt.AutoSwitchCard$lambda$12(mutableIntState);
        mutableIntState.setIntValue(AutoSwitchCard$lambda$12 + 1);
        return Unit.INSTANCE;
    }
}

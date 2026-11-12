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
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.clozed.code.engine.Skill;
import com.clozed.code.engine.Skills;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$SkillsCard$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ File $dir;
    final /* synthetic */ List<Skill> $list;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ MutableState<Integer> $tick$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$SkillsCard$1(List<Skill> list, File file, MutableState<Integer> mutableState, MutableState<Boolean> mutableState2) {
        this.$list = list;
        this.$dir = file;
        this.$tick$delegate = mutableState;
        this.$showAdd$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        final MutableState<Integer> mutableState;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C336@17217L192,348@18053L18,348@18025L180:AdvancedSettings.kt#qn8u0p");
        if ((i & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499118246, i, -1, "com.clozed.code.ui.SkillsCard.<anonymous> (AdvancedSettings.kt:336)");
            }
            AdvancedSettingsKt.Hint("Skills = reusable instructions that the agent loads on its own when needed (skill tool). .clozed/skills/<name>/SKILL.md or .claude/skills in the project are detected automatically too.", composer2, 6);
            composer2.startReplaceGroup(-1222337662);
            ComposerKt.sourceInformation(composer2, "337@17438L22");
            if (this.$list.isEmpty()) {
                AdvancedSettingsKt.Hint("No skills yet.", composer2, 6);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1222335370);
            ComposerKt.sourceInformation(composer2, "*340@17603L403");
            List<Skill> list = this.$list;
            File file = this.$dir;
            MutableState<Integer> mutableState2 = this.$tick$delegate;
            int i2 = 0;
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final Skill skill = (Skill) obj;
                composer2.startReplaceGroup(-1222334618);
                ComposerKt.sourceInformation(composer2, "339@17563L11,339@17523L67");
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
                ComposerKt.sourceInformationMarkerStart(composer2, 1616104622, "C341@17673L200,345@17911L39,345@17890L102:AdvancedSettings.kt#qn8u0p");
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
                ComposerKt.sourceInformationMarkerStart(composer2, 385222314, "C342@17759L10,342@17723L58:AdvancedSettings.kt#qn8u0p");
                final File file2 = file;
                MutableState<Integer> mutableState3 = mutableState2;
                int i5 = i2;
                TextKt.Text-Nvy7gAk(skill.getName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleSmall(), composer, 0, 0, 131070);
                composer.startReplaceGroup(-1234497014);
                ComposerKt.sourceInformation(composer, "343@17835L20");
                if (!StringsKt.isBlank(skill.getDescription())) {
                    AdvancedSettingsKt.Hint(skill.getDescription(), composer, i5);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.startReplaceGroup(2130349725);
                ComposerKt.sourceInformation(composer, "CC(remember):AdvancedSettings.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(file2) | composer.changedInstance(skill);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    mutableState = mutableState3;
                    rememberedValue = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$SkillsCard$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1;
                            invoke$lambda$4$lambda$3$lambda$2$lambda$1 = AdvancedSettingsKt$SkillsCard$1.invoke$lambda$4$lambda$3$lambda$2$lambda$1(file2, skill, mutableState);
                            return invoke$lambda$4$lambda$3$lambda$2$lambda$1;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                } else {
                    mutableState = mutableState3;
                }
                composer.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1367getLambda33$app_release(), composer, 1572864, 62);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                i2 = i5;
                file = file2;
                mutableState2 = mutableState;
                i3 = i4;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1222317366);
            ComposerKt.sourceInformation(composer2, "CC(remember):AdvancedSettings.kt#9igjgp");
            final MutableState<Boolean> mutableState4 = this.$showAdd$delegate;
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$SkillsCard$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$5;
                        invoke$lambda$6$lambda$5 = AdvancedSettingsKt$SkillsCard$1.invoke$lambda$6$lambda$5(mutableState4);
                        return invoke$lambda$6$lambda$5;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            ButtonKt.FilledTonalButton((Function0) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1368getLambda34$app_release(), composer, 805306422, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1(File file, Skill skill, MutableState mutableState) {
        int SkillsCard$lambda$73;
        Skills skills = Skills.INSTANCE;
        Intrinsics.checkNotNull(file);
        skills.delete(file, skill.getName());
        SkillsCard$lambda$73 = AdvancedSettingsKt.SkillsCard$lambda$73(mutableState);
        AdvancedSettingsKt.SkillsCard$lambda$74(mutableState, SkillsCard$lambda$73 + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(MutableState mutableState) {
        AdvancedSettingsKt.SkillsCard$lambda$78(mutableState, true);
        return Unit.INSTANCE;
    }
}

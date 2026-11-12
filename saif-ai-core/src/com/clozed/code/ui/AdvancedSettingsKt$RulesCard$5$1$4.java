package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.SegmentedButtonColors;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.core.view.PointerIconCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class AdvancedSettingsKt$RulesCard$5$1$4 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $decision$delegate;
    final /* synthetic */ List<String> $decisions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$RulesCard$5$1$4(List<String> list, MutableState<String> mutableState) {
        this.$decisions = list;
        this.$decision$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
        invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, int i) {
        String RulesCard$lambda$48;
        SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow = singleChoiceSegmentedButtonRowScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer2, "C*262@13635L16,263@13717L28,264@13777L11,261@13550L238:AdvancedSettings.kt#qn8u0p");
        int i2 = (i & 6) == 0 ? i | (composer2.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2) : i;
        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-261481001, i2, -1, "com.clozed.code.ui.RulesCard.<anonymous>.<anonymous>.<anonymous> (AdvancedSettings.kt:260)");
            }
            List<String> list = this.$decisions;
            final MutableState<String> mutableState = this.$decision$delegate;
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final String str = (String) obj;
                RulesCard$lambda$48 = AdvancedSettingsKt.RulesCard$lambda$48(mutableState);
                boolean areEqual = Intrinsics.areEqual(RulesCard$lambda$48, str);
                composer2.startReplaceGroup(1761559500);
                ComposerKt.sourceInformation(composer2, "CC(remember):AdvancedSettings.kt#9igjgp");
                boolean changed = composer2.changed(str);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$RulesCard$5$1$4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$2$lambda$1$lambda$0;
                            invoke$lambda$2$lambda$1$lambda$0 = AdvancedSettingsKt$RulesCard$5$1$4.invoke$lambda$2$lambda$1$lambda$0(str, mutableState);
                            return invoke$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, areEqual, (Function0) rememberedValue, SegmentedButtonDefaults.INSTANCE.itemShape(i3, list.size(), (CornerBasedShape) null, composer2, 3072, 4), (Modifier) null, false, (SegmentedButtonColors) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-518892369, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$RulesCard$5$1$4$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i5) {
                        ComposerKt.sourceInformation(composer3, "C264@13779L7:AdvancedSettings.kt#qn8u0p");
                        if ((i5 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-518892369, i5, -1, "com.clozed.code.ui.RulesCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdvancedSettings.kt:264)");
                        }
                        TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, i2 & 14, 48, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                SingleChoiceSegmentedButtonRow = singleChoiceSegmentedButtonRowScope;
                composer2 = composer;
                i3 = i4;
                i2 = i2;
                list = list;
                mutableState = mutableState;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }
}

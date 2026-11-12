package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.SegmentedButtonColors;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class SettingsScreenKt$CustomProviderDialog$4$1$9 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $anthropic$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$CustomProviderDialog$4$1$9(MutableState<Boolean> mutableState) {
        this.$anthropic$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
        invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        SettingsScreenKt.CustomProviderDialog$lambda$101(mutableState, false);
        return Unit.INSTANCE;
    }

    public final void invoke(SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow, Composer composer, int i) {
        int i2;
        boolean CustomProviderDialog$lambda$100;
        boolean CustomProviderDialog$lambda$1002;
        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer, "C568@27266L21,568@27321L15,568@27217L150,569@27436L20,569@27490L15,569@27388L140:SettingsScreen.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1394014589, i2, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:568)");
        }
        CustomProviderDialog$lambda$100 = SettingsScreenKt.CustomProviderDialog$lambda$100(this.$anthropic$delegate);
        boolean z = !CustomProviderDialog$lambda$100;
        composer.startReplaceGroup(299734819);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        final MutableState<Boolean> mutableState = this.$anthropic$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$9$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SettingsScreenKt$CustomProviderDialog$4$1$9.invoke$lambda$1$lambda$0(mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        int i3 = (i2 & 14) | 384;
        SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, z, (Function0) rememberedValue, SegmentedButtonDefaults.INSTANCE.itemShape(0, 2, (CornerBasedShape) null, composer, 3126, 4), (Modifier) null, false, (SegmentedButtonColors) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1486getLambda28$app_release(), composer, i3, 48, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
        CustomProviderDialog$lambda$1002 = SettingsScreenKt.CustomProviderDialog$lambda$100(this.$anthropic$delegate);
        composer.startReplaceGroup(299740258);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        final MutableState<Boolean> mutableState2 = this.$anthropic$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$9$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = SettingsScreenKt$CustomProviderDialog$4$1$9.invoke$lambda$3$lambda$2(mutableState2);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, CustomProviderDialog$lambda$1002, (Function0) rememberedValue2, SegmentedButtonDefaults.INSTANCE.itemShape(1, 2, (CornerBasedShape) null, composer, 3126, 4), (Modifier) null, false, (SegmentedButtonColors) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1487getLambda29$app_release(), composer, i3, 48, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState mutableState) {
        SettingsScreenKt.CustomProviderDialog$lambda$101(mutableState, true);
        return Unit.INSTANCE;
    }
}

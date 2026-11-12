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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$ConnectScreen$1$3 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $local$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$ConnectScreen$1$3(MutableState<Boolean> mutableState) {
        this.$local$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
        invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow, Composer composer, int i) {
        int i2;
        boolean ConnectScreen$lambda$2;
        boolean ConnectScreen$lambda$22;
        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer, "C121@5816L16,122@5882L15,120@5755L179,125@6009L17,126@6076L15,124@5947L185:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1276962080, i2, -1, "com.clozed.code.ui.ConnectScreen.<anonymous>.<anonymous> (SessionsScreens.kt:120)");
            }
            ConnectScreen$lambda$2 = SessionsScreensKt.ConnectScreen$lambda$2(this.$local$delegate);
            composer.startReplaceGroup(266247933);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changed = composer.changed(this.$local$delegate);
            final MutableState<Boolean> mutableState = this.$local$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$ConnectScreen$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SessionsScreensKt$ConnectScreen$1$3.invoke$lambda$1$lambda$0(mutableState);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            int i3 = i2 & 14;
            SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, ConnectScreen$lambda$2, (Function0) rememberedValue, SegmentedButtonDefaults.INSTANCE.itemShape(0, 2, (CornerBasedShape) null, composer, 3126, 4), (Modifier) null, false, (SegmentedButtonColors) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1432getLambda1$app_release(), composer, i3, 48, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            ConnectScreen$lambda$22 = SessionsScreensKt.ConnectScreen$lambda$2(this.$local$delegate);
            boolean z = !ConnectScreen$lambda$22;
            composer.startReplaceGroup(266254110);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changed2 = composer.changed(this.$local$delegate);
            final MutableState<Boolean> mutableState2 = this.$local$delegate;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$ConnectScreen$1$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2;
                        invoke$lambda$3$lambda$2 = SessionsScreensKt$ConnectScreen$1$3.invoke$lambda$3$lambda$2(mutableState2);
                        return invoke$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, z, (Function0) rememberedValue2, SegmentedButtonDefaults.INSTANCE.itemShape(1, 2, (CornerBasedShape) null, composer, 3126, 4), (Modifier) null, false, (SegmentedButtonColors) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1443getLambda2$app_release(), composer, i3, 48, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        SessionsScreensKt.ConnectScreen$lambda$3(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState mutableState) {
        SessionsScreensKt.ConnectScreen$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }
}

package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.clozed.code.data.SessionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$8$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<SessionInfo> $renaming$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$8$3(MutableState<SessionInfo> mutableState) {
        this.$renaming$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C377@17850L19,377@17829L60:SessionsScreens.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-684282799, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:377)");
        }
        composer.startReplaceGroup(1623228961);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        final MutableState<SessionInfo> mutableState = this.$renaming$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$8$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$8$3.invoke$lambda$1$lambda$0(mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1447getLambda23$app_release(), composer, 805306374, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

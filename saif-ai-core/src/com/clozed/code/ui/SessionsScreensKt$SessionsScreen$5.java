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
import com.clozed.code.AppViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $copyOpen$delegate;
    final /* synthetic */ MutableState<String> $dir$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<String> $portSrc$delegate;
    final /* synthetic */ MutableState<String> $portWhat$delegate;
    final /* synthetic */ MutableState<Boolean> $showNew$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$5(AppViewModel appViewModel, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6) {
        this.$vm = appViewModel;
        this.$showNew$delegate = mutableState;
        this.$dir$delegate = mutableState2;
        this.$name$delegate = mutableState3;
        this.$copyOpen$delegate = mutableState4;
        this.$portSrc$delegate = mutableState5;
        this.$portWhat$delegate = mutableState6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C360@17012L141,360@16991L181:SessionsScreens.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1210053167, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous> (SessionsScreens.kt:360)");
        }
        composer.startReplaceGroup(-2042997156);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm);
        final AppViewModel appViewModel = this.$vm;
        final MutableState<Boolean> mutableState = this.$showNew$delegate;
        final MutableState<String> mutableState2 = this.$dir$delegate;
        final MutableState<String> mutableState3 = this.$name$delegate;
        final MutableState<Boolean> mutableState4 = this.$copyOpen$delegate;
        final MutableState<String> mutableState5 = this.$portSrc$delegate;
        final MutableState<String> mutableState6 = this.$portWhat$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$5.invoke$lambda$1$lambda$0(AppViewModel.this, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1438getLambda15$app_release(), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6) {
        String SessionsScreen$lambda$44;
        String SessionsScreen$lambda$47;
        boolean SessionsScreen$lambda$53;
        String SessionsScreen$lambda$59;
        SessionsScreensKt.SessionsScreen$lambda$36(mutableState, false);
        SessionsScreen$lambda$44 = SessionsScreensKt.SessionsScreen$lambda$44(mutableState2);
        SessionsScreen$lambda$47 = SessionsScreensKt.SessionsScreen$lambda$47(mutableState3);
        SessionsScreen$lambda$53 = SessionsScreensKt.SessionsScreen$lambda$53(mutableState4);
        String SessionsScreen$lambda$56 = SessionsScreen$lambda$53 ? SessionsScreensKt.SessionsScreen$lambda$56(mutableState5) : "";
        SessionsScreen$lambda$59 = SessionsScreensKt.SessionsScreen$lambda$59(mutableState6);
        appViewModel.newSession(SessionsScreen$lambda$44, SessionsScreen$lambda$47, SessionsScreen$lambda$56, SessionsScreen$lambda$59);
        return Unit.INSTANCE;
    }
}

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
import com.clozed.code.data.SessionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$9$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<SessionInfo> $deleting$delegate;
    final /* synthetic */ SessionInfo $s;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$9$2(AppViewModel appViewModel, SessionInfo sessionInfo, MutableState<SessionInfo> mutableState) {
        this.$vm = appViewModel;
        this.$s = sessionInfo;
        this.$deleting$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, SessionInfo sessionInfo, MutableState mutableState) {
        appViewModel.deleteSession(sessionInfo.getId());
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C388@18219L43,388@18198L161:SessionsScreens.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1254131766, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:388)");
        }
        composer.startReplaceGroup(1623240793);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm) | composer.changed(this.$s);
        final AppViewModel appViewModel = this.$vm;
        final SessionInfo sessionInfo = this.$s;
        final MutableState<SessionInfo> mutableState = this.$deleting$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$9$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$9$2.invoke$lambda$1$lambda$0(AppViewModel.this, sessionInfo, mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1450getLambda26$app_release(), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

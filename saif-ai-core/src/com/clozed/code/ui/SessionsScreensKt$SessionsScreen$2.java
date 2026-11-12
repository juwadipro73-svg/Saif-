package com.clozed.code.ui;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $showNew$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$2(MutableState<Boolean> mutableState) {
        this.$showNew$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C265@12424L18,264@12368L195:SessionsScreens.kt#qn8u0p");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1347645795, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous> (SessionsScreens.kt:264)");
            }
            Function2<Composer, Integer, Unit> m1436getLambda13$app_release = ComposableSingletons$SessionsScreensKt.INSTANCE.m1436getLambda13$app_release();
            Function2<Composer, Integer, Unit> m1437getLambda14$app_release = ComposableSingletons$SessionsScreensKt.INSTANCE.m1437getLambda14$app_release();
            composer.startReplaceGroup(-2043144095);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            final MutableState<Boolean> mutableState = this.$showNew$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$2.invoke$lambda$1$lambda$0(mutableState);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            FloatingActionButtonKt.ExtendedFloatingActionButton-ElI5-7k(m1436getLambda13$app_release, m1437getLambda14$app_release, (Function0) rememberedValue, (Modifier) null, false, (Shape) null, 0L, 0L, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, composer, 438, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
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
        SessionsScreensKt.SessionsScreen$lambda$36(mutableState, true);
        return Unit.INSTANCE;
    }
}

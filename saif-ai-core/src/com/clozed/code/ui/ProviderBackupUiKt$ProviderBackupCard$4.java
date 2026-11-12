package com.clozed.code.ui;

import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProviderBackupUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderBackupUiKt$ProviderBackupCard$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ManagedActivityResultLauncher<String[], Uri> $openLauncher;
    final /* synthetic */ MutableState<Boolean> $showImport$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderBackupUiKt$ProviderBackupCard$4(ManagedActivityResultLauncher<String[], Uri> managedActivityResultLauncher, MutableState<Boolean> mutableState) {
        this.$openLauncher = managedActivityResultLauncher;
        this.$showImport$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4872L169,102@4851L215:ProviderBackupUi.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-319696265, i, -1, "com.clozed.code.ui.ProviderBackupCard.<anonymous> (ProviderBackupUi.kt:102)");
        }
        composer.startReplaceGroup(-1580621486);
        ComposerKt.sourceInformation(composer, "CC(remember):ProviderBackupUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$openLauncher);
        final ManagedActivityResultLauncher<String[], Uri> managedActivityResultLauncher = this.$openLauncher;
        final MutableState<Boolean> mutableState = this.$showImport$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$ProviderBackupCard$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProviderBackupUiKt$ProviderBackupCard$4.invoke$lambda$1$lambda$0(managedActivityResultLauncher, mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1430getLambda8$app_release(), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        ProviderBackupUiKt.ProviderBackupCard$lambda$8(mutableState, false);
        managedActivityResultLauncher.launch(new String[]{"application/json", "text/plain", "application/octet-stream"});
        return Unit.INSTANCE;
    }
}

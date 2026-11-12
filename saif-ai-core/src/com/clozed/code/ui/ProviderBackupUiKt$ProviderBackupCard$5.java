package com.clozed.code.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProviderBackupUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderBackupUiKt$ProviderBackupCard$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ MutableState<Boolean> $showImport$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderBackupUiKt$ProviderBackupCard$5(Context context, AppViewModel appViewModel, MutableState<Boolean> mutableState) {
        this.$ctx = context;
        this.$vm = appViewModel;
        this.$showImport$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@5149L435,108@5128L490:ProviderBackupUi.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2041698951, i, -1, "com.clozed.code.ui.ProviderBackupCard.<anonymous> (ProviderBackupUi.kt:108)");
        }
        composer.startReplaceGroup(-1580612356);
        ComposerKt.sourceInformation(composer, "CC(remember):ProviderBackupUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$ctx) | composer.changedInstance(this.$vm);
        final Context context = this.$ctx;
        final AppViewModel appViewModel = this.$vm;
        final MutableState<Boolean> mutableState = this.$showImport$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$ProviderBackupCard$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = ProviderBackupUiKt$ProviderBackupCard$5.invoke$lambda$2$lambda$1(context, appViewModel, mutableState);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1431getLambda9$app_release(), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(Context context, AppViewModel appViewModel, MutableState mutableState) {
        ClipData.Item itemAt;
        CharSequence text;
        ProviderBackupUiKt.ProviderBackupCard$lambda$8(mutableState, false);
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
        String str = null;
        if (primaryClip != null) {
            if (primaryClip.getItemCount() <= 0) {
                primaryClip = null;
            }
            if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null && (text = itemAt.getText()) != null) {
                str = text.toString();
            }
        }
        if (str == null) {
            str = "";
        }
        if (StringsKt.isBlank(str)) {
            Toast.makeText(context, "Clipboard is empty", 0).show();
        } else {
            appViewModel.importProvidersJson(str);
        }
        return Unit.INSTANCE;
    }
}

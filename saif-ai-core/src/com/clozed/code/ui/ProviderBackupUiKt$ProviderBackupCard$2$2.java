package com.clozed.code.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
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
import com.clozed.code.AppViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProviderBackupUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderBackupUiKt$ProviderBackupCard$2$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ String $mode;
    final /* synthetic */ MutableState<String> $pendingText$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $saveLauncher;
    final /* synthetic */ AppViewModel $vm;
    final /* synthetic */ MutableState<String> $warnFor$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderBackupUiKt$ProviderBackupCard$2$2(AppViewModel appViewModel, Context context, String str, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher, MutableState<String> mutableState, MutableState<String> mutableState2) {
        this.$vm = appViewModel;
        this.$ctx = context;
        this.$mode = str;
        this.$saveLauncher = managedActivityResultLauncher;
        this.$warnFor$delegate = mutableState;
        this.$pendingText$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3657L701,78@3636L744:ProviderBackupUi.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1236920288, i, -1, "com.clozed.code.ui.ProviderBackupCard.<anonymous>.<anonymous> (ProviderBackupUi.kt:78)");
        }
        composer.startReplaceGroup(1212880901);
        ComposerKt.sourceInformation(composer, "CC(remember):ProviderBackupUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm) | composer.changedInstance(this.$ctx) | composer.changed(this.$mode) | composer.changedInstance(this.$saveLauncher);
        final AppViewModel appViewModel = this.$vm;
        final Context context = this.$ctx;
        final String str = this.$mode;
        final ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher = this.$saveLauncher;
        final MutableState<String> mutableState = this.$warnFor$delegate;
        final MutableState<String> mutableState2 = this.$pendingText$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$ProviderBackupCard$2$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProviderBackupUiKt$ProviderBackupCard$2$2.invoke$lambda$1$lambda$0(AppViewModel.this, context, str, managedActivityResultLauncher, mutableState, mutableState2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1426getLambda4$app_release(), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, Context context, String str, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        String exportProvidersJson = appViewModel.exportProvidersJson();
        if (exportProvidersJson == null) {
            Toast.makeText(context, "Nothing to export", 0).show();
        } else if (!Intrinsics.areEqual(str, "file")) {
            Intent putExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", exportProvidersJson);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(Intent.createChooser(putExtra, "Share providers").addFlags(268435456));
        } else {
            mutableState2.setValue(exportProvidersJson);
            managedActivityResultLauncher.launch("clozed-providers.json");
        }
        return Unit.INSTANCE;
    }
}

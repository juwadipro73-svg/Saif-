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
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatExtras.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatExtrasKt$PortDialog$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ MutableState<String> $source$delegate;
    final /* synthetic */ AppViewModel $vm;
    final /* synthetic */ MutableState<String> $what$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatExtrasKt$PortDialog$1(AppViewModel appViewModel, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2) {
        this.$vm = appViewModel;
        this.$onDismiss = function0;
        this.$source$delegate = mutableState;
        this.$what$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, Function0 function0, MutableState mutableState, MutableState mutableState2) {
        String PortDialog$lambda$16;
        String PortDialog$lambda$19;
        PortDialog$lambda$16 = ChatExtrasKt.PortDialog$lambda$16(mutableState);
        PortDialog$lambda$19 = ChatExtrasKt.PortDialog$lambda$19(mutableState2);
        appViewModel.portFromProject(PortDialog$lambda$16, PortDialog$lambda$19);
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String PortDialog$lambda$16;
        ComposerKt.sourceInformation(composer, "C91@4523L49,91@4471L120:ChatExtras.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(640018232, i, -1, "com.clozed.code.ui.PortDialog.<anonymous> (ChatExtras.kt:91)");
        }
        PortDialog$lambda$16 = ChatExtrasKt.PortDialog$lambda$16(this.$source$delegate);
        boolean z = !StringsKt.isBlank(PortDialog$lambda$16);
        composer.startReplaceGroup(-1163156960);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm) | composer.changed(this.$onDismiss);
        final AppViewModel appViewModel = this.$vm;
        final Function0<Unit> function0 = this.$onDismiss;
        final MutableState<String> mutableState = this.$source$delegate;
        final MutableState<String> mutableState2 = this.$what$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$PortDialog$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ChatExtrasKt$PortDialog$1.invoke$lambda$1$lambda$0(AppViewModel.this, function0, mutableState, mutableState2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1398getLambda8$app_release(), composer, 805306368, 506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

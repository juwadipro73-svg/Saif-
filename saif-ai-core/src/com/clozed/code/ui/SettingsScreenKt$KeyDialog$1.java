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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$KeyDialog$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $key$delegate;
    final /* synthetic */ Function1<String, Unit> $onSave;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$KeyDialog$1(Function1<? super String, Unit> function1, MutableState<String> mutableState) {
        this.$onSave = function1;
        this.$key$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, MutableState mutableState) {
        String KeyDialog$lambda$74;
        KeyDialog$lambda$74 = SettingsScreenKt.KeyDialog$lambda$74(mutableState);
        function1.invoke(KeyDialog$lambda$74);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String KeyDialog$lambda$74;
        ComposerKt.sourceInformation(composer, "C497@22713L15,497@22664L82:SettingsScreen.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1714715790, i, -1, "com.clozed.code.ui.KeyDialog.<anonymous> (SettingsScreen.kt:497)");
        }
        KeyDialog$lambda$74 = SettingsScreenKt.KeyDialog$lambda$74(this.$key$delegate);
        boolean z = !StringsKt.isBlank(KeyDialog$lambda$74);
        composer.startReplaceGroup(-774005906);
        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
        boolean changed = composer.changed(this.$onSave);
        final Function1<String, Unit> function1 = this.$onSave;
        final MutableState<String> mutableState = this.$key$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SettingsScreenKt$KeyDialog$1.invoke$lambda$1$lambda$0(Function1.this, mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1473getLambda16$app_release(), composer, 805306368, 506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

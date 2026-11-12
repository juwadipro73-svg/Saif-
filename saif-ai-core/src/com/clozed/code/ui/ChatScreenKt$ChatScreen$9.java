package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.clozed.code.AppViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$ChatScreen$9 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $confirmStop$delegate;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$9(AppViewModel appViewModel, MutableState<Boolean> mutableState, ColorScheme colorScheme) {
        this.$vm = appViewModel;
        this.$confirmStop$delegate = mutableState;
        this.$cs = colorScheme;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel, MutableState mutableState) {
        ChatScreenKt.ChatScreen$lambda$17(mutableState, false);
        appViewModel.interrupt();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C336@17459L39,336@17500L39,336@17438L101:ChatScreen.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(978964588, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous> (ChatScreen.kt:336)");
        }
        composer.startReplaceGroup(926322833);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm);
        final AppViewModel appViewModel = this.$vm;
        final MutableState<Boolean> mutableState = this.$confirmStop$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$9$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ChatScreenKt$ChatScreen$9.invoke$lambda$1$lambda$0(AppViewModel.this, mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        final ColorScheme colorScheme = this.$cs;
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-302421719, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$9.2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer2, "C336@17502L35:ChatScreen.kt#qn8u0p");
                if ((i2 & 17) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-302421719, i2, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:336)");
                }
                TextKt.Text-Nvy7gAk("Yes, stop", (Modifier) null, colorScheme.getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 6, 0, 262138);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

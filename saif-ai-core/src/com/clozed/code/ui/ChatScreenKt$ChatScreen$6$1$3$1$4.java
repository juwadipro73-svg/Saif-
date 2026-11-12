package com.clozed.code.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class ChatScreenKt$ChatScreen$6$1$3$1$4 implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $confirmStop$delegate;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<Boolean> $follow$delegate;
    final /* synthetic */ MutableState<List<String>> $images$delegate;
    final /* synthetic */ MutableState<String> $input$delegate;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$6$1$3$1$4(ColorScheme colorScheme, MutableState<String> mutableState, AppViewModel appViewModel, MutableState<Boolean> mutableState2, MutableState<List<String>> mutableState3, MutableState<Boolean> mutableState4) {
        this.$cs = colorScheme;
        this.$input$delegate = mutableState;
        this.$vm = appViewModel;
        this.$confirmStop$delegate = mutableState2;
        this.$images$delegate = mutableState3;
        this.$follow$delegate = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
        invoke(bool.booleanValue(), composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Composer composer, int i) {
        int i2;
        String ChatScreen$lambda$4;
        List ChatScreen$lambda$19;
        ComposerKt.sourceInformation(composer, "C:ChatScreen.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-929179348, i2, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:242)");
            }
            boolean z2 = true;
            if (z) {
                composer.startReplaceGroup(-1894876588);
                ComposerKt.sourceInformation(composer, "246@12548L71,245@12460L22,248@12724L73,244@12396L401");
                final long j = this.$cs.getOnError-0d7_KjU();
                IconButtonColors iconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors-ro_MJ88(this.$cs.getError-0d7_KjU(), j, 0L, 0L, composer, IconButtonDefaults.$stable << 12, 12);
                Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(48));
                composer.startReplaceGroup(1324352668);
                ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                final MutableState<Boolean> mutableState = this.$confirmStop$delegate;
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$1$4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$1$lambda$0;
                            invoke$lambda$1$lambda$0 = ChatScreenKt$ChatScreen$6$1$3$1$4.invoke$lambda$1$lambda$0(mutableState);
                            return invoke$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                IconButtonKt.FilledIconButton((Function0) rememberedValue, modifier, false, (Shape) null, iconButtonColors, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1156547801, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$1$4.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C248@12726L69:ChatScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1156547801, i3, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:248)");
                        }
                        BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(14)), j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(3))), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 1572918, 44);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1894340319);
                ComposerKt.sourceInformation(composer, "255@13288L349,251@12931L202,250@12867L923");
                ChatScreen$lambda$4 = ChatScreenKt.ChatScreen$lambda$4(this.$input$delegate);
                if (StringsKt.isBlank(ChatScreen$lambda$4)) {
                    ChatScreen$lambda$19 = ChatScreenKt.ChatScreen$lambda$19(this.$images$delegate);
                    if (ChatScreen$lambda$19.isEmpty()) {
                        z2 = false;
                    }
                }
                IconButtonColors iconButtonColors2 = IconButtonDefaults.INSTANCE.filledIconButtonColors-ro_MJ88(this.$cs.getPrimary-0d7_KjU(), this.$cs.getOnPrimary-0d7_KjU(), this.$cs.getSurfaceContainerHighest-0d7_KjU(), Color.copy-wmQWz5c$default(this.$cs.getOnSurface-0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer, IconButtonDefaults.$stable << 12, 0);
                Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(48));
                composer.startReplaceGroup(1324367920);
                ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                boolean changed = composer.changed(this.$input$delegate) | composer.changedInstance(this.$vm);
                final AppViewModel appViewModel = this.$vm;
                final MutableState<String> mutableState2 = this.$input$delegate;
                final MutableState<List<String>> mutableState3 = this.$images$delegate;
                final MutableState<Boolean> mutableState4 = this.$follow$delegate;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$1$4$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$3$lambda$2;
                            invoke$lambda$3$lambda$2 = ChatScreenKt$ChatScreen$6$1$3$1$4.invoke$lambda$3$lambda$2(AppViewModel.this, mutableState2, mutableState3, mutableState4);
                            return invoke$lambda$3$lambda$2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                IconButtonKt.FilledIconButton((Function0) rememberedValue2, modifier2, z2, (Shape) null, iconButtonColors2, (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1411getLambda4$app_release(), composer, 1572912, 40);
                composer.endReplaceGroup();
            }
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
        ChatScreenKt.ChatScreen$lambda$17(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r0.isEmpty() == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit invoke$lambda$3$lambda$2(com.clozed.code.AppViewModel r1, androidx.compose.runtime.MutableState r2, androidx.compose.runtime.MutableState r3, androidx.compose.runtime.MutableState r4) {
        /*
            java.lang.String r0 = com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$4(r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L18
            java.util.List r0 = com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$19(r3)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L33
        L18:
            r0 = 1
            com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$14(r4, r0)
            java.lang.String r4 = com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$4(r2)
            java.util.List r0 = com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$19(r3)
            r1.send(r4, r0)
            java.lang.String r1 = ""
            com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$5(r2, r1)
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            com.clozed.code.ui.ChatScreenKt.access$ChatScreen$lambda$20(r3, r1)
        L33:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$1$4.invoke$lambda$3$lambda$2(com.clozed.code.AppViewModel, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState):kotlin.Unit");
    }
}

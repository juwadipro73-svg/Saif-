package com.clozed.code.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatExtras.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatExtrasKt$PortDialog$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $source$delegate;
    final /* synthetic */ MutableState<String> $what$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatExtrasKt$PortDialog$3(MutableState<String> mutableState, MutableState<String> mutableState2) {
        this.$source$delegate = mutableState;
        this.$what$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String PortDialog$lambda$16;
        String PortDialog$lambda$19;
        ComposerKt.sourceInformation(composer, "C89@4392L15,89@4415L13,89@4373L56:ChatExtras.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1998984061, i, -1, "com.clozed.code.ui.PortDialog.<anonymous> (ChatExtras.kt:89)");
        }
        PortDialog$lambda$16 = ChatExtrasKt.PortDialog$lambda$16(this.$source$delegate);
        composer.startReplaceGroup(-1163161186);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
        final MutableState<String> mutableState = this.$source$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.clozed.code.ui.ChatExtrasKt$PortDialog$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ChatExtrasKt$PortDialog$3.invoke$lambda$1$lambda$0(mutableState, (String) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function1 function1 = (Function1) rememberedValue;
        composer.endReplaceGroup();
        PortDialog$lambda$19 = ChatExtrasKt.PortDialog$lambda$19(this.$what$delegate);
        composer.startReplaceGroup(-1163160452);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
        final MutableState<String> mutableState2 = this.$what$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.clozed.code.ui.ChatExtrasKt$PortDialog$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ChatExtrasKt$PortDialog$3.invoke$lambda$3$lambda$2(mutableState2, (String) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        ChatExtrasKt.PortFields(PortDialog$lambda$16, function1, PortDialog$lambda$19, (Function1) rememberedValue2, composer, 3120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

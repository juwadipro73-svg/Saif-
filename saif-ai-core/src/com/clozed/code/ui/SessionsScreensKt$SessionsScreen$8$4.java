package com.clozed.code.ui;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$8$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $title$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$8$4(MutableState<String> mutableState) {
        this.$title$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, String it) {
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
        String SessionsScreen$lambda$70$lambda$66;
        ComposerKt.sourceInformation(composer, "C375@17602L14,375@17577L95:SessionsScreens.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1719030034, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:375)");
        }
        SessionsScreen$lambda$70$lambda$66 = SessionsScreensKt.SessionsScreen$lambda$70$lambda$66(this.$title$delegate);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(1623221020);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        boolean changed = composer.changed(this.$title$delegate);
        final MutableState<String> mutableState = this.$title$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$8$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$8$4.invoke$lambda$1$lambda$0(mutableState, (String) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        OutlinedTextFieldKt.OutlinedTextField(SessionsScreen$lambda$70$lambda$66, (Function1) rememberedValue, fillMaxWidth$default, false, false, (TextStyle) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 384, 12582912, 0, 8257528);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

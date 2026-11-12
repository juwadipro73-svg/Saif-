package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class PermissionsUiKt$PermissionsDialog$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ PermRow $next;
    final /* synthetic */ Function0<Unit> $onDismiss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionsUiKt$PermissionsDialog$1(PermRow permRow, Function0<Unit> function0) {
        this.$next = permRow;
        this.$onDismiss = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(PermRow permRow, Function0 function0) {
        if (permRow != null) {
            permRow.getGrant().invoke();
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C182@8369L51,182@8422L52,182@8348L126:PermissionsUi.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1734620591, i, -1, "com.clozed.code.ui.PermissionsDialog.<anonymous> (PermissionsUi.kt:182)");
        }
        composer.startReplaceGroup(1611096887);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changed = composer.changed(this.$next) | composer.changed(this.$onDismiss);
        final PermRow permRow = this.$next;
        final Function0<Unit> function0 = this.$onDismiss;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$PermissionsDialog$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = PermissionsUiKt$PermissionsDialog$1.invoke$lambda$1$lambda$0(PermRow.this, function0);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        final PermRow permRow2 = this.$next;
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(874792372, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$PermissionsDialog$1.2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer2, "C182@8424L48:PermissionsUi.kt#qn8u0p");
                if ((i2 & 17) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(874792372, i2, -1, "com.clozed.code.ui.PermissionsDialog.<anonymous>.<anonymous> (PermissionsUi.kt:182)");
                }
                TextKt.Text-Nvy7gAk(PermRow.this != null ? "Allow next" : "Done", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 262142);
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

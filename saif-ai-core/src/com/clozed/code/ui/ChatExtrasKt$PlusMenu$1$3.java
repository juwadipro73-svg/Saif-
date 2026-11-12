package com.clozed.code.ui;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatExtras.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatExtrasKt$PlusMenu$1$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $onAttach;
    final /* synthetic */ Function0<Unit> $onCopyProject;
    final /* synthetic */ MutableState<Boolean> $open$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatExtrasKt$PlusMenu$1$3(Function0<Unit> function0, Function0<Unit> function02, MutableState<Boolean> mutableState) {
        this.$onAttach = function0;
        this.$onCopyProject = function02;
        this.$open$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0, MutableState mutableState) {
        ChatExtrasKt.PlusMenu$lambda$2(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C44@2108L28,44@2048L89,45@2224L33,45@2150L108:ChatExtras.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2137237224, i, -1, "com.clozed.code.ui.PlusMenu.<anonymous>.<anonymous> (ChatExtras.kt:44)");
        }
        Function2<Composer, Integer, Unit> m1392getLambda2$app_release = ComposableSingletons$ChatExtrasKt.INSTANCE.m1392getLambda2$app_release();
        composer.startReplaceGroup(1727391322);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
        boolean changed = composer.changed(this.$onAttach);
        final Function0<Unit> function0 = this.$onAttach;
        final MutableState<Boolean> mutableState = this.$open$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$PlusMenu$1$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ChatExtrasKt$PlusMenu$1$3.invoke$lambda$1$lambda$0(Function0.this, mutableState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        AndroidMenu_androidKt.DropdownMenuItem(m1392getLambda2$app_release, (Function0) rememberedValue, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
        Function2<Composer, Integer, Unit> m1393getLambda3$app_release = ComposableSingletons$ChatExtrasKt.INSTANCE.m1393getLambda3$app_release();
        composer.startReplaceGroup(1727395039);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
        boolean changed2 = composer.changed(this.$onCopyProject);
        final Function0<Unit> function02 = this.$onCopyProject;
        final MutableState<Boolean> mutableState2 = this.$open$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$PlusMenu$1$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ChatExtrasKt$PlusMenu$1$3.invoke$lambda$3$lambda$2(Function0.this, mutableState2);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        AndroidMenu_androidKt.DropdownMenuItem(m1393getLambda3$app_release, (Function0) rememberedValue2, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(Function0 function0, MutableState mutableState) {
        ChatExtrasKt.PlusMenu$lambda$2(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }
}

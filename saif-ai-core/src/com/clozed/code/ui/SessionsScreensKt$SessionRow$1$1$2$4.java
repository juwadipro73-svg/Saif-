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

/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class SessionsScreensKt$SessionRow$1$1$2$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $menu$delegate;
    final /* synthetic */ Function0<Unit> $onDelete;
    final /* synthetic */ Function0<Unit> $onRename;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionRow$1$1$2$4(Function0<Unit> function0, Function0<Unit> function02, MutableState<Boolean> mutableState) {
        this.$onRename = function0;
        this.$onDelete = function02;
        this.$menu$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C450@21346L28,448@21193L204,454@21573L28,452@21418L206:SessionsScreens.kt#qn8u0p");
        if ((i & 17) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033255357, i, -1, "com.clozed.code.ui.SessionRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:448)");
            }
            Function2<Composer, Integer, Unit> m1455getLambda30$app_release = ComposableSingletons$SessionsScreensKt.INSTANCE.m1455getLambda30$app_release();
            composer.startReplaceGroup(-948167325);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changed = composer.changed(this.$onRename);
            final Function0<Unit> function0 = this.$onRename;
            final MutableState<Boolean> mutableState = this.$menu$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionRow$1$1$2$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionRow$1$1$2$4.invoke$lambda$1$lambda$0(Function0.this, mutableState);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            AndroidMenu_androidKt.DropdownMenuItem(m1455getLambda30$app_release, (Function0) rememberedValue, (Modifier) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1456getLambda31$app_release(), (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 3078, 500);
            Function2<Composer, Integer, Unit> m1457getLambda32$app_release = ComposableSingletons$SessionsScreensKt.INSTANCE.m1457getLambda32$app_release();
            composer.startReplaceGroup(-948160061);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changed2 = composer.changed(this.$onDelete);
            final Function0<Unit> function02 = this.$onDelete;
            final MutableState<Boolean> mutableState2 = this.$menu$delegate;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionRow$1$1$2$4$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2;
                        invoke$lambda$3$lambda$2 = SessionsScreensKt$SessionRow$1$1$2$4.invoke$lambda$3$lambda$2(Function0.this, mutableState2);
                        return invoke$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            AndroidMenu_androidKt.DropdownMenuItem(m1457getLambda32$app_release, (Function0) rememberedValue2, (Modifier) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1458getLambda33$app_release(), (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 3078, 500);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0, MutableState mutableState) {
        SessionsScreensKt.SessionRow$lambda$78(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(Function0 function0, MutableState mutableState) {
        SessionsScreensKt.SessionRow$lambda$78(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }
}

package com.clozed.code.ui;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.clozed.code.AppViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$3$1$1$2 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$3$1$1$2(AppViewModel appViewModel) {
        this.$vm = appViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel) {
        appViewModel.openSettings();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C277@12887L21,277@12877L31:SessionsScreens.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1048680197, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:277)");
        }
        composer.startReplaceGroup(-153450175);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$vm);
        final AppViewModel appViewModel = this.$vm;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$3$1$1$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$3$1$1$2.invoke$lambda$1$lambda$0(AppViewModel.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SessionsScreensKt.KeyBanner((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

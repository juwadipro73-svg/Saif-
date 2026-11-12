package com.clozed.code;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.clozed.code.ui.PermissionsUiKt;
import com.clozed.code.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class MainActivity$onCreate$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainActivity$onCreate$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$6$lambda$5$lambda$2(boolean z, Resources it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$6$lambda$5$lambda$3(boolean z, Resources it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AppViewModel vm;
        AppViewModel vm2;
        final boolean isSystemInDarkTheme;
        ComposerKt.sourceInformation(composer, "C97@3780L16,98@3840L16,106@4146L530,106@4123L553,119@4748L203,119@4690L261:MainActivity.kt#shl86d");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1019440605, i, -1, "com.clozed.code.MainActivity.onCreate.<anonymous> (MainActivity.kt:97)");
            }
            vm = this.this$0.getVm();
            State collectAsState = SnapshotStateKt.collectAsState(vm.getThemeMode(), (CoroutineContext) null, composer, 0, 1);
            vm2 = this.this$0.getVm();
            State collectAsState2 = SnapshotStateKt.collectAsState(vm2.getDynamicColor(), (CoroutineContext) null, composer, 0, 1);
            String invoke$lambda$0 = invoke$lambda$0(collectAsState);
            composer.startReplaceGroup(-1071929706);
            ComposerKt.sourceInformation(composer, "102@3982L21");
            if (Intrinsics.areEqual(invoke$lambda$0, "dark")) {
                isSystemInDarkTheme = true;
            } else {
                isSystemInDarkTheme = Intrinsics.areEqual(invoke$lambda$0, "light") ? false : DarkThemeKt.isSystemInDarkTheme(composer, 0);
            }
            composer.endReplaceGroup();
            Boolean valueOf = Boolean.valueOf(isSystemInDarkTheme);
            composer.startReplaceGroup(-1071920801);
            ComposerKt.sourceInformation(composer, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(this.this$0) | composer.changed(isSystemInDarkTheme);
            final MainActivity mainActivity = this.this$0;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.clozed.code.MainActivity$onCreate$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult invoke$lambda$6$lambda$5;
                        invoke$lambda$6$lambda$5 = MainActivity$onCreate$1.invoke$lambda$6$lambda$5(MainActivity.this, isSystemInDarkTheme, (DisposableEffectScope) obj);
                        return invoke$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            EffectsKt.DisposableEffect(valueOf, (Function1) rememberedValue, composer, 0);
            boolean invoke$lambda$1 = invoke$lambda$1(collectAsState2);
            final MainActivity mainActivity2 = this.this$0;
            ThemeKt.ClozedCodeTheme(isSystemInDarkTheme, invoke$lambda$1, ComposableLambdaKt.rememberComposableLambda(-595309087, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.MainActivity$onCreate$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C120@4820L11,120@4844L93,120@4766L171:MainActivity.kt#shl86d");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-595309087, i2, -1, "com.clozed.code.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:120)");
                        }
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        long j = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground-0d7_KjU();
                        final MainActivity mainActivity3 = MainActivity.this;
                        SurfaceKt.Surface-T9BRK9s(fillMaxSize$default, (Shape) null, j, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-132456964, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.MainActivity.onCreate.1.2.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i3) {
                                AppViewModel vm3;
                                ComposerKt.sourceInformation(composer3, "C121@4866L11,122@4898L21:MainActivity.kt#shl86d");
                                if ((i3 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-132456964, i3, -1, "com.clozed.code.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:121)");
                                    }
                                    vm3 = MainActivity.this.getVm();
                                    MainActivityKt.AppRoot(vm3, composer3, 0);
                                    PermissionsUiKt.PermissionsFirstRun(composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54), composer2, 12582918, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composer, 54), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$6$lambda$5(MainActivity mainActivity, final boolean z, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        EdgeToEdge.enable(mainActivity, SystemBarStyle.Companion.auto(0, 0, new Function1() { // from class: com.clozed.code.MainActivity$onCreate$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$6$lambda$5$lambda$2;
                invoke$lambda$6$lambda$5$lambda$2 = MainActivity$onCreate$1.invoke$lambda$6$lambda$5$lambda$2(z, (Resources) obj);
                return Boolean.valueOf(invoke$lambda$6$lambda$5$lambda$2);
            }
        }), SystemBarStyle.Companion.auto(Color.argb(230, 255, 255, 255), Color.argb(128, 27, 27, 27), new Function1() { // from class: com.clozed.code.MainActivity$onCreate$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$6$lambda$5$lambda$3;
                invoke$lambda$6$lambda$5$lambda$3 = MainActivity$onCreate$1.invoke$lambda$6$lambda$5$lambda$3(z, (Resources) obj);
                return Boolean.valueOf(invoke$lambda$6$lambda$5$lambda$3);
            }
        }));
        return new DisposableEffectResult() { // from class: com.clozed.code.MainActivity$onCreate$1$invoke$lambda$6$lambda$5$$inlined$onDispose$1
            public void dispose() {
            }
        };
    }

    private static final String invoke$lambda$0(State<String> state) {
        return (String) state.getValue();
    }

    private static final boolean invoke$lambda$1(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }
}

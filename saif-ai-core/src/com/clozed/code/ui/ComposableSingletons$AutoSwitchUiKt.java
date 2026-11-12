package com.clozed.code.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoSwitchUi.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ComposableSingletons$AutoSwitchUiKt {
    public static final ComposableSingletons$AutoSwitchUiKt INSTANCE = new ComposableSingletons$AutoSwitchUiKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f41lambda1 = ComposableLambdaKt.composableLambdaInstance(-66381524, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C115@5915L12:AutoSwitchUi.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-66381524, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-1.<anonymous> (AutoSwitchUi.kt:115)");
            }
            TextKt.Text-Nvy7gAk("Done", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f42lambda2 = ComposableLambdaKt.composableLambdaInstance(-866454222, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C68@3059L30:AutoSwitchUi.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-866454222, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-2.<anonymous> (AutoSwitchUi.kt:68)");
            }
            IconKt.Icon-ww6aTOc(LockKt.getLock(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f43lambda3 = ComposableLambdaKt.composableLambdaInstance(787769924, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C98@4977L19:AutoSwitchUi.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(787769924, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-3.<anonymous> (AutoSwitchUi.kt:98)");
            }
            TextKt.Text-Nvy7gAk("New API key", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f44lambda4 = ComposableLambdaKt.composableLambdaInstance(-1362230078, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C104@5455L13:AutoSwitchUi.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1362230078, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-4.<anonymous> (AutoSwitchUi.kt:104)");
            }
            TextKt.Text-Nvy7gAk("Paste", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f45lambda5 = ComposableLambdaKt.composableLambdaInstance(-739589024, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C109@5696L51,110@5772L17:AutoSwitchUi.kt#qn8u0p");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-739589024, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-5.<anonymous> (AutoSwitchUi.kt:109)");
                }
                IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), 0L, composer, 432, 8);
                TextKt.Text-Nvy7gAk("  Add key", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f46lambda6 = ComposableLambdaKt.composableLambdaInstance(1059115583, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C165@8836L41:AutoSwitchUi.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1059115583, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-6.<anonymous> (AutoSwitchUi.kt:165)");
            }
            IconKt.Icon-ww6aTOc(KeyboardArrowUpKt.getKeyboardArrowUp(Icons.INSTANCE.getDefault()), "Up", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f47lambda7 = ComposableLambdaKt.composableLambdaInstance(-618403928, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C168@9096L45:AutoSwitchUi.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-618403928, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-7.<anonymous> (AutoSwitchUi.kt:168)");
            }
            IconKt.Icon-ww6aTOc(KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault()), "Down", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f48lambda8 = ComposableLambdaKt.composableLambdaInstance(-1330993135, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C176@9566L51,177@9642L22:AutoSwitchUi.kt#qn8u0p");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1330993135, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-8.<anonymous> (AutoSwitchUi.kt:176)");
                }
                IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), 0L, composer, 432, 8);
                TextKt.Text-Nvy7gAk("  Add fallback", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f49lambda9 = ComposableLambdaKt.composableLambdaInstance(803321734, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C179@9763L25:AutoSwitchUi.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(803321734, i, -1, "com.clozed.code.ui.ComposableSingletons$AutoSwitchUiKt.lambda-9.<anonymous> (AutoSwitchUi.kt:179)");
            }
            TextKt.Text-Nvy7gAk("Limit flags reset", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1381getLambda1$app_release() {
        return f41lambda1;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1382getLambda2$app_release() {
        return f42lambda2;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1383getLambda3$app_release() {
        return f43lambda3;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1384getLambda4$app_release() {
        return f44lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1385getLambda5$app_release() {
        return f45lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1386getLambda6$app_release() {
        return f46lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1387getLambda7$app_release() {
        return f47lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1388getLambda8$app_release() {
        return f48lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1389getLambda9$app_release() {
        return f49lambda9;
    }
}

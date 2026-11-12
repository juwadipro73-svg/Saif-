package com.clozed.code.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.automirrored.filled.ExitToAppKt;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material.icons.filled.WarningKt;
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

/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ComposableSingletons$SettingsScreenKt {
    public static final ComposableSingletons$SettingsScreenKt INSTANCE = new ComposableSingletons$SettingsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f126lambda1 = ComposableLambdaKt.composableLambdaInstance(1995065506, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C104@4846L16:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1995065506, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-1.<anonymous> (SettingsScreen.kt:104)");
            }
            TextKt.Text-Nvy7gAk("Settings", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f137lambda2 = ComposableLambdaKt.composableLambdaInstance(-1890505726, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C106@4968L49:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890505726, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-2.<anonymous> (SettingsScreen.kt:106)");
            }
            IconKt.Icon-ww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f148lambda3 = ComposableLambdaKt.composableLambdaInstance(-1647434139, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C122@5630L37:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1647434139, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-3.<anonymous> (SettingsScreen.kt:122)");
            }
            ComponentsKt.SectionHeader("Providers & API keys", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f149lambda4 = ComposableLambdaKt.composableLambdaInstance(-348500525, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C173@8468L51,174@8544L22:SettingsScreen.kt#qn8u0p");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-348500525, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-4.<anonymous> (SettingsScreen.kt:173)");
                }
                IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), 0L, composer, 432, 8);
                TextKt.Text-Nvy7gAk("  Add provider", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f150lambda5 = ComposableLambdaKt.composableLambdaInstance(114186766, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation(composer, "C177@8710L23:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(114186766, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-5.<anonymous> (SettingsScreen.kt:177)");
            }
            TextKt.Text-Nvy7gAk("Custom endpoint", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f151lambda6 = ComposableLambdaKt.composableLambdaInstance(239546296, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C185@8982L54:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(239546296, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-6.<anonymous> (SettingsScreen.kt:185)");
            }
            ComponentsKt.SectionHeader("Auto-switch (when a limit is reached)", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f152lambda7 = ComposableLambdaKt.composableLambdaInstance(-328425927, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C191@9228L28:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328425927, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-7.<anonymous> (SettingsScreen.kt:191)");
            }
            ComponentsKt.SectionHeader("Permissions", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f153lambda8 = ComposableLambdaKt.composableLambdaInstance(179035166, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C209@9968L27:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(179035166, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-8.<anonymous> (SettingsScreen.kt:209)");
            }
            ComponentsKt.SectionHeader("Appearance", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f154lambda9 = ComposableLambdaKt.composableLambdaInstance(-956909280, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C236@11333L27:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-956909280, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-9.<anonymous> (SettingsScreen.kt:236)");
            }
            ComponentsKt.SectionHeader("Connection", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f127lambda10 = ComposableLambdaKt.composableLambdaInstance(-383572691, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C246@12071L50:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383572691, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-10.<anonymous> (SettingsScreen.kt:246)");
            }
            TextKt.Text-Nvy7gAk(ComponentsKt.hasAllFilesAccess() ? "ON ✓" : "Allow", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f128lambda11 = ComposableLambdaKt.composableLambdaInstance(2104386803, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation(composer, "C258@12628L69,259@12722L20:SettingsScreen.kt#qn8u0p");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2104386803, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-11.<anonymous> (SettingsScreen.kt:258)");
                }
                IconKt.Icon-ww6aTOc(ExitToAppKt.getExitToApp(Icons.AutoMirrored.Filled.INSTANCE), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), 0L, composer, 432, 8);
                TextKt.Text-Nvy7gAk("  Disconnect", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f129lambda12 = ComposableLambdaKt.composableLambdaInstance(-2092853726, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C265@12887L22:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2092853726, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-12.<anonymous> (SettingsScreen.kt:265)");
            }
            ComponentsKt.SectionHeader("About", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f130lambda13 = ComposableLambdaKt.composableLambdaInstance(-2047118137, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C444@20310L12:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2047118137, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-13.<anonymous> (SettingsScreen.kt:444)");
            }
            TextKt.Text-Nvy7gAk("Keys", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f131lambda14 = ComposableLambdaKt.composableLambdaInstance(-1221556610, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C467@21301L14:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1221556610, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-14.<anonymous> (SettingsScreen.kt:467)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f132lambda15 = ComposableLambdaKt.composableLambdaInstance(-913589894, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C463@21020L33:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913589894, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-15.<anonymous> (SettingsScreen.kt:463)");
            }
            IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f133lambda16 = ComposableLambdaKt.composableLambdaInstance(1740362635, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C497@22732L12:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1740362635, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-16.<anonymous> (SettingsScreen.kt:497)");
            }
            TextKt.Text-Nvy7gAk("Save", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-17, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f134lambda17 = ComposableLambdaKt.composableLambdaInstance(18359949, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C498@22810L14:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18359949, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-17.<anonymous> (SettingsScreen.kt:498)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-18, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f135lambda18 = ComposableLambdaKt.composableLambdaInstance(1279195409, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C478@21650L30:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1279195409, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-18.<anonymous> (SettingsScreen.kt:478)");
            }
            IconKt.Icon-ww6aTOc(LockKt.getLock(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-19, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f136lambda19 = ComposableLambdaKt.composableLambdaInstance(1584827043, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-19$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C484@21952L15:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584827043, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-19.<anonymous> (SettingsScreen.kt:484)");
            }
            TextKt.Text-Nvy7gAk("API key", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-20, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f138lambda20 = ComposableLambdaKt.composableLambdaInstance(-330257247, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-20$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C490@22378L13:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-330257247, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-20.<anonymous> (SettingsScreen.kt:490)");
            }
            TextKt.Text-Nvy7gAk("Paste", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-21, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f139lambda21 = ComposableLambdaKt.composableLambdaInstance(-352462286, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-21$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C579@27925L14:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-352462286, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-21.<anonymous> (SettingsScreen.kt:579)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-22, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f140lambda22 = ComposableLambdaKt.composableLambdaInstance(1415979280, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-22$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C528@24379L14:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1415979280, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-22.<anonymous> (SettingsScreen.kt:528)");
            }
            TextKt.Text-Nvy7gAk("Ollama", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-23, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f141lambda23 = ComposableLambdaKt.composableLambdaInstance(1891328135, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-23$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C529@24532L17:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1891328135, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-23.<anonymous> (SettingsScreen.kt:529)");
            }
            TextKt.Text-Nvy7gAk("LM Studio", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-24, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f142lambda24 = ComposableLambdaKt.composableLambdaInstance(-966873400, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-24$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C532@24677L12:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-966873400, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-24.<anonymous> (SettingsScreen.kt:532)");
            }
            TextKt.Text-Nvy7gAk("Name", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-25, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f143lambda25 = ComposableLambdaKt.composableLambdaInstance(-262619777, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-25$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C533@24817L16:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-262619777, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-25.<anonymous> (SettingsScreen.kt:533)");
            }
            TextKt.Text-Nvy7gAk("Base URL", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-26, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f144lambda26 = ComposableLambdaKt.composableLambdaInstance(1209658816, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-26$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C534@24942L35:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1209658816, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-26.<anonymous> (SettingsScreen.kt:534)");
            }
            TextKt.Text-Nvy7gAk("Model IDs (comma separated)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-27, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f145lambda27 = ComposableLambdaKt.composableLambdaInstance(-1454362810, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-27$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C543@25651L13:SettingsScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1454362810, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-27.<anonymous> (SettingsScreen.kt:543)");
            }
            TextKt.Text-Nvy7gAk("Paste", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-28, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f146lambda28 = ComposableLambdaKt.composableLambdaInstance(-1441162299, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-28$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C568@27340L25:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1441162299, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-28.<anonymous> (SettingsScreen.kt:568)");
            }
            TextKt.Text-Nvy7gAk("OpenAI-compatible", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-29, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f147lambda29 = ComposableLambdaKt.composableLambdaInstance(2132867324, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SettingsScreenKt$lambda-29$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C569@27509L17:SettingsScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2132867324, i, -1, "com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.lambda-29.<anonymous> (SettingsScreen.kt:569)");
            }
            TextKt.Text-Nvy7gAk("Anthropic", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1466getLambda1$app_release() {
        return f126lambda1;
    }

    /* renamed from: getLambda-10$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1467getLambda10$app_release() {
        return f127lambda10;
    }

    /* renamed from: getLambda-11$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1468getLambda11$app_release() {
        return f128lambda11;
    }

    /* renamed from: getLambda-12$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1469getLambda12$app_release() {
        return f129lambda12;
    }

    /* renamed from: getLambda-13$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1470getLambda13$app_release() {
        return f130lambda13;
    }

    /* renamed from: getLambda-14$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1471getLambda14$app_release() {
        return f131lambda14;
    }

    /* renamed from: getLambda-15$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1472getLambda15$app_release() {
        return f132lambda15;
    }

    /* renamed from: getLambda-16$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1473getLambda16$app_release() {
        return f133lambda16;
    }

    /* renamed from: getLambda-17$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1474getLambda17$app_release() {
        return f134lambda17;
    }

    /* renamed from: getLambda-18$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1475getLambda18$app_release() {
        return f135lambda18;
    }

    /* renamed from: getLambda-19$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1476getLambda19$app_release() {
        return f136lambda19;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1477getLambda2$app_release() {
        return f137lambda2;
    }

    /* renamed from: getLambda-20$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1478getLambda20$app_release() {
        return f138lambda20;
    }

    /* renamed from: getLambda-21$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1479getLambda21$app_release() {
        return f139lambda21;
    }

    /* renamed from: getLambda-22$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1480getLambda22$app_release() {
        return f140lambda22;
    }

    /* renamed from: getLambda-23$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1481getLambda23$app_release() {
        return f141lambda23;
    }

    /* renamed from: getLambda-24$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1482getLambda24$app_release() {
        return f142lambda24;
    }

    /* renamed from: getLambda-25$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1483getLambda25$app_release() {
        return f143lambda25;
    }

    /* renamed from: getLambda-26$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1484getLambda26$app_release() {
        return f144lambda26;
    }

    /* renamed from: getLambda-27$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1485getLambda27$app_release() {
        return f145lambda27;
    }

    /* renamed from: getLambda-28$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1486getLambda28$app_release() {
        return f146lambda28;
    }

    /* renamed from: getLambda-29$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1487getLambda29$app_release() {
        return f147lambda29;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1488getLambda3$app_release() {
        return f148lambda3;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1489getLambda4$app_release() {
        return f149lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1490getLambda5$app_release() {
        return f150lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1491getLambda6$app_release() {
        return f151lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1492getLambda7$app_release() {
        return f152lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1493getLambda8$app_release() {
        return f153lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1494getLambda9$app_release() {
        return f154lambda9;
    }
}

package com.clozed.code.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ComposableSingletons$SessionsScreensKt {
    public static final ComposableSingletons$SessionsScreensKt INSTANCE = new ComposableSingletons$SessionsScreensKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f92lambda1 = ComposableLambdaKt.composableLambdaInstance(315073566, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C123@5915L17:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(315073566, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-1.<anonymous> (SessionsScreens.kt:123)");
            }
            TextKt.Text-Nvy7gAk("On-device", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f103lambda2 = ComposableLambdaKt.composableLambdaInstance(1737500615, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C127@6109L21:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1737500615, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-2.<anonymous> (SessionsScreens.kt:127)");
            }
            TextKt.Text-Nvy7gAk("Remote server", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f114lambda3 = ComposableLambdaKt.composableLambdaInstance(-1342265344, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C137@6570L22:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1342265344, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-3.<anonymous> (SessionsScreens.kt:137)");
            }
            TextKt.Text-Nvy7gAk("Project folder", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f120lambda4 = ComposableLambdaKt.composableLambdaInstance(-542690815, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C138@6628L42:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-542690815, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-4.<anonymous> (SessionsScreens.kt:138)");
            }
            TextKt.Text-Nvy7gAk("/storage/emulated/0/ClozedProjects", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f121lambda5 = ComposableLambdaKt.composableLambdaInstance(-1211341229, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C139@6709L54:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1211341229, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-5.<anonymous> (SessionsScreens.kt:139)");
            }
            TextKt.Text-Nvy7gAk("Leave empty to use the app's private workspace", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f122lambda6 = ComposableLambdaKt.composableLambdaInstance(1084553559, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C160@7786L18:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1084553559, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-6.<anonymous> (SessionsScreens.kt:160)");
            }
            TextKt.Text-Nvy7gAk("Server URL", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f123lambda7 = ComposableLambdaKt.composableLambdaInstance(480625280, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C166@8095L39:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(480625280, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-7.<anonymous> (SessionsScreens.kt:166)");
            }
            TextKt.Text-Nvy7gAk("Password (if set on the server)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f124lambda8 = ComposableLambdaKt.composableLambdaInstance(2079774338, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C168@8241L30:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2079774338, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-8.<anonymous> (SessionsScreens.kt:168)");
            }
            IconKt.Icon-ww6aTOc(LockKt.getLock(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f125lambda9 = ComposableLambdaKt.composableLambdaInstance(1465445431, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C193@9632L20:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1465445431, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-9.<anonymous> (SessionsScreens.kt:193)");
            }
            TextKt.Text-Nvy7gAk("Copy command", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f93lambda10 = ComposableLambdaKt.composableLambdaInstance(-1585086503, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C247@11518L210:SessionsScreens.kt#qn8u0p");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1585086503, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-10.<anonymous> (SessionsScreens.kt:247)");
                }
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
                ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier = Modifier.Companion;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composer2 = Updater.constructor-impl(composer);
                Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1541493322, "C248@11649L16,249@11690L16:SessionsScreens.kt#qn8u0p");
                LogoMotionKt.m1505LogoBadgeorJrPs(Dp.m826constructorimpl(30), null, composer, 6, 2);
                TextKt.Text-Nvy7gAk("Sessions", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f94lambda11 = ComposableLambdaKt.composableLambdaInstance(271849062, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C253@11845L38:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(271849062, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-11.<anonymous> (SessionsScreens.kt:253)");
            }
            IconKt.Icon-ww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), "Refresh", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f95lambda12 = ComposableLambdaKt.composableLambdaInstance(-1046899825, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C254@11952L40:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1046899825, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-12.<anonymous> (SessionsScreens.kt:254)");
            }
            IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f96lambda13 = ComposableLambdaKt.composableLambdaInstance(1859479287, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C267@12527L19:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1859479287, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-13.<anonymous> (SessionsScreens.kt:267)");
            }
            TextKt.Text-Nvy7gAk("New session", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f97lambda14 = ComposableLambdaKt.composableLambdaInstance(-242974216, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C266@12469L29:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-242974216, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-14.<anonymous> (SessionsScreens.kt:266)");
            }
            IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f98lambda15 = ComposableLambdaKt.composableLambdaInstance(751033874, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C363@17157L13:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751033874, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-15.<anonymous> (SessionsScreens.kt:363)");
            }
            TextKt.Text-Nvy7gAk("Start", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f99lambda16 = ComposableLambdaKt.composableLambdaInstance(-341601328, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C365@17262L14:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-341601328, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-16.<anonymous> (SessionsScreens.kt:365)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-17, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f100lambda17 = ComposableLambdaKt.composableLambdaInstance(-975217237, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C329@15220L19:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975217237, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-17.<anonymous> (SessionsScreens.kt:329)");
            }
            TextKt.Text-Nvy7gAk("New session", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-18, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f101lambda18 = ComposableLambdaKt.composableLambdaInstance(850421575, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C336@15629L29:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(850421575, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-18.<anonymous> (SessionsScreens.kt:336)");
            }
            TextKt.Text-Nvy7gAk("Choose project folder", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-19, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f102lambda19 = ComposableLambdaKt.composableLambdaInstance(-1460183444, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-19$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation(composer, "C338@15876L28:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1460183444, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-19.<anonymous> (SessionsScreens.kt:338)");
            }
            TextKt.Text-Nvy7gAk("Grant storage access", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-20, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f104lambda20 = ComposableLambdaKt.composableLambdaInstance(1459924986, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-20$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C343@16114L33:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1459924986, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-20.<anonymous> (SessionsScreens.kt:343)");
            }
            TextKt.Text-Nvy7gAk("Project folder (optional)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-21, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f105lambda21 = ComposableLambdaKt.composableLambdaInstance(704193315, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-21$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C348@16414L20:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(704193315, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-21.<anonymous> (SessionsScreens.kt:348)");
            }
            TextKt.Text-Nvy7gAk("Project name", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-22, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f106lambda22 = ComposableLambdaKt.composableLambdaInstance(-631626634, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-22$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C376@17781L12:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-631626634, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-22.<anonymous> (SessionsScreens.kt:376)");
            }
            TextKt.Text-Nvy7gAk("Save", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-23, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f107lambda23 = ComposableLambdaKt.composableLambdaInstance(-1321458124, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-23$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C377@17873L14:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1321458124, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-23.<anonymous> (SessionsScreens.kt:377)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-24, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f108lambda24 = ComposableLambdaKt.composableLambdaInstance(-1029198544, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-24$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C373@17482L30:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1029198544, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-24.<anonymous> (SessionsScreens.kt:373)");
            }
            IconKt.Icon-ww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-25, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f109lambda25 = ComposableLambdaKt.composableLambdaInstance(-1374114289, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-25$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C374@17538L14:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1374114289, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-25.<anonymous> (SessionsScreens.kt:374)");
            }
            TextKt.Text-Nvy7gAk("Rename", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-26, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f110lambda26 = ComposableLambdaKt.composableLambdaInstance(600704237, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-26$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C389@18323L11,389@18286L55:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(600704237, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-26.<anonymous> (SessionsScreens.kt:389)");
            }
            TextKt.Text-Nvy7gAk("Delete", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-27, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f111lambda27 = ComposableLambdaKt.composableLambdaInstance(-902394069, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-27$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C392@18449L14:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-902394069, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-27.<anonymous> (SessionsScreens.kt:392)");
            }
            TextKt.Text-Nvy7gAk("Cancel", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-28, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f112lambda28 = ComposableLambdaKt.composableLambdaInstance(786188071, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-28$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C384@18029L32:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(786188071, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-28.<anonymous> (SessionsScreens.kt:384)");
            }
            IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-29, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f113lambda29 = ComposableLambdaKt.composableLambdaInstance(34638918, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-29$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C385@18087L23:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(34638918, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-29.<anonymous> (SessionsScreens.kt:385)");
            }
            TextKt.Text-Nvy7gAk("Delete session?", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-30, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f115lambda30 = ComposableLambdaKt.composableLambdaInstance(-705176045, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-30$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C449@21244L14:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-705176045, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-30.<anonymous> (SessionsScreens.kt:449)");
            }
            TextKt.Text-Nvy7gAk("Rename", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-31, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f116lambda31 = ComposableLambdaKt.composableLambdaInstance(-1121532266, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-31$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C449@21278L30:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1121532266, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-31.<anonymous> (SessionsScreens.kt:449)");
            }
            IconKt.Icon-ww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-32, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f117lambda32 = ComposableLambdaKt.composableLambdaInstance(-1328135350, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-32$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C453@21469L14:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1328135350, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-32.<anonymous> (SessionsScreens.kt:453)");
            }
            TextKt.Text-Nvy7gAk("Delete", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-33, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f118lambda33 = ComposableLambdaKt.composableLambdaInstance(-2014505203, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-33$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C453@21503L32:SessionsScreens.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2014505203, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-33.<anonymous> (SessionsScreens.kt:453)");
            }
            IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-34, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f119lambda34 = ComposableLambdaKt.composableLambdaInstance(517705179, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$SessionsScreensKt$lambda-34$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope Card, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Card, "$this$Card");
            ComposerKt.sourceInformation(composer, "C472@22031L567:SessionsScreens.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(517705179, i, -1, "com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.lambda-34.<anonymous> (SessionsScreens.kt:472)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(14));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1919203364, "C473@22175L30,474@22218L370:SessionsScreens.kt#qn8u0p");
            IconKt.Icon-ww6aTOc(LockKt.getLock(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(2));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier2);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer);
            Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1908252087, "C475@22352L10,475@22293L81,478@22535L10,476@22391L183:SessionsScreens.kt#qn8u0p");
            TextKt.Text-Nvy7gAk("First add a provider API key", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 6, 0, 131070);
            TextKt.Text-Nvy7gAk("Tap here: Anthropic, OpenAI, OpenRouter, Gemini, Groq, DeepSeek, Ollama…", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1432getLambda1$app_release() {
        return f92lambda1;
    }

    /* renamed from: getLambda-10$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1433getLambda10$app_release() {
        return f93lambda10;
    }

    /* renamed from: getLambda-11$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1434getLambda11$app_release() {
        return f94lambda11;
    }

    /* renamed from: getLambda-12$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1435getLambda12$app_release() {
        return f95lambda12;
    }

    /* renamed from: getLambda-13$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1436getLambda13$app_release() {
        return f96lambda13;
    }

    /* renamed from: getLambda-14$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1437getLambda14$app_release() {
        return f97lambda14;
    }

    /* renamed from: getLambda-15$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1438getLambda15$app_release() {
        return f98lambda15;
    }

    /* renamed from: getLambda-16$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1439getLambda16$app_release() {
        return f99lambda16;
    }

    /* renamed from: getLambda-17$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1440getLambda17$app_release() {
        return f100lambda17;
    }

    /* renamed from: getLambda-18$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1441getLambda18$app_release() {
        return f101lambda18;
    }

    /* renamed from: getLambda-19$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1442getLambda19$app_release() {
        return f102lambda19;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1443getLambda2$app_release() {
        return f103lambda2;
    }

    /* renamed from: getLambda-20$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1444getLambda20$app_release() {
        return f104lambda20;
    }

    /* renamed from: getLambda-21$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1445getLambda21$app_release() {
        return f105lambda21;
    }

    /* renamed from: getLambda-22$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1446getLambda22$app_release() {
        return f106lambda22;
    }

    /* renamed from: getLambda-23$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1447getLambda23$app_release() {
        return f107lambda23;
    }

    /* renamed from: getLambda-24$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1448getLambda24$app_release() {
        return f108lambda24;
    }

    /* renamed from: getLambda-25$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1449getLambda25$app_release() {
        return f109lambda25;
    }

    /* renamed from: getLambda-26$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1450getLambda26$app_release() {
        return f110lambda26;
    }

    /* renamed from: getLambda-27$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1451getLambda27$app_release() {
        return f111lambda27;
    }

    /* renamed from: getLambda-28$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1452getLambda28$app_release() {
        return f112lambda28;
    }

    /* renamed from: getLambda-29$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1453getLambda29$app_release() {
        return f113lambda29;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1454getLambda3$app_release() {
        return f114lambda3;
    }

    /* renamed from: getLambda-30$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1455getLambda30$app_release() {
        return f115lambda30;
    }

    /* renamed from: getLambda-31$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1456getLambda31$app_release() {
        return f116lambda31;
    }

    /* renamed from: getLambda-32$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1457getLambda32$app_release() {
        return f117lambda32;
    }

    /* renamed from: getLambda-33$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1458getLambda33$app_release() {
        return f118lambda33;
    }

    /* renamed from: getLambda-34$app_release, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m1459getLambda34$app_release() {
        return f119lambda34;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1460getLambda4$app_release() {
        return f120lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1461getLambda5$app_release() {
        return f121lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1462getLambda6$app_release() {
        return f122lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1463getLambda7$app_release() {
        return f123lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1464getLambda8$app_release() {
        return f124lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1465getLambda9$app_release() {
        return f125lambda9;
    }
}

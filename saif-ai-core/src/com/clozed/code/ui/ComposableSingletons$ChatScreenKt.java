package com.clozed.code.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.automirrored.filled.SendKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ComposableSingletons$ChatScreenKt {
    public static final ComposableSingletons$ChatScreenKt INSTANCE = new ComposableSingletons$ChatScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f60lambda1 = ComposableLambdaKt.composableLambdaInstance(-1846147905, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C149@6980L49:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1846147905, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-1.<anonymous> (ChatScreen.kt:149)");
            }
            IconKt.Icon-ww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f69lambda2 = ComposableLambdaKt.composableLambdaInstance(1809335660, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C177@8563L40:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1809335660, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-2.<anonymous> (ChatScreen.kt:177)");
            }
            IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f70lambda3 = ComposableLambdaKt.composableLambdaInstance(1662108648, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C229@11461L37:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1662108648, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-3.<anonymous> (ChatScreen.kt:229)");
            }
            TextKt.Text-Nvy7gAk("Type a message…", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, composer, 6, 24576, 245758);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f71lambda4 = ComposableLambdaKt.composableLambdaInstance(534999792, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C261@13744L44:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(534999792, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-4.<anonymous> (ChatScreen.kt:261)");
            }
            IconKt.Icon-ww6aTOc(SendKt.getSend(Icons.AutoMirrored.Filled.INSTANCE), "Send", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f72lambda5 = ComposableLambdaKt.composableLambdaInstance(-1862256361, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C322@16856L94:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1862256361, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-5.<anonymous> (ChatScreen.kt:322)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m826constructorimpl(38), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1602152073, "C322@16910L38:ChatScreen.kt#qn8u0p");
            LogoMotionKt.AgentWorkingIndicator(true, null, composer, 6, 2);
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

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f73lambda6 = ComposableLambdaKt.composableLambdaInstance(-813454267, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C325@17025L29:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-813454267, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-6.<anonymous> (ChatScreen.kt:325)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(1)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f74lambda7 = ComposableLambdaKt.composableLambdaInstance(-1949784661, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C338@17633L22:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1949784661, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-7.<anonymous> (ChatScreen.kt:338)");
            }
            TextKt.Text-Nvy7gAk("No, keep going", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f75lambda8 = ComposableLambdaKt.composableLambdaInstance(-1492079825, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C332@17195L33:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1492079825, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-8.<anonymous> (ChatScreen.kt:332)");
            }
            IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f76lambda9 = ComposableLambdaKt.composableLambdaInstance(1979206000, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C333@17254L28:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1979206000, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-9.<anonymous> (ChatScreen.kt:333)");
            }
            TextKt.Text-Nvy7gAk("Do you want to stop?", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f61lambda10 = ComposableLambdaKt.composableLambdaInstance(1155524529, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C334@17307L81:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1155524529, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-10.<anonymous> (ChatScreen.kt:334)");
            }
            TextKt.Text-Nvy7gAk("The agent is working right now. Stopping will interrupt the current task.", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f62lambda11 = ComposableLambdaKt.composableLambdaInstance(1214049196, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C372@18771L65:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1214049196, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-11.<anonymous> (ChatScreen.kt:372)");
            }
            IconKt.Icon-ww6aTOc(KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(14)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f63lambda12 = ComposableLambdaKt.composableLambdaInstance(1054699801, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation(composer, "C537@26102L36:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1054699801, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-12.<anonymous> (ChatScreen.kt:537)");
            }
            TextKt.Text-Nvy7gAk("Allow once", (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24582, 0, 262126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f64lambda13 = ComposableLambdaKt.composableLambdaInstance(1892833531, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation(composer, "C538@26262L32:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1892833531, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-13.<anonymous> (ChatScreen.kt:538)");
            }
            TextKt.Text-Nvy7gAk("Always", (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24582, 0, 262126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f65lambda14 = ComposableLambdaKt.composableLambdaInstance(-662882266, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C542@26560L32:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-662882266, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-14.<anonymous> (ChatScreen.kt:542)");
            }
            TextKt.Text-Nvy7gAk("Reject", (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24582, 0, 262126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f66lambda15 = ComposableLambdaKt.composableLambdaInstance(-107493452, false, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C585@28544L20:ChatScreen.kt#qn8u0p");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-107493452, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-15.<anonymous> (ChatScreen.kt:585)");
            }
            TextKt.Text-Nvy7gAk("Your answer…", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f67lambda16 = ComposableLambdaKt.composableLambdaInstance(2128254891, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation(composer, "C587@28702L12:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128254891, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-16.<anonymous> (ChatScreen.kt:587)");
            }
            TextKt.Text-Nvy7gAk("Send", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-17, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f68lambda17 = ComposableLambdaKt.composableLambdaInstance(-793884268, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ComposableSingletons$ChatScreenKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C589@28789L12:ChatScreen.kt#qn8u0p");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-793884268, i, -1, "com.clozed.code.ui.ComposableSingletons$ChatScreenKt.lambda-17.<anonymous> (ChatScreen.kt:589)");
            }
            TextKt.Text-Nvy7gAk("Skip", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1400getLambda1$app_release() {
        return f60lambda1;
    }

    /* renamed from: getLambda-10$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1401getLambda10$app_release() {
        return f61lambda10;
    }

    /* renamed from: getLambda-11$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1402getLambda11$app_release() {
        return f62lambda11;
    }

    /* renamed from: getLambda-12$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1403getLambda12$app_release() {
        return f63lambda12;
    }

    /* renamed from: getLambda-13$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1404getLambda13$app_release() {
        return f64lambda13;
    }

    /* renamed from: getLambda-14$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1405getLambda14$app_release() {
        return f65lambda14;
    }

    /* renamed from: getLambda-15$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1406getLambda15$app_release() {
        return f66lambda15;
    }

    /* renamed from: getLambda-16$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1407getLambda16$app_release() {
        return f67lambda16;
    }

    /* renamed from: getLambda-17$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1408getLambda17$app_release() {
        return f68lambda17;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1409getLambda2$app_release() {
        return f69lambda2;
    }

    /* renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1410getLambda3$app_release() {
        return f70lambda3;
    }

    /* renamed from: getLambda-4$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1411getLambda4$app_release() {
        return f71lambda4;
    }

    /* renamed from: getLambda-5$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1412getLambda5$app_release() {
        return f72lambda5;
    }

    /* renamed from: getLambda-6$app_release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1413getLambda6$app_release() {
        return f73lambda6;
    }

    /* renamed from: getLambda-7$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1414getLambda7$app_release() {
        return f74lambda7;
    }

    /* renamed from: getLambda-8$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1415getLambda8$app_release() {
        return f75lambda8;
    }

    /* renamed from: getLambda-9$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1416getLambda9$app_release() {
        return f76lambda9;
    }
}

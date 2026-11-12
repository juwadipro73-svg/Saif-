package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$ChatScreen$7$1$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<String> $input$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$7$1$1$1(ColorScheme colorScheme, MutableState<String> mutableState) {
        this.$cs = colorScheme;
        this.$input$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C277@14267L1505:ChatScreen.kt#qn8u0p");
        if ((i & 17) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(321930272, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:277)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m826constructorimpl(36), 0.0f, 0.0f, 13, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            float f = 8;
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
            ColorScheme colorScheme = this.$cs;
            MutableState<String> mutableState = this.$input$delegate;
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, centerHorizontally, composer, 54);
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
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1892637178, "C282@14543L16,283@14647L10,283@14584L85,284@14785L10,284@14694L113,285@14832L29:ChatScreen.kt#qn8u0p");
            LogoMotionKt.m1506LogoHeroorJrPs(Dp.m826constructorimpl(112), null, composer, 6, 2);
            MutableState<String> mutableState2 = mutableState;
            TextKt.Text-Nvy7gAk("What do you want to build today?", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 6, 0, 131070);
            TextKt.Text-Nvy7gAk("Type below or pick a suggestion", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131066);
            Composer composer3 = composer;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(f)), composer3, 6);
            composer3.startReplaceGroup(1324438241);
            ComposerKt.sourceInformation(composer3, "*294@15287L59,293@15216L15,297@15539L185,292@15160L564");
            for (final String str : CollectionsKt.listOf((Object[]) new String[]{"Explain this project", "Find and fix bugs", "Write tests for this code", "/init"})) {
                CardColors cardColors = CardDefaults.INSTANCE.outlinedCardColors-ro_MJ88(colorScheme.getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14);
                BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.m826constructorimpl(1), Color.copy-wmQWz5c$default(colorScheme.getPrimary-0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                composer3.startReplaceGroup(-1988213228);
                ComposerKt.sourceInformation(composer3, "CC(remember):ChatScreen.kt#9igjgp");
                final MutableState<String> mutableState3 = mutableState2;
                boolean changed = composer3.changed(mutableState3) | composer3.changed(str);
                Object rememberedValue = composer3.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$1$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$3$lambda$2$lambda$1$lambda$0;
                            invoke$lambda$3$lambda$2$lambda$1$lambda$0 = ChatScreenKt$ChatScreen$7$1$1$1.invoke$lambda$3$lambda$2$lambda$1$lambda$0(str, mutableState3);
                            return invoke$lambda$3$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue);
                }
                composer3.endReplaceGroup();
                mutableState2 = mutableState3;
                CardKt.OutlinedCard((Function0) rememberedValue, fillMaxWidth$default, false, (Shape) null, cardColors, (CardElevation) null, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1423314801, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$7$1$1$1$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope2, Composer composer4, Integer num) {
                        invoke(columnScope2, composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope OutlinedCard, Composer composer4, int i2) {
                        Intrinsics.checkNotNullParameter(OutlinedCard, "$this$OutlinedCard");
                        ComposerKt.sourceInformation(composer4, "C298@15605L10,298@15573L121:ChatScreen.kt#qn8u0p");
                        if ((i2 & 17) == 16 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1423314801, i2, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:298)");
                        }
                        TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.m826constructorimpl(16), Dp.m826constructorimpl(12)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), composer4, 48, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54), composer3, 100663344, 172);
                composer3 = composer;
            }
            composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1$lambda$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }
}

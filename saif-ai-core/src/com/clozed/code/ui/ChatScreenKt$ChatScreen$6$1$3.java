package com.clozed.code.ui;

import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class ChatScreenKt$ChatScreen$6$1$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $busy;
    final /* synthetic */ MutableState<Boolean> $confirmStop$delegate;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<Boolean> $follow$delegate;
    final /* synthetic */ MutableState<List<String>> $images$delegate;
    final /* synthetic */ MutableState<String> $input$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String, List<Uri>> $pickImages;
    final /* synthetic */ MutableState<Boolean> $showPort$delegate;
    final /* synthetic */ UiState $state;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$6$1$3(UiState uiState, ManagedActivityResultLauncher<String, List<Uri>> managedActivityResultLauncher, MutableState<String> mutableState, boolean z, MutableState<Boolean> mutableState2, ColorScheme colorScheme, AppViewModel appViewModel, MutableState<Boolean> mutableState3, MutableState<List<String>> mutableState4, MutableState<Boolean> mutableState5) {
        this.$state = uiState;
        this.$pickImages = managedActivityResultLauncher;
        this.$input$delegate = mutableState;
        this.$busy = z;
        this.$showPort$delegate = mutableState2;
        this.$cs = colorScheme;
        this.$vm = appViewModel;
        this.$confirmStop$delegate = mutableState3;
        this.$images$delegate = mutableState4;
        this.$follow$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String ChatScreen$lambda$4;
        ComposerKt.sourceInformation(composer, "C219@10857L3011:ChatScreen.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-247373367, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:219)");
        }
        float f = 4;
        float f2 = 6;
        Modifier modifier = PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.m826constructorimpl(f), Dp.m826constructorimpl(f), Dp.m826constructorimpl(f2), Dp.m826constructorimpl(f));
        Alignment.Vertical bottom = Alignment.Companion.getBottom();
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f2));
        UiState uiState = this.$state;
        final ManagedActivityResultLauncher<String, List<Uri>> managedActivityResultLauncher = this.$pickImages;
        final MutableState<String> mutableState = this.$input$delegate;
        boolean z = this.$busy;
        final MutableState<Boolean> mutableState2 = this.$showPort$delegate;
        ColorScheme colorScheme = this.$cs;
        AppViewModel appViewModel = this.$vm;
        MutableState<Boolean> mutableState3 = this.$confirmStop$delegate;
        MutableState<List<String>> mutableState4 = this.$images$delegate;
        MutableState<Boolean> mutableState5 = this.$follow$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, bottom, composer, 54);
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
        ComposerKt.sourceInformationMarkerStart(composer, 494085069, "C231@11599L493,228@11401L14,227@11331L848,241@12255L1591,241@12204L1642:ChatScreen.kt#qn8u0p");
        composer.startReplaceGroup(-2062274294);
        ComposerKt.sourceInformation(composer, "225@11210L32,225@11260L19,225@11190L90");
        if (uiState.getLocal()) {
            composer.startReplaceGroup(-2062272281);
            ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$1$lambda$0;
                        invoke$lambda$6$lambda$1$lambda$0 = ChatScreenKt$ChatScreen$6$1$3.invoke$lambda$6$lambda$1$lambda$0(managedActivityResultLauncher);
                        return invoke$lambda$6$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-2062270694);
            ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$3$lambda$2;
                        invoke$lambda$6$lambda$3$lambda$2 = ChatScreenKt$ChatScreen$6$1$3.invoke$lambda$6$lambda$3$lambda$2(mutableState2);
                        return invoke$lambda$6$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            ChatExtrasKt.PlusMenu(function0, (Function0) rememberedValue2, composer, 48);
        }
        composer.endReplaceGroup();
        ChatScreen$lambda$4 = ChatScreenKt.ChatScreen$lambda$4(mutableState);
        TextFieldColors textFieldColors = TextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, (TextSelectionColors) null, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 1794048, 3504, 0, 0, 3072, 2147469199, 4095);
        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
        composer.startReplaceGroup(-2062266187);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed = composer.changed(mutableState);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$6$1$3$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$6$lambda$5$lambda$4;
                    invoke$lambda$6$lambda$5$lambda$4 = ChatScreenKt$ChatScreen$6$1$3.invoke$lambda$6$lambda$5$lambda$4(mutableState, (String) obj);
                    return invoke$lambda$6$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        TextFieldKt.TextField(ChatScreen$lambda$4, (Function1) rememberedValue3, weight$default, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1410getLambda3$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 6, 0, (MutableInteractionSource) null, (Shape) null, textFieldColors, composer, 12582912, 100663296, 0, 3932024);
        CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, (FiniteAnimationSpec) null, "send-stop", ComposableLambdaKt.rememberComposableLambda(-929179348, true, new ChatScreenKt$ChatScreen$6$1$3$1$4(colorScheme, mutableState, appViewModel, mutableState3, mutableState4, mutableState5), composer, 54), composer, 27648, 6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$1$lambda$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$3$lambda$2(MutableState mutableState) {
        ChatScreenKt.ChatScreen$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }
}

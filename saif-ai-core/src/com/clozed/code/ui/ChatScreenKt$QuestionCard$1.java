package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.clozed.code.data.PermissionReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$QuestionCard$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function1<String, Unit> $onReply;
    final /* synthetic */ PermissionReq $req;
    final /* synthetic */ MutableState<String> $text$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatScreenKt$QuestionCard$1(PermissionReq permissionReq, Function1<? super String, Unit> function1, MutableState<String> mutableState) {
        this.$req = permissionReq;
        this.$onReply = function1;
        this.$text$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope Card, Composer composer, int i) {
        String QuestionCard$lambda$89;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C577@27942L871:ChatScreen.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-82763807, i, -1, "com.clozed.code.ui.QuestionCard.<anonymous> (ChatScreen.kt:577)");
        }
        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
        PermissionReq permissionReq = this.$req;
        final Function1<String, Unit> function1 = this.$onReply;
        final MutableState<String> mutableState = this.$text$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
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
        ComposerKt.sourceInformationMarkerStart(composer, -124258292, "C578@28085L10,578@28039L68,582@28302L428,589@28764L21,589@28743L60:ChatScreen.kt#qn8u0p");
        String message = permissionReq.getMessage();
        if (message == null) {
            message = "";
        }
        TextKt.Text-Nvy7gAk(message, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 0, 0, 131070);
        composer.startReplaceGroup(-973837288);
        ComposerKt.sourceInformation(composer, "*580@28190L16,580@28244L31,580@28165L110");
        for (final String str : permissionReq.getOptions()) {
            composer.startReplaceGroup(1807750218);
            ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$QuestionCard$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$10$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$10$lambda$2$lambda$1$lambda$0 = ChatScreenKt$QuestionCard$1.invoke$lambda$10$lambda$2$lambda$1$lambda$0(Function1.this, str);
                        return invoke$lambda$10$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            ButtonKt.OutlinedButton((Function0) rememberedValue, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-224011019, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$QuestionCard$1$1$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope OutlinedButton, Composer composer3, int i2) {
                    Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                    ComposerKt.sourceInformation(composer3, "C580@28246L27:ChatScreen.kt#qn8u0p");
                    if ((i2 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-224011019, i2, -1, "com.clozed.code.ui.QuestionCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:580)");
                    }
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 24576, 0, 262126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 805306416, 508);
        }
        composer.endReplaceGroup();
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
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
        Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
        }
        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 205922597, "C584@28493L13,583@28424L193,587@28651L47,587@28634L82:ChatScreen.kt#qn8u0p");
        QuestionCard$lambda$89 = ChatScreenKt.QuestionCard$lambda$89(mutableState);
        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
        composer.startReplaceGroup(1807759911);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed2 = composer.changed(mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$QuestionCard$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$10$lambda$7$lambda$4$lambda$3;
                    invoke$lambda$10$lambda$7$lambda$4$lambda$3 = ChatScreenKt$QuestionCard$1.invoke$lambda$10$lambda$7$lambda$4$lambda$3(mutableState, (String) obj);
                    return invoke$lambda$10$lambda$7$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        OutlinedTextFieldKt.OutlinedTextField(QuestionCard$lambda$89, (Function1) rememberedValue2, weight$default, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1406getLambda15$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 12582912, 0, 0, 8388472);
        composer.startReplaceGroup(1807765001);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed3 = composer.changed(mutableState) | composer.changed(function1);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$QuestionCard$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$10$lambda$7$lambda$6$lambda$5;
                    invoke$lambda$10$lambda$7$lambda$6$lambda$5 = ChatScreenKt$QuestionCard$1.invoke$lambda$10$lambda$7$lambda$6$lambda$5(Function1.this, mutableState);
                    return invoke$lambda$10$lambda$7$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        ButtonKt.Button((Function0) rememberedValue3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1407getLambda16$app_release(), composer, 805306368, 510);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-973817200);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed4 = composer.changed(function1);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$QuestionCard$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$10$lambda$9$lambda$8;
                    invoke$lambda$10$lambda$9$lambda$8 = ChatScreenKt$QuestionCard$1.invoke$lambda$10$lambda$9$lambda$8(Function1.this);
                    return invoke$lambda$10$lambda$9$lambda$8;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue4, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1408getLambda17$app_release(), composer, 805306368, 510);
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
    public static final Unit invoke$lambda$10$lambda$2$lambda$1$lambda$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$7$lambda$4$lambda$3(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$7$lambda$6$lambda$5(Function1 function1, MutableState mutableState) {
        String QuestionCard$lambda$89;
        String QuestionCard$lambda$892;
        QuestionCard$lambda$89 = ChatScreenKt.QuestionCard$lambda$89(mutableState);
        if (!StringsKt.isBlank(QuestionCard$lambda$89)) {
            QuestionCard$lambda$892 = ChatScreenKt.QuestionCard$lambda$89(mutableState);
            function1.invoke(StringsKt.trim((CharSequence) QuestionCard$lambda$892).toString());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$9$lambda$8(Function1 function1) {
        function1.invoke("reject");
        return Unit.INSTANCE;
    }
}

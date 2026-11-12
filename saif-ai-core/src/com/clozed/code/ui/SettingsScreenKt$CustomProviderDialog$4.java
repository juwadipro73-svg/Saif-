package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SegmentedButtonKt;
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
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.engine.CatProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$CustomProviderDialog$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $anthropic$delegate;
    final /* synthetic */ MutableState<String> $apiUrl$delegate;
    final /* synthetic */ MutableState<String> $ckey$delegate;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ CatProvider $existing;
    final /* synthetic */ MutableState<String> $fetchMsg$delegate;
    final /* synthetic */ MutableState<Boolean> $fetching$delegate;
    final /* synthetic */ MutableState<String> $models$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ Function4<String, Boolean, String, Continuation<? super List<String>>, Object> $onFetch;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableState<Boolean> $show$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$CustomProviderDialog$4(CatProvider catProvider, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<Boolean> mutableState6, Context context, CoroutineScope coroutineScope, Function4<? super String, ? super Boolean, ? super String, ? super Continuation<? super List<String>>, ? extends Object> function4, MutableState<Boolean> mutableState7, MutableState<String> mutableState8) {
        this.$existing = catProvider;
        this.$name$delegate = mutableState;
        this.$apiUrl$delegate = mutableState2;
        this.$anthropic$delegate = mutableState3;
        this.$models$delegate = mutableState4;
        this.$ckey$delegate = mutableState5;
        this.$show$delegate = mutableState6;
        this.$ctx = context;
        this.$scope = coroutineScope;
        this.$onFetch = function4;
        this.$fetching$delegate = mutableState7;
        this.$fetchMsg$delegate = mutableState8;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v24 */
    public final void invoke(Composer composer, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        MutableState<String> mutableState;
        MutableState<Boolean> mutableState2;
        String str5;
        MutableState<String> mutableState3;
        MutableState<String> mutableState4;
        MutableState<Boolean> mutableState5;
        Context context;
        CoroutineScope coroutineScope;
        Function4<String, Boolean, String, Continuation<? super List<String>>, Object> function4;
        MutableState<Boolean> mutableState6;
        MutableState<String> mutableState7;
        CatProvider catProvider;
        MutableState<String> mutableState8;
        String CustomProviderDialog$lambda$87;
        String CustomProviderDialog$lambda$90;
        final MutableState<String> mutableState9;
        String CustomProviderDialog$lambda$94;
        final MutableState<String> mutableState10;
        String CustomProviderDialog$lambda$97;
        boolean CustomProviderDialog$lambda$103;
        ?? r4;
        PasswordVisualTransformation passwordVisualTransformation;
        final MutableState<String> mutableState11;
        final MutableState<Boolean> mutableState12;
        final MutableState<String> mutableState13;
        boolean CustomProviderDialog$lambda$81;
        final MutableState<Boolean> mutableState14;
        MutableState<Boolean> mutableState15;
        String CustomProviderDialog$lambda$84;
        MutableState<Boolean> mutableState16;
        ?? r0;
        String CustomProviderDialog$lambda$902;
        final MutableState<String> mutableState17;
        final MutableState<String> mutableState18;
        final MutableState<Boolean> mutableState19;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C525@24002L21,525@23971L3589:SettingsScreen.kt#qn8u0p");
        if ((i & 3) == 2 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(429622328, i, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous> (SettingsScreen.kt:525)");
        }
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
        float f = 8;
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
        CatProvider catProvider2 = this.$existing;
        final MutableState<String> mutableState20 = this.$name$delegate;
        final MutableState<String> mutableState21 = this.$apiUrl$delegate;
        final MutableState<Boolean> mutableState22 = this.$anthropic$delegate;
        MutableState<String> mutableState23 = this.$models$delegate;
        MutableState<String> mutableState24 = this.$ckey$delegate;
        MutableState<Boolean> mutableState25 = this.$show$delegate;
        Context context2 = this.$ctx;
        CoroutineScope coroutineScope2 = this.$scope;
        Function4<String, Boolean, String, Continuation<? super List<String>>, Object> function42 = this.$onFetch;
        MutableState<Boolean> mutableState26 = this.$fetching$delegate;
        MutableState<String> mutableState27 = this.$fetchMsg$delegate;
        ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
        Function0 constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor);
        } else {
            composer2.useNode();
        }
        Composer composer3 = Updater.constructor-impl(composer2);
        Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode));
            composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer2, -891667240, "C532@24633L13,532@24609L119,533@24771L15,533@24745L127,534@24915L15,534@24889L127,536@25078L13,537@25140L101,535@25033L399,541@25449L235,545@25701L1289,566@27047L10,566@27093L11,566@27007L115,567@27195L351,567@27139L407:SettingsScreen.kt#qn8u0p");
        composer2.startReplaceGroup(-1691334399);
        ComposerKt.sourceInformation(composer2, "527@24168L21,527@24138L436");
        if (catProvider2 == null) {
            Modifier horizontalScroll$default = ScrollKt.horizontalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, horizontalScroll$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 698880859, "C528@24291L76,528@24270L126,529@24442L78,529@24421L131:SettingsScreen.kt#qn8u0p");
            composer2.startReplaceGroup(299639674);
            ComposerKt.sourceInformation(composer2, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$23$lambda$4$lambda$1$lambda$0;
                        invoke$lambda$23$lambda$4$lambda$1$lambda$0 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$4$lambda$1$lambda$0(mutableState20, mutableState21, mutableState22);
                        return invoke$lambda$23$lambda$4$lambda$1$lambda$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            mutableState5 = mutableState25;
            str = "C101@5233L9:Row.kt#2w3rfo";
            str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            function4 = function42;
            context = context2;
            str3 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
            catProvider = catProvider2;
            mutableState3 = mutableState23;
            str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            str5 = "CC(remember):SettingsScreen.kt#9igjgp";
            coroutineScope = coroutineScope2;
            mutableState4 = mutableState24;
            mutableState6 = mutableState26;
            mutableState7 = mutableState27;
            ChipKt.AssistChip((Function0) rememberedValue, ComposableSingletons$SettingsScreenKt.INSTANCE.m1480getLambda22$app_release(), (Modifier) null, false, (Function2) null, (Function2) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer, 54, 0, 2044);
            composer.startReplaceGroup(299644508);
            ComposerKt.sourceInformation(composer, str5);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                mutableState17 = mutableState20;
                mutableState18 = mutableState21;
                mutableState19 = mutableState22;
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$23$lambda$4$lambda$3$lambda$2;
                        invoke$lambda$23$lambda$4$lambda$3$lambda$2 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$4$lambda$3$lambda$2(mutableState17, mutableState18, mutableState19);
                        return invoke$lambda$23$lambda$4$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            } else {
                mutableState17 = mutableState20;
                mutableState18 = mutableState21;
                mutableState19 = mutableState22;
            }
            composer.endReplaceGroup();
            mutableState = mutableState18;
            mutableState8 = mutableState17;
            mutableState2 = mutableState19;
            ChipKt.AssistChip((Function0) rememberedValue2, ComposableSingletons$SettingsScreenKt.INSTANCE.m1481getLambda23$app_release(), (Modifier) null, false, (Function2) null, (Function2) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer, 54, 0, 2044);
            composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
        } else {
            str = "C101@5233L9:Row.kt#2w3rfo";
            str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            str3 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
            str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            mutableState = mutableState21;
            mutableState2 = mutableState22;
            str5 = "CC(remember):SettingsScreen.kt#9igjgp";
            mutableState3 = mutableState23;
            mutableState4 = mutableState24;
            mutableState5 = mutableState25;
            context = context2;
            coroutineScope = coroutineScope2;
            function4 = function42;
            mutableState6 = mutableState26;
            mutableState7 = mutableState27;
            catProvider = catProvider2;
            mutableState8 = mutableState20;
        }
        composer2.endReplaceGroup();
        CustomProviderDialog$lambda$87 = SettingsScreenKt.CustomProviderDialog$lambda$87(mutableState8);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer2.startReplaceGroup(-1691317636);
        ComposerKt.sourceInformation(composer2, str5);
        Object rememberedValue3 = composer2.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            final MutableState<String> mutableState28 = mutableState8;
            rememberedValue3 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$23$lambda$6$lambda$5;
                    invoke$lambda$23$lambda$6$lambda$5 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$6$lambda$5(mutableState28, (String) obj);
                    return invoke$lambda$23$lambda$6$lambda$5;
                }
            };
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer2.endReplaceGroup();
        String str6 = str5;
        OutlinedTextFieldKt.OutlinedTextField(CustomProviderDialog$lambda$87, (Function1) rememberedValue3, fillMaxWidth$default, false, false, (TextStyle) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1482getLambda24$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8257464);
        CustomProviderDialog$lambda$90 = SettingsScreenKt.CustomProviderDialog$lambda$90(mutableState);
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(-1691313218);
        ComposerKt.sourceInformation(composer, str6);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            mutableState9 = mutableState;
            rememberedValue4 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$23$lambda$8$lambda$7;
                    invoke$lambda$23$lambda$8$lambda$7 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$8$lambda$7(mutableState9, (String) obj);
                    return invoke$lambda$23$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        } else {
            mutableState9 = mutableState;
        }
        composer.endReplaceGroup();
        final MutableState<String> mutableState29 = mutableState9;
        OutlinedTextFieldKt.OutlinedTextField(CustomProviderDialog$lambda$90, (Function1) rememberedValue4, fillMaxWidth$default2, false, false, (TextStyle) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1483getLambda25$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8257464);
        CustomProviderDialog$lambda$94 = SettingsScreenKt.CustomProviderDialog$lambda$94(mutableState3);
        Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(-1691308610);
        ComposerKt.sourceInformation(composer, str6);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            mutableState10 = mutableState3;
            rememberedValue5 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$23$lambda$10$lambda$9;
                    invoke$lambda$23$lambda$10$lambda$9 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$10$lambda$9(mutableState10, (String) obj);
                    return invoke$lambda$23$lambda$10$lambda$9;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        } else {
            mutableState10 = mutableState3;
        }
        composer.endReplaceGroup();
        final MutableState<String> mutableState30 = mutableState10;
        OutlinedTextFieldKt.OutlinedTextField(CustomProviderDialog$lambda$94, (Function1) rememberedValue5, fillMaxWidth$default3, false, false, (TextStyle) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1484getLambda26$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 0, 0, 8388536);
        CustomProviderDialog$lambda$97 = SettingsScreenKt.CustomProviderDialog$lambda$97(mutableState4);
        CustomProviderDialog$lambda$103 = SettingsScreenKt.CustomProviderDialog$lambda$103(mutableState5);
        if (CustomProviderDialog$lambda$103) {
            passwordVisualTransformation = VisualTransformation.INSTANCE.getNone();
            r4 = 1;
        } else {
            r4 = 1;
            passwordVisualTransformation = new PasswordVisualTransformation((char) 0, 1, null);
        }
        VisualTransformation visualTransformation = passwordVisualTransformation;
        Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, (int) r4, (Object) null);
        composer.startReplaceGroup(-1691303396);
        ComposerKt.sourceInformation(composer, str6);
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == Composer.Companion.getEmpty()) {
            mutableState11 = mutableState4;
            rememberedValue6 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$23$lambda$12$lambda$11;
                    invoke$lambda$23$lambda$12$lambda$11 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$12$lambda$11(mutableState11, (String) obj);
                    return invoke$lambda$23$lambda$12$lambda$11;
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        } else {
            mutableState11 = mutableState4;
        }
        composer.endReplaceGroup();
        final CatProvider catProvider3 = catProvider;
        MutableState<String> mutableState31 = mutableState11;
        OutlinedTextFieldKt.OutlinedTextField(CustomProviderDialog$lambda$97, (Function1) rememberedValue6, fillMaxWidth$default4, false, false, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-1613029887, (boolean) r4, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                invoke(composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer5, int i2) {
                ComposerKt.sourceInformation(composer5, "C537@25142L97:SettingsScreen.kt#qn8u0p");
                if ((i2 & 3) == 2 && composer5.getSkipping()) {
                    composer5.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1613029887, i2, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:537)");
                }
                TextKt.Text-Nvy7gAk(CatProvider.this == null ? "API key (optional)" : "API key (leave empty to keep the old one)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, visualTransformation, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8241080);
        String str7 = str2;
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, str7);
        Modifier modifier = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
        String str8 = str3;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str8);
        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
        String str9 = str4;
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, str9);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composer5 = Updater.constructor-impl(composer);
        Updater.set-impl(composer5, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode3))) {
            composer5.updateRememberedValue(Integer.valueOf(hashCode3));
            composer5.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
        }
        Updater.set-impl(composer5, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
        String str10 = str;
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, str10);
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 700073398, "C542@25496L16,542@25514L38,542@25475L77,543@25594L53,543@25573L93:SettingsScreen.kt#qn8u0p");
        composer.startReplaceGroup(299678174);
        ComposerKt.sourceInformation(composer, str6);
        Object rememberedValue7 = composer.rememberedValue();
        if (rememberedValue7 == Composer.Companion.getEmpty()) {
            mutableState12 = mutableState5;
            rememberedValue7 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$23$lambda$18$lambda$14$lambda$13;
                    invoke$lambda$23$lambda$18$lambda$14$lambda$13 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$18$lambda$14$lambda$13(mutableState12);
                    return invoke$lambda$23$lambda$18$lambda$14$lambda$13;
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        } else {
            mutableState12 = mutableState5;
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue7, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(114374031, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$7$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope3, Composer composer6, Integer num) {
                invoke(rowScope3, composer6, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer6, int i2) {
                boolean CustomProviderDialog$lambda$1032;
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer6, "C542@25516L34:SettingsScreen.kt#qn8u0p");
                if ((i2 & 17) == 16 && composer6.getSkipping()) {
                    composer6.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(114374031, i2, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:542)");
                }
                CustomProviderDialog$lambda$1032 = SettingsScreenKt.CustomProviderDialog$lambda$103(mutableState12);
                TextKt.Text-Nvy7gAk(CustomProviderDialog$lambda$1032 ? "Hide" : "Show", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer6, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 805306374, 510);
        composer.startReplaceGroup(299681347);
        ComposerKt.sourceInformation(composer, str6);
        final Context context3 = context;
        boolean changedInstance = composer.changedInstance(context3);
        Object rememberedValue8 = composer.rememberedValue();
        if (changedInstance || rememberedValue8 == Composer.Companion.getEmpty()) {
            mutableState13 = mutableState31;
            rememberedValue8 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$23$lambda$18$lambda$17$lambda$16;
                    invoke$lambda$23$lambda$18$lambda$17$lambda$16 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$18$lambda$17$lambda$16(context3, mutableState13);
                    return invoke$lambda$23$lambda$18$lambda$17$lambda$16;
                }
            };
            composer.updateRememberedValue(rememberedValue8);
        } else {
            mutableState13 = mutableState31;
        }
        composer.endReplaceGroup();
        final MutableState<String> mutableState32 = mutableState13;
        ButtonKt.TextButton((Function0) rememberedValue8, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1485getLambda27$app_release(), composer, 805306368, 510);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, str7);
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str8);
        boolean z = false;
        int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifier2);
        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, str9);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer composer6 = Updater.constructor-impl(composer);
        Updater.set-impl(composer6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode4))) {
            composer6.updateRememberedValue(Integer.valueOf(hashCode4));
            composer6.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
        }
        Updater.set-impl(composer6, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, str10);
        RowScope rowScope3 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 700402184, "C548@25889L861,563@26774L55,546@25775L1054:SettingsScreen.kt#qn8u0p");
        CustomProviderDialog$lambda$81 = SettingsScreenKt.CustomProviderDialog$lambda$81(mutableState6);
        if (!CustomProviderDialog$lambda$81) {
            CustomProviderDialog$lambda$902 = SettingsScreenKt.CustomProviderDialog$lambda$90(mutableState29);
            if (!StringsKt.isBlank(CustomProviderDialog$lambda$902)) {
                z = true;
            }
        }
        composer.startReplaceGroup(299691595);
        ComposerKt.sourceInformation(composer, str6);
        final CoroutineScope coroutineScope3 = coroutineScope;
        final Function4<String, Boolean, String, Continuation<? super List<String>>, Object> function43 = function4;
        boolean changedInstance2 = composer.changedInstance(coroutineScope3) | composer.changedInstance(function43);
        Object rememberedValue9 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue9 == Composer.Companion.getEmpty()) {
            mutableState14 = mutableState6;
            final MutableState<String> mutableState33 = mutableState7;
            final MutableState<Boolean> mutableState34 = mutableState2;
            Function0 function0 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$23$lambda$22$lambda$20$lambda$19;
                    invoke$lambda$23$lambda$22$lambda$20$lambda$19 = SettingsScreenKt$CustomProviderDialog$4.invoke$lambda$23$lambda$22$lambda$20$lambda$19(CoroutineScope.this, mutableState14, mutableState33, function43, mutableState29, mutableState34, mutableState32, mutableState30);
                    return invoke$lambda$23$lambda$22$lambda$20$lambda$19;
                }
            };
            mutableState15 = mutableState34;
            composer.updateRememberedValue(function0);
            rememberedValue9 = function0;
        } else {
            mutableState14 = mutableState6;
            mutableState15 = mutableState2;
        }
        composer.endReplaceGroup();
        Composer composer7 = composer;
        ButtonKt.TextButton((Function0) rememberedValue9, (Modifier) null, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-565924218, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$8$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope4, Composer composer8, Integer num) {
                invoke(rowScope4, composer8, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TextButton, Composer composer8, int i2) {
                boolean CustomProviderDialog$lambda$812;
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                ComposerKt.sourceInformation(composer8, "C563@26776L51:SettingsScreen.kt#qn8u0p");
                if ((i2 & 17) == 16 && composer8.getSkipping()) {
                    composer8.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-565924218, i2, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:563)");
                }
                CustomProviderDialog$lambda$812 = SettingsScreenKt.CustomProviderDialog$lambda$81(mutableState14);
                TextKt.Text-Nvy7gAk(CustomProviderDialog$lambda$812 ? "Fetching…" : "Fetch models", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer8, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer7, 805306368, 506);
        CustomProviderDialog$lambda$84 = SettingsScreenKt.CustomProviderDialog$lambda$84(mutableState7);
        composer7.startReplaceGroup(299721918);
        ComposerKt.sourceInformation(composer7, "*564@26897L10,564@26941L11,564@26866L104");
        if (CustomProviderDialog$lambda$84 == null) {
            mutableState16 = mutableState15;
            r0 = 1;
        } else {
            mutableState16 = mutableState15;
            r0 = 1;
            TextKt.Text-Nvy7gAk(CustomProviderDialog$lambda$84, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
            composer7 = composer;
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        composer7.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        composer7.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        ComposerKt.sourceInformationMarkerEnd(composer7);
        TextKt.Text-Nvy7gAk("API style", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelMedium(), composer, 6, 0, 131066);
        SegmentedButtonKt.SingleChoiceSegmentedButtonRow-uFdPcIQ(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, (int) r0, (Object) null), 0.0f, ComposableLambdaKt.rememberComposableLambda(-1394014589, (boolean) r0, new SettingsScreenKt$CustomProviderDialog$4$1$9(mutableState16), composer, 54), composer, 390, 2);
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
    public static final Unit invoke$lambda$23$lambda$4$lambda$1$lambda$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        mutableState.setValue("Ollama");
        mutableState2.setValue("http://127.0.0.1:11434/v1");
        SettingsScreenKt.CustomProviderDialog$lambda$101(mutableState3, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$4$lambda$3$lambda$2(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        mutableState.setValue("LM Studio");
        mutableState2.setValue("http://127.0.0.1:1234/v1");
        SettingsScreenKt.CustomProviderDialog$lambda$101(mutableState3, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$6$lambda$5(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$8$lambda$7(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$10$lambda$9(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$12$lambda$11(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$18$lambda$14$lambda$13(MutableState mutableState) {
        boolean CustomProviderDialog$lambda$103;
        CustomProviderDialog$lambda$103 = SettingsScreenKt.CustomProviderDialog$lambda$103(mutableState);
        SettingsScreenKt.CustomProviderDialog$lambda$104(mutableState, !CustomProviderDialog$lambda$103);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$18$lambda$17$lambda$16(Context context, MutableState mutableState) {
        String pasteFromClipboard = ComponentsKt.pasteFromClipboard(context);
        if (pasteFromClipboard != null) {
            mutableState.setValue(StringsKt.trim((CharSequence) pasteFromClipboard).toString());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$23$lambda$22$lambda$20$lambda$19(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Function4 function4, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6) {
        SettingsScreenKt.CustomProviderDialog$lambda$82(mutableState, true);
        mutableState2.setValue(null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1(function4, mutableState3, mutableState4, mutableState5, mutableState6, mutableState2, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }
}

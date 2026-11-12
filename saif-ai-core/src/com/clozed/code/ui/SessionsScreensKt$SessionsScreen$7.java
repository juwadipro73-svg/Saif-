package com.clozed.code.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import com.clozed.code.UiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionsScreen$7 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $copyOpen$delegate;
    final /* synthetic */ Context $dctx;
    final /* synthetic */ MutableState<String> $dir$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<Boolean> $nameTouched$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<Uri, Uri> $picker;
    final /* synthetic */ MutableState<String> $portSrc$delegate;
    final /* synthetic */ MutableState<String> $portWhat$delegate;
    final /* synthetic */ UiState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionsScreen$7(UiState uiState, ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher, Context context, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6) {
        this.$state = uiState;
        this.$picker = managedActivityResultLauncher;
        this.$dctx = context;
        this.$dir$delegate = mutableState;
        this.$name$delegate = mutableState2;
        this.$nameTouched$delegate = mutableState3;
        this.$copyOpen$delegate = mutableState4;
        this.$portSrc$delegate = mutableState5;
        this.$portWhat$delegate = mutableState6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String str;
        MutableState<String> mutableState;
        MutableState<String> mutableState2;
        MutableState<Boolean> mutableState3;
        MutableState<Boolean> mutableState4;
        MutableState<String> mutableState5;
        MutableState<String> mutableState6;
        UiState uiState;
        float f;
        String SessionsScreen$lambda$44;
        String SessionsScreen$lambda$47;
        final MutableState<Boolean> mutableState7;
        boolean SessionsScreen$lambda$53;
        String SessionsScreen$lambda$56;
        String SessionsScreen$lambda$59;
        ComposerKt.sourceInformation(composer, "C332@15360L21,331@15280L1649:SessionsScreens.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(625948810, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous> (SessionsScreens.kt:331)");
        }
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
        UiState uiState2 = this.$state;
        final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher = this.$picker;
        final Context context = this.$dctx;
        MutableState<String> mutableState8 = this.$dir$delegate;
        MutableState<String> mutableState9 = this.$name$delegate;
        MutableState<Boolean> mutableState10 = this.$nameTouched$delegate;
        MutableState<Boolean> mutableState11 = this.$copyOpen$delegate;
        MutableState<String> mutableState12 = this.$portSrc$delegate;
        MutableState<String> mutableState13 = this.$portWhat$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1221802611, "C342@16047L12,341@15975L257,347@16326L33,346@16253L266:SessionsScreens.kt#qn8u0p");
        composer.startReplaceGroup(1623154041);
        ComposerKt.sourceInformation(composer, "336@15566L23,336@15538L122,338@15808L28,338@15783L123");
        if (uiState2.getLocal()) {
            composer.startReplaceGroup(1623155877);
            ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$14$lambda$1$lambda$0;
                        invoke$lambda$14$lambda$1$lambda$0 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$1$lambda$0(managedActivityResultLauncher);
                        return invoke$lambda$14$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            mutableState = mutableState8;
            str = "CC(remember):SessionsScreens.kt#9igjgp";
            mutableState6 = mutableState13;
            mutableState5 = mutableState12;
            mutableState2 = mutableState9;
            mutableState3 = mutableState10;
            mutableState4 = mutableState11;
            uiState = uiState2;
            f = 0.0f;
            ButtonKt.FilledTonalButton((Function0) rememberedValue, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1441getLambda18$app_release(), composer, 805306416, 508);
            if (Build.VERSION.SDK_INT >= 30 && !ComponentsKt.hasAllFilesAccess()) {
                composer.startReplaceGroup(1623163626);
                ComposerKt.sourceInformation(composer, str);
                boolean changedInstance2 = composer.changedInstance(context);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$14$lambda$3$lambda$2;
                            invoke$lambda$14$lambda$3$lambda$2 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$3$lambda$2(context);
                            return invoke$lambda$14$lambda$3$lambda$2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                ButtonKt.OutlinedButton((Function0) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1442getLambda19$app_release(), composer, 805306416, 508);
            }
        } else {
            str = "CC(remember):SessionsScreens.kt#9igjgp";
            mutableState = mutableState8;
            mutableState2 = mutableState9;
            mutableState3 = mutableState10;
            mutableState4 = mutableState11;
            mutableState5 = mutableState12;
            mutableState6 = mutableState13;
            uiState = uiState2;
            f = 0.0f;
        }
        composer.endReplaceGroup();
        SessionsScreen$lambda$44 = SessionsScreensKt.SessionsScreen$lambda$44(mutableState);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, f, 1, (Object) null);
        composer.startReplaceGroup(1623171258);
        ComposerKt.sourceInformation(composer, str);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            final MutableState<String> mutableState14 = mutableState;
            rememberedValue3 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$14$lambda$5$lambda$4;
                    invoke$lambda$14$lambda$5$lambda$4 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$5$lambda$4(mutableState14, (String) obj);
                    return invoke$lambda$14$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        String str2 = str;
        UiState uiState3 = uiState;
        OutlinedTextFieldKt.OutlinedTextField(SessionsScreen$lambda$44, (Function1) rememberedValue3, fillMaxWidth$default, false, false, (TextStyle) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1444getLambda20$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8257464);
        SessionsScreen$lambda$47 = SessionsScreensKt.SessionsScreen$lambda$47(mutableState2);
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(1623180207);
        ComposerKt.sourceInformation(composer, str2);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            final MutableState<String> mutableState15 = mutableState2;
            final MutableState<Boolean> mutableState16 = mutableState3;
            rememberedValue4 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$14$lambda$7$lambda$6;
                    invoke$lambda$14$lambda$7$lambda$6 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$7$lambda$6(mutableState15, mutableState16, (String) obj);
                    return invoke$lambda$14$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        OutlinedTextFieldKt.OutlinedTextField(SessionsScreen$lambda$47, (Function1) rememberedValue4, fillMaxWidth$default2, false, false, (TextStyle) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1445getLambda21$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 12582912, 0, 8257464);
        composer.startReplaceGroup(1623187393);
        ComposerKt.sourceInformation(composer, "352@16604L24,352@16630L154,352@16583L201,355@16843L16,355@16871L17,355@16823L66");
        if (uiState3.getLocal()) {
            composer.startReplaceGroup(1623189094);
            ComposerKt.sourceInformation(composer, str2);
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                mutableState7 = mutableState4;
                rememberedValue5 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$14$lambda$9$lambda$8;
                        invoke$lambda$14$lambda$9$lambda$8 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$9$lambda$8(mutableState7);
                        return invoke$lambda$14$lambda$9$lambda$8;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            } else {
                mutableState7 = mutableState4;
            }
            composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) rememberedValue5, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-584737755, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$1$6
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer3, int i2) {
                    boolean SessionsScreen$lambda$532;
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation(composer3, "C353@16660L98:SessionsScreens.kt#qn8u0p");
                    if ((i2 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-584737755, i2, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:353)");
                    }
                    SessionsScreen$lambda$532 = SessionsScreensKt.SessionsScreen$lambda$53(mutableState7);
                    TextKt.Text-Nvy7gAk(SessionsScreen$lambda$532 ? "Do not copy from another project" : "Copy from another project (optional)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 805306374, 510);
            SessionsScreen$lambda$53 = SessionsScreensKt.SessionsScreen$lambda$53(mutableState7);
            if (SessionsScreen$lambda$53) {
                SessionsScreen$lambda$56 = SessionsScreensKt.SessionsScreen$lambda$56(mutableState5);
                composer.startReplaceGroup(1623196734);
                ComposerKt.sourceInformation(composer, str2);
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    final MutableState<String> mutableState17 = mutableState5;
                    rememberedValue6 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit invoke$lambda$14$lambda$11$lambda$10;
                            invoke$lambda$14$lambda$11$lambda$10 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$11$lambda$10(mutableState17, (String) obj);
                            return invoke$lambda$14$lambda$11$lambda$10;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                Function1 function1 = (Function1) rememberedValue6;
                composer.endReplaceGroup();
                SessionsScreen$lambda$59 = SessionsScreensKt.SessionsScreen$lambda$59(mutableState6);
                composer.startReplaceGroup(1623197631);
                ComposerKt.sourceInformation(composer, str2);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    final MutableState<String> mutableState18 = mutableState6;
                    rememberedValue7 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$7$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit invoke$lambda$14$lambda$13$lambda$12;
                            invoke$lambda$14$lambda$13$lambda$12 = SessionsScreensKt$SessionsScreen$7.invoke$lambda$14$lambda$13$lambda$12(mutableState18, (String) obj);
                            return invoke$lambda$14$lambda$13$lambda$12;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue7);
                }
                composer.endReplaceGroup();
                ChatExtrasKt.PortFields(SessionsScreen$lambda$56, function1, SessionsScreen$lambda$59, (Function1) rememberedValue7, composer, 3120);
            }
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$1$lambda$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch((Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$3$lambda$2(Context context) {
        ComponentsKt.openAllFilesAccess(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$5$lambda$4(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$7$lambda$6(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        SessionsScreensKt.SessionsScreen$lambda$51(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$9$lambda$8(MutableState mutableState) {
        boolean SessionsScreen$lambda$53;
        SessionsScreen$lambda$53 = SessionsScreensKt.SessionsScreen$lambda$53(mutableState);
        SessionsScreensKt.SessionsScreen$lambda$54(mutableState, !SessionsScreen$lambda$53);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$11$lambda$10(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$14$lambda$13$lambda$12(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }
}

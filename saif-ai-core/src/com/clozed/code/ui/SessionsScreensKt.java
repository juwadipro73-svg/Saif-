package com.clozed.code.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.material3.TopAppBarState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.SessionInfo;
import com.clozed.code.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SessionsScreens.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000f\u001aG\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003¢\u0006\u0002\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"SERVE_CMD", "", "ConnectScreen", "", "state", "Lcom/clozed/code/UiState;", "vm", "Lcom/clozed/code/AppViewModel;", "(Lcom/clozed/code/UiState;Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "NoteCard", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ErrorCard", "SessionsScreen", "StatusPill", "(Lcom/clozed/code/UiState;Landroidx/compose/runtime/Composer;I)V", "SessionRow", "s", "Lcom/clozed/code/data/SessionInfo;", "busy", "", "onOpen", "Lkotlin/Function0;", "onRename", "onDelete", "(Lcom/clozed/code/data/SessionInfo;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "KeyBanner", "onClick", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "local", "url", "pass", "dir", "showNew", "renaming", "deleting", "name", "nameTouched", "copyOpen", "portSrc", "portWhat", "title", "menu"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt {
    private static final String SERVE_CMD = "CLOZED_SERVER_PASSWORD=mypass clozed-code serve --port 4096";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$31(UiState uiState, AppViewModel appViewModel, int i, Composer composer, int i2) {
        ConnectScreen(uiState, appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorCard$lambda$33(String str, int i, Composer composer, int i2) {
        ErrorCard(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyBanner$lambda$80(Function0 function0, int i, Composer composer, int i2) {
        KeyBanner(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCard$lambda$32(String str, int i, Composer composer, int i2) {
        NoteCard(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SessionRow$lambda$79(SessionInfo sessionInfo, boolean z, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        SessionRow(sessionInfo, z, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SessionsScreen$lambda$74(UiState uiState, AppViewModel appViewModel, int i, Composer composer, int i2) {
        SessionsScreen(uiState, appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatusPill$lambda$75(UiState uiState, int i, Composer composer, int i2) {
        StatusPill(uiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ConnectScreen(final UiState state, final AppViewModel vm, Composer composer, final int i) {
        int i2;
        final AppViewModel appViewModel;
        final UiState uiState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(-1093391349);
        ComposerKt.sourceInformation(startRestartGroup, "C(ConnectScreen)95@4486L7,96@4521L11,97@4567L45,97@4550L62,98@4645L38,98@4628L55,99@4717L37,99@4700L54,100@4787L38,100@4770L55,108@5007L21,102@4831L4871:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(state) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(vm) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            uiState = state;
            appViewModel = vm;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1093391349, i2, -1, "com.clozed.code.ui.ConnectScreen (SessionsScreens.kt:94)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1341465212);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(vm);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ConnectScreen$lambda$1$lambda$0;
                        ConnectScreen$lambda$1$lambda$0 = SessionsScreensKt.ConnectScreen$lambda$1$lambda$0(AppViewModel.this);
                        return ConnectScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue, startRestartGroup, 0);
            Object[] objArr2 = new Object[0];
            startRestartGroup.startReplaceGroup(1341467701);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(vm);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ConnectScreen$lambda$5$lambda$4;
                        ConnectScreen$lambda$5$lambda$4 = SessionsScreensKt.ConnectScreen$lambda$5$lambda$4(AppViewModel.this);
                        return ConnectScreen$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) rememberedValue2, startRestartGroup, 0);
            Object[] objArr3 = new Object[0];
            startRestartGroup.startReplaceGroup(1341470004);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(vm);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ConnectScreen$lambda$9$lambda$8;
                        ConnectScreen$lambda$9$lambda$8 = SessionsScreensKt.ConnectScreen$lambda$9$lambda$8(AppViewModel.this);
                        return ConnectScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) rememberedValue3, startRestartGroup, 0);
            Object[] objArr4 = new Object[0];
            startRestartGroup.startReplaceGroup(1341472245);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(vm);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ConnectScreen$lambda$13$lambda$12;
                        ConnectScreen$lambda$13$lambda$12 = SessionsScreensKt.ConnectScreen$lambda$13$lambda$12(AppViewModel.this);
                        return ConnectScreen$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) rememberedValue4, startRestartGroup, 0);
            float f = 16;
            Modifier modifier = PaddingKt.padding-VpY3zN4(ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)))), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.m826constructorimpl(20), Dp.m826constructorimpl(f));
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 284571106, "C112@5165L30,113@5204L86,114@5299L376,119@5741L401,119@5685L457:SessionsScreens.kt#qn8u0p");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(f)), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -336788314, "C113@5272L16:SessionsScreens.kt#qn8u0p");
            LogoMotionKt.m1506LogoHeroorJrPs(Dp.m826constructorimpl(132), null, startRestartGroup, 6, 2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical vertical2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(vertical2, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -336608452, "C115@5489L10,115@5447L88,116@5615L10,116@5548L117:SessionsScreens.kt#qn8u0p");
            TextKt.Text-Nvy7gAk("Clozed Code", (Modifier) null, colorScheme.getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getDisplaySmall(), startRestartGroup, 6, 0, 131066);
            TextKt.Text-Nvy7gAk("AI coding agent, right on your phone", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyLarge(), startRestartGroup, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SegmentedButtonKt.SingleChoiceSegmentedButtonRow-uFdPcIQ(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ComposableLambdaKt.rememberComposableLambda(1276962080, true, new SessionsScreensKt$ConnectScreen$1$3(mutableState), startRestartGroup, 54), startRestartGroup, 390, 2);
            if (ConnectScreen$lambda$2(mutableState)) {
                startRestartGroup.startReplaceGroup(285466540);
                ComposerKt.sourceInformation(startRestartGroup, "131@6177L257,136@6511L12,135@6447L385,150@7291L24,153@7442L191,149@7257L376");
                NoteCard("The whole agent runs on this phone: tools, build/plan agents, permissions, sessions. You only need one provider API key (Anthropic, OpenAI, OpenRouter, Gemini, Groq, DeepSeek, Ollama… 200+).", startRestartGroup, 6);
                String ConnectScreen$lambda$14 = ConnectScreen$lambda$14(mutableState4);
                Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(9218266);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changed = startRestartGroup.changed(mutableState4);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ConnectScreen$lambda$30$lambda$19$lambda$18;
                            ConnectScreen$lambda$30$lambda$19$lambda$18 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$19$lambda$18(mutableState4, (String) obj);
                            return ConnectScreen$lambda$30$lambda$19$lambda$18;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(ConnectScreen$lambda$14, (Function1) rememberedValue5, fillMaxWidth$default3, false, false, (TextStyle) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1454getLambda3$app_release(), ComposableSingletons$SessionsScreensKt.INSTANCE.m1460getLambda4$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1461getLambda5$app_release(), false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, startRestartGroup, 14156160, 12583296, 0, 8253240);
                startRestartGroup = startRestartGroup;
                startRestartGroup.startReplaceGroup(9229281);
                ComposerKt.sourceInformation(startRestartGroup, "144@6980L27,144@7045L125,144@6952L218");
                if (Build.VERSION.SDK_INT >= 30) {
                    final boolean hasAllFilesAccess = ComponentsKt.hasAllFilesAccess();
                    startRestartGroup.startReplaceGroup(9233289);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                    boolean changedInstance5 = startRestartGroup.changedInstance(context);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ConnectScreen$lambda$30$lambda$21$lambda$20;
                                ConnectScreen$lambda$30$lambda$21$lambda$20 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$21$lambda$20(context);
                                return ConnectScreen$lambda$30$lambda$21$lambda$20;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    ButtonKt.FilledTonalButton((Function0) rememberedValue6, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-2122256883, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$ConnectScreen$1$6
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                            invoke(rowScope, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope FilledTonalButton, Composer composer5, int i3) {
                            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
                            ComposerKt.sourceInformation(composer5, "C145@7067L85:SessionsScreens.kt#qn8u0p");
                            if ((i3 & 17) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2122256883, i3, -1, "com.clozed.code.ui.ConnectScreen.<anonymous>.<anonymous> (SessionsScreens.kt:145)");
                            }
                            TextKt.Text-Nvy7gAk(hasAllFilesAccess ? "Storage access: ON ✓" : "Grant storage access (for shared folders)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 0, 0, 262142);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 805306416, 508);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(9240253);
                ComposerKt.sourceInformation(startRestartGroup, "148@7222L22");
                if (state.getError() != null) {
                    ErrorCard(state.getError(), startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                boolean z = !state.getConnecting();
                Modifier modifier2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m826constructorimpl(56));
                startRestartGroup.startReplaceGroup(9243238);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                appViewModel = vm;
                boolean changedInstance6 = startRestartGroup.changedInstance(appViewModel) | startRestartGroup.changed(mutableState4);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance6 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ConnectScreen$lambda$30$lambda$23$lambda$22;
                            ConnectScreen$lambda$30$lambda$23$lambda$22 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$23$lambda$22(AppViewModel.this, mutableState4);
                            return ConnectScreen$lambda$30$lambda$23$lambda$22;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceGroup();
                uiState = state;
                ButtonKt.Button((Function0) rememberedValue7, modifier2, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-478021782, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$ConnectScreen$1$8
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                        invoke(rowScope, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer5, int i3) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation(composer5, "C:SessionsScreens.kt#qn8u0p");
                        if ((i3 & 17) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-478021782, i3, -1, "com.clozed.code.ui.ConnectScreen.<anonymous>.<anonymous> (SessionsScreens.kt:154)");
                        }
                        if (UiState.this.getConnecting()) {
                            composer5.startReplaceGroup(-334593329);
                            ComposerKt.sourceInformation(composer5, "154@7576L7,154@7482L102");
                            Modifier modifier3 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(20));
                            float m826constructorimpl = Dp.m826constructorimpl(2);
                            CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = composer5.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(modifier3, ((Color) consume2).unbox-impl(), m826constructorimpl, 0L, 0, 0.0f, composer5, 390, 56);
                            composer5.endReplaceGroup();
                        } else {
                            composer5.startReplaceGroup(266305210);
                            ComposerKt.sourceInformation(composer5, "155@7606L13");
                            TextKt.Text-Nvy7gAk("Start", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 6, 0, 262142);
                            composer5.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 805306416, 504);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(286958229);
                ComposerKt.sourceInformation(startRestartGroup, "159@7727L12,158@7663L294,165@8035L13,164@7970L370,173@8447L30,176@8604L193,172@8413L384,181@8854L51,183@8973L713,180@8810L876");
                String ConnectScreen$lambda$6 = ConnectScreen$lambda$6(mutableState2);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m520getUriPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(9257178);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(mutableState2);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ConnectScreen$lambda$30$lambda$25$lambda$24;
                            ConnectScreen$lambda$30$lambda$25$lambda$24 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$25$lambda$24(mutableState2, (String) obj);
                            return ConnectScreen$lambda$30$lambda$25$lambda$24;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                startRestartGroup.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(ConnectScreen$lambda$6, (Function1) rememberedValue8, fillMaxWidth$default4, false, false, (TextStyle) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1462getLambda6$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, startRestartGroup, 1573248, 12779520, 0, 8224696);
                String ConnectScreen$lambda$10 = ConnectScreen$lambda$10(mutableState3);
                PasswordVisualTransformation passwordVisualTransformation = new PasswordVisualTransformation((char) 0, 1, null);
                Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(9267035);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed(mutableState3);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ConnectScreen$lambda$30$lambda$27$lambda$26;
                            ConnectScreen$lambda$30$lambda$27$lambda$26 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$27$lambda$26(mutableState3, (String) obj);
                            return ConnectScreen$lambda$30$lambda$27$lambda$26;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                startRestartGroup.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(ConnectScreen$lambda$10, (Function1) rememberedValue9, fillMaxWidth$default5, false, false, (TextStyle) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1463getLambda7$app_release(), (Function2) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1464getLambda8$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, passwordVisualTransformation, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, startRestartGroup, 102236544, 12582912, 0, 8240824);
                startRestartGroup.startReplaceGroup(9277245);
                ComposerKt.sourceInformation(startRestartGroup, "171@8378L22");
                if (state.getError() != null) {
                    ErrorCard(state.getError(), startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                boolean z2 = !state.getConnecting();
                Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m826constructorimpl(56));
                startRestartGroup.startReplaceGroup(9280236);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                appViewModel = vm;
                boolean changedInstance7 = startRestartGroup.changedInstance(appViewModel) | startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState3) | startRestartGroup.changed(mutableState4);
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (changedInstance7 || rememberedValue10 == Composer.Companion.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ConnectScreen$lambda$30$lambda$29$lambda$28;
                            ConnectScreen$lambda$30$lambda$29$lambda$28 = SessionsScreensKt.ConnectScreen$lambda$30$lambda$29$lambda$28(AppViewModel.this, mutableState2, mutableState3, mutableState4);
                            return ConnectScreen$lambda$30$lambda$29$lambda$28;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                startRestartGroup.endReplaceGroup();
                uiState = state;
                ButtonKt.Button((Function0) rememberedValue10, modifier3, z2, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1688804161, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$ConnectScreen$1$12
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                        invoke(rowScope, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer5, int i3) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation(composer5, "C:SessionsScreens.kt#qn8u0p");
                        if ((i3 & 17) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1688804161, i3, -1, "com.clozed.code.ui.ConnectScreen.<anonymous>.<anonymous> (SessionsScreens.kt:177)");
                        }
                        if (UiState.this.getConnecting()) {
                            composer5.startReplaceGroup(-333440625);
                            ComposerKt.sourceInformation(composer5, "177@8738L7,177@8644L102");
                            Modifier modifier4 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(20));
                            float m826constructorimpl = Dp.m826constructorimpl(2);
                            CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = composer5.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(modifier4, ((Color) consume2).unbox-impl(), m826constructorimpl, 0L, 0, 0.0f, composer5, 390, 56);
                            composer5.endReplaceGroup();
                        } else {
                            composer5.startReplaceGroup(266342396);
                            ComposerKt.sourceInformation(composer5, "178@8768L15");
                            TextKt.Text-Nvy7gAk("Connect", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 6, 0, 262142);
                            composer5.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 805306416, 504);
                CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(colorScheme.getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14);
                startRestartGroup = startRestartGroup;
                CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, cardColors, (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2070290689, true, new SessionsScreensKt$ConnectScreen$1$13(colorScheme, context), startRestartGroup, 54), startRestartGroup, 196614, 26);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConnectScreen$lambda$31;
                    ConnectScreen$lambda$31 = SessionsScreensKt.ConnectScreen$lambda$31(UiState.this, appViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConnectScreen$lambda$31;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConnectScreen$lambda$1$lambda$0(AppViewModel appViewModel) {
        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!Intrinsics.areEqual(appViewModel.getPrefs().getMode(), "remote")), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ConnectScreen$lambda$2(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ConnectScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConnectScreen$lambda$5$lambda$4(AppViewModel appViewModel) {
        return SnapshotStateKt.mutableStateOf$default(appViewModel.getPrefs().getServerUrl(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final String ConnectScreen$lambda$6(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String ConnectScreen$lambda$10(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConnectScreen$lambda$9$lambda$8(AppViewModel appViewModel) {
        return SnapshotStateKt.mutableStateOf$default(appViewModel.getPrefs().getPassword(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConnectScreen$lambda$13$lambda$12(AppViewModel appViewModel) {
        return SnapshotStateKt.mutableStateOf$default(appViewModel.getPrefs().getDirectory(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final String ConnectScreen$lambda$14(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$19$lambda$18(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$21$lambda$20(Context context) {
        ComponentsKt.openAllFilesAccess(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$23$lambda$22(AppViewModel appViewModel, MutableState mutableState) {
        appViewModel.connectLocal(ConnectScreen$lambda$14(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$25$lambda$24(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$27$lambda$26(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectScreen$lambda$30$lambda$29$lambda$28(AppViewModel appViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        appViewModel.connect(ConnectScreen$lambda$6(mutableState), ConnectScreen$lambda$10(mutableState2), ConnectScreen$lambda$14(mutableState3));
        return Unit.INSTANCE;
    }

    private static final void NoteCard(final String str, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1549174626);
        ComposerKt.sourceInformation(startRestartGroup, "C(NoteCard)204@9841L11,205@9910L11,207@9994L242,202@9759L477:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1549174626, i2, -1, "com.clozed.code.ui.NoteCard (SessionsScreens.kt:201)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(2014638397, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$NoteCard$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C208@10004L226:SessionsScreens.kt#qn8u0p");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2014638397, i3, -1, "com.clozed.code.ui.NoteCard.<anonymous> (SessionsScreens.kt:208)");
                    }
                    Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(14));
                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
                    String str2 = str;
                    ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), composer2, 6);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
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
                    Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer3.updateRememberedValue(Integer.valueOf(hashCode));
                        composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1158025060, "C209@10100L52,210@10198L10,210@10165L55:SessionsScreens.kt#qn8u0p");
                    IconKt.Icon-ww6aTOc(InfoKt.getInfo(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(20)), 0L, composer2, 432, 8);
                    TextKt.Text-Nvy7gAk(str2, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 131070);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 12582918, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoteCard$lambda$32;
                    NoteCard$lambda$32 = SessionsScreensKt.NoteCard$lambda$32(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NoteCard$lambda$32;
                }
            });
        }
    }

    private static final void ErrorCard(final String str, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2014676904);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorCard)219@10376L11,220@10441L11,222@10521L245,217@10294L472:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2014676904, i2, -1, "com.clozed.code.ui.ErrorCard (SessionsScreens.kt:216)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getErrorContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-735815379, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$ErrorCard$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C223@10531L229:SessionsScreens.kt#qn8u0p");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-735815379, i3, -1, "com.clozed.code.ui.ErrorCard.<anonymous> (SessionsScreens.kt:223)");
                    }
                    Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(14));
                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
                    String str2 = str;
                    ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), composer2, 6);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
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
                    Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer3.updateRememberedValue(Integer.valueOf(hashCode));
                        composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1815683897, "C224@10627L55,225@10728L10,225@10695L55:SessionsScreens.kt#qn8u0p");
                    IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(20)), 0L, composer2, 432, 8);
                    TextKt.Text-Nvy7gAk(str2, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 131070);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 12582918, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorCard$lambda$33;
                    ErrorCard$lambda$33 = SessionsScreensKt.ErrorCard$lambda$33(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorCard$lambda$33;
                }
            });
        }
    }

    public static final void SessionsScreen(UiState uiState, AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        String str;
        Composer composer2;
        final UiState state = uiState;
        final AppViewModel vm = appViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(-428313252);
        ComposerKt.sourceInformation(startRestartGroup, "C(SessionsScreen)235@10976L34,236@11031L47,237@11099L47,238@11182L34,243@11401L11,244@11442L879,263@12354L219,270@12581L1595,241@11279L2897,*383@17987L19,387@18180L193,392@18403L64,386@18133L17,382@17943L535:SessionsScreens.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(vm) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-428313252, i2, -1, "com.clozed.code.ui.SessionsScreen (SessionsScreens.kt:234)");
            }
            startRestartGroup.startReplaceGroup(-1110468238);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1110466465);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1110464289);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior((TopAppBarState) null, (Function0) null, (AnimationSpec) null, (DecayAnimationSpec) null, startRestartGroup, TopAppBarDefaults.$stable << 12, 15);
            int i4 = 54;
            ScaffoldKt.Scaffold-TvnljyQ(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, exitUntilCollapsedScrollBehavior.getNestedScrollConnection(), (NestedScrollDispatcher) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(-1882014432, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    ComposerKt.sourceInformation(composer3, "C258@12166L11,259@12249L11,257@12098L198,252@11774L238,245@11456L855:SessionsScreens.kt#qn8u0p");
                    if ((i5 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1882014432, i5, -1, "com.clozed.code.ui.SessionsScreen.<anonymous> (SessionsScreens.kt:245)");
                        }
                        AppBarKt.LargeTopAppBar-oKE7A98(ComposableSingletons$SessionsScreensKt.INSTANCE.m1433getLambda10$app_release(), (Modifier) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1203864636, true, new AnonymousClass1(vm), composer3, 54), 0.0f, 0.0f, (WindowInsets) null, TopAppBarDefaults.INSTANCE.topAppBarColors-5tl4gsc(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getBackground-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceContainer-0d7_KjU(), 0L, 0L, 0L, 0L, composer3, TopAppBarDefaults.$stable << 18, 60), exitUntilCollapsedScrollBehavior, composer3, 3078, 118);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SessionsScreens.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1, reason: invalid class name */
                /* loaded from: /tmp/classes3.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ AppViewModel $vm;

                    AnonymousClass1(AppViewModel appViewModel) {
                        this.$vm = appViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel) {
                        appViewModel.refreshSessions();
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope LargeTopAppBar, Composer composer, int i) {
                        Intrinsics.checkNotNullParameter(LargeTopAppBar, "$this$LargeTopAppBar");
                        ComposerKt.sourceInformation(composer, "C253@11817L24,253@11796L89,254@11927L21,254@11906L88:SessionsScreens.kt#qn8u0p");
                        if ((i & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1203864636, i, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:253)");
                        }
                        composer.startReplaceGroup(1623035910);
                        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(this.$vm);
                        final AppViewModel appViewModel = this.$vm;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: CONSTRUCTOR (r2v2 'rememberedValue' java.lang.Object) = (r1v4 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:254) call: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                java.lang.String r1 = "$this$LargeTopAppBar"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                                java.lang.String r1 = "C253@11817L24,253@11796L89,254@11927L21,254@11906L88:SessionsScreens.kt#qn8u0p"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
                                r1 = r14 & 17
                                r2 = 16
                                if (r1 != r2) goto L1b
                                boolean r1 = r13.getSkipping()
                                if (r1 != 0) goto L17
                                goto L1b
                            L17:
                                r13.skipToGroupEnd()
                                return
                            L1b:
                                boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r1 == 0) goto L2a
                                r1 = -1
                                java.lang.String r2 = "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:253)"
                                r3 = -1203864636(0xffffffffb83e7bc4, float:-4.5414796E-5)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r1, r2)
                            L2a:
                                r0 = 1623035910(0x60bd9006, float:1.0927539E20)
                                r13.startReplaceGroup(r0)
                                java.lang.String r10 = "CC(remember):SessionsScreens.kt#9igjgp"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
                                com.clozed.code.AppViewModel r0 = r11.$vm
                                boolean r0 = r13.changedInstance(r0)
                                com.clozed.code.AppViewModel r1 = r11.$vm
                                java.lang.Object r2 = r13.rememberedValue()
                                if (r0 != 0) goto L4b
                                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                                java.lang.Object r0 = r0.getEmpty()
                                if (r2 != r0) goto L53
                            L4b:
                                com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda0 r2 = new com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda0
                                r2.<init>(r1)
                                r13.updateRememberedValue(r2)
                            L53:
                                r0 = r2
                                kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                                r13.endReplaceGroup()
                                com.clozed.code.ui.ComposableSingletons$SessionsScreensKt r1 = com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.INSTANCE
                                kotlin.jvm.functions.Function2 r6 = r1.m1434getLambda11$app_release()
                                r8 = 1572864(0x180000, float:2.204052E-39)
                                r9 = 62
                                r1 = 0
                                r2 = 0
                                r3 = 0
                                r4 = 0
                                r5 = 0
                                r7 = r13
                                androidx.compose.material3.IconButtonKt.IconButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                                r0 = 1623039427(0x60bd9dc3, float:1.0930633E20)
                                r13.startReplaceGroup(r0)
                                androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
                                com.clozed.code.AppViewModel r0 = r11.$vm
                                boolean r0 = r13.changedInstance(r0)
                                com.clozed.code.AppViewModel r1 = r11.$vm
                                java.lang.Object r2 = r13.rememberedValue()
                                if (r0 != 0) goto L8b
                                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                                java.lang.Object r0 = r0.getEmpty()
                                if (r2 != r0) goto L93
                            L8b:
                                com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda1 r2 = new com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1$1$$ExternalSyntheticLambda1
                                r2.<init>(r1)
                                r13.updateRememberedValue(r2)
                            L93:
                                r0 = r2
                                kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                                r13.endReplaceGroup()
                                com.clozed.code.ui.ComposableSingletons$SessionsScreensKt r1 = com.clozed.code.ui.ComposableSingletons$SessionsScreensKt.INSTANCE
                                kotlin.jvm.functions.Function2 r6 = r1.m1435getLambda12$app_release()
                                r8 = 1572864(0x180000, float:2.204052E-39)
                                r9 = 62
                                r1 = 0
                                r2 = 0
                                r3 = 0
                                r4 = 0
                                r5 = 0
                                r7 = r13
                                androidx.compose.material3.IconButtonKt.IconButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto Lb5
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            Lb5:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$3$lambda$2(AppViewModel appViewModel) {
                            appViewModel.openSettings();
                            return Unit.INSTANCE;
                        }
                    }
                }, startRestartGroup, 54), (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1347645795, true, new SessionsScreensKt$SessionsScreen$2(mutableState), startRestartGroup, 54), 0, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getBackground-0d7_KjU(), 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1072315435, true, new SessionsScreensKt$SessionsScreen$3(state, state.getLocal() && state.getModels().isEmpty(), vm, mutableState2, mutableState3), startRestartGroup, 54), startRestartGroup, 805330992, 428);
                Composer composer3 = startRestartGroup;
                composer3.startReplaceGroup(-1110362565);
                ComposerKt.sourceInformation(composer3, "309@14216L47,310@14284L31,311@14343L34,312@14402L34,313@14460L31,314@14516L31,315@14580L7,316@14687L437,316@14609L515,328@15177L19,359@16973L213,365@17216L64,330@15262L1681,327@15133L2158");
                if (SessionsScreen$lambda$35(mutableState)) {
                    composer3.startReplaceGroup(-1110364545);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = SnapshotStateKt.mutableStateOf$default(appViewModel.getPrefs().getDirectory(), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    final MutableState mutableState4 = (MutableState) rememberedValue4;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1110362385);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue5 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    final MutableState mutableState5 = (MutableState) rememberedValue5;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1110360494);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        rememberedValue6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    final MutableState mutableState6 = (MutableState) rememberedValue6;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1110358606);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue7 = composer3.rememberedValue();
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        rememberedValue7 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    MutableState mutableState7 = (MutableState) rememberedValue7;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1110356753);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue8 = composer3.rememberedValue();
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        rememberedValue8 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue8);
                    }
                    MutableState mutableState8 = (MutableState) rememberedValue8;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-1110354961);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue9 = composer3.rememberedValue();
                    if (rememberedValue9 == Composer.Companion.getEmpty()) {
                        rememberedValue9 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer3.updateRememberedValue(rememberedValue9);
                    }
                    MutableState mutableState9 = (MutableState) rememberedValue9;
                    composer3.endReplaceGroup();
                    CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = composer3.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final Context context = (Context) consume;
                    ActivityResultContract openDocumentTree = new ActivityResultContracts.OpenDocumentTree();
                    composer3.startReplaceGroup(-1110349083);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    boolean changedInstance = composer3.changedInstance(context);
                    Object rememberedValue10 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue10 == Composer.Companion.getEmpty()) {
                        rememberedValue10 = new Function1() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SessionsScreen$lambda$62$lambda$61;
                                SessionsScreen$lambda$62$lambda$61 = SessionsScreensKt.SessionsScreen$lambda$62$lambda$61(context, mutableState4, mutableState6, mutableState5, (Uri) obj);
                                return SessionsScreen$lambda$62$lambda$61;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue10);
                    }
                    composer3.endReplaceGroup();
                    ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocumentTree, (Function1) rememberedValue10, composer3, 0);
                    composer3.startReplaceGroup(-1110333821);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SessionsScreens.kt#9igjgp");
                    Object rememberedValue11 = composer3.rememberedValue();
                    if (rememberedValue11 == Composer.Companion.getEmpty()) {
                        rememberedValue11 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SessionsScreen$lambda$64$lambda$63;
                                SessionsScreen$lambda$64$lambda$63 = SessionsScreensKt.SessionsScreen$lambda$64$lambda$63(mutableState);
                                return SessionsScreen$lambda$64$lambda$63;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue11);
                    }
                    Function0 function0 = (Function0) rememberedValue11;
                    composer3.endReplaceGroup();
                    Function2 rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1210053167, true, new SessionsScreensKt$SessionsScreen$5(appViewModel, mutableState, mutableState4, mutableState5, mutableState7, mutableState8, mutableState9), composer3, 54);
                    Function2 rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(117417965, true, new SessionsScreensKt$SessionsScreen$6(mutableState), composer3, 54);
                    Function2<Composer, Integer, Unit> m1440getLambda17$app_release = ComposableSingletons$SessionsScreensKt.INSTANCE.m1440getLambda17$app_release();
                    state = uiState;
                    Function2 rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(625948810, true, new SessionsScreensKt$SessionsScreen$7(state, rememberLauncherForActivityResult, context, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9), composer3, 54);
                    str = "CC(remember):SessionsScreens.kt#9igjgp";
                    i4 = 54;
                    i3 = 2;
                    mutableState2 = mutableState2;
                    mutableState3 = mutableState3;
                    z = true;
                    vm = appViewModel;
                    AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, rememberComposableLambda, (Modifier) null, rememberComposableLambda2, (Function2) null, m1440getLambda17$app_release, rememberComposableLambda3, (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer3, 1772598, 0, 16276);
                    composer3 = composer3;
                } else {
                    vm = appViewModel;
                    z = true;
                    i3 = 2;
                    str = "CC(remember):SessionsScreens.kt#9igjgp";
                    state = uiState;
                }
                composer3.endReplaceGroup();
                SessionInfo SessionsScreen$lambda$38 = SessionsScreen$lambda$38(mutableState2);
                composer3.startReplaceGroup(-1110264893);
                ComposerKt.sourceInformation(composer3, "*370@17345L42,372@17440L19,376@17704L93,377@17827L64,375@17575L99,371@17396L506");
                if (SessionsScreen$lambda$38 != null) {
                    String id = SessionsScreen$lambda$38.getId();
                    composer3.startReplaceGroup(-2042986599);
                    ComposerKt.sourceInformation(composer3, str);
                    boolean changed = composer3.changed(id);
                    Object rememberedValue12 = composer3.rememberedValue();
                    if (changed || rememberedValue12 == Composer.Companion.getEmpty()) {
                        rememberedValue12 = SnapshotStateKt.mutableStateOf$default(SessionsScreen$lambda$38.getTitle(), (SnapshotMutationPolicy) null, i3, (Object) null);
                        composer3.updateRememberedValue(rememberedValue12);
                    }
                    MutableState mutableState10 = (MutableState) rememberedValue12;
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(-2042983582);
                    ComposerKt.sourceInformation(composer3, str);
                    Object rememberedValue13 = composer3.rememberedValue();
                    if (rememberedValue13 == Composer.Companion.getEmpty()) {
                        rememberedValue13 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SessionsScreen$lambda$70$lambda$69$lambda$68;
                                SessionsScreen$lambda$70$lambda$69$lambda$68 = SessionsScreensKt.SessionsScreen$lambda$70$lambda$69$lambda$68(mutableState2);
                                return SessionsScreen$lambda$70$lambda$69$lambda$68;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue13);
                    }
                    composer3.endReplaceGroup();
                    Composer composer4 = composer3;
                    AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue13, ComposableLambdaKt.rememberComposableLambda(5548691, z, new SessionsScreensKt$SessionsScreen$8$2(vm, SessionsScreen$lambda$38, mutableState10, mutableState2), composer3, i4), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-684282799, z, new SessionsScreensKt$SessionsScreen$8$3(mutableState2), composer3, i4), ComposableSingletons$SessionsScreensKt.INSTANCE.m1448getLambda24$app_release(), ComposableSingletons$SessionsScreensKt.INSTANCE.m1449getLambda25$app_release(), ComposableLambdaKt.rememberComposableLambda(-1719030034, z, new SessionsScreensKt$SessionsScreen$8$4(mutableState10), composer3, i4), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer4, 1797174, 0, 16260);
                    composer3 = composer4;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer3.endReplaceGroup();
                final SessionInfo SessionsScreen$lambda$41 = SessionsScreen$lambda$41(mutableState3);
                if (SessionsScreen$lambda$41 == null) {
                    composer2 = composer3;
                } else {
                    composer3.startReplaceGroup(-2042966078);
                    ComposerKt.sourceInformation(composer3, str);
                    Object rememberedValue14 = composer3.rememberedValue();
                    if (rememberedValue14 == Composer.Companion.getEmpty()) {
                        rememberedValue14 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SessionsScreen$lambda$73$lambda$72$lambda$71;
                                SessionsScreen$lambda$73$lambda$72$lambda$71 = SessionsScreensKt.SessionsScreen$lambda$73$lambda$72$lambda$71(mutableState3);
                                return SessionsScreen$lambda$73$lambda$72$lambda$71;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue14);
                    }
                    composer3.endReplaceGroup();
                    composer2 = composer3;
                    AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue14, ComposableLambdaKt.rememberComposableLambda(-1254131766, z, new SessionsScreensKt$SessionsScreen$9$2(vm, SessionsScreen$lambda$41, mutableState3), composer3, i4), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(1537737224, z, new SessionsScreensKt$SessionsScreen$9$3(mutableState3), composer3, i4), ComposableSingletons$SessionsScreensKt.INSTANCE.m1452getLambda28$app_release(), ComposableSingletons$SessionsScreensKt.INSTANCE.m1453getLambda29$app_release(), ComposableLambdaKt.rememberComposableLambda(-716910235, z, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionsScreen$9$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i5) {
                            ComposerKt.sourceInformation(composer5, "C386@18135L13:SessionsScreens.kt#qn8u0p");
                            if ((i5 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-716910235, i5, -1, "com.clozed.code.ui.SessionsScreen.<anonymous>.<anonymous> (SessionsScreens.kt:386)");
                            }
                            TextKt.Text-Nvy7gAk(SessionInfo.this.getTitle(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 0, 0, 262142);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, i4), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1797174, 0, 16260);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SessionsScreen$lambda$74;
                        SessionsScreen$lambda$74 = SessionsScreensKt.SessionsScreen$lambda$74(UiState.this, vm, i, (Composer) obj, ((Integer) obj2).intValue());
                        return SessionsScreen$lambda$74;
                    }
                });
            }
        }

        private static final boolean SessionsScreen$lambda$35(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SessionsScreen$lambda$36(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        private static final SessionInfo SessionsScreen$lambda$38(MutableState<SessionInfo> mutableState) {
            return (SessionInfo) ((State) mutableState).getValue();
        }

        private static final SessionInfo SessionsScreen$lambda$41(MutableState<SessionInfo> mutableState) {
            return (SessionInfo) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SessionsScreen$lambda$44(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SessionsScreen$lambda$47(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        private static final boolean SessionsScreen$lambda$50(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SessionsScreen$lambda$51(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean SessionsScreen$lambda$53(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SessionsScreen$lambda$54(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SessionsScreen$lambda$56(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SessionsScreen$lambda$59(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SessionsScreen$lambda$62$lambda$61(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Uri uri) {
            if (uri != null) {
                String treeUriToPath = FolderPickerKt.treeUriToPath(uri);
                if (treeUriToPath == null) {
                    Toast.makeText(context, "Could not use this folder. Pick a folder on internal storage or SD card.", 1).show();
                } else {
                    mutableState.setValue(treeUriToPath);
                    if (!SessionsScreen$lambda$50(mutableState2)) {
                        mutableState3.setValue(StringsKt.substringAfterLast$default(StringsKt.trimEnd(treeUriToPath, '/'), '/', (String) null, 2, (Object) null));
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SessionsScreen$lambda$64$lambda$63(MutableState mutableState) {
            SessionsScreen$lambda$36(mutableState, false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SessionsScreen$lambda$70$lambda$66(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SessionsScreen$lambda$70$lambda$69$lambda$68(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SessionsScreen$lambda$73$lambda$72$lambda$71(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void StatusPill(final UiState uiState, Composer composer, final int i) {
            int i2;
            final long m1575getWarning0d7_KjU;
            Composer startRestartGroup = composer.startRestartGroup(-1035067673);
            ComposerKt.sourceInformation(startRestartGroup, "C(StatusPill)402@18704L11,403@18744L517,400@18636L625:SessionsScreens.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(uiState) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035067673, i2, -1, "com.clozed.code.ui.StatusPill (SessionsScreens.kt:398)");
                }
                if (uiState.getLive()) {
                    startRestartGroup.startReplaceGroup(-1528924903);
                    ComposerKt.sourceInformation(startRestartGroup, "399@18585L5");
                    m1575getWarning0d7_KjU = ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable).m1573getSuccess0d7_KjU();
                } else {
                    startRestartGroup.startReplaceGroup(-1528923847);
                    ComposerKt.sourceInformation(startRestartGroup, "399@18618L5");
                    m1575getWarning0d7_KjU = ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable).m1575getWarning0d7_KjU();
                }
                startRestartGroup.endReplaceGroup();
                SurfaceKt.Surface-T9BRK9s((Modifier) null, RoundedCornerShapeKt.getCircleShape(), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceContainerHigh-0d7_KjU(), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1441702700, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$StatusPill$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        String str;
                        ComposerKt.sourceInformation(composer2, "C404@18754L501:SessionsScreens.kt#qn8u0p");
                        if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1441702700, i3, -1, "com.clozed.code.ui.StatusPill.<anonymous> (SessionsScreens.kt:404)");
                            }
                            Modifier modifier = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.m826constructorimpl(12), Dp.m826constructorimpl(6));
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            long j = m1575getWarning0d7_KjU;
                            UiState uiState2 = uiState;
                            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
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
                            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                            }
                            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1695740223, "C405@18875L58,406@18946L27,409@19140L10,410@19202L11,407@18986L259:SessionsScreens.kt#qn8u0p");
                            float f = 8;
                            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), j, (Shape) null, 2, (Object) null), composer2, 0);
                            SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(f)), composer2, 6);
                            String str2 = uiState2.getLive() ? "live" : "connecting…";
                            String serverVersion = uiState2.getServerVersion();
                            if (serverVersion == null || (str = " · v" + serverVersion) == null) {
                                str = "";
                            }
                            TextKt.Text-Nvy7gAk(str2 + str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, 12582912, 121);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit StatusPill$lambda$75;
                        StatusPill$lambda$75 = SessionsScreensKt.StatusPill$lambda$75(UiState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                        return StatusPill$lambda$75;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SessionRow(final SessionInfo sessionInfo, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i) {
            int i2;
            float m826constructorimpl;
            long j;
            Composer composer2;
            Composer startRestartGroup = composer.startRestartGroup(-218641017);
            ComposerKt.sourceInformation(startRestartGroup, "C(SessionRow)P(4!1,2,3)418@19413L34,419@19475L11,422@19553L51,425@19777L1895,420@19491L2181:SessionsScreens.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changed(sessionInfo) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changed(z) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
            }
            if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-218641017, i2, -1, "com.clozed.code.ui.SessionRow (SessionsScreens.kt:417)");
                }
                startRestartGroup.startReplaceGroup(69577933);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SessionsScreens.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(colorScheme.getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14);
                if (z) {
                    m826constructorimpl = Dp.m826constructorimpl(1);
                    j = Color.copy-wmQWz5c$default(colorScheme.getPrimary-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    m826constructorimpl = Dp.m826constructorimpl(1);
                    j = colorScheme.getOutlineVariant-0d7_KjU();
                }
                composer2 = startRestartGroup;
                CardKt.Card(function0, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, cardColors, (CardElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(m826constructorimpl, j), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-608926094, true, new SessionsScreensKt$SessionRow$1(sessionInfo, z, colorScheme, mutableState, function02, function03), startRestartGroup, 54), composer2, ((i2 >> 6) & 14) | 100663344, 172);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SessionRow$lambda$79;
                        SessionRow$lambda$79 = SessionsScreensKt.SessionRow$lambda$79(SessionInfo.this, z, function0, function02, function03, i, (Composer) obj, ((Integer) obj2).intValue());
                        return SessionRow$lambda$79;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean SessionRow$lambda$77(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SessionRow$lambda$78(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void KeyBanner(Function0<Unit> function0, Composer composer, final int i) {
            int i2;
            final Function0<Unit> function02;
            Composer startRestartGroup = composer.startRestartGroup(1068037926);
            ComposerKt.sourceInformation(startRestartGroup, "C(KeyBanner)467@21855L11,468@21927L11,466@21800L169,464@21737L867:SessionsScreens.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1068037926, i2, -1, "com.clozed.code.ui.KeyBanner (SessionsScreens.kt:463)");
                }
                function02 = function0;
                CardKt.Card(function02, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 12), (CardElevation) null, (BorderStroke) null, (MutableInteractionSource) null, ComposableSingletons$SessionsScreensKt.INSTANCE.m1459getLambda34$app_release(), startRestartGroup, (i2 & 14) | 100663344, 236);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                function02 = function0;
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SessionsScreensKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit KeyBanner$lambda$80;
                        KeyBanner$lambda$80 = SessionsScreensKt.KeyBanner$lambda$80(Function0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                        return KeyBanner$lambda$80;
                    }
                });
            }
        }
    }

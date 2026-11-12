package com.clozed.code;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.clozed.code.ui.ChatScreenKt;
import com.clozed.code.ui.SessionsScreensKt;
import com.clozed.code.ui.SettingsScreenKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"AppRoot", "", "vm", "Lcom/clozed/code/AppViewModel;", "(Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "app_release", "state", "Lcom/clozed/code/UiState;"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class MainActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppRoot$lambda$4(AppViewModel appViewModel, int i, Composer composer, int i2) {
        AppRoot(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AppRoot(final AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(190467563);
        ComposerKt.sourceInformation(startRestartGroup, "C(AppRoot)131@5049L16,132@5085L32,134@5231L29,136@5296L116,136@5266L146,143@5418L614:MainActivity.kt#shl86d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(appViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(190467563, i2, -1, "com.clozed.code.AppRoot (MainActivity.kt:130)");
            }
            final State collectAsState = SnapshotStateKt.collectAsState(appViewModel.getState(), (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(-452684368);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
            String message = AppRoot$lambda$0(collectAsState).getMessage();
            startRestartGroup.startReplaceGroup(-452677532);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):MainActivity.kt#9igjgp");
            boolean changed = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(appViewModel);
            MainActivityKt$AppRoot$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainActivityKt$AppRoot$1$1(collectAsState, snackbarHostState, appViewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(message, (Function2) rememberedValue2, startRestartGroup, 0);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
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
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1905433350, "C145@5590L293,145@5563L320,153@5892L134:MainActivity.kt#shl86d");
            rememberSaveableStateHolder.SaveableStateProvider(AppRoot$lambda$0(collectAsState).getScreen() == Screen.Chat ? "chat-" + AppRoot$lambda$0(collectAsState).getCurrentId() : AppRoot$lambda$0(collectAsState).getScreen().name(), ComposableLambdaKt.rememberComposableLambda(1250454598, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.MainActivityKt$AppRoot$2$1

                /* compiled from: MainActivity.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* loaded from: /tmp/classes3.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Screen.values().length];
                        try {
                            iArr[Screen.Connect.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[Screen.Sessions.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[Screen.Chat.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[Screen.Settings.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    UiState AppRoot$lambda$0;
                    UiState AppRoot$lambda$02;
                    UiState AppRoot$lambda$03;
                    UiState AppRoot$lambda$04;
                    UiState AppRoot$lambda$05;
                    ComposerKt.sourceInformation(composer3, "C:MainActivity.kt#shl86d");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1250454598, i3, -1, "com.clozed.code.AppRoot.<anonymous>.<anonymous> (MainActivity.kt:146)");
                    }
                    AppRoot$lambda$0 = MainActivityKt.AppRoot$lambda$0(collectAsState);
                    int i4 = WhenMappings.$EnumSwitchMapping$0[AppRoot$lambda$0.getScreen().ordinal()];
                    if (i4 == 1) {
                        composer3.startReplaceGroup(860785414);
                        ComposerKt.sourceInformation(composer3, "147@5660L24");
                        AppRoot$lambda$02 = MainActivityKt.AppRoot$lambda$0(collectAsState);
                        SessionsScreensKt.ConnectScreen(AppRoot$lambda$02, AppViewModel.this, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (i4 == 2) {
                        composer3.startReplaceGroup(860787335);
                        ComposerKt.sourceInformation(composer3, "148@5720L25");
                        AppRoot$lambda$03 = MainActivityKt.AppRoot$lambda$0(collectAsState);
                        SessionsScreensKt.SessionsScreen(AppRoot$lambda$03, AppViewModel.this, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (i4 == 3) {
                        composer3.startReplaceGroup(860789155);
                        ComposerKt.sourceInformation(composer3, "149@5777L21");
                        AppRoot$lambda$04 = MainActivityKt.AppRoot$lambda$0(collectAsState);
                        ChatScreenKt.ChatScreen(AppRoot$lambda$04, AppViewModel.this, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        if (i4 != 4) {
                            composer3.startReplaceGroup(860783867);
                            composer3.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer3.startReplaceGroup(860790983);
                        ComposerKt.sourceInformation(composer3, "150@5834L25");
                        AppRoot$lambda$05 = MainActivityKt.AppRoot$lambda$0(collectAsState);
                        SettingsScreenKt.SettingsScreen(AppRoot$lambda$05, AppViewModel.this, composer3, 0);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 48);
            SnackbarHostKt.SnackbarHost(snackbarHostState, WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()))), (Function3) null, startRestartGroup, 6, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.MainActivityKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AppRoot$lambda$4;
                    AppRoot$lambda$4 = MainActivityKt.AppRoot$lambda$4(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AppRoot$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UiState AppRoot$lambda$0(State<UiState> state) {
        return (UiState) state.getValue();
    }
}

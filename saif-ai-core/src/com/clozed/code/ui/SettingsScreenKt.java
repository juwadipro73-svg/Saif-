package com.clozed.code.ui;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.IntegrationOpt;
import com.clozed.code.engine.CatModel;
import com.clozed.code.engine.CatProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.mozilla.javascript.ES6Iterator;

/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\u00012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\u000b\u001aC\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0019\u001a\u008b\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u00112\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u00112\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010$\u001aA\u0010%\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010*\u001aA\u0010+\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010.\u001aÿ\u0001\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u0001012a\u0010!\u001a]\b\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(6\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0807\u0012\u0006\u0012\u0004\u0018\u000109022u\u0010-\u001aq\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b3\u0012\b\b\u001b\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00010:2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010<¨\u0006=²\u0006\n\u0010>\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010?\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\f\u0010@\u001a\u0004\u0018\u00010AX\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010AX\u008a\u008e\u0002²\u0006\f\u0010D\u001a\u0004\u0018\u00010EX\u008a\u008e\u0002²\u0006\f\u0010F\u001a\u0004\u0018\u00010AX\u008a\u008e\u0002²\u0006\f\u0010G\u001a\u0004\u0018\u00010AX\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010J\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"SettingsScreen", "", "state", "Lcom/clozed/code/UiState;", "vm", "Lcom/clozed/code/AppViewModel;", "(Lcom/clozed/code/UiState;Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "SettingsCard", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SwitchRow", "title", "", "subtitle", "checked", "", "onChange", "Lkotlin/Function1;", "warn", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "InfoRow", "label", ES6Iterator.VALUE_PROPERTY, "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ProviderCard", "name", "editLabel", "onEdit", "onRemove", "enabled", "onToggle", "onFetch", "fetching", "onKeys", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ConfirmDialog", "text", "confirm", "onConfirm", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "KeyDialog", "hint", "onSave", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CustomProviderDialog", "existing", "Lcom/clozed/code/engine/CatProvider;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "url", "anthropic", "key", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/Function5;", "models", "(Lcom/clozed/code/engine/CatProvider;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "themeMode", "dynamic", "keyTarget", "Lcom/clozed/code/data/IntegrationOpt;", "showAdd", "manageKeysFor", "editor", "Lcom/clozed/code/ui/CustomEdit;", "removeKeyFor", "removeCustomFor", "confirmDisconnect", "show", "fetchMsg", "apiUrl", "ckey"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmDialog$lambda$72(String str, String str2, String str3, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ConfirmDialog(str, str2, str3, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomProviderDialog$lambda$105(CatProvider catProvider, Function4 function4, Function5 function5, Function0 function0, int i, Composer composer, int i2) {
        CustomProviderDialog(catProvider, function4, function5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoRow$lambda$70(String str, String str2, int i, Composer composer, int i2) {
        InfoRow(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyDialog$lambda$79(String str, String str2, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        KeyDialog(str, str2, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderCard$lambda$71(String str, String str2, String str3, Function0 function0, Function0 function02, boolean z, Function1 function1, Function0 function03, boolean z2, Function0 function04, int i, int i2, Composer composer, int i3) {
        ProviderCard(str, str2, str3, function0, function02, z, function1, function03, z2, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsCard$lambda$65(Function2 function2, int i, Composer composer, int i2) {
        SettingsCard(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$64(UiState uiState, AppViewModel appViewModel, int i, Composer composer, int i2) {
        SettingsScreen(uiState, appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchRow$lambda$68(String str, String str2, boolean z, Function1 function1, boolean z2, int i, int i2, Composer composer, int i3) {
        SwitchRow(str, str2, z, function1, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SettingsScreen(UiState state, AppViewModel appViewModel, Composer composer, final int i) {
        String str;
        final UiState uiState;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final AppViewModel vm = appViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(785454783);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsScreen)79@3682L22,79@3670L34,81@3733L7,82@3768L11,83@3814L16,84@3866L16,85@3918L34,87@3975L50,88@4045L34,89@4105L50,90@4174L46,91@4245L50,92@4323L50,93@4403L34,102@4790L510,115@5308L8275,99@4650L8933,*340@15586L102,341@15711L354,348@16091L17,338@15507L612:SettingsScreen.kt#qn8u0p");
        int i2 = (i & 6) == 0 ? i | (startRestartGroup.changedInstance(state) ? 4 : 2) : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(vm) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(785454783, i2, -1, "com.clozed.code.ui.SettingsScreen (SettingsScreen.kt:78)");
            }
            startRestartGroup.startReplaceGroup(1262882604);
            String str2 = "CC(remember):SettingsScreen.kt#9igjgp";
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(vm);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsScreen$lambda$1$lambda$0;
                        SettingsScreen$lambda$1$lambda$0 = SettingsScreenKt.SettingsScreen$lambda$1$lambda$0(AppViewModel.this);
                        return SettingsScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue, startRestartGroup, 0, 1);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            State collectAsState = SnapshotStateKt.collectAsState(vm.getThemeMode(), (CoroutineContext) null, startRestartGroup, 0, 1);
            State collectAsState2 = SnapshotStateKt.collectAsState(vm.getDynamicColor(), (CoroutineContext) null, startRestartGroup, 0, 1);
            final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior((TopAppBarState) null, (Function0) null, (AnimationSpec) null, (DecayAnimationSpec) null, startRestartGroup, TopAppBarDefaults.$stable << 12, 15);
            startRestartGroup.startReplaceGroup(1262892008);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262894232);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262896168);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262898372);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState8 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262900648);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState9 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262903144);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState10 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1262905688);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            MutableState mutableState11 = (MutableState) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            List<CatProvider> customProviders = vm.customProviders();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(customProviders, 10)), 16));
            for (Object obj : customProviders) {
                linkedHashMap.put(((CatProvider) obj).getId(), obj);
                str2 = str2;
            }
            String str3 = str2;
            List<IntegrationOpt> integrations = state.getIntegrations();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : integrations) {
                if (((IntegrationOpt) obj2).getConnected()) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            List<IntegrationOpt> integrations2 = state.getIntegrations();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = integrations2.iterator();
            while (it.hasNext()) {
                Iterator it2 = it;
                Object next = it2.next();
                IntegrationOpt integrationOpt = (IntegrationOpt) next;
                if (!integrationOpt.getConnected() && integrationOpt.getSupportsKey()) {
                    arrayList3.add(next);
                }
                it = it2;
            }
            ArrayList arrayList4 = arrayList3;
            int i3 = i2;
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, exitUntilCollapsedScrollBehavior.getNestedScrollConnection(), (NestedScrollDispatcher) null, 2, (Object) null);
            long j = colorScheme.getBackground-0d7_KjU();
            Function2 rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-924006789, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C109@5123L152,105@4899L138,103@4804L486:SettingsScreen.kt#qn8u0p");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-924006789, i4, -1, "com.clozed.code.ui.SettingsScreen.<anonymous> (SettingsScreen.kt:103)");
                        }
                        AppBarKt.LargeTopAppBar-oKE7A98(ComposableSingletons$SettingsScreenKt.INSTANCE.m1466getLambda1$app_release(), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(1383796448, true, new AnonymousClass1(vm), composer2, 54), (Function3) null, 0.0f, 0.0f, (WindowInsets) null, TopAppBarDefaults.INSTANCE.topAppBarColors-5tl4gsc(colorScheme.getBackground-0d7_KjU(), colorScheme.getSurfaceContainer-0d7_KjU(), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 18, 60), exitUntilCollapsedScrollBehavior, composer2, 390, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SettingsScreen.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2$1, reason: invalid class name */
                /* loaded from: /tmp/classes3.dex */
                public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ AppViewModel $vm;

                    AnonymousClass1(AppViewModel appViewModel) {
                        this.$vm = appViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel) {
                        appViewModel.closeSettings();
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C106@4942L22,106@4921L98:SettingsScreen.kt#qn8u0p");
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1383796448, i, -1, "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous> (SettingsScreen.kt:106)");
                        }
                        composer.startReplaceGroup(-1023571926);
                        ComposerKt.sourceInformation(composer, "CC(remember):SettingsScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(this.$vm);
                        final AppViewModel appViewModel = this.$vm;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: CONSTRUCTOR (r1v2 'rememberedValue' java.lang.Object) = (r0v3 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:107) call: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2$1$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2.1.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "C106@4942L22,106@4921L98:SettingsScreen.kt#qn8u0p"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
                                r0 = r14 & 3
                                r1 = 2
                                if (r0 != r1) goto L15
                                boolean r0 = r13.getSkipping()
                                if (r0 != 0) goto L11
                                goto L15
                            L11:
                                r13.skipToGroupEnd()
                                return
                            L15:
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto L24
                                r0 = -1
                                java.lang.String r1 = "com.clozed.code.ui.SettingsScreen.<anonymous>.<anonymous> (SettingsScreen.kt:106)"
                                r2 = 1383796448(0x527b0ee0, float:2.6957159E11)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                            L24:
                                r14 = -1023571926(0xffffffffc2fd882a, float:-126.765945)
                                r13.startReplaceGroup(r14)
                                java.lang.String r14 = "CC(remember):SettingsScreen.kt#9igjgp"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
                                com.clozed.code.AppViewModel r14 = r12.$vm
                                boolean r14 = r13.changedInstance(r14)
                                com.clozed.code.AppViewModel r0 = r12.$vm
                                java.lang.Object r1 = r13.rememberedValue()
                                if (r14 != 0) goto L45
                                androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
                                java.lang.Object r14 = r14.getEmpty()
                                if (r1 != r14) goto L4d
                            L45:
                                com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2$1$$ExternalSyntheticLambda0 r1 = new com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2$1$$ExternalSyntheticLambda0
                                r1.<init>(r0)
                                r13.updateRememberedValue(r1)
                            L4d:
                                r2 = r1
                                kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
                                r13.endReplaceGroup()
                                com.clozed.code.ui.ComposableSingletons$SettingsScreenKt r14 = com.clozed.code.ui.ComposableSingletons$SettingsScreenKt.INSTANCE
                                kotlin.jvm.functions.Function2 r8 = r14.m1477getLambda2$app_release()
                                r10 = 1572864(0x180000, float:2.204052E-39)
                                r11 = 62
                                r3 = 0
                                r4 = 0
                                r5 = 0
                                r6 = 0
                                r7 = 0
                                r9 = r13
                                androidx.compose.material3.IconButtonKt.IconButton(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r13 == 0) goto L6f
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            L6f:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$SettingsScreen$2.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }
                }, startRestartGroup, 54);
                vm = appViewModel;
                ScaffoldKt.Scaffold-TvnljyQ(nestedScroll$default, rememberComposableLambda, (Function2) null, (Function2) null, (Function2) null, 0, j, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(833862160, true, new SettingsScreenKt$SettingsScreen$3(colorScheme, arrayList2, state, linkedHashMap, appViewModel, arrayList4, collectAsState, collectAsState2, context, mutableState8, mutableState7, mutableState5, mutableState10, mutableState9, mutableState6, mutableState11), startRestartGroup, 54), startRestartGroup, 805306416, 444);
                startRestartGroup = startRestartGroup;
                startRestartGroup.startReplaceGroup(1263202787);
                ComposerKt.sourceInformation(startRestartGroup, "286@13804L11,287@13835L9,288@13867L18,289@13911L19,283@13701L304");
                if (SettingsScreen$lambda$8(mutableState6)) {
                    startRestartGroup.startReplaceGroup(1263206497);
                    str = str3;
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                    if (rememberedValue9 == Composer.Companion.getEmpty()) {
                        rememberedValue9 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                String SettingsScreen$lambda$29$lambda$28;
                                SettingsScreen$lambda$29$lambda$28 = SettingsScreenKt.SettingsScreen$lambda$29$lambda$28((IntegrationOpt) obj3);
                                return SettingsScreen$lambda$29$lambda$28;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                    }
                    Function1 function1 = (Function1) rememberedValue9;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1263207487);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue10 = startRestartGroup.rememberedValue();
                    if (rememberedValue10 == Composer.Companion.getEmpty()) {
                        rememberedValue10 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                String SettingsScreen$lambda$31$lambda$30;
                                SettingsScreen$lambda$31$lambda$30 = SettingsScreenKt.SettingsScreen$lambda$31$lambda$30((IntegrationOpt) obj3);
                                return SettingsScreen$lambda$31$lambda$30;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                    }
                    Function1 function12 = (Function1) rememberedValue10;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1263208520);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue11 = startRestartGroup.rememberedValue();
                    if (rememberedValue11 == Composer.Companion.getEmpty()) {
                        rememberedValue11 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                Unit SettingsScreen$lambda$33$lambda$32;
                                SettingsScreen$lambda$33$lambda$32 = SettingsScreenKt.SettingsScreen$lambda$33$lambda$32(mutableState5, (IntegrationOpt) obj3);
                                return SettingsScreen$lambda$33$lambda$32;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue11);
                    }
                    Function1 function13 = (Function1) rememberedValue11;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1263209929);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue12 = startRestartGroup.rememberedValue();
                    if (rememberedValue12 == Composer.Companion.getEmpty()) {
                        rememberedValue12 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$35$lambda$34;
                                SettingsScreen$lambda$35$lambda$34 = SettingsScreenKt.SettingsScreen$lambda$35$lambda$34(mutableState6);
                                return SettingsScreen$lambda$35$lambda$34;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue12);
                    }
                    startRestartGroup.endReplaceGroup();
                    SheetsKt.PickerSheet("Choose provider", arrayList4, function1, function12, function13, (Function0) rememberedValue12, "All providers are already connected.", null, startRestartGroup, 1797510, 128);
                    startRestartGroup = startRestartGroup;
                } else {
                    str = str3;
                }
                startRestartGroup.endReplaceGroup();
                final IntegrationOpt SettingsScreen$lambda$5 = SettingsScreen$lambda$5(mutableState5);
                startRestartGroup.startReplaceGroup(1263213878);
                ComposerKt.sourceInformation(startRestartGroup, "*298@14144L45,299@14215L20,295@14047L199");
                if (SettingsScreen$lambda$5 != null) {
                    String name = SettingsScreen$lambda$5.getName();
                    String keyHint = vm.keyHint(SettingsScreen$lambda$5.getId());
                    startRestartGroup.startReplaceGroup(342416386);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance2 = startRestartGroup.changedInstance(vm) | startRestartGroup.changed(SettingsScreen$lambda$5);
                    Object rememberedValue13 = startRestartGroup.rememberedValue();
                    if (changedInstance2 || rememberedValue13 == Composer.Companion.getEmpty()) {
                        rememberedValue13 = new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                Unit SettingsScreen$lambda$40$lambda$37$lambda$36;
                                SettingsScreen$lambda$40$lambda$37$lambda$36 = SettingsScreenKt.SettingsScreen$lambda$40$lambda$37$lambda$36(AppViewModel.this, SettingsScreen$lambda$5, mutableState5, (String) obj3);
                                return SettingsScreen$lambda$40$lambda$37$lambda$36;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue13);
                    }
                    Function1 function14 = (Function1) rememberedValue13;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(342418633);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue14 = startRestartGroup.rememberedValue();
                    if (rememberedValue14 == Composer.Companion.getEmpty()) {
                        rememberedValue14 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$40$lambda$39$lambda$38;
                                SettingsScreen$lambda$40$lambda$39$lambda$38 = SettingsScreenKt.SettingsScreen$lambda$40$lambda$39$lambda$38(mutableState5);
                                return SettingsScreen$lambda$40$lambda$39$lambda$38;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue14);
                    }
                    startRestartGroup.endReplaceGroup();
                    Composer composer2 = startRestartGroup;
                    KeyDialog(name, keyHint, function14, (Function0) rememberedValue14, composer2, 3072);
                    startRestartGroup = composer2;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                IntegrationOpt SettingsScreen$lambda$11 = SettingsScreen$lambda$11(mutableState7);
                startRestartGroup.startReplaceGroup(1263221585);
                ComposerKt.sourceInformation(startRestartGroup, "*304@14333L24,304@14292L66");
                if (SettingsScreen$lambda$11 == null) {
                    uiState = state;
                } else {
                    String id = SettingsScreen$lambda$11.getId();
                    String name2 = SettingsScreen$lambda$11.getName();
                    startRestartGroup.startReplaceGroup(342422413);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue15 = startRestartGroup.rememberedValue();
                    if (rememberedValue15 == Composer.Companion.getEmpty()) {
                        rememberedValue15 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$43$lambda$42$lambda$41;
                                SettingsScreen$lambda$43$lambda$42$lambda$41 = SettingsScreenKt.SettingsScreen$lambda$43$lambda$42$lambda$41(mutableState7);
                                return SettingsScreen$lambda$43$lambda$42$lambda$41;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue15);
                    }
                    startRestartGroup.endReplaceGroup();
                    uiState = state;
                    AutoSwitchUiKt.KeysDialog(vm, id, name2, (Function0) rememberedValue15, startRestartGroup, ((i3 >> 3) & 14) | 3072);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                final IntegrationOpt SettingsScreen$lambda$17 = SettingsScreen$lambda$17(mutableState9);
                startRestartGroup.startReplaceGroup(1263225413);
                ComposerKt.sourceInformation(startRestartGroup, "*312@14642L43,313@14711L23,308@14403L342");
                if (SettingsScreen$lambda$17 != null) {
                    String str4 = "The saved key for " + SettingsScreen$lambda$17.getName() + " will be removed. Its models will not work in chat until you add a key again.";
                    startRestartGroup.startReplaceGroup(342432320);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance3 = startRestartGroup.changedInstance(vm) | startRestartGroup.changed(SettingsScreen$lambda$17);
                    Object rememberedValue16 = startRestartGroup.rememberedValue();
                    if (changedInstance3 || rememberedValue16 == Composer.Companion.getEmpty()) {
                        mutableState4 = mutableState9;
                        rememberedValue16 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$48$lambda$45$lambda$44;
                                SettingsScreen$lambda$48$lambda$45$lambda$44 = SettingsScreenKt.SettingsScreen$lambda$48$lambda$45$lambda$44(AppViewModel.this, SettingsScreen$lambda$17, mutableState4);
                                return SettingsScreen$lambda$48$lambda$45$lambda$44;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue16);
                    } else {
                        mutableState4 = mutableState9;
                    }
                    Function0 function0 = (Function0) rememberedValue16;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(342434508);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue17 = startRestartGroup.rememberedValue();
                    if (rememberedValue17 == Composer.Companion.getEmpty()) {
                        rememberedValue17 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$48$lambda$47$lambda$46;
                                SettingsScreen$lambda$48$lambda$47$lambda$46 = SettingsScreenKt.SettingsScreen$lambda$48$lambda$47$lambda$46(mutableState4);
                                return SettingsScreen$lambda$48$lambda$47$lambda$46;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue17);
                    }
                    startRestartGroup.endReplaceGroup();
                    ConfirmDialog("API key hatayein?", str4, "Remove", function0, (Function0) rememberedValue17, startRestartGroup, 24966);
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                final IntegrationOpt SettingsScreen$lambda$20 = SettingsScreen$lambda$20(mutableState10);
                startRestartGroup.startReplaceGroup(1263237845);
                ComposerKt.sourceInformation(startRestartGroup, "*322@14967L57,323@15050L26,318@14793L294");
                if (SettingsScreen$lambda$20 != null) {
                    String str5 = SettingsScreen$lambda$20.getName() + " and its key will be deleted.";
                    startRestartGroup.startReplaceGroup(342442734);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance4 = startRestartGroup.changedInstance(vm) | startRestartGroup.changed(SettingsScreen$lambda$20);
                    Object rememberedValue18 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue18 == Composer.Companion.getEmpty()) {
                        mutableState3 = mutableState10;
                        rememberedValue18 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$53$lambda$50$lambda$49;
                                SettingsScreen$lambda$53$lambda$50$lambda$49 = SettingsScreenKt.SettingsScreen$lambda$53$lambda$50$lambda$49(AppViewModel.this, SettingsScreen$lambda$20, mutableState3);
                                return SettingsScreen$lambda$53$lambda$50$lambda$49;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue18);
                    } else {
                        mutableState3 = mutableState10;
                    }
                    Function0 function02 = (Function0) rememberedValue18;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(342445359);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue19 = startRestartGroup.rememberedValue();
                    if (rememberedValue19 == Composer.Companion.getEmpty()) {
                        rememberedValue19 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$53$lambda$52$lambda$51;
                                SettingsScreen$lambda$53$lambda$52$lambda$51 = SettingsScreenKt.SettingsScreen$lambda$53$lambda$52$lambda$51(mutableState3);
                                return SettingsScreen$lambda$53$lambda$52$lambda$51;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue19);
                    }
                    startRestartGroup.endReplaceGroup();
                    ConfirmDialog("Provider hatayein?", str5, "Delete", function02, (Function0) rememberedValue19, startRestartGroup, 24966);
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1263248301);
                ComposerKt.sourceInformation(startRestartGroup, "332@15356L46,333@15428L29,328@15132L336");
                if (SettingsScreen$lambda$23(mutableState11)) {
                    startRestartGroup.startReplaceGroup(1263256196);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance5 = startRestartGroup.changedInstance(vm);
                    Object rememberedValue20 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue20 == Composer.Companion.getEmpty()) {
                        mutableState2 = mutableState11;
                        rememberedValue20 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$55$lambda$54;
                                SettingsScreen$lambda$55$lambda$54 = SettingsScreenKt.SettingsScreen$lambda$55$lambda$54(AppViewModel.this, mutableState2);
                                return SettingsScreen$lambda$55$lambda$54;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue20);
                    } else {
                        mutableState2 = mutableState11;
                    }
                    Function0 function03 = (Function0) rememberedValue20;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1263258483);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue21 = startRestartGroup.rememberedValue();
                    if (rememberedValue21 == Composer.Companion.getEmpty()) {
                        rememberedValue21 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$57$lambda$56;
                                SettingsScreen$lambda$57$lambda$56 = SettingsScreenKt.SettingsScreen$lambda$57$lambda$56(mutableState2);
                                return SettingsScreen$lambda$57$lambda$56;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue21);
                    }
                    startRestartGroup.endReplaceGroup();
                    ConfirmDialog("Disconnect karein?", "You will go back to the connect screen. Sessions and keys stay saved on this device.", "Disconnect", function03, (Function0) rememberedValue21, startRestartGroup, 25014);
                }
                startRestartGroup.endReplaceGroup();
                final CustomEdit SettingsScreen$lambda$14 = SettingsScreen$lambda$14(mutableState8);
                if (SettingsScreen$lambda$14 != null) {
                    CatProvider existing = SettingsScreen$lambda$14.getExisting();
                    startRestartGroup.startReplaceGroup(342462587);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance6 = startRestartGroup.changedInstance(vm) | startRestartGroup.changedInstance(SettingsScreen$lambda$14);
                    Object rememberedValue22 = startRestartGroup.rememberedValue();
                    if (changedInstance6 || rememberedValue22 == Composer.Companion.getEmpty()) {
                        rememberedValue22 = (Function4) new SettingsScreenKt$SettingsScreen$14$1$1(vm, SettingsScreen$lambda$14, null);
                        startRestartGroup.updateRememberedValue(rememberedValue22);
                    }
                    Function4 function4 = (Function4) rememberedValue22;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(342466839);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    boolean changedInstance7 = startRestartGroup.changedInstance(SettingsScreen$lambda$14) | startRestartGroup.changedInstance(vm);
                    Object rememberedValue23 = startRestartGroup.rememberedValue();
                    if (changedInstance7 || rememberedValue23 == Composer.Companion.getEmpty()) {
                        mutableState = mutableState8;
                        rememberedValue23 = new Function5() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function5
                            public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                                Unit SettingsScreen$lambda$63$lambda$60$lambda$59;
                                SettingsScreen$lambda$63$lambda$60$lambda$59 = SettingsScreenKt.SettingsScreen$lambda$63$lambda$60$lambda$59(CustomEdit.this, vm, mutableState, (String) obj3, ((Boolean) obj4).booleanValue(), (String) obj5, (String) obj6, (String) obj7);
                                return SettingsScreen$lambda$63$lambda$60$lambda$59;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue23);
                    } else {
                        mutableState = mutableState8;
                    }
                    Function5 function5 = (Function5) rememberedValue23;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(342478662);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    Object rememberedValue24 = startRestartGroup.rememberedValue();
                    if (rememberedValue24 == Composer.Companion.getEmpty()) {
                        rememberedValue24 = new Function0() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$63$lambda$62$lambda$61;
                                SettingsScreen$lambda$63$lambda$62$lambda$61 = SettingsScreenKt.SettingsScreen$lambda$63$lambda$62$lambda$61(mutableState);
                                return SettingsScreen$lambda$63$lambda$62$lambda$61;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue24);
                    }
                    startRestartGroup.endReplaceGroup();
                    Composer composer3 = startRestartGroup;
                    CustomProviderDialog(existing, function4, function5, (Function0) rememberedValue24, composer3, 3072);
                    startRestartGroup = composer3;
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                uiState = state;
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        Unit SettingsScreen$lambda$64;
                        SettingsScreen$lambda$64 = SettingsScreenKt.SettingsScreen$lambda$64(UiState.this, vm, i, (Composer) obj3, ((Integer) obj4).intValue());
                        return SettingsScreen$lambda$64;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$1$lambda$0(AppViewModel appViewModel) {
            appViewModel.closeSettings();
            return Unit.INSTANCE;
        }

        private static final IntegrationOpt SettingsScreen$lambda$5(MutableState<IntegrationOpt> mutableState) {
            return (IntegrationOpt) ((State) mutableState).getValue();
        }

        private static final boolean SettingsScreen$lambda$8(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SettingsScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        private static final IntegrationOpt SettingsScreen$lambda$11(MutableState<IntegrationOpt> mutableState) {
            return (IntegrationOpt) ((State) mutableState).getValue();
        }

        private static final CustomEdit SettingsScreen$lambda$14(MutableState<CustomEdit> mutableState) {
            return (CustomEdit) ((State) mutableState).getValue();
        }

        private static final IntegrationOpt SettingsScreen$lambda$17(MutableState<IntegrationOpt> mutableState) {
            return (IntegrationOpt) ((State) mutableState).getValue();
        }

        private static final IntegrationOpt SettingsScreen$lambda$20(MutableState<IntegrationOpt> mutableState) {
            return (IntegrationOpt) ((State) mutableState).getValue();
        }

        private static final boolean SettingsScreen$lambda$23(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SettingsScreen$lambda$24(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SettingsScreen$lambda$29$lambda$28(IntegrationOpt it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SettingsScreen$lambda$31$lambda$30(IntegrationOpt it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$33$lambda$32(MutableState mutableState, IntegrationOpt it) {
            Intrinsics.checkNotNullParameter(it, "it");
            mutableState.setValue(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$35$lambda$34(MutableState mutableState) {
            SettingsScreen$lambda$9(mutableState, false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$40$lambda$37$lambda$36(AppViewModel appViewModel, IntegrationOpt integrationOpt, MutableState mutableState, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            appViewModel.connectKey(integrationOpt.getId(), it);
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$40$lambda$39$lambda$38(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$43$lambda$42$lambda$41(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$48$lambda$45$lambda$44(AppViewModel appViewModel, IntegrationOpt integrationOpt, MutableState mutableState) {
            appViewModel.removeKey(integrationOpt.getId());
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$48$lambda$47$lambda$46(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$53$lambda$50$lambda$49(AppViewModel appViewModel, IntegrationOpt integrationOpt, MutableState mutableState) {
            appViewModel.removeCustomProvider(integrationOpt.getId());
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$53$lambda$52$lambda$51(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$55$lambda$54(AppViewModel appViewModel, MutableState mutableState) {
            SettingsScreen$lambda$24(mutableState, false);
            appViewModel.disconnect();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$57$lambda$56(MutableState mutableState) {
            SettingsScreen$lambda$24(mutableState, false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$63$lambda$60$lambda$59(CustomEdit customEdit, AppViewModel appViewModel, MutableState mutableState, String name, boolean z, String url, String models, String key) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(models, "models");
            Intrinsics.checkNotNullParameter(key, "key");
            String str = z ? "anthropic" : "openai";
            CatProvider existing = customEdit.getExisting();
            if (existing == null) {
                appViewModel.addCustomProvider(name, str, url, models, key);
            } else {
                appViewModel.updateCustomProvider(existing.getId(), name, str, url, models, key);
            }
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit SettingsScreen$lambda$63$lambda$62$lambda$61(MutableState mutableState) {
            mutableState.setValue(null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SettingsCard(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            Composer startRestartGroup = composer.startRestartGroup(-1250654184);
            ComposerKt.sourceInformation(startRestartGroup, "C(SettingsCard)358@16370L11,358@16328L74,360@16454L112,357@16292L274:SettingsScreen.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1250654184, i2, -1, "com.clozed.code.ui.SettingsCard (SettingsScreen.kt:356)");
                }
                composer2 = startRestartGroup;
                CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1709903882, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$SettingsCard$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope Card, Composer composer3, int i3) {
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        ComposerKt.sourceInformation(composer3, "C361@16464L96:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1709903882, i3, -1, "com.clozed.code.ui.SettingsCard.<anonymous> (SettingsScreen.kt:361)");
                        }
                        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer3, 6);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer4 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer4, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode))) {
                            composer4.updateRememberedValue(Integer.valueOf(hashCode));
                            composer4.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1873254142, "C361@16549L9:SettingsScreen.kt#qn8u0p");
                        function22.invoke(composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 196614, 26);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SettingsCard$lambda$65;
                        SettingsCard$lambda$65 = SettingsScreenKt.SettingsCard$lambda$65(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                        return SettingsCard$lambda$65;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x033c  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01e6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01f2  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x021b  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0299  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0331  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02b1  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void SwitchRow(final java.lang.String r34, final java.lang.String r35, final boolean r36, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r37, boolean r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
            /*
                Method dump skipped, instructions count: 847
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt.SwitchRow(java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void InfoRow(final String str, String str2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            final String str3;
            Composer startRestartGroup = composer.startRestartGroup(-1929560678);
            ComposerKt.sourceInformation(startRestartGroup, "C(InfoRow)381@17317L244:SettingsScreen.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1929560678, i2, -1, "com.clozed.code.ui.InfoRow (SettingsScreen.kt:380)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier = Modifier.Companion;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
                Composer composer3 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                    composer3.updateRememberedValue(Integer.valueOf(hashCode));
                    composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -552613630, "C382@17368L10,382@17414L11,382@17334L109,383@17486L10,383@17452L103:SettingsScreen.kt#qn8u0p");
                composer2 = startRestartGroup;
                TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), composer2, i2 & 14, 0, 131066);
                str3 = str2;
                TextKt.Text-Nvy7gAk(str3, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 2, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, (i2 >> 3) & 14, 24960, 110590);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                str3 = str2;
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit InfoRow$lambda$70;
                        InfoRow$lambda$70 = SettingsScreenKt.InfoRow$lambda$70(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                        return InfoRow$lambda$70;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:103:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void ProviderCard(final java.lang.String r25, final java.lang.String r26, final java.lang.String r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, final boolean r30, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r31, final kotlin.jvm.functions.Function0<kotlin.Unit> r32, final boolean r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
            /*
                Method dump skipped, instructions count: 486
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt.ProviderCard(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
        }

        private static final void ConfirmDialog(final String str, final String str2, final String str3, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
            int i2;
            Composer composer2;
            Composer startRestartGroup = composer.startRestartGroup(1059564837);
            ComposerKt.sourceInformation(startRestartGroup, "C(ConfirmDialog)P(4,3)466@21145L94,467@21265L54,464@21073L15,465@21105L14,461@20952L374:SettingsScreen.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= startRestartGroup.changed(str3) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
            }
            if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1059564837, i2, -1, "com.clozed.code.ui.ConfirmDialog (SettingsScreen.kt:460)");
                }
                composer2 = startRestartGroup;
                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function02, ComposableLambdaKt.rememberComposableLambda(-36432419, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$ConfirmDialog$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C466@21179L58,466@21147L90:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36432419, i3, -1, "com.clozed.code.ui.ConfirmDialog.<anonymous> (SettingsScreen.kt:466)");
                        }
                        Function0<Unit> function03 = function0;
                        final String str4 = str3;
                        ButtonKt.TextButton(function03, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-636784960, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$ConfirmDialog$1.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                invoke(rowScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TextButton, Composer composer4, int i4) {
                                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                ComposerKt.sourceInformation(composer4, "C466@21217L11,466@21181L54:SettingsScreen.kt#qn8u0p");
                                if ((i4 & 17) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-636784960, i4, -1, "com.clozed.code.ui.ConfirmDialog.<anonymous>.<anonymous> (SettingsScreen.kt:466)");
                                }
                                TextKt.Text-Nvy7gAk(str4, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 262138);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-621204069, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$ConfirmDialog$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C467@21267L50:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-621204069, i3, -1, "com.clozed.code.ui.ConfirmDialog.<anonymous> (SettingsScreen.kt:467)");
                        }
                        ButtonKt.TextButton(function02, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1471getLambda14$app_release(), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableSingletons$SettingsScreenKt.INSTANCE.m1472getLambda15$app_release(), ComposableLambdaKt.rememberComposableLambda(-1205975719, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$ConfirmDialog$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C464@21075L11:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1205975719, i3, -1, "com.clozed.code.ui.ConfirmDialog.<anonymous> (SettingsScreen.kt:464)");
                        }
                        TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1498361544, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$ConfirmDialog$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C465@21107L10:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1498361544, i3, -1, "com.clozed.code.ui.ConfirmDialog.<anonymous> (SettingsScreen.kt:465)");
                        }
                        TextKt.Text-Nvy7gAk(str2, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i2 >> 12) & 14) | 1797168, 0, 16260);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ConfirmDialog$lambda$72;
                        ConfirmDialog$lambda$72 = SettingsScreenKt.ConfirmDialog$lambda$72(str, str2, str3, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                        return ConfirmDialog$lambda$72;
                    }
                });
            }
        }

        private static final void KeyDialog(final String str, final String str2, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Composer composer, final int i) {
            int i2;
            Composer composer2;
            Composer startRestartGroup = composer.startRestartGroup(-466181562);
            ComposerKt.sourceInformation(startRestartGroup, "C(KeyDialog)P(3!1,2)473@21472L7,474@21495L31,475@21543L34,497@22662L86,498@22774L54,479@21700L15,480@21732L904,476@21582L1253:SettingsScreen.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466181562, i2, -1, "com.clozed.code.ui.KeyDialog (SettingsScreen.kt:472)");
                }
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Context context = (Context) consume;
                startRestartGroup.startReplaceGroup(-1609227969);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1609226430);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1714715790, true, new SettingsScreenKt$KeyDialog$1(function1, mutableState), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-7286896, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C498@22776L50:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-7286896, i3, -1, "com.clozed.code.ui.KeyDialog.<anonymous> (SettingsScreen.kt:498)");
                        }
                        ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1474getLambda17$app_release(), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableSingletons$SettingsScreenKt.INSTANCE.m1475getLambda18$app_release(), ComposableLambdaKt.rememberComposableLambda(-1729289582, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$KeyDialog$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i3) {
                        ComposerKt.sourceInformation(composer3, "C479@21702L11:SettingsScreen.kt#qn8u0p");
                        if ((i3 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1729289582, i3, -1, "com.clozed.code.ui.KeyDialog.<anonymous> (SettingsScreen.kt:479)");
                        }
                        TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-442807277, true, new SettingsScreenKt$KeyDialog$4(str2, mutableState, (MutableState) rememberedValue2, context), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i2 >> 9) & 14) | 1797168, 0, 16260);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit KeyDialog$lambda$79;
                        KeyDialog$lambda$79 = SettingsScreenKt.KeyDialog$lambda$79(str, str2, function1, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                        return KeyDialog$lambda$79;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String KeyDialog$lambda$74(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean KeyDialog$lambda$77(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void KeyDialog$lambda$78(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        private static final void CustomProviderDialog(final CatProvider catProvider, final Function4<? super String, ? super Boolean, ? super String, ? super Continuation<? super List<String>>, ? extends Object> function4, final Function5<? super String, ? super Boolean, ? super String, ? super String, ? super String, Unit> function5, final Function0<Unit> function0, Composer composer, final int i) {
            int i2;
            Function5<? super String, ? super Boolean, ? super String, ? super String, ? super String, Unit> function52;
            MutableState mutableState;
            Composer composer2;
            String str;
            List<CatModel> models;
            String str2;
            String str3;
            Composer startRestartGroup = composer.startRestartGroup(1664987307);
            ComposerKt.sourceInformation(startRestartGroup, "C(CustomProviderDialog)P(!1,2,3)510@23194L7,511@23218L24,512@23263L34,513@23318L42,514@23377L49,515@23445L73,516@23537L81,517@23635L31,518@23688L58,519@23763L34,573@27596L267,579@27889L54,523@23870L70,524@23957L3613,521@23803L4147:SettingsScreen.kt#qn8u0p");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(catProvider) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changedInstance(function4) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                function52 = function5;
                i2 |= startRestartGroup.changedInstance(function52) ? 256 : 128;
            } else {
                function52 = function5;
            }
            if ((i & 3072) == 0) {
                i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            int i3 = i2;
            if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1664987307, i3, -1, "com.clozed.code.ui.CustomProviderDialog (SettingsScreen.kt:509)");
                }
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Context context = (Context) consume;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.startReplaceGroup(1463583955);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463585723);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                MutableState mutableState3 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463587618);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    if (catProvider == null || (str3 = catProvider.getName()) == null) {
                        str3 = "";
                    }
                    rememberedValue4 = SnapshotStateKt.mutableStateOf$default(str3, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                MutableState mutableState4 = (MutableState) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463589818);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    if (catProvider == null || (str2 = catProvider.getApi()) == null) {
                        str2 = "http://127.0.0.1:11434/v1";
                    }
                    MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(str2, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(mutableStateOf$default);
                    rememberedValue5 = mutableStateOf$default;
                }
                MutableState mutableState5 = (MutableState) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463592770);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    if (catProvider == null || (models = catProvider.getModels()) == null || (str = CollectionsKt.joinToString$default(models, ", ", null, null, 0, null, new Function1() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            CharSequence CustomProviderDialog$lambda$93$lambda$92;
                            CustomProviderDialog$lambda$93$lambda$92 = SettingsScreenKt.CustomProviderDialog$lambda$93$lambda$92((CatModel) obj);
                            return CustomProviderDialog$lambda$93$lambda$92;
                        }
                    }, 30, null)) == null) {
                        str = "";
                    }
                    rememberedValue6 = SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                MutableState mutableState6 = (MutableState) rememberedValue6;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463595856);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                    rememberedValue7 = mutableStateOf$default2;
                }
                MutableState mutableState7 = (MutableState) rememberedValue7;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463597579);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    mutableState = mutableState4;
                    rememberedValue8 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(Intrinsics.areEqual(catProvider != null ? catProvider.getKind() : null, "anthropic")), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                } else {
                    mutableState = mutableState4;
                }
                MutableState mutableState8 = (MutableState) rememberedValue8;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1463599955);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SettingsScreen.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1510719731, true, new SettingsScreenKt$CustomProviderDialog$1(function52, mutableState, mutableState5, mutableState6, mutableState8, mutableState7, catProvider), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(1937274229, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i4) {
                        ComposerKt.sourceInformation(composer3, "C579@27891L50:SettingsScreen.kt#qn8u0p");
                        if ((i4 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1937274229, i4, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous> (SettingsScreen.kt:579)");
                        }
                        ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SettingsScreenKt.INSTANCE.m1479getLambda21$app_release(), composer3, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1931138569, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i4) {
                        ComposerKt.sourceInformation(composer3, "C523@23872L66:SettingsScreen.kt#qn8u0p");
                        if ((i4 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1931138569, i4, -1, "com.clozed.code.ui.CustomProviderDialog.<anonymous> (SettingsScreen.kt:523)");
                        }
                        TextKt.Text-Nvy7gAk(CatProvider.this == null ? "Custom provider" : "Provider edit", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(429622328, true, new SettingsScreenKt$CustomProviderDialog$4(catProvider, mutableState, mutableState5, mutableState8, mutableState6, mutableState7, (MutableState) rememberedValue9, context, coroutineScope, function4, mutableState2, mutableState3), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i3 >> 9) & 14) | 1772592, 0, 16276);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.SettingsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CustomProviderDialog$lambda$105;
                        CustomProviderDialog$lambda$105 = SettingsScreenKt.CustomProviderDialog$lambda$105(CatProvider.this, function4, function5, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                        return CustomProviderDialog$lambda$105;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CustomProviderDialog$lambda$81(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void CustomProviderDialog$lambda$82(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String CustomProviderDialog$lambda$84(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String CustomProviderDialog$lambda$87(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String CustomProviderDialog$lambda$90(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence CustomProviderDialog$lambda$93$lambda$92(CatModel it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String CustomProviderDialog$lambda$94(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String CustomProviderDialog$lambda$97(MutableState<String> mutableState) {
            return (String) ((State) mutableState).getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CustomProviderDialog$lambda$100(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void CustomProviderDialog$lambda$101(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CustomProviderDialog$lambda$103(MutableState<Boolean> mutableState) {
            return ((Boolean) ((State) mutableState).getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void CustomProviderDialog$lambda$104(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String SettingsScreen$lambda$2(State<String> state) {
            return (String) state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean SettingsScreen$lambda$3(State<Boolean> state) {
            return ((Boolean) state.getValue()).booleanValue();
        }
    }

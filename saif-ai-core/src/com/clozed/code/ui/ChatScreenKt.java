package com.clozed.code.ui;

import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.app.NotificationCompat;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import com.clozed.code.data.AgentOpt;
import com.clozed.code.data.Block;
import com.clozed.code.data.ChatItem;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.data.PermissionReq;
import com.clozed.code.data.SessionInfo;
import com.clozed.code.ui.theme.ExtraColors;
import com.clozed.code.ui.theme.TypeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mozilla.classfile.ByteCode;

/* compiled from: ChatScreen.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010\u001f\u001a\u001d\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a)\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050+H\u0003¢\u0006\u0002\u0010,\u001a\u0015\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a)\u0010/\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050+H\u0003¢\u0006\u0002\u0010,¨\u00060²\u0006\n\u0010.\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\u0010\u00105\u001a\b\u0012\u0004\u0012\u00020\u000106X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\u0001X\u008a\u008e\u0002"}, d2 = {"formatTokens", "", "n", "", "ChatScreen", "", "state", "Lcom/clozed/code/UiState;", "vm", "Lcom/clozed/code/AppViewModel;", "(Lcom/clozed/code/UiState;Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "MiniChip", "text", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "UserBubble", "m", "Lcom/clozed/code/data/ChatItem$User;", "(Lcom/clozed/code/data/ChatItem$User;Landroidx/compose/runtime/Composer;I)V", "AssistantBubble", "Lcom/clozed/code/data/ChatItem$Assistant;", "spinner", "", "(Lcom/clozed/code/data/ChatItem$Assistant;ZLandroidx/compose/runtime/Composer;I)V", "AssistantContent", "ReasoningBlock", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ToolCard", "t", "Lcom/clozed/code/data/Block$Tool;", "(Lcom/clozed/code/data/Block$Tool;Landroidx/compose/runtime/Composer;I)V", "MonoBox", "label", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ShellCard", "s", "Lcom/clozed/code/data/ChatItem$Shell;", "(Lcom/clozed/code/data/ChatItem$Shell;Landroidx/compose/runtime/Composer;I)V", "PermissionCard", "req", "Lcom/clozed/code/data/PermissionReq;", "onReply", "Lkotlin/Function1;", "(Lcom/clozed/code/data/PermissionReq;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TodoList", "input", "QuestionCard", "app_release", "showModels", "showAgents", "follow", "confirmStop", "images", "", "showPort", "open"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssistantBubble$lambda$57(ChatItem.Assistant assistant, boolean z, int i, Composer composer, int i2) {
        AssistantBubble(assistant, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssistantContent$lambda$60(ChatItem.Assistant assistant, boolean z, int i, Composer composer, int i2) {
        AssistantContent(assistant, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatScreen$lambda$50(UiState uiState, AppViewModel appViewModel, int i, Composer composer, int i2) {
        ChatScreen(uiState, appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniChip$lambda$51(String str, Function0 function0, int i, Composer composer, int i2) {
        MiniChip(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonoBox$lambda$79(String str, String str2, int i, Composer composer, int i2) {
        MonoBox(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionCard$lambda$82(PermissionReq permissionReq, Function1 function1, int i, Composer composer, int i2) {
        PermissionCard(permissionReq, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuestionCard$lambda$91(PermissionReq permissionReq, Function1 function1, int i, Composer composer, int i2) {
        QuestionCard(permissionReq, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReasoningBlock$lambda$68(String str, int i, Composer composer, int i2) {
        ReasoningBlock(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShellCard$lambda$81(ChatItem.Shell shell, int i, Composer composer, int i2) {
        ShellCard(shell, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TodoList$lambda$87(String str, int i, Composer composer, int i2) {
        TodoList(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolCard$lambda$76(Block.Tool tool, int i, Composer composer, int i2) {
        ToolCard(tool, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserBubble$lambda$54(ChatItem.User user, int i, Composer composer, int i2) {
        UserBubble(user, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final String formatTokens(long j) {
        String format;
        if (j < 1000) {
            return String.valueOf(j);
        }
        String[] strArr = {"K", "M", "B", "T"};
        double d = j;
        int i = -1;
        while (d >= 999.5d && i < 3) {
            d /= 1000.0d;
            i++;
        }
        if (d >= 100.0d) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("%.0f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        }
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        if (StringsKt.contains$default((CharSequence) format, '.', false, 2, (Object) null)) {
            format = StringsKt.trimEnd(StringsKt.trimEnd(format, '0'), '.');
        }
        return format + strArr[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void ChatScreen(final UiState uiState, AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String str;
        final UiState state = uiState;
        final AppViewModel vm = appViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(-2147379553);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChatScreen)111@5169L13,111@5157L25,113@5211L11,114@5243L23,115@5301L22,115@5284L39,116@5346L34,117@5403L34,118@5456L33,119@5513L34,120@5566L45,121@5632L34,122@5769L89,122@5688L170,134@6409L34,134@6388L55,136@6475L179,136@6449L205,140@6715L74,140@6659L130,146@6862L1878,182@8762L5148,268@13918L3154,144@6795L10277,358@18329L11,359@18360L24,360@18407L22,361@18455L22,355@18226L306:ChatScreen.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(state) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(vm) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2147379553, i3, -1, "com.clozed.code.ui.ChatScreen (ChatScreen.kt:110)");
            }
            startRestartGroup.startReplaceGroup(1317193400);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(vm);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ChatScreen$lambda$1$lambda$0;
                        ChatScreen$lambda$1$lambda$0 = ChatScreenKt.ChatScreen$lambda$1$lambda$0(AppViewModel.this);
                        return ChatScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue, startRestartGroup, 0, 1);
            final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1317197633);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ChatScreen$lambda$3$lambda$2;
                        ChatScreen$lambda$3$lambda$2 = ChatScreenKt.ChatScreen$lambda$3$lambda$2();
                        return ChatScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue2, startRestartGroup, 48);
            startRestartGroup.startReplaceGroup(1317199085);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1317200909);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1317202604);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState4 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1317204429);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1317206136);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1317208237);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            ActivityResultContract getMultipleContents = new ActivityResultContracts.GetMultipleContents();
            startRestartGroup.startReplaceGroup(1317212676);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ChatScreen$lambda$26$lambda$25;
                        ChatScreen$lambda$26$lambda$25 = ChatScreenKt.ChatScreen$lambda$26$lambda$25(mutableState6, (List) obj);
                        return ChatScreen$lambda$26$lambda$25;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getMultipleContents, (Function1) rememberedValue9, startRestartGroup, 48);
            boolean z = state.getCurrentId() != null && state.getBusy().contains(state.getCurrentId());
            ChatItem chatItem = (ChatItem) CollectionsKt.lastOrNull((List) state.getItems());
            boolean z2 = z && state.getPermissions().isEmpty();
            int i4 = (!z2 || (chatItem instanceof ChatItem.Assistant)) ? 0 : 1;
            int size = state.getItems().size() + state.getPermissions().size() + i4 + 1;
            Boolean valueOf = Boolean.valueOf(z);
            startRestartGroup.startReplaceGroup(1317233101);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(z);
            ChatScreenKt$ChatScreen$2$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new ChatScreenKt$ChatScreen$2$1(z, mutableState5, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue10, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1317235358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(rememberLazyListState);
            ChatScreenKt$ChatScreen$3$1 rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new ChatScreenKt$ChatScreen$3$1(rememberLazyListState, mutableState4, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(rememberLazyListState, (Function2) rememberedValue11, startRestartGroup, 0);
            Integer valueOf2 = Integer.valueOf(size);
            Integer valueOf3 = Integer.valueOf(uiState.getPermissions().size());
            startRestartGroup.startReplaceGroup(1317242933);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(size) | startRestartGroup.changed(rememberLazyListState);
            boolean z3 = z;
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = (Function2) new ChatScreenKt$ChatScreen$4$1(size, rememberLazyListState, mutableState4, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf2, chatItem, valueOf3, (Function2) rememberedValue12, startRestartGroup, 0);
            state = uiState;
            vm = appViewModel;
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1103707557, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: ChatScreen.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$2, reason: invalid class name */
                /* loaded from: /tmp/classes3.dex */
                public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ AppViewModel $vm;

                    AnonymousClass2(AppViewModel appViewModel) {
                        this.$vm = appViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel) {
                        appViewModel.back();
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C149@6963L13,149@6942L89:ChatScreen.kt#qn8u0p");
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1956720351, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:149)");
                        }
                        composer.startReplaceGroup(-1216744586);
                        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(this.$vm);
                        final AppViewModel appViewModel = this.$vm;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: CONSTRUCTOR (r1v2 'rememberedValue' java.lang.Object) = (r0v3 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:150) call: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$2$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.2.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "C149@6963L13,149@6942L89:ChatScreen.kt#qn8u0p"
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
                                java.lang.String r1 = "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:149)"
                                r2 = -1956720351(0xffffffff8b5ed121, float:-4.2912976E-32)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                            L24:
                                r14 = -1216744586(0xffffffffb779f376, float:-1.4898242E-5)
                                r13.startReplaceGroup(r14)
                                java.lang.String r14 = "CC(remember):ChatScreen.kt#9igjgp"
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
                                com.clozed.code.ui.ChatScreenKt$ChatScreen$5$2$$ExternalSyntheticLambda0 r1 = new com.clozed.code.ui.ChatScreenKt$ChatScreen$5$2$$ExternalSyntheticLambda0
                                r1.<init>(r0)
                                r13.updateRememberedValue(r1)
                            L4d:
                                r2 = r1
                                kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
                                r13.endReplaceGroup()
                                com.clozed.code.ui.ComposableSingletons$ChatScreenKt r14 = com.clozed.code.ui.ComposableSingletons$ChatScreenKt.INSTANCE
                                kotlin.jvm.functions.Function2 r8 = r14.m1400getLambda1$app_release()
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
                            throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.AnonymousClass2.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    public final void invoke(Composer composer3, int i5) {
                        ComposerKt.sourceInformation(composer3, "C179@8668L47,151@7075L1392,148@6920L129,176@8495L128,147@6876L1854:ChatScreen.kt#qn8u0p");
                        if ((i5 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1103707557, i5, -1, "com.clozed.code.ui.ChatScreen.<anonymous> (ChatScreen.kt:147)");
                            }
                            AppBarKt.TopAppBar-GHTll3U(ComposableLambdaKt.rememberComposableLambda(-1800739809, true, new AnonymousClass1(uiState, colorScheme, mutableState2, mutableState3), composer3, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1956720351, true, new AnonymousClass2(vm), composer3, 54), ComposableLambdaKt.rememberComposableLambda(-1850587318, true, new AnonymousClass3(vm), composer3, 54), 0.0f, (WindowInsets) null, TopAppBarDefaults.INSTANCE.topAppBarColors-5tl4gsc(colorScheme.getBackground-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composer3, TopAppBarDefaults.$stable << 18, 62), (TopAppBarScrollBehavior) null, composer3, 3462, ByteCode.GETSTATIC);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ChatScreen.kt */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$1, reason: invalid class name */
                    /* loaded from: /tmp/classes3.dex */
                    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ ColorScheme $cs;
                        final /* synthetic */ MutableState<Boolean> $showAgents$delegate;
                        final /* synthetic */ MutableState<Boolean> $showModels$delegate;
                        final /* synthetic */ UiState $state;

                        AnonymousClass1(UiState uiState, ColorScheme colorScheme, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
                            this.$state = uiState;
                            this.$cs = colorScheme;
                            this.$showModels$delegate = mutableState;
                            this.$showAgents$delegate = mutableState2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            String str;
                            String str2;
                            String str3;
                            String str4;
                            ComposerKt.sourceInformation(composer, "C152@7097L1352:ChatScreen.kt#qn8u0p");
                            if ((i & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1800739809, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:152)");
                            }
                            UiState uiState = this.$state;
                            ColorScheme colorScheme = this.$cs;
                            final MutableState<Boolean> mutableState = this.$showModels$delegate;
                            final MutableState<Boolean> mutableState2 = this.$showAgents$delegate;
                            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Modifier modifier = Modifier.Companion;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
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
                            ComposerKt.sourceInformationMarkerStart(composer, 147730762, "C155@7297L10,153@7130L216,158@7430L21,157@7371L1056:ChatScreen.kt#qn8u0p");
                            SessionInfo current = uiState.getCurrent();
                            if (current == null || (str = current.getTitle()) == null) {
                                str = "Session";
                            }
                            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 24960, 110590);
                            Modifier horizontalScroll$default = ScrollKt.horizontalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(6));
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
                            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, horizontalScroll$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer, 490574877, "C162@7715L21,162@7666L70,163@7807L21,163@7765L63:ChatScreen.kt#qn8u0p");
                            SessionInfo current2 = uiState.getCurrent();
                            if (current2 == null || (str2 = current2.getModel()) == null) {
                                str2 = "choose model";
                            }
                            composer.startReplaceGroup(-2062384132);
                            ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                            Object rememberedValue = composer.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0256: CONSTRUCTOR (r4v18 'rememberedValue' java.lang.Object) = (r4v1 'mutableState' androidx.compose.runtime.MutableState<java.lang.Boolean> A[DONT_INLINE]) A[MD:(androidx.compose.runtime.MutableState):void (m)] (LINE:163) call: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$1$$ExternalSyntheticLambda0.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.1.invoke(androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 25 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 898
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$5$lambda$4$lambda$1$lambda$0(MutableState mutableState) {
                                ChatScreenKt.ChatScreen$lambda$8(mutableState, true);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$5$lambda$4$lambda$3$lambda$2(MutableState mutableState) {
                                ChatScreenKt.ChatScreen$lambda$11(mutableState, true);
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: ChatScreen.kt */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        /* renamed from: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$3, reason: invalid class name */
                        /* loaded from: /tmp/classes3.dex */
                        public static final class AnonymousClass3 implements Function3<RowScope, Composer, Integer, Unit> {
                            final /* synthetic */ AppViewModel $vm;

                            AnonymousClass3(AppViewModel appViewModel) {
                                this.$vm = appViewModel;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$1$lambda$0(AppViewModel appViewModel) {
                                appViewModel.openSettings();
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TopAppBar, Composer composer, int i) {
                                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                                ComposerKt.sourceInformation(composer, "C177@8538L21,177@8517L88:ChatScreen.kt#qn8u0p");
                                if ((i & 17) == 16 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1850587318, i, -1, "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:177)");
                                }
                                composer.startReplaceGroup(-1216694178);
                                ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
                                boolean changedInstance = composer.changedInstance(this.$vm);
                                final AppViewModel appViewModel = this.$vm;
                                Object rememberedValue = composer.rememberedValue();
                                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: CONSTRUCTOR (r0v3 'rememberedValue' java.lang.Object) = (r14v1 'appViewModel' com.clozed.code.AppViewModel A[DONT_INLINE]) A[MD:(com.clozed.code.AppViewModel):void (m)] (LINE:178) call: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$3$$ExternalSyntheticLambda0.<init>(com.clozed.code.AppViewModel):void type: CONSTRUCTOR in method: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.ChatScreenKt$ChatScreen$5$3$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 25 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "$this$TopAppBar"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                                        java.lang.String r12 = "C177@8538L21,177@8517L88:ChatScreen.kt#qn8u0p"
                                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
                                        r12 = r14 & 17
                                        r0 = 16
                                        if (r12 != r0) goto L1b
                                        boolean r12 = r13.getSkipping()
                                        if (r12 != 0) goto L17
                                        goto L1b
                                    L17:
                                        r13.skipToGroupEnd()
                                        return
                                    L1b:
                                        boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r12 == 0) goto L2a
                                        r12 = -1
                                        java.lang.String r0 = "com.clozed.code.ui.ChatScreen.<anonymous>.<anonymous> (ChatScreen.kt:177)"
                                        r1 = -1850587318(0xffffffff91b2474a, float:-2.8127384E-28)
                                        androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r12, r0)
                                    L2a:
                                        r12 = -1216694178(0xffffffffb77ab85e, float:-1.49440875E-5)
                                        r13.startReplaceGroup(r12)
                                        java.lang.String r12 = "CC(remember):ChatScreen.kt#9igjgp"
                                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
                                        com.clozed.code.AppViewModel r12 = r11.$vm
                                        boolean r12 = r13.changedInstance(r12)
                                        com.clozed.code.AppViewModel r14 = r11.$vm
                                        java.lang.Object r0 = r13.rememberedValue()
                                        if (r12 != 0) goto L4b
                                        androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
                                        java.lang.Object r12 = r12.getEmpty()
                                        if (r0 != r12) goto L53
                                    L4b:
                                        com.clozed.code.ui.ChatScreenKt$ChatScreen$5$3$$ExternalSyntheticLambda0 r0 = new com.clozed.code.ui.ChatScreenKt$ChatScreen$5$3$$ExternalSyntheticLambda0
                                        r0.<init>(r14)
                                        r13.updateRememberedValue(r0)
                                    L53:
                                        r1 = r0
                                        kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
                                        r13.endReplaceGroup()
                                        com.clozed.code.ui.ComposableSingletons$ChatScreenKt r12 = com.clozed.code.ui.ComposableSingletons$ChatScreenKt.INSTANCE
                                        kotlin.jvm.functions.Function2 r7 = r12.m1409getLambda2$app_release()
                                        r9 = 1572864(0x180000, float:2.204052E-39)
                                        r10 = 62
                                        r2 = 0
                                        r3 = 0
                                        r4 = 0
                                        r5 = 0
                                        r6 = 0
                                        r8 = r13
                                        androidx.compose.material3.IconButtonKt.IconButton(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                                        boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r12 == 0) goto L75
                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                    L75:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$5.AnonymousClass3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                                }
                            }
                        }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-2056909190, true, new ChatScreenKt$ChatScreen$6(colorScheme, z3, mutableState, mutableState6, uiState, rememberLauncherForActivityResult, mutableState7, appViewModel, mutableState5, mutableState4), startRestartGroup, 54), (Function2) null, (Function2) null, 0, colorScheme.getBackground-0d7_KjU(), 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1090446608, true, new ChatScreenKt$ChatScreen$7(rememberLazyListState, state, colorScheme, mutableState, z2, chatItem, appViewModel, i4), startRestartGroup, 54), startRestartGroup, 805306800, 441);
                        composer2 = startRestartGroup;
                        composer2.startReplaceGroup(1317575073);
                        ComposerKt.sourceInformation(composer2, "331@17149L23,335@17420L133,338@17583L76,330@17105L565");
                        if (ChatScreen$lambda$16(mutableState5)) {
                            composer2.startReplaceGroup(1317576770);
                            str = "CC(remember):ChatScreen.kt#9igjgp";
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue13 = composer2.rememberedValue();
                            if (rememberedValue13 == Composer.Companion.getEmpty()) {
                                rememberedValue13 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit ChatScreen$lambda$31$lambda$30;
                                        ChatScreen$lambda$31$lambda$30 = ChatScreenKt.ChatScreen$lambda$31$lambda$30(mutableState5);
                                        return ChatScreen$lambda$31$lambda$30;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue13);
                            }
                            composer2.endReplaceGroup();
                            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue13, ComposableLambdaKt.rememberComposableLambda(978964588, true, new ChatScreenKt$ChatScreen$9(vm, mutableState5, colorScheme), composer2, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-668398354, true, new ChatScreenKt$ChatScreen$10(mutableState5), composer2, 54), ComposableSingletons$ChatScreenKt.INSTANCE.m1415getLambda8$app_release(), ComposableSingletons$ChatScreenKt.INSTANCE.m1416getLambda9$app_release(), ComposableSingletons$ChatScreenKt.INSTANCE.m1401getLambda10$app_release(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1797174, 0, 16260);
                            composer2 = composer2;
                        } else {
                            str = "CC(remember):ChatScreen.kt#9igjgp";
                        }
                        composer2.endReplaceGroup();
                        composer2.startReplaceGroup(1317594218);
                        ComposerKt.sourceInformation(composer2, "345@17810L11,346@17841L17,347@17881L22,348@17929L22,350@18056L55,342@17707L415");
                        if (ChatScreen$lambda$7(mutableState2)) {
                            List<ModelOpt> models = state.getModels();
                            composer2.startReplaceGroup(1317597910);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue14 = composer2.rememberedValue();
                            if (rememberedValue14 == Composer.Companion.getEmpty()) {
                                rememberedValue14 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        String ChatScreen$lambda$33$lambda$32;
                                        ChatScreen$lambda$33$lambda$32 = ChatScreenKt.ChatScreen$lambda$33$lambda$32((ModelOpt) obj);
                                        return ChatScreen$lambda$33$lambda$32;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue14);
                            }
                            Function1 function1 = (Function1) rememberedValue14;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317598908);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue15 = composer2.rememberedValue();
                            if (rememberedValue15 == Composer.Companion.getEmpty()) {
                                rememberedValue15 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        String ChatScreen$lambda$35$lambda$34;
                                        ChatScreen$lambda$35$lambda$34 = ChatScreenKt.ChatScreen$lambda$35$lambda$34((ModelOpt) obj);
                                        return ChatScreen$lambda$35$lambda$34;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue15);
                            }
                            Function1 function12 = (Function1) rememberedValue15;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317600193);
                            ComposerKt.sourceInformation(composer2, str);
                            boolean changedInstance2 = composer2.changedInstance(vm);
                            Object rememberedValue16 = composer2.rememberedValue();
                            if (changedInstance2 || rememberedValue16 == Composer.Companion.getEmpty()) {
                                rememberedValue16 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit ChatScreen$lambda$37$lambda$36;
                                        ChatScreen$lambda$37$lambda$36 = ChatScreenKt.ChatScreen$lambda$37$lambda$36(AppViewModel.this, (ModelOpt) obj);
                                        return ChatScreen$lambda$37$lambda$36;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue16);
                            }
                            Function1 function13 = (Function1) rememberedValue16;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317601729);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue17 = composer2.rememberedValue();
                            if (rememberedValue17 == Composer.Companion.getEmpty()) {
                                rememberedValue17 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit ChatScreen$lambda$39$lambda$38;
                                        ChatScreen$lambda$39$lambda$38 = ChatScreenKt.ChatScreen$lambda$39$lambda$38(mutableState2);
                                        return ChatScreen$lambda$39$lambda$38;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue17);
                            }
                            composer2.endReplaceGroup();
                            Composer composer3 = composer2;
                            SheetsKt.PickerSheet("Choose model", models, function1, function12, function13, (Function0) rememberedValue17, "No models found. First add an API key in Settings (⚙).", ComposableLambdaKt.rememberComposableLambda(-2070592148, true, new Function3<Function0<? extends Unit>, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$ChatScreen$15
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer4, Integer num) {
                                    invoke((Function0<Unit>) function0, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function0<Unit> dismiss, Composer composer4, int i5) {
                                    Intrinsics.checkNotNullParameter(dismiss, "dismiss");
                                    ComposerKt.sourceInformation(composer4, "C350@18069L40:ChatScreen.kt#qn8u0p");
                                    if ((i5 & 6) == 0) {
                                        i5 |= composer4.changedInstance(dismiss) ? 4 : 2;
                                    }
                                    if ((i5 & 19) == 18 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2070592148, i5, -1, "com.clozed.code.ui.ChatScreen.<anonymous> (ChatScreen.kt:350)");
                                    }
                                    ChatExtrasKt.ProviderChips(AppViewModel.this, state.getModels(), dismiss, composer4, (i5 << 6) & 896);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer3, 14355846, 0);
                            composer2 = composer3;
                        }
                        composer2.endReplaceGroup();
                        composer2.startReplaceGroup(1317608297);
                        ComposerKt.sourceInformation(composer2, "353@18174L20,353@18147L48");
                        if (ChatScreen$lambda$22(mutableState7)) {
                            composer2.startReplaceGroup(1317609567);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue18 = composer2.rememberedValue();
                            if (rememberedValue18 == Composer.Companion.getEmpty()) {
                                rememberedValue18 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit ChatScreen$lambda$41$lambda$40;
                                        ChatScreen$lambda$41$lambda$40 = ChatScreenKt.ChatScreen$lambda$41$lambda$40(mutableState7);
                                        return ChatScreen$lambda$41$lambda$40;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue18);
                            }
                            composer2.endReplaceGroup();
                            ChatExtrasKt.PortDialog(vm, (Function0) rememberedValue18, composer2, ((i3 >> 3) & 14) | 48);
                        }
                        composer2.endReplaceGroup();
                        if (ChatScreen$lambda$10(mutableState3)) {
                            List<AgentOpt> agents = state.getAgents();
                            composer2.startReplaceGroup(1317614518);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue19 = composer2.rememberedValue();
                            if (rememberedValue19 == Composer.Companion.getEmpty()) {
                                rememberedValue19 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        String ChatScreen$lambda$43$lambda$42;
                                        ChatScreen$lambda$43$lambda$42 = ChatScreenKt.ChatScreen$lambda$43$lambda$42((AgentOpt) obj);
                                        return ChatScreen$lambda$43$lambda$42;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue19);
                            }
                            Function1 function14 = (Function1) rememberedValue19;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317615523);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue20 = composer2.rememberedValue();
                            if (rememberedValue20 == Composer.Companion.getEmpty()) {
                                rememberedValue20 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        String ChatScreen$lambda$45$lambda$44;
                                        ChatScreen$lambda$45$lambda$44 = ChatScreenKt.ChatScreen$lambda$45$lambda$44((AgentOpt) obj);
                                        return ChatScreen$lambda$45$lambda$44;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue20);
                            }
                            Function1 function15 = (Function1) rememberedValue20;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317617025);
                            ComposerKt.sourceInformation(composer2, str);
                            boolean changedInstance3 = composer2.changedInstance(vm);
                            Object rememberedValue21 = composer2.rememberedValue();
                            if (changedInstance3 || rememberedValue21 == Composer.Companion.getEmpty()) {
                                rememberedValue21 = new Function1() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit ChatScreen$lambda$47$lambda$46;
                                        ChatScreen$lambda$47$lambda$46 = ChatScreenKt.ChatScreen$lambda$47$lambda$46(AppViewModel.this, (AgentOpt) obj);
                                        return ChatScreen$lambda$47$lambda$46;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue21);
                            }
                            Function1 function16 = (Function1) rememberedValue21;
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1317618561);
                            ComposerKt.sourceInformation(composer2, str);
                            Object rememberedValue22 = composer2.rememberedValue();
                            if (rememberedValue22 == Composer.Companion.getEmpty()) {
                                rememberedValue22 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit ChatScreen$lambda$49$lambda$48;
                                        ChatScreen$lambda$49$lambda$48 = ChatScreenKt.ChatScreen$lambda$49$lambda$48(mutableState3);
                                        return ChatScreen$lambda$49$lambda$48;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue22);
                            }
                            composer2.endReplaceGroup();
                            Composer composer4 = composer2;
                            SheetsKt.PickerSheet("Choose agent", agents, function14, function15, function16, (Function0) rememberedValue22, "No agents found.", null, composer4, 1772934, 128);
                            composer2 = composer4;
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ChatScreen$lambda$50;
                                ChatScreen$lambda$50 = ChatScreenKt.ChatScreen$lambda$50(UiState.this, vm, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ChatScreen$lambda$50;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$1$lambda$0(AppViewModel appViewModel) {
                    appViewModel.back();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final MutableState ChatScreen$lambda$3$lambda$2() {
                    return SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String ChatScreen$lambda$4(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                private static final boolean ChatScreen$lambda$7(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ChatScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                private static final boolean ChatScreen$lambda$10(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ChatScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final boolean ChatScreen$lambda$13(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ChatScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                private static final boolean ChatScreen$lambda$16(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ChatScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final List<String> ChatScreen$lambda$19(MutableState<List<String>> mutableState) {
                    return (List) ((State) mutableState).getValue();
                }

                private static final boolean ChatScreen$lambda$22(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ChatScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$26$lambda$25(MutableState mutableState, List uris) {
                    Intrinsics.checkNotNullParameter(uris, "uris");
                    List<String> ChatScreen$lambda$19 = ChatScreen$lambda$19(mutableState);
                    List list = uris;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String uri = ((Uri) it.next()).toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                        arrayList.add(uri);
                    }
                    mutableState.setValue(CollectionsKt.take(CollectionsKt.distinct(CollectionsKt.plus((Collection) ChatScreen$lambda$19, (Iterable) arrayList)), 6));
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$31$lambda$30(MutableState mutableState) {
                    ChatScreen$lambda$17(mutableState, false);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String ChatScreen$lambda$33$lambda$32(ModelOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getName();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String ChatScreen$lambda$35$lambda$34(ModelOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getProviderId();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$37$lambda$36(AppViewModel appViewModel, ModelOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    appViewModel.switchModel(it);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$39$lambda$38(MutableState mutableState) {
                    ChatScreen$lambda$8(mutableState, false);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$41$lambda$40(MutableState mutableState) {
                    ChatScreen$lambda$23(mutableState, false);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String ChatScreen$lambda$43$lambda$42(AgentOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getName();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String ChatScreen$lambda$45$lambda$44(AgentOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String description = it.getDescription();
                    return description == null ? "" : description;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$47$lambda$46(AppViewModel appViewModel, AgentOpt it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    appViewModel.switchAgent(it);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ChatScreen$lambda$49$lambda$48(MutableState mutableState) {
                    ChatScreen$lambda$11(mutableState, false);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void MiniChip(final String str, final Function0<Unit> function0, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(-1055863501);
                    ComposerKt.sourceInformation(startRestartGroup, "C(MiniChip)P(1)371@18671L73,369@18616L272:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i & 48) == 0) {
                        i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
                    }
                    if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1055863501, i2, -1, "com.clozed.code.ui.MiniChip (ChatScreen.kt:368)");
                        }
                        ChipKt.AssistChip(function0, ComposableLambdaKt.rememberComposableLambda(157031728, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$MiniChip$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i3) {
                                ComposerKt.sourceInformation(composer2, "C371@18706L10,371@18673L69:ChatScreen.kt#qn8u0p");
                                if ((i3 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(157031728, i3, -1, "com.clozed.code.ui.MiniChip.<anonymous> (ChatScreen.kt:371)");
                                }
                                TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 0, 24576, 114686);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), SizeKt.height-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(30)), false, (Function2) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1402getLambda11$app_release(), (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, startRestartGroup, ((i2 >> 3) & 14) | 197040, 0, 2008);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit MiniChip$lambda$51;
                                MiniChip$lambda$51 = ChatScreenKt.MiniChip$lambda$51(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                                return MiniChip$lambda$51;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void UserBubble(final ChatItem.User user, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(818566649);
                    ComposerKt.sourceInformation(startRestartGroup, "C(UserBubble)379@18974L11,380@18990L732:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changed(user) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(818566649, i2, -1, "com.clozed.code.ui.UserBubble (ChatScreen.kt:378)");
                        }
                        MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, Alignment.Companion.getTop(), startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                        Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                            composer2.updateRememberedValue(Integer.valueOf(hashCode));
                            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2085024512, "C381@19070L646:ChatScreen.kt#qn8u0p");
                        float f = 20;
                        Modifier modifier = PaddingKt.padding-VpY3zN4(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth(Modifier.Companion, 0.88f), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.m826constructorimpl(f), Dp.m826constructorimpl(f), Dp.m826constructorimpl(4), Dp.m826constructorimpl(f))), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.box-impl(ColorKt.Color(4278879487L)), Color.box-impl(ColorKt.Color(4278212822L))}), 0L, 0L, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), Dp.m826constructorimpl(14), Dp.m826constructorimpl(10));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1266476391, "C388@19405L301,388@19386L320:ChatScreen.kt#qn8u0p");
                        SelectionContainerKt.SelectionContainer((Modifier) null, ComposableLambdaKt.rememberComposableLambda(1870032908, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$UserBubble$1$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i3) {
                                String str;
                                ComposerKt.sourceInformation(composer4, "C391@19653L10,389@19423L269:ChatScreen.kt#qn8u0p");
                                if ((i3 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1870032908, i3, -1, "com.clozed.code.ui.UserBubble.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:389)");
                                    }
                                    String text = ChatItem.User.this.getText();
                                    if (ChatItem.User.this.getFileCount() > 0) {
                                        str = (StringsKt.isBlank(ChatItem.User.this.getText()) ? "" : "\n") + "🖼 " + ChatItem.User.this.getFileCount() + " image" + (ChatItem.User.this.getFileCount() > 1 ? "s" : "");
                                    }
                                    TextKt.Text-Nvy7gAk(text + str, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyLarge(), composer4, 384, 0, 131066);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), startRestartGroup, 48, 1);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UserBubble$lambda$54;
                                UserBubble$lambda$54 = ChatScreenKt.UserBubble$lambda$54(ChatItem.User.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return UserBubble$lambda$54;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void AssistantBubble(final ChatItem.Assistant assistant, final boolean z, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(-1086447047);
                    ComposerKt.sourceInformation(startRestartGroup, "C(AssistantBubble)400@19813L210:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changedInstance(assistant) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i & 48) == 0) {
                        i2 |= startRestartGroup.changed(z) ? 32 : 16;
                    }
                    if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1086447047, i2, -1, "com.clozed.code.ui.AssistantBubble (ChatScreen.kt:399)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                        Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                            composer2.updateRememberedValue(Integer.valueOf(hashCode));
                            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -377615, "C401@19905L46,402@19960L57:ChatScreen.kt#qn8u0p");
                        LogoMotionKt.m1505LogoBadgeorJrPs(Dp.m826constructorimpl(28), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(2), 0.0f, 0.0f, 13, (Object) null), startRestartGroup, 54, 0);
                        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 410722662, "C402@19987L28:ChatScreen.kt#qn8u0p");
                        AssistantContent(assistant, z, startRestartGroup, i2 & 126);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit AssistantBubble$lambda$57;
                                AssistantBubble$lambda$57 = ChatScreenKt.AssistantBubble$lambda$57(ChatItem.Assistant.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                                return AssistantBubble$lambda$57;
                            }
                        });
                    }
                }

                private static final void AssistantContent(final ChatItem.Assistant assistant, final boolean z, Composer composer, final int i) {
                    Composer startRestartGroup = composer.startRestartGroup(1556156940);
                    ComposerKt.sourceInformation(startRestartGroup, "C(AssistantContent)408@20138L11,409@20154L1103:ChatScreen.kt#qn8u0p");
                    int i2 = (i & 6) == 0 ? (startRestartGroup.changedInstance(assistant) ? 4 : 2) | i : i;
                    if ((i & 48) == 0) {
                        i2 |= startRestartGroup.changed(z) ? 32 : 16;
                    }
                    if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1556156940, i2, -1, "com.clozed.code.ui.AssistantContent (ChatScreen.kt:407)");
                        }
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -617232203, "C:ChatScreen.kt#qn8u0p");
                        startRestartGroup.startReplaceGroup(-1821026505);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        for (Block block : assistant.getBlocks()) {
                            if (block instanceof Block.Text) {
                                startRestartGroup.startReplaceGroup(1136255445);
                                ComposerKt.sourceInformation(startRestartGroup, "412@20351L20");
                                Block.Text text = (Block.Text) block;
                                if (!StringsKt.isBlank(text.getText())) {
                                    MarkdownKt.MarkdownText(text.getText(), null, startRestartGroup, 0, 2);
                                }
                                startRestartGroup.endReplaceGroup();
                            } else if (block instanceof Block.Reasoning) {
                                startRestartGroup.startReplaceGroup(-378985930);
                                ComposerKt.sourceInformation(startRestartGroup, "413@20410L22");
                                ReasoningBlock(((Block.Reasoning) block).getText(), startRestartGroup, 0);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                if (!(block instanceof Block.Tool)) {
                                    startRestartGroup.startReplaceGroup(-378989839);
                                    startRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                startRestartGroup.startReplaceGroup(-378984149);
                                ComposerKt.sourceInformation(startRestartGroup, "414@20466L11");
                                ToolCard((Block.Tool) block, startRestartGroup, 0);
                                startRestartGroup.endReplaceGroup();
                            }
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1821018502);
                        ComposerKt.sourceInformation(startRestartGroup, "418@20537L52");
                        if (z) {
                            LogoMotionKt.AgentWorkingIndicator(assistant.getBlocks().isEmpty(), null, startRestartGroup, 0, 2);
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1821014970);
                        ComposerKt.sourceInformation(startRestartGroup, "421@20749L334,421@20643L440");
                        if (assistant.getError() != null) {
                            SurfaceKt.Surface-T9BRK9s((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(12)), colorScheme.getErrorContainer-0d7_KjU(), colorScheme.getOnErrorContainer-0d7_KjU(), 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1911177745, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$AssistantContent$1$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i3) {
                                    ComposerKt.sourceInformation(composer3, "C422@20767L302:ChatScreen.kt#qn8u0p");
                                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1911177745, i3, -1, "com.clozed.code.ui.AssistantContent.<anonymous>.<anonymous> (ChatScreen.kt:422)");
                                    }
                                    Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(10));
                                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    ChatItem.Assistant assistant2 = ChatItem.Assistant.this;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer3, 54);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifier);
                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composer4 = Updater.constructor-impl(composer3);
                                    Updater.set-impl(composer4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                                        composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                                        composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                                    }
                                    Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                    RowScope rowScope = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -425643937, "C423@20918L55,424@21030L10,424@20994L57:ChatScreen.kt#qn8u0p");
                                    IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16)), 0L, composer3, 432, 8);
                                    TextKt.Text-Nvy7gAk(assistant2.getError(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 0, 0, 131070);
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
                            }, startRestartGroup, 54), startRestartGroup, 12582912, 113);
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1820999498);
                        ComposerKt.sourceInformation(startRestartGroup, "429@21219L10,429@21154L87");
                        if (!StringsKt.isBlank(assistant.getModel()) && !z) {
                            TextKt.Text-Nvy7gAk(assistant.getModel(), (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelSmall(), startRestartGroup, 0, 0, 131066);
                            startRestartGroup = startRestartGroup;
                        }
                        startRestartGroup.endReplaceGroup();
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit AssistantContent$lambda$60;
                                AssistantContent$lambda$60 = ChatScreenKt.AssistantContent$lambda$60(ChatItem.Assistant.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                                return AssistantContent$lambda$60;
                            }
                        });
                    }
                }

                private static final void ReasoningBlock(final String str, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(1098938507);
                    ComposerKt.sourceInformation(startRestartGroup, "C(ReasoningBlock)436@21332L34,437@21394L11,444@21605L16,439@21452L942:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1098938507, i2, -1, "com.clozed.code.ui.ReasoningBlock (ChatScreen.kt:435)");
                        }
                        startRestartGroup.startReplaceGroup(727919384);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        float f = 12;
                        Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(f));
                        Modifier modifier = BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), shape), Dp.m826constructorimpl(1), colorScheme.getOutlineVariant-0d7_KjU(), shape);
                        startRestartGroup.startReplaceGroup(727928102);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit ReasoningBlock$lambda$65$lambda$64;
                                    ReasoningBlock$lambda$65$lambda$64 = ChatScreenKt.ReasoningBlock$lambda$65$lambda$64(mutableState);
                                    return ReasoningBlock$lambda$65$lambda$64;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier animateContentSize$default = AnimationModifierKt.animateContentSize$default(PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) rememberedValue2, 15, (Object) null), Dp.m826constructorimpl(f)), (FiniteAnimationSpec) null, (Function2) null, 3, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, animateContentSize$default);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -811467841, "C448@21701L514:ChatScreen.kt#qn8u0p");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier modifier2 = Modifier.Companion;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
                        Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                        }
                        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2121764167, "C449@21767L91,451@21958L10,450@21871L172,454@22056L149:ChatScreen.kt#qn8u0p");
                        IconKt.Icon-ww6aTOc(InfoKt.getInfo(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16)), colorScheme.getOnSurfaceVariant-0d7_KjU(), startRestartGroup, 432, 0);
                        int i3 = i2;
                        TextKt.Text-Nvy7gAk("  Thinking", RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), startRestartGroup, 6, 0, 131064);
                        startRestartGroup = startRestartGroup;
                        IconKt.Icon-ww6aTOc(ReasoningBlock$lambda$62(mutableState) ? KeyboardArrowUpKt.getKeyboardArrowUp(Icons.INSTANCE.getDefault()) : KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), colorScheme.getOnSurfaceVariant-0d7_KjU(), startRestartGroup, 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.startReplaceGroup(-2104370151);
                        ComposerKt.sourceInformation(startRestartGroup, "456@22296L10,456@22234L154");
                        if (ReasoningBlock$lambda$62(mutableState)) {
                            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(8), 0.0f, 0.0f, 13, (Object) null), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, FontStyle.m385boximpl(FontStyle.INSTANCE.m394getItalic_LCdwA()), (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, (i3 & 14) | 48, 0, 131032);
                            startRestartGroup = startRestartGroup;
                        }
                        startRestartGroup.endReplaceGroup();
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ReasoningBlock$lambda$68;
                                ReasoningBlock$lambda$68 = ChatScreenKt.ReasoningBlock$lambda$68(str, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ReasoningBlock$lambda$68;
                            }
                        });
                    }
                }

                private static final boolean ReasoningBlock$lambda$62(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                private static final void ReasoningBlock$lambda$63(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ReasoningBlock$lambda$65$lambda$64(MutableState mutableState) {
                    ReasoningBlock$lambda$63(mutableState, !ReasoningBlock$lambda$62(mutableState));
                    return Unit.INSTANCE;
                }

                private static final void ToolCard(final Block.Tool tool, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(-1767663075);
                    ComposerKt.sourceInformation(startRestartGroup, "C(ToolCard)462@22464L34,463@22526L11,470@22733L16,465@22584L1339:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changed(tool) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1767663075, i2, -1, "com.clozed.code.ui.ToolCard (ChatScreen.kt:461)");
                        }
                        startRestartGroup.startReplaceGroup(-1801700271);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(14))), colorScheme.getSurfaceContainerLow-0d7_KjU(), (Shape) null, 2, (Object) null);
                        startRestartGroup.startReplaceGroup(-1801691681);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit ToolCard$lambda$73$lambda$72;
                                    ToolCard$lambda$73$lambda$72 = ChatScreenKt.ToolCard$lambda$73$lambda$72(mutableState);
                                    return ToolCard$lambda$73$lambda$72;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier animateContentSize$default = AnimationModifierKt.animateContentSize$default(PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) rememberedValue2, 15, (Object) null), Dp.m826constructorimpl(12)), (FiniteAnimationSpec) null, (Function2) null, 3, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, animateContentSize$default);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -655470539, "C474@22829L874:ChatScreen.kt#qn8u0p");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier modifier2 = Modifier.Companion;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, startRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
                        Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                        }
                        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -218602772, "C480@23304L46,481@23430L10,481@23363L168,482@23544L149:ChatScreen.kt#qn8u0p");
                        String status = tool.getStatus();
                        if (Intrinsics.areEqual(status, "completed")) {
                            startRestartGroup.startReplaceGroup(-218574191);
                            ComposerKt.sourceInformation(startRestartGroup, "476@23049L5,476@22996L100");
                            IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16)), com.clozed.code.ui.theme.ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable).m1573getSuccess0d7_KjU(), startRestartGroup, 432, 0);
                            startRestartGroup.endReplaceGroup();
                        } else if (Intrinsics.areEqual(status, "error")) {
                            startRestartGroup.startReplaceGroup(-218447804);
                            ComposerKt.sourceInformation(startRestartGroup, "477@23124L81");
                            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16)), colorScheme.getError-0d7_KjU(), startRestartGroup, 432, 0);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(1516977308);
                            ComposerKt.sourceInformation(startRestartGroup, "478@23263L5,478@23230L47");
                            LogoMotionKt.m1508LogoSpinner8s8adOk(Dp.m826constructorimpl(16), com.clozed.code.ui.theme.ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable).m1575getWarning0d7_KjU(), null, startRestartGroup, 6, 4);
                            startRestartGroup = startRestartGroup;
                            startRestartGroup.endReplaceGroup();
                        }
                        Composer composer4 = startRestartGroup;
                        TextKt.Text-Nvy7gAk(tool.getName(), (Modifier) null, colorScheme.getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TypeKt.getMono(), composer4, 0, 12582912, 131066);
                        TextKt.Text-Nvy7gAk(tool.getSummary(), RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall(), composer4, 0, 24960, 110584);
                        startRestartGroup = composer4;
                        IconKt.Icon-ww6aTOc(ToolCard$lambda$70(mutableState) ? KeyboardArrowUpKt.getKeyboardArrowUp(Icons.INSTANCE.getDefault()) : KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(18)), colorScheme.getOnSurfaceVariant-0d7_KjU(), startRestartGroup, 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.startReplaceGroup(1087261658);
                        ComposerKt.sourceInformation(startRestartGroup, "484@23739L17");
                        if (Intrinsics.areEqual(tool.getName(), "todowrite")) {
                            TodoList(tool.getInput(), startRestartGroup, 0);
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(1087263462);
                        ComposerKt.sourceInformation(startRestartGroup, "487@23880L27");
                        if (ToolCard$lambda$70(mutableState)) {
                            startRestartGroup.startReplaceGroup(1087264129);
                            ComposerKt.sourceInformation(startRestartGroup, "486@23815L25");
                            if (!StringsKt.isBlank(tool.getInput())) {
                                MonoBox("input", tool.getInput(), startRestartGroup, 6);
                            }
                            startRestartGroup.endReplaceGroup();
                            if (!StringsKt.isBlank(tool.getOutput())) {
                                MonoBox("output", tool.getOutput(), startRestartGroup, 6);
                            }
                        }
                        startRestartGroup.endReplaceGroup();
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ToolCard$lambda$76;
                                ToolCard$lambda$76 = ChatScreenKt.ToolCard$lambda$76(Block.Tool.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ToolCard$lambda$76;
                            }
                        });
                    }
                }

                private static final boolean ToolCard$lambda$70(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                private static final void ToolCard$lambda$71(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit ToolCard$lambda$73$lambda$72(MutableState mutableState) {
                    ToolCard$lambda$71(mutableState, !ToolCard$lambda$70(mutableState));
                    return Unit.INSTANCE;
                }

                private static final void MonoBox(final String str, String str2, Composer composer, final int i) {
                    int i2;
                    Composer composer2;
                    final String str3;
                    Composer startRestartGroup = composer.startRestartGroup(1846840041);
                    ComposerKt.sourceInformation(startRestartGroup, "C(MonoBox)494@24017L11,495@24033L501:ChatScreen.kt#qn8u0p");
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
                            ComposerKt.traceEventStart(1846840041, i2, -1, "com.clozed.code.ui.MonoBox (ChatScreen.kt:493)");
                        }
                        final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        float f = 8;
                        Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(f), 0.0f, 0.0f, 13, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -609726429, "C496@24143L10,496@24080L85,502@24369L21,497@24174L354:ChatScreen.kt#qn8u0p");
                        TextKt.Text-Nvy7gAk(str, (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelSmall(), startRestartGroup, i2 & 14, 0, 131066);
                        composer2 = startRestartGroup;
                        Modifier modifier2 = PaddingKt.padding-3ABfNKs(ScrollKt.horizontalScroll$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(f))), colorScheme.getSurfaceContainerLowest-0d7_KjU(), (Shape) null, 2, (Object) null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.m826constructorimpl(10));
                        ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifier2);
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
                        Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                            composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                            composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                        }
                        Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1174280705, "C505@24468L50,505@24449L69:ChatScreen.kt#qn8u0p");
                        str3 = str2;
                        SelectionContainerKt.SelectionContainer((Modifier) null, ComposableLambdaKt.rememberComposableLambda(352917034, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatScreenKt$MonoBox$1$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i3) {
                                ComposerKt.sourceInformation(composer5, "C505@24470L46:ChatScreen.kt#qn8u0p");
                                if ((i3 & 3) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(352917034, i3, -1, "com.clozed.code.ui.MonoBox.<anonymous>.<anonymous>.<anonymous> (ChatScreen.kt:505)");
                                }
                                TextStyle mono = TypeKt.getMono();
                                TextKt.Text-Nvy7gAk(str3, (Modifier) null, colorScheme.getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, mono, composer5, 0, 12582912, 131066);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 48, 1);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit MonoBox$lambda$79;
                                MonoBox$lambda$79 = ChatScreenKt.MonoBox$lambda$79(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                                return MonoBox$lambda$79;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void ShellCard(final ChatItem.Shell shell, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(-1499396499);
                    ComposerKt.sourceInformation(startRestartGroup, "C(ShellCard)512@24620L11,513@24636L281:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changed(shell) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1499396499, i2, -1, "com.clozed.code.ui.ShellCard (ChatScreen.kt:511)");
                        }
                        Modifier modifier = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(14))), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceContainerLow-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.m826constructorimpl(12));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 368787700, "C514@24819L5,514@24760L73:ChatScreen.kt#qn8u0p");
                        TextKt.Text-Nvy7gAk("$ " + shell.getCommand(), (Modifier) null, com.clozed.code.ui.theme.ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable).m1573getSuccess0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TypeKt.getMono(), startRestartGroup, 0, 12582912, 131066);
                        startRestartGroup = startRestartGroup;
                        startRestartGroup.startReplaceGroup(1813014237);
                        ComposerKt.sourceInformation(startRestartGroup, "515@24869L42");
                        if (!StringsKt.isBlank(shell.getOutput())) {
                            MonoBox(shell.getStatus(), StringsKt.takeLast(shell.getOutput(), 4000), startRestartGroup, 0);
                        }
                        startRestartGroup.endReplaceGroup();
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ShellCard$lambda$81;
                                ShellCard$lambda$81 = ChatScreenKt.ShellCard$lambda$81(ChatItem.Shell.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ShellCard$lambda$81;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void PermissionCard(final PermissionReq permissionReq, final Function1<? super String, Unit> function1, Composer composer, final int i) {
                    int i2;
                    Composer startRestartGroup = composer.startRestartGroup(-998089242);
                    ComposerKt.sourceInformation(startRestartGroup, "C(PermissionCard)P(1)521@25039L5,523@25085L92,526@25272L1352,522@25049L1575:ChatScreen.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changedInstance(permissionReq) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i & 48) == 0) {
                        i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                    }
                    if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-998089242, i2, -1, "com.clozed.code.ui.PermissionCard (ChatScreen.kt:520)");
                        }
                        ExtraColors extra = com.clozed.code.ui.theme.ColorKt.getExtra(MaterialTheme.INSTANCE, startRestartGroup, MaterialTheme.$stable);
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(20)), CardDefaults.INSTANCE.cardColors-ro_MJ88(extra.m1576getWarningContainer0d7_KjU(), extra.m1572getOnWarningContainer0d7_KjU(), 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 12), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(829862232, true, new ChatScreenKt$PermissionCard$1(permissionReq, function1), startRestartGroup, 54), startRestartGroup, 196614, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit PermissionCard$lambda$82;
                                PermissionCard$lambda$82 = ChatScreenKt.PermissionCard$lambda$82(PermissionReq.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                                return PermissionCard$lambda$82;
                            }
                        });
                    }
                }

                private static final void TodoList(final String str, Composer composer, final int i) {
                    ArrayList emptyList;
                    Composer composer2;
                    String str2;
                    Composer startRestartGroup = composer.startRestartGroup(-1433453760);
                    ComposerKt.sourceInformation(startRestartGroup, "C(TodoList)550@26705L11,551@26733L323,557@27061L461:ChatScreen.kt#qn8u0p");
                    int i2 = (i & 6) == 0 ? (startRestartGroup.changed(str) ? 4 : 2) | i : i;
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1433453760, i2, -1, "com.clozed.code.ui.TodoList (ChatScreen.kt:549)");
                        }
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
                        startRestartGroup.startReplaceGroup(-865001138);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatScreen.kt#9igjgp");
                        boolean z = (i2 & 14) == 4;
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (z || rememberedValue == Composer.Companion.getEmpty()) {
                            try {
                                JSONArray optJSONArray = new JSONObject(str).optJSONArray("todos");
                                if (optJSONArray == null) {
                                    emptyList = CollectionsKt.emptyList();
                                } else {
                                    IntRange until = RangesKt.until(0, optJSONArray.length());
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                                    Iterator<Integer> it = until.iterator();
                                    while (it.hasNext()) {
                                        int nextInt = ((IntIterator) it).nextInt();
                                        arrayList.add(TuplesKt.to(optJSONArray.getJSONObject(nextInt).optString(NotificationCompat.CATEGORY_STATUS), optJSONArray.getJSONObject(nextInt).optString("content")));
                                    }
                                    emptyList = arrayList;
                                }
                            } catch (Exception unused) {
                                emptyList = CollectionsKt.emptyList();
                            }
                            rememberedValue = emptyList;
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        List<Pair> list = (List) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(8), 0.0f, 0.0f, 13, (Object) null);
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(3));
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -824790541, "C:ChatScreen.kt#qn8u0p");
                        startRestartGroup.startReplaceGroup(-1550626614);
                        ComposerKt.sourceInformation(startRestartGroup, "*561@27364L10,560@27308L198");
                        for (Pair pair : list) {
                            String str3 = (String) pair.component1();
                            String str4 = (String) pair.component2();
                            int hashCode2 = str3.hashCode();
                            if (hashCode2 == -1402931637) {
                                if (str3.equals("completed")) {
                                    str2 = "☑";
                                }
                                str2 = "☐";
                            } else if (hashCode2 != -753541113) {
                                if (hashCode2 == 476588369 && str3.equals("cancelled")) {
                                    str2 = "✕";
                                }
                                str2 = "☐";
                            } else {
                                if (str3.equals("in_progress")) {
                                    str2 = "▶";
                                }
                                str2 = "☐";
                            }
                            Composer composer4 = startRestartGroup;
                            TextKt.Text-Nvy7gAk(str2 + " " + str4, (Modifier) null, (Intrinsics.areEqual(str3, "completed") || Intrinsics.areEqual(str3, "cancelled")) ? colorScheme.getOnSurfaceVariant-0d7_KjU() : colorScheme.getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer4, 0, 0, 131066);
                            startRestartGroup = composer4;
                        }
                        composer2 = startRestartGroup;
                        composer2.endReplaceGroup();
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
                        composer2 = startRestartGroup;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatScreenKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TodoList$lambda$87;
                                TodoList$lambda$87 = ChatScreenKt.TodoList$lambda$87(str, i, (Composer) obj, ((Integer) obj2).intValue());
                                return TodoList$lambda$87;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
                
                    if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L30;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public static final void QuestionCard(final com.clozed.code.data.PermissionReq r17, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, final int r20) {
                    /*
                        Method dump skipped, instructions count: 252
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt.QuestionCard(com.clozed.code.data.PermissionReq, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final String QuestionCard$lambda$89(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }
            }

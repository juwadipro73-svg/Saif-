package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.app.NotificationCompat;
import com.clozed.code.AppViewModel;
import com.clozed.code.engine.Commands;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.McpServer;
import com.clozed.code.engine.PermRule;
import com.clozed.code.engine.ProviderStore;
import com.clozed.code.engine.Skills;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;

/* compiled from: AdvancedSettings.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0005\u001a\u00020\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\fX\u008a\u008e\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u008a\u008e\u0002²\u0006\u0016\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001bX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\fX\u008a\u008e\u0002²\u0006\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"advancedSettings", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "vm", "Lcom/clozed/code/AppViewModel;", "AdvCard", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Hint", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "EffortCard", "(Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "McpCard", "RulesCard", "CommandsCard", "(Landroidx/compose/runtime/Composer;I)V", "SkillsCard", "app_release", "effort", "servers", "", "Lcom/clozed/code/engine/McpServer;", NotificationCompat.CATEGORY_STATUS, "", "showAdd", "", "loginTick", "", "name", "url", "headers", "rules", "Lcom/clozed/code/engine/PermRule;", "action", "pattern", "decision", "tick", "desc", "body"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt {
    public static final Unit AdvCard$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        AdvCard(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit CommandsCard$lambda$71(int i, Composer composer, int i2) {
        CommandsCard(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit EffortCard$lambda$2(AppViewModel appViewModel, int i, Composer composer, int i2) {
        EffortCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit EffortCard$lambda$6(AppViewModel appViewModel, int i, Composer composer, int i2) {
        EffortCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit Hint$lambda$1(String str, int i, Composer composer, int i2) {
        Hint(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit McpCard$lambda$32(AppViewModel appViewModel, int i, Composer composer, int i2) {
        McpCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit McpCard$lambda$7(AppViewModel appViewModel, int i, Composer composer, int i2) {
        McpCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit RulesCard$lambda$33(AppViewModel appViewModel, int i, Composer composer, int i2) {
        RulesCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit RulesCard$lambda$52(AppViewModel appViewModel, int i, Composer composer, int i2) {
        RulesCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit SkillsCard$lambda$90(int i, Composer composer, int i2) {
        SkillsCard(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$CommandsCard(Composer composer, int i) {
        CommandsCard(composer, i);
    }

    public static final /* synthetic */ void access$SkillsCard(Composer composer, int i) {
        SkillsCard(composer, i);
    }

    public static final void advancedSettings(LazyListScope lazyListScope, final AppViewModel vm) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(vm, "vm");
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1341getLambda1$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1474337730, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$advancedSettings$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C57@2469L14:AdvancedSettings.kt#qn8u0p");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1474337730, i, -1, "com.clozed.code.ui.advancedSettings.<anonymous> (AdvancedSettings.kt:57)");
                }
                AdvancedSettingsKt.EffortCard(AppViewModel.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1352getLambda2$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-392370944, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$advancedSettings$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C59@2539L11:AdvancedSettings.kt#qn8u0p");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-392370944, i, -1, "com.clozed.code.ui.advancedSettings.<anonymous> (AdvancedSettings.kt:59)");
                }
                AdvancedSettingsKt.McpCard(AppViewModel.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1363getLambda3$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(2035887678, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$advancedSettings$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C61@2611L13:AdvancedSettings.kt#qn8u0p");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2035887678, i, -1, "com.clozed.code.ui.advancedSettings.<anonymous> (AdvancedSettings.kt:61)");
                }
                AdvancedSettingsKt.RulesCard(AppViewModel.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1374getLambda4$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1376getLambda5$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1377getLambda6$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1378getLambda7$app_release(), 3, (Object) null);
    }

    private static final void AdvCard(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-794514834);
        ComposerKt.sourceInformation(startRestartGroup, "C(AdvCard)71@2916L11,71@2874L74,73@3000L112,70@2838L274:AdvancedSettings.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-794514834, i2, -1, "com.clozed.code.ui.AdvCard (AdvancedSettings.kt:69)");
            }
            composer2 = startRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(140670908, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$AdvCard$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation(composer3, "C74@3010L96:AdvancedSettings.kt#qn8u0p");
                    if ((i3 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(140670908, i3, -1, "com.clozed.code.ui.AdvCard.<anonymous> (AdvancedSettings.kt:74)");
                    }
                    Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
                    Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -587213664, "C74@3095L9:AdvancedSettings.kt#qn8u0p");
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
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdvCard$lambda$0;
                    AdvCard$lambda$0 = AdvancedSettingsKt.AdvCard$lambda$0(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdvCard$lambda$0;
                }
            });
        }
    }

    public static final void Hint(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2097342050);
        ComposerKt.sourceInformation(startRestartGroup, "C(Hint)80@3198L10,80@3242L11,80@3165L106:AdvancedSettings.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2097342050, i2, -1, "com.clozed.code.ui.Hint (AdvancedSettings.kt:79)");
            }
            composer2 = startRestartGroup;
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer2, i2 & 14, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Hint$lambda$1;
                    Hint$lambda$1 = AdvancedSettingsKt.Hint$lambda$1(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Hint$lambda$1;
                }
            });
        }
    }

    public static final void EffortCard(final AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        final ProviderStore store;
        Composer startRestartGroup = composer.startRestartGroup(-912298651);
        ComposerKt.sourceInformation(startRestartGroup, "C(EffortCard)88@3481L48,90@3597L691,90@3589L699:AdvancedSettings.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(appViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-912298651, i2, -1, "com.clozed.code.ui.EffortCard (AdvancedSettings.kt:86)");
            }
            LocalBackend local = appViewModel.getLocal();
            if (local == null || (store = local.getStore()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit EffortCard$lambda$2;
                            EffortCard$lambda$2 = AdvancedSettingsKt.EffortCard$lambda$2(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return EffortCard$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(-614669805);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(store.getDefaultEffort(), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            final List listOf = CollectionsKt.listOf((Object[]) new String[]{DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "low", "medium", "high"});
            AdvCard(ComposableLambdaKt.rememberComposableLambda(1431425325, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: AdvancedSettings.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1$1, reason: invalid class name */
                /* loaded from: /tmp/classes3.dex */
                public static final class AnonymousClass1 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<String> $effort$delegate;
                    final /* synthetic */ List<String> $opts;
                    final /* synthetic */ ProviderStore $store;

                    AnonymousClass1(List<String> list, ProviderStore providerStore, MutableState<String> mutableState) {
                        this.$opts = list;
                        this.$store = providerStore;
                        this.$effort$delegate = mutableState;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
                        invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, int i) {
                        String EffortCard$lambda$4;
                        SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow = singleChoiceSegmentedButtonRowScope;
                        Composer composer2 = composer;
                        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
                        ComposerKt.sourceInformation(composer2, "C*96@3902L39,97@3995L23,98@4038L47,94@3811L274:AdvancedSettings.kt#qn8u0p");
                        int i2 = (i & 6) == 0 ? i | (composer2.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2) : i;
                        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1711565694, i2, -1, "com.clozed.code.ui.EffortCard.<anonymous>.<anonymous> (AdvancedSettings.kt:93)");
                            }
                            List<String> list = this.$opts;
                            final ProviderStore providerStore = this.$store;
                            final MutableState<String> mutableState = this.$effort$delegate;
                            int i3 = 0;
                            for (Object obj : list) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                final String str = (String) obj;
                                EffortCard$lambda$4 = AdvancedSettingsKt.EffortCard$lambda$4(mutableState);
                                boolean areEqual = Intrinsics.areEqual(EffortCard$lambda$4, str);
                                composer2.startReplaceGroup(616801191);
                                ComposerKt.sourceInformation(composer2, "CC(remember):AdvancedSettings.kt#9igjgp");
                                boolean changed = composer2.changed(str) | composer2.changedInstance(providerStore);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0092: CONSTRUCTOR (r4v2 'rememberedValue' java.lang.Object) = 
                                          (r14v1 'str' java.lang.String A[DONT_INLINE])
                                          (r11v1 'providerStore' com.clozed.code.engine.ProviderStore A[DONT_INLINE])
                                          (r12v1 'mutableState' androidx.compose.runtime.MutableState<java.lang.String> A[DONT_INLINE])
                                         A[MD:(java.lang.String, com.clozed.code.engine.ProviderStore, androidx.compose.runtime.MutableState):void (m)] (LINE:97) call: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1$1$$ExternalSyntheticLambda0.<init>(java.lang.String, com.clozed.code.engine.ProviderStore, androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1.1.invoke(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, androidx.compose.runtime.Composer, int):void, file: /tmp/classes3.dex
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
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
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
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 35 more
                                        */
                                    /*
                                        Method dump skipped, instructions count: 250
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.AdvancedSettingsKt$EffortCard$1.AnonymousClass1.invoke(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, androidx.compose.runtime.Composer, int):void");
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$2$lambda$1$lambda$0(String str, ProviderStore providerStore, MutableState mutableState) {
                                    mutableState.setValue(str);
                                    providerStore.setDefaultEffort(str);
                                    return Unit.INSTANCE;
                                }
                            }

                            public final void invoke(Composer composer2, int i3) {
                                ComposerKt.sourceInformation(composer2, "C91@3664L10,91@3607L79,92@3751L358,92@3695L414,101@4118L164:AdvancedSettings.kt#qn8u0p");
                                if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1431425325, i3, -1, "com.clozed.code.ui.EffortCard.<anonymous> (AdvancedSettings.kt:91)");
                                    }
                                    TextKt.Text-Nvy7gAk("Reasoning effort (default)", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleSmall(), composer2, 6, 0, 131070);
                                    SegmentedButtonKt.SingleChoiceSegmentedButtonRow-uFdPcIQ(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, ComposableLambdaKt.rememberComposableLambda(-1711565694, true, new AnonymousClass1(listOf, store, mutableState), composer2, 54), composer2, 390, 2);
                                    AdvancedSettingsKt.Hint("Applies to reasoning models only (GPT-5/o-series, Gemini, Claude extended thinking). Use /effort low|medium|high in chat to change it for that session only.", composer2, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), startRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit EffortCard$lambda$6;
                                EffortCard$lambda$6 = AdvancedSettingsKt.EffortCard$lambda$6(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return EffortCard$lambda$6;
                            }
                        });
                    }
                }

                public static final String EffortCard$lambda$4(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final void McpCard(final AppViewModel appViewModel, Composer composer, final int i) {
                    int i2;
                    MutableState mutableState;
                    AdvancedSettingsKt$McpCard$1$1 advancedSettingsKt$McpCard$1$1;
                    Composer composer2;
                    Composer startRestartGroup = composer.startRestartGroup(73192183);
                    ComposerKt.sourceInformation(startRestartGroup, "C(McpCard)111@4503L24,112@4547L47,113@4613L52,114@4685L34,115@4747L7,116@4776L30,121@5015L582,121@4994L603,134@5611L3283,134@5603L3291,182@8935L31,183@8986L39,184@9049L31,186@9133L19,195@9904L440,205@10374L64,188@9217L657,185@9089L1360:AdvancedSettings.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changedInstance(appViewModel) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(73192183, i2, -1, "com.clozed.code.ui.McpCard (AdvancedSettings.kt:108)");
                        }
                        LocalBackend local = appViewModel.getLocal();
                        if (local == null) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit McpCard$lambda$7;
                                        McpCard$lambda$7 = AdvancedSettingsKt.McpCard$lambda$7(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                        return McpCard$lambda$7;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        ProviderStore store = local.getStore();
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
                        startRestartGroup.startReplaceGroup(-1788816494);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt.mutableStateOf$default(store.mcpServers(), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        MutableState mutableState2 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1788814377);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        MutableState mutableState3 = (MutableState) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1788812091);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        final MutableState mutableState4 = (MutableState) rememberedValue4;
                        startRestartGroup.endReplaceGroup();
                        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Context context = (Context) consume;
                        startRestartGroup.startReplaceGroup(-1788809183);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        MutableState mutableState5 = (MutableState) rememberedValue5;
                        startRestartGroup.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                        startRestartGroup.startReplaceGroup(-1788800983);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        boolean changedInstance = startRestartGroup.changedInstance(local) | startRestartGroup.changedInstance(store);
                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                        if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                            mutableState = mutableState3;
                            advancedSettingsKt$McpCard$1$1 = new AdvancedSettingsKt$McpCard$1$1(local, mutableState5, mutableState2, mutableState, store, null);
                            startRestartGroup.updateRememberedValue(advancedSettingsKt$McpCard$1$1);
                        } else {
                            advancedSettingsKt$McpCard$1$1 = rememberedValue6;
                            mutableState = mutableState3;
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(unit, (Function2) advancedSettingsKt$McpCard$1$1, startRestartGroup, 6);
                        AdvCard(ComposableLambdaKt.rememberComposableLambda(235029551, true, new AdvancedSettingsKt$McpCard$2(mutableState2, coroutineScope, local, store, context, mutableState, mutableState5, mutableState4), startRestartGroup, 54), startRestartGroup, 6);
                        if (McpCard$lambda$15(mutableState4)) {
                            startRestartGroup.startReplaceGroup(-1788676094);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue7 = startRestartGroup.rememberedValue();
                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                rememberedValue7 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue7);
                            }
                            MutableState mutableState6 = (MutableState) rememberedValue7;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1788674454);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue8 = startRestartGroup.rememberedValue();
                            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                                rememberedValue8 = SnapshotStateKt.mutableStateOf$default("https://", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue8);
                            }
                            MutableState mutableState7 = (MutableState) rememberedValue8;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1788672446);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue9 = startRestartGroup.rememberedValue();
                            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                                rememberedValue9 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue9);
                            }
                            MutableState mutableState8 = (MutableState) rememberedValue9;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1788669770);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue10 = startRestartGroup.rememberedValue();
                            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                                rememberedValue10 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit McpCard$lambda$31$lambda$30;
                                        McpCard$lambda$31$lambda$30 = AdvancedSettingsKt.McpCard$lambda$31$lambda$30(mutableState4);
                                        return McpCard$lambda$31$lambda$30;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue10);
                            }
                            startRestartGroup.endReplaceGroup();
                            composer2 = startRestartGroup;
                            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue10, ComposableLambdaKt.rememberComposableLambda(82898186, true, new AdvancedSettingsKt$McpCard$4(store, local, mutableState6, mutableState7, mutableState2, mutableState8, mutableState4), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-540383416, true, new AdvancedSettingsKt$McpCard$5(mutableState4), startRestartGroup, 54), (Function2) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1345getLambda13$app_release(), ComposableLambdaKt.rememberComposableLambda(672177829, true, new AdvancedSettingsKt$McpCard$6(mutableState6, mutableState7, mutableState8), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1772598, 0, 16276);
                        } else {
                            composer2 = startRestartGroup;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                    }
                    ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit McpCard$lambda$32;
                                McpCard$lambda$32 = AdvancedSettingsKt.McpCard$lambda$32(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return McpCard$lambda$32;
                            }
                        });
                    }
                }

                public static final List<McpServer> McpCard$lambda$9(MutableState<List<McpServer>> mutableState) {
                    return (List) ((State) mutableState).getValue();
                }

                public static final Map<String, String> McpCard$lambda$12(MutableState<Map<String, String>> mutableState) {
                    return (Map) ((State) mutableState).getValue();
                }

                private static final boolean McpCard$lambda$15(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                public static final void McpCard$lambda$16(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                public static final int McpCard$lambda$18(MutableState<Integer> mutableState) {
                    return ((Number) ((State) mutableState).getValue()).intValue();
                }

                public static final void McpCard$lambda$19(MutableState<Integer> mutableState, int i) {
                    mutableState.setValue(Integer.valueOf(i));
                }

                public static final void McpCard$save(ProviderStore providerStore, LocalBackend localBackend, MutableState<List<McpServer>> mutableState, List<McpServer> list) {
                    mutableState.setValue(list);
                    providerStore.saveMcpServers(list);
                    localBackend.getMcp().invalidate();
                }

                public static final String McpCard$lambda$22(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String McpCard$lambda$25(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String McpCard$lambda$28(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final Unit McpCard$lambda$31$lambda$30(MutableState mutableState) {
                    McpCard$lambda$16(mutableState, false);
                    return Unit.INSTANCE;
                }

                public static final void RulesCard(final AppViewModel appViewModel, Composer composer, final int i) {
                    int i2;
                    ProviderStore store;
                    Composer composer2;
                    Composer startRestartGroup = composer.startRestartGroup(1299404820);
                    ComposerKt.sourceInformation(startRestartGroup, "C(RulesCard)215@10663L42,216@10725L34,219@10848L1336,219@10840L1344,241@12227L36,242@12287L31,243@12343L35,247@12594L19,269@13898L179,272@14107L64,249@12683L1185,246@12550L1632:AdvancedSettings.kt#qn8u0p");
                    if ((i & 6) == 0) {
                        i2 = (startRestartGroup.changedInstance(appViewModel) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1299404820, i2, -1, "com.clozed.code.ui.RulesCard (AdvancedSettings.kt:213)");
                        }
                        LocalBackend local = appViewModel.getLocal();
                        if (local == null || (store = local.getStore()) == null) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit RulesCard$lambda$33;
                                        RulesCard$lambda$33 = AdvancedSettingsKt.RulesCard$lambda$33(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                        return RulesCard$lambda$33;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        startRestartGroup.startReplaceGroup(-1331155094);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(store.rules(), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1331153118);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        final MutableState mutableState2 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        AdvCard(ComposableLambdaKt.rememberComposableLambda(-2088674484, true, new AdvancedSettingsKt$RulesCard$1(mutableState, store, mutableState2), startRestartGroup, 54), startRestartGroup, 6);
                        if (RulesCard$lambda$38(mutableState2)) {
                            startRestartGroup.startReplaceGroup(-1331105052);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt.mutableStateOf$default("shell", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            MutableState mutableState3 = (MutableState) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1331103137);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            MutableState mutableState4 = (MutableState) rememberedValue4;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1331101341);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = SnapshotStateKt.mutableStateOf$default("deny", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            MutableState mutableState5 = (MutableState) rememberedValue5;
                            startRestartGroup.endReplaceGroup();
                            List listOf = CollectionsKt.listOf((Object[]) new String[]{"shell", "edit", "read", "webfetch", "websearch", "mcp", "external_directory"});
                            List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"allow", "ask", "deny"});
                            startRestartGroup.startReplaceGroup(-1331093325);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit RulesCard$lambda$51$lambda$50;
                                        RulesCard$lambda$51$lambda$50 = AdvancedSettingsKt.RulesCard$lambda$51$lambda$50(mutableState2);
                                        return RulesCard$lambda$51$lambda$50;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            startRestartGroup.endReplaceGroup();
                            Function2 rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2036939111, true, new AdvancedSettingsKt$RulesCard$3(store, mutableState4, mutableState, mutableState3, mutableState5, mutableState2), startRestartGroup, 54);
                            Function2 rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(63773733, true, new AdvancedSettingsKt$RulesCard$4(mutableState2), startRestartGroup, 54);
                            Function2<Composer, Integer, Unit> m1355getLambda22$app_release = ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1355getLambda22$app_release();
                            Function2 rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1398992962, true, new AdvancedSettingsKt$RulesCard$5(listOf, mutableState3, mutableState4, listOf2, mutableState5), startRestartGroup, 54);
                            composer2 = startRestartGroup;
                            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue6, rememberComposableLambda, (Modifier) null, rememberComposableLambda2, (Function2) null, m1355getLambda22$app_release, rememberComposableLambda3, (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1772598, 0, 16276);
                        } else {
                            composer2 = startRestartGroup;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                    }
                    ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit RulesCard$lambda$52;
                                RulesCard$lambda$52 = AdvancedSettingsKt.RulesCard$lambda$52(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                                return RulesCard$lambda$52;
                            }
                        });
                    }
                }

                public static final List<PermRule> RulesCard$lambda$35(MutableState<List<PermRule>> mutableState) {
                    return (List) ((State) mutableState).getValue();
                }

                private static final boolean RulesCard$lambda$38(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                public static final void RulesCard$lambda$39(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                public static final void RulesCard$save$40(ProviderStore providerStore, MutableState<List<PermRule>> mutableState, List<PermRule> list) {
                    mutableState.setValue(list);
                    providerStore.saveRules(list);
                }

                public static final String RulesCard$lambda$42(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String RulesCard$lambda$45(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String RulesCard$lambda$48(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final Unit RulesCard$lambda$51$lambda$50(MutableState mutableState) {
                    RulesCard$lambda$39(mutableState, false);
                    return Unit.INSTANCE;
                }

                public static final void CommandsCard(Composer composer, final int i) {
                    Composer composer2;
                    Composer startRestartGroup = composer.startRestartGroup(-273875420);
                    ComposerKt.sourceInformation(startRestartGroup, "C(CommandsCard)281@14347L7,282@14380L30,283@14426L63,284@14509L34,286@14557L1001,286@14549L1009,305@15599L31,306@15651L31,307@15703L31,309@15787L19,318@16554L186,321@16770L64,311@15875L649,308@15743L1102:AdvancedSettings.kt#qn8u0p");
                    if (i != 0 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-273875420, i, -1, "com.clozed.code.ui.CommandsCard (AdvancedSettings.kt:280)");
                        }
                        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        File filesDir = ((Context) consume).getFilesDir();
                        startRestartGroup.startReplaceGroup(903244605);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        int CommandsCard$lambda$54 = CommandsCard$lambda$54(mutableState);
                        startRestartGroup.startReplaceGroup(903246110);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        boolean changed = startRestartGroup.changed(CommandsCard$lambda$54);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            Commands commands = Commands.INSTANCE;
                            File file = new File("/nonexistent");
                            Intrinsics.checkNotNull(filesDir);
                            rememberedValue2 = commands.discover(file, filesDir);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        List list = (List) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(903248737);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        final MutableState mutableState2 = (MutableState) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        AdvCard(ComposableLambdaKt.rememberComposableLambda(1636563948, true, new AdvancedSettingsKt$CommandsCard$1(list, filesDir, mutableState, mutableState2), startRestartGroup, 54), startRestartGroup, 6);
                        if (CommandsCard$lambda$58(mutableState2)) {
                            startRestartGroup.startReplaceGroup(903283614);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            MutableState mutableState3 = (MutableState) rememberedValue4;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(903285278);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            MutableState mutableState4 = (MutableState) rememberedValue5;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(903286942);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            MutableState mutableState5 = (MutableState) rememberedValue6;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(903289618);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue7 = startRestartGroup.rememberedValue();
                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                rememberedValue7 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit CommandsCard$lambda$70$lambda$69;
                                        CommandsCard$lambda$70$lambda$69 = AdvancedSettingsKt.CommandsCard$lambda$70$lambda$69(mutableState2);
                                        return CommandsCard$lambda$70$lambda$69;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue7);
                            }
                            startRestartGroup.endReplaceGroup();
                            composer2 = startRestartGroup;
                            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue7, ComposableLambdaKt.rememberComposableLambda(-1919171727, true, new AdvancedSettingsKt$CommandsCard$3(filesDir, mutableState3, mutableState5, mutableState4, mutableState, mutableState2), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-888130829, true, new AdvancedSettingsKt$CommandsCard$4(mutableState2), startRestartGroup, 54), (Function2) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1361getLambda28$app_release(), ComposableLambdaKt.rememberComposableLambda(658430518, true, new AdvancedSettingsKt$CommandsCard$5(mutableState3, mutableState4, mutableState5), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1772598, 0, 16276);
                        } else {
                            composer2 = startRestartGroup;
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit CommandsCard$lambda$71;
                                CommandsCard$lambda$71 = AdvancedSettingsKt.CommandsCard$lambda$71(i, (Composer) obj, ((Integer) obj2).intValue());
                                return CommandsCard$lambda$71;
                            }
                        });
                    }
                }

                public static final int CommandsCard$lambda$54(MutableState<Integer> mutableState) {
                    return ((Number) ((State) mutableState).getValue()).intValue();
                }

                public static final void CommandsCard$lambda$55(MutableState<Integer> mutableState, int i) {
                    mutableState.setValue(Integer.valueOf(i));
                }

                private static final boolean CommandsCard$lambda$58(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                public static final void CommandsCard$lambda$59(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                public static final String CommandsCard$lambda$61(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String CommandsCard$lambda$64(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String CommandsCard$lambda$67(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final Unit CommandsCard$lambda$70$lambda$69(MutableState mutableState) {
                    CommandsCard$lambda$59(mutableState, false);
                    return Unit.INSTANCE;
                }

                public static final void SkillsCard(Composer composer, final int i) {
                    Composer composer2;
                    Composer startRestartGroup = composer.startRestartGroup(1371990750);
                    ComposerKt.sourceInformation(startRestartGroup, "C(SkillsCard)330@16999L7,331@17032L30,332@17078L61,333@17159L34,335@17207L1004,335@17199L1012,354@18252L31,355@18304L31,356@18356L31,358@18440L19,367@19156L205,370@19391L64,360@18519L607,357@18396L1070:AdvancedSettings.kt#qn8u0p");
                    if (i != 0 || !startRestartGroup.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371990750, i, -1, "com.clozed.code.ui.SkillsCard (AdvancedSettings.kt:329)");
                        }
                        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        File filesDir = ((Context) consume).getFilesDir();
                        startRestartGroup.startReplaceGroup(-1418475849);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        int SkillsCard$lambda$73 = SkillsCard$lambda$73(mutableState);
                        startRestartGroup.startReplaceGroup(-1418474346);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        boolean changed = startRestartGroup.changed(SkillsCard$lambda$73);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            Skills skills = Skills.INSTANCE;
                            File file = new File("/nonexistent");
                            Intrinsics.checkNotNull(filesDir);
                            rememberedValue2 = skills.discover(file, filesDir);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        List list = (List) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1418471781);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        final MutableState mutableState2 = (MutableState) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        AdvCard(ComposableLambdaKt.rememberComposableLambda(1499118246, true, new AdvancedSettingsKt$SkillsCard$1(list, filesDir, mutableState, mutableState2), startRestartGroup, 54), startRestartGroup, 6);
                        if (SkillsCard$lambda$77(mutableState2)) {
                            startRestartGroup.startReplaceGroup(-1418436808);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            MutableState mutableState3 = (MutableState) rememberedValue4;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1418435144);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            MutableState mutableState4 = (MutableState) rememberedValue5;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1418433480);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            MutableState mutableState5 = (MutableState) rememberedValue6;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1418430804);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AdvancedSettings.kt#9igjgp");
                            Object rememberedValue7 = startRestartGroup.rememberedValue();
                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                rememberedValue7 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit SkillsCard$lambda$89$lambda$88;
                                        SkillsCard$lambda$89$lambda$88 = AdvancedSettingsKt.SkillsCard$lambda$89$lambda$88(mutableState2);
                                        return SkillsCard$lambda$89$lambda$88;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue7);
                            }
                            startRestartGroup.endReplaceGroup();
                            composer2 = startRestartGroup;
                            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue7, ComposableLambdaKt.rememberComposableLambda(726703979, true, new AdvancedSettingsKt$SkillsCard$3(filesDir, mutableState3, mutableState4, mutableState5, mutableState, mutableState2), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1967192211, true, new AdvancedSettingsKt$SkillsCard$4(mutableState2), startRestartGroup, 54), (Function2) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1371getLambda37$app_release(), ComposableLambdaKt.rememberComposableLambda(434414448, true, new AdvancedSettingsKt$SkillsCard$5(mutableState3, mutableState4, mutableState5), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1772598, 0, 16276);
                        } else {
                            composer2 = startRestartGroup;
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
                        endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AdvancedSettingsKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit SkillsCard$lambda$90;
                                SkillsCard$lambda$90 = AdvancedSettingsKt.SkillsCard$lambda$90(i, (Composer) obj, ((Integer) obj2).intValue());
                                return SkillsCard$lambda$90;
                            }
                        });
                    }
                }

                public static final int SkillsCard$lambda$73(MutableState<Integer> mutableState) {
                    return ((Number) ((State) mutableState).getValue()).intValue();
                }

                public static final void SkillsCard$lambda$74(MutableState<Integer> mutableState, int i) {
                    mutableState.setValue(Integer.valueOf(i));
                }

                private static final boolean SkillsCard$lambda$77(MutableState<Boolean> mutableState) {
                    return ((Boolean) ((State) mutableState).getValue()).booleanValue();
                }

                public static final void SkillsCard$lambda$78(MutableState<Boolean> mutableState, boolean z) {
                    mutableState.setValue(Boolean.valueOf(z));
                }

                public static final String SkillsCard$lambda$80(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String SkillsCard$lambda$83(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final String SkillsCard$lambda$86(MutableState<String> mutableState) {
                    return (String) ((State) mutableState).getValue();
                }

                public static final Unit SkillsCard$lambda$89$lambda$88(MutableState mutableState) {
                    SkillsCard$lambda$78(mutableState, false);
                    return Unit.INSTANCE;
                }
            }

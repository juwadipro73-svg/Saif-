package com.clozed.code.ui;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupProperties;
import com.clozed.code.AppViewModel;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.engine.CatProvider;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatExtras.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001aE\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0012\u001a1\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010\u0007\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\bX\u008a\u008e\u0002"}, d2 = {"PlusMenu", "", "onAttach", "Lkotlin/Function0;", "onCopyProject", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PortFields", "source", "", "onSource", "Lkotlin/Function1;", "what", "onWhat", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PortDialog", "vm", "Lcom/clozed/code/AppViewModel;", "onDismiss", "(Lcom/clozed/code/AppViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProviderChips", "models", "", "Lcom/clozed/code/data/ModelOpt;", "dismiss", "(Lcom/clozed/code/AppViewModel;Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "open", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatExtrasKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlusMenu$lambda$8(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        PlusMenu(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PortDialog$lambda$21(AppViewModel appViewModel, Function0 function0, int i, Composer composer, int i2) {
        PortDialog(appViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PortFields$lambda$14(String str, Function1 function1, String str2, Function1 function12, int i, Composer composer, int i2) {
        PortFields(str, function1, str2, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderChips$lambda$22(AppViewModel appViewModel, List list, Function0 function0, int i, Composer composer, int i2) {
        ProviderChips(appViewModel, list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderChips$lambda$24(AppViewModel appViewModel, List list, Function0 function0, int i, Composer composer, int i2) {
        ProviderChips(appViewModel, list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderChips$lambda$30(AppViewModel appViewModel, List list, Function0 function0, int i, Composer composer, int i2) {
        ProviderChips(appViewModel, list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PlusMenu(final Function0<Unit> onAttach, final Function0<Unit> onCopyProject, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onAttach, "onAttach");
        Intrinsics.checkNotNullParameter(onCopyProject, "onCopyProject");
        Composer startRestartGroup = composer.startRestartGroup(-885879827);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlusMenu)40@1791L34,41@1830L444:ChatExtras.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onAttach) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onCopyProject) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-885879827, i2, -1, "com.clozed.code.ui.PlusMenu (ChatExtras.kt:39)");
            }
            startRestartGroup.startReplaceGroup(-109510334);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1890385540, "C42@1865L15,42@1844L114,43@2016L16,43@2034L234,43@1967L301:ChatExtras.kt#qn8u0p");
            startRestartGroup.startReplaceGroup(1878682734);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PlusMenu$lambda$7$lambda$4$lambda$3;
                        PlusMenu$lambda$7$lambda$4$lambda$3 = ChatExtrasKt.PlusMenu$lambda$7$lambda$4$lambda$3(mutableState);
                        return PlusMenu$lambda$7$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            IconButtonKt.IconButton((Function0) rememberedValue2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1390getLambda1$app_release(), startRestartGroup, 1572918, 60);
            boolean PlusMenu$lambda$1 = PlusMenu$lambda$1(mutableState);
            startRestartGroup.startReplaceGroup(1878687567);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PlusMenu$lambda$7$lambda$6$lambda$5;
                        PlusMenu$lambda$7$lambda$6$lambda$5 = ChatExtrasKt.PlusMenu$lambda$7$lambda$6$lambda$5(mutableState);
                        return PlusMenu$lambda$7$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(PlusMenu$lambda$1, (Function0) rememberedValue3, (Modifier) null, 0L, (ScrollState) null, (PopupProperties) null, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2137237224, true, new ChatExtrasKt$PlusMenu$1$3(onAttach, onCopyProject, mutableState), startRestartGroup, 54), composer2, 48, 48, 2044);
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
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PlusMenu$lambda$8;
                    PlusMenu$lambda$8 = ChatExtrasKt.PlusMenu$lambda$8(Function0.this, onCopyProject, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PlusMenu$lambda$8;
                }
            });
        }
    }

    private static final boolean PlusMenu$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlusMenu$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlusMenu$lambda$7$lambda$4$lambda$3(MutableState mutableState) {
        PlusMenu$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlusMenu$lambda$7$lambda$6$lambda$5(MutableState mutableState) {
        PlusMenu$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    public static final void PortFields(final String source, final Function1<? super String, Unit> onSource, final String what, final Function1<? super String, Unit> onWhat, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(onSource, "onSource");
        Intrinsics.checkNotNullParameter(what, "what");
        Intrinsics.checkNotNullParameter(onWhat, "onWhat");
        Composer startRestartGroup = composer.startRestartGroup(-2005360604);
        ComposerKt.sourceInformation(startRestartGroup, "C(PortFields)P(2!1,3)53@2534L7,54@2637L268,54@2559L346,61@2910L1061:ChatExtras.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(source) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onSource) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(what) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onWhat) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2005360604, i2, -1, "com.clozed.code.ui.PortFields (ChatExtras.kt:52)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            ActivityResultContract openDocumentTree = new ActivityResultContracts.OpenDocumentTree();
            startRestartGroup.startReplaceGroup(-556681619);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            int i3 = i2 & 112;
            boolean changedInstance = (i3 == 32) | startRestartGroup.changedInstance(context);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PortFields$lambda$10$lambda$9;
                        PortFields$lambda$10$lambda$9 = ChatExtrasKt.PortFields$lambda$10$lambda$9(context, onSource, (Uri) obj);
                        return PortFields$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocumentTree, (Function1) rememberedValue, startRestartGroup, 0);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(10));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 102170376, "C62@3006L23,62@2978L122,63@3109L192,67@3310L299,76@3882L10,76@3926L11,73@3618L347:ChatExtras.kt#qn8u0p");
            startRestartGroup.startReplaceGroup(557485079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(rememberLauncherForActivityResult);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PortFields$lambda$13$lambda$12$lambda$11;
                        PortFields$lambda$13$lambda$12$lambda$11 = ChatExtrasKt.PortFields$lambda$13$lambda$12$lambda$11(rememberLauncherForActivityResult);
                        return PortFields$lambda$13$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            int i4 = i2;
            ButtonKt.FilledTonalButton((Function0) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1394getLambda4$app_release(), startRestartGroup, 805306416, 508);
            OutlinedTextFieldKt.OutlinedTextField(source, onSource, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, (TextStyle) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1395getLambda5$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, startRestartGroup, (i4 & 14) | 1573248 | i3, 12582912, 0, 8257464);
            int i5 = i4 >> 6;
            OutlinedTextFieldKt.OutlinedTextField(what, onWhat, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, (TextStyle) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1396getLambda6$app_release(), ComposableSingletons$ChatExtrasKt.INSTANCE.m1397getLambda7$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 5, 2, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, startRestartGroup, (i5 & 14) | 14156160 | (i5 & 112), 905969664, 0, 7601976);
            TextKt.Text-Nvy7gAk("The agent studies this project (read-only), then rebuilds the features, UI and logic inside the current project, following the current project's structure, naming, theme and dependencies.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 6, 0, 131066);
            composer2 = startRestartGroup;
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
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PortFields$lambda$14;
                    PortFields$lambda$14 = ChatExtrasKt.PortFields$lambda$14(source, onSource, what, onWhat, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PortFields$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PortFields$lambda$10$lambda$9(Context context, Function1 function1, Uri uri) {
        if (uri != null) {
            String treeUriToPath = FolderPickerKt.treeUriToPath(uri);
            if (treeUriToPath == null) {
                Toast.makeText(context, "Could not use this folder. Pick a folder on internal storage or SD card.", 1).show();
            } else {
                function1.invoke(treeUriToPath);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PortFields$lambda$13$lambda$12$lambda$11(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch((Object) null);
        return Unit.INSTANCE;
    }

    public static final void PortDialog(final AppViewModel vm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(420212464);
        ComposerKt.sourceInformation(startRestartGroup, "C(PortDialog)P(1)84@4166L31,85@4214L31,90@4457L144,93@4627L54,89@4371L60,86@4250L438:ChatExtras.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(vm) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(420212464, i2, -1, "com.clozed.code.ui.PortDialog (ChatExtras.kt:83)");
            }
            startRestartGroup.startReplaceGroup(138513263);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(138514799);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(640018232, true, new ChatExtrasKt$PortDialog$1(vm, onDismiss, mutableState, mutableState2), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-1393375814, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatExtrasKt$PortDialog$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C93@4629L50:ChatExtras.kt#qn8u0p");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1393375814, i3, -1, "com.clozed.code.ui.PortDialog.<anonymous> (ChatExtras.kt:93)");
                    }
                    ButtonKt.TextButton(onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1399getLambda9$app_release(), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), (Function2) null, ComposableSingletons$ChatExtrasKt.INSTANCE.m1391getLambda10$app_release(), ComposableLambdaKt.rememberComposableLambda(1998984061, true, new ChatExtrasKt$PortDialog$3(mutableState, mutableState2), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i2 >> 3) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PortDialog$lambda$21;
                    PortDialog$lambda$21 = ChatExtrasKt.PortDialog$lambda$21(AppViewModel.this, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PortDialog$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PortDialog$lambda$16(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PortDialog$lambda$19(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    public static final void ProviderChips(final AppViewModel vm, final List<ModelOpt> models, final Function0<Unit> dismiss, Composer composer, final int i) {
        int i2;
        final ProviderStore store;
        final Function0<Unit> function0;
        Composer composer2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1959284579);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProviderChips)P(2,1)103@5045L638:ChatExtras.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(vm) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(models) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(dismiss) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function0 = dismiss;
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1959284579, i2, -1, "com.clozed.code.ui.ProviderChips (ChatExtras.kt:99)");
            }
            LocalBackend local = vm.getLocal();
            if (local == null || (store = local.getStore()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ProviderChips$lambda$22;
                            ProviderChips$lambda$22 = ChatExtrasKt.ProviderChips$lambda$22(AppViewModel.this, models, dismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ProviderChips$lambda$22;
                        }
                    });
                    return;
                }
                return;
            }
            List<ModelOpt> list = models;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ModelOpt) it.next()).getProviderId());
            }
            final List distinct = CollectionsKt.distinct(arrayList);
            if (distinct.size() < 2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ProviderChips$lambda$24;
                            ProviderChips$lambda$24 = ChatExtrasKt.ProviderChips$lambda$24(AppViewModel.this, models, dismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ProviderChips$lambda$24;
                        }
                    });
                    return;
                }
                return;
            }
            float f = 8;
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m826constructorimpl(f), 7, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296615889, "C106@5205L10,106@5249L11,104@5095L249,109@5413L264,109@5353L324:ChatExtras.kt#qn8u0p");
            int i3 = i2;
            TextKt.Text-Nvy7gAk("Tap a provider to use the model you used last with it:", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m826constructorimpl(6), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 54, 0, 131064);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
            startRestartGroup.startReplaceGroup(-1533579050);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ChatExtras.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(distinct) | startRestartGroup.changedInstance(vm) | ((i3 & 896) == 256) | startRestartGroup.changedInstance(store);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                function0 = dismiss;
                rememberedValue = new Function1() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProviderChips$lambda$29$lambda$28$lambda$27;
                        ProviderChips$lambda$29$lambda$28$lambda$27 = ChatExtrasKt.ProviderChips$lambda$29$lambda$28$lambda$27(distinct, vm, function0, store, (LazyListScope) obj);
                        return ProviderChips$lambda$29$lambda$28$lambda$27;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                function0 = dismiss;
            }
            startRestartGroup.endReplaceGroup();
            LazyDslKt.LazyRow((Modifier) null, (LazyListState) null, (PaddingValues) null, false, horizontal, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) rememberedValue, startRestartGroup, 24576, 495);
            composer2 = startRestartGroup;
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
        ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: com.clozed.code.ui.ChatExtrasKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProviderChips$lambda$30;
                    ProviderChips$lambda$30 = ChatExtrasKt.ProviderChips$lambda$30(AppViewModel.this, models, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProviderChips$lambda$30;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderChips$lambda$29$lambda$28$lambda$27(final List list, final AppViewModel appViewModel, final Function0 function0, final ProviderStore providerStore, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final ChatExtrasKt$ProviderChips$lambda$29$lambda$28$lambda$27$$inlined$items$default$1 chatExtrasKt$ProviderChips$lambda$29$lambda$28$lambda$27$$inlined$items$default$1 = new Function1() { // from class: com.clozed.code.ui.ChatExtrasKt$ProviderChips$lambda$29$lambda$28$lambda$27$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((String) obj);
            }
        };
        LazyRow.items(list.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.clozed.code.ui.ChatExtrasKt$ProviderChips$lambda$29$lambda$28$lambda$27$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatExtrasKt$ProviderChips$lambda$29$lambda$28$lambda$27$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final String str = (String) list.get(i);
                composer.startReplaceGroup(791147872);
                ComposerKt.sourceInformation(composer, "C*112@5511L37,113@5578L56,111@5469L184:ChatExtras.kt#qn8u0p");
                composer.startReplaceGroup(25522096);
                ComposerKt.sourceInformation(composer, "CC(remember):ChatExtras.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(appViewModel) | composer.changed(str) | composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    final AppViewModel appViewModel2 = appViewModel;
                    final Function0 function02 = function0;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: com.clozed.code.ui.ChatExtrasKt$ProviderChips$2$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AppViewModel.this.switchProvider(str);
                            function02.invoke();
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                final ProviderStore providerStore2 = providerStore;
                ChipKt.AssistChip((Function0) rememberedValue, ComposableLambdaKt.rememberComposableLambda(-64789270, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.ChatExtrasKt$ProviderChips$2$1$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        String str2;
                        ComposerKt.sourceInformation(composer2, "C113@5580L52:ChatExtras.kt#qn8u0p");
                        if ((i4 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-64789270, i4, -1, "com.clozed.code.ui.ProviderChips.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatExtras.kt:113)");
                        }
                        CatProvider provider = ProviderStore.this.provider(str);
                        if (provider == null || (str2 = provider.getName()) == null) {
                            str2 = str;
                        }
                        TextKt.Text-Nvy7gAk(str2, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, composer2, 0, 24576, 245758);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), (Modifier) null, false, (Function2) null, (Function2) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer, 48, 0, 2044);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}

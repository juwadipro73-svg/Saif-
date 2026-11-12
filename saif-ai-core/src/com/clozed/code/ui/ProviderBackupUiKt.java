package com.clozed.code.ui;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.clozed.code.AppViewModel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: ProviderBackupUi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"ProviderBackupCard", "", "vm", "Lcom/clozed/code/AppViewModel;", "(Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "app_release", "warnFor", "", "pendingText", "showImport", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ProviderBackupUiKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$28(AppViewModel appViewModel, int i, Composer composer, int i2) {
        ProviderBackupCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProviderBackupCard(AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Context context;
        int i3;
        String str;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        final AppViewModel vm = appViewModel;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(-1257576854);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProviderBackupCard)31@1292L7,32@1319L42,33@1405L42,34@1470L34,36@1623L463,36@1529L557,48@2184L379,48@2110L453,59@2569L746,98@4580L22,101@4833L247,107@5110L522,97@4536L1107:ProviderBackupUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(vm) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1257576854, i2, -1, "com.clozed.code.ui.ProviderBackupCard (ProviderBackupUi.kt:30)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context2 = (Context) consume;
            startRestartGroup.startReplaceGroup(-469872204);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-469869452);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-469867380);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            ActivityResultContract createDocument = new ActivityResultContracts.CreateDocument("application/json");
            startRestartGroup.startReplaceGroup(-469862055);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(context2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProviderBackupCard$lambda$11$lambda$10;
                        ProviderBackupCard$lambda$11$lambda$10 = ProviderBackupUiKt.ProviderBackupCard$lambda$11$lambda$10(context2, mutableState2, (Uri) obj);
                        return ProviderBackupCard$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(createDocument, (Function1) rememberedValue4, startRestartGroup, 0);
            ActivityResultContract openDocument = new ActivityResultContracts.OpenDocument();
            startRestartGroup.startReplaceGroup(-469844187);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(context2) | startRestartGroup.changedInstance(vm);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProviderBackupCard$lambda$14$lambda$13;
                        ProviderBackupCard$lambda$14$lambda$13 = ProviderBackupUiKt.ProviderBackupCard$lambda$14$lambda$13(context2, vm, (Uri) obj);
                        return ProviderBackupCard$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            ManagedActivityResultLauncher rememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocument, (Function1) rememberedValue5, startRestartGroup, 0);
            float f = 4;
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m826constructorimpl(f), 0.0f, 0.0f, 13, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(6));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1756785050, "C62@2830L10,62@2874L11,60@2681L292,65@2982L327:ProviderBackupUi.kt#qn8u0p");
            final MutableState mutableState4 = mutableState3;
            TextKt.Text-Nvy7gAk("Backup your providers and keys to a file, or share them with friends so they can import them.", PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.m826constructorimpl(f), 0.0f, 2, (Object) null), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 54, 0, 131064);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), startRestartGroup, 6);
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
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1055987939, "C66@3102L20,66@3077L65,67@3180L21,67@3155L65,68@3258L21,68@3233L66:ProviderBackupUi.kt#qn8u0p");
            startRestartGroup.startReplaceGroup(1212862460);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProviderBackupCard$lambda$22$lambda$21$lambda$16$lambda$15;
                        ProviderBackupCard$lambda$22$lambda$21$lambda$16$lambda$15 = ProviderBackupUiKt.ProviderBackupCard$lambda$22$lambda$21$lambda$16$lambda$15(mutableState);
                        return ProviderBackupCard$lambda$22$lambda$21$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            ButtonKt.OutlinedButton((Function0) rememberedValue6, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1421getLambda1$app_release(), startRestartGroup, 805306374, 510);
            startRestartGroup.startReplaceGroup(1212864957);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProviderBackupCard$lambda$22$lambda$21$lambda$18$lambda$17;
                        ProviderBackupCard$lambda$22$lambda$21$lambda$18$lambda$17 = ProviderBackupUiKt.ProviderBackupCard$lambda$22$lambda$21$lambda$18$lambda$17(mutableState);
                        return ProviderBackupCard$lambda$22$lambda$21$lambda$18$lambda$17;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            ButtonKt.OutlinedButton((Function0) rememberedValue7, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1424getLambda2$app_release(), startRestartGroup, 805306374, 510);
            startRestartGroup.startReplaceGroup(1212867453);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProviderBackupUi.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProviderBackupCard$lambda$22$lambda$21$lambda$20$lambda$19;
                        ProviderBackupCard$lambda$22$lambda$21$lambda$20$lambda$19 = ProviderBackupUiKt.ProviderBackupCard$lambda$22$lambda$21$lambda$20$lambda$19(mutableState4);
                        return ProviderBackupCard$lambda$22$lambda$21$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            ButtonKt.OutlinedButton((Function0) rememberedValue8, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1425getLambda3$app_release(), startRestartGroup, 805306374, 510);
            composer2 = startRestartGroup;
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
            String ProviderBackupCard$lambda$1 = ProviderBackupCard$lambda$1(mutableState);
            composer2.startReplaceGroup(-469806720);
            ComposerKt.sourceInformation(composer2, "*74@3396L18,77@3618L776,92@4424L63,73@3352L1146");
            if (ProviderBackupCard$lambda$1 == null) {
                vm = appViewModel;
                str = "CC(remember):ProviderBackupUi.kt#9igjgp";
                i3 = 54;
                context = context2;
                managedActivityResultLauncher = rememberLauncherForActivityResult2;
            } else {
                composer2.startReplaceGroup(-1580668869);
                ComposerKt.sourceInformation(composer2, "CC(remember):ProviderBackupUi.kt#9igjgp");
                Object rememberedValue9 = composer2.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProviderBackupCard$lambda$25$lambda$24$lambda$23;
                            ProviderBackupCard$lambda$25$lambda$24$lambda$23 = ProviderBackupUiKt.ProviderBackupCard$lambda$25$lambda$24$lambda$23(mutableState);
                            return ProviderBackupCard$lambda$25$lambda$24$lambda$23;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue9);
                }
                Function0 function0 = (Function0) rememberedValue9;
                composer2.endReplaceGroup();
                context = context2;
                vm = appViewModel;
                mutableState4 = mutableState4;
                i3 = 54;
                str = "CC(remember):ProviderBackupUi.kt#9igjgp";
                managedActivityResultLauncher = rememberLauncherForActivityResult2;
                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1236920288, true, new ProviderBackupUiKt$ProviderBackupCard$2$2(vm, context, ProviderBackupCard$lambda$1, rememberLauncherForActivityResult, mutableState, mutableState2), composer2, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(450922398, true, new ProviderBackupUiKt$ProviderBackupCard$2$3(mutableState), composer2, 54), (Function2) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1428getLambda6$app_release(), ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1429getLambda7$app_release(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, 1772598, 0, 16276);
                composer2 = composer2;
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            if (ProviderBackupCard$lambda$7(mutableState4)) {
                composer2.startReplaceGroup(-469767872);
                ComposerKt.sourceInformation(composer2, str);
                Object rememberedValue10 = composer2.rememberedValue();
                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProviderBackupCard$lambda$27$lambda$26;
                            ProviderBackupCard$lambda$27$lambda$26 = ProviderBackupUiKt.ProviderBackupCard$lambda$27$lambda$26(mutableState4);
                            return ProviderBackupCard$lambda$27$lambda$26;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue10);
                }
                composer2.endReplaceGroup();
                Composer composer5 = composer2;
                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) rememberedValue10, ComposableLambdaKt.rememberComposableLambda(-319696265, true, new ProviderBackupUiKt$ProviderBackupCard$4(managedActivityResultLauncher, mutableState4), composer2, i3), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-2041698951, true, new ProviderBackupUiKt$ProviderBackupCard$5(context, vm, mutableState4), composer2, i3), (Function2) null, ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1422getLambda10$app_release(), ComposableSingletons$ProviderBackupUiKt.INSTANCE.m1423getLambda11$app_release(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer5, 1772598, 0, 16276);
                composer2 = composer5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ProviderBackupUiKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProviderBackupCard$lambda$28;
                    ProviderBackupCard$lambda$28 = ProviderBackupUiKt.ProviderBackupCard$lambda$28(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProviderBackupCard$lambda$28;
                }
            });
        }
    }

    private static final String ProviderBackupCard$lambda$1(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String ProviderBackupCard$lambda$4(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final boolean ProviderBackupCard$lambda$7(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProviderBackupCard$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$11$lambda$10(Context context, MutableState mutableState, Uri uri) {
        String ProviderBackupCard$lambda$4 = ProviderBackupCard$lambda$4(mutableState);
        mutableState.setValue(null);
        if (uri != null && ProviderBackupCard$lambda$4 != null) {
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(uri);
                if (openOutputStream != null) {
                    OutputStream outputStream = openOutputStream;
                    try {
                        byte[] bytes = ProviderBackupCard$lambda$4.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        outputStream.write(bytes);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                    } finally {
                    }
                }
                Toast.makeText(context, "Backup saved", 0).show();
            } catch (Exception e) {
                Toast.makeText(context, "Could not save: " + e.getMessage(), 1).show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r4 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ProviderBackupCard$lambda$14$lambda$13(android.content.Context r2, com.clozed.code.AppViewModel r3, android.net.Uri r4) {
        /*
            if (r4 == 0) goto L61
            android.content.ContentResolver r0 = r2.getContentResolver()     // Catch: java.lang.Exception -> L43
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch: java.lang.Exception -> L43
            if (r4 == 0) goto L3d
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L43
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L43
            r1.<init>(r4, r0)     // Catch: java.lang.Exception -> L43
            java.io.Reader r1 = (java.io.Reader) r1     // Catch: java.lang.Exception -> L43
            boolean r4 = r1 instanceof java.io.BufferedReader     // Catch: java.lang.Exception -> L43
            if (r4 == 0) goto L1c
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch: java.lang.Exception -> L43
            goto L24
        L1c:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L43
            r0 = 8192(0x2000, float:1.148E-41)
            r4.<init>(r1, r0)     // Catch: java.lang.Exception -> L43
            r1 = r4
        L24:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch: java.lang.Exception -> L43
            r4 = r1
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch: java.lang.Throwable -> L36
            java.io.Reader r4 = (java.io.Reader) r4     // Catch: java.lang.Throwable -> L36
            java.lang.String r4 = kotlin.io.TextStreamsKt.readText(r4)     // Catch: java.lang.Throwable -> L36
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch: java.lang.Exception -> L43
            if (r4 != 0) goto L3f
            goto L3d
        L36:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> L38
        L38:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch: java.lang.Exception -> L43
            throw r4     // Catch: java.lang.Exception -> L43
        L3d:
            java.lang.String r4 = ""
        L3f:
            r3.importProvidersJson(r4)     // Catch: java.lang.Exception -> L43
            goto L61
        L43:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not read file: "
            r4.<init>(r0)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 1
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r4)
            r2.show()
        L61:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ProviderBackupUiKt.ProviderBackupCard$lambda$14$lambda$13(android.content.Context, com.clozed.code.AppViewModel, android.net.Uri):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$22$lambda$21$lambda$16$lambda$15(MutableState mutableState) {
        mutableState.setValue("file");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$22$lambda$21$lambda$18$lambda$17(MutableState mutableState) {
        mutableState.setValue("share");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$22$lambda$21$lambda$20$lambda$19(MutableState mutableState) {
        ProviderBackupCard$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$25$lambda$24$lambda$23(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProviderBackupCard$lambda$27$lambda$26(MutableState mutableState) {
        ProviderBackupCard$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }
}

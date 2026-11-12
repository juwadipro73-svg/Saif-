package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.window.DialogProperties;
import com.clozed.code.AppViewModel;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.engine.ChainEntry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: AutoSwitchUi.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"untilText", "", "until", "", "KeysDialog", "", "vm", "Lcom/clozed/code/AppViewModel;", "providerId", "title", "onDismiss", "Lkotlin/Function0;", "(Lcom/clozed/code/AppViewModel;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AutoSwitchCard", "(Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "app_release", "rev", "", "key", "show", "", DebugKt.DEBUG_PROPERTY_VALUE_ON, "picking"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AutoSwitchUiKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSwitchCard$lambda$30(AppViewModel appViewModel, int i, Composer composer, int i2) {
        AutoSwitchCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeysDialog$lambda$10(AppViewModel appViewModel, String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        KeysDialog(appViewModel, str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String untilText(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        return ((j - currentTimeMillis > 43200000 || !Intrinsics.areEqual(new SimpleDateFormat("yyyyMMdd").format(new Date(j)), new SimpleDateFormat("yyyyMMdd").format(new Date(currentTimeMillis)))) ? new StringBuilder("kal ") : new StringBuilder()).append(DateFormat.getTimeInstance(3).format(new Date(j))).append(" tak").toString();
    }

    public static final void KeysDialog(final AppViewModel vm, final String providerId, final String title, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1158489383);
        ComposerKt.sourceInformation(startRestartGroup, "C(KeysDialog)P(3,1,2)60@2731L7,61@2766L11,62@2793L33,63@2845L43,64@2904L31,65@2952L34,115@5879L52,69@3109L15,70@3141L2712,66@2991L2947:AutoSwitchUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(vm) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(providerId) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(title) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158489383, i3, -1, "com.clozed.code.ui.KeysDialog (AutoSwitchUi.kt:59)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            startRestartGroup.startReplaceGroup(714560068);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            int KeysDialog$lambda$1 = KeysDialog$lambda$1(mutableIntState);
            startRestartGroup.startReplaceGroup(714561742);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            boolean changed = startRestartGroup.changed(KeysDialog$lambda$1);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = vm.keyEntries(providerId);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            List list = (List) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(714563618);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(714565157);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(1056804207, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C115@5881L48:AutoSwitchUi.kt#qn8u0p");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1056804207, i4, -1, "com.clozed.code.ui.KeysDialog.<anonymous> (AutoSwitchUi.kt:115)");
                    }
                    ButtonKt.TextButton(onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1381getLambda1$app_release(), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), (Modifier) null, (Function2) null, ComposableSingletons$AutoSwitchUiKt.INSTANCE.m1382getLambda2$app_release(), ComposableLambdaKt.rememberComposableLambda(-1507540365, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.AutoSwitchUiKt$KeysDialog$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C69@3111L11:AutoSwitchUi.kt#qn8u0p");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1507540365, i4, -1, "com.clozed.code.ui.KeysDialog.<anonymous> (AutoSwitchUi.kt:69)");
                    }
                    TextKt.Text-Nvy7gAk(title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2146340788, true, new AutoSwitchUiKt$KeysDialog$3(colorScheme, list, vm, providerId, mutableIntState, mutableState, (MutableState) rememberedValue4, context), startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i3 >> 9) & 14) | 1794096, 0, 16268);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit KeysDialog$lambda$10;
                    KeysDialog$lambda$10 = AutoSwitchUiKt.KeysDialog$lambda$10(AppViewModel.this, providerId, title, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return KeysDialog$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int KeysDialog$lambda$1(MutableIntState mutableIntState) {
        return ((IntState) mutableIntState).getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String KeysDialog$lambda$5(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KeysDialog$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void KeysDialog$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void AutoSwitchCard(final AppViewModel vm, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(vm, "vm");
        Composer startRestartGroup = composer.startRestartGroup(-1734304662);
        ComposerKt.sourceInformation(startRestartGroup, "C(AutoSwitchCard)122@6124L11,123@6151L33,124@6199L46,125@6262L36,126@6318L34,130@6463L51,130@6552L3561,130@6436L3677,190@10156L33,194@10305L11,195@10336L50,196@10409L72,197@10507L19,191@10198L403:AutoSwitchUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(vm) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1734304662, i2, -1, "com.clozed.code.ui.AutoSwitchCard (AutoSwitchUi.kt:121)");
            }
            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            startRestartGroup.startReplaceGroup(-1443485733);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1443484184);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(vm.autoSwitchOn()), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            int AutoSwitchCard$lambda$12 = AutoSwitchCard$lambda$12(mutableIntState);
            startRestartGroup.startReplaceGroup(-1443482178);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            boolean changed = startRestartGroup.changed(AutoSwitchCard$lambda$12);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = vm.fallbackChain();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final List list = (List) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1443480388);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(colorScheme.getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, startRestartGroup, CardDefaults.$stable << 12, 14);
            startRestartGroup = startRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, cardColors, (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1761263432, true, new AutoSwitchUiKt$AutoSwitchCard$1(colorScheme, list, vm, mutableState, mutableIntState, mutableState2), startRestartGroup, 54), startRestartGroup, 196614, 26);
            if (AutoSwitchCard$lambda$19(mutableState2)) {
                startRestartGroup.startReplaceGroup(-1443357573);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = vm.fallbackChoices();
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                List list2 = (List) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1443352827);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String AutoSwitchCard$lambda$23$lambda$22;
                            AutoSwitchCard$lambda$23$lambda$22 = AutoSwitchUiKt.AutoSwitchCard$lambda$23$lambda$22((ModelOpt) obj);
                            return AutoSwitchCard$lambda$23$lambda$22;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                Function1 function1 = (Function1) rememberedValue6;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1443351796);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(vm);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String AutoSwitchCard$lambda$25$lambda$24;
                            AutoSwitchCard$lambda$25$lambda$24 = AutoSwitchUiKt.AutoSwitchCard$lambda$25$lambda$24(AppViewModel.this, (ModelOpt) obj);
                            return AutoSwitchCard$lambda$25$lambda$24;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                Function1 function12 = (Function1) rememberedValue7;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1443349438);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(vm) | startRestartGroup.changedInstance(list);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AutoSwitchCard$lambda$27$lambda$26;
                            AutoSwitchCard$lambda$27$lambda$26 = AutoSwitchUiKt.AutoSwitchCard$lambda$27$lambda$26(list, vm, mutableIntState, mutableState2, (ModelOpt) obj);
                            return AutoSwitchCard$lambda$27$lambda$26;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                Function1 function13 = (Function1) rememberedValue8;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1443346355);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AutoSwitchUi.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    rememberedValue9 = new Function0() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AutoSwitchCard$lambda$29$lambda$28;
                            AutoSwitchCard$lambda$29$lambda$28 = AutoSwitchUiKt.AutoSwitchCard$lambda$29$lambda$28(mutableState2);
                            return AutoSwitchCard$lambda$29$lambda$28;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                startRestartGroup.endReplaceGroup();
                SheetsKt.PickerSheet("Choose fallback model", list2, function1, function12, function13, (Function0) rememberedValue9, "Connect at least one provider first.", null, startRestartGroup, 1769862, 128);
                startRestartGroup = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.AutoSwitchUiKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AutoSwitchCard$lambda$30;
                    AutoSwitchCard$lambda$30 = AutoSwitchUiKt.AutoSwitchCard$lambda$30(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AutoSwitchCard$lambda$30;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AutoSwitchCard$lambda$12(MutableIntState mutableIntState) {
        return ((IntState) mutableIntState).getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AutoSwitchCard$lambda$15(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoSwitchCard$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AutoSwitchCard$lambda$19(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoSwitchCard$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoSwitchCard$update(AppViewModel appViewModel, MutableIntState mutableIntState, List<ChainEntry> list) {
        appViewModel.saveFallbackChain(list);
        mutableIntState.setIntValue(AutoSwitchCard$lambda$12(mutableIntState) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AutoSwitchCard$lambda$23$lambda$22(ModelOpt it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AutoSwitchCard$lambda$25$lambda$24(AppViewModel appViewModel, ModelOpt it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return appViewModel.providerName(it.getProviderId()) + " · " + it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSwitchCard$lambda$27$lambda$26(List list, AppViewModel appViewModel, MutableIntState mutableIntState, MutableState mutableState, ModelOpt m) {
        Intrinsics.checkNotNullParameter(m, "m");
        AutoSwitchCard$update(appViewModel, mutableIntState, CollectionsKt.plus((Collection<? extends ChainEntry>) list, new ChainEntry(m.getProviderId(), m.getId())));
        AutoSwitchCard$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSwitchCard$lambda$29$lambda$28(MutableState mutableState) {
        AutoSwitchCard$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }
}

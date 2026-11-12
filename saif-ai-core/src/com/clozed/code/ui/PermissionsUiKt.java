package com.clozed.code.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.clozed.code.AppViewModel;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsUi.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0003H\u0002\u001a\r\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0003¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0001¢\u0006\u0002\u0010\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u0007*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0001X\u008a\u008e\u0002"}, d2 = {"hasNotifications", "", "ctx", "Landroid/content/Context;", "hasUnrestrictedBattery", "missingPermissions", "openNotificationSettings", "", "openBatterySettings", "openAppDetails", "findOwner", "Landroidx/lifecycle/LifecycleOwner;", "rememberResumeTick", "", "(Landroidx/compose/runtime/Composer;I)I", "rememberPermRows", "", "Lcom/clozed/code/ui/PermRow;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "PermRowView", "r", "(Lcom/clozed/code/ui/PermRow;Landroidx/compose/runtime/Composer;I)V", "PermissionsFirstRun", "(Landroidx/compose/runtime/Composer;I)V", "PermissionsDialog", "onDismiss", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "backgroundSettings", "Landroidx/compose/foundation/lazy/LazyListScope;", "vm", "Lcom/clozed/code/AppViewModel;", "BackgroundCard", "(Lcom/clozed/code/AppViewModel;Landroidx/compose/runtime/Composer;I)V", "app_release", "tick", "show", "voice"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class PermissionsUiKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundCard$lambda$32(AppViewModel appViewModel, int i, Composer composer, int i2) {
        BackgroundCard(appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermRowView$lambda$19(PermRow permRow, int i, Composer composer, int i2) {
        PermRowView(permRow, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsDialog$lambda$28(Function0 function0, int i, Composer composer, int i2) {
        PermissionsDialog(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsFirstRun$lambda$26(int i, Composer composer, int i2) {
        PermissionsFirstRun(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final boolean hasNotifications(Context context) {
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return Build.VERSION.SDK_INT < 33 || context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0;
        }
        return false;
    }

    private static final boolean hasUnrestrictedBattery(Context context) {
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static final boolean missingPermissions(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return (hasNotifications(ctx) && hasUnrestrictedBattery(ctx) && ComponentsKt.hasAllFilesAccess()) ? false : true;
    }

    private static final void openNotificationSettings(Context context) {
        try {
            context.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName()).addFlags(268435456));
        } catch (Exception unused) {
            openAppDetails(context);
        }
    }

    private static final void openBatterySettings(Context context) {
        try {
            try {
                context.startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + context.getPackageName())).addFlags(268435456));
            } catch (Exception unused) {
                context.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS").addFlags(268435456));
            }
        } catch (Exception unused2) {
            openAppDetails(context);
        }
    }

    private static final void openAppDetails(Context context) {
        try {
            context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName())).addFlags(268435456));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.lifecycle.LifecycleOwner findOwner(android.content.Context r1) {
        /*
        L0:
            boolean r0 = r1 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L12
            boolean r0 = r1 instanceof androidx.lifecycle.LifecycleOwner
            if (r0 == 0) goto Lb
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            return r1
        Lb:
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1
            android.content.Context r1 = r1.getBaseContext()
            goto L0
        L12:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.PermissionsUiKt.findOwner(android.content.Context):androidx.lifecycle.LifecycleOwner");
    }

    private static final int rememberResumeTick(Composer composer, int i) {
        composer.startReplaceGroup(-2060709393);
        ComposerKt.sourceInformation(composer, "C(rememberResumeTick)95@4092L7,96@4116L30,97@4173L242,97@4151L264:PermissionsUi.kt#qn8u0p");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2060709393, i, -1, "com.clozed.code.ui.rememberResumeTick (PermissionsUi.kt:94)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) consume;
        composer.startReplaceGroup(-1704243396);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1704241360);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult rememberResumeTick$lambda$6$lambda$5;
                    rememberResumeTick$lambda$6$lambda$5 = PermissionsUiKt.rememberResumeTick$lambda$6$lambda$5(context, mutableState, (DisposableEffectScope) obj);
                    return rememberResumeTick$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(context, (Function1) rememberedValue2, composer, 0);
        int rememberResumeTick$lambda$1 = rememberResumeTick$lambda$1(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberResumeTick$lambda$1;
    }

    private static final int rememberResumeTick$lambda$1(MutableState<Integer> mutableState) {
        return ((Number) ((State) mutableState).getValue()).intValue();
    }

    private static final void rememberResumeTick$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberResumeTick$lambda$6$lambda$5(Context context, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleOwner findOwner = findOwner(context);
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                PermissionsUiKt.rememberResumeTick$lambda$6$lambda$5$lambda$3(mutableState, lifecycleOwner, event);
            }
        };
        if (findOwner != null && (lifecycle = findOwner.getLifecycle()) != null) {
            lifecycle.addObserver(lifecycleEventObserver);
        }
        return new DisposableEffectResult() { // from class: com.clozed.code.ui.PermissionsUiKt$rememberResumeTick$lambda$6$lambda$5$$inlined$onDispose$1
            public void dispose() {
                Lifecycle lifecycle2;
                LifecycleOwner lifecycleOwner = LifecycleOwner.this;
                if (lifecycleOwner == null || (lifecycle2 = lifecycleOwner.getLifecycle()) == null) {
                    return;
                }
                lifecycle2.removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberResumeTick$lambda$6$lambda$5$lambda$3(MutableState mutableState, LifecycleOwner lifecycleOwner, Lifecycle.Event e) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(e, "e");
        if (e == Lifecycle.Event.ON_RESUME) {
            rememberResumeTick$lambda$2(mutableState, rememberResumeTick$lambda$1(mutableState) + 1);
        }
    }

    private static final List<PermRow> rememberPermRows(Composer composer, int i) {
        composer.startReplaceGroup(-975963595);
        ComposerKt.sourceInformation(composer, "C(rememberPermRows)110@4647L7,111@4699L20,112@4882L60,112@4803L139,119@5173L272,127@5668L28,137@6292L23:PermissionsUi.kt#qn8u0p");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-975963595, i, -1, "com.clozed.code.ui.rememberPermRows (PermissionsUi.kt:109)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) consume;
        rememberResumeTick(composer, 0);
        ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
        composer.startReplaceGroup(1909877209);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit rememberPermRows$lambda$8$lambda$7;
                    rememberPermRows$lambda$8$lambda$7 = PermissionsUiKt.rememberPermRows$lambda$8$lambda$7(context, ((Boolean) obj).booleanValue());
                    return rememberPermRows$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) rememberedValue, composer, 0);
        ArrayList arrayList = new ArrayList();
        Boolean valueOf = Boolean.valueOf(hasNotifications(context));
        composer.startReplaceGroup(1909886733);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(context) | composer.changedInstance(rememberLauncherForActivityResult);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit rememberPermRows$lambda$10$lambda$9;
                    rememberPermRows$lambda$10$lambda$9 = PermissionsUiKt.rememberPermRows$lambda$10$lambda$9(context, rememberLauncherForActivityResult);
                    return rememberPermRows$lambda$10$lambda$9;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        arrayList.add(new PermRow("Notifications", "Shows the \"working\" notification that keeps the agent alive, and tells you when a task is done.", valueOf, "Allow", (Function0) rememberedValue2));
        Boolean valueOf2 = Boolean.valueOf(hasUnrestrictedBattery(context));
        composer.startReplaceGroup(1909902329);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changedInstance3 = composer.changedInstance(context);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit rememberPermRows$lambda$12$lambda$11;
                    rememberPermRows$lambda$12$lambda$11 = PermissionsUiKt.rememberPermRows$lambda$12$lambda$11(context);
                    return rememberPermRows$lambda$12$lambda$11;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        arrayList.add(new PermRow("Run in background (battery)", "Lets the agent keep coding with the screen off or the phone locked. Choose \"Allow\" / \"Unrestricted\".", valueOf2, "Allow", (Function0) rememberedValue3));
        composer.startReplaceGroup(1909903658);
        ComposerKt.sourceInformation(composer, "132@5937L27");
        if (Build.VERSION.SDK_INT >= 30) {
            Boolean valueOf3 = Boolean.valueOf(ComponentsKt.hasAllFilesAccess());
            composer.startReplaceGroup(1909910936);
            ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(context);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit rememberPermRows$lambda$14$lambda$13;
                        rememberPermRows$lambda$14$lambda$13 = PermissionsUiKt.rememberPermRows$lambda$14$lambda$13(context);
                        return rememberPermRows$lambda$14$lambda$13;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            arrayList.add(new PermRow("All files access", "Lets the agent read and write your project folders on internal storage or the SD card.", valueOf3, "Allow", (Function0) rememberedValue4));
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(1909922292);
        ComposerKt.sourceInformation(composer, "CC(remember):PermissionsUi.kt#9igjgp");
        boolean changedInstance5 = composer.changedInstance(context);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit rememberPermRows$lambda$16$lambda$15;
                    rememberPermRows$lambda$16$lambda$15 = PermissionsUiKt.rememberPermRows$lambda$16$lambda$15(context);
                    return rememberPermRows$lambda$16$lambda$15;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        arrayList.add(new PermRow("Auto-start / background activity", "On Xiaomi, Oppo, Vivo, Realme, Samsung and similar phones also enable Auto-start, set Battery to \"No restrictions\" and keep the app out of \"sleeping apps\". This cannot be detected, so please check it once.", null, "Open app settings", (Function0) rememberedValue5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberPermRows$lambda$8$lambda$7(Context context, boolean z) {
        if (!z) {
            openNotificationSettings(context);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberPermRows$lambda$10$lambda$9(Context context, ManagedActivityResultLauncher managedActivityResultLauncher) {
        if (Build.VERSION.SDK_INT >= 33 && context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            managedActivityResultLauncher.launch("android.permission.POST_NOTIFICATIONS");
        } else {
            openNotificationSettings(context);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberPermRows$lambda$12$lambda$11(Context context) {
        openBatterySettings(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberPermRows$lambda$14$lambda$13(Context context) {
        ComponentsKt.openAllFilesAccess(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberPermRows$lambda$16$lambda$15(Context context) {
        openAppDetails(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermRowView(final PermRow permRow, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(153296750);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermRowView)143@6390L614:PermissionsUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(permRow) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(153296750, i2, -1, "com.clozed.code.ui.PermRowView (PermissionsUi.kt:142)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, startRestartGroup, 54);
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
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -872630456, "C144@6530L229:PermissionsUi.kt#qn8u0p");
            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1459374292, "C145@6608L10,145@6572L57,146@6676L10,146@6720L11,146@6642L107:PermissionsUi.kt#qn8u0p");
            TextKt.Text-Nvy7gAk(permRow.getTitle(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyLarge(), startRestartGroup, 0, 0, 131070);
            TextKt.Text-Nvy7gAk(permRow.getWhy(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (Intrinsics.areEqual((Object) permRow.getGranted(), (Object) true)) {
                startRestartGroup.startReplaceGroup(-872366926);
                ComposerKt.sourceInformation(startRestartGroup, "149@6847L10,149@6892L11,149@6807L105");
                composer2 = startRestartGroup;
                TextKt.Text-Nvy7gAk("✓ Allowed", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelLarge(), composer2, 6, 0, 131066);
                composer2.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(664599774);
                ComposerKt.sourceInformation(startRestartGroup, "150@6970L18,150@6933L55");
                ButtonKt.FilledTonalButton(permRow.getGrant(), (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-183622555, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$PermRowView$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer5, Integer num) {
                        invoke(rowScope2, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope FilledTonalButton, Composer composer5, int i3) {
                        Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
                        ComposerKt.sourceInformation(composer5, "C150@6972L14:PermissionsUi.kt#qn8u0p");
                        if ((i3 & 17) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-183622555, i3, -1, "com.clozed.code.ui.PermRowView.<anonymous>.<anonymous> (PermissionsUi.kt:150)");
                        }
                        TextKt.Text-Nvy7gAk(PermRow.this.getButton(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 805306368, 510);
                composer2 = startRestartGroup;
                composer2.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PermRowView$lambda$19;
                    PermRowView$lambda$19 = PermissionsUiKt.PermRowView$lambda$19(PermRow.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PermRowView$lambda$19;
                }
            });
        }
    }

    public static final void PermissionsFirstRun(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(757161506);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermissionsFirstRun)158@7186L7,159@7210L74,160@7301L99,161@7445L74,161@7415L105:PermissionsUi.kt#qn8u0p");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757161506, i, -1, "com.clozed.code.ui.PermissionsFirstRun (PermissionsUi.kt:157)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            startRestartGroup.startReplaceGroup(-1069051806);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PermissionsUi.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = context.getSharedPreferences("clozed_code", 0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SharedPreferences sharedPreferences = (SharedPreferences) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1069048869);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PermissionsUi.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!sharedPreferences.getBoolean("perm_intro_done", false) && missingPermissions(context)), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (PermissionsFirstRun$lambda$22(mutableState)) {
                startRestartGroup.startReplaceGroup(-1069044286);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PermissionsUi.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(sharedPreferences);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PermissionsFirstRun$lambda$25$lambda$24;
                            PermissionsFirstRun$lambda$25$lambda$24 = PermissionsUiKt.PermissionsFirstRun$lambda$25$lambda$24(sharedPreferences, mutableState);
                            return PermissionsFirstRun$lambda$25$lambda$24;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                PermissionsDialog((Function0) rememberedValue3, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PermissionsFirstRun$lambda$26;
                    PermissionsFirstRun$lambda$26 = PermissionsUiKt.PermissionsFirstRun$lambda$26(i, (Composer) obj, ((Integer) obj2).intValue());
                    return PermissionsFirstRun$lambda$26;
                }
            });
        }
    }

    private static final boolean PermissionsFirstRun$lambda$22(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void PermissionsFirstRun$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsFirstRun$lambda$25$lambda$24(SharedPreferences sharedPreferences, MutableState mutableState) {
        sharedPreferences.edit().putBoolean("perm_intro_done", true).apply();
        PermissionsFirstRun$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    public static final void PermissionsDialog(final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1805753753);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermissionsDialog)166@7607L18,181@8334L150,184@8510L84,171@7803L505,168@7686L915:PermissionsUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(onDismiss) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1805753753, i2, -1, "com.clozed.code.ui.PermissionsDialog (PermissionsUi.kt:165)");
            }
            final List<PermRow> rememberPermRows = rememberPermRows(startRestartGroup, 0);
            Iterator<T> it = rememberPermRows.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((PermRow) obj).getGranted(), (Object) false)) {
                        break;
                    }
                }
            }
            final PermRow permRow = (PermRow) obj;
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(-1734620591, true, new PermissionsUiKt$PermissionsDialog$1(permRow, onDismiss), startRestartGroup, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(162876175, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$PermissionsDialog$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C184@8544L48,184@8512L80:PermissionsUi.kt#qn8u0p");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(162876175, i3, -1, "com.clozed.code.ui.PermissionsDialog.<anonymous> (PermissionsUi.kt:184)");
                    }
                    Function0<Unit> function0 = onDismiss;
                    final PermRow permRow2 = permRow;
                    ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1522678158, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$PermissionsDialog$2.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TextButton, Composer composer4, int i4) {
                            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                            ComposerKt.sourceInformation(composer4, "C184@8546L44:PermissionsUi.kt#qn8u0p");
                            if ((i4 & 17) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1522678158, i4, -1, "com.clozed.code.ui.PermissionsDialog.<anonymous>.<anonymous> (PermissionsUi.kt:184)");
                            }
                            TextKt.Text-Nvy7gAk(PermRow.this != null ? "Later" : "Close", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer4, 0, 0, 262142);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), (Function2) null, ComposableSingletons$PermissionsUiKt.INSTANCE.m1418getLambda1$app_release(), ComposableLambdaKt.rememberComposableLambda(861637676, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$PermissionsDialog$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C172@7848L21,172@7817L481:PermissionsUi.kt#qn8u0p");
                    if ((i3 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861637676, i3, -1, "com.clozed.code.ui.PermissionsDialog.<anonymous> (PermissionsUi.kt:172)");
                        }
                        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer3, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(14));
                        List<PermRow> list = rememberPermRows;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer3, 6);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, verticalScroll$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 1442259049, "C176@8195L10,173@7941L294:PermissionsUi.kt#qn8u0p");
                        TextKt.Text-Nvy7gAk("Clozed Code keeps working in a foreground service even when the screen is off or the phone is locked. To do that reliably it needs the permissions below.", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyMedium(), composer3, 6, 0, 131070);
                        composer3.startReplaceGroup(739270942);
                        ComposerKt.sourceInformation(composer3, "*178@8267L15");
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            PermissionsUiKt.PermRowView((PermRow) it2.next(), composer3, 0);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, (i2 & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PermissionsDialog$lambda$28;
                    PermissionsDialog$lambda$28 = PermissionsUiKt.PermissionsDialog$lambda$28(Function0.this, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return PermissionsDialog$lambda$28;
                }
            });
        }
    }

    public static final void backgroundSettings(LazyListScope lazyListScope, final AppViewModel vm) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(vm, "vm");
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$PermissionsUiKt.INSTANCE.m1419getLambda2$app_release(), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1315915427, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.clozed.code.ui.PermissionsUiKt$backgroundSettings$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation(composer, "C191@8798L18:PermissionsUi.kt#qn8u0p");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1315915427, i, -1, "com.clozed.code.ui.backgroundSettings.<anonymous> (PermissionsUi.kt:191)");
                }
                PermissionsUiKt.BackgroundCard(AppViewModel.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackgroundCard(final AppViewModel appViewModel, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1122157206);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundCard)196@8908L7,198@8966L18,199@9002L53,200@9129L11,200@9087L74,200@9199L1303,200@9060L1442:PermissionsUi.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(appViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1122157206, i2, -1, "com.clozed.code.ui.BackgroundCard (PermissionsUi.kt:195)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            LocalBackend local = appViewModel.getLocal();
            ProviderStore store = local != null ? local.getStore() : null;
            List<PermRow> rememberPermRows = rememberPermRows(startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1863918458);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PermissionsUi.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(store != null ? store.getVoiceDone() : true), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getSurfaceContainerLow-0d7_KjU(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1957879076, true, new PermissionsUiKt$BackgroundCard$1(rememberPermRows, context, store, (MutableState) rememberedValue), composer2, 54), composer2, 196614, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.PermissionsUiKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackgroundCard$lambda$32;
                    BackgroundCard$lambda$32 = PermissionsUiKt.BackgroundCard$lambda$32(AppViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackgroundCard$lambda$32;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BackgroundCard$lambda$30(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackgroundCard$lambda$31(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}

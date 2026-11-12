package com.clozed.code;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.clozed.code.engine.AppState;
import com.clozed.code.engine.McpOAuth;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"Lcom/clozed/code/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "vm", "Lcom/clozed/code/AppViewModel;", "getVm", "()Lcom/clozed/code/AppViewModel;", "vm$delegate", "Lkotlin/Lazy;", "notifPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "onStart", "", "onStop", "setupBackgroundWork", "onResume", "onNewIntent", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release", "mode", "dynamic", ""}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final ActivityResultLauncher<String> notifPermission = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.clozed.code.MainActivity$$ExternalSyntheticLambda0
        public final void onActivityResult(Object obj) {
            MainActivity.notifPermission$lambda$0(((Boolean) obj).booleanValue());
        }
    });

    /* renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifPermission$lambda$0(boolean z) {
    }

    public MainActivity() {
        final MainActivity mainActivity = this;
        final Function0 function0 = null;
        this.vm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppViewModel.class), new Function0<ViewModelStore>() { // from class: com.clozed.code.MainActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.clozed.code.MainActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return mainActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.clozed.code.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppViewModel getVm() {
        return (AppViewModel) this.vm.getValue();
    }

    protected void onStart() {
        super.onStart();
        AppState.INSTANCE.setForeground(true);
    }

    protected void onStop() {
        AppState.INSTANCE.setForeground(false);
        super.onStop();
    }

    private final void setupBackgroundWork() {
        SharedPreferences sharedPreferences = getSharedPreferences("clozed_code", 0);
        if (Build.VERSION.SDK_INT >= 33 && !sharedPreferences.getBoolean("notif_asked", false) && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            sharedPreferences.edit().putBoolean("notif_asked", true).apply();
            this.notifPermission.launch("android.permission.POST_NOTIFICATIONS");
        } else {
            if (sharedPreferences.getBoolean("battery_asked", false)) {
                return;
            }
            Object systemService = getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            if (((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                return;
            }
            sharedPreferences.edit().putBoolean("battery_asked", true).apply();
            try {
                startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + getPackageName())));
            } catch (Exception unused) {
            }
        }
    }

    protected void onResume() {
        super.onResume();
        getVm().onAppResumed();
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        McpOAuth.INSTANCE.handleRedirect(intent.getData());
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        McpOAuth mcpOAuth = McpOAuth.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        mcpOAuth.init(applicationContext);
        if (savedInstanceState == null) {
            McpOAuth mcpOAuth2 = McpOAuth.INSTANCE;
            Intent intent = getIntent();
            mcpOAuth2.handleRedirect(intent != null ? intent.getData() : null);
        }
        MainActivity mainActivity = this;
        EdgeToEdge.enable$default(mainActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        ComponentActivityKt.setContent$default(mainActivity, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(1019440605, true, new MainActivity$onCreate$1(this)), 1, (Object) null);
    }
}

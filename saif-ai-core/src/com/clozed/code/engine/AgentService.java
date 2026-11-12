package com.clozed.code.engine;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentService.kt */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0017\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006 "}, d2 = {"Lcom/clozed/code/engine/AgentService;", "Landroid/app/Service;", "<init>", "()V", "wake", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "wifi", "Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/net/wifi/WifiManager;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "handler", "Landroid/os/Handler;", "stopRunnable", "Ljava/lang/Runnable;", "renewRunnable", "com/clozed/code/engine/AgentService$renewRunnable$1", "Lcom/clozed/code/engine/AgentService$renewRunnable$1;", "acquireLocks", "", "releaseLocks", "onTimeout", "fgsType", "onDestroy", "Companion", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AgentService extends Service {
    public static final String ACTION_STOP = "com.clozed.code.STOP_AGENT";
    private static final long RENEW_MS = 1800000;
    private PowerManager.WakeLock wake;
    private WifiManager.WifiLock wifi;
    public static final int $stable = 8;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable stopRunnable = new Runnable() { // from class: com.clozed.code.engine.AgentService$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AgentService.stopRunnable$lambda$0(AgentService.this);
        }
    };
    private final AgentService$renewRunnable$1 renewRunnable = new Runnable() { // from class: com.clozed.code.engine.AgentService$renewRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            AgentService.this.acquireLocks();
            handler = AgentService.this.handler;
            handler.postDelayed(this, 1800000L);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, ACTION_STOP)) {
            LocalBackend engine = EngineHolder.INSTANCE.getEngine();
            if (engine != null) {
                engine.interruptAll();
            }
            stopSelf();
            return 2;
        }
        int intExtra = intent != null ? intent.getIntExtra("count", 1) : 1;
        this.handler.removeCallbacks(this.stopRunnable);
        Notification running = Notifier.INSTANCE.running(this, intExtra);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(Notifier.RUN_ID, running, 1);
            } else {
                startForeground(Notifier.RUN_ID, running);
            }
            if (intExtra <= 0) {
                this.handler.postDelayed(this.stopRunnable, 6000L);
                return 2;
            }
            acquireLocks();
            this.handler.removeCallbacks(this.renewRunnable);
            this.handler.postDelayed(this.renewRunnable, RENEW_MS);
            return 2;
        } catch (Exception unused) {
            stopSelf();
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopRunnable$lambda$0(AgentService agentService) {
        agentService.stopForeground(1);
        agentService.stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acquireLocks() {
        WifiManager.WifiLock wifiLock;
        try {
            if (this.wake == null) {
                Object systemService = getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "clozed:agent");
                newWakeLock.setReferenceCounted(false);
                this.wake = newWakeLock;
            }
            PowerManager.WakeLock wakeLock = this.wake;
            if (wakeLock != null) {
                wakeLock.acquire(3600000L);
            }
        } catch (Exception unused) {
        }
        try {
            if (this.wifi == null) {
                Object systemService2 = getApplicationContext().getSystemService("wifi");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                WifiManager.WifiLock createWifiLock = ((WifiManager) systemService2).createWifiLock(Build.VERSION.SDK_INT >= 29 ? 4 : 3, "clozed:wifi");
                createWifiLock.setReferenceCounted(false);
                this.wifi = createWifiLock;
            }
            WifiManager.WifiLock wifiLock2 = this.wifi;
            if (wifiLock2 == null || wifiLock2.isHeld() || (wifiLock = this.wifi) == null) {
                return;
            }
            wifiLock.acquire();
        } catch (Exception unused2) {
        }
    }

    private final void releaseLocks() {
        WifiManager.WifiLock wifiLock;
        PowerManager.WakeLock wakeLock;
        try {
            PowerManager.WakeLock wakeLock2 = this.wake;
            if (wakeLock2 != null && wakeLock2.isHeld() && (wakeLock = this.wake) != null) {
                wakeLock.release();
            }
        } catch (Exception unused) {
        }
        try {
            WifiManager.WifiLock wifiLock2 = this.wifi;
            if (wifiLock2 == null || !wifiLock2.isHeld() || (wifiLock = this.wifi) == null) {
                return;
            }
            wifiLock.release();
        } catch (Exception unused2) {
        }
    }

    public void onTimeout(int startId, int fgsType) {
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        releaseLocks();
        super.onDestroy();
    }
}

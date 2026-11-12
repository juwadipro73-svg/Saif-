package com.clozed.code.engine;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.clozed.code.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AgentService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bJ&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/engine/Notifier;", "", "<init>", "()V", "CH_RUN", "", "CH_ALERT", "RUN_ID", "", "ensureChannels", "", "ctx", "Landroid/content/Context;", "openIntent", "Landroid/app/PendingIntent;", "running", "Landroid/app/Notification;", "count", "alert", "key", "title", "text", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Notifier {
    public static final int $stable = 0;
    public static final String CH_ALERT = "agent_alert";
    public static final String CH_RUN = "agent_run";
    public static final Notifier INSTANCE = new Notifier();
    public static final int RUN_ID = 4101;

    private Notifier() {
    }

    public final void ensureChannels(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Object systemService = ctx.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(new NotificationChannel(CH_RUN, "Agent running", 2));
        notificationManager.createNotificationChannel(new NotificationChannel(CH_ALERT, "Agent alerts", 3));
    }

    private final PendingIntent openIntent(Context ctx) {
        Intent addFlags = new Intent(ctx, (Class<?>) MainActivity.class).addFlags(805306368);
        Intrinsics.checkNotNullExpressionValue(addFlags, "addFlags(...)");
        PendingIntent activity = PendingIntent.getActivity(ctx, 0, addFlags, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    public final Notification running(Context ctx, int count) {
        String str;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ensureChannels(ctx);
        PendingIntent service = PendingIntent.getService(ctx, 1, new Intent(ctx, (Class<?>) AgentService.class).setAction(AgentService.ACTION_STOP), 201326592);
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(ctx, CH_RUN).setContentTitle("Clozed Code is working");
        if (count <= 0) {
            str = "Finishing up…";
        } else {
            str = count == 1 ? "1 session running" : count + " sessions running";
        }
        Notification build = contentTitle.setContentText(str).setSmallIcon(R.drawable.stat_notify_sync).setOngoing(true).setOnlyAlertOnce(true).setContentIntent(openIntent(ctx)).addAction(0, "Stop", service).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final void alert(Context ctx, String key, String title, String text) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        if (AppState.INSTANCE.getForeground()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 33 || ctx.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            try {
                ensureChannels(ctx);
                Notification build = new NotificationCompat.Builder(ctx, CH_ALERT).setContentTitle(title).setContentText(StringsKt.take(text, 200)).setStyle(new NotificationCompat.BigTextStyle().bigText(StringsKt.take(text, 400))).setSmallIcon(R.drawable.stat_notify_chat).setAutoCancel(true).setContentIntent(openIntent(ctx)).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Object systemService = ctx.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).notify(key.hashCode(), build);
            } catch (Exception unused) {
            }
        }
    }
}

package com.clozed.code.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Components.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"hasAllFilesAccess", "", "openAllFilesAccess", "", "ctx", "Landroid/content/Context;", "pasteFromClipboard", "", "SectionHeader", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "LetterAvatar", "name", "size", "Landroidx/compose/ui/unit/Dp;", "LetterAvatar-rAjV9yQ", "(Ljava/lang/String;FLandroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ComponentsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LetterAvatar_rAjV9yQ$lambda$1(String str, float f, int i, int i2, Composer composer, int i3) {
        m1340LetterAvatarrAjV9yQ(str, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionHeader$lambda$0(String str, int i, Composer composer, int i2) {
        SectionHeader(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final boolean hasAllFilesAccess() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return true;
    }

    public static final void openAllFilesAccess(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    ctx.startActivity(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + ctx.getPackageName())));
                }
            } catch (Exception unused) {
                ctx.startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
            }
        } catch (Exception unused2) {
        }
    }

    public static final String pasteFromClipboard(Context ctx) {
        ClipData primaryClip;
        CharSequence coerceToText;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() == 0 || (coerceToText = primaryClip.getItemAt(0).coerceToText(ctx)) == null) {
            return null;
        }
        return coerceToText.toString();
    }

    public static final void SectionHeader(final String text, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(1032124032);
        ComposerKt.sourceInformation(startRestartGroup, "C(SectionHeader)47@1723L10,48@1776L11,45@1673L208:Components.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(text) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1032124032, i2, -1, "com.clozed.code.ui.SectionHeader (Components.kt:44)");
            }
            composer2 = startRestartGroup;
            TextKt.Text-Nvy7gAk(text, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.m826constructorimpl(4), Dp.m826constructorimpl(20), 0.0f, Dp.m826constructorimpl(2), 4, (Object) null), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getTitleSmall(), composer2, (i2 & 14) | 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.ComponentsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SectionHeader$lambda$0;
                    SectionHeader$lambda$0 = ComponentsKt.SectionHeader$lambda$0(text, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SectionHeader$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* renamed from: LetterAvatar-rAjV9yQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1340LetterAvatarrAjV9yQ(final java.lang.String r24, float r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ComponentsKt.m1340LetterAvatarrAjV9yQ(java.lang.String, float, androidx.compose.runtime.Composer, int, int):void");
    }
}

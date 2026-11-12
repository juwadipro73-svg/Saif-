package com.clozed.code.ui.theme;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Theme.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkScheme", "Landroidx/compose/material3/ColorScheme;", "LightScheme", "ClozedCodeTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ThemeKt {
    private static final ColorScheme DarkScheme = ColorSchemeKt.darkColorScheme-_VG5OTI$default(ColorKt.getDarkPrimary(), ColorKt.getDarkOnPrimary(), ColorKt.getDarkPrimaryContainer(), ColorKt.getDarkOnPrimaryContainer(), ColorKt.getDarkInversePrimary(), ColorKt.getDarkSecondary(), ColorKt.getDarkOnSecondary(), ColorKt.getDarkSecondaryContainer(), ColorKt.getDarkOnSecondaryContainer(), ColorKt.getDarkTertiary(), ColorKt.getDarkOnTertiary(), ColorKt.getDarkTertiaryContainer(), ColorKt.getDarkOnTertiaryContainer(), ColorKt.getDarkSurface(), ColorKt.getDarkOnSurface(), ColorKt.getDarkSurface(), ColorKt.getDarkOnSurface(), ColorKt.getDarkSurfaceVariant(), ColorKt.getDarkOnSurfaceVariant(), ColorKt.getDarkPrimary(), ColorKt.getDarkInverseSurface(), ColorKt.getDarkInverseOnSurface(), ColorKt.getDarkError(), ColorKt.getDarkOnError(), ColorKt.getDarkErrorContainer(), ColorKt.getDarkOnErrorContainer(), ColorKt.getDarkOutline(), ColorKt.getDarkOutlineVariant(), Color.Companion.getBlack-0d7_KjU(), ColorKt.getDarkSurfaceBright(), ColorKt.getDarkSurfaceContainer(), ColorKt.getDarkSurfaceHigh(), ColorKt.getDarkSurfaceHighest(), ColorKt.getDarkSurfaceLow(), ColorKt.getDarkSurfaceLowest(), ColorKt.getDarkSurfaceDim(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, (Object) null);
    private static final ColorScheme LightScheme = ColorSchemeKt.lightColorScheme-_VG5OTI$default(ColorKt.getLightPrimary(), ColorKt.getLightOnPrimary(), ColorKt.getLightPrimaryContainer(), ColorKt.getLightOnPrimaryContainer(), ColorKt.getLightInversePrimary(), ColorKt.getLightSecondary(), ColorKt.getLightOnSecondary(), ColorKt.getLightSecondaryContainer(), ColorKt.getLightOnSecondaryContainer(), ColorKt.getLightTertiary(), ColorKt.getLightOnTertiary(), ColorKt.getLightTertiaryContainer(), ColorKt.getLightOnTertiaryContainer(), ColorKt.getLightSurface(), ColorKt.getLightOnSurface(), ColorKt.getLightSurface(), ColorKt.getLightOnSurface(), ColorKt.getLightSurfaceVariant(), ColorKt.getLightOnSurfaceVariant(), ColorKt.getLightPrimary(), ColorKt.getLightInverseSurface(), ColorKt.getLightInverseOnSurface(), ColorKt.getLightError(), ColorKt.getLightOnError(), ColorKt.getLightErrorContainer(), ColorKt.getLightOnErrorContainer(), ColorKt.getLightOutline(), ColorKt.getLightOutlineVariant(), Color.Companion.getBlack-0d7_KjU(), ColorKt.getLightSurfaceBright(), ColorKt.getLightSurfaceContainer(), ColorKt.getLightSurfaceHigh(), ColorKt.getLightSurfaceHighest(), ColorKt.getLightSurfaceLow(), ColorKt.getLightSurfaceLowest(), ColorKt.getLightSurfaceDim(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClozedCodeTheme$lambda$0(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        ClozedCodeTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ClozedCodeTheme(boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(177029803);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClozedCodeTheme)P(1,2)66@3504L7,73@3864L95,73@3769L190:Theme.kt#8lz4te");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && startRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "62@3378L21");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    z = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
                    i3 &= -15;
                }
                if (i4 != 0) {
                    z2 = false;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(177029803, i3, -1, "com.clozed.code.ui.theme.ClozedCodeTheme (Theme.kt:65)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            if (z2 && Build.VERSION.SDK_INT >= 31) {
                colorScheme = z ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
            } else if (z) {
                colorScheme = DarkScheme;
            } else {
                colorScheme = LightScheme;
            }
            CompositionLocalKt.CompositionLocalProvider(ColorKt.getLocalExtraColors().provides(z ? ColorKt.getDarkExtra() : ColorKt.getLightExtra()), ComposableLambdaKt.rememberComposableLambda(1666574187, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.theme.ThemeKt$ClozedCodeTheme$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C74@3874L79:Theme.kt#8lz4te");
                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1666574187, i5, -1, "com.clozed.code.ui.theme.ClozedCodeTheme.<anonymous> (Theme.kt:74)");
                    }
                    MaterialThemeKt.MaterialTheme(colorScheme, (Shapes) null, TypeKt.getTypography(), content, composer2, 384, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final boolean z3 = z;
        final boolean z4 = z2;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ClozedCodeTheme$lambda$0;
                    ClozedCodeTheme$lambda$0 = ThemeKt.ClozedCodeTheme$lambda$0(z3, z4, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ClozedCodeTheme$lambda$0;
                }
            });
        }
    }
}

package com.clozed.code.ui.theme;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0088\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0013\u0010\u0007\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0013\u0010\t\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0013\u0010\u000b\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u0013\u0010\r\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u0003\"\u0013\u0010\u000f\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0013\u0010\u0011\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\u0003\"\u0013\u0010\u0013\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0003\"\u0013\u0010\u0015\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0016\u0010\u0003\"\u0013\u0010\u0017\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0018\u0010\u0003\"\u0013\u0010\u0019\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001a\u0010\u0003\"\u0013\u0010\u001b\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001c\u0010\u0003\"\u0013\u0010\u001d\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001e\u0010\u0003\"\u0013\u0010\u001f\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b \u0010\u0003\"\u0013\u0010!\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\"\u0010\u0003\"\u0013\u0010#\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b$\u0010\u0003\"\u0013\u0010%\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b&\u0010\u0003\"\u0013\u0010'\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b(\u0010\u0003\"\u0013\u0010)\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b*\u0010\u0003\"\u0013\u0010+\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b,\u0010\u0003\"\u0013\u0010-\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b.\u0010\u0003\"\u0013\u0010/\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b0\u0010\u0003\"\u0013\u00101\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b2\u0010\u0003\"\u0013\u00103\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b4\u0010\u0003\"\u0013\u00105\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b6\u0010\u0003\"\u0013\u00107\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b8\u0010\u0003\"\u0013\u00109\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b:\u0010\u0003\"\u0013\u0010;\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b<\u0010\u0003\"\u0013\u0010=\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b>\u0010\u0003\"\u0013\u0010?\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b@\u0010\u0003\"\u0013\u0010A\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bB\u0010\u0003\"\u0013\u0010C\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bD\u0010\u0003\"\u0013\u0010E\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bF\u0010\u0003\"\u0013\u0010G\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bH\u0010\u0003\"\u0013\u0010I\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bJ\u0010\u0003\"\u0013\u0010K\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bL\u0010\u0003\"\u0013\u0010M\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bN\u0010\u0003\"\u0013\u0010O\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bP\u0010\u0003\"\u0013\u0010Q\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bR\u0010\u0003\"\u0013\u0010S\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bT\u0010\u0003\"\u0013\u0010U\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bV\u0010\u0003\"\u0013\u0010W\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bX\u0010\u0003\"\u0013\u0010Y\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bZ\u0010\u0003\"\u0013\u0010[\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\\\u0010\u0003\"\u0013\u0010]\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b^\u0010\u0003\"\u0013\u0010_\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b`\u0010\u0003\"\u0013\u0010a\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bb\u0010\u0003\"\u0013\u0010c\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bd\u0010\u0003\"\u0013\u0010e\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bf\u0010\u0003\"\u0013\u0010g\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bh\u0010\u0003\"\u0013\u0010i\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bj\u0010\u0003\"\u0013\u0010k\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bl\u0010\u0003\"\u0013\u0010m\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bn\u0010\u0003\"\u0013\u0010o\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bp\u0010\u0003\"\u0013\u0010q\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\br\u0010\u0003\"\u0013\u0010s\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bt\u0010\u0003\"\u0013\u0010u\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bv\u0010\u0003\"\u0013\u0010w\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bx\u0010\u0003\"\u0013\u0010y\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bz\u0010\u0003\"\u0013\u0010{\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b|\u0010\u0003\"\u0013\u0010}\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b~\u0010\u0003\"\u0014\u0010\u007f\u001a\u00020\u0001¢\u0006\u000b\n\u0002\u0010\u0004\u001a\u0005\b\u0080\u0001\u0010\u0003\"\u0015\u0010\u0081\u0001\u001a\u00020\u0001¢\u0006\u000b\n\u0002\u0010\u0004\u001a\u0005\b\u0082\u0001\u0010\u0003\"\u0015\u0010\u0083\u0001\u001a\u00020\u0001¢\u0006\u000b\n\u0002\u0010\u0004\u001a\u0005\b\u0084\u0001\u0010\u0003\"\u0015\u0010\u0085\u0001\u001a\u00020\u0001¢\u0006\u000b\n\u0002\u0010\u0004\u001a\u0005\b\u0086\u0001\u0010\u0003\"\u0015\u0010\u0087\u0001\u001a\u00020\u0001¢\u0006\u000b\n\u0002\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0003\"\u0015\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0015\u0010\u008d\u0001\u001a\u00030\u008a\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001\"\u001c\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0090\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u001a\u0010\u0093\u0001\u001a\u00030\u008a\u0001*\u00030\u0094\u00018G¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u0097\u0001"}, d2 = {"DarkPrimary", "Landroidx/compose/ui/graphics/Color;", "getDarkPrimary", "()J", "J", "DarkOnPrimary", "getDarkOnPrimary", "DarkPrimaryContainer", "getDarkPrimaryContainer", "DarkOnPrimaryContainer", "getDarkOnPrimaryContainer", "DarkSecondary", "getDarkSecondary", "DarkOnSecondary", "getDarkOnSecondary", "DarkSecondaryContainer", "getDarkSecondaryContainer", "DarkOnSecondaryContainer", "getDarkOnSecondaryContainer", "DarkTertiary", "getDarkTertiary", "DarkOnTertiary", "getDarkOnTertiary", "DarkTertiaryContainer", "getDarkTertiaryContainer", "DarkOnTertiaryContainer", "getDarkOnTertiaryContainer", "DarkError", "getDarkError", "DarkOnError", "getDarkOnError", "DarkErrorContainer", "getDarkErrorContainer", "DarkOnErrorContainer", "getDarkOnErrorContainer", "DarkSurface", "getDarkSurface", "DarkOnSurface", "getDarkOnSurface", "DarkSurfaceVariant", "getDarkSurfaceVariant", "DarkOnSurfaceVariant", "getDarkOnSurfaceVariant", "DarkOutline", "getDarkOutline", "DarkOutlineVariant", "getDarkOutlineVariant", "DarkSurfaceDim", "getDarkSurfaceDim", "DarkSurfaceBright", "getDarkSurfaceBright", "DarkSurfaceLowest", "getDarkSurfaceLowest", "DarkSurfaceLow", "getDarkSurfaceLow", "DarkSurfaceContainer", "getDarkSurfaceContainer", "DarkSurfaceHigh", "getDarkSurfaceHigh", "DarkSurfaceHighest", "getDarkSurfaceHighest", "DarkInverseSurface", "getDarkInverseSurface", "DarkInverseOnSurface", "getDarkInverseOnSurface", "DarkInversePrimary", "getDarkInversePrimary", "LightPrimary", "getLightPrimary", "LightOnPrimary", "getLightOnPrimary", "LightPrimaryContainer", "getLightPrimaryContainer", "LightOnPrimaryContainer", "getLightOnPrimaryContainer", "LightSecondary", "getLightSecondary", "LightOnSecondary", "getLightOnSecondary", "LightSecondaryContainer", "getLightSecondaryContainer", "LightOnSecondaryContainer", "getLightOnSecondaryContainer", "LightTertiary", "getLightTertiary", "LightOnTertiary", "getLightOnTertiary", "LightTertiaryContainer", "getLightTertiaryContainer", "LightOnTertiaryContainer", "getLightOnTertiaryContainer", "LightError", "getLightError", "LightOnError", "getLightOnError", "LightErrorContainer", "getLightErrorContainer", "LightOnErrorContainer", "getLightOnErrorContainer", "LightSurface", "getLightSurface", "LightOnSurface", "getLightOnSurface", "LightSurfaceVariant", "getLightSurfaceVariant", "LightOnSurfaceVariant", "getLightOnSurfaceVariant", "LightOutline", "getLightOutline", "LightOutlineVariant", "getLightOutlineVariant", "LightSurfaceDim", "getLightSurfaceDim", "LightSurfaceBright", "getLightSurfaceBright", "LightSurfaceLowest", "getLightSurfaceLowest", "LightSurfaceLow", "getLightSurfaceLow", "LightSurfaceContainer", "getLightSurfaceContainer", "LightSurfaceHigh", "getLightSurfaceHigh", "LightSurfaceHighest", "getLightSurfaceHighest", "LightInverseSurface", "getLightInverseSurface", "LightInverseOnSurface", "getLightInverseOnSurface", "LightInversePrimary", "getLightInversePrimary", "BrandBlue", "getBrandBlue", "BrandWhite", "getBrandWhite", "BrandBlack", "getBrandBlack", "DarkExtra", "Lcom/clozed/code/ui/theme/ExtraColors;", "getDarkExtra", "()Lcom/clozed/code/ui/theme/ExtraColors;", "LightExtra", "getLightExtra", "LocalExtraColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalExtraColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "extra", "Landroidx/compose/material3/MaterialTheme;", "getExtra", "(Landroidx/compose/material3/MaterialTheme;Landroidx/compose/runtime/Composer;I)Lcom/clozed/code/ui/theme/ExtraColors;", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ColorKt {
    private static final long DarkPrimary = androidx.compose.ui.graphics.ColorKt.Color(4281044223L);
    private static final long DarkOnPrimary = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long DarkPrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4278857315L);
    private static final long DarkOnPrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4292077055L);
    private static final long DarkSecondary = androidx.compose.ui.graphics.ColorKt.Color(4288462322L);
    private static final long DarkOnSecondary = androidx.compose.ui.graphics.ColorKt.Color(4278920007L);
    private static final long DarkSecondaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279576128L);
    private static final long DarkOnSecondaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4292010747L);
    private static final long DarkTertiary = androidx.compose.ui.graphics.ColorKt.Color(4283421160L);
    private static final long DarkOnTertiary = androidx.compose.ui.graphics.ColorKt.Color(4278203452L);
    private static final long DarkTertiaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4278860356L);
    private static final long DarkOnTertiaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4290835711L);
    private static final long DarkError = androidx.compose.ui.graphics.ColorKt.Color(4294948011L);
    private static final long DarkOnError = androidx.compose.ui.graphics.ColorKt.Color(4285071365L);
    private static final long DarkErrorContainer = androidx.compose.ui.graphics.ColorKt.Color(4287823882L);
    private static final long DarkOnErrorContainer = androidx.compose.ui.graphics.ColorKt.Color(4294957782L);
    private static final long DarkSurface = androidx.compose.ui.graphics.ColorKt.Color(4278585096L);
    private static final long DarkOnSurface = androidx.compose.ui.graphics.ColorKt.Color(4294177781L);
    private static final long DarkSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4279902512L);
    private static final long DarkOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4288390840L);
    private static final long DarkOutline = androidx.compose.ui.graphics.ColorKt.Color(4283851128L);
    private static final long DarkOutlineVariant = androidx.compose.ui.graphics.ColorKt.Color(4280429114L);
    private static final long DarkSurfaceDim = androidx.compose.ui.graphics.ColorKt.Color(4278585096L);
    private static final long DarkSurfaceBright = androidx.compose.ui.graphics.ColorKt.Color(4280954939L);
    private static final long DarkSurfaceLowest = androidx.compose.ui.graphics.ColorKt.Color(4278190080L);
    private static final long DarkSurfaceLow = androidx.compose.ui.graphics.ColorKt.Color(4278980114L);
    private static final long DarkSurfaceContainer = androidx.compose.ui.graphics.ColorKt.Color(4279309595L);
    private static final long DarkSurfaceHigh = androidx.compose.ui.graphics.ColorKt.Color(4279770406L);
    private static final long DarkSurfaceHighest = androidx.compose.ui.graphics.ColorKt.Color(4280297010L);
    private static final long DarkInverseSurface = androidx.compose.ui.graphics.ColorKt.Color(4294177781L);
    private static final long DarkInverseOnSurface = androidx.compose.ui.graphics.ColorKt.Color(4279309080L);
    private static final long DarkInversePrimary = androidx.compose.ui.graphics.ColorKt.Color(4278216406L);
    private static final long LightPrimary = androidx.compose.ui.graphics.ColorKt.Color(4278216934L);
    private static final long LightOnPrimary = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long LightPrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4292273919L);
    private static final long LightOnPrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4278197056L);
    private static final long LightSecondary = androidx.compose.ui.graphics.ColorKt.Color(4282933386L);
    private static final long LightOnSecondary = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long LightSecondaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4292536060L);
    private static final long LightOnSecondaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4278852406L);
    private static final long LightTertiary = androidx.compose.ui.graphics.ColorKt.Color(4278217594L);
    private static final long LightOnTertiary = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long LightTertiaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4290506747L);
    private static final long LightOnTertiaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4278198053L);
    private static final long LightError = androidx.compose.ui.graphics.ColorKt.Color(4290386458L);
    private static final long LightOnError = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long LightErrorContainer = androidx.compose.ui.graphics.ColorKt.Color(4294957782L);
    private static final long LightOnErrorContainer = androidx.compose.ui.graphics.ColorKt.Color(4282449922L);
    private static final long LightSurface = androidx.compose.ui.graphics.ColorKt.Color(4294375934L);
    private static final long LightOnSurface = androidx.compose.ui.graphics.ColorKt.Color(4278849046L);
    private static final long LightSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4292929523L);
    private static final long LightOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4282732128L);
    private static final long LightOutline = androidx.compose.ui.graphics.ColorKt.Color(4285692814L);
    private static final long LightOutlineVariant = androidx.compose.ui.graphics.ColorKt.Color(4291219165L);
    private static final long LightSurfaceDim = androidx.compose.ui.graphics.ColorKt.Color(4292402921L);
    private static final long LightSurfaceBright = androidx.compose.ui.graphics.ColorKt.Color(4294375934L);
    private static final long LightSurfaceLowest = androidx.compose.ui.graphics.ColorKt.Color(4294967295L);
    private static final long LightSurfaceLow = androidx.compose.ui.graphics.ColorKt.Color(4293915642L);
    private static final long LightSurfaceContainer = androidx.compose.ui.graphics.ColorKt.Color(4293521143L);
    private static final long LightSurfaceHigh = androidx.compose.ui.graphics.ColorKt.Color(4293126643L);
    private static final long LightSurfaceHighest = androidx.compose.ui.graphics.ColorKt.Color(4292732143L);
    private static final long LightInverseSurface = androidx.compose.ui.graphics.ColorKt.Color(4278585096L);
    private static final long LightInverseOnSurface = androidx.compose.ui.graphics.ColorKt.Color(4294177781L);
    private static final long LightInversePrimary = androidx.compose.ui.graphics.ColorKt.Color(4287478783L);
    private static final long BrandBlue = androidx.compose.ui.graphics.ColorKt.Color(4278220542L);
    private static final long BrandWhite = androidx.compose.ui.graphics.ColorKt.Color(4294177781L);
    private static final long BrandBlack = androidx.compose.ui.graphics.ColorKt.Color(4278585096L);
    private static final ExtraColors DarkExtra = new ExtraColors(androidx.compose.ui.graphics.ColorKt.Color(4287027603L), androidx.compose.ui.graphics.ColorKt.Color(4278204698L), androidx.compose.ui.graphics.ColorKt.Color(4278211113L), androidx.compose.ui.graphics.ColorKt.Color(4288869806L), androidx.compose.ui.graphics.ColorKt.Color(4294949212L), androidx.compose.ui.graphics.ColorKt.Color(4282788352L), androidx.compose.ui.graphics.ColorKt.Color(4284759808L), androidx.compose.ui.graphics.ColorKt.Color(4294958516L), null);
    private static final ExtraColors LightExtra = new ExtraColors(androidx.compose.ui.graphics.ColorKt.Color(4279987258L), androidx.compose.ui.graphics.ColorKt.Color(4294967295L), androidx.compose.ui.graphics.ColorKt.Color(4288869812L), androidx.compose.ui.graphics.ColorKt.Color(4278198541L), androidx.compose.ui.graphics.ColorKt.Color(4287320064L), androidx.compose.ui.graphics.ColorKt.Color(4294967295L), androidx.compose.ui.graphics.ColorKt.Color(4294958269L), androidx.compose.ui.graphics.ColorKt.Color(4281079296L), null);
    private static final ProvidableCompositionLocal<ExtraColors> LocalExtraColors = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.clozed.code.ui.theme.ColorKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ExtraColors extraColors;
            extraColors = ColorKt.DarkExtra;
            return extraColors;
        }
    });

    public static final long getDarkPrimary() {
        return DarkPrimary;
    }

    public static final long getDarkOnPrimary() {
        return DarkOnPrimary;
    }

    public static final long getDarkPrimaryContainer() {
        return DarkPrimaryContainer;
    }

    public static final long getDarkOnPrimaryContainer() {
        return DarkOnPrimaryContainer;
    }

    public static final long getDarkSecondary() {
        return DarkSecondary;
    }

    public static final long getDarkOnSecondary() {
        return DarkOnSecondary;
    }

    public static final long getDarkSecondaryContainer() {
        return DarkSecondaryContainer;
    }

    public static final long getDarkOnSecondaryContainer() {
        return DarkOnSecondaryContainer;
    }

    public static final long getDarkTertiary() {
        return DarkTertiary;
    }

    public static final long getDarkOnTertiary() {
        return DarkOnTertiary;
    }

    public static final long getDarkTertiaryContainer() {
        return DarkTertiaryContainer;
    }

    public static final long getDarkOnTertiaryContainer() {
        return DarkOnTertiaryContainer;
    }

    public static final long getDarkError() {
        return DarkError;
    }

    public static final long getDarkOnError() {
        return DarkOnError;
    }

    public static final long getDarkErrorContainer() {
        return DarkErrorContainer;
    }

    public static final long getDarkOnErrorContainer() {
        return DarkOnErrorContainer;
    }

    public static final long getDarkSurface() {
        return DarkSurface;
    }

    public static final long getDarkOnSurface() {
        return DarkOnSurface;
    }

    public static final long getDarkSurfaceVariant() {
        return DarkSurfaceVariant;
    }

    public static final long getDarkOnSurfaceVariant() {
        return DarkOnSurfaceVariant;
    }

    public static final long getDarkOutline() {
        return DarkOutline;
    }

    public static final long getDarkOutlineVariant() {
        return DarkOutlineVariant;
    }

    public static final long getDarkSurfaceDim() {
        return DarkSurfaceDim;
    }

    public static final long getDarkSurfaceBright() {
        return DarkSurfaceBright;
    }

    public static final long getDarkSurfaceLowest() {
        return DarkSurfaceLowest;
    }

    public static final long getDarkSurfaceLow() {
        return DarkSurfaceLow;
    }

    public static final long getDarkSurfaceContainer() {
        return DarkSurfaceContainer;
    }

    public static final long getDarkSurfaceHigh() {
        return DarkSurfaceHigh;
    }

    public static final long getDarkSurfaceHighest() {
        return DarkSurfaceHighest;
    }

    public static final long getDarkInverseSurface() {
        return DarkInverseSurface;
    }

    public static final long getDarkInverseOnSurface() {
        return DarkInverseOnSurface;
    }

    public static final long getDarkInversePrimary() {
        return DarkInversePrimary;
    }

    public static final long getLightPrimary() {
        return LightPrimary;
    }

    public static final long getLightOnPrimary() {
        return LightOnPrimary;
    }

    public static final long getLightPrimaryContainer() {
        return LightPrimaryContainer;
    }

    public static final long getLightOnPrimaryContainer() {
        return LightOnPrimaryContainer;
    }

    public static final long getLightSecondary() {
        return LightSecondary;
    }

    public static final long getLightOnSecondary() {
        return LightOnSecondary;
    }

    public static final long getLightSecondaryContainer() {
        return LightSecondaryContainer;
    }

    public static final long getLightOnSecondaryContainer() {
        return LightOnSecondaryContainer;
    }

    public static final long getLightTertiary() {
        return LightTertiary;
    }

    public static final long getLightOnTertiary() {
        return LightOnTertiary;
    }

    public static final long getLightTertiaryContainer() {
        return LightTertiaryContainer;
    }

    public static final long getLightOnTertiaryContainer() {
        return LightOnTertiaryContainer;
    }

    public static final long getLightError() {
        return LightError;
    }

    public static final long getLightOnError() {
        return LightOnError;
    }

    public static final long getLightErrorContainer() {
        return LightErrorContainer;
    }

    public static final long getLightOnErrorContainer() {
        return LightOnErrorContainer;
    }

    public static final long getLightSurface() {
        return LightSurface;
    }

    public static final long getLightOnSurface() {
        return LightOnSurface;
    }

    public static final long getLightSurfaceVariant() {
        return LightSurfaceVariant;
    }

    public static final long getLightOnSurfaceVariant() {
        return LightOnSurfaceVariant;
    }

    public static final long getLightOutline() {
        return LightOutline;
    }

    public static final long getLightOutlineVariant() {
        return LightOutlineVariant;
    }

    public static final long getLightSurfaceDim() {
        return LightSurfaceDim;
    }

    public static final long getLightSurfaceBright() {
        return LightSurfaceBright;
    }

    public static final long getLightSurfaceLowest() {
        return LightSurfaceLowest;
    }

    public static final long getLightSurfaceLow() {
        return LightSurfaceLow;
    }

    public static final long getLightSurfaceContainer() {
        return LightSurfaceContainer;
    }

    public static final long getLightSurfaceHigh() {
        return LightSurfaceHigh;
    }

    public static final long getLightSurfaceHighest() {
        return LightSurfaceHighest;
    }

    public static final long getLightInverseSurface() {
        return LightInverseSurface;
    }

    public static final long getLightInverseOnSurface() {
        return LightInverseOnSurface;
    }

    public static final long getLightInversePrimary() {
        return LightInversePrimary;
    }

    public static final long getBrandBlue() {
        return BrandBlue;
    }

    public static final long getBrandWhite() {
        return BrandWhite;
    }

    public static final long getBrandBlack() {
        return BrandBlack;
    }

    public static final ExtraColors getDarkExtra() {
        return DarkExtra;
    }

    public static final ExtraColors getLightExtra() {
        return LightExtra;
    }

    public static final ProvidableCompositionLocal<ExtraColors> getLocalExtraColors() {
        return LocalExtraColors;
    }

    public static final ExtraColors getExtra(MaterialTheme materialTheme, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(materialTheme, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 1227541186, "C(<get-extra>)117@4466L7:Color.kt#8lz4te");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1227541186, i, -1, "com.clozed.code.ui.theme.<get-extra> (Color.kt:117)");
        }
        CompositionLocal compositionLocal = LocalExtraColors;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(compositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ExtraColors extraColors = (ExtraColors) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return extraColors;
    }
}

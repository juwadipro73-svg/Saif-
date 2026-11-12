package com.clozed.code.ui;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import com.clozed.code.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LogoMotion.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\u001aM\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0016\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b&\u0010$\u001a#\u0010'\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b(\u0010$\u001a-\u0010)\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010,\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u00102\u001a#\u00103\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b4\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065²\u0006\n\u00106\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00108\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00109\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010:\u001a\u00020;X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"X0", "", "Y0", "SPAN", "C_SHAPE", "", "LEFT_CHEVRON", "RIGHT_CHEVRON", "SLASH", "poly", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "pts", "ox", "oy", "k", "dx", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "poly-vmayBhU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFFFJF)V", "drawMark", "side", "cColor", "accent", "shift", "slashAlpha", "drawMark-9z6LAg8", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJJFF)V", "LogoMark", "size", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "LogoMark--orJrPs", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LogoBadge", "LogoBadge--orJrPs", "ClozedLoader", "ClozedLoader--orJrPs", "LogoSpinner", "LogoSpinner-8s8adOk", "(FJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TypingDots", "TypingDots-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)V", "AgentWorkingIndicator", "thinking", "", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LogoHero", "LogoHero--orJrPs", "app_release", "rot", "pulse", "tail", "phase", "idx", "", "glow"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class LogoMotionKt {
    private static final float[] C_SHAPE = {835.0f, 258.0f, 572.0f, 258.0f, 498.0f, 288.0f, 408.0f, 370.0f, 396.0f, 395.0f, 398.0f, 552.0f, 412.0f, 580.0f, 498.0f, 658.0f, 552.0f, 680.0f, 835.0f, 678.0f, 765.0f, 606.0f, 562.0f, 606.0f, 546.0f, 598.0f, 480.0f, 538.0f, 472.0f, 520.0f, 472.0f, 432.0f, 486.0f, 408.0f, 550.0f, 342.0f, 580.0f, 331.0f, 757.0f, 331.0f, 775.0f, 325.0f};
    private static final float[] LEFT_CHEVRON = {605.0f, 402.0f, 510.0f, 458.0f, 510.0f, 486.0f, 605.0f, 538.0f, 605.0f, 505.0f, 548.0f, 472.0f, 605.0f, 436.0f};
    private static final float[] RIGHT_CHEVRON = {715.0f, 402.0f, 809.0f, 458.0f, 809.0f, 486.0f, 715.0f, 538.0f, 715.0f, 505.0f, 771.0f, 470.0f, 715.0f, 435.0f};
    private static final float[] SLASH = {673.0f, 373.0f, 700.0f, 373.0f, 642.0f, 562.0f, 637.0f, 570.0f, 610.0f, 570.0f};
    private static final float SPAN = 450.0f;
    private static final float X0 = 390.0f;
    private static final float Y0 = 255.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgentWorkingIndicator$lambda$32(boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AgentWorkingIndicator(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClozedLoader__orJrPs$lambda$11(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1504ClozedLoaderorJrPs(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoBadge__orJrPs$lambda$4(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1505LogoBadgeorJrPs(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoHero__orJrPs$lambda$37(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1506LogoHeroorJrPs(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoMark__orJrPs$lambda$2(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1507LogoMarkorJrPs(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoSpinner_8s8adOk$lambda$17(float f, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1508LogoSpinner8s8adOk(f, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TypingDots_ek8zF_U$lambda$21(long j, int i, Composer composer, int i2) {
        m1509TypingDotsek8zF_U(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: poly-vmayBhU$default, reason: not valid java name */
    static /* synthetic */ void m1512polyvmayBhU$default(DrawScope drawScope, float[] fArr, float f, float f2, float f3, float f4, long j, float f5, int i, Object obj) {
        m1511polyvmayBhU(drawScope, fArr, f, f2, f3, f4, j, (i & 64) != 0 ? 1.0f : f5);
    }

    /* renamed from: poly-vmayBhU, reason: not valid java name */
    private static final void m1511polyvmayBhU(DrawScope drawScope, float[] fArr, float f, float f2, float f3, float f4, long j, float f5) {
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo((((fArr[0] - X0) + f4) * f3) + f, ((fArr[1] - Y0) * f3) + f2);
        for (int i = 2; i < fArr.length; i += 2) {
            Path.lineTo((((fArr[i] - X0) + f4) * f3) + f, ((fArr[i + 1] - Y0) * f3) + f2);
        }
        Path.close();
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j, f5, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j, f5, new Stroke(f3 * 7.0f, 0.0f, 0, StrokeJoin.Companion.getRound-LxFBmk8(), (PathEffect) null, 22, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 48, (Object) null);
    }

    /* renamed from: drawMark-9z6LAg8, reason: not valid java name */
    private static final void m1510drawMark9z6LAg8(DrawScope drawScope, float f, long j, long j2, float f2, float f3) {
        float f4 = f / SPAN;
        float intBitsToFloat = (Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) - (SPAN * f4)) / 2.0f;
        float intBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() & 4294967295L)) - (430.0f * f4)) / 2.0f;
        m1512polyvmayBhU$default(drawScope, C_SHAPE, intBitsToFloat, intBitsToFloat2, f4, 0.0f, j, 0.0f, 64, null);
        m1512polyvmayBhU$default(drawScope, LEFT_CHEVRON, intBitsToFloat, intBitsToFloat2, f4, f2 * (-16.0f), j2, 0.0f, 64, null);
        m1512polyvmayBhU$default(drawScope, RIGHT_CHEVRON, intBitsToFloat, intBitsToFloat2, f4, f2 * 16.0f, j2, 0.0f, 64, null);
        m1511polyvmayBhU(drawScope, SLASH, intBitsToFloat, intBitsToFloat2, f4, 0.0f, j2, f3);
    }

    /* renamed from: LogoMark--orJrPs, reason: not valid java name */
    public static final void m1507LogoMarkorJrPs(final float f, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1675928277);
        ComposerKt.sourceInformation(startRestartGroup, "C(LogoMark)P(1:c#ui.unit.Dp)98@4470L11,99@4523L11,100@4575L60,100@4547L88:LogoMotion.kt#qn8u0p");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1675928277, i3, -1, "com.clozed.code.ui.LogoMark (LogoMotion.kt:97)");
            }
            final long j = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            final long j2 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
            Modifier modifier2 = SizeKt.size-3ABfNKs(modifier, f);
            startRestartGroup.startReplaceGroup(1661063835);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):LogoMotion.kt#9igjgp");
            boolean changed = startRestartGroup.changed(j) | startRestartGroup.changed(j2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LogoMark__orJrPs$lambda$1$lambda$0;
                        LogoMark__orJrPs$lambda$1$lambda$0 = LogoMotionKt.LogoMark__orJrPs$lambda$1$lambda$0(j, j2, (DrawScope) obj);
                        return LogoMark__orJrPs$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(modifier2, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LogoMark__orJrPs$lambda$2;
                    LogoMark__orJrPs$lambda$2 = LogoMotionKt.LogoMark__orJrPs$lambda$2(f, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return LogoMark__orJrPs$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoMark__orJrPs$lambda$1$lambda$0(long j, long j2, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        m1510drawMark9z6LAg8(Canvas, Size.getMinDimension-impl(Canvas.getSize-NH-jbRc()), j, j2, 0.0f, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006b  */
    /* renamed from: LogoBadge--orJrPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1505LogoBadgeorJrPs(float r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.LogoMotionKt.m1505LogoBadgeorJrPs(float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* renamed from: ClozedLoader--orJrPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1504ClozedLoaderorJrPs(float r34, androidx.compose.ui.Modifier r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.LogoMotionKt.m1504ClozedLoaderorJrPs(float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClozedLoader__orJrPs$lambda$10$lambda$9(long j, long j2, State state, State state2, State state3, DrawScope Canvas) {
        long j3;
        DrawContext drawContext;
        float f;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f2 = Size.getMinDimension-impl(Canvas.getSize-NH-jbRc());
        float f3 = f2 * 0.05f;
        DrawScope.drawCircle-V9BoPsw$default(Canvas, Brush.Companion.radialGradient-P_Vx-Ks$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j, (ClozedLoader__orJrPs$lambda$6(state) * 0.14f) + 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0L, 0.0f, 0, 14, (Object) null), 0.52f * f2, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        DrawScope.drawCircle-VaOC9Bg$default(Canvas, Color.copy-wmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (f2 / 2.0f) - f3, 0L, 0.0f, new Stroke(f3 * 0.7f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        float ClozedLoader__orJrPs$lambda$5 = ClozedLoader__orJrPs$lambda$5(state2);
        long j4 = Canvas.getCenter-F1C5BW0();
        DrawContext drawContext2 = Canvas.getDrawContext();
        long j5 = drawContext2.getSize-NH-jbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().rotate-Uv8p0NA(ClozedLoader__orJrPs$lambda$5, j4);
            f = f2 - (2.0f * f3);
            try {
            } catch (Throwable th) {
                th = th;
                drawContext = drawContext2;
                j3 = j5;
            }
        } catch (Throwable th2) {
            th = th2;
            j3 = j5;
            drawContext = drawContext2;
        }
        try {
            DrawScope.drawArc-illE91I$default(Canvas, Brush.Companion.sweepGradient-Uv8p0NA$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(j)}), 0L, 2, (Object) null), 0.0f, (ClozedLoader__orJrPs$lambda$7(state3) * 150.0f) + 150.0f, false, Offset.constructor-impl((Float.floatToRawIntBits(f3) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), 0.0f, new Stroke(f3, 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 832, (Object) null);
            drawContext2.getCanvas().restore();
            drawContext2.setSize-uvyYCjk(j5);
            m1510drawMark9z6LAg8(Canvas, ((ClozedLoader__orJrPs$lambda$6(state) * 0.025f) + 0.5f) * f2, j2, j, ClozedLoader__orJrPs$lambda$6(state), (ClozedLoader__orJrPs$lambda$6(state) * 0.55f) + 0.45f);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            drawContext = drawContext2;
            j3 = j5;
            drawContext.getCanvas().restore();
            drawContext.setSize-uvyYCjk(j3);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9  */
    /* renamed from: LogoSpinner-8s8adOk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1508LogoSpinner8s8adOk(float r25, long r26, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.LogoMotionKt.m1508LogoSpinner8s8adOk(float, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoSpinner_8s8adOk$lambda$16$lambda$15(long j, State state, State state2, DrawScope Canvas) {
        long j2;
        DrawContext drawContext;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f = Size.getMinDimension-impl(Canvas.getSize-NH-jbRc());
        float f2 = f * 0.14f;
        DrawScope.drawCircle-VaOC9Bg$default(Canvas, Color.copy-wmQWz5c$default(j, 0.22f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (f / 2.0f) - f2, 0L, 0.0f, new Stroke(f2 * 0.8f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        float LogoSpinner_8s8adOk$lambda$12 = LogoSpinner_8s8adOk$lambda$12(state);
        long j3 = Canvas.getCenter-F1C5BW0();
        DrawContext drawContext2 = Canvas.getDrawContext();
        long j4 = drawContext2.getSize-NH-jbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().rotate-Uv8p0NA(LogoSpinner_8s8adOk$lambda$12, j3);
            float f3 = f - (2.0f * f2);
            try {
                try {
                    DrawScope.drawArc-illE91I$default(Canvas, Brush.Companion.sweepGradient-Uv8p0NA$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(j)}), 0L, 2, (Object) null), 0.0f, 270.0f, false, Offset.constructor-impl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(f3) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L)), 0.0f, new Stroke(f2, 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 832, (Object) null);
                    drawContext2.getCanvas().restore();
                    drawContext2.setSize-uvyYCjk(j4);
                    DrawScope.drawCircle-VaOC9Bg$default(Canvas, Color.copy-wmQWz5c$default(j, LogoSpinner_8s8adOk$lambda$13(state2), 0.0f, 0.0f, 0.0f, 14, (Object) null), f * 0.11f, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    drawContext = drawContext2;
                    j2 = j4;
                    drawContext.getCanvas().restore();
                    drawContext.setSize-uvyYCjk(j2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                drawContext = drawContext2;
                j2 = j4;
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = j4;
            drawContext = drawContext2;
        }
    }

    /* renamed from: TypingDots-ek8zF_U, reason: not valid java name */
    private static final void m1509TypingDotsek8zF_U(final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-941289632);
        ComposerKt.sourceInformation(startRestartGroup, "C(TypingDots)P(0:c#ui.graphics.Color)185@8349L42,186@8411L93,187@8561L287,187@8509L339:LogoMotion.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-941289632, i2, -1, "com.clozed.code.ui.TypingDots (LogoMotion.kt:184)");
            }
            final State animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("dots", startRestartGroup, 6, 0), 0.0f, 3.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(1200, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), "phase", startRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            Modifier modifier = SizeKt.size-VpY3zN4(Modifier.Companion, Dp.m826constructorimpl(26), Dp.m826constructorimpl(8));
            startRestartGroup.startReplaceGroup(541765895);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):LogoMotion.kt#9igjgp");
            boolean changed = startRestartGroup.changed(animateFloat) | ((i2 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TypingDots_ek8zF_U$lambda$20$lambda$19;
                        TypingDots_ek8zF_U$lambda$20$lambda$19 = LogoMotionKt.TypingDots_ek8zF_U$lambda$20$lambda$19(j, animateFloat, (DrawScope) obj);
                        return TypingDots_ek8zF_U$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(modifier, (Function1) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TypingDots_ek8zF_U$lambda$21;
                    TypingDots_ek8zF_U$lambda$21 = LogoMotionKt.TypingDots_ek8zF_U$lambda$21(j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TypingDots_ek8zF_U$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TypingDots_ek8zF_U$lambda$20$lambda$19(long j, State state, DrawScope drawScope) {
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float intBitsToFloat = Float.intBitsToFloat((int) (Canvas.getSize-NH-jbRc() & 4294967295L)) / 2.0f;
        int i = 0;
        while (i < 3) {
            float coerceIn = RangesKt.coerceIn(1.0f - RangesKt.coerceAtMost(Math.abs((TypingDots_ek8zF_U$lambda$18(state) - i) - 0.5f), 1.0f), 0.25f, 1.0f);
            DrawScope.drawCircle-VaOC9Bg$default(Canvas, Color.copy-wmQWz5c$default(j, coerceIn, 0.0f, 0.0f, 0.0f, 14, (Object) null), ((coerceIn * 0.35f) + 0.65f) * intBitsToFloat, Offset.constructor-impl((Float.floatToRawIntBits((r3 * (2.6f * intBitsToFloat)) + intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            i++;
            Canvas = drawScope;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AgentWorkingIndicator(final boolean r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.LogoMotionKt.AgentWorkingIndicator(boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AgentWorkingIndicator$lambda$23(MutableIntState mutableIntState) {
        return ((IntState) mutableIntState).getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(320, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(320, 0, (Easing) null, 6, (Object) null), new Function1() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$26;
                AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$26 = LogoMotionKt.AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$26(((Integer) obj).intValue());
                return Integer.valueOf(AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$26);
            }
        })), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), new Function1() { // from class: com.clozed.code.ui.LogoMotionKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27;
                AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27 = LogoMotionKt.AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(((Integer) obj).intValue());
                return Integer.valueOf(AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$26(int i) {
        return i / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AgentWorkingIndicator$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(int i) {
        return (-i) / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006c  */
    /* renamed from: LogoHero--orJrPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1506LogoHeroorJrPs(float r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.LogoMotionKt.m1506LogoHeroorJrPs(float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoHero__orJrPs$lambda$36$lambda$35$lambda$34(State state, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.drawCircle-V9BoPsw$default(Canvas, Brush.Companion.radialGradient-P_Vx-Ks$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(ColorKt.getBrandBlue(), LogoHero__orJrPs$lambda$33(state), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0L, 0.0f, 0, 14, (Object) null), Size.getMinDimension-impl(Canvas.getSize-NH-jbRc()) / 2.0f, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        return Unit.INSTANCE;
    }

    private static final float ClozedLoader__orJrPs$lambda$5(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float ClozedLoader__orJrPs$lambda$6(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float ClozedLoader__orJrPs$lambda$7(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float LogoSpinner_8s8adOk$lambda$12(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float LogoSpinner_8s8adOk$lambda$13(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float TypingDots_ek8zF_U$lambda$18(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float LogoHero__orJrPs$lambda$33(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}

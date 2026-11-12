package com.clozed.code.ui.theme;

import androidx.compose.material3.Typography;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Type.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Typography", "Landroidx/compose/material3/Typography;", "getTypography", "()Landroidx/compose/material3/Typography;", "Mono", "Landroidx/compose/ui/text/TextStyle;", "getMono", "()Landroidx/compose/ui/text/TextStyle;", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class TypeKt {
    private static final TextStyle Mono;
    private static final Typography Typography;

    static {
        SystemFontFamily systemFontFamily = FontFamily.INSTANCE.getDefault();
        TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(34), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(40), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily2 = FontFamily.INSTANCE.getDefault();
        TextStyle textStyle2 = new TextStyle(0L, TextUnitKt.getSp(28), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(36), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily3 = FontFamily.INSTANCE.getDefault();
        TextStyle textStyle3 = new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily3, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily4 = FontFamily.INSTANCE.getDefault();
        TextStyle textStyle4 = new TextStyle(0L, TextUnitKt.getSp(22), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily4, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646105, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily5 = FontFamily.INSTANCE.getDefault();
        FontWeight medium = FontWeight.INSTANCE.getMedium();
        SystemFontFamily systemFontFamily6 = systemFontFamily5;
        TextStyle textStyle5 = new TextStyle(0L, TextUnitKt.getSp(16), medium, (FontStyle) null, (FontSynthesis) null, systemFontFamily6, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily7 = FontFamily.INSTANCE.getDefault();
        FontWeight medium2 = FontWeight.INSTANCE.getMedium();
        SystemFontFamily systemFontFamily8 = systemFontFamily7;
        TextStyle textStyle6 = new TextStyle(0L, TextUnitKt.getSp(14), medium2, (FontStyle) null, (FontSynthesis) null, systemFontFamily8, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily9 = FontFamily.INSTANCE.getDefault();
        FontWeight normal = FontWeight.INSTANCE.getNormal();
        SystemFontFamily systemFontFamily10 = systemFontFamily9;
        TextStyle textStyle7 = new TextStyle(0L, TextUnitKt.getSp(15), normal, (FontStyle) null, (FontSynthesis) null, systemFontFamily10, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily11 = FontFamily.INSTANCE.getDefault();
        FontWeight normal2 = FontWeight.INSTANCE.getNormal();
        SystemFontFamily systemFontFamily12 = systemFontFamily11;
        TextStyle textStyle8 = new TextStyle(0L, TextUnitKt.getSp(14), normal2, (FontStyle) null, (FontSynthesis) null, systemFontFamily12, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily13 = FontFamily.INSTANCE.getDefault();
        FontWeight normal3 = FontWeight.INSTANCE.getNormal();
        SystemFontFamily systemFontFamily14 = systemFontFamily13;
        TextStyle textStyle9 = new TextStyle(0L, TextUnitKt.getSp(12), normal3, (FontStyle) null, (FontSynthesis) null, systemFontFamily14, (String) null, TextUnitKt.getSp(0.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily15 = FontFamily.INSTANCE.getDefault();
        FontWeight medium3 = FontWeight.INSTANCE.getMedium();
        SystemFontFamily systemFontFamily16 = systemFontFamily15;
        TextStyle textStyle10 = new TextStyle(0L, TextUnitKt.getSp(14), medium3, (FontStyle) null, (FontSynthesis) null, systemFontFamily16, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily17 = FontFamily.INSTANCE.getDefault();
        FontWeight medium4 = FontWeight.INSTANCE.getMedium();
        SystemFontFamily systemFontFamily18 = systemFontFamily17;
        TextStyle textStyle11 = new TextStyle(0L, TextUnitKt.getSp(12), medium4, (FontStyle) null, (FontSynthesis) null, systemFontFamily18, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily19 = FontFamily.INSTANCE.getDefault();
        FontWeight medium5 = FontWeight.INSTANCE.getMedium();
        SystemFontFamily systemFontFamily20 = systemFontFamily19;
        Typography = new Typography((TextStyle) null, (TextStyle) null, textStyle, (TextStyle) null, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, new TextStyle(0L, TextUnitKt.getSp(11), medium5, (FontStyle) null, (FontSynthesis) null, systemFontFamily20, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null), 11, (DefaultConstructorMarker) null);
        Mono = new TextStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646109, (DefaultConstructorMarker) null);
    }

    public static final Typography getTypography() {
        return Typography;
    }

    public static final TextStyle getMono() {
        return Mono;
    }
}

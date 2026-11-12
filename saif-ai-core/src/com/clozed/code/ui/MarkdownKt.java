package com.clozed.code.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.clozed.code.ui.theme.TypeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Markdown.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"copyToClipboard", "", "ctx", "Landroid/content/Context;", "text", "", "splitFences", "", "Lcom/clozed/code/ui/Part;", "src", "inline", "Landroidx/compose/ui/text/AnnotatedString;", "s", "codeBg", "Landroidx/compose/ui/graphics/Color;", "codeFg", "inline-WkMS-hQ", "(Ljava/lang/String;JJ)Landroidx/compose/ui/text/AnnotatedString;", "CodeBlock", "code", "lang", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "MarkdownText", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class MarkdownKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodeBlock$lambda$9(String str, String str2, int i, Composer composer, int i2) {
        CodeBlock(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownText$lambda$11(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MarkdownText(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void copyToClipboard(Context ctx, String text) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(text, "text");
        Object systemService = ctx.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Clozed Code", text));
    }

    private static final List<Part> splitFences(String str) {
        String str2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        loop0: while (true) {
            str2 = "";
            z = false;
            for (String str3 : StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null)) {
                String str4 = str3;
                if (StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) str4).toString(), "```", false, 2, (Object) null)) {
                    if (z) {
                        break;
                    }
                    if (sb.length() > 0) {
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                        arrayList.add(new Part(false, StringsKt.trimEnd(sb2, '\n'), ""));
                    }
                    sb.setLength(0);
                    str2 = StringsKt.trim((CharSequence) StringsKt.removePrefix(StringsKt.trimStart((CharSequence) str4).toString(), (CharSequence) "```")).toString();
                    z = true;
                } else {
                    sb.append(str3).append('\n');
                }
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            arrayList.add(new Part(true, StringsKt.trimEnd(sb3, '\n'), str2));
            sb.setLength(0);
        }
        if (sb.length() > 0) {
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            arrayList.add(new Part(z, StringsKt.trimEnd(sb4, '\n'), str2));
        }
        return arrayList;
    }

    public static final void CodeBlock(final String code, final String lang, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Composer startRestartGroup = composer.startRestartGroup(-6446010);
        ComposerKt.sourceInformation(startRestartGroup, "C(CodeBlock)100@3745L7,101@3780L11,103@3838L992:Markdown.kt#qn8u0p");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(code) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(lang) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6446010, i2, -1, "com.clozed.code.ui.CodeBlock (Markdown.kt:99)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            float f = 12;
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(f));
            Modifier modifier = BackgroundKt.background-bw27NRU$default(BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), shape), Dp.m826constructorimpl(1), colorScheme.getOutlineVariant-0d7_KjU(), shape), colorScheme.getSurfaceContainerLowest-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1643146346, "C110@4035L585,126@4689L21,124@4629L195:Markdown.kt#qn8u0p");
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), colorScheme.getSurfaceContainerHigh-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.m826constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 274503931, "C119@4387L10,117@4273L209,122@4516L30,122@4495L115:Markdown.kt#qn8u0p");
            String str = lang;
            TextKt.Text-Nvy7gAk(StringsKt.isBlank(str) ? "code" : str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.m826constructorimpl(f), 0.0f, 0.0f, 13, (Object) null), colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), startRestartGroup, 48, 0, 131064);
            startRestartGroup.startReplaceGroup(-1515158219);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Markdown.kt#9igjgp");
            int i3 = i2 & 14;
            boolean changedInstance = startRestartGroup.changedInstance(context) | (i3 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.clozed.code.ui.MarkdownKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CodeBlock$lambda$8$lambda$6$lambda$5$lambda$4;
                        CodeBlock$lambda$8$lambda$6$lambda$5$lambda$4 = MarkdownKt.CodeBlock$lambda$8$lambda$6$lambda$5$lambda$4(context, code);
                        return CodeBlock$lambda$8$lambda$6$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$MarkdownKt.INSTANCE.m1417getLambda1$app_release(), startRestartGroup, 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier modifier3 = PaddingKt.padding-3ABfNKs(ScrollKt.horizontalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.m826constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 274985950, "C129@4768L46:Markdown.kt#qn8u0p");
            TextKt.Text-Nvy7gAk(code, (Modifier) null, colorScheme.getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TypeKt.getMono(), startRestartGroup, i3, 12582912, 131066);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.MarkdownKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CodeBlock$lambda$9;
                    CodeBlock$lambda$9 = MarkdownKt.CodeBlock$lambda$9(code, lang, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CodeBlock$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodeBlock$lambda$8$lambda$6$lambda$5$lambda$4(Context context, String str) {
        copyToClipboard(context, str);
        return Unit.INSTANCE;
    }

    public static final void MarkdownText(final String text, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-128957752);
        ComposerKt.sourceInformation(startRestartGroup, "C(MarkdownText)P(1)136@4926L36,137@4990L11,140@5097L2874,140@5078L2893:Markdown.kt#qn8u0p");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            final Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-128957752, i3, -1, "com.clozed.code.ui.MarkdownText (Markdown.kt:135)");
            }
            startRestartGroup.startReplaceGroup(899009927);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Markdown.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = splitFences(text);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable);
            final long j = colorScheme.getSurfaceContainerHighest-0d7_KjU();
            final long j2 = colorScheme.getPrimary-0d7_KjU();
            SelectionContainerKt.SelectionContainer((Modifier) null, ComposableLambdaKt.rememberComposableLambda(-322891925, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.MarkdownKt$MarkdownText$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    String str;
                    int i6;
                    int i7;
                    String str2;
                    long j3;
                    long j4;
                    ColorScheme colorScheme2;
                    String str3;
                    String str4;
                    String str5;
                    long j5;
                    long j6;
                    ColorScheme colorScheme3;
                    String str6;
                    int i8;
                    int i9;
                    AnnotatedString m1517inlineWkMShQ;
                    AnnotatedString m1517inlineWkMShQ2;
                    AnnotatedString m1517inlineWkMShQ3;
                    AnnotatedString m1517inlineWkMShQ4;
                    AnnotatedString m1517inlineWkMShQ5;
                    AnnotatedString m1517inlineWkMShQ6;
                    Composer composer3 = composer2;
                    ComposerKt.sourceInformation(composer3, "C141@5107L2858:Markdown.kt#qn8u0p");
                    int i10 = 2;
                    if ((i5 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-322891925, i5, -1, "com.clozed.code.ui.MarkdownText.<anonymous> (Markdown.kt:141)");
                        }
                        int i11 = 1;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null);
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(6));
                        List<Part> list2 = list;
                        long j7 = j;
                        long j8 = j2;
                        ColorScheme colorScheme4 = colorScheme;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer3, 6);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        ColorScheme colorScheme5 = colorScheme4;
                        boolean z2 = false;
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        String str7 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                        String str8 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -245667614, "C:Markdown.kt#qn8u0p");
                        composer3.startReplaceGroup(-1254850565);
                        String str9 = "";
                        ComposerKt.sourceInformation(composer3, "");
                        for (Part part : list2) {
                            if (part.getCode()) {
                                composer3.startReplaceGroup(836753601);
                                ComposerKt.sourceInformation(composer3, "144@5274L25");
                                MarkdownKt.CodeBlock(part.getText(), part.getLang(), composer3, z2 ? 1 : 0);
                                composer3.endReplaceGroup();
                                str = str9;
                                i6 = i10;
                                i7 = i11;
                                str2 = str8;
                                j3 = j7;
                                j4 = j8;
                                colorScheme2 = colorScheme5;
                                str3 = str7;
                            } else {
                                composer3.startReplaceGroup(836903176);
                                ComposerKt.sourceInformation(composer3, str9);
                                String text2 = part.getText();
                                String[] strArr = new String[i11];
                                strArr[z2 ? 1 : 0] = "\n";
                                Iterator it = StringsKt.split$default((CharSequence) text2, strArr, false, 0, 6, (Object) null).iterator();
                                while (it.hasNext()) {
                                    String obj = StringsKt.trimEnd((CharSequence) it.next()).toString();
                                    String str10 = obj;
                                    String obj2 = StringsKt.trimStart((CharSequence) str10).toString();
                                    if (StringsKt.isBlank(str10)) {
                                        composer3.startReplaceGroup(-1303573511);
                                        ComposerKt.sourceInformation(composer3, "150@5562L26");
                                        BoxKt.Box(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(i10)), composer3, 6);
                                        composer3.endReplaceGroup();
                                        str4 = str9;
                                        i8 = i10;
                                        i9 = i11;
                                        str5 = str8;
                                        j5 = j7;
                                        j6 = j8;
                                        colorScheme3 = colorScheme5;
                                        str6 = str7;
                                    } else {
                                        if (StringsKt.startsWith$default(obj, "### ", z2, i10, (Object) null)) {
                                            composer3.startReplaceGroup(-1755958103);
                                            ComposerKt.sourceInformation(composer3, "152@5676L90");
                                            m1517inlineWkMShQ6 = MarkdownKt.m1517inlineWkMShQ(StringsKt.drop(obj, 4), j7, j8);
                                            colorScheme3 = colorScheme5;
                                            str6 = str7;
                                            str4 = str9;
                                            j5 = j7;
                                            j6 = j8;
                                            str5 = str8;
                                            TextKt.Text-Z58ophY(m1517inlineWkMShQ6, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 1597440, 0, 524206);
                                            composer2.endReplaceGroup();
                                        } else {
                                            str4 = str9;
                                            str5 = str8;
                                            j5 = j7;
                                            j6 = j8;
                                            colorScheme3 = colorScheme5;
                                            str6 = str7;
                                            if (StringsKt.startsWith$default(obj, "## ", false, 2, (Object) null)) {
                                                composer3.startReplaceGroup(-1755782519);
                                                ComposerKt.sourceInformation(composer3, "154@5853L90");
                                                m1517inlineWkMShQ5 = MarkdownKt.m1517inlineWkMShQ(StringsKt.drop(obj, 3), j5, j6);
                                                TextKt.Text-Z58ophY(m1517inlineWkMShQ5, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 1597440, 0, 524206);
                                                composer2.endReplaceGroup();
                                            } else if (StringsKt.startsWith$default(obj, "# ", false, 2, (Object) null)) {
                                                composer3.startReplaceGroup(-1755607927);
                                                ComposerKt.sourceInformation(composer3, "156@6029L90");
                                                m1517inlineWkMShQ4 = MarkdownKt.m1517inlineWkMShQ(StringsKt.drop(obj, 2), j5, j6);
                                                j5 = j5;
                                                j6 = j6;
                                                TextKt.Text-Z58ophY(m1517inlineWkMShQ4, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(19), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 1597440, 0, 524206);
                                                composer2.endReplaceGroup();
                                            } else if (StringsKt.startsWith$default(obj2, "- ", false, 2, (Object) null) || StringsKt.startsWith$default(obj2, "* ", false, 2, (Object) null)) {
                                                i8 = 2;
                                                i9 = 1;
                                                composer3.startReplaceGroup(-1755426205);
                                                ComposerKt.sourceInformation(composer3, "159@6312L214");
                                                int length = obj.length() - obj2.length();
                                                m1517inlineWkMShQ = MarkdownKt.m1517inlineWkMShQ("•  " + StringsKt.drop(obj2, 2), j5, j6);
                                                j5 = j5;
                                                j6 = j6;
                                                TextKt.Text-Z58ophY(m1517inlineWkMShQ, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.m826constructorimpl(length * 4), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 0, 0, 524284);
                                                composer2.endReplaceGroup();
                                            } else if (StringsKt.startsWith$default(obj, "> ", false, 2, (Object) null)) {
                                                composer3.startReplaceGroup(-1303538166);
                                                ComposerKt.sourceInformation(composer3, "165@6642L811");
                                                Modifier height = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                                                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer3, 0);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str6);
                                                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, height);
                                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str5);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer composer5 = Updater.constructor-impl(composer3);
                                                Updater.set-impl(composer5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode2))) {
                                                    composer5.updateRememberedValue(Integer.valueOf(hashCode2));
                                                    composer5.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                                                }
                                                Updater.set-impl(composer5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                                RowScope rowScope = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 1015280557, "C166@6755L353,173@7145L274:Markdown.kt#qn8u0p");
                                                BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(3)), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.m826constructorimpl(2))), colorScheme3.getOutline-0d7_KjU(), (Shape) null, 2, (Object) null), composer3, 0);
                                                m1517inlineWkMShQ3 = MarkdownKt.m1517inlineWkMShQ(StringsKt.drop(obj, 2), j5, j6);
                                                str6 = str6;
                                                j5 = j5;
                                                j6 = j6;
                                                str5 = str5;
                                                TextKt.Text-Z58ophY(m1517inlineWkMShQ3, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.m826constructorimpl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme3.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 48, 0, 524280);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceGroup();
                                                i8 = 2;
                                                i9 = 1;
                                            } else if (StringsKt.startsWith$default(obj, "---", false, 2, (Object) null)) {
                                                composer3.startReplaceGroup(-1303509977);
                                                ComposerKt.sourceInformation(composer3, "180@7540L264");
                                                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m826constructorimpl(1)), colorScheme3.getOutlineVariant-0d7_KjU(), (Shape) null, 2, (Object) null), composer3, 0);
                                                composer3.endReplaceGroup();
                                                i8 = 2;
                                                i9 = 1;
                                                j5 = j5;
                                                j6 = j6;
                                            } else {
                                                composer3.startReplaceGroup(-1303500575);
                                                ComposerKt.sourceInformation(composer3, "186@7841L34");
                                                m1517inlineWkMShQ2 = MarkdownKt.m1517inlineWkMShQ(obj, j5, j6);
                                                i9 = 1;
                                                j5 = j5;
                                                j6 = j6;
                                                i8 = 2;
                                                TextKt.Text-Z58ophY(m1517inlineWkMShQ2, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer2, 0, 0, 524286);
                                                composer2.endReplaceGroup();
                                            }
                                        }
                                        i8 = 2;
                                        i9 = 1;
                                    }
                                    composer3 = composer2;
                                    i10 = i8;
                                    str8 = str5;
                                    colorScheme5 = colorScheme3;
                                    str7 = str6;
                                    str9 = str4;
                                    j7 = j5;
                                    j8 = j6;
                                    i11 = i9;
                                    z2 = false;
                                }
                                str = str9;
                                i6 = i10;
                                i7 = i11;
                                str2 = str8;
                                j3 = j7;
                                j4 = j8;
                                colorScheme2 = colorScheme5;
                                str3 = str7;
                                composer2.endReplaceGroup();
                            }
                            composer3 = composer2;
                            i10 = i6;
                            str8 = str2;
                            colorScheme5 = colorScheme2;
                            str7 = str3;
                            str9 = str;
                            j7 = j3;
                            j8 = j4;
                            i11 = i7;
                            z2 = false;
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.clozed.code.ui.MarkdownKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MarkdownText$lambda$11;
                    MarkdownText$lambda$11 = MarkdownKt.MarkdownText$lambda$11(text, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return MarkdownText$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inline-WkMS-hQ, reason: not valid java name */
    public static final AnnotatedString m1517inlineWkMShQ(String str, long j, long j2) {
        int i;
        int indexOf$default;
        int pushStyle;
        int i2;
        int indexOf$default2;
        int i3 = 0;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        while (i3 < str.length()) {
            if (!StringsKt.startsWith$default(str, "**", i3, false, 4, (Object) null) || (indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, "**", (i2 = i3 + 2), false, 4, (Object) null)) <= i3 + 1) {
                if (str.charAt(i3) != '`' || (indexOf$default = StringsKt.indexOf$default((CharSequence) str, '`', (i = i3 + 1), false, 4, (Object) null)) <= i3) {
                    builder.append(str.charAt(i3));
                    i3++;
                } else {
                    pushStyle = builder.pushStyle(new SpanStyle(j2, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, j, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63452, (DefaultConstructorMarker) null));
                    try {
                        String substring = str.substring(i, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        builder.append(substring);
                        Unit unit = Unit.INSTANCE;
                        builder.pop(pushStyle);
                        i3 = indexOf$default + 1;
                    } finally {
                    }
                }
            } else {
                pushStyle = builder.pushStyle(new SpanStyle(0L, 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null));
                try {
                    String substring2 = str.substring(i2, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    builder.append(substring2);
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(pushStyle);
                    i3 = indexOf$default2 + 2;
                } finally {
                }
            }
        }
        return builder.toAnnotatedString();
    }
}

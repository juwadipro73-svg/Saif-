package com.clozed.code.ui;

import android.text.format.DateUtils;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MoreVertKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import com.clozed.code.data.SessionInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionsScreens.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SessionsScreensKt$SessionRow$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ boolean $busy;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<Boolean> $menu$delegate;
    final /* synthetic */ Function0<Unit> $onDelete;
    final /* synthetic */ Function0<Unit> $onRename;
    final /* synthetic */ SessionInfo $s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionsScreensKt$SessionRow$1(SessionInfo sessionInfo, boolean z, ColorScheme colorScheme, MutableState<Boolean> mutableState, Function0<Unit> function0, Function0<Unit> function02) {
        this.$s = sessionInfo;
        this.$busy = z;
        this.$cs = colorScheme;
        this.$menu$delegate = mutableState;
        this.$onRename = function0;
        this.$onDelete = function02;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope Card, Composer composer, int i) {
        String str;
        final MutableState<Boolean> mutableState;
        boolean SessionRow$lambda$77;
        String trimEnd;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C426@19787L1879:SessionsScreens.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-608926094, i, -1, "com.clozed.code.ui.SessionRow.<anonymous> (SessionsScreens.kt:426)");
        }
        float f = 12;
        Modifier modifier = PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.m826constructorimpl(16), Dp.m826constructorimpl(f), Dp.m826constructorimpl(4), Dp.m826constructorimpl(f));
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(14));
        SessionInfo sessionInfo = this.$s;
        boolean z = this.$busy;
        final ColorScheme colorScheme = this.$cs;
        MutableState<Boolean> mutableState2 = this.$menu$delegate;
        Function0<Unit> function0 = this.$onRename;
        Function0<Unit> function02 = this.$onDelete;
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0 constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composer2 = Updater.constructor-impl(composer);
        Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
            composer2.updateRememberedValue(Integer.valueOf(hashCode));
            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -80102275, "C431@20027L21,432@20061L844,445@20959L697:SessionsScreens.kt#qn8u0p");
        ComponentsKt.m1340LetterAvatarrAjV9yQ(sessionInfo.getTitle(), 0.0f, composer, 0, 2);
        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(2));
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, weight$default);
        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composer3 = Updater.constructor-impl(composer);
        Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
        }
        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1214768323, "C433@20241L10,433@20157L129,440@20755L10,438@20598L293:SessionsScreens.kt#qn8u0p");
        TextKt.Text-Nvy7gAk(sessionInfo.getTitle(), (Modifier) null, colorScheme.getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 24960, 110586);
        String directory = sessionInfo.getDirectory();
        if (directory == null || (trimEnd = StringsKt.trimEnd(directory, '/')) == null || (str = StringsKt.substringAfterLast$default(trimEnd, '/', (String) null, 2, (Object) null)) == null) {
            str = "";
        }
        String obj = sessionInfo.getUpdated() > 0 ? DateUtils.getRelativeTimeSpanString(sessionInfo.getUpdated(), System.currentTimeMillis(), 60000L).toString() : "";
        String[] strArr = new String[3];
        strArr[0] = str;
        String model = sessionInfo.getModel();
        strArr[1] = model != null ? model : "";
        strArr[2] = obj;
        List listOf = CollectionsKt.listOf((Object[]) strArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList.add(obj2);
            }
        }
        TextKt.Text-Nvy7gAk(CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null), (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 24960, 110586);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-1665125019);
        ComposerKt.sourceInformation(composer, "444@20928L18");
        if (z) {
            LogoMotionKt.m1508LogoSpinner8s8adOk(Dp.m826constructorimpl(22), 0L, null, composer, 6, 6);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifier2);
        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composer4 = Updater.constructor-impl(composer);
        Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
            composer4.updateRememberedValue(Integer.valueOf(hashCode3));
            composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
        }
        Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1213953178, "C446@21002L15,446@21019L68,446@20981L106,447@21153L16,447@21171L471,447@21104L538:SessionsScreens.kt#qn8u0p");
        composer.startReplaceGroup(1069218903);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            mutableState = mutableState2;
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionRow$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6$lambda$3$lambda$2;
                    invoke$lambda$7$lambda$6$lambda$3$lambda$2 = SessionsScreensKt$SessionRow$1.invoke$lambda$7$lambda$6$lambda$3$lambda$2(mutableState);
                    return invoke$lambda$7$lambda$6$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        } else {
            mutableState = mutableState2;
        }
        composer.endReplaceGroup();
        IconButtonKt.IconButton((Function0) rememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1660952938, true, new Function2<Composer, Integer, Unit>() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionRow$1$1$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                invoke(composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer5, int i2) {
                ComposerKt.sourceInformation(composer5, "C446@21021L64:SessionsScreens.kt#qn8u0p");
                if ((i2 & 3) == 2 && composer5.getSkipping()) {
                    composer5.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1660952938, i2, -1, "com.clozed.code.ui.SessionRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SessionsScreens.kt:446)");
                }
                IconKt.Icon-ww6aTOc(MoreVertKt.getMoreVert(Icons.INSTANCE.getDefault()), "More", (Modifier) null, colorScheme.getOnSurfaceVariant-0d7_KjU(), composer5, 48, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 1572870, 62);
        SessionRow$lambda$77 = SessionsScreensKt.SessionRow$lambda$77(mutableState);
        composer.startReplaceGroup(1069223736);
        ComposerKt.sourceInformation(composer, "CC(remember):SessionsScreens.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.SessionsScreensKt$SessionRow$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6$lambda$5$lambda$4;
                    invoke$lambda$7$lambda$6$lambda$5$lambda$4 = SessionsScreensKt$SessionRow$1.invoke$lambda$7$lambda$6$lambda$5$lambda$4(mutableState);
                    return invoke$lambda$7$lambda$6$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        AndroidMenu_androidKt.DropdownMenu-IlH_yew(SessionRow$lambda$77, (Function0) rememberedValue2, (Modifier) null, 0L, (ScrollState) null, (PopupProperties) null, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1033255357, true, new SessionsScreensKt$SessionRow$1$1$2$4(function0, function02, mutableState), composer, 54), composer, 48, 48, 2044);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6$lambda$3$lambda$2(MutableState mutableState) {
        SessionsScreensKt.SessionRow$lambda$78(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6$lambda$5$lambda$4(MutableState mutableState) {
        SessionsScreensKt.SessionRow$lambda$78(mutableState, false);
        return Unit.INSTANCE;
    }
}

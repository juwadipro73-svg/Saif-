package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.LockKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
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
import com.clozed.code.data.PermissionReq;
import com.clozed.code.ui.theme.TypeKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
final class ChatScreenKt$PermissionCard$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function1<String, Unit> $onReply;
    final /* synthetic */ PermissionReq $req;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatScreenKt$PermissionCard$1(PermissionReq permissionReq, Function1<? super String, Unit> function1) {
        this.$req = permissionReq;
        this.$onReply = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C527@25282L1336:ChatScreen.kt#qn8u0p");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(829862232, i, -1, "com.clozed.code.ui.PermissionCard.<anonymous> (ChatScreen.kt:527)");
        }
        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(16));
        float f = 10;
        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
        PermissionReq permissionReq = this.$req;
        final Function1<String, Unit> function1 = this.$onReply;
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 6);
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
        Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
            composer2.updateRememberedValue(Integer.valueOf(hashCode));
            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -435401838, "C528@25379L291,536@25936L672:ChatScreen.kt#qn8u0p");
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(f));
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier2);
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
        Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
        }
        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 197319142, "C529@25502L52,530@25634L10,530@25571L85:ChatScreen.kt#qn8u0p");
        IconKt.Icon-ww6aTOc(LockKt.getLock(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m826constructorimpl(20)), 0L, composer, 432, 8);
        TextKt.Text-Nvy7gAk("Permission needed: " + permissionReq.getAction(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 0, 0, 131070);
        Composer composer4 = composer;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerEnd(composer4);
        composer4.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerEnd(composer4);
        composer4.startReplaceGroup(1787078691);
        ComposerKt.sourceInformation(composer4, "532@25757L10,532@25717L61");
        String message = permissionReq.getMessage();
        if (message != null && !StringsKt.isBlank(message)) {
            TextKt.Text-Nvy7gAk(permissionReq.getMessage(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131070);
            composer4 = composer;
        }
        composer4.endReplaceGroup();
        composer4.startReplaceGroup(1787082866);
        ComposerKt.sourceInformation(composer4, "*534@25839L70");
        Iterator it = CollectionsKt.take(permissionReq.getResources(), 6).iterator();
        while (it.hasNext()) {
            TextKt.Text-Nvy7gAk((String) it.next(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m750getEllipsisgIe3tQ8(), false, 2, 0, (Function1) null, TypeKt.getMono(), composer, 0, 12607872, 110590);
            composer4 = composer;
        }
        composer4.endReplaceGroup();
        Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.m826constructorimpl(8));
        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier3 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontal2, Alignment.Companion.getTop(), composer4, 6);
        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, modifier3);
        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer4.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer4.startReusableNode();
        if (composer4.getInserting()) {
            composer4.createNode(constructor3);
        } else {
            composer4.useNode();
        }
        Composer composer5 = Updater.constructor-impl(composer4);
        Updater.set-impl(composer5, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode3))) {
            composer5.updateRememberedValue(Integer.valueOf(hashCode3));
            composer5.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
        }
        Updater.set-impl(composer5, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer4, 197836408, "C537@26027L19,537@26010L130,538@26185L21,538@26157L139,541@26520L11,541@26474L64,540@26355L21,539@26313L281:ChatScreen.kt#qn8u0p");
        composer4.startReplaceGroup(-547807530);
        ComposerKt.sourceInformation(composer4, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed = composer4.changed(function1);
        Object rememberedValue = composer4.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$PermissionCard$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8$lambda$3$lambda$2;
                    invoke$lambda$9$lambda$8$lambda$3$lambda$2 = ChatScreenKt$PermissionCard$1.invoke$lambda$9$lambda$8$lambda$3$lambda$2(Function1.this);
                    return invoke$lambda$9$lambda$8$lambda$3$lambda$2;
                }
            };
            composer4.updateRememberedValue(rememberedValue);
        }
        composer4.endReplaceGroup();
        float f2 = 14;
        ButtonKt.Button((Function0) rememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-YgX7TsA$default(Dp.m826constructorimpl(f2), 0.0f, 2, (Object) null), (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1403getLambda12$app_release(), composer4, 817889280, 382);
        composer4.startReplaceGroup(-547802472);
        ComposerKt.sourceInformation(composer4, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed2 = composer4.changed(function1);
        Object rememberedValue2 = composer4.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$PermissionCard$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8$lambda$5$lambda$4;
                    invoke$lambda$9$lambda$8$lambda$5$lambda$4 = ChatScreenKt$PermissionCard$1.invoke$lambda$9$lambda$8$lambda$5$lambda$4(Function1.this);
                    return invoke$lambda$9$lambda$8$lambda$5$lambda$4;
                }
            };
            composer4.updateRememberedValue(rememberedValue2);
        }
        composer4.endReplaceGroup();
        ButtonKt.FilledTonalButton((Function0) rememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-YgX7TsA$default(Dp.m826constructorimpl(f2), 0.0f, 2, (Object) null), (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1404getLambda13$app_release(), composer4, 817889280, 382);
        PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(Dp.m826constructorimpl(12), 0.0f, 2, (Object) null);
        ButtonColors buttonColors = ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 13);
        composer.startReplaceGroup(-547797032);
        ComposerKt.sourceInformation(composer, "CC(remember):ChatScreen.kt#9igjgp");
        boolean changed3 = composer.changed(function1);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.clozed.code.ui.ChatScreenKt$PermissionCard$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8$lambda$7$lambda$6;
                    invoke$lambda$9$lambda$8$lambda$7$lambda$6 = ChatScreenKt$PermissionCard$1.invoke$lambda$9$lambda$8$lambda$7$lambda$6(Function1.this);
                    return invoke$lambda$9$lambda$8$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue3, (Modifier) null, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableSingletons$ChatScreenKt.INSTANCE.m1405getLambda14$app_release(), composer, 817889280, 366);
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
    public static final Unit invoke$lambda$9$lambda$8$lambda$3$lambda$2(Function1 function1) {
        function1.invoke("once");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$5$lambda$4(Function1 function1) {
        function1.invoke("always");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$7$lambda$6(Function1 function1) {
        function1.invoke("reject");
        return Unit.INSTANCE;
    }
}

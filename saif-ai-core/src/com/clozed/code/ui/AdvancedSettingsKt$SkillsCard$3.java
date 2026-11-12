package com.clozed.code.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.Skills;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$SkillsCard$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $body$delegate;
    final /* synthetic */ MutableState<String> $desc$delegate;
    final /* synthetic */ File $dir;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ MutableState<Integer> $tick$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$SkillsCard$3(File file, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Integer> mutableState4, MutableState<Boolean> mutableState5) {
        this.$dir = file;
        this.$name$delegate = mutableState;
        this.$desc$delegate = mutableState2;
        this.$body$delegate = mutableState3;
        this.$tick$delegate = mutableState4;
        this.$showAdd$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(File file, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        String SkillsCard$lambda$80;
        String SkillsCard$lambda$83;
        String SkillsCard$lambda$86;
        int SkillsCard$lambda$73;
        Skills skills = Skills.INSTANCE;
        Intrinsics.checkNotNull(file);
        SkillsCard$lambda$80 = AdvancedSettingsKt.SkillsCard$lambda$80(mutableState);
        SkillsCard$lambda$83 = AdvancedSettingsKt.SkillsCard$lambda$83(mutableState2);
        SkillsCard$lambda$86 = AdvancedSettingsKt.SkillsCard$lambda$86(mutableState3);
        skills.save(file, SkillsCard$lambda$80, SkillsCard$lambda$83, SkillsCard$lambda$86);
        SkillsCard$lambda$73 = AdvancedSettingsKt.SkillsCard$lambda$73(mutableState4);
        AdvancedSettingsKt.SkillsCard$lambda$74(mutableState4, SkillsCard$lambda$73 + 1);
        AdvancedSettingsKt.SkillsCard$lambda$78(mutableState5, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "C368@19266L63,368@19174L173:AdvancedSettings.kt#qn8u0p"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r15 & 3
            r1 = 2
            if (r0 != r1) goto L15
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L11
            goto L15
        L11:
            r14.skipToGroupEnd()
            return
        L15:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L24
            r0 = -1
            java.lang.String r1 = "com.clozed.code.ui.SkillsCard.<anonymous> (AdvancedSettings.kt:368)"
            r2 = 726703979(0x2b509f6b, float:7.411768E-13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L24:
            androidx.compose.runtime.MutableState<java.lang.String> r15 = r13.$name$delegate
            java.lang.String r15 = com.clozed.code.ui.AdvancedSettingsKt.access$SkillsCard$lambda$80(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)
            if (r15 != 0) goto L50
            androidx.compose.runtime.MutableState<java.lang.String> r15 = r13.$desc$delegate
            java.lang.String r15 = com.clozed.code.ui.AdvancedSettingsKt.access$SkillsCard$lambda$83(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)
            if (r15 != 0) goto L50
            androidx.compose.runtime.MutableState<java.lang.String> r15 = r13.$body$delegate
            java.lang.String r15 = com.clozed.code.ui.AdvancedSettingsKt.access$SkillsCard$lambda$86(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)
            if (r15 != 0) goto L50
            r15 = 1
            goto L51
        L50:
            r15 = 0
        L51:
            r2 = r15
            r15 = -1222278505(0xffffffffb7258297, float:-9.865172E-6)
            r14.startReplaceGroup(r15)
            java.lang.String r15 = "CC(remember):AdvancedSettings.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            java.io.File r15 = r13.$dir
            boolean r15 = r14.changedInstance(r15)
            java.io.File r4 = r13.$dir
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r13.$name$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r13.$desc$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r7 = r13.$body$delegate
            androidx.compose.runtime.MutableState<java.lang.Integer> r8 = r13.$tick$delegate
            androidx.compose.runtime.MutableState<java.lang.Boolean> r9 = r13.$showAdd$delegate
            java.lang.Object r0 = r14.rememberedValue()
            if (r15 != 0) goto L7d
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L86
        L7d:
            com.clozed.code.ui.AdvancedSettingsKt$SkillsCard$3$$ExternalSyntheticLambda0 r3 = new com.clozed.code.ui.AdvancedSettingsKt$SkillsCard$3$$ExternalSyntheticLambda0
            r3.<init>()
            r14.updateRememberedValue(r3)
            r0 = r3
        L86:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.endReplaceGroup()
            com.clozed.code.ui.ComposableSingletons$AdvancedSettingsKt r15 = com.clozed.code.ui.ComposableSingletons$AdvancedSettingsKt.INSTANCE
            kotlin.jvm.functions.Function3 r9 = r15.m1369getLambda35$app_release()
            r11 = 805306368(0x30000000, float:4.656613E-10)
            r12 = 506(0x1fa, float:7.09E-43)
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = r14
            androidx.compose.material3.ButtonKt.TextButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto La9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.AdvancedSettingsKt$SkillsCard$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

package com.clozed.code.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.Commands;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$CommandsCard$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $body$delegate;
    final /* synthetic */ MutableState<String> $desc$delegate;
    final /* synthetic */ File $dir;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ MutableState<Integer> $tick$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$CommandsCard$3(File file, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Integer> mutableState4, MutableState<Boolean> mutableState5) {
        this.$dir = file;
        this.$name$delegate = mutableState;
        this.$body$delegate = mutableState2;
        this.$desc$delegate = mutableState3;
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
        String CommandsCard$lambda$61;
        String CommandsCard$lambda$64;
        String CommandsCard$lambda$67;
        int CommandsCard$lambda$54;
        Commands commands = Commands.INSTANCE;
        Intrinsics.checkNotNull(file);
        CommandsCard$lambda$61 = AdvancedSettingsKt.CommandsCard$lambda$61(mutableState);
        CommandsCard$lambda$64 = AdvancedSettingsKt.CommandsCard$lambda$64(mutableState2);
        CommandsCard$lambda$67 = AdvancedSettingsKt.CommandsCard$lambda$67(mutableState3);
        commands.save(file, CommandsCard$lambda$61, CommandsCard$lambda$64, CommandsCard$lambda$67);
        CommandsCard$lambda$54 = AdvancedSettingsKt.CommandsCard$lambda$54(mutableState4);
        AdvancedSettingsKt.CommandsCard$lambda$55(mutableState4, CommandsCard$lambda$54 + 1);
        AdvancedSettingsKt.CommandsCard$lambda$59(mutableState5, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "C319@16643L65,319@16572L154:AdvancedSettings.kt#qn8u0p"
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
            java.lang.String r1 = "com.clozed.code.ui.CommandsCard.<anonymous> (AdvancedSettings.kt:319)"
            r2 = -1919171727(0xffffffff8d9bc371, float:-9.599663E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L24:
            androidx.compose.runtime.MutableState<java.lang.String> r15 = r13.$name$delegate
            java.lang.String r15 = com.clozed.code.ui.AdvancedSettingsKt.access$CommandsCard$lambda$61(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)
            if (r15 != 0) goto L42
            androidx.compose.runtime.MutableState<java.lang.String> r15 = r13.$body$delegate
            java.lang.String r15 = com.clozed.code.ui.AdvancedSettingsKt.access$CommandsCard$lambda$67(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)
            if (r15 != 0) goto L42
            r15 = 1
            goto L43
        L42:
            r15 = 0
        L43:
            r2 = r15
            r15 = 842158527(0x323251bf, float:1.03795506E-8)
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
            if (r15 != 0) goto L6f
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L78
        L6f:
            com.clozed.code.ui.AdvancedSettingsKt$CommandsCard$3$$ExternalSyntheticLambda0 r3 = new com.clozed.code.ui.AdvancedSettingsKt$CommandsCard$3$$ExternalSyntheticLambda0
            r3.<init>()
            r14.updateRememberedValue(r3)
            r0 = r3
        L78:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.endReplaceGroup()
            com.clozed.code.ui.ComposableSingletons$AdvancedSettingsKt r15 = com.clozed.code.ui.ComposableSingletons$AdvancedSettingsKt.INSTANCE
            kotlin.jvm.functions.Function3 r9 = r15.m1359getLambda26$app_release()
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
            if (r14 == 0) goto L9b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.AdvancedSettingsKt$CommandsCard$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

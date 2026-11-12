package com.clozed.code.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.CatProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$CustomProviderDialog$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $anthropic$delegate;
    final /* synthetic */ MutableState<String> $apiUrl$delegate;
    final /* synthetic */ MutableState<String> $ckey$delegate;
    final /* synthetic */ CatProvider $existing;
    final /* synthetic */ MutableState<String> $models$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ Function5<String, Boolean, String, String, String, Unit> $onSave;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$CustomProviderDialog$1(Function5<? super String, ? super Boolean, ? super String, ? super String, ? super String, Unit> function5, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, MutableState<String> mutableState5, CatProvider catProvider) {
        this.$onSave = function5;
        this.$name$delegate = mutableState;
        this.$apiUrl$delegate = mutableState2;
        this.$models$delegate = mutableState3;
        this.$anthropic$delegate = mutableState4;
        this.$ckey$delegate = mutableState5;
        this.$existing = catProvider;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            r0 = r15
            java.lang.String r1 = "C576@27739L49,577@27804L49,574@27610L243:SettingsScreen.kt#qn8u0p"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r0 & 3
            r2 = 2
            if (r1 != r2) goto L16
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L12
            goto L16
        L12:
            r14.skipToGroupEnd()
            return
        L16:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L25
            r1 = -1
            java.lang.String r2 = "com.clozed.code.ui.CustomProviderDialog.<anonymous> (SettingsScreen.kt:574)"
            r3 = 1510719731(0x5a0bc0f3, float:9.834293E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r15, r1, r2)
        L25:
            androidx.compose.runtime.MutableState<java.lang.String> r0 = r13.$name$delegate
            java.lang.String r0 = com.clozed.code.ui.SettingsScreenKt.access$CustomProviderDialog$lambda$87(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r1 = 1
            if (r0 != 0) goto L52
            androidx.compose.runtime.MutableState<java.lang.String> r0 = r13.$apiUrl$delegate
            java.lang.String r0 = com.clozed.code.ui.SettingsScreenKt.access$CustomProviderDialog$lambda$90(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L52
            androidx.compose.runtime.MutableState<java.lang.String> r0 = r13.$models$delegate
            java.lang.String r0 = com.clozed.code.ui.SettingsScreenKt.access$CustomProviderDialog$lambda$94(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L52
            r2 = r1
            goto L54
        L52:
            r0 = 0
            r2 = r0
        L54:
            r0 = -1381743391(0xffffffffada444e1, float:-1.867523E-11)
            r14.startReplaceGroup(r0)
            java.lang.String r0 = "CC(remember):SettingsScreen.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            kotlin.jvm.functions.Function5<java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, kotlin.Unit> r0 = r13.$onSave
            boolean r0 = r14.changed(r0)
            kotlin.jvm.functions.Function5<java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, kotlin.Unit> r4 = r13.$onSave
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r13.$name$delegate
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r13.$anthropic$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r7 = r13.$apiUrl$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r8 = r13.$models$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r9 = r13.$ckey$delegate
            java.lang.Object r3 = r14.rememberedValue()
            if (r0 != 0) goto L7f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L87
        L7f:
            com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$1$$ExternalSyntheticLambda0 r3 = new com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$1$$ExternalSyntheticLambda0
            r3.<init>()
            r14.updateRememberedValue(r3)
        L87:
            r0 = r3
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.endReplaceGroup()
            com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$1$2 r3 = new com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$1$2
            com.clozed.code.engine.CatProvider r4 = r13.$existing
            r3.<init>()
            r4 = 54
            r5 = -779016784(0xffffffffd19125b0, float:-7.792532E10)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r1, r3, r14, r4)
            r9 = r1
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
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
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto Lb8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$1.invoke(androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function5 function5, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        String CustomProviderDialog$lambda$87;
        boolean CustomProviderDialog$lambda$100;
        String CustomProviderDialog$lambda$90;
        String CustomProviderDialog$lambda$94;
        String CustomProviderDialog$lambda$97;
        CustomProviderDialog$lambda$87 = SettingsScreenKt.CustomProviderDialog$lambda$87(mutableState);
        CustomProviderDialog$lambda$100 = SettingsScreenKt.CustomProviderDialog$lambda$100(mutableState2);
        Boolean valueOf = Boolean.valueOf(CustomProviderDialog$lambda$100);
        CustomProviderDialog$lambda$90 = SettingsScreenKt.CustomProviderDialog$lambda$90(mutableState3);
        CustomProviderDialog$lambda$94 = SettingsScreenKt.CustomProviderDialog$lambda$94(mutableState4);
        CustomProviderDialog$lambda$97 = SettingsScreenKt.CustomProviderDialog$lambda$97(mutableState5);
        function5.invoke(CustomProviderDialog$lambda$87, valueOf, CustomProviderDialog$lambda$90, CustomProviderDialog$lambda$94, CustomProviderDialog$lambda$97);
        return Unit.INSTANCE;
    }
}

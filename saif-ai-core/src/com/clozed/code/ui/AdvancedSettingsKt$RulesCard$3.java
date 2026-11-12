package com.clozed.code.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.clozed.code.engine.PermRule;
import com.clozed.code.engine.ProviderStore;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$RulesCard$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $action$delegate;
    final /* synthetic */ MutableState<String> $decision$delegate;
    final /* synthetic */ MutableState<String> $pattern$delegate;
    final /* synthetic */ MutableState<List<PermRule>> $rules$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ ProviderStore $store;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$RulesCard$3(ProviderStore providerStore, MutableState<String> mutableState, MutableState<List<PermRule>> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5) {
        this.$store = providerStore;
        this.$pattern$delegate = mutableState;
        this.$rules$delegate = mutableState2;
        this.$action$delegate = mutableState3;
        this.$decision$delegate = mutableState4;
        this.$showAdd$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, ProviderStore providerStore, MutableState mutableState5) {
        List RulesCard$lambda$35;
        String RulesCard$lambda$42;
        String RulesCard$lambda$45;
        String RulesCard$lambda$48;
        RulesCard$lambda$35 = AdvancedSettingsKt.RulesCard$lambda$35(mutableState);
        RulesCard$lambda$42 = AdvancedSettingsKt.RulesCard$lambda$42(mutableState2);
        RulesCard$lambda$45 = AdvancedSettingsKt.RulesCard$lambda$45(mutableState3);
        String obj = StringsKt.trim((CharSequence) RulesCard$lambda$45).toString();
        RulesCard$lambda$48 = AdvancedSettingsKt.RulesCard$lambda$48(mutableState4);
        AdvancedSettingsKt.RulesCard$save$40(providerStore, mutableState, CollectionsKt.plus((Collection<? extends PermRule>) RulesCard$lambda$35, new PermRule(RulesCard$lambda$42, obj, RulesCard$lambda$48)));
        AdvancedSettingsKt.RulesCard$lambda$39(mutableState5, false);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String RulesCard$lambda$45;
        ComposerKt.sourceInformation(composer, "C270@13969L77,270@13916L147:AdvancedSettings.kt#qn8u0p");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2036939111, i, -1, "com.clozed.code.ui.RulesCard.<anonymous> (AdvancedSettings.kt:270)");
        }
        RulesCard$lambda$45 = AdvancedSettingsKt.RulesCard$lambda$45(this.$pattern$delegate);
        boolean z = !StringsKt.isBlank(RulesCard$lambda$45);
        composer.startReplaceGroup(-1727103284);
        ComposerKt.sourceInformation(composer, "CC(remember):AdvancedSettings.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$store);
        final MutableState<List<PermRule>> mutableState = this.$rules$delegate;
        final MutableState<String> mutableState2 = this.$action$delegate;
        final MutableState<String> mutableState3 = this.$pattern$delegate;
        final MutableState<String> mutableState4 = this.$decision$delegate;
        final ProviderStore providerStore = this.$store;
        final MutableState<Boolean> mutableState5 = this.$showAdd$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            Function0 function0 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$RulesCard$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = AdvancedSettingsKt$RulesCard$3.invoke$lambda$1$lambda$0(mutableState, mutableState2, mutableState3, mutableState4, providerStore, mutableState5);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(function0);
            rememberedValue = function0;
        }
        composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, z, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1353getLambda20$app_release(), composer, 805306368, 506);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

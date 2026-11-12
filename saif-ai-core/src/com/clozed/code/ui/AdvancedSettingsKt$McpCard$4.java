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
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.McpServer;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ MutableState<String> $headers$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<List<McpServer>> $servers$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ ProviderStore $store;
    final /* synthetic */ MutableState<String> $url$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$McpCard$4(ProviderStore providerStore, LocalBackend localBackend, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<List<McpServer>> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5) {
        this.$store = providerStore;
        this.$engine = localBackend;
        this.$name$delegate = mutableState;
        this.$url$delegate = mutableState2;
        this.$servers$delegate = mutableState3;
        this.$headers$delegate = mutableState4;
        this.$showAdd$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String McpCard$lambda$22;
        String McpCard$lambda$25;
        ComposerKt.sourceInformation(composer, "C198@10039L256,196@9922L408:AdvancedSettings.kt#qn8u0p");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(82898186, i, -1, "com.clozed.code.ui.McpCard.<anonymous> (AdvancedSettings.kt:196)");
            }
            McpCard$lambda$22 = AdvancedSettingsKt.McpCard$lambda$22(this.$name$delegate);
            boolean z = false;
            if (!StringsKt.isBlank(McpCard$lambda$22)) {
                McpCard$lambda$25 = AdvancedSettingsKt.McpCard$lambda$25(this.$url$delegate);
                if (StringsKt.startsWith$default(McpCard$lambda$25, "http", false, 2, (Object) null)) {
                    z = true;
                }
            }
            boolean z2 = z;
            composer.startReplaceGroup(-20621214);
            ComposerKt.sourceInformation(composer, "CC(remember):AdvancedSettings.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(this.$store) | composer.changedInstance(this.$engine);
            final MutableState<String> mutableState = this.$name$delegate;
            final MutableState<List<McpServer>> mutableState2 = this.$servers$delegate;
            final MutableState<String> mutableState3 = this.$url$delegate;
            final MutableState<String> mutableState4 = this.$headers$delegate;
            final ProviderStore providerStore = this.$store;
            final LocalBackend localBackend = this.$engine;
            final MutableState<Boolean> mutableState5 = this.$showAdd$delegate;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                Function0 function0 = new Function0() { // from class: com.clozed.code.ui.AdvancedSettingsKt$McpCard$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$2$lambda$1;
                        invoke$lambda$2$lambda$1 = AdvancedSettingsKt$McpCard$4.invoke$lambda$2$lambda$1(mutableState, mutableState2, mutableState3, mutableState4, providerStore, localBackend, mutableState5);
                        return invoke$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(function0);
                rememberedValue = function0;
            }
            composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) rememberedValue, (Modifier) null, z2, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$AdvancedSettingsKt.INSTANCE.m1343getLambda11$app_release(), composer, 805306368, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, ProviderStore providerStore, LocalBackend localBackend, MutableState mutableState5) {
        String McpCard$lambda$22;
        List McpCard$lambda$9;
        String McpCard$lambda$25;
        String McpCard$lambda$28;
        McpCard$lambda$22 = AdvancedSettingsKt.McpCard$lambda$22(mutableState);
        String replace = new Regex("[^A-Za-z0-9_-]").replace(StringsKt.trim((CharSequence) McpCard$lambda$22).toString(), "_");
        McpCard$lambda$9 = AdvancedSettingsKt.McpCard$lambda$9(mutableState2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : McpCard$lambda$9) {
            if (!Intrinsics.areEqual(((McpServer) obj).getName(), replace)) {
                arrayList.add(obj);
            }
        }
        McpCard$lambda$25 = AdvancedSettingsKt.McpCard$lambda$25(mutableState3);
        String obj2 = StringsKt.trim((CharSequence) McpCard$lambda$25).toString();
        McpCard$lambda$28 = AdvancedSettingsKt.McpCard$lambda$28(mutableState4);
        AdvancedSettingsKt.McpCard$save(providerStore, localBackend, mutableState2, CollectionsKt.plus((Collection<? extends McpServer>) arrayList, new McpServer(replace, obj2, StringsKt.trim((CharSequence) McpCard$lambda$28).toString(), true)));
        AdvancedSettingsKt.McpCard$lambda$16(mutableState5, false);
        return Unit.INSTANCE;
    }
}

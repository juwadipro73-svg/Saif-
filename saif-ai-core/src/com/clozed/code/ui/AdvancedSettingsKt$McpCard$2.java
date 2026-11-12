package com.clozed.code.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.McpOAuth;
import com.clozed.code.engine.McpServer;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvancedSettings.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AdvancedSettingsKt$McpCard$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ MutableState<Integer> $loginTick$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableState<List<McpServer>> $servers$delegate;
    final /* synthetic */ MutableState<Boolean> $showAdd$delegate;
    final /* synthetic */ MutableState<Map<String, String>> $status$delegate;
    final /* synthetic */ ProviderStore $store;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedSettingsKt$McpCard$2(MutableState<List<McpServer>> mutableState, CoroutineScope coroutineScope, LocalBackend localBackend, ProviderStore providerStore, Context context, MutableState<Map<String, String>> mutableState2, MutableState<Integer> mutableState3, MutableState<Boolean> mutableState4) {
        this.$servers$delegate = mutableState;
        this.$scope = coroutineScope;
        this.$engine = localBackend;
        this.$store = providerStore;
        this.$ctx = context;
        this.$status$delegate = mutableState2;
        this.$loginTick$delegate = mutableState3;
        this.$showAdd$delegate = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x03c5, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r1, (java.lang.CharSequence) "login", true) == true) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0405 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x056d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.runtime.Composer r42, int r43) {
        /*
            Method dump skipped, instructions count: 1551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.AdvancedSettingsKt$McpCard$2.invoke(androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$13$lambda$12$lambda$3$lambda$2$lambda$1(boolean z, McpServer mcpServer, LocalBackend localBackend, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Context context) {
        int McpCard$lambda$18;
        Map McpCard$lambda$12;
        if (!z) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AdvancedSettingsKt$McpCard$2$1$1$1$1$1$1(mcpServer, context, mutableState2, null), 3, null);
        } else {
            McpOAuth.INSTANCE.logout(mcpServer.getUrl());
            localBackend.getMcp().invalidate();
            McpCard$lambda$18 = AdvancedSettingsKt.McpCard$lambda$18(mutableState);
            AdvancedSettingsKt.McpCard$lambda$19(mutableState, McpCard$lambda$18 + 1);
            McpCard$lambda$12 = AdvancedSettingsKt.McpCard$lambda$12(mutableState2);
            mutableState2.setValue(MapsKt.plus(McpCard$lambda$12, TuplesKt.to(mcpServer.getName(), "Logged out")));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$13$lambda$12$lambda$5$lambda$4(CoroutineScope coroutineScope, McpServer mcpServer, LocalBackend localBackend, MutableState mutableState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AdvancedSettingsKt$McpCard$2$1$1$2$1$1(mcpServer, localBackend, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$13$lambda$12$lambda$8$lambda$7(MutableState mutableState, McpServer mcpServer, ProviderStore providerStore, LocalBackend localBackend, boolean z) {
        List McpCard$lambda$9;
        boolean z2;
        McpCard$lambda$9 = AdvancedSettingsKt.McpCard$lambda$9(mutableState);
        List<McpServer> list = McpCard$lambda$9;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (McpServer mcpServer2 : list) {
            if (Intrinsics.areEqual(mcpServer2.getName(), mcpServer.getName())) {
                z2 = z;
                mcpServer2 = McpServer.copy$default(mcpServer2, null, null, null, z2, 7, null);
            } else {
                z2 = z;
            }
            arrayList.add(mcpServer2);
            z = z2;
        }
        AdvancedSettingsKt.McpCard$save(providerStore, localBackend, mutableState, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$13$lambda$12$lambda$11$lambda$10(MutableState mutableState, McpServer mcpServer, ProviderStore providerStore, LocalBackend localBackend) {
        List McpCard$lambda$9;
        McpCard$lambda$9 = AdvancedSettingsKt.McpCard$lambda$9(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : McpCard$lambda$9) {
            if (!Intrinsics.areEqual(((McpServer) obj).getName(), mcpServer.getName())) {
                arrayList.add(obj);
            }
        }
        AdvancedSettingsKt.McpCard$save(providerStore, localBackend, mutableState, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14(MutableState mutableState) {
        AdvancedSettingsKt.McpCard$lambda$16(mutableState, true);
        return Unit.INSTANCE;
    }
}

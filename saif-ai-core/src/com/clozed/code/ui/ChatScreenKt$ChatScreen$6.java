package com.clozed.code.ui;

import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.clozed.code.AppViewModel;
import com.clozed.code.UiState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ChatScreenKt$ChatScreen$6 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $busy;
    final /* synthetic */ MutableState<Boolean> $confirmStop$delegate;
    final /* synthetic */ ColorScheme $cs;
    final /* synthetic */ MutableState<Boolean> $follow$delegate;
    final /* synthetic */ MutableState<List<String>> $images$delegate;
    final /* synthetic */ MutableState<String> $input$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String, List<Uri>> $pickImages;
    final /* synthetic */ MutableState<Boolean> $showPort$delegate;
    final /* synthetic */ UiState $state;
    final /* synthetic */ AppViewModel $vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatScreenKt$ChatScreen$6(ColorScheme colorScheme, boolean z, MutableState<String> mutableState, MutableState<List<String>> mutableState2, UiState uiState, ManagedActivityResultLauncher<String, List<Uri>> managedActivityResultLauncher, MutableState<Boolean> mutableState3, AppViewModel appViewModel, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5) {
        this.$cs = colorScheme;
        this.$busy = z;
        this.$input$delegate = mutableState;
        this.$images$delegate = mutableState2;
        this.$state = uiState;
        this.$pickImages = managedActivityResultLauncher;
        this.$showPort$delegate = mutableState3;
        this.$vm = appViewModel;
        this.$confirmStop$delegate = mutableState4;
        this.$follow$delegate = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x05ce  */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.runtime.Composer r52, int r53) {
        /*
            Method dump skipped, instructions count: 1636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.ui.ChatScreenKt$ChatScreen$6.invoke(androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$4$lambda$3$lambda$2$lambda$1(String str, MutableState mutableState) {
        mutableState.setValue(str + " ");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(String str, MutableState mutableState) {
        List ChatScreen$lambda$19;
        ChatScreen$lambda$19 = ChatScreenKt.ChatScreen$lambda$19(mutableState);
        mutableState.setValue(CollectionsKt.minus(ChatScreen$lambda$19, str));
        return Unit.INSTANCE;
    }
}

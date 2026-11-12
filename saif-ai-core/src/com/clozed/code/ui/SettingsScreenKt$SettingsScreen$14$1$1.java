package com.clozed.code.ui;

import com.clozed.code.AppViewModel;
import com.clozed.code.engine.CatProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "", "url", "anth", "", "key"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.SettingsScreenKt$SettingsScreen$14$1$1", f = "SettingsScreen.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$SettingsScreen$14$1$1 extends SuspendLambda implements Function4<String, Boolean, String, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ CustomEdit $e;
    final /* synthetic */ AppViewModel $vm;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsScreenKt$SettingsScreen$14$1$1(AppViewModel appViewModel, CustomEdit customEdit, Continuation<? super SettingsScreenKt$SettingsScreen$14$1$1> continuation) {
        super(4, continuation);
        this.$vm = appViewModel;
        this.$e = customEdit;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String str, Boolean bool, String str2, Continuation<? super List<? extends String>> continuation) {
        return invoke(str, bool.booleanValue(), str2, (Continuation<? super List<String>>) continuation);
    }

    public final Object invoke(String str, boolean z, String str2, Continuation<? super List<String>> continuation) {
        SettingsScreenKt$SettingsScreen$14$1$1 settingsScreenKt$SettingsScreen$14$1$1 = new SettingsScreenKt$SettingsScreen$14$1$1(this.$vm, this.$e, continuation);
        settingsScreenKt$SettingsScreen$14$1$1.L$0 = str;
        settingsScreenKt$SettingsScreen$14$1$1.Z$0 = z;
        settingsScreenKt$SettingsScreen$14$1$1.L$1 = str2;
        return settingsScreenKt$SettingsScreen$14$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.L$0;
        boolean z = this.Z$0;
        String str2 = (String) this.L$1;
        AppViewModel appViewModel = this.$vm;
        String str3 = z ? "anthropic" : "openai";
        CatProvider existing = this.$e.getExisting();
        String id = existing != null ? existing.getId() : null;
        this.L$0 = null;
        this.label = 1;
        Object fetchModelList = appViewModel.fetchModelList(str3, str, str2, id, this);
        return fetchModelList == coroutine_suspended ? coroutine_suspended : fetchModelList;
    }
}

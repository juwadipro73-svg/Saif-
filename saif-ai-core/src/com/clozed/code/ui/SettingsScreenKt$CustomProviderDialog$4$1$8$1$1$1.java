package com.clozed.code.ui;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.ui.SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1", f = "SettingsScreen.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $anthropic$delegate;
    final /* synthetic */ MutableState<String> $apiUrl$delegate;
    final /* synthetic */ MutableState<String> $ckey$delegate;
    final /* synthetic */ MutableState<String> $fetchMsg$delegate;
    final /* synthetic */ MutableState<Boolean> $fetching$delegate;
    final /* synthetic */ MutableState<String> $models$delegate;
    final /* synthetic */ Function4<String, Boolean, String, Continuation<? super List<String>>, Object> $onFetch;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1(Function4<? super String, ? super Boolean, ? super String, ? super Continuation<? super List<String>>, ? extends Object> function4, MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<Boolean> mutableState6, Continuation<? super SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1> continuation) {
        super(2, continuation);
        this.$onFetch = function4;
        this.$apiUrl$delegate = mutableState;
        this.$anthropic$delegate = mutableState2;
        this.$ckey$delegate = mutableState3;
        this.$models$delegate = mutableState4;
        this.$fetchMsg$delegate = mutableState5;
        this.$fetching$delegate = mutableState6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1(this.$onFetch, this.$apiUrl$delegate, this.$anthropic$delegate, this.$ckey$delegate, this.$models$delegate, this.$fetchMsg$delegate, this.$fetching$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsScreenKt$CustomProviderDialog$4$1$8$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String CustomProviderDialog$lambda$90;
        boolean CustomProviderDialog$lambda$100;
        String CustomProviderDialog$lambda$97;
        String CustomProviderDialog$lambda$94;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function4<String, Boolean, String, Continuation<? super List<String>>, Object> function4 = this.$onFetch;
                CustomProviderDialog$lambda$90 = SettingsScreenKt.CustomProviderDialog$lambda$90(this.$apiUrl$delegate);
                CustomProviderDialog$lambda$100 = SettingsScreenKt.CustomProviderDialog$lambda$100(this.$anthropic$delegate);
                Boolean boxBoolean = Boxing.boxBoolean(CustomProviderDialog$lambda$100);
                CustomProviderDialog$lambda$97 = SettingsScreenKt.CustomProviderDialog$lambda$97(this.$ckey$delegate);
                this.label = 1;
                obj = function4.invoke(CustomProviderDialog$lambda$90, boxBoolean, CustomProviderDialog$lambda$97, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            CustomProviderDialog$lambda$94 = SettingsScreenKt.CustomProviderDialog$lambda$94(this.$models$delegate);
            List split$default = StringsKt.split$default((CharSequence) CustomProviderDialog$lambda$94, new String[]{",", "\n"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((String) obj2).length() > 0) {
                    arrayList2.add(obj2);
                }
            }
            this.$models$delegate.setValue(CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus((Collection) arrayList2, (Iterable) list)), ", ", null, null, 0, null, null, 62, null));
            this.$fetchMsg$delegate.setValue(list.size() + " models mile ✓");
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            MutableState<String> mutableState = this.$fetchMsg$delegate;
            String message = e.getMessage();
            if (message == null) {
                message = "error";
            }
            mutableState.setValue("Fetch fail: " + message);
        }
        SettingsScreenKt.CustomProviderDialog$lambda$82(this.$fetching$delegate, false);
        return Unit.INSTANCE;
    }
}

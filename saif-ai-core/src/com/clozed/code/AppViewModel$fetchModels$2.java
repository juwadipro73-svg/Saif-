package com.clozed.code;

import com.clozed.code.engine.CatModel;
import com.clozed.code.engine.CatProvider;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.ModelFetch;
import com.clozed.code.engine.ProviderStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.AppViewModel$fetchModels$2", f = "AppViewModel.kt", i = {}, l = {628}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel$fetchModels$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalBackend $engine;
    final /* synthetic */ String $id;
    final /* synthetic */ CatProvider $p;
    final /* synthetic */ boolean $silent;
    int label;
    final /* synthetic */ AppViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel$fetchModels$2(CatProvider catProvider, LocalBackend localBackend, String str, boolean z, AppViewModel appViewModel, Continuation<? super AppViewModel$fetchModels$2> continuation) {
        super(2, continuation);
        this.$p = catProvider;
        this.$engine = localBackend;
        this.$id = str;
        this.$silent = z;
        this.this$0 = appViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppViewModel$fetchModels$2(this.$p, this.$engine, this.$id, this.$silent, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppViewModel$fetchModels$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        UiState uiState;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        UiState uiState2;
        String message;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        UiState uiState3;
        Object fetch;
        MutableStateFlow mutableStateFlow4;
        Object value4;
        UiState uiState4;
        MutableStateFlow mutableStateFlow5;
        Object value5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    fetch = ModelFetch.INSTANCE.fetch(this.$p.getKind(), this.$p.getApi(), this.$engine.getStore().keyFor(this.$id), this);
                    if (fetch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    fetch = obj;
                }
                List<String> list = (List) fetch;
                List<CatModel> models = this.$p.getModels();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(models, 10));
                Iterator<T> it = models.iterator();
                while (it.hasNext()) {
                    arrayList.add(((CatModel) it.next()).getId());
                }
                Set set = CollectionsKt.toSet(arrayList);
                List<String> list2 = list;
                int i2 = 0;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!set.contains((String) it2.next()) && (i2 = i2 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (this.$p.getCustom()) {
                    ProviderStore store = this.$engine.getStore();
                    String str = this.$id;
                    List<CatModel> models2 = this.$p.getModels();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(models2, 10));
                    Iterator<T> it3 = models2.iterator();
                    while (it3.hasNext()) {
                        arrayList2.add(((CatModel) it3.next()).getId());
                    }
                    store.setCustomModels(str, CollectionsKt.distinct(CollectionsKt.plus((Collection) arrayList2, (Iterable) list)));
                } else {
                    this.$engine.getStore().setFetched(this.$id, list);
                }
                if (!this.$silent) {
                    mutableStateFlow5 = this.this$0._state;
                    do {
                        value5 = mutableStateFlow5.getValue();
                    } while (!mutableStateFlow5.compareAndSet(value5, UiState.copy$default((UiState) value5, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, list.size() + " models mile, " + i2 + " naye ✓", false, false, null, 491519, null)));
                }
                this.this$0.loadPickers();
                this.this$0.loadIntegrations();
                mutableStateFlow4 = this.this$0._state;
                String str2 = this.$id;
                do {
                    value4 = mutableStateFlow4.getValue();
                    uiState4 = (UiState) value4;
                } while (!mutableStateFlow4.compareAndSet(value4, UiState.copy$default(uiState4, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, SetsKt.minus(uiState4.getFetching(), str2), 262143, null)));
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    throw e;
                }
                if (!this.$silent) {
                    mutableStateFlow2 = this.this$0._state;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        uiState2 = (UiState) value2;
                        message = e.getMessage();
                        if (message == null) {
                            message = "error";
                        }
                    } while (!mutableStateFlow2.compareAndSet(value2, UiState.copy$default(uiState2, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Could not fetch models: " + message, false, false, null, 491519, null)));
                }
                mutableStateFlow = this.this$0._state;
                String str3 = this.$id;
                do {
                    value = mutableStateFlow.getValue();
                    uiState = (UiState) value;
                } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, SetsKt.minus(uiState.getFetching(), str3), 262143, null)));
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableStateFlow3 = this.this$0._state;
            String str4 = this.$id;
            do {
                value3 = mutableStateFlow3.getValue();
                uiState3 = (UiState) value3;
            } while (!mutableStateFlow3.compareAndSet(value3, UiState.copy$default(uiState3, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, SetsKt.minus(uiState3.getFetching(), str4), 262143, null)));
            throw th;
        }
    }
}

package com.clozed.code.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModelFetch.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.ModelFetch$fetch$2", f = "ModelFetch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class ModelFetch$fetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $apiUrl;
    final /* synthetic */ String $key;
    final /* synthetic */ String $kind;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelFetch$fetch$2(String str, String str2, String str3, Continuation<? super ModelFetch$fetch$2> continuation) {
        super(2, continuation);
        this.$apiUrl = str;
        this.$kind = str2;
        this.$key = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModelFetch$fetch$2(this.$apiUrl, this.$kind, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return ((ModelFetch$fetch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StringBuilder append;
        String str;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String trimEnd = StringsKt.trimEnd(StringsKt.trim((CharSequence) this.$apiUrl).toString(), '/');
        if (StringsKt.isBlank(trimEnd)) {
            throw new IllegalStateException("Endpoint URL not found");
        }
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(this.$kind, "anthropic")) {
            append = new StringBuilder().append(trimEnd);
            str = "/models?limit=1000";
        } else {
            append = new StringBuilder().append(trimEnd);
            str = "/models";
        }
        arrayList.add(append.append(str).toString());
        Exception exc = null;
        if (!Intrinsics.areEqual(this.$kind, "anthropic") && StringsKt.endsWith$default(trimEnd, "/v1", false, 2, (Object) null)) {
            arrayList.add(StringsKt.removeSuffix(trimEnd, (CharSequence) "/v1") + "/api/tags");
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            try {
                list = ModelFetch.INSTANCE.get(this.$kind, (String) next, this.$key);
                return list;
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (exc != null) {
            throw exc;
        }
        throw new IllegalStateException("Could not fetch models");
    }
}

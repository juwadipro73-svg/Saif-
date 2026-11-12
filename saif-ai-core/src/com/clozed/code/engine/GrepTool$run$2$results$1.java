package com.clozed.code.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.GrepTool$run$2$results$1", f = "Tools.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class GrepTool$run$2$results$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends List<? extends String>>>, Object> {
    final /* synthetic */ ToolCtx $c;
    final /* synthetic */ ArrayList<File> $candidates;
    final /* synthetic */ int $limit;
    final /* synthetic */ Regex $re;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrepTool$run$2$results$1(ArrayList<File> arrayList, Regex regex, ToolCtx toolCtx, int i, Continuation<? super GrepTool$run$2$results$1> continuation) {
        super(2, continuation);
        this.$candidates = arrayList;
        this.$re = regex;
        this.$c = toolCtx;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GrepTool$run$2$results$1 grepTool$run$2$results$1 = new GrepTool$run$2$results$1(this.$candidates, this.$re, this.$c, this.$limit, continuation);
        grepTool$run$2$results$1.L$0 = obj;
        return grepTool$run$2$results$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends List<? extends String>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<? extends List<String>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<? extends List<String>>> continuation) {
        return ((GrepTool$run$2$results$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
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
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        List chunked = CollectionsKt.chunked(this.$candidates, 48);
        Regex regex = this.$re;
        ToolCtx toolCtx = this.$c;
        int i2 = this.$limit;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
        Iterator it = chunked.iterator();
        while (it.hasNext()) {
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new GrepTool$run$2$results$1$1$1((List) it.next(), regex, toolCtx, i2, null), 2, null);
            arrayList.add(async$default);
            regex = regex;
            toolCtx = toolCtx;
            i2 = i2;
        }
        this.label = 1;
        Object awaitAll = AwaitKt.awaitAll(arrayList, this);
        return awaitAll == coroutine_suspended ? coroutine_suspended : awaitAll;
    }
}

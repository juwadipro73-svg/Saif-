package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$generateTitle$1", f = "LocalBackend.kt", i = {}, l = {1432, 1441}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$generateTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $first;
    final /* synthetic */ String $modelId;
    final /* synthetic */ CatProvider $provider;
    final /* synthetic */ Sess $s;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$generateTitle$1(CatProvider catProvider, LocalBackend localBackend, String str, String str2, Sess sess, Continuation<? super LocalBackend$generateTitle$1> continuation) {
        super(2, continuation);
        this.$provider = catProvider;
        this.this$0 = localBackend;
        this.$modelId = str;
        this.$first = str2;
        this.$s = sess;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalBackend$generateTitle$1(this.$provider, this.this$0, this.$modelId, this.$first, this.$s, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalBackend$generateTitle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.clozed.code.engine.LocalBackend$generateTitle$1.AnonymousClass1(r19.this$0, r19.$s, null), r19) == r1) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L24
            if (r2 == r3) goto L1e
            if (r2 != r4) goto L16
            kotlin.ResultKt.throwOnFailure(r20)     // Catch: java.lang.Exception -> Ld8
            goto Lcb
        L16:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1e:
            kotlin.ResultKt.throwOnFailure(r20)     // Catch: java.lang.Exception -> Ld8
            r2 = r20
            goto L6f
        L24:
            kotlin.ResultKt.throwOnFailure(r20)
            com.clozed.code.engine.Llm r2 = com.clozed.code.engine.Llm.INSTANCE     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.LlmRequest r6 = new com.clozed.code.engine.LlmRequest     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.CatProvider r7 = r0.$provider     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.LocalBackend r8 = r0.this$0     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.ProviderStore r8 = r8.getStore()     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.CatProvider r9 = r0.$provider     // Catch: java.lang.Exception -> Ld8
            java.lang.String r9 = r9.getId()     // Catch: java.lang.Exception -> Ld8
            java.lang.String r8 = r8.keyFor(r9)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r9 = r0.$modelId     // Catch: java.lang.Exception -> Ld8
            java.lang.String r10 = "Write a short title (max 6 words, no quotes, no trailing punctuation) for a conversation that starts with the user's message. Reply with the title only."
            com.clozed.code.engine.LlmTurn$User r11 = new com.clozed.code.engine.LlmTurn$User     // Catch: java.lang.Exception -> Ld8
            java.lang.String r12 = r0.$first     // Catch: java.lang.Exception -> Ld8
            r13 = 1500(0x5dc, float:2.102E-42)
            java.lang.String r12 = kotlin.text.StringsKt.take(r12, r13)     // Catch: java.lang.Exception -> Ld8
            r11.<init>(r12, r5, r4, r5)     // Catch: java.lang.Exception -> Ld8
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r11)     // Catch: java.lang.Exception -> Ld8
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> Ld8
            r17 = 896(0x380, float:1.256E-42)
            r18 = 0
            r13 = 60
            r14 = 0
            r15 = 0
            r16 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> Ld8
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Exception -> Ld8
            r0.label = r3     // Catch: java.lang.Exception -> Ld8
            java.lang.Object r2 = r2.complete(r6, r7)     // Catch: java.lang.Exception -> Ld8
            if (r2 != r1) goto L6f
            goto Lca
        L6f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Ld8
            java.util.List r2 = kotlin.text.StringsKt.lines(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Ld8
            if (r2 == 0) goto L94
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Ld8
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Ld8
            if (r2 == 0) goto L94
            r3 = 3
            char[] r3 = new char[r3]     // Catch: java.lang.Exception -> Ld8
            r3 = {x00dc: FILL_ARRAY_DATA , data: [34, 39, 46} // fill-array     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = kotlin.text.StringsKt.trim(r2, r3)     // Catch: java.lang.Exception -> Ld8
            goto L95
        L94:
            r2 = r5
        L95:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Ld8
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto La1
            goto Ld8
        La1:
            int r3 = r2.length()     // Catch: java.lang.Exception -> Ld8
            r6 = 80
            if (r3 > r6) goto Ld8
            com.clozed.code.engine.Sess r3 = r0.$s     // Catch: java.lang.Exception -> Ld8
            r3.setTitle(r2)     // Catch: java.lang.Exception -> Ld8
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> Ld8
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.LocalBackend$generateTitle$1$1 r3 = new com.clozed.code.engine.LocalBackend$generateTitle$1$1     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.LocalBackend r6 = r0.this$0     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.Sess r7 = r0.$s     // Catch: java.lang.Exception -> Ld8
            r3.<init>(r6, r7, r5)     // Catch: java.lang.Exception -> Ld8
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: java.lang.Exception -> Ld8
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> Ld8
            r0.label = r4     // Catch: java.lang.Exception -> Ld8
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r3, r5)     // Catch: java.lang.Exception -> Ld8
            if (r2 != r1) goto Lcb
        Lca:
            return r1
        Lcb:
            com.clozed.code.engine.LocalBackend r1 = r0.this$0     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = "session.renamed"
            com.clozed.code.engine.Sess r3 = r0.$s     // Catch: java.lang.Exception -> Ld8
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Exception -> Ld8
            com.clozed.code.engine.LocalBackend.access$emit(r1, r2, r3)     // Catch: java.lang.Exception -> Ld8
        Ld8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend$generateTitle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.clozed.code.engine.LocalBackend$generateTitle$1$1", f = "LocalBackend.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.clozed.code.engine.LocalBackend$generateTitle$1$1, reason: invalid class name */
    /* loaded from: /tmp/classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Sess $s;
        int label;
        final /* synthetic */ LocalBackend this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocalBackend localBackend, Sess sess, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = localBackend;
            this.$s = sess;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$s, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.save(this.$s);
            return Unit.INSTANCE;
        }
    }
}

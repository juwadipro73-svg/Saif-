package com.clozed.code.engine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$startJob$1", f = "LocalBackend.kt", i = {0, 1, 2, 3}, l = {610, 623, 623, 623}, m = "invokeSuspend", n = {"outcome", "outcome", "outcome", "outcome"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$startJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Sess $s;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalBackend$startJob$1(LocalBackend localBackend, Sess sess, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super LocalBackend$startJob$1> continuation) {
        super(2, continuation);
        this.this$0 = localBackend;
        this.$s = sess;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalBackend$startJob$1(this.this$0, this.$s, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalBackend$startJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|2|(1:(1:(1:(1:(5:8|9|(11:11|377|23|(1:(1:26))|50|28|(2:(1:31)|32)(2:(1:48)|49)|33|(1:(1:45))(1:46)|38|(1:44))|58|59)(2:60|61))(6:62|63|(11:68|22b|80|(1:(1:83))|107|85|(2:(1:88)|89)(2:(1:105)|106)|90|(1:(1:102))(1:103)|95|(2:97|(1:99)))|65|66|67))(6:114|115|(11:117|bc|129|(1:(1:132))|155|134|(2:(1:137)|138)(2:(1:153)|154)|139|(1:(1:150))(1:151)|144|(2:146|(1:148)))|65|66|67))(2:162|163))(3:216|217|(2:219|171))|164|166|167|168|(6:170|115|(0)|65|66|67)|171|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02e2, code lost:
    
        if (r12.this$0.getStore().getVoiceDone() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0175, code lost:
    
        r13 = com.clozed.code.engine.VoiceAnnouncer.INSTANCE;
        r0 = r12.this$0.ctx;
        r0 = r0.getApplicationContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "getApplicationContext(...)");
        r13.speak(r0, "Your task is completed, sir.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00f7, code lost:
    
        if ((r2 != null ? r2.getError() : null) != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0173, code lost:
    
        if (r12.this$0.getStore().getVoiceDone() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x01a5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01a6, code lost:
    
        r2 = org.mozilla.javascript.ES6Iterator.DONE_PROPERTY;
        r13 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02f0, code lost:
    
        r0 = r12.$s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02f2, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02f3, code lost:
    
        r4 = (com.clozed.code.engine.Msg) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) r0.getMsgs());
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02ff, code lost:
    
        if (r4 != null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x030b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.getRole(), "assistant") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0313, code lost:
    
        r4.setCompleted(true);
        r4.setError("Interrupted");
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x031b, code lost:
    
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x031e, code lost:
    
        r12.this$0.emit("session.execution.interrupted", r12.$s.getId());
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x032b, code lost:
    
        throw r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x01a0, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x01a1, code lost:
    
        r13 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x01af, code lost:
    
        r2 = "failed";
        r5 = r12.$s;
        r9 = r12.this$0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x01b5, code lost:
    
        monitor-enter(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x01b6, code lost:
    
        r10 = r13.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x01ba, code lost:
    
        if (r10 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x01bc, code lost:
    
        r10 = r13.getClass().getSimpleName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x01c4, code lost:
    
        r9.note(r5, "⚠ " + r10);
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x01d7, code lost:
    
        r12.this$0.emit("session.execution.failed", r12.$s.getId());
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x01e4, code lost:
    
        r12.$s.setUpdated(java.lang.System.currentTimeMillis());
        r12.L$0 = "failed";
        r12.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x020f, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.NonCancellable.INSTANCE.plus(kotlinx.coroutines.Dispatchers.getIO()), new com.clozed.code.engine.LocalBackend$startJob$1.AnonymousClass3(r12.this$0, r12.$s, null), r12) != r1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0213, code lost:
    
        r0 = "failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x019c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x019d, code lost:
    
        r2 = org.mozilla.javascript.ES6Iterator.DONE_PROPERTY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x032f, code lost:
    
        r12.$s.setUpdated(java.lang.System.currentTimeMillis());
        r12.L$0 = r2;
        r12.L$1 = r0;
        r12.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x035c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.NonCancellable.INSTANCE.plus(kotlinx.coroutines.Dispatchers.getIO()), new com.clozed.code.engine.LocalBackend$startJob$1.AnonymousClass3(r12.this$0, r12.$s, null), r12) != r1) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x035f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x03b2, code lost:
    
        if ((r3 != null ? r3.getError() : null) != null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0266, code lost:
    
        if ((r2 != null ? r2.getError() : null) != null) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0229  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 1110
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend$startJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.clozed.code.engine.LocalBackend$startJob$1$3", f = "LocalBackend.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.clozed.code.engine.LocalBackend$startJob$1$3, reason: invalid class name */
    /* loaded from: /tmp/classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Sess $s;
        int label;
        final /* synthetic */ LocalBackend this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LocalBackend localBackend, Sess sess, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = localBackend;
            this.$s = sess;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$s, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

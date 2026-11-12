package com.clozed.code.engine;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Ignore.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/io/File;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.IgnoreWalker$walk$1", f = "Ignore.kt", i = {0, 0, 0, 0, 0}, l = {109}, m = "invokeSuspend", n = {"$this$sequence", "stack", "rules", "children", "subdirs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: /tmp/classes3.dex */
public final class IgnoreWalker$walk$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super File>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hidden;
    final /* synthetic */ File $start;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ IgnoreWalker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoreWalker$walk$1(File file, IgnoreWalker ignoreWalker, boolean z, Continuation<? super IgnoreWalker$walk$1> continuation) {
        super(2, continuation);
        this.$start = file;
        this.this$0 = ignoreWalker;
        this.$hidden = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IgnoreWalker$walk$1 ignoreWalker$walk$1 = new IgnoreWalker$walk$1(this.$start, this.this$0, this.$hidden, continuation);
        ignoreWalker$walk$1.L$0 = obj;
        return ignoreWalker$walk$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super File> sequenceScope, Continuation<? super Unit> continuation) {
        return ((IgnoreWalker$walk$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0126, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r12, ".", false, 2, (java.lang.Object) null) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0111, code lost:
    
        r8 = new java.util.ArrayList();
        r10 = r1;
        r1 = r7.length;
        r9 = r7;
        r7 = r6;
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0113  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0126 -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0138 -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0143 -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0145 -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x014d -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0158 -> B:6:0x0180). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0174 -> B:5:0x017a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.IgnoreWalker$walk$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

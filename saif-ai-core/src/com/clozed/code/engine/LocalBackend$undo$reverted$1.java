package com.clozed.code.engine;

import com.clozed.code.engine.MPart;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.LocalBackend$undo$reverted$1", f = "LocalBackend.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend$undo$reverted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Sess $s;
    int label;
    final /* synthetic */ LocalBackend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBackend$undo$reverted$1(Sess sess, LocalBackend localBackend, Continuation<? super LocalBackend$undo$reverted$1> continuation) {
        super(2, continuation);
        this.$s = sess;
        this.this$0 = localBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalBackend$undo$reverted$1(this.$s, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((LocalBackend$undo$reverted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        Integer boxInt;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Sess sess = this.$s;
        LocalBackend localBackend = this.this$0;
        synchronized (sess) {
            ArrayList<Msg> msgs = sess.getMsgs();
            ListIterator<Msg> listIterator = msgs.listIterator(msgs.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i = -1;
                    break;
                }
                Msg previous = listIterator.previous();
                if (Intrinsics.areEqual(previous.getRole(), "user") && Intrinsics.areEqual(previous.getKind(), "")) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            int i2 = 0;
            if (i < 0) {
                localBackend.note(sess, "Nothing to undo");
            } else {
                List<Msg> subList = sess.getMsgs().subList(i, sess.getMsgs().size());
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                Iterator it = CollectionsKt.reversed(CollectionsKt.toList(subList)).iterator();
                while (it.hasNext()) {
                    ArrayList<MPart> parts = ((Msg) it.next()).getParts();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : parts) {
                        if (obj2 instanceof MPart.ToolP) {
                            arrayList.add(obj2);
                        }
                    }
                    Iterator it2 = CollectionsKt.reversed(arrayList).iterator();
                    while (it2.hasNext()) {
                        for (Pair pair : CollectionsKt.reversed(((MPart.ToolP) it2.next()).getUndo())) {
                            String str = (String) pair.component1();
                            String str2 = (String) pair.component2();
                            try {
                                File file = new File(str);
                                if (str2 == null) {
                                    Boxing.boxBoolean(file.delete());
                                } else {
                                    FilesKt.writeText$default(file, str2, null, 2, null);
                                }
                                i2++;
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                while (sess.getMsgs().size() > i) {
                    sess.getMsgs().remove(sess.getMsgs().size() - 1);
                }
                localBackend.note(sess, "Undid last turn (" + i2 + " file change" + (i2 == 1 ? "" : "s") + " reverted)");
            }
            boxInt = Boxing.boxInt(i2);
        }
        return boxInt;
    }
}

package com.clozed.code.engine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.ShellTool$run$2", f = "Tools.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {447, 452, 480}, m = "invokeSuspend", n = {"$this$withContext", "cmd", "dir", "$this$withContext", "cmd", "dir", "$this$withContext", "proc", "out", "reader", "timeout", "started", "timedOut"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "I$0"})
/* loaded from: /tmp/classes3.dex */
final class ShellTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellTool$run$2(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super ShellTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShellTool$run$2 shellTool$run$2 = new ShellTool$run$2(this.$a, this.$c, continuation);
        shellTool$run$2.L$0 = obj;
        return shellTool$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ShellTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cd, code lost:
    
        if (r8.invoke("shell", r10, "Run command", r21) == r0) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0172 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:8:0x0029, B:10:0x016c, B:12:0x0172, B:14:0x017f, B:36:0x0189), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01ac A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a5 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.ShellTool$run$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3(Process process, StringBuilder sb) {
        try {
            InputStream inputStream = process.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                BufferedReader bufferedReader2 = bufferedReader;
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader2.read(cArr);
                    if (read < 0) {
                        break;
                    }
                    synchronized (sb) {
                        if (sb.length() < 300000) {
                            sb.append(cArr, 0, read);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
            } finally {
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}

package com.clozed.code.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tools.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.GrepTool$run$2$results$1$1$1", f = "Tools.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
public final class GrepTool$run$2$results$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ ToolCtx $c;
    final /* synthetic */ List<File> $chunk;
    final /* synthetic */ int $limit;
    final /* synthetic */ Regex $re;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GrepTool$run$2$results$1$1$1(List<? extends File> list, Regex regex, ToolCtx toolCtx, int i, Continuation<? super GrepTool$run$2$results$1$1$1> continuation) {
        super(2, continuation);
        this.$chunk = list;
        this.$re = regex;
        this.$c = toolCtx;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GrepTool$run$2$results$1$1$1(this.$chunk, this.$re, this.$c, this.$limit, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return ((GrepTool$run$2$results$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean looksBinary;
        String rel;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<File> list = this.$chunk;
        Regex regex = this.$re;
        ToolCtx toolCtx = this.$c;
        int i = this.$limit;
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            looksBinary = ToolsKt.looksBinary(file);
            ArrayList arrayList2 = null;
            if (!looksBinary) {
                ArrayList arrayList3 = new ArrayList();
                Ref.IntRef intRef = new Ref.IntRef();
                try {
                    Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        BufferedReader bufferedReader2 = bufferedReader;
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            intRef.element++;
                            if (regex.containsMatchIn(readLine)) {
                                rel = ToolsKt.rel(toolCtx, file);
                                arrayList3.add(rel + ":" + intRef.element + ": " + StringsKt.take(StringsKt.trim((CharSequence) readLine).toString(), 300));
                                if (arrayList3.size() >= i) {
                                    break;
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                            break;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader, th);
                            throw th2;
                            break;
                        }
                    }
                } catch (Exception unused) {
                }
                if (!arrayList3.isEmpty()) {
                    arrayList2 = arrayList3;
                }
            }
            if (arrayList2 != null) {
                arrayList.add(arrayList2);
            }
        }
        return CollectionsKt.flatten(arrayList);
    }
}

package com.clozed.code.engine;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mcp.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/clozed/code/engine/McpManager;", "", "store", "Lcom/clozed/code/engine/ProviderStore;", "<init>", "(Lcom/clozed/code/engine/ProviderStore;)V", "clients", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/clozed/code/engine/McpClient;", "cache", "Lkotlin/Pair;", "", "", "Lcom/clozed/code/engine/McpToolDef;", "errors", "getErrors", "()Ljava/util/concurrent/ConcurrentHashMap;", "clientFor", "s", "Lcom/clozed/code/engine/McpServer;", "invalidate", "", "tools", "Lcom/clozed/code/engine/Tool;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "test", "", "(Lcom/clozed/code/engine/McpServer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class McpManager {
    public static final int $stable = 8;
    private final ConcurrentHashMap<String, Pair<Long, List<McpToolDef>>> cache;
    private final ConcurrentHashMap<String, McpClient> clients;
    private final ConcurrentHashMap<String, String> errors;
    private final ProviderStore store;

    public McpManager(ProviderStore store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
        this.clients = new ConcurrentHashMap<>();
        this.cache = new ConcurrentHashMap<>();
        this.errors = new ConcurrentHashMap<>();
    }

    public final ConcurrentHashMap<String, String> getErrors() {
        return this.errors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final McpClient clientFor(McpServer s) {
        McpClient putIfAbsent;
        ConcurrentHashMap<String, McpClient> concurrentHashMap = this.clients;
        String str = s.getName() + "|" + s.getUrl() + "|" + s.getHeaders();
        McpClient mcpClient = concurrentHashMap.get(str);
        if (mcpClient == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (mcpClient = new McpClient(s.getName(), s.getUrl(), s.getHeaders())))) != null) {
            mcpClient = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(mcpClient, "getOrPut(...)");
        return mcpClient;
    }

    public final void invalidate() {
        this.cache.clear();
        this.clients.clear();
        this.errors.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0105 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:11:0x003a, B:12:0x0101, B:14:0x0105, B:27:0x00e4, B:32:0x0117), top: B:10:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0161 A[LOOP:0: B:16:0x015b->B:18:0x0161, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0174 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:11:0x003a, B:12:0x0101, B:14:0x0105, B:27:0x00e4, B:32:0x0117), top: B:10:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00dd -> B:15:0x0151). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00fe -> B:12:0x0101). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tools(kotlin.coroutines.Continuation<? super java.util.List<? extends com.clozed.code.engine.Tool>> r13) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpManager.tools(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object test(com.clozed.code.engine.McpServer r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.clozed.code.engine.McpManager$test$1
            if (r0 == 0) goto L14
            r0 = r6
            com.clozed.code.engine.McpManager$test$1 r0 = (com.clozed.code.engine.McpManager$test$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.clozed.code.engine.McpManager$test$1 r0 = new com.clozed.code.engine.McpManager$test$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            com.clozed.code.engine.McpManager$test$d$1 r6 = new com.clozed.code.engine.McpManager$test$d$1
            r2 = 0
            r6.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r0.label = r3
            r2 = 25000(0x61a8, double:1.23516E-319)
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r6, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L55
            int r5 = r6.size()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        L55:
            com.clozed.code.engine.McpException r5 = new com.clozed.code.engine.McpException
            java.lang.String r6 = "Timeout (25s)"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.McpManager.test(com.clozed.code.engine.McpServer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

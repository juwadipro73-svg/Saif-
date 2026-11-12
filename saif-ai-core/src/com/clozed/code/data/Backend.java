package com.clozed.code.data;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

/* compiled from: Backend.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH¦@¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ.\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H¦@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ&\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H¦@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0006H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0006H¦@¢\u0006\u0002\u0010\u0004J\u001e\u0010&\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010'\u001a\u00020#H¦@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0013J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0006H¦@¢\u0006\u0002\u0010\u0004J\u001e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0013J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H&¨\u00063"}, d2 = {"Lcom/clozed/code/data/Backend;", "", "info", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessions", "", "Lcom/clozed/code/data/SessionInfo;", "activeSessionIds", "", "session", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "directory", "deleteSession", "", "renameSession", "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", "Lcom/clozed/code/data/ChatItem;", "prompt", "text", "images", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupt", "permissions", "Lcom/clozed/code/data/PermissionReq;", "replyPermission", "sessionId", "requestId", "decision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "models", "Lcom/clozed/code/data/ModelOpt;", "agents", "Lcom/clozed/code/data/AgentOpt;", "switchModel", "m", "(Ljava/lang/String;Lcom/clozed/code/data/ModelOpt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchAgent", "agentId", "integrations", "Lcom/clozed/code/data/IntegrationOpt;", "connectKey", "integrationId", "key", "events", "Lkotlinx/coroutines/flow/Flow;", "Lorg/json/JSONObject;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public interface Backend {
    Object activeSessionIds(Continuation<? super Set<String>> continuation);

    Object agents(Continuation<? super List<AgentOpt>> continuation);

    Object connectKey(String str, String str2, Continuation<? super Unit> continuation);

    Object createSession(String str, Continuation<? super SessionInfo> continuation);

    Object deleteSession(String str, Continuation<? super Unit> continuation);

    Flow<JSONObject> events();

    Object info(Continuation<? super String> continuation);

    Object integrations(Continuation<? super List<IntegrationOpt>> continuation);

    Object interrupt(String str, Continuation<? super Unit> continuation);

    Object messages(String str, Continuation<? super List<? extends ChatItem>> continuation);

    Object models(Continuation<? super List<ModelOpt>> continuation);

    Object permissions(String str, Continuation<? super List<PermissionReq>> continuation);

    Object prompt(String str, String str2, List<String> list, Continuation<? super Unit> continuation);

    Object renameSession(String str, String str2, Continuation<? super Unit> continuation);

    Object replyPermission(String str, String str2, String str3, Continuation<? super Unit> continuation);

    Object session(String str, Continuation<? super SessionInfo> continuation);

    Object sessions(Continuation<? super List<SessionInfo>> continuation);

    Object switchAgent(String str, String str2, Continuation<? super Unit> continuation);

    Object switchModel(String str, ModelOpt modelOpt, Continuation<? super Unit> continuation);

    /* compiled from: Backend.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object prompt$default(Backend backend, String str, String str2, List list, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prompt");
            }
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return backend.prompt(str, str2, list, continuation);
        }
    }
}

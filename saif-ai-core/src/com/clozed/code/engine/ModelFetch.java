package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ModelFetch.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clozed/code/engine/ModelFetch;", "", "<init>", "()V", "SKIP", "Lkotlin/text/Regex;", "fetch", "", "", "kind", "apiUrl", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "url", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class ModelFetch {
    public static final ModelFetch INSTANCE = new ModelFetch();
    private static final Regex SKIP = new Regex("embed|rerank|whisper|tts|moderation|dall-e|diffusion|reward", RegexOption.IGNORE_CASE);
    public static final int $stable = 8;

    private ModelFetch() {
    }

    public final Object fetch(String str, String str2, String str3, Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ModelFetch$fetch$2(str2, str, str3, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0190 A[Catch: all -> 0x01f3, TryCatch #1 {all -> 0x01f3, blocks: (B:3:0x0014, B:6:0x003c, B:9:0x0043, B:11:0x0049, B:12:0x006e, B:17:0x007f, B:19:0x0095, B:20:0x009e, B:23:0x00a9, B:25:0x00c1, B:27:0x00d4, B:28:0x00f6, B:30:0x0101, B:32:0x0109, B:34:0x011a, B:35:0x0122, B:36:0x012e, B:38:0x014c, B:40:0x0157, B:42:0x015a, B:45:0x0125, B:47:0x0129, B:50:0x015d, B:52:0x0163, B:56:0x0173, B:57:0x017a, B:58:0x00da, B:60:0x00e7, B:62:0x00ef, B:64:0x017b, B:65:0x0182, B:72:0x0186, B:73:0x0189, B:74:0x0098, B:75:0x018a, B:77:0x0190, B:79:0x019d, B:80:0x01a6, B:83:0x01b1, B:92:0x01bc, B:93:0x01bf, B:94:0x01a0, B:95:0x01c0, B:96:0x01f2, B:97:0x0052, B:98:0x0065, B:100:0x006b, B:22:0x00a0, B:69:0x0184, B:82:0x01a8, B:89:0x01ba), top: B:2:0x0014, inners: #0, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> get(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.ModelFetch.get(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }
}

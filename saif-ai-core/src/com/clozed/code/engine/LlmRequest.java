package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Llm.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/clozed/code/engine/LlmRequest;", "", "provider", "Lcom/clozed/code/engine/CatProvider;", "apiKey", "", "model", "system", "turns", "", "Lcom/clozed/code/engine/LlmTurn;", "tools", "Lcom/clozed/code/engine/ToolSpec;", "maxOutput", "", "effort", "reasoning", "", "capKnown", "<init>", "(Lcom/clozed/code/engine/CatProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;ZZ)V", "getProvider", "()Lcom/clozed/code/engine/CatProvider;", "getApiKey", "()Ljava/lang/String;", "getModel", "getSystem", "getTurns", "()Ljava/util/List;", "getTools", "getMaxOutput", "()I", "getEffort", "getReasoning", "()Z", "getCapKnown", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class LlmRequest {
    public static final int $stable = 8;
    private final String apiKey;
    private final boolean capKnown;
    private final String effort;
    private final int maxOutput;
    private final String model;
    private final CatProvider provider;
    private final boolean reasoning;
    private final String system;
    private final List<ToolSpec> tools;
    private final List<LlmTurn> turns;

    /* JADX WARN: Multi-variable type inference failed */
    public LlmRequest(CatProvider provider, String str, String model, String system, List<? extends LlmTurn> turns, List<ToolSpec> tools, int i, String effort, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(turns, "turns");
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(effort, "effort");
        this.provider = provider;
        this.apiKey = str;
        this.model = model;
        this.system = system;
        this.turns = turns;
        this.tools = tools;
        this.maxOutput = i;
        this.effort = effort;
        this.reasoning = z;
        this.capKnown = z2;
    }

    public final CatProvider getProvider() {
        return this.provider;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getSystem() {
        return this.system;
    }

    public final List<LlmTurn> getTurns() {
        return this.turns;
    }

    public final List<ToolSpec> getTools() {
        return this.tools;
    }

    public final int getMaxOutput() {
        return this.maxOutput;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ LlmRequest(com.clozed.code.engine.CatProvider r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.util.List r18, java.util.List r19, int r20, java.lang.String r21, boolean r22, boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 64
            if (r1 == 0) goto La
            r1 = 8192(0x2000, float:1.148E-41)
            r9 = r1
            goto Lc
        La:
            r9 = r20
        Lc:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L14
            java.lang.String r1 = "auto"
            r10 = r1
            goto L16
        L14:
            r10 = r21
        L16:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L1d
            r11 = r2
            goto L1f
        L1d:
            r11 = r22
        L1f:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L30
            r12 = r2
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r2 = r13
            goto L3d
        L30:
            r12 = r23
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
        L3d:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LlmRequest.<init>(com.clozed.code.engine.CatProvider, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, int, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getEffort() {
        return this.effort;
    }

    public final boolean getReasoning() {
        return this.reasoning;
    }

    public final boolean getCapKnown() {
        return this.capKnown;
    }
}

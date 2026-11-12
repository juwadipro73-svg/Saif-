package com.clozed.code.engine;

import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u0005R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u0005R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u0005R!\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R!\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`(¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R!\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`(¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010;\"\u0004\bF\u0010=R\u001a\u0010G\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\u0005R\u001a\u0010J\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R\u001a\u0010M\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R\u001a\u0010P\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0013\"\u0004\bR\u0010\u0015R\u001a\u0010S\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R\u001a\u0010V\u001a\u00020WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006\\"}, d2 = {"Lcom/clozed/code/engine/Sess;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "instr", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getInstr", "()Ljava/util/HashSet;", "title", "getTitle", "setTitle", "created", "", "getCreated", "()J", "setCreated", "(J)V", "updated", "getUpdated", "setUpdated", "directory", "getDirectory", "setDirectory", "agent", "getAgent", "setAgent", "providerId", "getProviderId", "setProviderId", "modelId", "getModelId", "setModelId", "msgs", "Ljava/util/ArrayList;", "Lcom/clozed/code/engine/Msg;", "Lkotlin/collections/ArrayList;", "getMsgs", "()Ljava/util/ArrayList;", "lastPrompt", "", "getLastPrompt", "()I", "setLastPrompt", "(I)V", "slow", "getSlow", "setSlow", "extraDirs", "getExtraDirs", "callHist", "getCallHist", "stuck", "", "getStuck", "()Z", "setStuck", "(Z)V", "todos", "Lorg/json/JSONArray;", "getTodos", "()Lorg/json/JSONArray;", "setTodos", "(Lorg/json/JSONArray;)V", "titled", "getTitled", "setTitled", "effort", "getEffort", "setEffort", "inTokens", "getInTokens", "setInTokens", "outTokens", "getOutTokens", "setOutTokens", "cacheRead", "getCacheRead", "setCacheRead", "cacheWrite", "getCacheWrite", "setCacheWrite", "cost", "", "getCost", "()D", "setCost", "(D)V", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Sess {
    public static final int $stable = 8;
    private String agent;
    private long cacheRead;
    private long cacheWrite;
    private final ArrayList<String> callHist;
    private double cost;
    private long created;
    private String directory;
    private String effort;
    private final ArrayList<String> extraDirs;
    private final String id;
    private long inTokens;
    private final HashSet<String> instr;
    private volatile int lastPrompt;
    private String modelId;
    private final ArrayList<Msg> msgs;
    private long outTokens;
    private String providerId;
    private volatile int slow;
    private volatile boolean stuck;
    private String title;
    private boolean titled;
    private JSONArray todos;
    private long updated;

    public Sess(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.instr = new HashSet<>();
        this.title = "";
        long currentTimeMillis = System.currentTimeMillis();
        this.created = currentTimeMillis;
        this.updated = currentTimeMillis;
        this.directory = "";
        this.agent = "build";
        this.msgs = new ArrayList<>();
        this.extraDirs = new ArrayList<>();
        this.callHist = new ArrayList<>();
        this.todos = new JSONArray();
        this.effort = "";
    }

    public final String getId() {
        return this.id;
    }

    public final HashSet<String> getInstr() {
        return this.instr;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final long getCreated() {
        return this.created;
    }

    public final void setCreated(long j) {
        this.created = j;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public final void setUpdated(long j) {
        this.updated = j;
    }

    public final String getDirectory() {
        return this.directory;
    }

    public final void setDirectory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.directory = str;
    }

    public final String getAgent() {
        return this.agent;
    }

    public final void setAgent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agent = str;
    }

    public final String getProviderId() {
        return this.providerId;
    }

    public final void setProviderId(String str) {
        this.providerId = str;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setModelId(String str) {
        this.modelId = str;
    }

    public final ArrayList<Msg> getMsgs() {
        return this.msgs;
    }

    public final int getLastPrompt() {
        return this.lastPrompt;
    }

    public final void setLastPrompt(int i) {
        this.lastPrompt = i;
    }

    public final int getSlow() {
        return this.slow;
    }

    public final void setSlow(int i) {
        this.slow = i;
    }

    public final ArrayList<String> getExtraDirs() {
        return this.extraDirs;
    }

    public final ArrayList<String> getCallHist() {
        return this.callHist;
    }

    public final boolean getStuck() {
        return this.stuck;
    }

    public final void setStuck(boolean z) {
        this.stuck = z;
    }

    public final JSONArray getTodos() {
        return this.todos;
    }

    public final void setTodos(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
        this.todos = jSONArray;
    }

    public final boolean getTitled() {
        return this.titled;
    }

    public final void setTitled(boolean z) {
        this.titled = z;
    }

    public final String getEffort() {
        return this.effort;
    }

    public final void setEffort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.effort = str;
    }

    public final long getInTokens() {
        return this.inTokens;
    }

    public final void setInTokens(long j) {
        this.inTokens = j;
    }

    public final long getOutTokens() {
        return this.outTokens;
    }

    public final void setOutTokens(long j) {
        this.outTokens = j;
    }

    public final long getCacheRead() {
        return this.cacheRead;
    }

    public final void setCacheRead(long j) {
        this.cacheRead = j;
    }

    public final long getCacheWrite() {
        return this.cacheWrite;
    }

    public final void setCacheWrite(long j) {
        this.cacheWrite = j;
    }

    public final double getCost() {
        return this.cost;
    }

    public final void setCost(double d) {
        this.cost = d;
    }
}

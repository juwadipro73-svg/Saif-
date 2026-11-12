package com.clozed.code.engine;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* compiled from: CodeMode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.CodeTool$run$2", f = "CodeMode.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class CodeTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    final /* synthetic */ ToolCtx $c;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CodeTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeTool$run$2(JSONObject jSONObject, CodeTool codeTool, ToolCtx toolCtx, Continuation<? super CodeTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.this$0 = codeTool;
        this.$c = toolCtx;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CodeTool$run$2 codeTool$run$2 = new CodeTool$run$2(this.$a, this.this$0, this.$c, continuation);
        codeTool$run$2.L$0 = obj;
        return codeTool$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((CodeTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final String prep;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        if (!this.$a.has("code") || this.$a.isNull("code")) {
            throw new ToolError("code is required");
        }
        String optString = this.$a.optString("code");
        CodeTool codeTool = this.this$0;
        Intrinsics.checkNotNull(optString);
        prep = codeTool.prep(optString);
        final Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        final long currentTimeMillis = System.currentTimeMillis() + 180000;
        final StringBuilder sb = new StringBuilder();
        final Ref.IntRef intRef = new Ref.IntRef();
        ContextFactory contextFactory = new ContextFactory() { // from class: com.clozed.code.engine.CodeTool$run$2$factory$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.mozilla.javascript.ContextFactory
            public Context makeContext() {
                Context makeContext = super.makeContext();
                makeContext.setOptimizationLevel(-1);
                makeContext.setLanguageVersion(200);
                makeContext.setInstructionObserverThreshold(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                Intrinsics.checkNotNull(makeContext);
                return makeContext;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.mozilla.javascript.ContextFactory
            public void observeInstructionCount(Context cx, int instructionCount) {
                Intrinsics.checkNotNullParameter(cx, "cx");
                if (System.currentTimeMillis() > currentTimeMillis) {
                    throw new Error("Script timed out (3 minutes)");
                }
                Job job2 = job;
                if (job2 != null && !job2.isActive()) {
                    throw new Error("Cancelled");
                }
            }
        };
        list = this.this$0.inner;
        List list2 = list;
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap.put(((Tool) obj2).getName(), obj2);
        }
        try {
            final CodeTool codeTool2 = this.this$0;
            final ToolCtx toolCtx = this.$c;
            String str = (String) contextFactory.call(new ContextAction() { // from class: com.clozed.code.engine.CodeTool$run$2$$ExternalSyntheticLambda0
                @Override // org.mozilla.javascript.ContextAction
                public final Object run(Context context) {
                    String invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = CodeTool$run$2.invokeSuspend$lambda$1(linkedHashMap, prep, codeTool2, sb, intRef, toolCtx, context);
                    return invokeSuspend$lambda$1;
                }
            });
            StringBuilder sb2 = new StringBuilder();
            if (sb.length() > 0) {
                sb2.append((CharSequence) sb).append('\n');
            }
            sb2.append(str);
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            String obj3 = StringsKt.trim((CharSequence) sb3).toString();
            if (obj3.length() == 0) {
                obj3 = "(no output)";
            }
            return obj3;
        } catch (Error e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Script aborted";
            }
            throw new ToolError(message);
        } catch (RhinoException e2) {
            throw new ToolError("Script error: " + e2.details() + " (line " + RangesKt.coerceAtLeast(e2.lineNumber() - (new Regex("\\breturn\\b").containsMatchIn(prep) ? 1 : 0), 1) + ")" + (sb.length() > 0 ? "\nLogs so far:\n" + ((Object) sb) : ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$1(Map map, String str, CodeTool codeTool, StringBuilder sb, final Ref.IntRef intRef, final ToolCtx toolCtx, Context context) {
        String text;
        ScriptableObject initSafeStandardObjects = context.initSafeStandardObjects();
        NativeObject nativeObject = new NativeObject();
        CodeTool$run$2$out$1$log$1 codeTool$run$2$out$1$log$1 = new CodeTool$run$2$out$1$log$1(sb, codeTool);
        NativeObject nativeObject2 = nativeObject;
        ScriptableObject.putProperty(nativeObject2, "log", codeTool$run$2$out$1$log$1);
        ScriptableObject.putProperty(nativeObject2, "error", codeTool$run$2$out$1$log$1);
        ScriptableObject.putProperty(nativeObject2, "warn", codeTool$run$2$out$1$log$1);
        ScriptableObject scriptableObject = initSafeStandardObjects;
        ScriptableObject.putProperty(scriptableObject, "console", nativeObject);
        NativeObject nativeObject3 = new NativeObject();
        for (Map.Entry entry : map.entrySet()) {
            final String str2 = (String) entry.getKey();
            final Tool tool = (Tool) entry.getValue();
            ScriptableObject.putProperty(nativeObject3, str2, new BaseFunction() { // from class: com.clozed.code.engine.CodeTool$run$2$out$1$fn$1
                @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
                public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
                    Object obj;
                    JSONObject jSONObject;
                    Object runBlocking$default;
                    Intrinsics.checkNotNullParameter(cx, "cx");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(args, "args");
                    Ref.IntRef.this.element++;
                    if (Ref.IntRef.this.element > 60) {
                        throw ScriptRuntime.constructError("Error", "Too many tool calls (max 60)");
                    }
                    try {
                        try {
                            if (args.length != 0 && (obj = args[0]) != null && obj != Undefined.instance) {
                                Object stringify = NativeJSON.stringify(cx, scope, args[0], null, null);
                                Intrinsics.checkNotNull(stringify, "null cannot be cast to non-null type kotlin.String");
                                jSONObject = new JSONObject((String) stringify);
                                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new CodeTool$run$2$out$1$fn$1$call$1(tool, ToolRepair.INSTANCE.repairArgs(jSONObject, tool.getSchema()), toolCtx, null), 1, null);
                                return runBlocking$default;
                            }
                            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new CodeTool$run$2$out$1$fn$1$call$1(tool, ToolRepair.INSTANCE.repairArgs(jSONObject, tool.getSchema()), toolCtx, null), 1, null);
                            return runBlocking$default;
                        } catch (DeniedException e) {
                            String message = e.getMessage();
                            if (message == null) {
                                message = "denied";
                            }
                            throw ScriptRuntime.constructError("PermissionDenied", message);
                        } catch (ToolError e2) {
                            String message2 = e2.getMessage();
                            if (message2 == null) {
                                message2 = "tool failed";
                            }
                            throw ScriptRuntime.constructError("ToolError", message2);
                        } catch (CancellationException e3) {
                            throw e3;
                        } catch (RhinoException e4) {
                            throw e4;
                        } catch (Exception e5) {
                            throw ScriptRuntime.constructError("Error", e5.getClass().getSimpleName() + ": " + e5.getMessage());
                        }
                        jSONObject = new JSONObject();
                    } catch (Exception unused) {
                        throw ScriptRuntime.constructError("TypeError", "tools." + str2 + " expects a single object argument");
                    }
                }
            });
        }
        ScriptableObject.putProperty(scriptableObject, "tools", nativeObject3);
        context.evaluateString(scriptableObject, "var Promise = { all: function(a){ return a; }, resolve: function(v){ return v; }, allSettled: function(a){ return a.map(function(v){ return { status: 'fulfilled', value: v }; }); } };", "prelude", 1, null);
        if (new Regex("\\breturn\\b").containsMatchIn(str)) {
            str = "(function(){\n" + str + "\n})()";
        }
        Object evaluateString = context.evaluateString(scriptableObject, str, "execute", 1, null);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(initSafeStandardObjects);
        text = codeTool.text(context, scriptableObject, evaluateString);
        return text;
    }
}

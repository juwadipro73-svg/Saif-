package com.clozed.code.engine;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* compiled from: CodeMode.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/clozed/code/engine/CodeTool$run$2$out$1$log$1", "Lorg/mozilla/javascript/BaseFunction;", NotificationCompat.CATEGORY_CALL, "", "cx", "Lorg/mozilla/javascript/Context;", "scope", "Lorg/mozilla/javascript/Scriptable;", "thisObj", "args", "", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class CodeTool$run$2$out$1$log$1 extends BaseFunction {
    final /* synthetic */ StringBuilder $logs;
    final /* synthetic */ CodeTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CodeTool$run$2$out$1$log$1(StringBuilder sb, CodeTool codeTool) {
        this.$logs = sb;
        this.this$0 = codeTool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence call$lambda$0(CodeTool codeTool, Context context, Scriptable scriptable, Object obj) {
        String text;
        text = codeTool.text(context, scriptable, obj);
        return text;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(final Context cx, final Scriptable scope, Scriptable thisObj, Object[] args) {
        Intrinsics.checkNotNullParameter(cx, "cx");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(args, "args");
        StringBuilder sb = this.$logs;
        final CodeTool codeTool = this.this$0;
        sb.append(ArraysKt.joinToString$default(args, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.clozed.code.engine.CodeTool$run$2$out$1$log$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence call$lambda$0;
                call$lambda$0 = CodeTool$run$2$out$1$log$1.call$lambda$0(CodeTool.this, cx, scope, obj);
                return call$lambda$0;
            }
        }, 30, (Object) null)).append('\n');
        return Undefined.instance;
    }
}

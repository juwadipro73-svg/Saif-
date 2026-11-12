package com.clozed.code.engine;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.clozed.code.engine.SkillTool$run$2", f = "Extensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/classes3.dex */
final class SkillTool$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $a;
    int label;
    final /* synthetic */ SkillTool this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillTool$run$2(JSONObject jSONObject, SkillTool skillTool, Continuation<? super SkillTool$run$2> continuation) {
        super(2, continuation);
        this.$a = jSONObject;
        this.this$0 = skillTool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SkillTool$run$2(this.$a, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((SkillTool$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        Object obj2;
        List list2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String optString = this.$a.optString("id");
        list = this.this$0.skills;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((Skill) obj2).getName(), optString)) {
                break;
            }
        }
        final Skill skill = (Skill) obj2;
        if (skill == null) {
            list2 = this.this$0.skills;
            throw new ToolError("Unknown skill '" + optString + "'. Available: " + CollectionsKt.joinToString$default(list2, null, null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.SkillTool$run$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    CharSequence invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = SkillTool$run$2.invokeSuspend$lambda$1((Skill) obj3);
                    return invokeSuspend$lambda$1;
                }
            }, 31, null));
        }
        String component2 = ExtensionsKt.parseFrontmatter(FilesKt.readText$default(skill.getFile(), null, 1, null)).component2();
        List list3 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(FilesKt.walkTopDown(skill.getDir()), new Function1() { // from class: com.clozed.code.engine.SkillTool$run$2$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                boolean invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = SkillTool$run$2.invokeSuspend$lambda$2((File) obj3);
                return Boolean.valueOf(invokeSuspend$lambda$2);
            }
        }), 40), new Function1() { // from class: com.clozed.code.engine.SkillTool$run$2$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                String invokeSuspend$lambda$3;
                invokeSuspend$lambda$3 = SkillTool$run$2.invokeSuspend$lambda$3(Skill.this, (File) obj3);
                return invokeSuspend$lambda$3;
            }
        }));
        StringBuilder sb = new StringBuilder("<skill_content name=\"");
        sb.append(skill.getName()).append("\">\n# Skill: ").append(skill.getName()).append("\n\n").append(StringsKt.trim((CharSequence) component2).toString());
        sb.append("\n\nBase directory for this skill: ").append(skill.getDir().getPath());
        if (!list3.isEmpty()) {
            sb.append("\n\n<skill_files>\n").append(CollectionsKt.joinToString$default(list3, "\n", null, null, 0, null, null, 62, null)).append("\n</skill_files>");
        }
        sb.append("\n</skill_content>");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$1(Skill skill) {
        return skill.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$2(File file) {
        return file.isFile() && !Intrinsics.areEqual(file.getName(), "SKILL.md");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$3(Skill skill, File file) {
        return FilesKt.relativeTo(file, skill.getDir()).getPath();
    }
}

package com.clozed.code.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/clozed/code/engine/SkillTool;", "Lcom/clozed/code/engine/Tool;", "skills", "", "Lcom/clozed/code/engine/Skill;", "<init>", "(Ljava/util/List;)V", "name", "", "getName", "()Ljava/lang/String;", "description", "getDescription", "schema", "Lorg/json/JSONObject;", "getSchema", "()Lorg/json/JSONObject;", "run", "a", "c", "Lcom/clozed/code/engine/ToolCtx;", "(Lorg/json/JSONObject;Lcom/clozed/code/engine/ToolCtx;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class SkillTool implements Tool {
    public static final int $stable = 8;
    private final String description;
    private final String name;
    private final JSONObject schema;
    private final List<Skill> skills;

    public SkillTool(List<Skill> skills) {
        JSONObject sStr;
        JSONObject objSchema;
        Intrinsics.checkNotNullParameter(skills, "skills");
        this.skills = skills;
        this.name = "skill";
        StringBuilder sb = new StringBuilder("Load a specialized skill's instructions and resources into the current conversation when the task at hand matches its description.\n\nThe skill ID must match an available skill or a skill explicitly referenced by the user.\n\n<available_skills>\n");
        for (Skill skill : skills) {
            StringBuilder append = sb.append("- ").append(skill.getName()).append(": ");
            String description = skill.getDescription();
            if (StringsKt.isBlank(description)) {
                description = "(no description)";
            }
            append.append(description).append('\n');
        }
        sb.append("</available_skills>");
        this.description = sb.toString();
        List listOf = CollectionsKt.listOf("id");
        sStr = ExtensionsKt.sStr("The ID of an available skill");
        objSchema = ExtensionsKt.objSchema(listOf, TuplesKt.to("id", sStr));
        this.schema = objSchema;
    }

    @Override // com.clozed.code.engine.Tool
    public String getName() {
        return this.name;
    }

    @Override // com.clozed.code.engine.Tool
    public String getDescription() {
        return this.description;
    }

    @Override // com.clozed.code.engine.Tool
    public JSONObject getSchema() {
        return this.schema;
    }

    @Override // com.clozed.code.engine.Tool
    public Object run(JSONObject jSONObject, ToolCtx toolCtx, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SkillTool$run$2(jSONObject, this, null), continuation);
    }
}

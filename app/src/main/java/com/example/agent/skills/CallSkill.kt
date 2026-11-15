package com.example.agent.skills

import org.json.JSONObject

/**
 * Phone calls are REMOVED from this build: no CALL_PHONE permission, no dialer automation and
 * no contact lookup. The skill stays registered under its old name only so an older prompt gets
 * an honest answer instead of a crash.
 */
object CallSkill : Skill {
    override val name: String = "call"

    override suspend fun run(args: JSONObject, env: AgentEnv): SkillResult {
        return SkillResult(
            success = false,
            message = "Calling is turned off in this build. Open your phone app to place the call."
        )
    }
}

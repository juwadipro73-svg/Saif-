package com.example

import com.example.skills.VideoSkillPolicy
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** Locks the bundled Cinematic Motion Engine activation (request 23). */
class VideoSkillPolicyTest {

    @Test
    fun videoSlashCommandActivates() {
        assertTrue(VideoSkillPolicy.isVideoRequest("/video ek gaming montage banao"))
        assertTrue(VideoSkillPolicy.isVideoRequest("/VIDEO promo"))
    }

    @Test
    fun videoPhrasingActivatesInAnyLanguage() {
        assertTrue(VideoSkillPolicy.isVideoRequest("Mujhe ek documentary video banao"))
        assertTrue(VideoSkillPolicy.isVideoRequest("create advanced motion graphics for my app"))
        assertTrue(VideoSkillPolicy.isVideoRequest("make a YouTube Short about black holes"))
        assertTrue(VideoSkillPolicy.isVideoRequest("is script ko animate karo with voiceover"))
        assertTrue(VideoSkillPolicy.isVideoRequest("render a cinematic reel in Remotion"))
    }

    @Test
    fun storyModeDetectedForCharacterNarratives() {
        assertTrue(VideoSkillPolicy.isStoryRequest("Ek stickman ki kahani jo zero se successful businessman banta hai"))
        assertTrue(VideoSkillPolicy.isStoryRequest("ek gareeb stickman ki success story banao"))
        assertTrue(VideoSkillPolicy.isStoryRequest("Make an emotional story video about a village boy"))
        assertTrue(VideoSkillPolicy.isStoryRequest("/video horror story 60 seconds"))
        assertFalse(VideoSkillPolicy.isStoryRequest("Black holes kaise kaam karte hain? video banao"))
        assertFalse(VideoSkillPolicy.isStoryRequest("AI technology par documentary banao"))
    }

    @Test
    fun casualChatDoesNotActivate() {
        assertFalse(VideoSkillPolicy.isVideoRequest("hello"))
        assertFalse(VideoSkillPolicy.isVideoRequest("fix the login button crash"))
        assertFalse(VideoSkillPolicy.isVideoRequest("build my calculator app apk"))
    }
}

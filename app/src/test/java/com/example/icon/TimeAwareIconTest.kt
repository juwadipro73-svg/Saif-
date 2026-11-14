package com.example.icon

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TimeAwareIconTest {
    @Test fun everyHourMapsToOneOfTheEightPhases() {
        for (h in 0..23) assertTrue(TimeAwareIcon.phaseForHour(h) in 0 until TimeAwareIcon.PHASE_COUNT)
    }

    @Test fun phasesFollowTheDay() {
        assertEquals(0, TimeAwareIcon.phaseForHour(5))   // dawn
        assertEquals(1, TimeAwareIcon.phaseForHour(8))   // morning
        assertEquals(2, TimeAwareIcon.phaseForHour(12))  // noon
        assertEquals(3, TimeAwareIcon.phaseForHour(15))  // afternoon
        assertEquals(4, TimeAwareIcon.phaseForHour(18))  // sunset
        assertEquals(5, TimeAwareIcon.phaseForHour(20))  // evening
        assertEquals(6, TimeAwareIcon.phaseForHour(23))  // night
        assertEquals(6, TimeAwareIcon.phaseForHour(0))
        assertEquals(7, TimeAwareIcon.phaseForHour(2))   // late night
    }

    @Test fun nextHourNeverJumpsMoreThanOnePhase() {
        for (h in 0..23) {
            val a = TimeAwareIcon.phaseForHour(h)
            val b = TimeAwareIcon.phaseForHour(h + 1)
            val step = (b - a + TimeAwareIcon.PHASE_COUNT) % TimeAwareIcon.PHASE_COUNT
            assertTrue("hour $h: step $step", step <= 1)
        }
    }
}

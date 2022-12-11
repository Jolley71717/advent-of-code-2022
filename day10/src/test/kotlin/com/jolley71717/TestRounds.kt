package com.jolley71717

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRounds {
    @Test
    fun testCycles() {
        val clock = ClockCycle(testDataSmall, true)
        clock.processInput()
        assertEquals(5, clock.clockCycle)
        assertEquals(-1, clock.signal)
    }

    @Test
    fun testImportantCycles() {
        val clock = ClockCycle(testDataLarge, false)
        clock.processInput()
        clock.printFullOutput()
        assertEquals(21, clock.importantCycles[20], "Cycle 20")
        assertEquals(19, clock.importantCycles[60], "Cycle 60")
        assertEquals(18, clock.importantCycles[100], "Cycle 100")
        assertEquals(21, clock.importantCycles[140], "Cycle 140")
        assertEquals(16, clock.importantCycles[180], "Cycle 180")
        assertEquals(18, clock.importantCycles[220], "Cycle 220")
        assertEquals(420, clock.importantCycles[20]?.times(20), "Cycle 20")
        assertEquals(1140, clock.importantCycles[60]?.times(60), "Cycle 60")
        assertEquals(1800, clock.importantCycles[100]?.times(100), "Cycle 100")
        assertEquals(2940, clock.importantCycles[140]?.times(140), "Cycle 140")
        assertEquals(2880, clock.importantCycles[180]?.times(180), "Cycle 180")
        assertEquals(3960, clock.importantCycles[220]?.times(220), "Cycle 220")
        assertEquals(13140, clock.finalSignalStrength())
    }
//    During the 20th cycle, register X has the value 21, so the signal strength is 20 * 21 = 420. (The 20th cycle occurs in the middle of the second addx -1, so the value of register X is the starting value, 1, plus all of the other addx values up to that point: 1 + 15 - 11 + 6 - 3 + 5 - 1 - 8 + 13 + 4 = 21.)
//    During the 60th cycle, register X has the value 19, so the signal strength is 60 * 19 = 1140.
//    During the 100th cycle, register X has the value 18, so the signal strength is 100 * 18 = 1800.
//    During the 140th cycle, register X has the value 21, so the signal strength is 140 * 21 = 2940.
//    During the 180th cycle, register X has the value 16, so the signal strength is 180 * 16 = 2880.
//    During the 220th cycle, register X has the value 18, so the signal strength is 220 * 18 = 3960.
//    The sum of these signal strengths is 13140.

    companion object {
        val testDataSmall = """
            noop
            addx 3
            addx -5
        """.trimIndent()
        val testDataLarge = """
            addx 15
            addx -11
            addx 6
            addx -3
            addx 5
            addx -1
            addx -8
            addx 13
            addx 4
            noop
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx -35
            addx 1
            addx 24
            addx -19
            addx 1
            addx 16
            addx -11
            noop
            noop
            addx 21
            addx -15
            noop
            noop
            addx -3
            addx 9
            addx 1
            addx -3
            addx 8
            addx 1
            addx 5
            noop
            noop
            noop
            noop
            noop
            addx -36
            noop
            addx 1
            addx 7
            noop
            noop
            noop
            addx 2
            addx 6
            noop
            noop
            noop
            noop
            noop
            addx 1
            noop
            noop
            addx 7
            addx 1
            noop
            addx -13
            addx 13
            addx 7
            noop
            addx 1
            addx -33
            noop
            noop
            noop
            addx 2
            noop
            noop
            noop
            addx 8
            noop
            addx -1
            addx 2
            addx 1
            noop
            addx 17
            addx -9
            addx 1
            addx 1
            addx -3
            addx 11
            noop
            noop
            addx 1
            noop
            addx 1
            noop
            noop
            addx -13
            addx -19
            addx 1
            addx 3
            addx 26
            addx -30
            addx 12
            addx -1
            addx 3
            addx 1
            noop
            noop
            noop
            addx -9
            addx 18
            addx 1
            addx 2
            noop
            noop
            addx 9
            noop
            noop
            noop
            addx -1
            addx 2
            addx -37
            addx 1
            addx 3
            noop
            addx 15
            addx -21
            addx 22
            addx -6
            addx 1
            noop
            addx 2
            addx 1
            noop
            addx -10
            noop
            noop
            addx 20
            addx 1
            addx 2
            addx 2
            addx -6
            addx -11
            noop
            noop
            noop
        """.trimIndent()
    }
}
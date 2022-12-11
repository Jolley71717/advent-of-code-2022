package com.jolley71717

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRounds {
    @Test
    fun testCycles() {
        val bridge = RopeGrid(testDataSmall, true)
        bridge.processInput()
        assertEquals(13, bridge.totalVisitedPoints())
    }

    companion object {
        val testDataSmall = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
        """.trimIndent()
    }
}
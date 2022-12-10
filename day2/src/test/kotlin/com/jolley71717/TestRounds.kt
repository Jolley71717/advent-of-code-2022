package com.jolley71717

import com.jolley71717.RockPaperScissorsUtil.firstPassTotalScore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRounds {
    @Test
    fun testCasesTotalScore() {
        val highestCalories = testData.firstPassTotalScore()
        assertEquals(15L, highestCalories)
    }

    @Test
    fun testBetterIncrement() {
//        val highestC3alories = testData.highestTopXTotal(3)
//        assertEquals(45000L, highestC3alories)
    }

    companion object {
        val testData = """
            A Y
            B X
            C Z
        """.trimIndent()
    }
}
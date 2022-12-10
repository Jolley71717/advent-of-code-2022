package com.jolley71717

import com.jolley71717.RockPaperScissorsUtil.firstPassTotalScore
import com.jolley71717.RockPaperScissorsUtil.updatedStrategy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRounds {
    @Test
    fun testCasesTotalScore() {
        val totalScore = testData.firstPassTotalScore()
        assertEquals(15L, totalScore)
    }

    @Test
    fun testBetterIncrement() {
        val totalScore = testData.updatedStrategy()
        assertEquals(12L, totalScore)
    }

    companion object {
        val testData = """
            A Y
            B X
            C Z
        """.trimIndent()
    }
}
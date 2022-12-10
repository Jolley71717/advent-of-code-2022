package com.jolley71717

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestIncrease {
    @Test
    fun testIncrement() {
        val increasedNumber = SonarUtils.checkIncreases(testData)
        Assertions.assertEquals(7, increasedNumber)
    }

    @Test
    fun testBetterIncrement() {
        val increasedNumber = SonarUtils.moreHelpfulCheck(testData)
        Assertions.assertEquals(5, increasedNumber)
    }

    companion object {
        val testData = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )
    }
}
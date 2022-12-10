package com.jolley71717

import com.jolley71717.CalorieUtils.highestCalories
import com.jolley71717.CalorieUtils.highestTopXTotal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestIncrease {
    @Test
    fun testIncrement() {
        val highestCalories = testData.highestCalories()
        assertEquals(24000L, highestCalories)
    }

    @Test
    fun testBetterIncrement() {
        val highestC3alories = testData.highestTopXTotal(3)
        assertEquals(45000L, highestC3alories)
    }

    companion object {
        val testData = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
        """.trimIndent()
    }
}
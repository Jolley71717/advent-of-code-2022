package com.jolley71717

import com.jolley71717.RockPaperScissorsUtil.firstPassTotalScore

object RockPaperScissorsUtil {
    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors

    // (1 for Rock, 2 for Paper, and 3 for Scissors)
    // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
    fun String.firstPassTotalScore() = this.split("\\n".toRegex())
        .sumOf { oldStrategy[it] ?: 0 }

    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
    fun String.updatedStrategy() = this.split("\\n".toRegex())
        .sumOf { oldStrategy["${it.split(" ")[0]} ${strategyMapping[it]}"] ?: 0 }

    private val oldStrategy = mapOf<String, Long>(
        "A X" to 4,
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6,
    )

    /**
     * X -> lose
     * Y -> draw
     * Z -> win
     */
    private val strategyMapping = mapOf(
        "A X" to "Z",
        "A Y" to "X",
        "A Z" to "Y",
        "B X" to "X",
        "B Y" to "Y",
        "B Z" to "Z",
        "C X" to "Y",
        "C Y" to "Z",
        "C Z" to "X",
    )
}
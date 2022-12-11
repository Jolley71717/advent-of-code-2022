package com.jolley71717

import kotlin.math.abs
import kotlin.math.sign


data class RopeGrid(
    val input: String,
    val debug: Boolean = false,

) {
    val tVisitedPoints: MutableMap<Pair<Int, Int>, Int> = mutableMapOf(
        (0 to 0) to 1
    )
    val instructions = input.split("\\n".toRegex())
    var tLocation = 0 to 0
    var hLocation = 0 to 0

    fun processInput() {
        instructions.map { it.split(" ") }
            .map { it[0] to it[1] } // map to e.g. "R" to 4
            .forEach { (direction, repetitions) ->
               moveHeadWithFollowTail(direction, repetitions.toInt())
            }
    }

    fun totalVisitedPoints() = tVisitedPoints.keys.count()

    private fun moveHeadWithFollowTail(direction: String, repetitions: Int) {
        debugOnlyPrint("Executing direction $direction, $repetitions times")
        repeat(repetitions) {
            hLocation = directionMap[direction]?.invoke(hLocation) ?: (0 to 0)
            followWithTail()
            debugOnlyPrint("Head: $hLocation, Tail: $tLocation")
        }
    }


    private fun followWithTail() {
        when {
            (abs(xDiff()) > 1 && abs(yDiff()) >= 1) ||
                    (abs(xDiff()) >= 1 && abs(yDiff()) > 1) -> tLocation.directionChange(xDiff().sign * 1, yDiff().sign * 1)
            abs(xDiff()) > 1 -> tLocation.directionChange(xDiff().sign * 1, 0)
            abs(yDiff()) > 1 -> tLocation.directionChange(0, yDiff().sign * 1)
        }
        tVisitedPoints[tLocation] = tVisitedPoints.getOrPut(tLocation) { 0 } + 1
    }


    private fun debugOnlyPrint(message: String) {
        if (debug) {
            println(message)
        }
    }
    companion object {
        val directionMap = mapOf<String, (Pair<Int, Int>) -> Pair<Int, Int>>(
            "L" to { (first, second) ->  first - 1 to second },
            "R" to { (first, second) ->  first + 1 to second },
            "U" to { (first, second) ->  first to second + 1 },
            "D" to { (first, second) ->  first to second - 1 },
        )
    }
    /*
    R 4
    U 4
    L 3
    D 1
    R 4
    D 1
    L 5
    R 2

     */

    private fun Pair<Int, Int>.directionChange(x: Int, y:Int) {
        tLocation = first + x to second + y
    }

    private fun xDiff() = hLocation.first - tLocation.first
    private fun yDiff() = hLocation.second - tLocation.second
}

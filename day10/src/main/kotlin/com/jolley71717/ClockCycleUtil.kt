package com.jolley71717

data class ClockCycle(
    val input: String,
    val debug: Boolean = false,
    var clockCycle: Int = 0,
    var signal: Int = 1,
    val importantCycles: MutableMap<Int, Int> = mutableMapOf(
        20 to 0,
        60 to 0,
        100 to 0,
        140 to 0,
        180 to 0,
        220 to 0,
    ),
) {
    private var line = 1
    private val outputLines: MutableMap<Int, String> = mutableMapOf(1 to "")
    private val inputLines: List<String> = input.split("\\n".toRegex())

    fun processInput() {
        inputLines.forEach { line ->
            if (line.contains("noop")) {
                noOperation()
            } else {
                val (_, increment) = line.split(Regex("\\s+")).let {
                    Pair(it[0], it.getOrNull(1)?.toInt() ?: 0)
                }
                addX(increment)
            }
        }
        debugOnlyPrint("Final Cycle: $clockCycle. Final Signal: $signal")
    }

    fun finalSignalStrength() = importantCycles.entries.sumOf { it.key.times(it.value) }
    fun printFullOutput() = outputLines.values.forEach { println(it) }

    private fun noOperation() {
        debugOnlyPrint("Start of Cycle: $clockCycle -> No Op")
        incrementCycle()
        checkAndUpdateImportantSignals()
        debugOnlyPrint("End of Cycle: No Op")
    }

    private fun addX(addStrength: Int) {
        debugOnlyPrint("Start of Cycle: $clockCycle -> addX $addStrength")
        incrementCycle()
        incrementCycle()
        checkAndUpdateImportantSignals()
        debugOnlyPrint("Incrementing signal from $signal to ${signal + addStrength}")
        signal += addStrength
        debugOnlyPrint("Signal now: $signal")
        debugOnlyPrint("End of Cycle: addX $addStrength")
    }

    private fun incrementCycle() {
        extractOutput()
        clockCycle ++
        checkAndUpdateImportantSignals()
        debugOnlyPrint("incrementing cycle")
        debugOnlyPrint("cycle: $clockCycle")

    }

    private fun checkAndUpdateImportantSignals() {
        debugOnlyPrint("Checking cycle and signal")
        if (importantCycles.containsKey(clockCycle)) {
            debugOnlyPrint("Important cycle $clockCycle found with value of $signal")
            importantCycles[clockCycle] = signal
        }
    }

    private fun extractOutput() {
        val pixelPoint = if (clockCycle < 40) {
            clockCycle
        } else if (clockCycle % 40 != 0) {
            clockCycle % 40
        } else {
            1
        }

        val signalRange = (signal - 1)..(signal + 1)
        val printable = if (pixelPoint in signalRange) "#" else "."
        outputLines[line] = outputLines.getOrDefault(line, "") + printable

        if (clockCycle != 0 && (clockCycle + 1) % 40 == 0) {
            line += 1
        }
    }

    private fun debugOnlyPrint(message: String) {
        if (debug) {
            println(message)
        }
    }
}
/*
"""
.#.#.#.#..#.#.#.#.#.#..#..##..##..#..#...####
##...##....###...##..###...#
###...###...##....###...#
##...####....####....###
###....####.....###.....
"""

 */
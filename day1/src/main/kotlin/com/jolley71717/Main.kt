package com.jolley71717

fun main(args: Array<String>) {
    println("Day 1!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("The total increases are: ${SonarUtils.checkIncreases(realData)}")
    println("The total better increases are: ${SonarUtils.moreHelpfulCheck(realData)}")

}

private val realData = listOf(
 1234
)

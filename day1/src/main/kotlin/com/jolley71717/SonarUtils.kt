package com.jolley71717

object SonarUtils {
    fun moreHelpfulCheck(depths:List<Int>) = depths.let{
        val miniList = mutableListOf<Int>()
        for ((index, value) in it.withIndex()) {
            if(depths.size <= index + 2) {
                break
            }
            miniList.add(value + depths[index + 1] + depths[index + 2])
        }
        checkIncreases(miniList)
    }
    fun checkIncreases(depths: List<Int>) = depths.zipWithNext { a, b -> b > a }.count { it }
}
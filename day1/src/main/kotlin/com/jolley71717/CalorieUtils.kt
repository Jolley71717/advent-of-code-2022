package com.jolley71717

import com.jolley71717.CalorieUtils.highestCalories

object CalorieUtils {
    fun String.highestCalories() = this.split("\\n{2}".toRegex()).maxOfOrNull {
        it.split("\\n".toRegex())
            .map(String::toLong).sum()
    } ?: 0

    fun String.highestTopXTotal(topList: Int) = this.split("\\n{2}".toRegex())
        .map {
            it.split("\\n".toRegex())
                .map(String::toLong).sum()
        }.sorted()
        .takeLast(topList)
        .sum()
}
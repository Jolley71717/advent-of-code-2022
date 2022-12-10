pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "1.7.20"
    }
}
rootProject.name = "AdventOfCode2022"

include(":day1", ":day2")
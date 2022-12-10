plugins {
    kotlin("jvm")
    application
}

group = "me.ldutton"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}



application {
    mainClass.set("MainKt")
}
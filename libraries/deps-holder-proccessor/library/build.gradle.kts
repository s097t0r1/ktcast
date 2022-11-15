plugins {
    id("ktcast-java-library")
}

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }
}

dependencies {
    implementation(libs.google.ksp)
    implementation(libs.squareup.moshi)
}

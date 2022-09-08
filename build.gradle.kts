buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }

}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

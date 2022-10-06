plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

dependencies {

    implementation(libs.squareup.moshi)

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
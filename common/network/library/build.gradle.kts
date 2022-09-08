plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.logger)
    implementation(libs.squareup.moshi)
    implementation(libs.squareup.moshi.converter)

    implementation(projects.core.di.library)
    implementation(projects.core.exceptions.library)
    implementation(projects.core.utils.reaction.library)
}

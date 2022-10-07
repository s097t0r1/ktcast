plugins {
    id("ktcast-java-library")
    id("kotlin-kapt")
}

dependencies {
    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)
}
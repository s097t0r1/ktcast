plugins {
    id("com.android.library")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

    implementation(projects.core.di.library)
}
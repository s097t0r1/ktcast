plugins {
    id("com.android.library")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(projects.core.di.library)

    implementation(libs.androidx.security)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

}
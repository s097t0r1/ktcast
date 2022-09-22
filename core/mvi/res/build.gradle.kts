plugins {
    id("com.android.library")
    id("compose-configurator")
    id("module-configurator")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.bundles.androidx.compose)
}
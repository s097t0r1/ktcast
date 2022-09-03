plugins {
    id("com.android.library")
    id("module-configurator")
}

moduleConfiguration {
    isComposeEnable = true
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.bundles.androidx.compose)
}
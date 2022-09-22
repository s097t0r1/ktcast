plugins {
    id("com.android.library")
    id("compose-configurator")
    id("module-configurator")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.bundles.androidx.compose)
    implementation(libs.bundles.orbit.mvi)

    implementation(projects.core.mvi.res)
    implementation(projects.core.uiComponents.androidLibrary)
    implementation(projects.core.navigation.androidLibrary)

}

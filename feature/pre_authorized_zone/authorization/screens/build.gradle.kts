plugins {
    id("com.android.library")
    id("module-configurator")
    id("compose-configurator")
}

dependencies {

    implementation(projects.feature.preAuthorizedZone.authorization.res)

    implementation(libs.bundles.androidx.compose)
    implementation(projects.core.uiComponents.androidLibrary)
    implementation(projects.core.mvi.androidLibrary)
    implementation(projects.core.uiComponents.res)

}
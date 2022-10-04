plugins {
    id("com.android.library")
    id("module-configurator")
    id("compose-configurator")
}

moduleConfiguration {
    isDesugaringEnabled = true
}

dependencies {

    implementation(projects.feature.preAuthorizedZone.authorization.res)
    implementation(projects.feature.preAuthorizedZone.authorization.widget)

    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.androidx.compose)

    implementation(projects.core.uiComponents.androidLibrary)
    implementation(projects.core.mvi.androidLibrary)
    implementation(projects.core.uiComponents.res)

    implementation(libs.android.desugaring)

}
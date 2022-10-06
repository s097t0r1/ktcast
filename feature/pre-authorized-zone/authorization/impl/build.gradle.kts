plugins {
    id("com.android.library")
    id("module-configurator")
    id("compose-configurator")
    id("kotlin-kapt")
}

moduleConfiguration {
    isDesugaringEnabled = true
}

dependencies {
    implementation(projects.feature.preAuthorizedZone.authorization.api)
    implementation(projects.feature.preAuthorizedZone.authorization.screen)

    implementation(projects.core.di.library)
    implementation(projects.core.mvi.androidLibrary)
    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.core.exceptions.library)
    implementation(projects.libraries.viewmodelFactory.androidLibrary)
    implementation(projects.libraries.resourceProvider.androidLibrary)
    implementation(projects.core.uiComponents.androidLibrary)
    implementation(projects.libraries.validator.androidLibrary)
    implementation(projects.libraries.reaction.library)

    implementation(projects.data.authorization.api)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.bundles.androidx.compose)
    implementation(libs.bundles.orbit.mvi)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

    implementation(libs.android.desugaring)
}
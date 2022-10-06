plugins {
    id("com.android.application")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.google.material)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

    implementation(projects.core.di.library)
    implementation(projects.core.mvi.androidLibrary)
    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.core.debugHelper.androidLibrary)
    implementation(projects.core.utils.resourceProvider.androidLibrary)

    implementation(projects.common.network.androidLibrary)
    implementation(projects.common.persistence.database.androidLibrary)
    implementation(projects.common.persistence.secureStorage.androidLibrary)

    implementation(projects.feature.preAuthorizedZone.authorization.api)
    implementation(projects.feature.preAuthorizedZone.authorization.impl)
    implementation(projects.feature.preAuthorizedZone.splash.api)
    implementation(projects.feature.preAuthorizedZone.splash.impl)

    implementation(projects.data.authorization.api)
    implementation(projects.data.authorization.impl)
}

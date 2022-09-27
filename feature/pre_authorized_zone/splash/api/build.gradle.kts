plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    implementation(projects.feature.preAuthorizedZone.authorization.api)

    implementation(projects.core.di.library)
    implementation(projects.core.navigation.androidLibrary)
    implementation(libs.androidx.appcompat)

}
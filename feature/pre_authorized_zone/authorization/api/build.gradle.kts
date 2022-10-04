plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    implementation(projects.data.authorization.api)

    implementation(projects.core.di.library)
    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.core.utils.resourceProvider.androidLibrary)

    implementation(libs.androidx.appcompat)

}
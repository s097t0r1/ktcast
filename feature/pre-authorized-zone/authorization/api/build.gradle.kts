plugins {
    id("com.android.library")
    id("ktcast-feature-api")
}

dependencies {

    implementation(projects.data.authorization.api)

    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.libraries.resourceProvider.androidLibrary)

    implementation(libs.androidx.appcompat)

}
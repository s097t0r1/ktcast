plugins {
    id("ktcast-android-library")
    id("compose-configurator")
}

dependencies {

    implementation(projects.core.uiComponents.res)
    implementation(libs.bundles.androidx.compose)

}
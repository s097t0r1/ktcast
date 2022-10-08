plugins {
    id("ktcast-android-application")
    id("compose-configurator")
}

dependencies {

    implementation(libs.google.material)
    implementation(libs.androidx.compose.viewbinding)

    implementation(libs.bundles.orbit.mvi)

}

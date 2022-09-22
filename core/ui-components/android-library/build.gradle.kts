plugins {
    id("com.android.library")
    id("module-configurator")
    id("compose-configurator")
}

dependencies {

    implementation(projects.core.uiComponents.res)
    implementation(libs.bundles.androidx.compose)

}
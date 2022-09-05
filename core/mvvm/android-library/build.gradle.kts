plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.bundles.androidx.compose)

    implementation(projects.core.mvvm.res)
    implementation(projects.core.navigation.androidLibrary)
}

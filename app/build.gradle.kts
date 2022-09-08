plugins {
    id("com.android.application")
    id("module-configurator")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.google.material)

    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.core.mvvm.androidLibrary)
    implementation(projects.core.di.library)

    implementation(projects.common.network.library)
}

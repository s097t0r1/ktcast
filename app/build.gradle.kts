plugins {
    id("com.android.application")
    id("module-configurator")
}

moduleConfiguration {
    isParcelizeEnable = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.google.material)

    implementation(projects.core.navigation.androidLibrary)
    implementation(projects.core.mvvm.androidLibrary)
}

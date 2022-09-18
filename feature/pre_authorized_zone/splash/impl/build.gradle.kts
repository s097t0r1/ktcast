plugins {
    id("com.android.library")
    id("module-configurator")
    id("compose-configurator")
    id("kotlin-kapt")
}

moduleConfiguration {
    isParcelizeEnable = true
}


dependencies {

    implementation(projects.feature.preAuthorizedZone.splash.api)
    implementation(projects.feature.preAuthorizedZone.splash.res)

    implementation(projects.core.di.library)
    implementation(projects.core.mvvm.androidLibrary)
    implementation(projects.core.utils.viewmodelFactory.androidLibrary)
    implementation(projects.core.navigation.androidLibrary)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.bundles.androidx.compose)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

}
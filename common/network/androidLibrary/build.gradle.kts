plugins {
    id("com.android.library")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(projects.common.network.androidUtils)

    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.logger)
    implementation(libs.squareup.moshi)
    implementation(libs.squareup.moshi.converter)
    implementation(libs.jetbrains.coroutines.android)

    implementation(projects.core.di.library)
    implementation(projects.core.exceptions.library)
    implementation(projects.core.utils.reaction.library)

    implementation(projects.common.persistence.secureStorage.androidLibrary)
}

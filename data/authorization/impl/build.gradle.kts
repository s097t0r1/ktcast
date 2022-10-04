plugins {
    id("com.android.library")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(projects.data.authorization.api)

    implementation(projects.core.di.library)
    implementation(projects.core.utils.reaction.library)
    implementation(projects.core.utils.mapper.library)
    implementation(projects.core.exceptions.library)

    implementation(projects.common.network.androidLibrary)
    implementation(projects.common.persistence.database.androidLibrary)
    implementation(projects.common.persistence.secureStorage.androidLibrary)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.moshi)
    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)
}
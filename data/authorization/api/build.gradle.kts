plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    implementation(projects.core.di.library)
    implementation(projects.libraries.reaction.library)
    implementation(projects.libraries.mapper.library)
    implementation(projects.core.exceptions.library)

    implementation(projects.common.network.androidLibrary)

}
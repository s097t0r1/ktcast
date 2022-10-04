plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    implementation(projects.core.di.library)
    implementation(projects.core.utils.reaction.library)
    implementation(projects.core.utils.mapper.library)
    implementation(projects.core.exceptions.library)

    implementation(projects.common.network.androidLibrary)

}
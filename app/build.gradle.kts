plugins {
    id("com.google.devtools.ksp") version "1.7.20-1.0.7"
    id("ktcast-android-application")
    id("compose-configurator")
}

kotlin {
    sourceSets.debug {
        kotlin.srcDir("build/generated/ksp/debug/kotlin")
    }
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

dependencies {

    implementation(projects.libraries.depsHolderProccessor.library)
    ksp(projects.libraries.depsHolderProccessor.library)

    implementation(libs.google.material)
    implementation(libs.androidx.compose.viewbinding)

    implementation(libs.bundles.orbit.mvi)

}

ksp {
    arg("jsonConfigurationFilePath", "$rootDir/app/dhconfig.json")
}

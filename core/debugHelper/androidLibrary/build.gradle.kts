plugins {
    id("com.android.library")
    id("module-configurator")
}

dependencies {

    debugImplementation(libs.pandulapetor.beagle)
    releaseImplementation(libs.pandulapetor.beagle.noop)

    debugImplementation(libs.pandulapetor.beagle.okhttp)
    releaseImplementation(libs.pandulapetor.beagle.okhttp.noop)

    debugImplementation(libs.pandulapetor.beagle.logger)
    releaseImplementation(libs.pandulapetor.beagle.logger.noop)

    implementation(libs.jakewharton.timber)
}
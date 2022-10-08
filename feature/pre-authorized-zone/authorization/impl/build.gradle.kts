plugins {
    id("ktcast-feature-implementation")
}

dependencies {
    implementation(projects.feature.preAuthorizedZone.authorization.api)
    implementation(projects.feature.preAuthorizedZone.authorization.screen)

    implementation(projects.data.authorization.api)

    implementation(projects.common.persistence.secureStorage.androidLibrary)
}
plugins {
    id("ktcast-feature-implementation")
    id("kotlin-kapt")
}

dependencies {
    implementation(projects.feature.${buildModuleName}.api)
}

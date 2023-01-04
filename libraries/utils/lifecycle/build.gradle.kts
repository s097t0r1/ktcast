plugins {
    id("ktcast-android-library")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.jetbrains.coroutines.android)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.fragment.ktx)
}
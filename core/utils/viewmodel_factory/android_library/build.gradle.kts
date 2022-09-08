plugins {
    id("com.android.library")
    id("module-configurator")
    id("kotlin-kapt")
}

dependencies {

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.google.dagger)
    kapt(libs.google.dagger.compiler)

}
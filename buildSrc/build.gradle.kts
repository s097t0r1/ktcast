plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("module-configurator") {
            id = "module-configurator"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.wetalk.plugins.module_configuration.ModuleConfigurationPlugin"
        }
    }
}

dependencies {
    gradleApi()

    implementation(libs.android.gradle.plugin.api)
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}
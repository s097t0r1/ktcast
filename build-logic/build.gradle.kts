plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("module-configurator") {
            id = "module-configurator"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.module_configuration.ModuleConfigurationPlugin"
        }
        register("compose-configurator") {
            id = "compose-configurator"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.compose_configuration.ComposeConfigurationPlugin"
        }
        register("me.s097t0r1.ktcast.feature-impl") {
            id = "ktcast-feature-implementation"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.convention_plugin.FeatureImplConventionPlugin"
        }
        register("me.s097t0r1.ktcast.feature-api") {
            id = "ktcast-feature-api"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.convention_plugin.FeatureApiConventionPlugin"
        }
        register("me.s097t0r1.ktcast.java-library") {
            id = "ktcast-java-library"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.convention_plugin.LibraryConventionPlugin"
        }
        register("me.s097t0r1.ktcast.android-library") {
            id = "ktcast-android-library"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.convention_plugin.AndroidLibraryConventionPlugin"
        }
        register("me.s097t0r1.ktcast.android-application") {
            id = "ktcast-android-application"
            group = "me.s097t0r1"
            implementationClass =
                "me.s097t0r1.ktcast.plugins.convention_plugin.AndroidApplicationConventionPlugin"
        }
    }
}

dependencies {
    gradleApi()

    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}
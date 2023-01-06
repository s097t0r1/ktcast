package me.s097t0r1.ktcast.plugins.module_configuration.config

import com.android.build.api.dsl.ApplicationExtension
import me.s097t0r1.ktcast.plugins.module_configuration.ModuleConfigurationExtension
import org.gradle.api.Project

internal fun ApplicationExtension.configureApp(
    project: Project,
    configuration: ModuleConfigurationExtension
) {

    defaultConfig {
        vectorDrawables.useSupportLibrary = configuration.isVectorDrawableSupportEnabled
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    when {
        configuration.isParcelizeEnable -> project.plugins.apply("kotlin-parcelize")
    }
}
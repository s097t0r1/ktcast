package me.s097t0r1.wetalk.plugins.module_configuration.config

import com.android.build.api.dsl.LibraryExtension
import me.s097t0r1.wetalk.plugins.module_configuration.ModuleConfigurationExtension
import me.s097t0r1.wetalk.plugins.module_configuration.ext.libs
import me.s097t0r1.wetalk.plugins.module_configuration.ext.versionOf
import org.gradle.api.Project

fun LibraryExtension.configureAndroidLibrary(
    project: Project,
    configuration: ModuleConfigurationExtension
) {
    when {
        configuration.isParcelizeEnable -> project.plugins.apply("kotlin-parcelize")
        configuration.isComposeEnable -> configureCompose(project)
    }

}

private fun LibraryExtension.configureCompose(project: Project) {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = project.libs.versionOf("kotlinComposeCompiler")
    }
}
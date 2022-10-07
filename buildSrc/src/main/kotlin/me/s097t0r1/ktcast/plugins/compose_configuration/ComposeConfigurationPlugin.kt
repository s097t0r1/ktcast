package me.s097t0r1.ktcast.plugins.compose_configuration

import me.s097t0r1.ktcast.plugins.implementation
import me.s097t0r1.ktcast.plugins.module_configuration.ext.bundle
import me.s097t0r1.ktcast.plugins.module_configuration.ext.libraryExtension
import me.s097t0r1.ktcast.plugins.module_configuration.ext.libs
import me.s097t0r1.ktcast.plugins.module_configuration.ext.versionOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposeConfigurationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        libraryExtension.apply {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion = libs.versionOf("kotlinComposeCompiler")
        }

        dependencies {
            implementation(libs bundle "androidx.compose")
        }
    }
}
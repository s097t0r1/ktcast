package me.s097t0r1.wetalk.plugins.compose_configuration

import com.android.build.gradle.BaseExtension
import me.s097t0r1.wetalk.plugins.module_configuration.ext.libs
import me.s097t0r1.wetalk.plugins.module_configuration.ext.versionOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class ComposeConfigurationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        extensions.getByType<BaseExtension>().apply {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion = libs.versionOf("kotlinComposeCompiler")
        }
    }
}
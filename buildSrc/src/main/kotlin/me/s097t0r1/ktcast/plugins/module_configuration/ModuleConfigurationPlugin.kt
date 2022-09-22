package me.s097t0r1.ktcast.plugins.module_configuration

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import me.s097t0r1.ktcast.plugins.module_configuration.config.configureAndroidLibrary
import me.s097t0r1.ktcast.plugins.module_configuration.config.configureApp
import me.s097t0r1.ktcast.plugins.module_configuration.config.configureCommonOptions
import me.s097t0r1.ktcast.plugins.module_configuration.ext.applicationExtension
import me.s097t0r1.ktcast.plugins.module_configuration.ext.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.the

internal class ModuleConfigurationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        initalSetup(target)
        target.afterEvaluate {
            val moduleConfiguration = project.extensions.getByType<ModuleConfigurationExtension>()
            plugins.all {
                when (this) {
                    is AppPlugin -> applicationExtension.configureApp(target, moduleConfiguration)
                    is LibraryPlugin -> libraryExtension.configureAndroidLibrary(
                        target,
                        moduleConfiguration
                    )
                    is JavaLibraryPlugin -> println("This is Java Library")
                }
            }
        }
    }

    private fun initalSetup(target: Project) {
        target.plugins.apply("kotlin-android")
        target.the<BaseExtension>().configureCommonOptions(target)
        target.extensions.create<ModuleConfigurationExtension>("moduleConfiguration")
    }

}

package me.s097t0r1.ktcast.plugins

import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

internal fun DependencyHandlerScope.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

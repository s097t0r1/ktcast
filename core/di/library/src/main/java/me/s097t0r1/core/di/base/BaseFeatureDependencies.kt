package me.s097t0r1.core.di.base

import me.s097t0r1.core.di.base.holder.BaseDependencyHolder

interface BaseFeatureDependencies {
    val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies>
}

package me.s097t0r1.core.di.base

import me.s097t0r1.core.di.base.holder.BaseDependencyHolder

interface BaseFeatureDepenendencies {
    val dependencyProvider: BaseDependencyHolder<out BaseFeatureDepenendencies>
}
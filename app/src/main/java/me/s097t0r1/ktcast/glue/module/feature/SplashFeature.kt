package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder0
import me.s097t0r1.feature.splash.api.SplashFeatureDependencies
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder

fun glueSplashFeature() {
    SplashComponentHolder.provider = Provider {
        BaseDependencyHolder0.create {
            object : SplashFeatureDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDepenendencies> = it
            }
        }
    }
}
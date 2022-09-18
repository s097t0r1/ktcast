package me.s097t0r1.feature.splash.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import me.s097t0r1.feature.splash.api.SplashFeatureAPI
import me.s097t0r1.feature.splash.api.SplashFeatureDependencies

object SplashComponentHolder : BaseComponentHolder<SplashFeatureAPI, SplashFeatureDependencies>() {

    override fun initComponent(dependencies: SplashFeatureDependencies): SplashFeatureAPI =
        DaggerSplashComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as SplashComponent
}
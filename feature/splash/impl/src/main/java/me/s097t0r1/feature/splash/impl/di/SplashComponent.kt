package me.s097t0r1.feature.splash.impl.di

import dagger.Component
import me.s097t0r1.feature.splash.api.SplashFeatureAPI
import me.s097t0r1.feature.splash.api.SplashFeatureDependencies
import me.s097t0r1.feature.splash.impl.presentation.splash.SplashFragment
import me.s097t0r1.ktcast.libraries.factory.ViewModelFactoryModule

@Component(
    dependencies = [SplashFeatureDependencies::class],
    modules = [ViewModelModule::class, ViewModelFactoryModule::class, SplashModule::class]
)
internal interface SplashComponent : SplashFeatureAPI {

    fun inject(fragment: SplashFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: SplashFeatureDependencies): SplashComponent
    }

}
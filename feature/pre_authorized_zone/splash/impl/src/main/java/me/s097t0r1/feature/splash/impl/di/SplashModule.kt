package me.s097t0r1.feature.splash.impl.di

import dagger.Module
import dagger.Provides
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.feature.splash.api.SplashFeatureStarter
import me.s097t0r1.feature.splash.impl.presentation.SplashContainerFragment

@Module
internal abstract class SplashModule {


    companion object {

        @Provides
        fun provideSplashStarter(): SplashFeatureStarter =
            SplashFeatureStarter { FragmentScreen.create { SplashContainerFragment() } }

    }
}
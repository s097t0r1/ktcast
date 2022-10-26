package me.s097t0r1.feature.splash.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.s097t0r1.feature.splash.impl.presentation.splash.SplashViewModel
import me.s097t0r1.ktcast.libraries.factory.ViewModelKey

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindsViewModel(splashViewModel: SplashViewModel): ViewModel
}

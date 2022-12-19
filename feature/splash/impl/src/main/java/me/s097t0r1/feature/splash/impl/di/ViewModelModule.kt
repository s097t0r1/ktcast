package me.s097t0r1.feature.splash.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.s097t0r1.feature.splash.impl.presentation.splash.SplashViewModel
import me.s097t0r1.ktcast.libraries.factory.ViewModelKey

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsViewModel(splashViewModel: SplashViewModel): ViewModel

}
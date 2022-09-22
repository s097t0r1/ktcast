package me.s097t0r1.feature.splash.impl.presentation.splash

import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashSideEffect
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashState
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationGraph
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class SplashViewModel @Inject constructor(

) : BaseViewModel<SplashState, SplashSideEffect, SplashNavigationGraph>() {

    override val container: Container<SplashState, SplashSideEffect> = container(SplashState())


}
package me.s097t0r1.feature.splash.impl.presentation.splash

import javax.inject.Inject
import kotlinx.coroutines.delay
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationGraph
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashSideEffect
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashUIState
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class SplashViewModel @Inject constructor(

) : BaseViewModel<SplashUIState, SplashSideEffect, SplashNavigationGraph>() {

    override val container: Container<SplashUIState, SplashSideEffect> = container(SplashUIState())

    fun onInitViewModel() = intent {
        delay(SPLASH_DELAY_MILLIS)
        reduce {
            state.copy(isAppNameVisible = true)
        }
        delay(SPLASH_DELAY_MILLIS)
        navigateTo(SplashNavigationGraph.SignInScreen)
    }

    companion object {
        const val SPLASH_DELAY_MILLIS = 2000L
    }

}
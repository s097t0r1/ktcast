package me.s097t0r1.ktcast.feature.splash.widget.splash.mvi

import me.s097t0r1.core.mvi.base.state.BaseState

data class SplashUIState(
    val isAppNameVisible: Boolean = false
) : BaseState

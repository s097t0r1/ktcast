package me.s097t0r1.feature.splash.impl.presentation.splash.navigation

import me.s097t0r1.core.navigation.base.NavigationGraph

sealed class SplashNavigationGraph : NavigationGraph {
    object SignInScreen : SplashNavigationGraph()
}
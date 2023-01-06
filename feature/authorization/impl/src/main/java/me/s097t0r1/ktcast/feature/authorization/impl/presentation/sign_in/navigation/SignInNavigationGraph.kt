package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation

import me.s097t0r1.core.navigation.base.NavigationGraph

sealed class SignInNavigationGraph : NavigationGraph {
    object SignUpScreen : SignInNavigationGraph()
    object HomeScreen : SignInNavigationGraph()
}
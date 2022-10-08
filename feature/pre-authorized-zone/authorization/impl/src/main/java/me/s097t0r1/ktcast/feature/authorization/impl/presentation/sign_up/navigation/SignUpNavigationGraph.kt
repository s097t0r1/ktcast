package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation

import me.s097t0r1.core.navigation.base.NavigationGraph

sealed class SignUpNavigationGraph : NavigationGraph {
    object FillProfileScreen : SignUpNavigationGraph()
    object SignInScreen : SignUpNavigationGraph()
}
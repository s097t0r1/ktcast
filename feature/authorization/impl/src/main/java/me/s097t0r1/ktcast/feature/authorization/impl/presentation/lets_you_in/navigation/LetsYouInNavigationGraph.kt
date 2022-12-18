package me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.navigation

import me.s097t0r1.core.navigation.base.NavigationGraph

sealed class LetsYouInNavigationGraph : NavigationGraph {
    object SignUp : LetsYouInNavigationGraph()
    object SignIn : LetsYouInNavigationGraph()
}
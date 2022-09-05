package me.s097t0r1.core.navigation.base

import me.s097t0r1.core.navigation.router.Router

interface NavigationProvider<N : NavigationGraph> {
    fun navigate(router: Router, screen: N)
}

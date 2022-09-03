package me.s097t0r1.core.navigation.base

abstract class NavigationProvider<N : NavigationGraph> {
    abstract fun navigate(screen: N)
}

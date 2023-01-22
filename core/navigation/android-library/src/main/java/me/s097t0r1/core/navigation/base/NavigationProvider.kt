package me.s097t0r1.core.navigation.base

import android.os.Bundle
import androidx.core.os.bundleOf
import kotlin.reflect.KClass
import me.s097t0r1.core.navigation.router.Router

interface NavigationProvider<N : NavigationGraph> {
    fun navigate(router: Router, screen: N)
}

interface NavProvider<T : NavigationNode> {
    fun route(router: Router, nodeClazz: KClass<T>, params: Bundle = bundleOf())
}

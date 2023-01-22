package me.s097t0r1.core.navigation.base

import android.os.Bundle
import kotlin.reflect.KClass
import me.s097t0r1.core.navigation.router.Router

interface NavigationGraph

interface NavigationNode {
    fun navigate(router: Router, params: Bundle)
}

interface NavGraph<T : NavigationNode> {
    fun navigate(router: Router, kClass: KClass<T>, params: Bundle)
}

package me.s097t0r1.core.navigation.dispatcher

import me.s097t0r1.core.navigation.message.NavigationMessage

interface NavigationDispatcherHost {
    val dispatcher: NavigationDispatcher
    fun accept(navigationMessage: NavigationMessage)
}

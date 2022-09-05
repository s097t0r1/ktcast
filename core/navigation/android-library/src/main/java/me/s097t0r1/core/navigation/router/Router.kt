package me.s097t0r1.core.navigation.router

import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcher
import me.s097t0r1.core.navigation.message.NavigationMessage

interface Router {

    fun navigate(message: NavigationMessage)

    fun attachDispatcher(dispatcher: NavigationDispatcher)

    fun dettachDispatcher()
}

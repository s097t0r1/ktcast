package me.s097t0r1.core.navigation.router

import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcher
import me.s097t0r1.core.navigation.message.NavigationMessage

class AppRouter : Router {

    private var dispatcher: NavigationDispatcher? = null

    override fun navigate(message: NavigationMessage) {
        dispatcher?.dispatch(message)
    }

    override fun attachDispatcher(dispatcher: NavigationDispatcher) {
        this.dispatcher = dispatcher
    }

    override fun dettachDispatcher() {
        this.dispatcher = null
    }
}

package me.s097t0r1.core.navigation.dispatcher

import me.s097t0r1.core.navigation.command.NavigationCommand
import me.s097t0r1.core.navigation.message.NavigationMessage

interface NavigationDispatcher {
    val receiverTag: String
        get() = NavigationCommand.DEFAULT_RECEIVER

    fun dispatch(navigationMessage: NavigationMessage)
}

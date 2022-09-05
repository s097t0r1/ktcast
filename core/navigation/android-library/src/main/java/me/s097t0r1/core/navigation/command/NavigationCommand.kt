package me.s097t0r1.core.navigation.command

import me.s097t0r1.core.navigation.screen.NavigationScreen

sealed class NavigationCommand {

    class Forward(val screen: NavigationScreen) : NavigationCommand()

    class Replace(val screen: NavigationScreen) : NavigationCommand()

    object Back : NavigationCommand()

    class BackTo(val screen: NavigationScreen) : NavigationCommand()

    companion object {
        const val DEFAULT_RECEIVER = "NavigationMessage.DEFAULT_RECIVER"
    }
}

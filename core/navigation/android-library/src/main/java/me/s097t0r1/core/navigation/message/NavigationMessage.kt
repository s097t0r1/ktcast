package me.s097t0r1.core.navigation.message

import me.s097t0r1.core.navigation.command.NavigationCommand

abstract class NavigationMessage {
    val receiver = NavigationCommand.DEFAULT_RECEIVER
    abstract fun convertToCommands(): Array<out NavigationCommand>
}

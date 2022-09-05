package me.s097t0r1.core.navigation.navigator

import me.s097t0r1.core.navigation.command.NavigationCommand

interface Navigator {
    fun execute(commands: Array<out NavigationCommand>)
}

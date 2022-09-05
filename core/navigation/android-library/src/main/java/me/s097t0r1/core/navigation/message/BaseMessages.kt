package me.s097t0r1.core.navigation.message

import me.s097t0r1.core.navigation.command.NavigationCommand
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.core.navigation.screen.NavigationScreen

class ForwardMessage(
    private val screen: NavigationScreen
) : NavigationMessage() {

    override fun convertToCommands(): Array<out NavigationCommand> {
        return arrayOf(NavigationCommand.Forward(screen))
    }
}

object BackMessage : NavigationMessage() {

    override fun convertToCommands(): Array<out NavigationCommand> {
        return arrayOf(NavigationCommand.Back)
    }
}

class StartFlowMessage(
    private val screen: NavigationScreen
) : NavigationMessage() {

    override fun convertToCommands(): Array<out NavigationCommand> {
        return arrayOf(
            NavigationCommand.BackTo(FragmentScreen.Root),
            NavigationCommand.Replace(screen)
        )
    }
}

class FinishFlowMessage(
    private val screen: NavigationScreen
) : NavigationMessage() {

    override fun convertToCommands(): Array<out NavigationCommand> {
        return arrayOf(
            NavigationCommand.BackTo(FragmentScreen.Root)
        )
    }
}

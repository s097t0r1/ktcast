package me.s097t0r1.core.navigation.dispatcher

import androidx.fragment.app.Fragment
import me.s097t0r1.core.navigation.command.NavigationCommand
import me.s097t0r1.core.navigation.message.NavigationMessage

abstract class FragmentNavigationDispatcher(
    private val host: Fragment
) : NavigationDispatcher {

    abstract fun isSupportMessage(navigationMessage: NavigationMessage): Boolean

    override fun dispatch(navigationMessage: NavigationMessage) {
        if (!isSupportMessage(navigationMessage)) {
            dispatchToParentNode(navigationMessage)
        } else {
            if (navigationMessage.receiver != NavigationCommand.DEFAULT_RECEIVER &&
                receiverTag != navigationMessage.receiver
            ) {
                dispatchToParentNode(navigationMessage)
            } else {
                (host as? NavigationDispatcherHost)?.accept(navigationMessage)
            }
        }
    }

    private fun dispatchToParentNode(navigationMessage: NavigationMessage) {
        val parentNode = host.parentFragment ?: host.activity
        if (parentNode == null || parentNode !is NavigationDispatcherHost) {
            throw RuntimeException("Navigation host supported $navigationMessage not found")
        }
        parentNode.dispatcher.dispatch(navigationMessage)
    }
}

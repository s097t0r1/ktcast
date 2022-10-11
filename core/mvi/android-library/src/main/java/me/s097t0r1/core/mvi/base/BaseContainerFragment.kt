package me.s097t0r1.core.mvi.base

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import me.s097t0r1.core.navigation.dispatcher.FragmentNavigationDispatcher
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcher
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcherHost
import me.s097t0r1.core.navigation.message.BackMessage
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.message.NavigationMessage
import me.s097t0r1.core.navigation.message.ReplaceMessage
import me.s097t0r1.core.navigation.navigator.AppNavigator
import me.s097t0r1.core.navigation.navigator.Navigator
import me.s097t0r1.core.navigation.router.AppRouter
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.core.navigation.router.RouterProvider

abstract class BaseContainerFragment : Fragment, NavigationDispatcherHost, RouterProvider {

    protected abstract val containerId: Int

    override val dispatcher: NavigationDispatcher by lazy {

        object : FragmentNavigationDispatcher(this) {
            override fun isSupportMessage(navigationMessage: NavigationMessage): Boolean {
                return navigationMessage is ForwardMessage || navigationMessage is BackMessage ||
                        navigationMessage is ReplaceMessage
            }
        }
    }

    override val router: Router by lazy { AppRouter() }

    private val navigator: Navigator by lazy {
        AppNavigator(containerId, requireActivity(), childFragmentManager)
    }

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    protected abstract fun openLaunchScreen()

    protected open fun inject() { /* no-op */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        router.attachDispatcher(dispatcher)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addBackHandler()
        openLaunchScreen()
    }

    private fun addBackHandler() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (childFragmentManager.backStackEntryCount > 1) {
                accept(BackMessage)
            } else {
                router.navigate(BackMessage)
            }
        }
    }

    override fun onDestroy() {
        router.dettachDispatcher()
        super.onDestroy()
    }

    override fun accept(navigationMessage: NavigationMessage) {
        navigator.execute(navigationMessage.convertToCommands())
    }
}

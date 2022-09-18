package me.s097t0r1.core.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcher
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcherHost
import me.s097t0r1.core.navigation.message.NavigationMessage
import me.s097t0r1.core.navigation.navigator.AppNavigator
import me.s097t0r1.core.navigation.router.AppRouter
import me.s097t0r1.core.navigation.router.Router

abstract class BaseContainerActivity : AppCompatActivity, NavigationDispatcherHost {

    abstract val containerId: Int

    protected val router: Router by lazy { AppRouter() }

    override val dispatcher: NavigationDispatcher by lazy {
        object : NavigationDispatcher {
            override fun dispatch(navigationMessage: NavigationMessage) {
                this@BaseContainerActivity.accept(navigationMessage)
            }
        }
    }

    private val navigator: AppNavigator by lazy {
        AppNavigator(containerId, this)
    }

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    abstract fun openLaunchScreen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.attachDispatcher(dispatcher)
        openLaunchScreen()
    }

    override fun onDestroy() {
        router.dettachDispatcher()
        super.onDestroy()
    }

    override fun accept(navigationMessage: NavigationMessage) {
        navigator.execute(navigationMessage.convertToCommands())
    }

}

package me.s097t0r1.core.mvi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.viewbinding.ViewBinding
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcher
import me.s097t0r1.core.navigation.dispatcher.NavigationDispatcherHost
import me.s097t0r1.core.navigation.message.NavigationMessage
import me.s097t0r1.core.navigation.navigator.AppNavigator
import me.s097t0r1.core.navigation.router.AppRouter
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.core.ui_components.theme.KtCastTheme

abstract class BaseContainerActivity<V : ViewBinding> : AppCompatActivity(),
    NavigationDispatcherHost {

    protected lateinit var binding: V

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

    protected abstract fun setupToolbar(): Toolbar

    abstract fun openLaunchScreen()

    abstract fun onCreateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): V

    open fun onViewCreated(binding: V) {
        setSupportActionBar(setupToolbar())
        router.attachDispatcher(dispatcher)
        openLaunchScreen()
    }

    @Composable
    abstract fun Content()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtCastTheme {
                AndroidViewBinding(factory = ::onCreateViewBinding) {
                    binding = this
                    onViewCreated(binding)
                }
                Content()
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

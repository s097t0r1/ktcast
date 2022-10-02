package me.s097t0r1.core.mvi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import me.s097t0r1.core.mvi.base.state.BaseSideEffect
import me.s097t0r1.core.mvi.base.state.BaseState
import me.s097t0r1.core.mvi.res.R
import me.s097t0r1.core.navigation.base.NavigationGraph
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.router.RouterProvider
import me.s097t0r1.core.ui_components.theme.KtCastTheme

abstract class BaseFragment<VM : BaseViewModel<S, E, N>, S : BaseState, E : BaseSideEffect, N : NavigationGraph> : Fragment {

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    protected abstract val viewModel: VM
    protected abstract val navigationProvider: NavigationProvider<N>

    private val router by lazy { (parentFragment as RouterProvider).router }

    protected abstract fun inject()

    @Composable
    protected abstract fun Content()

    open fun onInitViewModel(viewModel: VM) { /* no-op */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        onInitViewModel(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            findViewById<ComposeView>(R.id.cvContent).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    KtCastTheme {
                        Surface(color = KtCastTheme.colors.backgroundPrimaryColor) {
                            this@BaseFragment.Content()
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewLifecycleObservers()
    }

    private fun initViewLifecycleObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                initNavigationObserver()
            }
        }
    }

    private suspend fun initNavigationObserver() =
        viewModel.navigation.collect {
            navigationProvider.navigate(router, it)
        }
}

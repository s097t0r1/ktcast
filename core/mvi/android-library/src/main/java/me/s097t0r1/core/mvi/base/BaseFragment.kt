package me.s097t0r1.core.mvi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import me.s097t0r1.core.mvi.base.host.HostSideEffect
import me.s097t0r1.core.mvi.base.host.HostViewModel
import me.s097t0r1.core.mvi.base.host.HostViewModelOwner
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

    private val hostViewModel: HostViewModel by activityViewModels(
        factoryProducer = { (requireActivity() as HostViewModelOwner).viewModelFactory }
    )

    private val router by lazy { (parentFragment as RouterProvider).router }

    protected abstract fun onInjectDaggerComponent()

    @Composable
    protected abstract fun Content()

    open fun onInitViewModel(viewModel: VM) { /* no-op */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        onInjectDaggerComponent()
        super.onCreate(savedInstanceState)
        onInitViewModel(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onSetupToolbar()
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

    private fun onSetupToolbar() {
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.let { setupToolbar(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewLifecycleObservers()
    }

    protected open fun setupToolbar(actionBar: ActionBar) {
        if (isBackAvailable()) {
            actionBar.show()
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(
                me.s097t0r1.core.ui_components.res.R.drawable.ic_toolbar_back
            )
            actionBar.setDisplayShowTitleEnabled(false)
        } else {
            actionBar.hide()
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setHomeAsUpIndicator(null)
        }
    }

    protected open fun isBackAvailable(): Boolean {
        return parentFragmentManager.backStackEntryCount > 1
    }

    private fun initViewLifecycleObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { initNavigationObserver() }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { initSideEffectObserver() }
    }

    private suspend fun initNavigationObserver() {
        viewModel.navigation.collectLatest { navigationProvider.navigate(router, it) }
    }

    private suspend fun initSideEffectObserver() {
        viewModel.hostSideEffect.collect {
            when (it) {
                is HostSideEffect.Alert -> hostViewModel.alert(it.alertType, it.message)
                is HostSideEffect.Logout -> hostViewModel.logout(it.logoutType)
            }
        }
    }


}

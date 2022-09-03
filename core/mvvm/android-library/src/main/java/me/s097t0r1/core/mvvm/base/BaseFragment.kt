package me.s097t0r1.core.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import me.s097t0r1.core.mvvm.res.R
import me.s097t0r1.core.navigation.base.NavigationGraph
import me.s097t0r1.core.navigation.base.NavigationProvider

abstract class BaseFragment<VM : BaseViewModel<N>, N : NavigationGraph> : Fragment {

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    protected abstract val viewModel: VM
    protected abstract val navigationProvider: NavigationProvider<N>

    protected abstract fun inject()

    protected abstract fun ComposeView.content()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_base, container).apply {
            findViewById<ComposeView>(R.id.cvContent).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                content()
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
            navigationProvider.navigate(it)
        }
}

package me.s097t0r1.feature.splash.impl.presentation.splash

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationGraph
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationProvider
import me.s097t0r1.ktcast.feature.splash.widget.splash.SplashScreen
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashSideEffect
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashUIState
import org.orbitmvi.orbit.compose.collectAsState

internal class SplashFragment(

) : BaseFragment<SplashViewModel, SplashUIState, SplashSideEffect, SplashNavigationGraph>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigationProviderFactory: Provider<SplashNavigationProvider>

    override val viewModel: SplashViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SplashNavigationGraph> by lazy {
        navigationProviderFactory.get()
    }

    override fun onInjectDaggerComponent() = SplashComponentHolder.getDaggerComponent().inject(this)

    override fun onInitViewModel(viewModel: SplashViewModel) {
        viewModel.onInitViewModel()
    }

    @Composable
    override fun Content() {
        val state = viewModel.collectAsState().value
        SplashScreen(state, SplashSideEffect())

    }

}
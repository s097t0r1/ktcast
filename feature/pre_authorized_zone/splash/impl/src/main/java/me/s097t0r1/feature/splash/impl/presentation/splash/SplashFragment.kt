package me.s097t0r1.feature.splash.impl.presentation.splash

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationGraph
import me.s097t0r1.feature.splash.impl.presentation.splash.navigation.SplashNavigationProvider
import me.s097t0r1.ktcast.feature.splash.widget.splash.SplashScreen
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashSideEffect
import me.s097t0r1.ktcast.feature.splash.widget.splash.mvi.SplashUIState
import org.orbitmvi.orbit.compose.collectAsState
import javax.inject.Inject

internal class SplashFragment(

) : BaseFragment<SplashViewModel, SplashUIState, SplashSideEffect, SplashNavigationGraph>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: SplashViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SplashNavigationGraph> by lazy {
        SplashNavigationProvider()
    }

    override fun inject() = SplashComponentHolder.getDaggerComponent().inject(this)

    override fun onInitViewModel(viewModel: SplashViewModel) {
        viewModel.onInitViewModel()
    }

    @Composable
    override fun Content() {

        val state = viewModel.collectAsState().value

        SplashScreen(state, SplashSideEffect())

    }

}
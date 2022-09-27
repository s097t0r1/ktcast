package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationProvider
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInScreen
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInUIState
import org.orbitmvi.orbit.compose.collectAsState
import javax.inject.Inject

internal class SignInFragment : BaseFragment<SignInViewModel, SignInUIState, SignInSideEffect, SignInNavigationGraph>(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: SignInViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SignInNavigationGraph> by lazy { SignInNavigationProvider() }

    override fun inject() = AuthorizationComponentHolder.getDaggerComponent().inject(this)

    @Composable
    override fun Content() {
        val state = viewModel.collectAsState().value
        SignInScreen(
            state = state,
            sideEffect = SignInSideEffect(),
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChanged = viewModel::onPasswordChanged
        )
    }

    companion object {
        fun newInstance() = SignInFragment()
    }

}
package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation.SignInNavigationProvider
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInScreen
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_in.SignInUIState
import org.orbitmvi.orbit.compose.collectAsState

internal class SignInFragment : BaseFragment<SignInViewModel, SignInUIState, SignInSideEffect, SignInNavigationGraph>(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: SignInViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SignInNavigationGraph> by lazy { SignInNavigationProvider() }

    override fun onInjectDaggerComponent() = AuthorizationComponentHolder.getDaggerComponent().inject(this)

    override fun onInitViewModel(viewModel: SignInViewModel) {
        viewModel.onInitViewModel()
    }

    @Composable
    override fun Content() {
        val state = viewModel.collectAsState().value
        SignInScreen(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            state = state,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onRememberCheckedChange = {},
            onSignInClicked = viewModel::onSignInClicked,
            onSignUpClicked = viewModel::onSignUpClicked,
            onToggleMaskPassword = viewModel::onToggleMaskPassword
        )
    }

}
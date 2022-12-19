package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up

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
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationProvider
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpScreen
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpUIState
import org.orbitmvi.orbit.compose.collectAsState

internal class SignUpFragment : BaseFragment<SignUpViewModel, SignUpUIState, SignUpSideEffect, SignUpNavigationGraph>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: SignUpViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SignUpNavigationGraph> by lazy {
        SignUpNavigationProvider()
    }

    override fun onInjectDaggerComponent() = AuthorizationComponentHolder.getDaggerComponent().inject(this)

    override fun onInitViewModel(viewModel: SignUpViewModel) {
        viewModel.onInitViewModel()
    }

    @Composable
    override fun Content() {
        SignUpScreen(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            state = viewModel.collectAsState().value,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChaged = viewModel::onPasswordChanged,
            onRememberCheckedChange = {},
            onSignUpClicked = viewModel::onSignUpClicked,
            onSignedInClicked = viewModel::onSignInClicked,
            onToggleMaskPassword = viewModel::onToggleMaskPassword
        )
    }
}
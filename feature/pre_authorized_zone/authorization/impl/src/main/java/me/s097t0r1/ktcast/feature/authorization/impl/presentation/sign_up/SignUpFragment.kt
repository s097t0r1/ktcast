package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up

//import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpScreen
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation.SignUpNavigationProvider
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpScreen
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.sign_up.SignUpUIState
import org.orbitmvi.orbit.compose.collectAsState
import javax.inject.Inject

internal class SignUpFragment : BaseFragment<SignUpViewModel, SignUpUIState, SignUpSideEffect, SignUpNavigationGraph>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: SignUpViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<SignUpNavigationGraph> by lazy {
        SignUpNavigationProvider()
    }

    override fun inject() = AuthorizationComponentHolder.getDaggerComponent().inject(this)

    override fun onInitViewModel(viewModel: SignUpViewModel) {
        viewModel.onInitViewModel()
    }

    @Composable
    override fun Content() {
        SignUpScreen(
            state = viewModel.collectAsState().value,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChaged = viewModel::onPasswordChanged,
            onRememberCheckedChange = {},
            onSignUpClicked = {},
            onSignedInClicked = {},
            onToggleMaskPassword = viewModel::onToggleMaskPassword
        )
    }
}
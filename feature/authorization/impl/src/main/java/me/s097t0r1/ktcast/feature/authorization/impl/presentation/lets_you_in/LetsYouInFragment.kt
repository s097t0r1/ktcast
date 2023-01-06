package me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in

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
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.navigation.LetsYouInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.navigation.LetsYouInNavigationProvider
import me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in.LetsYouInScreen
import me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in.LetsYouInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in.LetsYouInUIState

internal class LetsYouInFragment(

) : BaseFragment<LetsYouInViewModel, LetsYouInUIState, LetsYouInSideEffect, LetsYouInNavigationGraph>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: LetsYouInViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<LetsYouInNavigationGraph> by lazy {
        LetsYouInNavigationProvider()
    }

    override fun onInjectDaggerComponent() = AuthorizationComponentHolder.getDaggerComponent().inject(this)

    @Composable
    override fun Content() {
        LetsYouInScreen(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            onSignUpClicked = viewModel::onSignedUpClicked,
            onSignInClicked = viewModel::onSignedInClicked
        )
    }


}
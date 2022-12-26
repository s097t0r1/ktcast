package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.ktcast.feature.profile.impl.R
import me.s097t0r1.ktcast.feature.profile.impl.di.ProfileComponentHolder
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.navigation.FillYourProfileNavGraph
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.navigation.FillYourProfileNavigationProvider
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileScreen
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileSideEffect
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileUIState
import org.orbitmvi.orbit.compose.collectAsState

internal class FillYourProfileFragment() :
    BaseFragment<FillYourProfileViewModel, FillYourProfileUIState, FillYourProfileSideEffect, FillYourProfileNavGraph>(
        R.layout.profile_feat_fragment_profile_container
    ) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: FillYourProfileViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<FillYourProfileNavGraph> by lazy {
        FillYourProfileNavigationProvider()
    }

    override fun onInjectDaggerComponent() {
        ProfileComponentHolder.getDaggerComponent().inject(this)
    }

    @Composable
    override fun Content() {
        val state by viewModel.collectAsState()
        FillYourProfileScreen(
            state = state,
            onEditClick = viewModel::onEditClick,
            onFullNameChange = viewModel::onFullNameChange,
            onNicknameChange = viewModel::onNicknameChange,
            onBirthdayChange = viewModel::onBirthdayChange,
            onEmailChange = viewModel::onEmailChange,
        )
    }
}

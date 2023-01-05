package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile

import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import me.s097t0r1.core.mvi.base.BaseFragment
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.ui_components.components.AlertSnackBarHost
import me.s097t0r1.ktcast.feature.profile.impl.R
import me.s097t0r1.ktcast.feature.profile.impl.di.ProfileComponentHolder
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.navigation.FillYourProfileNavGraph
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.navigation.FillYourProfileNavigationProvider
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileScreen
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileSideEffect
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui.FillYourProfileUIState
import me.s097t0r1.utils.lifecycle.observeAtLeastStarted
import org.orbitmvi.orbit.compose.collectAsState

internal class FillYourProfileFragment() :
    BaseFragment<FillYourProfileViewModel, FillYourProfileUIState, FillYourProfileSideEffect, FillYourProfileNavGraph>(
        R.layout.profile_feat_fragment_profile_container
    ) {

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri == null) {
            viewModel.alert(AlertSnackBarHost.AlertType.ERROR, getString(R.string.profile_feat_email_placeholder))
            return@registerForActivityResult
        }
        viewModel.onImageSelect(uri)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: FillYourProfileViewModel by viewModels { viewModelFactory }

    override val navigationProvider: NavigationProvider<FillYourProfileNavGraph> by lazy {
        FillYourProfileNavigationProvider()
    }

    override fun onInjectDaggerComponent() {
        ProfileComponentHolder.getDaggerComponent().inject(this)
    }

    override fun onInitViewModel(viewModel: FillYourProfileViewModel) {
        viewModel.onInitViewModel()
        collectSideEffects()
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

    private fun collectSideEffects() {
        observeAtLeastStarted(viewModel.container.sideEffectFlow) { sideEffect ->
            when (sideEffect) {
                is FillYourProfileSideEffect.OpenImagePicker -> openImagePicker()
            }
        }
    }

    private fun openImagePicker() = imagePickerLauncher.launch(IMAGE_MIME_TYPE)

    companion object {
        private const val IMAGE_MIME_TYPE = "image/*"
    }
}

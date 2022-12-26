package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui

import me.s097t0r1.core.mvi.base.state.BaseSideEffect

sealed class FillYourProfileSideEffect : BaseSideEffect {
    object OpenImagePicker : FillYourProfileSideEffect()
}

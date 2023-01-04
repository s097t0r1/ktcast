package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui

import me.s097t0r1.core.mvi.base.state.BaseState

internal data class FillYourProfileUIState(
    val avatarUri: String = "",
    val fieldsState: ProfileFields = ProfileFields(),
    val isContinueEnabled: Boolean = false
) : BaseState

internal data class ProfileFields(
    val fullNameField: StringFieldState = StringFieldState(),
    val nicknameField: StringFieldState = StringFieldState(),
    val birthDayField: StringFieldState = StringFieldState(),
    val emailField: StringFieldState = StringFieldState()
)

internal data class StringFieldState(
    val isError: Boolean = false,
    val value: String = "",
    val errorMsg: String = ""
)


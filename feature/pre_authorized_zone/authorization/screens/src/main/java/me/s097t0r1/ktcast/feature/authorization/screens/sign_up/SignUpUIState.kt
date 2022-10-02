package me.s097t0r1.ktcast.feature.authorization.screens.sign_up

import me.s097t0r1.core.mvi.base.state.BaseState

data class SignUpUIState(
    val isSignUpEnabled: Boolean = false,
    val isRemeberChecked: Boolean = false,
    val emailField: EmailFieldState = EmailFieldState(),
    val passwordField: PasswordFieldState = PasswordFieldState(),
) : BaseState

data class EmailFieldState(
    val isError: Boolean = false,
    val errorMsg: String = "",
    val value: String = ""
)

data class PasswordFieldState(
    val isError: Boolean = false,
    val errorMsg: String = "",
    val value: String = "",
    val isMaskEnabled: Boolean = true,
)

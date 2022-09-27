package me.s097t0r1.ktcast.feature.authorization.screens.sign_in

import me.s097t0r1.core.mvi.base.state.BaseState

data class SignInUIState(
    val emailField: EmailFieldState = EmailFieldState(),
    val passwordFieldState: PasswordFieldState = PasswordFieldState()
) : BaseState

data class EmailFieldState(
    val isError: Boolean = false,
    val errorMessage: String = "",
    val value: String = ""
)

data class PasswordFieldState(
    val isError: Boolean = false,
    val errorMessage: String = "",
    val value: String = ""
)
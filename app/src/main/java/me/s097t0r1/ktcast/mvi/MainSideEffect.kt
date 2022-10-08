package me.s097t0r1.ktcast.mvi

import me.s097t0r1.core.ui_components.components.AlertSnackBarHost


sealed class MainSideEffect {
    object Initial : MainSideEffect()
    class Alert(val alertType: AlertSnackBarHost.AlertType, val message: String) : MainSideEffect()
    object Logout : MainSideEffect()
}
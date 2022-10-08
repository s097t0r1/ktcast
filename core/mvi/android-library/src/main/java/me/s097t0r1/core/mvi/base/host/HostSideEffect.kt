package me.s097t0r1.core.mvi.base.host

import me.s097t0r1.core.mvi.base.state.BaseSideEffect
import me.s097t0r1.core.ui_components.components.AlertSnackBarHost
import me.s097t0r1.ktcast.common.logout.LogoutHandler

sealed class HostSideEffect : BaseSideEffect {
    class Alert(
        val alertType: AlertSnackBarHost.AlertType,
        val message: String
    ) : HostSideEffect()
    class Logout(val logoutType: LogoutHandler.LogoutType) : HostSideEffect()
}

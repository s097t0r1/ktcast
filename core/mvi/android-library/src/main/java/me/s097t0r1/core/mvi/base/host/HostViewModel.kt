package me.s097t0r1.core.mvi.base.host

import androidx.lifecycle.ViewModel
import me.s097t0r1.core.ui_components.components.AlertSnackBarHost
import me.s097t0r1.ktcast.common.logout.LogoutHandler

abstract class HostViewModel : ViewModel() {

    abstract fun alert(alertType: AlertSnackBarHost.AlertType, message: String)

    abstract fun logout(logoutType: LogoutHandler.LogoutType)

}
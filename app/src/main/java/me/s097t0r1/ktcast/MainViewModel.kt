package me.s097t0r1.ktcast

import me.s097t0r1.core.mvi.base.host.HostViewModel
import me.s097t0r1.core.ui_components.components.AlertSnackBarHost
import me.s097t0r1.ktcast.common.logout.LogoutHandler
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.mvi.MainSideEffect
import me.s097t0r1.ktcast.mvi.MainUIState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : HostViewModel(), ContainerHost<MainUIState, MainSideEffect> {

    override val container = container<MainUIState, MainSideEffect>(MainUIState())

    override fun alert(alertType: AlertSnackBarHost.AlertType, message: String) = intent {
        postSideEffect(MainSideEffect.Alert(alertType, message))
    }

    override fun logout(logoutType: LogoutHandler.LogoutType) {
        SecureStorageComponentHolder.get().storage.clear()
    }
}
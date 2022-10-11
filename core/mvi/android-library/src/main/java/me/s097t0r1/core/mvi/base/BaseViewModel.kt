package me.s097t0r1.core.mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.mvi.base.host.HostSideEffect
import me.s097t0r1.core.mvi.base.state.BaseSideEffect
import me.s097t0r1.core.mvi.base.state.BaseState
import me.s097t0r1.core.navigation.base.NavigationGraph
import me.s097t0r1.core.ui_components.components.AlertSnackBarHost
import me.s097t0r1.ktcast.common.logout.LogoutHandler
import org.orbitmvi.orbit.ContainerHost

abstract class BaseViewModel<S : BaseState, E : BaseSideEffect, N : NavigationGraph>(

) : ContainerHost<S, E>, ViewModel() {

    private val _navigation: Channel<N> = Channel(
        capacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val navigation = _navigation.receiveAsFlow()

    private val _hostSideEffect = MutableSharedFlow<HostSideEffect>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val hostSideEffect = _hostSideEffect.asSharedFlow()

    fun onError(exception: AppException) {
        when (exception) {
            is AppException.NetworkException -> {
                when (exception) {
                    is AppException.NetworkException.HttpException -> handleHttpException(exception)
                    else -> {}
                }
            }
            is AppException.LocalException -> {}
        }
    }

    private fun handleHttpException(exception: AppException.NetworkException.HttpException) {
        when (exception.code) {
            AppException.NetworkException.HttpException.UNATHORIZED_CODE -> _hostSideEffect.tryEmit(
                HostSideEffect.Logout(LogoutHandler.LogoutType.SERVER_LOGOUT)
            )
            else -> alert(AlertSnackBarHost.AlertType.ERROR, exception.messages.first())
        }
    }

    protected fun navigateTo(screen: N) {
        viewModelScope.launch { _navigation.send(screen) }
    }

    protected fun alert(alertType: AlertSnackBarHost.AlertType, message: String) {
        _hostSideEffect.tryEmit(HostSideEffect.Alert(alertType, message))
    }

}

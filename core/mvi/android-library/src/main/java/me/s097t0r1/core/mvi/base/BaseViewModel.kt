package me.s097t0r1.core.mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import me.s097t0r1.core.mvi.base.state.BaseSideEffect
import me.s097t0r1.core.mvi.base.state.BaseState
import me.s097t0r1.core.navigation.base.NavigationGraph
import org.orbitmvi.orbit.ContainerHost

abstract class BaseViewModel<S : BaseState, E : BaseSideEffect, N : NavigationGraph>(

) : ContainerHost<S, E>, ViewModel() {

    private val _navigation: Channel<N> = Channel(
        capacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val navigation = _navigation.receiveAsFlow()

    protected fun navigateTo(screen: N): Unit {
        viewModelScope.launch { _navigation.send(screen) }
    }
}

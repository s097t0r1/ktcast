package me.s097t0r1.core.mvvm.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import me.s097t0r1.core.navigation.base.NavigationGraph

abstract class BaseViewModel<N : NavigationGraph> : ViewModel() {

    private val _navigation: Channel<N> =
        Channel(capacity = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
    val navigation = _navigation.receiveAsFlow()

}

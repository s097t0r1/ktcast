package me.s097t0r1.core.mvi.base.host

import androidx.lifecycle.ViewModelProvider

interface HostViewModelOwner {
    val viewModelFactory: ViewModelProvider.Factory
}
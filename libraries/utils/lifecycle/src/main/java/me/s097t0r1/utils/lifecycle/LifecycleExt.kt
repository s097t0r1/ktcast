package me.s097t0r1.utils.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

fun <T> LifecycleOwner.observeAtLeastStarted(flow: Flow<T>, block: suspend (T) -> Unit) {
    this.lifecycleScope.launchWhenCreated { flow.collect(block) }
}
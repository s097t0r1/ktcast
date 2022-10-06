package me.s097t0r1.ktcast.libraries.validator.ext

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import me.s097t0r1.ktcast.libraries.validator.Validator

fun <T> Validator<T>.asFlow() = callbackFlow {
    this@asFlow.setOnValidateListener { this.trySend(it) }
    this.awaitClose { this@asFlow.setOnValidateListener(null) }
}
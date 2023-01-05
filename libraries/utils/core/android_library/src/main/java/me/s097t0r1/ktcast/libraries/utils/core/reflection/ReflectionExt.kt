package me.s097t0r1.ktcast.libraries.utils.core.reflection

inline fun <reified T : Any?> Any?.cast() = this as T

inline fun <reified T : Any?> Any?.safeCast() = this as? T

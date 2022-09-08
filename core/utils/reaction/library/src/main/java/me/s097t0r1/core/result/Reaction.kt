package me.s097t0r1.core.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

sealed class Reaction<out V, out E> {

    abstract operator fun component1(): V?
    abstract operator fun component2(): E?

}

class Ok<out V> private constructor(val value: V) : Reaction<V, Nothing>() {

    override fun component1(): V = value
    override fun component2(): Nothing? = null

    companion object {
        fun <V> of(value: V) = Ok(value)
    }
}

class Err<out E > private constructor(val err: E) : Reaction<Nothing, E>() {
    override fun component1(): Nothing? = null
    override fun component2(): E? = err

    companion object {
        fun <E> of(err: E) = Err(err)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T> catchReaction(block: () -> T): Reaction<T, Throwable> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    return try {
        val value = block()
        Ok.of(value)
    } catch (e: Throwable) {
        Err.of(e)
    }
}
package me.s097t0r1.ktcast.libraries.either

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

sealed class Either<out V, out E> {

    abstract operator fun component1(): V?
    abstract operator fun component2(): E?
}

class Ok<out V> private constructor(val value: V) : Either<V, Nothing>() {

    override fun component1(): V = value
    override fun component2(): Nothing? = null

    companion object {
        fun <V> of(value: V) = Ok(value)
    }
}

class Err<out E > private constructor(val err: E) : Either<Nothing, E>() {
    override fun component1(): Nothing? = null
    override fun component2(): E? = err

    companion object {
        fun <E> of(err: E) = Err(err)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T> catchEither(block: () -> T): Either<T, Throwable> {
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

inline fun <T, E> Either<T, E>.subscribe(
    onSuccess: (value: T) -> Unit,
    onFailure: (exception: E) -> Unit
) {
    return when (this) {
        is Ok -> onSuccess(value)
        is Err -> onFailure(err)
    }
}

inline fun <T, E, R> Either<T, E>.fold(
    onSuccess: (value: T) -> R,
    onFailure: (exception: E) -> R
): R {
    return when (this) {
        is Ok -> onSuccess(value)
        is Err -> onFailure(err)
    }
}

inline fun <T1, T2, E1> Either<T1, E1>.andThen(
    block: (T1) -> Either<T2, E1>,
): Either<T2, E1> {
    return when (this) {
        is Ok -> block(this.value)
        is Err -> Err.of(err)
    }
}

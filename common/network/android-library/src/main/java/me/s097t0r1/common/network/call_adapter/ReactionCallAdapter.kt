package me.s097t0r1.common.network.call_adapter

import java.lang.reflect.Type
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.libraries.either.Either
import retrofit2.Call
import retrofit2.CallAdapter

internal class EitherCallAdapter<V>(
    private val responseType: Type
) : CallAdapter<V, Call<Either<V, AppException.NetworkException>>> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<V>): Call<Either<V, AppException.NetworkException>> {
        return EitherCall(call)
    }
}
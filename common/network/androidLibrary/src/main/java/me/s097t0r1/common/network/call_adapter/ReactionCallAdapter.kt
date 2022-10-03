package me.s097t0r1.common.network.call_adapter

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.result.Reaction
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

internal class ReactionCallAdapter<V>(
    private val responseType: Type
) : CallAdapter<V, Call<Reaction<V, AppException.NetworkException>>> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<V>): Call<Reaction<V, AppException.NetworkException>> {
        return ReactionCall(call)
    }
}
package me.s097t0r1.common.network.call_adapter

import com.squareup.moshi.rawType
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.result.Reaction
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ReactionCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(
            returnType is ParameterizedType
                    && getParameterUpperBound(0, returnType).rawType == Reaction::class.java
        ) {
            "Call must be parametrized like: Call<Reaction<Data>>"
        }

        val reaction = getParameterUpperBound(0, returnType)
        check(reaction is ParameterizedType
                    && getParameterUpperBound(1, reaction)
                .rawType
                .isAssignableFrom(AppException.NetworkException::class.java)
        ) {
            "Reaction must be parameterized like: Reaction<D, AppException.NetworkException>"
        }

        return ReactionCallAdapter<Type>(returnType)
    }
}
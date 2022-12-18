package me.s097t0r1.common.network.call_adapter

import com.squareup.moshi.rawType
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.libraries.either.Either
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit

internal class EitherCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(
            returnType is ParameterizedType
                    && getParameterUpperBound(0, returnType).rawType == Either::class.java
        ) {
            "Call must be parametrized like: Call<Either<Data>>"
        }

        val either = getParameterUpperBound(0, returnType)
        check(either is ParameterizedType
                    && getParameterUpperBound(1, either)
                .rawType
                .isAssignableFrom(AppException.NetworkException::class.java)
        ) {
            "Either must be parameterized like: Either<D, AppException.NetworkException>"
        }

        return EitherCallAdapter<Type>(
            getParameterUpperBound(0, either)
        )
    }
}
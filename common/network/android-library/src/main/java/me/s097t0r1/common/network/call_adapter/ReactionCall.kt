package me.s097t0r1.common.network.call_adapter

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.common.network.utils.deserialize
import me.s097t0r1.ktcast.common.network.utils.model.ErrorResponse
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Err
import me.s097t0r1.ktcast.libraries.either.Ok
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class EitherCall<D>(private val delegate: Call<D>) : Call<Either<D, AppException.NetworkException>> {

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

    override fun clone(): Call<Either<D, AppException.NetworkException>> = EitherCall(delegate)

    override fun execute(): Response<Either<D, AppException.NetworkException>> =
        error("Only async call supported")

    override fun enqueue(callback: Callback<Either<D, AppException.NetworkException>>) {
        delegate.enqueue(object : Callback<D> {
            override fun onResponse(call: Call<D>, response: Response<D>) {
                if (response.isSuccessful) {
                    handleSuccessResponse(callback, response)
                } else {
                    val exception = when (response.errorBody()) {
                        null -> AppException.NetworkException.UnknownException
                        else -> response.toAppException()
                    }
                    callback.onResponse(
                        this@EitherCall,
                        Response.success(Err.of(exception))
                    )
                }
            }

            override fun onFailure(call: Call<D>, t: Throwable) {
                callback.onResponse(
                    this@EitherCall,
                    Response.success(Err.of(t.toAppException()))
                )
            }
        })
    }

    private fun handleSuccessResponse(
        callback: Callback<Either<D, AppException.NetworkException>>,
        response: Response<D>
    ) {
        if (response.body() != null) {
            callback.onResponse(
                this@EitherCall,
                Response.success(Ok.of(response.body()!!))
            )
        } else {
            callback.onResponse(
                this@EitherCall,
                Response.success(
                    Err.of(AppException.NetworkException.UnknownException)
                )
            )
        }
    }

    private fun Response<*>.toAppException(): AppException.NetworkException {
        return when (this.code()) {
            in 400..410 -> AppException.NetworkException.HttpException(
                code = this.code(),
                messages = this.errorBody()
                    ?.string()
                    ?.deserialize<ErrorResponse>()
                    ?.errors ?: emptyList()
            )
            in 500..510 -> AppException.NetworkException.InternalServerException
            else -> AppException.NetworkException.UnknownException
        }
    }

    private fun Throwable.toAppException(): AppException.NetworkException {
        return when(this) {
            is UnknownHostException, is ConnectException ->
                AppException.NetworkException.NoInternetConnectionException

            is SocketTimeoutException -> AppException.NetworkException.TimeoutException

            else -> AppException.NetworkException.UnknownException
        }
    }

}

package me.s097t0r1.common.network.call_adapter

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.result.Err
import me.s097t0r1.core.result.Ok
import me.s097t0r1.core.result.Reaction
import me.s097t0r1.ktcast.common.network.utils.deserialize
import me.s097t0r1.ktcast.common.network.utils.model.ErrorResponse
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

internal class ReactionCall<D>(private val delegate: Call<D>) : Call<Reaction<D, AppException.NetworkException>> {

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

    override fun clone(): Call<Reaction<D, AppException.NetworkException>> = ReactionCall(delegate)

    override fun execute(): Response<Reaction<D, AppException.NetworkException>> =
        error("Only async call supported")

    override fun enqueue(callback: Callback<Reaction<D, AppException.NetworkException>>) {
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
                        this@ReactionCall,
                        Response.success(Err.of(exception))
                    )
                }
            }

            override fun onFailure(call: Call<D>, t: Throwable) {
                callback.onResponse(
                    this@ReactionCall,
                    Response.success(Err.of(t.toAppException()))
                )
            }
        })
    }

    private fun handleSuccessResponse(
        callback: Callback<Reaction<D, AppException.NetworkException>>,
        response: Response<D>
    ) {
        if (response.body() != null) {
            callback.onResponse(
                this@ReactionCall,
                Response.success(Ok.of(response.body()!!))
            )
        } else {
            callback.onResponse(
                this@ReactionCall,
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

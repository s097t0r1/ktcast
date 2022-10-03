package me.s097t0r1.core.exceptions.library

sealed class AppException : Throwable() {
    sealed class NetworkException(override val message: String? = null) : AppException() {
        object NoInternetConnectionException : NetworkException()
        object TimeoutException : NetworkException()
        class HttpException(
            val code: Int,
            val messages: List<String>
        ) : NetworkException()
        object InternalServerException : NetworkException()
        object UnknownException : NetworkException()
    }

    open class Local(override val message: String? = null) : AppException()
}

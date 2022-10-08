package me.s097t0r1.core.exceptions.library

sealed class AppException : Throwable() {
    sealed class NetworkException(override val message: String? = null) : AppException() {
        object NoInternetConnectionException : NetworkException()
        object TimeoutException : NetworkException()
        class HttpException(
            val code: Int,
            val messages: List<String>
        ) : NetworkException() {
            companion object {
                const val UNATHORIZED_CODE = 401
            }
        }
        object InternalServerException : NetworkException()
        object UnknownException : NetworkException()
    }

    open class LocalException(override val message: String? = null) : AppException()
}

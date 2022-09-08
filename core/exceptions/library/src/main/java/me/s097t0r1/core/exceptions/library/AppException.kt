package me.s097t0r1.core.exceptions.library

open class AppException : Throwable() {
    open class NetworkException(override val message: String? = null) : AppException() {
        object NoInternetException : NetworkException()
        object TimeoutException : NetworkException()
        object BadRequestException : NetworkException()
        object InternalServerException : NetworkException()
    }

    open class Local(override val message: String? = null) : AppException()
}

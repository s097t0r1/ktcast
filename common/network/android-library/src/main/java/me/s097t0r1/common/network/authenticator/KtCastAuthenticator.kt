package me.s097t0r1.common.network.authenticator

import com.squareup.moshi.Json
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.runBlocking
import me.s097t0r1.common.network.AUTHORIZATION_HEADER_NAME
import me.s097t0r1.common.network.BEARER_PREFIX
import me.s097t0r1.common.network.Endpoint
import me.s097t0r1.common.network.di.NetworkModule
import me.s097t0r1.common.network.factory.NetworkService
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Ok
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.http.Header
import retrofit2.http.POST

internal class KtCastAuthenticator @Inject constructor(
    @Named(NetworkModule.UNAUTHORIZED)
    private val apiFactory: NetworkServiceFactory,
    private val secureStorage: SecureStorage
) : Authenticator {

    private val authService = apiFactory.create(AuthService::class.java)

    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        val request = response.request.also { response.close() }
        return request.refreshToken()
    }

    private fun Request.refreshToken(): Request? = runBlocking {
        if (secureStorage.webToken == null) return@runBlocking null
        val authReact = authService.tokenUpdate(secureStorage.webToken!!)
        when (authReact) {
            is Ok -> {
                secureStorage.webToken = authReact.value.authToken
                buildAuthorizedRequest(authReact.value.authToken)
            }
            else -> null
        }
    }

    private fun Request.buildAuthorizedRequest(newToken: String): Request {
        return this.newBuilder()
            .addHeader(AUTHORIZATION_HEADER_NAME, "$BEARER_PREFIX $newToken")
            .build()
    }

    private interface AuthService : NetworkService {

        @POST(Endpoint.TOKEN_UPDATE)
        suspend fun tokenUpdate(
            @Header(AUTHORIZATION_HEADER_NAME) token: String
        ): Either<TokenUpdateDTO, AppException.NetworkException>

    }

    private class TokenUpdateDTO(
        @Json(name = "role")
        val role: String,
        @Json(name = "auth_token")
        val authToken: String
    )

}
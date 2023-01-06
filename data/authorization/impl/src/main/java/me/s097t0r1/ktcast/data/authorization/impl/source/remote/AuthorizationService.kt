package me.s097t0r1.ktcast.data.authorization.impl.source.remote

import me.s097t0r1.common.network.Endpoint
import me.s097t0r1.common.network.factory.NetworkService
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.RemoteTokenRequest
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.RemoteToken
import me.s097t0r1.ktcast.libraries.either.Either
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

internal interface AuthorizationService : NetworkService {

    @POST(Endpoint.USER_LOGIN)
    suspend fun signIn(
        @Body body: RemoteTokenRequest,
        @Path("username") username: String
    ): Either<RemoteToken, AppException>
}
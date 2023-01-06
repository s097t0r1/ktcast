package me.s097t0r1.ktcast.data.authorization.impl.source.remote

import javax.inject.Inject
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.common.network.factory.create
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.RemoteTokenRequest
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.RemoteToken
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Err

internal interface AuthorizationRemoteDataSource {

    suspend fun signIn(tokenRequestDTO: RemoteTokenRequest): Either<RemoteToken, AppException>

    suspend fun signUp(tokenRequestDTO: RemoteTokenRequest): Either<Unit, AppException>

    class Base @Inject constructor(
        serviceFactory: NetworkServiceFactory
    ) : AuthorizationRemoteDataSource {

        private val service = serviceFactory.create<AuthorizationService>()

        override suspend fun signIn(tokenRequestDTO: RemoteTokenRequest): Either<RemoteToken, AppException> {
            return service.signIn(tokenRequestDTO, tokenRequestDTO.login)
        }

        override suspend fun signUp(tokenRequestDTO: RemoteTokenRequest): Either<Unit, AppException> {
            return Err.of(AppException.LocalException())
        }

    }

}
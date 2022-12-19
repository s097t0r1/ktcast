package me.s097t0r1.ktcast.data.authorization.impl.source.remote

import javax.inject.Inject
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.common.network.factory.create
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.TokenRequestDTO
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.TokenResponseDTO
import me.s097t0r1.ktcast.libraries.either.Either

internal interface AuthorizationRemoteDataSource {

    suspend fun signIn(tokenRequestDTO: TokenRequestDTO): Either<TokenResponseDTO, AppException>

    suspend fun signUp(tokenRequestDTO: TokenRequestDTO): Either<Unit, AppException>

    class Base @Inject constructor(
        serviceFactory: NetworkServiceFactory
    ) : AuthorizationRemoteDataSource {

        private val service = serviceFactory.create<AuthorizationService>()

        override suspend fun signIn(tokenRequestDTO: TokenRequestDTO): Either<TokenResponseDTO, AppException> {
            return service.signIn(tokenRequestDTO)
        }

        override suspend fun signUp(tokenRequestDTO: TokenRequestDTO): Either<Unit, AppException> {
            return service.signUp(tokenRequestDTO)
        }

    }

}
package me.s097t0r1.ktcast.data.authorization.impl.source.remote

import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.common.network.factory.create
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.TokenRequestDTO
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.TokenResponseDTO
import me.s097t0r1.ktcast.libraries.reaction.Reaction
import javax.inject.Inject

internal interface AuthorizationRemoteDataSource {

    suspend fun signIn(tokenRequestDTO: TokenRequestDTO): Reaction<TokenResponseDTO, AppException>

    suspend fun signUp(tokenRequestDTO: TokenRequestDTO): Reaction<Unit, AppException>

    class Base @Inject constructor(
        serviceFactory: NetworkServiceFactory
    ) : AuthorizationRemoteDataSource {

        private val service = serviceFactory.create<AuthorizationService>()

        override suspend fun signIn(tokenRequestDTO: TokenRequestDTO): Reaction<TokenResponseDTO, AppException> {
            return service.signIn(tokenRequestDTO)
        }

        override suspend fun signUp(tokenRequestDTO: TokenRequestDTO): Reaction<Unit, AppException> {
            return service.signUp(tokenRequestDTO)
        }
    }
}

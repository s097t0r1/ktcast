package me.s097t0r1.ktcast.data.authorization.impl.source.remote

import me.s097t0r1.common.network.Endpoint
import me.s097t0r1.common.network.factory.NetworkService
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.TokenRequestDTO
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.TokenResponseDTO
import me.s097t0r1.ktcast.libraries.either.Either
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthorizationService : NetworkService {

    @POST(Endpoint.TOKEN)
    suspend fun signIn(@Body requestDTO: TokenRequestDTO): Either<TokenResponseDTO, AppException>

    @POST(Endpoint.USERS)
    suspend fun signUp(@Body requestDTO: TokenRequestDTO): Either<Unit, AppException>

}
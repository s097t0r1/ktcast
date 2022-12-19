package me.s097t0r1.ktcast.data.authorization.impl.repository

import javax.inject.Inject
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.api.model.domain.AuthInfo
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.data.authorization.impl.mapper.AuthInfoMapper
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.request.TokenRequestDTO
import me.s097t0r1.ktcast.data.authorization.impl.source.remote.AuthorizationRemoteDataSource
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Err
import me.s097t0r1.ktcast.libraries.either.Ok
import me.s097t0r1.ktcast.libraries.mapper.createMapper

internal class AuthorizationRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthorizationRemoteDataSource
) : AuthorizationRepository {

    override suspend fun signIn(params: SignInParams): Either<AuthInfo, AppException> {
        val react = remoteDataSource.signIn(
            TokenRequestDTO(
                login = params.login,
                password = params.password
            )
        )
        return when (react) {
            is Ok -> Ok.of(createMapper<AuthInfoMapper>().map(react.value))
            is Err -> react
        }
    }

    override suspend fun signUp(params: SignInParams): Either<Unit, AppException> {
        return remoteDataSource.signUp(
            TokenRequestDTO(
                login = params.login,
                password = params.password
            )
        )
    }
}
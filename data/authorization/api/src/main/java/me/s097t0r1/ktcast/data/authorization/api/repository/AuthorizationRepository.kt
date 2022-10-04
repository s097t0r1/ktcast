package me.s097t0r1.ktcast.data.authorization.api.repository

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.result.Reaction
import me.s097t0r1.ktcast.data.authorization.api.model.domain.AuthInfo
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams

interface AuthorizationRepository {

    suspend fun signIn(params: SignInParams): Reaction<AuthInfo, AppException>

    suspend fun signUp(params: SignInParams): Reaction<Unit, AppException>

}
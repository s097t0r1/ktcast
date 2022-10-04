package me.s097t0r1.ktcast.feature.authorization.impl.domain

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.core.result.Reaction
import me.s097t0r1.ktcast.data.authorization.api.model.domain.AuthInfo
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import javax.inject.Inject

class SignInInteractor @Inject constructor(
    private val repository: AuthorizationRepository
) {

    suspend fun signIn(login: String, password: String): Reaction<AuthInfo, AppException> {
        return repository.signIn(SignInParams(login, password))
    }

}
package me.s097t0r1.ktcast.feature.authorization.impl.domain

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.libraries.reaction.Reaction
import javax.inject.Inject

class SignUpInteractor @Inject constructor(
    private val repository: AuthorizationRepository
) {

    suspend fun signUp(login: String, password: String): Reaction<Unit, AppException> {
        return repository.signUp(SignInParams(login, password))
    }

}
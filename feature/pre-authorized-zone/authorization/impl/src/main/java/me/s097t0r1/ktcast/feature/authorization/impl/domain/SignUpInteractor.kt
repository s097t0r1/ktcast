package me.s097t0r1.ktcast.feature.authorization.impl.domain

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.common.secure_storage.storage.Role
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.libraries.reaction.Err
import me.s097t0r1.ktcast.libraries.reaction.Ok
import me.s097t0r1.ktcast.libraries.reaction.Reaction
import me.s097t0r1.ktcast.libraries.reaction.fold
import javax.inject.Inject

class SignUpInteractor @Inject constructor(
    private val repository: AuthorizationRepository,
    private val secureStorage: SecureStorage
) {

    suspend fun signUp(login: String, password: String): Reaction<Unit, AppException> {
        return repository.signUp(SignInParams(login, password)).fold(
            onSuccess = { startSession(login, password) },
            onFailure = { Err.of(it) }
        )
    }

    private suspend fun startSession(login: String, password: String): Reaction<Unit, AppException> {
        return repository.signIn(SignInParams(login, password)).fold(
            onSuccess = {
                secureStorage.webToken = it.token
                secureStorage.role = Role.valueOf(it.role)
                Ok.of(Unit)
            },
            onFailure = { Err.of(it) }
        )
    }

}
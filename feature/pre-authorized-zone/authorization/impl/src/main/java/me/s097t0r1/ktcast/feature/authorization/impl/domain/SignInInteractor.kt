package me.s097t0r1.ktcast.feature.authorization.impl.domain

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.libraries.reaction.Err
import me.s097t0r1.ktcast.libraries.reaction.Ok
import me.s097t0r1.ktcast.libraries.reaction.Reaction
import me.s097t0r1.ktcast.libraries.reaction.fold
import javax.inject.Inject

class SignInInteractor @Inject constructor(
    private val repository: AuthorizationRepository
) {

    suspend fun signIn(login: String, password: String): Reaction<Unit, AppException> {
        return repository.signIn(SignInParams(login, password))
            .fold(
                onSuccess = { Ok.of(Unit) },
                onFailure = { Err.of(it) }
            )
    }

    suspend fun getProfile() {
        return
    }

    suspend fun checkProfileIsEmpty() {

    }

}
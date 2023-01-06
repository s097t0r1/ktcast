package me.s097t0r1.ktcast.feature.authorization.impl.domain

import javax.inject.Inject
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.common.secure_storage.storage.Role
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.data.authorization.api.model.param.SignInParams
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Ok
import me.s097t0r1.ktcast.libraries.either.andThen

class SignInInteractor @Inject constructor(
    private val repository: AuthorizationRepository,
    private val secureStorage: SecureStorage
) {

    suspend fun signIn(login: String, password: String): Either<Unit, AppException> {
        return repository.signIn(SignInParams(login, password))
            .andThen {
                secureStorage.webToken = it.token
                secureStorage.role = Role.valueOf(it.role)
                Ok.of(Unit)
            }
    }
}

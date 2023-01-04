package me.s097t0r1.ktcast.feature.profile.impl.domain

import javax.inject.Inject
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.api.ProfileRepository
import me.s097t0r1.ktcast.data.profile.api.model.Profile
import me.s097t0r1.ktcast.libraries.either.Either

class FillYourProfileInteractor @Inject constructor(
    private val repository: ProfileRepository
) {

    suspend fun getProfile(): Either<Profile, AppException> = repository.getProfile()
}

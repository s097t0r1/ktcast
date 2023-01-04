package me.s097t0r1.ktcast.data.profile.api

import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.api.model.Profile
import me.s097t0r1.ktcast.libraries.either.Either

interface ProfileRepository {

    suspend fun getProfile(): Either<Profile, AppException>

    suspend fun updateProfile(profile: Profile): Either<Unit, AppException>
}

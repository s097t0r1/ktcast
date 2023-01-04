package me.s097t0r1.ktcast.data.profile.impl.source

import javax.inject.Inject
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.impl.model.local.LocalProfile
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Err
import me.s097t0r1.ktcast.libraries.either.Ok
import me.s097t0r1.ktcast.libraries.either.catchEither
import me.s097t0r1.ktcast.libraries.either.mapError
import me.s097t0r1.shelf.Shelf
import me.s097t0r1.shelf.get

interface ProfileLocalDataSource {

    fun getProfile(): Either<LocalProfile, AppException.LocalException>

    fun updateProfile(profile: LocalProfile): Either<Unit, AppException.LocalException>

    fun resetProfile(): Either<Unit, AppException.LocalException>

    class Base @Inject constructor(
        private val shelf: Shelf
    ) : ProfileLocalDataSource {

        override fun getProfile(): Either<LocalProfile, AppException.LocalException> =
            shelf.item(PROFILE_SHELF_KEY).get<LocalProfile>()?.let { Ok.of(it) }
                ?: Err.of(AppException.LocalException())

        override fun updateProfile(profile: LocalProfile) = catchEither {
            shelf.item(PROFILE_SHELF_KEY).put(profile)
            return@catchEither
        }.mapError { AppException.LocalException() }

        override fun resetProfile() = catchEither {
            shelf.item(PROFILE_SHELF_KEY).remove()
            return@catchEither
        }.mapError { AppException.LocalException() }

        companion object {
            private const val PROFILE_SHELF_KEY = "SHELF_PROFILE_KEY"
        }
    }
}

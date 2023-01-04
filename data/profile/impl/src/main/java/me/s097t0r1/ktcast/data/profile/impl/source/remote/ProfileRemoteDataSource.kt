package me.s097t0r1.ktcast.data.profile.impl.source

import javax.inject.Inject
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.common.network.factory.create
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.impl.model.remote.RemoteProfile
import me.s097t0r1.ktcast.data.profile.impl.source.remote.ProfileService
import me.s097t0r1.ktcast.libraries.either.Either

interface ProfileRemoteDataSource {

    suspend fun getProfile(): Either<RemoteProfile, AppException>

    suspend fun updateProfile(profile: RemoteProfile): Either<Unit, AppException>

    class Base @Inject constructor(
        serviceFactory: NetworkServiceFactory
    ) : ProfileRemoteDataSource {

        private val service = serviceFactory.create<ProfileService>()

        override suspend fun getProfile(): Either<RemoteProfile, AppException> = service.getProfile()

        override suspend fun updateProfile(profile: RemoteProfile): Either<Unit, AppException> = service.updateProfile()
    }
}

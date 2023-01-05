package me.s097t0r1.ktcast.data.profile.impl.source.remote

import me.s097t0r1.common.network.Endpoint
import me.s097t0r1.common.network.factory.NetworkService
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.impl.model.remote.RemoteProfile
import me.s097t0r1.ktcast.libraries.either.Either
import retrofit2.http.GET

interface ProfileService : NetworkService {

    @GET(Endpoint.PROFILE)
    suspend fun getProfile(): Either<RemoteProfile, AppException.NetworkException>

    @GET(Endpoint.PROFILE)
    suspend fun updateProfile(): Either<Unit, AppException.NetworkException>
}

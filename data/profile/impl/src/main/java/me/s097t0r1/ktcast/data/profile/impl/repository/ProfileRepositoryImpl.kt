package me.s097t0r1.ktcast.data.profile.impl.repository

import javax.inject.Inject
import me.s097t0r1.core.exceptions.library.AppException
import me.s097t0r1.ktcast.data.profile.api.ProfileRepository
import me.s097t0r1.ktcast.data.profile.api.model.Profile
import me.s097t0r1.ktcast.data.profile.impl.model.local.mapper.ProfileDToLMapper
import me.s097t0r1.ktcast.data.profile.impl.model.local.mapper.ProfileLToDMapper
import me.s097t0r1.ktcast.data.profile.impl.model.remote.mapper.ProfileDToRMapper
import me.s097t0r1.ktcast.data.profile.impl.model.remote.mapper.ProfileRToDMapper
import me.s097t0r1.ktcast.data.profile.impl.source.ProfileLocalDataSource
import me.s097t0r1.ktcast.data.profile.impl.source.ProfileRemoteDataSource
import me.s097t0r1.ktcast.libraries.either.Either
import me.s097t0r1.ktcast.libraries.either.Ok
import me.s097t0r1.ktcast.libraries.either.andThen
import me.s097t0r1.ktcast.libraries.either.fold
import me.s097t0r1.ktcast.libraries.mapper.createMapper

class ProfileRepositoryImpl @Inject constructor(
    private val localDataSource: ProfileLocalDataSource,
    private val remoteDataSource: ProfileRemoteDataSource
) : ProfileRepository {

    override suspend fun getProfile(): Either<Profile, AppException> {
        return localDataSource.getProfile()
            .fold(
                onSuccess = { return@fold Ok.of(createMapper<ProfileLToDMapper>().map(it)) },
                onFailure = {
                    remoteDataSource.getProfile()
                        .andThen { Ok.of(createMapper<ProfileRToDMapper>().map(it)) }
                }
            )
    }

    override suspend fun updateProfile(profile: Profile): Either<Unit, AppException> {
        val localMapper = createMapper<ProfileDToLMapper>()
        val remoteMapper = createMapper<ProfileDToRMapper>()
        return remoteDataSource.updateProfile(remoteMapper.map(profile))
            .andThen { localDataSource.updateProfile(localMapper.map(profile)) }
    }
}

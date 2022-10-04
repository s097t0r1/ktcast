package me.s097t0r1.ktcast.data.authorization.impl.di

import dagger.Binds
import dagger.Module
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.data.authorization.impl.repository.AuthorizationRepositoryImpl
import me.s097t0r1.ktcast.data.authorization.impl.source.remote.AuthorizationRemoteDataSource

@Module
internal interface AuthorizationModule {

    @Binds
    fun bindRepository(
        repo: AuthorizationRepositoryImpl
    ): AuthorizationRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: AuthorizationRemoteDataSource.Base
    ): AuthorizationRemoteDataSource
}
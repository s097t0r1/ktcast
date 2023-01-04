package me.s097t0r1.ktcast.data.profile.impl.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.s097t0r1.core.di.base.scope.FeatureScope
import me.s097t0r1.ktcast.data.profile.api.ProfileRepository
import me.s097t0r1.ktcast.data.profile.impl.repository.ProfileRepositoryImpl
import me.s097t0r1.ktcast.data.profile.impl.source.ProfileLocalDataSource
import me.s097t0r1.ktcast.data.profile.impl.source.ProfileRemoteDataSource
import me.s097t0r1.shelf.Shelf

@Module
internal abstract class ProfileDataModule {

    @Binds
    abstract fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    abstract fun bindLocalDataSource(impl: ProfileLocalDataSource.Base): ProfileLocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(impl: ProfileRemoteDataSource.Base): ProfileRemoteDataSource


    companion object {

        @Provides
        @FeatureScope
        fun provideShelf(context: Context): Shelf = Shelf.create(context)
    }
}
package me.s097t0r1.ktcast.common.secure_storage.di

import dagger.Binds
import dagger.Module
import me.s097t0r1.ktcast.common.secure_storage.storage.AndroidSecureStorage
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import javax.inject.Singleton

@Module
internal interface SecureStorageModule {

    @Binds
    @Singleton
    fun bindSecureStorage(secureStorage: AndroidSecureStorage): SecureStorage
}
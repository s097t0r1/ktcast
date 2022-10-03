package me.s097t0r1.ktcast.common.secure_storage.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [SecureStorageDependencies::class],
    modules = [SecureStorageModule::class]
)
internal interface SecureStorageComponent : SecureStorageAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: SecureStorageDependencies): SecureStorageComponent
    }
}
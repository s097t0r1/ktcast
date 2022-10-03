package me.s097t0r1.ktcast.common.secure_storage.di

import me.s097t0r1.core.di.base.BaseComponentHolder

object SecureStorageComponentHolder : BaseComponentHolder<SecureStorageAPI, SecureStorageDependencies>() {

    override fun initComponent(dependencies: SecureStorageDependencies): SecureStorageAPI =
        DaggerSecureStorageComponent.factory().create(dependencies)

}
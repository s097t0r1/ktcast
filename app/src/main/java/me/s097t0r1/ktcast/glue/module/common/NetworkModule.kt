package me.s097t0r1.ktcast.glue.module.common

import me.s097t0r1.common.network.di.NetworkComponentHolder
import me.s097t0r1.common.network.di.NetworkDependencies
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder1
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage

internal fun glueNetworkModule() {

    NetworkComponentHolder.provider = Provider {
         BaseDependencyHolder1.create(
             a1 = SecureStorageComponentHolder.get()
         ) { secureStorageAPI, dh ->
             object : NetworkDependencies {
                 override val secureStorage: SecureStorage = secureStorageAPI.storage
                 override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dh
             }
         }
    }

}
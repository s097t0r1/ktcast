package me.s097t0r1.ktcast.glue.module.common

import me.s097t0r1.common.network.di.NetworkComponentHolder
import me.s097t0r1.common.network.di.NetworkDependencies
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder1
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage

@ComponentHolder(1)
internal fun glueNetworkModule() {
    NetworkComponentHolder.provider = Provider {
        BaseDependencyHolder1.create(
            a0 = SecureStorageComponentHolder.get()
        ) { secureStorageAPI, dh ->
            object : NetworkDependencies {
                override val secureStorage: SecureStorage = secureStorageAPI.storage
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dh
            }
        }
    }
}

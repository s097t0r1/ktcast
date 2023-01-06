package me.s097t0r1.ktcast.glue.module.common

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder0
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageDependencies

@ComponentHolder(0)
internal fun glueSecureStorage(applicationContext: Context) {
    SecureStorageComponentHolder.provider = Provider {
        BaseDependencyHolder0.create {
            object : SecureStorageDependencies {
                override val context: Context = applicationContext
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = it
            }
        }
    }
}

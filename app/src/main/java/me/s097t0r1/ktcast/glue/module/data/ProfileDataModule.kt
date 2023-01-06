package me.s097t0r1.ktcast.glue.module.data

import android.content.Context
import me.s097t0r1.common.network.di.NetworkComponentHolder
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder1
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.data.profile.api.ProfileDataDependencies
import me.s097t0r1.ktcast.data.profile.impl.di.ProfileDataComponentHolder

@ComponentHolder(1)
fun glueProfileDataModule(context: Context) {
    ProfileDataComponentHolder.provider = Provider {
        BaseDependencyHolder1.create(
            a0 = NetworkComponentHolder.get(),
        ) { networkAPI, dh ->
            object : ProfileDataDependencies {
                override val context: Context = context
                override val networkServiceFactory: NetworkServiceFactory = networkAPI.authorizedServiceFactory
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dh
            }
        }
    }
}

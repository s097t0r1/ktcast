package me.s097t0r1.ktcast.glue.module.data

import me.s097t0r1.common.network.di.NetworkComponentHolder
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder2
import me.s097t0r1.ktcast.data.authorization.api.AuthorizationDataDependencies
import me.s097t0r1.ktcast.data.authorization.impl.di.AuthorizationDataComponentHolder
import me.s097t0r1.persistence.database.di.DatabaseComponentHolder

fun glueAuthModule() {
    AuthorizationDataComponentHolder.provider = Provider {
        BaseDependencyHolder2.create(
            a1 = NetworkComponentHolder.get(),
            a2 = DatabaseComponentHolder.get()
        ) { networkAPI, databaseAPI, baseDependencyHolder ->
            object : AuthorizationDataDependencies {
                override val networkServiceFactory: NetworkServiceFactory = networkAPI.unauthorizedServiceFactory
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = baseDependencyHolder
            }
        }
    }
}
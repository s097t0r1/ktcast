package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder2
import me.s097t0r1.ktcast.KtCastApplication
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.data.authorization.impl.di.AuthorizationDataComponentHolder
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureDependencies
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

fun glueAuthFeature() {
    AuthorizationComponentHolder.provider = Provider {
        BaseDependencyHolder2.create(
            a1 = AuthorizationDataComponentHolder.get(),
            a2 = SecureStorageComponentHolder.get()
        ) { authDataAPI, secureStorageAPI, dependencyHolder ->
            object : AuthorizationFeatureDependencies {
                override val resourceProvider: ResourceProvider = KtCastApplication.INSTANCE.component.getResourceProvider()
                override val authorizationRepository: AuthorizationRepository = authDataAPI.repository
                override val secureStorage: SecureStorage = secureStorageAPI.storage
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
            }
        }
    }
}
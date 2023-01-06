package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder3
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.di.SecureStorageComponentHolder
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.data.authorization.impl.di.AuthorizationDataComponentHolder
import me.s097t0r1.ktcast.di.ApplicationComponentHolder
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureDependencies
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureStarter
import me.s097t0r1.ktcast.feature.profile.impl.di.ProfileComponentHolder
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

@ComponentHolder(3)
fun glueAuthFeature() {
    AuthorizationComponentHolder.provider = Provider {
        BaseDependencyHolder3.create(
            a0 = AuthorizationDataComponentHolder.get(),
            a1 = SecureStorageComponentHolder.get(),
            a2 = ProfileComponentHolder.get()
        ) { authDataAPI, secureStorageAPI, profileFeatAPI, dependencyHolder ->
            object : AuthorizationFeatureDependencies {
                override val resourceProvider: ResourceProvider = ApplicationComponentHolder.getDaggerComponent().getResourceProvider()
                override val authorizationRepository: AuthorizationRepository = authDataAPI.repository
                override val secureStorage: SecureStorage = secureStorageAPI.storage
                override val profileStarter: ProfileFeatureStarter = profileFeatAPI.starter
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
            }
        }
    }
}
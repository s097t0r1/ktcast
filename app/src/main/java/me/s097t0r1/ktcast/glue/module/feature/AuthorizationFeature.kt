package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder1
import me.s097t0r1.ktcast.KtCastApplication
import me.s097t0r1.ktcast.core.utils.resource_provider.ResourceProvider
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.data.authorization.impl.di.AuthorizationDataComponentHolder
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureDependencies
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder

fun glueAuthFeature() {
    AuthorizationComponentHolder.provider = Provider {
        BaseDependencyHolder1.create(
            a1 = AuthorizationDataComponentHolder.get()
        ) { authDataAPI, dependencyHolder ->
            object : AuthorizationFeatureDependencies {
                override val resourceProvider: ResourceProvider = KtCastApplication.INSTANCE.component.getResourceProvider()
                override val authorizationRepository: AuthorizationRepository = authDataAPI.repository
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDepenendencies> = dependencyHolder
            }
        }
    }
}
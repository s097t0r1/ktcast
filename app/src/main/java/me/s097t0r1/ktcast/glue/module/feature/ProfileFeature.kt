package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder0
import me.s097t0r1.ktcast.di.ApplicationComponentHolder
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureDependencies
import me.s097t0r1.ktcast.feature.profile.impl.di.ProfileComponentHolder
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

fun glueProfileFeature() {
    ProfileComponentHolder.provider = Provider {
        BaseDependencyHolder0.create {
            object : ProfileFeatureDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = it
                override val resProvider: ResourceProvider =
                    ApplicationComponentHolder.getDaggerComponent().getResourceProvider()
            }
        }
    }
}

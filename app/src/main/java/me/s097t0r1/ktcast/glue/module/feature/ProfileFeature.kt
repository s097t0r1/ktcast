package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder1
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.data.profile.api.ProfileRepository
import me.s097t0r1.ktcast.data.profile.impl.di.ProfileDataComponentHolder
import me.s097t0r1.ktcast.di.ApplicationComponentHolder
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureDependencies
import me.s097t0r1.ktcast.feature.profile.impl.di.ProfileComponentHolder
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

@ComponentHolder(1)
fun glueProfileFeature() {
    ProfileComponentHolder.provider = Provider {
        BaseDependencyHolder1.create(
            a0 = ProfileDataComponentHolder.get()
        ) { profileApi, dh ->
            object : ProfileFeatureDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dh
                override val resProvider: ResourceProvider =
                    ApplicationComponentHolder.getDaggerComponent().getResourceProvider()
                override val profileRepository: ProfileRepository = profileApi.repository
            }
        }
    }
}

package me.s097t0r1.ktcast.feature.profile.api

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.ktcast.data.profile.api.ProfileRepository
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

interface ProfileFeatureDependencies : BaseFeatureDependencies {
    val resProvider: ResourceProvider
    val profileRepository: ProfileRepository
}
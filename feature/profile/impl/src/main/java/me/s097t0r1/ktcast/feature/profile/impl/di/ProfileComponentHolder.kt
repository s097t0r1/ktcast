package me.s097t0r1.ktcast.feature.profile.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureAPI
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureDependencies

object ProfileComponentHolder : BaseComponentHolder<ProfileFeatureAPI, ProfileFeatureDependencies>() {

    override fun initComponent(dependencies: ProfileFeatureDependencies): ProfileFeatureAPI =
        DaggerProfileComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as ProfileComponent
}

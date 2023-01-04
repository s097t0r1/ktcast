package me.s097t0r1.ktcast.data.profile.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import me.s097t0r1.ktcast.data.profile.api.ProfileDataAPI
import me.s097t0r1.ktcast.data.profile.api.ProfileDataDependencies

object ProfileDataComponentHolder : BaseComponentHolder<ProfileDataAPI, ProfileDataDependencies>() {

    override fun initComponent(dependencies: ProfileDataDependencies): ProfileDataAPI =
        DaggerProfileDataComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as ProfileDataComponent
}
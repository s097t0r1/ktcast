package me.s097t0r1.common.network.di

import me.s097t0r1.core.di.base.BaseComponentHolder

object NetworkComponentHolder :
    BaseComponentHolder<NetworkAPI, NetworkDependencies, NetworkComponent>() {

    override fun initComponent(dependencies: NetworkDependencies): NetworkComponent =
        DaggerNetworkComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent()
}
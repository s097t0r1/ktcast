package me.s097t0r1.common.network.di

import dagger.Component

@Component(
    dependencies = [NetworkDependencies::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: NetworkDependencies): NetworkComponent
    }

}
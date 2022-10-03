package me.s097t0r1.common.network.di

import dagger.Component
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [NetworkDependencies::class],
    modules = [NetworkModule::class]
)
internal interface NetworkComponent : NetworkAPI {

    @get:Named(NetworkModule.AUTHORIZED)
    override val authorizedServiceFactory: NetworkServiceFactory

    @get:Named(NetworkModule.UNAUTHORIZED)
    override val unauthorizedServiceFactory: NetworkServiceFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: NetworkDependencies): NetworkComponent
    }

}
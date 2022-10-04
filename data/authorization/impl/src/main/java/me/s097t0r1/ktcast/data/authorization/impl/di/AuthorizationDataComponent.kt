package me.s097t0r1.ktcast.data.authorization.impl.di

import dagger.Component
import me.s097t0r1.ktcast.data.authorization.api.AuthorizationDataAPI
import me.s097t0r1.ktcast.data.authorization.api.AuthorizationDataDependencies

@Component(
    modules = [AuthorizationModule::class],
    dependencies = [AuthorizationDataDependencies::class]
)
internal interface AuthorizationDataComponent : AuthorizationDataAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: AuthorizationDataDependencies): AuthorizationDataComponent
    }

}
package me.s097t0r1.ktcast.data.authorization.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import me.s097t0r1.ktcast.data.authorization.api.AuthorizationDataAPI
import me.s097t0r1.ktcast.data.authorization.api.AuthorizationDataDependencies

object AuthorizationDataComponentHolder : BaseComponentHolder<AuthorizationDataAPI, AuthorizationDataDependencies>() {

    override fun initComponent(dependencies: AuthorizationDataDependencies): AuthorizationDataAPI =
        DaggerAuthorizationDataComponent.factory().create(dependencies)
}
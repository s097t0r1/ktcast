package me.s097t0r1.ktcast.feature.authorization.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureAPI
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureDependencies

object AuthorizationComponentHolder : BaseComponentHolder<AuthorizationFeatureAPI, AuthorizationFeatureDependencies>() {

    override fun initComponent(dependencies: AuthorizationFeatureDependencies): AuthorizationFeatureAPI =
        DaggerAuthorizationComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as AuthorizationComponent
}
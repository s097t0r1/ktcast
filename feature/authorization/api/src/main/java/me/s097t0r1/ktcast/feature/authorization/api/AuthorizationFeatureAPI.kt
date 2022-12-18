package me.s097t0r1.ktcast.feature.authorization.api

import me.s097t0r1.core.di.base.BaseFeatureAPI

interface AuthorizationFeatureAPI : BaseFeatureAPI {
    val starter: AuthorizationFeatureStarter
}
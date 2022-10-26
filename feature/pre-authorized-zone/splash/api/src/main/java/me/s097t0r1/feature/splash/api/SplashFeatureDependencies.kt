package me.s097t0r1.feature.splash.api

import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter

interface SplashFeatureDependencies : BaseFeatureDepenendencies {
    val authStarter: AuthorizationFeatureStarter
}

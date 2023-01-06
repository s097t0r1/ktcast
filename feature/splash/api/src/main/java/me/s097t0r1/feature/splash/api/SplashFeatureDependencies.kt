package me.s097t0r1.feature.splash.api

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter

interface SplashFeatureDependencies : BaseFeatureDependencies {
    val authStarter: AuthorizationFeatureStarter
}
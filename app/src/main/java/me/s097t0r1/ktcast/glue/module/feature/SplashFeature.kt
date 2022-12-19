package me.s097t0r1.ktcast.glue.module.feature

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder1
import me.s097t0r1.feature.splash.api.SplashFeatureDependencies
import me.s097t0r1.feature.splash.impl.di.SplashComponentHolder
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter
import me.s097t0r1.ktcast.feature.authorization.impl.di.AuthorizationComponentHolder

fun glueSplashFeature() {
    SplashComponentHolder.provider = Provider {
        return@Provider BaseDependencyHolder1.create(
            a1 = AuthorizationComponentHolder.get()
        ) { authApi, depsHolder ->
            object : SplashFeatureDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = depsHolder
                override val authStarter: AuthorizationFeatureStarter = authApi.starter
            }
        }
    }
}
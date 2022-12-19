package me.s097t0r1.ktcast.data.authorization.api

import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureDependencies

interface AuthorizationDataDependencies : BaseFeatureDependencies {
    val networkServiceFactory: NetworkServiceFactory
}
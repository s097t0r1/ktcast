package me.s097t0r1.ktcast.data.authorization.api

import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureDepenendencies

interface AuthorizationDataDependencies : BaseFeatureDepenendencies {
    val networkServiceFactory: NetworkServiceFactory
}
package me.s097t0r1.common.network.di

import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureAPI

interface NetworkAPI : BaseFeatureAPI {
    val authorizedServiceFactory: NetworkServiceFactory
    val unauthorizedServiceFactory: NetworkServiceFactory
}
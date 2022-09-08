package me.s097t0r1.common.network.di

import me.s097t0r1.common.network.service.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureAPI

interface NetworkAPI : BaseFeatureAPI {
    val serviceFactory: NetworkServiceFactory
}
package me.s097t0r1.ktcast.feature.authorization.api

import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.ktcast.core.utils.resource_provider.ResourceProvider

interface AuthorizationFeatureDependencies : BaseFeatureDepenendencies{
    val resourceProvider: ResourceProvider
}
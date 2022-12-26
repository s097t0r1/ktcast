package me.s097t0r1.ktcast.di

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

interface ApplicationAPI : BaseFeatureAPI {
    fun getResourceProvider(): ResourceProvider
}
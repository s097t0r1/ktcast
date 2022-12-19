package me.s097t0r1.ktcast.feature.authorization.api

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

interface AuthorizationFeatureDependencies : BaseFeatureDependencies {
    val resourceProvider: ResourceProvider
    val authorizationRepository: AuthorizationRepository
    val secureStorage: SecureStorage
}
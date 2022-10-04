package me.s097t0r1.ktcast.data.authorization.api

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.ktcast.data.authorization.api.repository.AuthorizationRepository

interface AuthorizationDataAPI : BaseFeatureAPI {
    val repository: AuthorizationRepository
}
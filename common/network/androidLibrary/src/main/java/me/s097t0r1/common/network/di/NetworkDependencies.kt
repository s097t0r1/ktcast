package me.s097t0r1.common.network.di

import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage

interface NetworkDependencies : BaseFeatureDepenendencies {
    val secureStorage: SecureStorage
}
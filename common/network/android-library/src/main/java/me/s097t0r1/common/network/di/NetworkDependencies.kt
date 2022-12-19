package me.s097t0r1.common.network.di

import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage

interface NetworkDependencies : BaseFeatureDependencies {
    val secureStorage: SecureStorage
}
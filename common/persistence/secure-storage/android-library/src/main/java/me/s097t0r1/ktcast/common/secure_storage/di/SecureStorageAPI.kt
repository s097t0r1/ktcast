package me.s097t0r1.ktcast.common.secure_storage.di

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.ktcast.common.secure_storage.storage.SecureStorage

interface SecureStorageAPI : BaseFeatureAPI {
    val storage: SecureStorage
}
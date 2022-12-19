package me.s097t0r1.ktcast.common.secure_storage.di

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies

interface SecureStorageDependencies : BaseFeatureDependencies {
    val context: Context
}
package me.s097t0r1.ktcast.data.profile.api

import android.content.Context
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.core.di.base.BaseFeatureDependencies

interface ProfileDataDependencies : BaseFeatureDependencies {
    val context: Context
    val networkServiceFactory: NetworkServiceFactory
}

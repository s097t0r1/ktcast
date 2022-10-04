package me.s097t0r1.ktcast.glue

import android.content.Context
import me.s097t0r1.ktcast.glue.module.common.glueDatabaseModule
import me.s097t0r1.ktcast.glue.module.common.glueNetworkModule
import me.s097t0r1.ktcast.glue.module.common.glueSecureStorage
import me.s097t0r1.ktcast.glue.module.data.glueAuthModule
import me.s097t0r1.ktcast.glue.module.feature.glueAuthFeature
import me.s097t0r1.ktcast.glue.module.feature.glueSplashFeature

internal fun glueModules(applicationContext: Context) {
    glueNetworkModule()
    glueDatabaseModule(applicationContext)
    glueSecureStorage(applicationContext)

    // Feature
    glueSplashFeature()
    glueAuthFeature()

    // Data
    glueAuthModule()
}
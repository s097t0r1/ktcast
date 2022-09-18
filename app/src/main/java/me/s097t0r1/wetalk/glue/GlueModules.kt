package me.s097t0r1.wetalk.glue

import android.content.Context
import me.s097t0r1.wetalk.glue.module.common.glueDatabaseModule
import me.s097t0r1.wetalk.glue.module.common.glueNetworkModule
import me.s097t0r1.wetalk.glue.module.feature.glueSplashFeature

internal fun glueModules(applicationContext: Context) {
    glueNetworkModule()
    glueDatabaseModule(applicationContext)

    // Feature
    glueSplashFeature()
}
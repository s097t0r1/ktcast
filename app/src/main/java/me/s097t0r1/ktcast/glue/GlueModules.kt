package me.s097t0r1.ktcast.glue

import android.content.Context
import me.s097t0r1.ktcast.glue.module.common.glueDatabaseModule
import me.s097t0r1.ktcast.glue.module.common.glueNetworkModule
import me.s097t0r1.ktcast.glue.module.common.glueSecureStorage
import me.s097t0r1.ktcast.glue.module.data.glueAuthModule
import me.s097t0r1.ktcast.glue.module.data.glueProfileDataModule
import me.s097t0r1.ktcast.glue.module.feature.glueAuthFeature
import me.s097t0r1.ktcast.glue.module.feature.glueProfileFeature
import me.s097t0r1.ktcast.glue.module.feature.glueSplashFeature
import me.s097t0r1.ktcast.glue.module.glueApplication

fun glueModules(application: Context) {
    glueApplication(application)

    glueNetworkModule()
    glueDatabaseModule(application)
    glueSecureStorage(application)

    // Feature
    glueSplashFeature()
    glueProfileFeature()
    glueAuthFeature()

    // Data
    glueAuthModule()
    glueProfileDataModule(application)
}

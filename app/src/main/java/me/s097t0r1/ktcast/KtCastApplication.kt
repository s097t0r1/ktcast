package me.s097t0r1.ktcast

import android.app.Application
import me.s097t0r1.ktcast.core.debug_helper.KtCastDebugHelper
import me.s097t0r1.ktcast.glue.glueModules

class KtCastApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        glueModules(this)
        KtCastDebugHelper.initialize(this).also {
            KtCastDebugHelper.Logger.init()
        }
    }
}

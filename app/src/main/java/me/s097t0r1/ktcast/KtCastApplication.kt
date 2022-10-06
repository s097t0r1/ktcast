package me.s097t0r1.ktcast

import android.app.Application
import me.s097t0r1.ktcast.core.debug_helper.KtCastDebugHelper
import me.s097t0r1.ktcast.di.ApplicationComponent
import me.s097t0r1.ktcast.di.DaggerApplicationComponent
import me.s097t0r1.ktcast.glue.glueModules

class KtCastApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        glueModules(this)
        KtCastDebugHelper.initialize(this).also {
            KtCastDebugHelper.Logger.init()
        }
    }

    companion object {
        lateinit var INSTANCE: KtCastApplication
    }


}
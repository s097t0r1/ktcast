package me.s097t0r1.wetalk

import android.app.Application
import me.s097t0r1.wetalk.glue.glueModules

class WeTalkApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        glueModules(this)
    }

}
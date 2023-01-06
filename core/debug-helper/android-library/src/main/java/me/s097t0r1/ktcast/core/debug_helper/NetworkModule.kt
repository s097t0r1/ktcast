package me.s097t0r1.ktcast.core.debug_helper

import android.app.Activity
import android.content.Context

class NetworkModule(private val hostActivity: Activity) {

    private val storage = hostActivity.applicationContext.getSharedPreferences(
        STORAGE_NAME,
        Context.MODE_PRIVATE,
    )

    var stand: Stand
        get() = Stand.valueOf(
            storage.getString(STAND_KEY, null)
                ?: Stand.MOCKER.name
        )
        set(value) {
            storage.edit().putString(STAND_KEY, value.name).apply()
            hostActivity.recreate()
        }

    enum class Stand(val baseUrl: String) {
        MOCKER("https://virtserver.swaggerhub.com/S097T0R1_1/ktcast/1.0.0/"),
        TEST("http://185.104.115.136/api/v1/")
    }

    companion object {
        private const val STORAGE_NAME = "me.s097t0r1.ktcast.core.debug_helper"

        private const val STAND_KEY = "STAND_KEY"
    }
}
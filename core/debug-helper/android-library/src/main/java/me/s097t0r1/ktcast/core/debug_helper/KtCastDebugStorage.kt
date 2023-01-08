package me.s097t0r1.ktcast.core.debug_helper

import android.content.Context
import androidx.core.content.edit
import me.s097t0r1.ktcast.core.debug_helper.modules.stand_module.Stand

class KtCastDebugStorage(context: Context) {

    private val storage = context.getSharedPreferences(
        STORAGE_NAME,
        Context.MODE_PRIVATE,
    )

    var stand: Stand
        get() = Stand.valueOf(
            storage.getString(STAND_KEY, null)
                ?: Stand.MOCKER.name
        )
        set(value) {
            storage.edit {
                putString(STAND_KEY, value.name)
            }
        }


    companion object {
        private const val STORAGE_NAME = "me.s097t0r1.ktcast.core.debug_helper"

        private const val STAND_KEY = "STAND_KEY"
    }
}
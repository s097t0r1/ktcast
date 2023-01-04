package me.s097t0r1.shelf

import android.content.Context
import androidx.core.content.edit

class SharedPreferencesStorage(context: Context) : Shelf.Storage {

    private val sharedPrefs = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    override fun get(key: String): String? = sharedPrefs.getString(key, null)

    override fun put(key: String, value: String, timestamp: Long) {
        sharedPrefs.edit {
            putString(key, value)
            putLong(TIMESTAMP_PATTERN.format(key), timestamp)
        }
    }

    override fun timestamp(key: String): Long? = sharedPrefs.getLong(TIMESTAMP_PATTERN.format(key), -1)

    override fun keys(): Set<String> {
        return sharedPrefs.all.keys.toSet()
    }

    override fun remove(key: String) =
        sharedPrefs.edit { remove(key) }

    companion object {
        private const val SHARED_PREFS_NAME = "me.s097t0r1.shelf.SHELF_NAME"
        private const val TIMESTAMP_PATTERN = "t_%s"
    }

}

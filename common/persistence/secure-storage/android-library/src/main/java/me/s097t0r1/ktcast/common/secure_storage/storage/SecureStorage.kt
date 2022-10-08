package me.s097t0r1.ktcast.common.secure_storage.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Inject


interface SecureStorage {

    var role: Role?
    var webToken: String?

    fun clear()

}

enum class Role {
    ADMIN,
    USER,
    UNKNOWN
}

internal class AndroidSecureStorage @Inject constructor(context: Context) : SecureStorage {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        SHARED_PREFS_FILE_NAME,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override var role: Role?
        get() = sharedPreferences.getString(ROLE_KEY, null)?.let(Role::valueOf)
        set(value) = sharedPreferences.edit {
            putString(ROLE_KEY, value?.name)
        }

    override var webToken: String?
        get() = sharedPreferences.getString(WEB_TOKEN_KEY, null)
        set(value) = sharedPreferences.edit {
            putString(WEB_TOKEN_KEY, value)
        }

    override fun clear() {
        sharedPreferences.edit { clear() }
    }

    companion object {
        private const val SHARED_PREFS_FILE_NAME =
            "me.s097t0r1.ktcast.common.secure_storage.storage"

        private const val ROLE_KEY = "me.s097t0r1.ktcast.common.secure_storage.storage.ROLE"
        private const val WEB_TOKEN_KEY =
            "me.s097t0r1.ktcast.common.secure_storage.storage.WEB_TOKEN_KEY"

    }

}
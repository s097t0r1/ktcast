package me.s097t0r1.ktcast.common.logout

interface LogoutHandler {

    fun logout(logoutType: LogoutType)

    enum class LogoutType {
        SERVER_LOGOUT
    }
}
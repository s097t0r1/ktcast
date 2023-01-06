package me.s097t0r1.ktcast.data.authorization.impl.mapper

import me.s097t0r1.ktcast.data.authorization.api.model.domain.AuthInfo
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.RemoteToken
import me.s097t0r1.ktcast.libraries.mapper.Mapper

class AuthInfoMapper : Mapper<RemoteToken, AuthInfo> {
    override fun map(input: RemoteToken): AuthInfo {
        return AuthInfo(
            token = input.authToken
        )
    }
}
package me.s097t0r1.ktcast.data.authorization.impl.mapper

import me.s097t0r1.core.utils.mapper.Mapper
import me.s097t0r1.ktcast.data.authorization.api.model.domain.AuthInfo
import me.s097t0r1.ktcast.data.authorization.impl.model.remote.response.TokenResponseDTO

class AuthInfoMapper : Mapper<TokenResponseDTO, AuthInfo> {
    override fun map(input: TokenResponseDTO): AuthInfo {
        return AuthInfo(
            token = input.authToken,
            role = input.role
        )
    }
}
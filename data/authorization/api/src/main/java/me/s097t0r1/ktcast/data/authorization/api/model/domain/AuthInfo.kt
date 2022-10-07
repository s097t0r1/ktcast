package me.s097t0r1.ktcast.data.authorization.api.model.domain

import me.s097t0r1.ktcast.libraries.mapper.DomainModel

class AuthInfo(
    val token: String,
    val role: String
) : DomainModel
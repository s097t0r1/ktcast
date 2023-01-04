package me.s097t0r1.ktcast.data.profile.impl.model.local

import me.s097t0r1.ktcast.libraries.mapper.DTO

class LocalProfile(
    val avatarUrl: String,
    val fullName: String,
    val nickname: String,
    val birthday: Long,
    val email: String
) : DTO

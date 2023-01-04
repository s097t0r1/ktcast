package me.s097t0r1.ktcast.data.profile.api.model

import java.time.LocalDate
import me.s097t0r1.ktcast.libraries.mapper.DomainModel

class Profile(
    val avatarUrl: String,
    val fullName: String,
    val nickname: String,
    val birthday: LocalDate,
    val email: String
) : DomainModel

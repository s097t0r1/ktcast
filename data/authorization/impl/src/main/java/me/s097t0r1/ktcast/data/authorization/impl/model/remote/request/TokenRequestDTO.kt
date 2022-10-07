package me.s097t0r1.ktcast.data.authorization.impl.model.remote.request

import com.squareup.moshi.Json
import me.s097t0r1.ktcast.libraries.mapper.DTO

class TokenRequestDTO(
    @Json(name = "login")
    val login: String,
    @Json(name = "password")
    val password: String
): DTO
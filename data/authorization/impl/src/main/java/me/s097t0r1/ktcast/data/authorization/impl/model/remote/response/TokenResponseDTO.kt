package me.s097t0r1.ktcast.data.authorization.impl.model.remote.response

import com.squareup.moshi.Json
import me.s097t0r1.ktcast.libraries.mapper.DTO

class TokenResponseDTO(
    @Json(name = "auth_token")
    val authToken: String,
    @Json(name = "role")
    val role: String
) : DTO
package me.s097t0r1.ktcast.data.authorization.impl.model.remote.response

import com.squareup.moshi.Json
import me.s097t0r1.ktcast.libraries.mapper.DTO

class RemoteToken(
    @Json(name = "access_token")
    val authToken: String,
) : DTO
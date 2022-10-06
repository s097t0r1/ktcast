package me.s097t0r1.ktcast.common.network.utils.model

import com.squareup.moshi.Json

class ErrorResponse(
    @Json(name ="errors")
    val errors: List<String>
)
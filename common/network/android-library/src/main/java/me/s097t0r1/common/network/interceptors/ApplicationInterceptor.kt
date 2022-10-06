package me.s097t0r1.common.network.interceptors

import me.s097t0r1.common.network.CONTENT_TYPE_HEADER_NAME
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class ApplicationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addContentTypeHeader()
                .build()
        )
    }

    private fun Request.Builder.addContentTypeHeader() =
        addHeader(CONTENT_TYPE_HEADER_NAME, APPLICATION_JSON)

    companion object {
        private const val APPLICATION_JSON = "application/json"
    }
}
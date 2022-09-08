package me.s097t0r1.common.network.service

import retrofit2.Retrofit
import javax.inject.Inject

interface NetworkService

interface NetworkServiceFactory {

    fun <T : NetworkService> create(serviceClass: Class<T>): T

    class Base @Inject constructor(
        private val retrofit: Retrofit
    ) : NetworkServiceFactory {

        override fun <T : NetworkService> create(serviceClass: Class<T>): T =
            retrofit.create(serviceClass)

    }
}

inline fun <reified T : NetworkService> NetworkServiceFactory.create() = this.create(T::class.java)
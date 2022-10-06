package me.s097t0r1.ktcast.common.network.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

fun <T> String.deserialize(clazz: Class<T>): T? = moshi.adapter(clazz).fromJson(this)

inline fun <reified T> String.deserialize(): T? = this.deserialize(T::class.java)
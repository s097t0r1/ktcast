package me.s097t0r1.common.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.s097t0r1.common.network.service.NetworkServiceFactory
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
internal abstract class NetworkModule {

    @Binds
    abstract fun bindNetworkServiceFactory(
        networkServiceFactory: NetworkServiceFactory.Base
    ): NetworkServiceFactory

    companion object {

        @Provides
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor())
        }.build()

        @Provides
        fun provideMoshi(): Moshi = Moshi.Builder().apply {
            addLast(KotlinJsonAdapterFactory())
        }.build()

        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            moshi: Moshi
        ): Retrofit = Retrofit.Builder().apply {
            baseUrl("https://listen-api-test.listennotes.com/api/v2".toHttpUrl())
            addConverterFactory(MoshiConverterFactory.create(moshi))
            client(okHttpClient)
        }.build()
    }


}
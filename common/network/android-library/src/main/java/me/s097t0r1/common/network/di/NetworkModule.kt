package me.s097t0r1.common.network.di

import com.pandulapeter.beagle.logOkHttp.BeagleOkHttpLogger
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton
import me.s097t0r1.common.network.BASE_URL
import me.s097t0r1.common.network.authenticator.KtCastAuthenticator
import me.s097t0r1.common.network.call_adapter.EitherCallAdapterFactory
import me.s097t0r1.common.network.factory.NetworkServiceFactory
import me.s097t0r1.common.network.interceptors.ApplicationInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
internal object NetworkModule {

    @Provides
    @Singleton
    @Named(UNAUTHORIZED)
    fun provideUnauthorizedApiFactory(
        @Named(UNAUTHORIZED)
        retrofit: Retrofit
    ): NetworkServiceFactory = NetworkServiceFactory.Base(retrofit)

    @Provides
    @Singleton
    @Named(AUTHORIZED)
    fun provideAuthorizedApiFactory(
        @Named(AUTHORIZED)
        retrofit: Retrofit
    ): NetworkServiceFactory = NetworkServiceFactory.Base(retrofit)

    @Provides
    @Singleton
    @Named(AUTHORIZED)
    fun provideAuthorizedRetrofit(
        moshi: Moshi,
        @Named(AUTHORIZED)
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(MoshiConverterFactory.create(moshi))
        addCallAdapterFactory(EitherCallAdapterFactory())
        client(okHttpClient)
    }.build()

    @Provides
    @Singleton
    @Named(UNAUTHORIZED)
    fun provideUnathorizedRetrofit(
        moshi: Moshi,
        @Named(UNAUTHORIZED)
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(MoshiConverterFactory.create(moshi))
        addCallAdapterFactory(EitherCallAdapterFactory())
        client(okHttpClient)
    }.build()

    @Provides
    @Singleton
    @Named(AUTHORIZED)
    fun provideAuthorizedOkHttpClient(
        authenticator: KtCastAuthenticator
    ): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor())
        addInterceptor(ApplicationInterceptor())
        (BeagleOkHttpLogger.logger as? Interceptor?)?.let(::addInterceptor)
        authenticator(authenticator)
    }.build()

    @Provides
    @Singleton
    @Named(UNAUTHORIZED)
    fun provideUnauthorizedOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor())
        addInterceptor(ApplicationInterceptor())
        (BeagleOkHttpLogger.logger as? Interceptor?)?.let(::addInterceptor)
    }.build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    const val UNAUTHORIZED = "UNAUTHORIZED_API_FACTORY"
    const val AUTHORIZED = "AUHTORIZED_API_FACTORY"

}
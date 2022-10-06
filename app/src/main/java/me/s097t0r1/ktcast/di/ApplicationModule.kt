package me.s097t0r1.ktcast.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.s097t0r1.ktcast.libraries.resource_provider.AndroidResourceProvider
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    companion object {

        @Provides
        @Singleton
        fun provideResourceProvider(
            context: Context
        ): ResourceProvider = AndroidResourceProvider(context)

    }
}
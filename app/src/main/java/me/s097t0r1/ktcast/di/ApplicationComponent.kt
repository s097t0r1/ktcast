package me.s097t0r1.ktcast.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun getResourceProvider(): ResourceProvider

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}
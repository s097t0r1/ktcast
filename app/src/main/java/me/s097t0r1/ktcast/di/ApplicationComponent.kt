package me.s097t0r1.ktcast.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import me.s097t0r1.ktcast.libraries.resource_provider.ResourceProvider

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent : ApplicationAPI {

    override fun getResourceProvider(): ResourceProvider

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}

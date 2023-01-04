package me.s097t0r1.ktcast.data.profile.impl.di

import dagger.Component
import me.s097t0r1.core.di.base.scope.FeatureScope
import me.s097t0r1.ktcast.data.profile.api.ProfileDataAPI
import me.s097t0r1.ktcast.data.profile.api.ProfileDataDependencies
import me.s097t0r1.ktcast.libraries.factory.ViewModelFactoryModule

@FeatureScope
@Component(
    dependencies = [ProfileDataDependencies::class],
    modules = [ViewModelFactoryModule::class, ProfileDataModule::class],
)
internal interface ProfileDataComponent : ProfileDataAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: ProfileDataDependencies): ProfileDataComponent
    }
}
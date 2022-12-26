package me.s097t0r1.ktcast.feature.profile.impl.di

import dagger.Component
import me.s097t0r1.core.di.base.scope.FeatureScope
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureAPI
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureDependencies
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.FillYourProfileFragment
import me.s097t0r1.ktcast.libraries.factory.ViewModelFactoryModule

@FeatureScope
@Component(
    dependencies = [ProfileFeatureDependencies::class],
    modules = [ViewModelFactoryModule::class, ProfileModule::class],
)
internal interface ProfileComponent : ProfileFeatureAPI {

    fun inject(fragment: FillYourProfileFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ProfileFeatureDependencies): ProfileComponent
    }
}

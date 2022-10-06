package me.s097t0r1.ktcast.feature.authorization.impl.di

import dagger.Component
import me.s097t0r1.core.di.base.scope.FeatureScope
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureAPI
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureDependencies
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.LetsYouInFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.SignInFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.SignUpFragment
import me.s097t0r1.ktcast.libraries.factory.ViewModelFactoryModule

@FeatureScope
@Component(
    dependencies = [AuthorizationFeatureDependencies::class],
    modules = [ViewModelFactoryModule::class, AuthorizationModule::class],
)
internal interface AuthorizationComponent : AuthorizationFeatureAPI {

    fun inject(fragment: SignInFragment)
    fun inject(fragment: SignUpFragment)
    fun inject(fragment: LetsYouInFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: AuthorizationFeatureDependencies): AuthorizationComponent
    }

}
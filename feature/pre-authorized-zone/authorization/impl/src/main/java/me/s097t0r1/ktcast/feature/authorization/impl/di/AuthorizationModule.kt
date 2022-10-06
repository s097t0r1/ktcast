package me.s097t0r1.ktcast.feature.authorization.impl.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.AuthorizationContainerFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.LetsYouInViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.SignInViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.SignUpViewModel
import me.s097t0r1.ktcast.libraries.factory.ViewModelKey

@Module
internal abstract class AuthorizationModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(signIn: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(singUp: SignUpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LetsYouInViewModel::class)
    abstract fun bindLetsYouInViewModel(letsYouIn: LetsYouInViewModel): ViewModel

    companion object {

        @Provides
        fun provideStarter(): AuthorizationFeatureStarter =
            object : AuthorizationFeatureStarter {
                override fun start(): FragmentScreen<Fragment> {
                    return FragmentScreen.create { AuthorizationContainerFragment() }
                }
            }

    }
}
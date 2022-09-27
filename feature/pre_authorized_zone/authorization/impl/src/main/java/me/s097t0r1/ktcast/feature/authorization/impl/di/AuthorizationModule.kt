package me.s097t0r1.ktcast.feature.authorization.impl.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.SignInFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.SignInViewModel
import me.s097t0r1.viewmodel.factory.ViewModelKey

@Module
internal abstract class AuthorizationModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(signIn: SignInViewModel): ViewModel

    companion object {

        @Provides
        fun provideStarter(): AuthorizationFeatureStarter =
            object : AuthorizationFeatureStarter {
                override fun signIn(): FragmentScreen<Fragment> {
                    return FragmentScreen.create { SignInFragment.newInstance() }
                }
            }

    }
}
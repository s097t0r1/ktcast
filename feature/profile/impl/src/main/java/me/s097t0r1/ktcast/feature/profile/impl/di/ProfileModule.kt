package me.s097t0r1.ktcast.feature.profile.impl.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureStarter
import me.s097t0r1.ktcast.feature.profile.impl.presentation.ProfileContainerFragment
import me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.FillYourProfileViewModel
import me.s097t0r1.ktcast.libraries.factory.ViewModelKey

@Module
internal abstract class ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(FillYourProfileViewModel::class)
    abstract fun bindFillYourProfileViewModel(vm: FillYourProfileViewModel): ViewModel

    companion object {

        @Provides
        fun provideStarter(): ProfileFeatureStarter = object : ProfileFeatureStarter {
            override fun start(): FragmentScreen<Fragment> =
                FragmentScreen.create { ProfileContainerFragment() }
        }
    }
}

package me.s097t0r1.ktcast.feature.profile.impl.presentation

import me.s097t0r1.core.mvi.base.BaseContainerFragment
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.ktcast.feature.profile.impl.R
import me.s097t0r1.ktcast.feature.profile.impl.navigation.FillYourProfileScreen

internal class ProfileContainerFragment : BaseContainerFragment(R.layout.profile_feat_fragment_profile_container) {

    override val containerId: Int = R.id.container

    override fun openLaunchScreen() {
        router.navigate(ForwardMessage(FillYourProfileScreen()))
    }
}

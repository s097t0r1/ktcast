package me.s097t0r1.feature.splash.impl.presentation

import me.s097t0r1.core.mvi.base.BaseContainerFragment
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.feature.splash.impl.navigation.splashFragmentScreen
import me.s097t0r1.feature.splash.res.R

internal class SplashContainerFragment : BaseContainerFragment(R.layout.splash_feature_fragment_splash_container) {

    override val containerId: Int = R.id.fcvContainer

    override fun openLaunchScreen() = router.navigate(ForwardMessage(splashFragmentScreen()))

}
package me.s097t0r1.ktcast.feature.authorization.impl.presentation

import me.s097t0r1.core.mvi.base.BaseContainerFragment
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.ktcast.feature.authorization.impl.R
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.LetsYouIn

internal class AuthorizationContainerFragment(

) : BaseContainerFragment(R.layout.authorization_feature_fragment_authorization_container) {

    override val containerId: Int = R.id.fcvContainer

    override fun openLaunchScreen() {
        router.navigate(ForwardMessage(LetsYouIn()))
    }
}
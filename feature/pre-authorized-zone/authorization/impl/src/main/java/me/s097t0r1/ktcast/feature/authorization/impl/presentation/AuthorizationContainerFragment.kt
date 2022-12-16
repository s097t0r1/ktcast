package me.s097t0r1.ktcast.feature.authorization.impl.presentation

import me.s097t0r1.core.mvi.base.BaseContainerFragment
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.LetsYouIn

internal class AuthorizationContainerFragment(

) : BaseContainerFragment(me.s097t0r1.ktcast.feature.authorization.screens.R.layout.authorization_feature_fragment_authorization_container) {

    override val containerId: Int = me.s097t0r1.ktcast.feature.authorization.screens.R.id.fcvContainer

    override fun openLaunchScreen() {
        router.navigate(ForwardMessage(LetsYouIn()))
    }
}
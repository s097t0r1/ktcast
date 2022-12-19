package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation

import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.message.ReplaceMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.SignInScreen

class SignUpNavigationProvider : NavigationProvider<SignUpNavigationGraph> {

    override fun navigate(router: Router, screen: SignUpNavigationGraph) {
        when (screen) {
            is SignUpNavigationGraph.FillProfileScreen -> showFillProfile(router, screen)
            is SignUpNavigationGraph.SignInScreen -> showSignIn(router, screen)
        }
    }

    private fun showSignIn(router: Router, screen: SignUpNavigationGraph.SignInScreen) {
        router.navigate(ReplaceMessage(SignInScreen()))
    }

    private fun showFillProfile(
        router: Router,
        screen: SignUpNavigationGraph.FillProfileScreen
    ) = router.navigate(ForwardMessage(TODO()))

}
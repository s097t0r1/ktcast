package me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.navigation

import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.SignInScreen
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.SignUpScreen

class LetsYouInNavigationProvider : NavigationProvider<LetsYouInNavigationGraph> {

    override fun navigate(router: Router, screen: LetsYouInNavigationGraph) {
        when (screen) {
            is LetsYouInNavigationGraph.SignUp -> navigateToSignedUp(router, screen)
            is LetsYouInNavigationGraph.SignIn -> navigateToSignedIn(router, screen)
        }
    }

    private fun navigateToSignedIn(router: Router, screen: LetsYouInNavigationGraph.SignIn) {
        router.navigate(ForwardMessage(SignInScreen()))
    }

    private fun navigateToSignedUp(router: Router, screen: LetsYouInNavigationGraph.SignUp) {
        router.navigate(ForwardMessage(SignUpScreen()))
    }
}
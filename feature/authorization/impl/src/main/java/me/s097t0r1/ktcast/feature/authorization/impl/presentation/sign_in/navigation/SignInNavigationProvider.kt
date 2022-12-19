package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation

import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.ReplaceMessage
import me.s097t0r1.core.navigation.message.StartFlowMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.SignUpScreen

internal class SignInNavigationProvider : NavigationProvider<SignInNavigationGraph> {

    override fun navigate(router: Router, screen: SignInNavigationGraph) {
        when(screen) {
            is SignInNavigationGraph.SignUpScreen -> navigateToSignUp(router, screen)
            is SignInNavigationGraph.HomeScreen -> navigateToHome(router, screen)
        }
    }

    private fun navigateToHome(router: Router, screen: SignInNavigationGraph.HomeScreen) {
        router.navigate(StartFlowMessage(TODO()))
    }

    private fun navigateToSignUp(router: Router, screen: SignInNavigationGraph.SignUpScreen) {
        router.navigate(ReplaceMessage(SignUpScreen()))
    }
}
package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.navigation

import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.signUpScreen

internal class SignInNavigationProvider : NavigationProvider<SignInNavigationGraph> {

    override fun navigate(router: Router, screen: SignInNavigationGraph) {
        when(screen) {
            is SignInNavigationGraph.SignUpScreen -> navigateToSignUp(router, screen)
        }
    }

    private fun navigateToSignUp(router: Router, screen: SignInNavigationGraph.SignUpScreen) {
        router.navigate(ForwardMessage(signUpScreen()))
    }
}
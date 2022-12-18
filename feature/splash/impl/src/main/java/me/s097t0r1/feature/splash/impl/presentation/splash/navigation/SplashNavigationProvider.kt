package me.s097t0r1.feature.splash.impl.presentation.splash.navigation

import javax.inject.Inject
import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.StartFlowMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.api.AuthorizationFeatureStarter

class SplashNavigationProvider @Inject constructor(
    private val signInStarter: AuthorizationFeatureStarter
) : NavigationProvider<SplashNavigationGraph> {

    override fun navigate(router: Router, screen: SplashNavigationGraph) {
        when (screen) {
            is SplashNavigationGraph.SignInScreen -> router.navigate(StartFlowMessage(signInStarter.start()))
        }
    }
}
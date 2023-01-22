package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation

import android.os.Bundle
import javax.inject.Inject
import kotlin.reflect.KClass
import me.s097t0r1.core.navigation.base.NavGraph
import me.s097t0r1.core.navigation.base.NavigationNode
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.message.StartFlowMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.SignInScreen
import me.s097t0r1.ktcast.feature.profile.api.ProfileFeatureStarter

class SignUpNavigationGraph @Inject constructor(
    profileFeatureStarter: ProfileFeatureStarter
) : NavGraph<SignUpNavigationGraph.SignUpNavigationNode> {

    private val navigationGraphMap = mapOf<KClass<out SignUpNavigationNode>, NavigationNode>(
        SignUpNavigationNode.FillProfileScreen::class to SignUpNavigationNode.FillProfileScreen(profileFeatureStarter),
        SignUpNavigationNode.SignInScreen::class to SignUpNavigationNode.SignInScreen
    )
    override fun navigate(router: Router, kClass: KClass<SignUpNavigationNode>, params: Bundle) {
        navigationGraphMap[kClass]?.navigate(router, params)
    }

    sealed class SignUpNavigationNode : NavigationNode {

        class FillProfileScreen(val profileFeatureStarter: ProfileFeatureStarter) : SignUpNavigationNode() {
            override fun navigate(router: Router, params: Bundle) {
                router.navigate(StartFlowMessage(profileFeatureStarter.start()))
            }
        }
        object SignInScreen : SignUpNavigationNode() {
            override fun navigate(router: Router, params: Bundle) {
                router.navigate(ForwardMessage(SignInScreen()))
            }
        }
    }
}
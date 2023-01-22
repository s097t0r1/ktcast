package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation

import android.os.Bundle
import javax.inject.Inject
import kotlin.reflect.KClass
import me.s097t0r1.core.navigation.base.NavProvider
import me.s097t0r1.core.navigation.router.Router

class SignUpNavProvider @Inject constructor(
    private val signUpNavigationGraph: SignUpNavigationGraph
) : NavProvider<SignUpNavigationGraph.SignUpNavigationNode> {

    override fun route(
        router: Router,
        nodeClazz: KClass<SignUpNavigationGraph.SignUpNavigationNode>,
        params: Bundle
    ) {
        signUpNavigationGraph.navigate(router, nodeClazz, params)
    }

}

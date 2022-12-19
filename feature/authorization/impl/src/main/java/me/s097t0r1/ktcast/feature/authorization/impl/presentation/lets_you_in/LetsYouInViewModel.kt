package me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in

import javax.inject.Inject
import me.s097t0r1.core.mvi.base.BaseViewModel
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.navigation.LetsYouInNavigationGraph
import me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in.LetsYouInSideEffect
import me.s097t0r1.ktcast.feature.authorization.screens.lets_you_in.LetsYouInUIState
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container

class LetsYouInViewModel @Inject constructor(

): BaseViewModel<LetsYouInUIState, LetsYouInSideEffect, LetsYouInNavigationGraph>() {

    override val container: Container<LetsYouInUIState, LetsYouInSideEffect> = container(LetsYouInUIState())

    fun onSignedUpClicked() = navigateTo(LetsYouInNavigationGraph.SignUp)

    fun onSignedInClicked() = navigateTo(LetsYouInNavigationGraph.SignIn)
}
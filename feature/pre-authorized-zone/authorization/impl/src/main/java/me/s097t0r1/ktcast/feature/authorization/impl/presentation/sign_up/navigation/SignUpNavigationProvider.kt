package me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.navigation

import me.s097t0r1.core.navigation.base.NavigationProvider
import me.s097t0r1.core.navigation.message.ForwardMessage
import me.s097t0r1.core.navigation.router.Router
import me.s097t0r1.ktcast.feature.authorization.impl.navigation.datePickerDialog

class SignUpNavigationProvider : NavigationProvider<SignUpNavigationGraph> {

    override fun navigate(router: Router, screen: SignUpNavigationGraph) {
        when (screen) {
            is SignUpNavigationGraph.DatePickerDialog -> showDatePickerDialog(router, screen)
        }
    }

    private fun showDatePickerDialog(
        router: Router,
        screen: SignUpNavigationGraph.DatePickerDialog
    ) = router.navigate(ForwardMessage(datePickerDialog()))

}
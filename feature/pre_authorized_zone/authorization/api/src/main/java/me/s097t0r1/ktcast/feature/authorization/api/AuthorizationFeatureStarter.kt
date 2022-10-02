package me.s097t0r1.ktcast.feature.authorization.api

import androidx.fragment.app.Fragment
import me.s097t0r1.core.navigation.screen.FragmentScreen

interface AuthorizationFeatureStarter {
    fun start(): FragmentScreen<Fragment>
}
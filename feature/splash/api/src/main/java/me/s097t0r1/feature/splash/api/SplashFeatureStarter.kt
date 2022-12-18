package me.s097t0r1.feature.splash.api

import androidx.fragment.app.Fragment
import me.s097t0r1.core.navigation.screen.FragmentScreen

fun interface SplashFeatureStarter {
    fun start(): FragmentScreen<Fragment>
}
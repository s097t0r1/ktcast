package me.s097t0r1.ktcast.feature.authorization.impl.navigation

import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.lets_you_in.LetsYouInFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_in.SignInFragment
import me.s097t0r1.ktcast.feature.authorization.impl.presentation.sign_up.SignUpFragment

internal fun LetsYouIn() = FragmentScreen.create { LetsYouInFragment() }

internal fun SignInScreen() = FragmentScreen.create { SignInFragment() }

internal fun SignUpScreen() = FragmentScreen.create { SignUpFragment() }
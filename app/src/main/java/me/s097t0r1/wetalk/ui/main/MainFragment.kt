package me.s097t0r1.wetalk.ui.main

import androidx.fragment.app.Fragment
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.wetalk.R

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        fun MainScreen() = FragmentScreen.create { MainFragment() }
    }
}

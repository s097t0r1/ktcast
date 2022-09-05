package me.s097t0r1.core.navigation.navigator

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import me.s097t0r1.core.navigation.command.NavigationCommand
import me.s097t0r1.core.navigation.screen.ActivityScreen
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.core.navigation.screen.NavigationScreen

class AppNavigator(
    private val containerId: Int,
    private val fragmentActivity: FragmentActivity,
    private val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
) : Navigator {

    override fun execute(commands: Array<out NavigationCommand>) {
        for (command in commands) {
            when (command) {
                is NavigationCommand.Back -> back()
                is NavigationCommand.BackTo -> backTo(command.screen)
                is NavigationCommand.Replace -> replace(command.screen)
                is NavigationCommand.Forward -> forward(command.screen)
            }
        }
    }

    private fun forward(screen: NavigationScreen) {
        when (screen) {
            is ActivityScreen -> screen.creator.create(fragmentActivity)
            is FragmentScreen<*> -> fragmentManager.commit {
                add(
                    containerId,
                    screen.creator.create(fragmentManager.fragmentFactory),
                    screen.screenKey
                )
            }
        }
    }

    private fun replace(screen: NavigationScreen) {
        when (screen) {
            is ActivityScreen -> {
                val context = fragmentActivity.applicationContext
                fragmentActivity.finish()
                screen.creator.create(context)
            }
            is FragmentScreen<*> -> {
                fragmentManager.commit {
                    replace(
                        containerId,
                        screen.creator.create(fragmentManager.fragmentFactory),
                        screen.screenKey
                    )
                }
            }
        }
    }

    private fun backTo(screen: NavigationScreen) = when (screen) {
        is ActivityScreen -> throw IllegalArgumentException("Activity doesn't support 'BackTo' command")
        is FragmentScreen<*> -> {
            val localStack = fragmentManager.fragments
            val indexOfScreen = if (screen == FragmentScreen.Root) {
                localStack.reversed().indexOfFirst { it.tag == screen.screenKey }
            } else {
                localStack.size - 1
            }
            repeat(indexOfScreen) { fragmentManager.popBackStack() }
        }
    }

    private fun back() {
        if (fragmentManager.backStackEntryCount == 0) {
            fragmentActivity.finish()
        } else {
            fragmentManager.popBackStack()
        }
    }

}

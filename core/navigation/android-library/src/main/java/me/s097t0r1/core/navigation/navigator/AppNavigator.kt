package me.s097t0r1.core.navigation.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import me.s097t0r1.core.navigation.R
import me.s097t0r1.core.navigation.command.NavigationCommand
import me.s097t0r1.core.navigation.screen.ActivityScreen
import me.s097t0r1.core.navigation.screen.DialogFragmentScreen
import me.s097t0r1.core.navigation.screen.FragmentScreen
import me.s097t0r1.core.navigation.screen.NavigationScreen

class AppNavigator(
    private val containerId: Int,
    private val fragmentActivity: FragmentActivity,
    private val fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager
) : Navigator {

    private var transactions = listOf<Pair<Char, String>>()

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
                val nextFragment = screen.creator.create(fragmentManager.fragmentFactory)
                setupFragmentTransaction(
                    screen,
                    this,
                    nextFragment,
                    fragmentManager.findFragmentById(containerId)
                )
                val transaction = '+' to screen.screenKey.orEmpty()
                transactions += transaction
                addToBackStack(transaction.hashCode().toString())
                replace(
                    containerId,
                    nextFragment,
                    screen.screenKey
                )
            }
            is DialogFragmentScreen<*> -> {
                screen.creator.create(fragmentManager.fragmentFactory)
                    .show(fragmentManager, screen.screenKey)
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
                    val nextFragment = screen.creator.create(fragmentManager.fragmentFactory)

                    if (transactions.isNotEmpty()) {
                        transactions = transactions.subList(0, transactions.lastIndex)
                    }

                    transactions += '+' to screen.screenKey.toString()

                    setupFragmentTransaction(
                        screen,
                        this,
                        nextFragment,
                        null
                    )
                    replace(containerId, nextFragment, screen.screenKey.toString())
                    addToBackStack(transactions.last().hashCode().toString())
                }
            }
            else -> error("DialogFragment doesn't support 'Replace' command")
        }
    }

    open fun <T : Fragment> setupFragmentTransaction(
        fragmentScreen: FragmentScreen<T>,
        fragmentTransaction: FragmentTransaction,
        nextFragment: Fragment,
        previousFragment: Fragment?
    ) {
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.setCustomAnimations(
            R.animator.slide_in,
            R.animator.slide_out,
            R.animator.slide_in,
            R.animator.slide_out
        )
    }

    private fun backTo(screen: NavigationScreen) = when (screen) {
        is ActivityScreen -> throw IllegalArgumentException("Activity doesn't support 'BackTo' command")
        is FragmentScreen<*> -> {
            if (screen != FragmentScreen.Root) {
                val indexOfScreen = transactions.indexOfLast { it.second == screen.screenKey }
                fragmentManager.popBackStack(transactions[indexOfScreen].hashCode().toString(), 0)
                transactions = transactions.subList(0, indexOfScreen)
            } else {
                fragmentManager.popBackStack(
                    transactions.firstOrNull().hashCode().toString(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                transactions = emptyList()
            }
        }
        else -> error("DialogFragment doesn't support 'Back' command")
    }

    private fun back() {
        if (fragmentManager.backStackEntryCount <= 1) {
            transactions = emptyList()
            fragmentActivity.finish()
        } else {
            transactions = if (transactions.size > 1) {
                transactions.subList(0, transactions.lastIndex)
            } else {
                emptyList()
            }
            fragmentManager.popBackStack(
                transactions.lastOrNull().hashCode().toString(),
                0
            )
        }
    }

}

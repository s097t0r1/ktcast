package me.s097t0r1.core.navigation.screen

import android.content.Context
import android.content.Intent
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

fun interface Creator<I, O> {
    fun create(input: I): O
}

sealed interface NavigationScreen

open class ActivityScreen private constructor(
    val screenKey: String? = null,
    val creator: Creator<Context, Intent>
) : NavigationScreen {

    companion object {

        fun create(screenKey: String? = null, creator: Creator<Context, Intent>) =
            ActivityScreen(screenKey, creator)

        inline fun <reified T> create(creator: Creator<Context, Intent>): ActivityScreen =
            create(T::class.simpleName, creator)
    }
}

open class FragmentScreen<T : Fragment> private constructor(
    val screenKey: String? = null,
    val creator: Creator<FragmentFactory, T>
) : NavigationScreen {

    companion object {

        fun <T : Fragment> create(screenKey: String? = null, creator: Creator<FragmentFactory, T>) =
            FragmentScreen(screenKey, creator)

        inline fun <reified T : Fragment> create(creator: Creator<FragmentFactory, T>) =
            create(T::class.simpleName, creator)
    }

    object Root : FragmentScreen<Fragment>(
        screenKey = "ROOT",
        creator = { Fragment() }
    )
}

open class DialogFragmentScreen<T : DialogFragment> private constructor(
    val screenKey: String? = null,
    val creator: Creator<FragmentFactory, T>
) : NavigationScreen {

    companion object {

        fun <T : DialogFragment> create(
            screenKey: String? = null,
            creator: Creator<FragmentFactory, T>
        ) = DialogFragmentScreen(screenKey, creator)

        inline fun <reified T : DialogFragment> create(
            creator: Creator<FragmentFactory, T>
        ) = create(T::class.simpleName, creator)
    }
}
package me.s097t0r1.ktcast.di

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies

interface ApplicationDependencies : BaseFeatureDependencies {
    fun getContext(): Context
}

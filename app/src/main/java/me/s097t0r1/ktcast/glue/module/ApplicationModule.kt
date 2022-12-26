package me.s097t0r1.ktcast.glue.module

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder0
import me.s097t0r1.ktcast.di.ApplicationComponentHolder
import me.s097t0r1.ktcast.di.ApplicationDependencies

fun glueApplication(applicaton: Context) {
    ApplicationComponentHolder.provider = Provider {
        BaseDependencyHolder0.create {
            object : ApplicationDependencies {
                override fun getContext(): Context = applicaton
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = it
            }
        }
    }
}
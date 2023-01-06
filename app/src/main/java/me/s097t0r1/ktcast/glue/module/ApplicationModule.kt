package me.s097t0r1.ktcast.glue.module

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder0
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.ktcast.di.ApplicationComponentHolder
import me.s097t0r1.ktcast.di.ApplicationDependencies

@ComponentHolder(0)
fun glueApplication(application: Context) {
    ApplicationComponentHolder.provider = Provider {
        BaseDependencyHolder0.create {
            object : ApplicationDependencies {
                override fun getContext(): Context = application
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = it
            }
        }
    }
}
package me.s097t0r1.ktcast.glue.module.common

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDepenendencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holders.BaseDependencyHolder0
import me.s097t0r1.deps_holder_processor.ComponentHolder
import me.s097t0r1.persistence.database.di.DatabaseComponentHolder
import me.s097t0r1.persistence.database.di.DatabaseDependencies

@ComponentHolder(0)
internal fun glueDatabaseModule(applicationContext: Context) {
    DatabaseComponentHolder.provider = Provider {
        BaseDependencyHolder0.create { dependencyHolder ->
            object : DatabaseDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDepenendencies> = dependencyHolder
                override val applicationContext: Context = applicationContext
            }
        }
    }
}
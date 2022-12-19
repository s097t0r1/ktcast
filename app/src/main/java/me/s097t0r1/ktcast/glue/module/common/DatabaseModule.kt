package me.s097t0r1.ktcast.glue.module.common

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies
import me.s097t0r1.core.di.base.Provider
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder
import me.s097t0r1.core.di.base.holder.BaseDependencyHolder0
import me.s097t0r1.persistence.database.di.DatabaseComponentHolder
import me.s097t0r1.persistence.database.di.DatabaseDependencies

internal fun glueDatabaseModule(applicationContext: Context) {
    DatabaseComponentHolder.provider = Provider {
        BaseDependencyHolder0.create { dependencyHolder ->
            object : DatabaseDependencies {
                override val dependencyProvider: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                override val applicationContext: Context = applicationContext
            }
        }
    }
}
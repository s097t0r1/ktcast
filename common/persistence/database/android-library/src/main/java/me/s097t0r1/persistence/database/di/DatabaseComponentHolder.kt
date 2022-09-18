package me.s097t0r1.persistence.database.di

import me.s097t0r1.core.di.base.BaseComponentHolder

object DatabaseComponentHolder : BaseComponentHolder<DatabaseAPI, DatabaseDependencies>() {

    override fun initComponent(dependencies: DatabaseDependencies) =
        DaggerDatabaseComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as DatabaseComponent
}
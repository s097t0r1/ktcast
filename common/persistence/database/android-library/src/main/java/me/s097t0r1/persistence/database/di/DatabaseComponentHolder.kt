package me.s097t0r1.persistence.database.di

import me.s097t0r1.core.di.base.BaseComponentHolder

object DatabaseComponentHolder : BaseComponentHolder<DatabaseAPI, DatabaseDependencies, DatabaseComponent>() {

    override fun initComponent(dependencies: DatabaseDependencies): DatabaseComponent =
        DaggerDatabaseComponent.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent()
}
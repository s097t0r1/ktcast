package me.s097t0r1.persistence.database.di

import dagger.Component

@Component(
    dependencies = [DatabaseDependencies::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: DatabaseDependencies): DatabaseComponent
    }
}
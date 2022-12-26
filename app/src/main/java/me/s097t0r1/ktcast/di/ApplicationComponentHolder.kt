package me.s097t0r1.ktcast.di

import me.s097t0r1.core.di.base.BaseComponentHolder

object ApplicationComponentHolder : BaseComponentHolder<ApplicationAPI, ApplicationDependencies>() {

    override fun initComponent(dependencies: ApplicationDependencies): ApplicationAPI =
        DaggerApplicationComponent.factory().create(dependencies.getContext())

    fun getDaggerComponent() = getComponent() as ApplicationComponent
}

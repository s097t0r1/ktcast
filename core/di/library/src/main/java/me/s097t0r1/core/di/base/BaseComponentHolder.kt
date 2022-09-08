package me.s097t0r1.core.di.base

import java.lang.ref.WeakReference

abstract class BaseComponentHolder<A : BaseFeatureAPI, D : BaseFeatureDepenendencies, C : A> {

    private var weakRef: WeakReference<C>? = null

    lateinit var provider: Provider<D>

    protected abstract fun initComponent(dependencies: D): C

    fun get(): A = getComponent()

    protected fun getComponent(): C {
        var component: C? = null

        synchronized(this) {
            if (this::provider.isInitialized) {
                component = weakRef?.get()

                if (component == null) {
                    component = initComponent(provider.provide())
                    weakRef = WeakReference(component)
                }
            } else {
                error("Dependency provider is not initialized")
            }
        }

        return requireNotNull(component)
    }
}

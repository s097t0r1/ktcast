package me.s097t0r1.core.di.base

import java.lang.ref.WeakReference

abstract class BaseComponentHolder<A : BaseFeatureAPI, D : BaseFeatureDependencies> {

    private var weakRef: WeakReference<A>? = null

    lateinit var provider: Provider<D>

    protected abstract fun initComponent(dependencies: D): A

    fun get(): A = getComponent()

    protected fun getComponent(): A {
        var component: A? = null

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

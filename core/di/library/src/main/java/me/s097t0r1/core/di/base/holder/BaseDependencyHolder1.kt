package me.s097t0r1.core.di.base.holder

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.core.di.base.BaseFeatureDepenendencies

abstract class BaseDependencyHolder0<D : BaseFeatureDepenendencies> : BaseDependencyHolder<D>() {

    abstract val block: (BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(this)
}

abstract class BaseDependencyHolder1<A1 : BaseFeatureAPI, D : BaseFeatureDepenendencies>(
    private val a1: A1
) : BaseDependencyHolder<D>() {

    abstract val block: (A1, BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(a1, this)
}

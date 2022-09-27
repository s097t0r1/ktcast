package me.s097t0r1.core.di.base.holder

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.core.di.base.BaseFeatureDepenendencies

abstract class BaseDependencyHolder0<D : BaseFeatureDepenendencies> : BaseDependencyHolder<D>() {

    abstract val block: (BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(this)

    companion object {

        fun <D : BaseFeatureDepenendencies> create(block: (BaseDependencyHolder<D>) -> D) =
            object : BaseDependencyHolder0<D>() {
                override val block: (BaseDependencyHolder<D>) -> D = block
            }.dependecies

    }
}

abstract class BaseDependencyHolder1<A1 : BaseFeatureAPI, D : BaseFeatureDepenendencies>(
    private val a1: A1
) : BaseDependencyHolder<D>() {

    abstract val block: (A1, BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(a1, this)

    companion object {
        fun <D : BaseFeatureDepenendencies, A1 : BaseFeatureAPI> create(
            a1: A1,
            block: (A1, BaseDependencyHolder<D>) -> D
        ): D = object : BaseDependencyHolder1<A1, D>(a1 = a1) {
            override val block: (A1, BaseDependencyHolder<D>) -> D = block
        }.dependecies
    }

}

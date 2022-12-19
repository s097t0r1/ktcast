package me.s097t0r1.core.di.base.holder

import me.s097t0r1.core.di.base.BaseFeatureAPI
import me.s097t0r1.core.di.base.BaseFeatureDependencies

abstract class BaseDependencyHolder0<D : BaseFeatureDependencies> : BaseDependencyHolder<D>() {

    abstract val block: (BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(this)

    companion object {

        fun <D : BaseFeatureDependencies> create(block: (BaseDependencyHolder<D>) -> D) =
            object : BaseDependencyHolder0<D>() {
                override val block: (BaseDependencyHolder<D>) -> D = block
            }.dependecies

    }
}

abstract class BaseDependencyHolder1<A1 : BaseFeatureAPI, D : BaseFeatureDependencies>(
    private val a1: A1
) : BaseDependencyHolder<D>() {

    abstract val block: (A1, BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(a1, this)

    companion object {
        fun <D : BaseFeatureDependencies, A1 : BaseFeatureAPI> create(
            a1: A1,
            block: (A1, BaseDependencyHolder<D>) -> D
        ): D = object : BaseDependencyHolder1<A1, D>(a1 = a1) {
            override val block: (A1, BaseDependencyHolder<D>) -> D = block
        }.dependecies
    }

}

abstract class BaseDependencyHolder2<A1 : BaseFeatureAPI, A2 : BaseFeatureAPI, D : BaseFeatureDependencies>(
    private val a1: A1,
    private val a2: A2
) : BaseDependencyHolder<D>() {

    abstract val block: (A1, A2, BaseDependencyHolder<D>) -> D

    val dependecies: D get() = block(a1, a2, this)

    companion object {
        fun <D : BaseFeatureDependencies, A1 : BaseFeatureAPI, A2 : BaseFeatureAPI> create(
            a1: A1,
            a2: A2,
            block: (A1, A2, BaseDependencyHolder<D>) -> D
        ): D = object : BaseDependencyHolder2<A1, A2, D>(
            a1 = a1,
            a2 = a2
        ) {
            override val block: (A1, A2, BaseDependencyHolder<D>) -> D = block
        }.dependecies
    }

}

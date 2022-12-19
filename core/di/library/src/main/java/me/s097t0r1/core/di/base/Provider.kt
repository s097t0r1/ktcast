package me.s097t0r1.core.di.base

fun interface Provider<D : BaseFeatureDependencies> {
    fun provide(): D
}

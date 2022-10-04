package me.s097t0r1.core.utils.mapper

interface Mapper<I : Mappable, O : Mappable> {
    fun map(input: I): O
}

inline fun <reified T : Mapper<*, *>> createMapper(vararg args: Any) =
    T::class.java.constructors.first().newInstance(args) as T
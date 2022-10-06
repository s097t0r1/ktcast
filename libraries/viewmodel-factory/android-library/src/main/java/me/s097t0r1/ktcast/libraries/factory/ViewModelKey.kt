package me.s097t0r1.ktcast.libraries.factory

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(
    val viewModelClazz: KClass<out ViewModel>
)

package me.s097t0r1.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(
    @JvmSuppressWildcards
    val viewModelMap: Map<KClass<out ViewModel>, Provider<out ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var viewModelProvider = viewModelMap[modelClass.kotlin]
        return if (viewModelProvider == null) {
            viewModelProvider = viewModelMap.toList()
                .find { modelClass.isAssignableFrom(it.first.java) }
                ?.second
            requireNotNull(viewModelProvider) {
                "Provider for $modelClass didn't find"
            }
            viewModelProvider.get() as? T ?: error("Cannot create viewmodel with $modelClass")
        } else {
            viewModelProvider.get() as? T ?: error("Cannot create viewmodel with $modelClass")
        }
    }

}
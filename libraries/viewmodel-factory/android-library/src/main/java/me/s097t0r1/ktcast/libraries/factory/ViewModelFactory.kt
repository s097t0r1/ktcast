package me.s097t0r1.ktcast.libraries.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val map: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var viewModelProvider = map[modelClass]
        return if (viewModelProvider == null) {
            viewModelProvider = map.toList()
                .find { modelClass.isAssignableFrom(it.first) }?.second
            requireNotNull(viewModelProvider) {
                "Provider for $modelClass didn't find"
            }
            viewModelProvider.get() as? T ?: error("Cannot create viewmodel with $modelClass")
        } else {
            viewModelProvider.get() as? T ?: error("Cannot create viewmodel with $modelClass")
        }
    }

}
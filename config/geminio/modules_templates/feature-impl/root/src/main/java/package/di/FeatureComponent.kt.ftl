package ${packageName}.impl.di

import dagger.Component
import me.s097t0r1.core.di.base.scope.FeatureScope
import ${packageName}.api.${__formattedModuleName}FeatureAPI
import ${packageName}.api.${__formattedModuleName}FeatureDependencies
import me.s097t0r1.ktcast.libraries.factory.ViewModelFactoryModule

@FeatureScope
@Component(
    dependencies = [${__formattedModuleName}FeatureDependencies::class],
    modules = [ViewModelFactoryModule::class, ${__formattedModuleName}Module::class],
)
internal interface ${__formattedModuleName}Component : ${__formattedModuleName}FeatureAPI {

    @Component.Factory
    interface Factory {
        fun create(dependencies: ${__formattedModuleName}FeatureDependencies): ${__formattedModuleName}Component
    }
}

package ${packageName}.impl.di

import me.s097t0r1.core.di.base.BaseComponentHolder
import ${packageName}.api.${__formattedModuleName}FeatureAPI
import ${packageName}.api.${__formattedModuleName}FeatureDependencies

object ${__formattedModuleName}ComponentHolder : BaseComponentHolder<${__formattedModuleName}FeatureAPI, ${__formattedModuleName}FeatureDependencies>() {

    override fun initComponent(dependencies: ${__formattedModuleName}FeatureDependencies): ${__formattedModuleName}FeatureAPI =
        Dagger${__formattedModuleName}Component.factory().create(dependencies)

    internal fun getDaggerComponent() = getComponent() as ${__formattedModuleName}Component
}

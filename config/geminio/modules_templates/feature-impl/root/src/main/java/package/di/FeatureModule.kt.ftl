package ${packageName}.impl.di

import dagger.Binds
import dagger.Module
import dagger.Provides
<#if (includeStarter)>
import ${packageName}.api.AuthorizationFeatureStarter
import me.s097t0r1.core.navigation.screen.FragmentScreen
</#if>

@Module
internal abstract class ${__formattedModuleName}Module {

    companion object {

        <#if (includeStarter)>
        @Provides
        fun provideStarter(): ${__formattedModuleName}FeatureStarter = TODO()
        </#if>

    }
}

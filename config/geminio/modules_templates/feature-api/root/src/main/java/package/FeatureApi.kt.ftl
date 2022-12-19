package ${packageName}.api

import me.s097t0r1.core.di.base.BaseFeatureAPI

interface ${__formattedModuleName}FeatureAPI : BaseFeatureAPI {
    <#if (includeStarter)>
    val starter: ${__formattedModuleName}FeatureStarter
    </#if>
}

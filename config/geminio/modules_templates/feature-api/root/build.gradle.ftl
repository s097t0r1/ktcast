plugins {
    id("ktcast-feature-api")
}

dependencies {
     <#if (includeStarter)>
     implementation(projects.core.navigation.androidLibrary)
     </#if>
}

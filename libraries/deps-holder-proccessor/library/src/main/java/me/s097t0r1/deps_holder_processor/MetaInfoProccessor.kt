package me.s097t0r1.deps_holder_processor

import com.squareup.moshi.Json

class MetaInfoProccessor(
    @Json(name = "package_location")
    val packageLocation: String,

    @Json(name = "feature_api_package")
    val baseFeatureApiPackage: String,

    @Json(name = "feature_dependency_package")
    val baseFeatureDependencyPackage: String,

    @Json(name = "dependency_holder_package")
    val baseDependencyHolderPackage: String
)

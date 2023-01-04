package me.s097t0r1.ktcast.data.profile.api

import me.s097t0r1.core.di.base.BaseFeatureAPI

interface ProfileDataAPI : BaseFeatureAPI {
    val repository: ProfileRepository
}

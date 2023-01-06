package me.s097t0r1.persistence.database.di

import android.content.Context
import me.s097t0r1.core.di.base.BaseFeatureDependencies

interface DatabaseDependencies : BaseFeatureDependencies {
    val applicationContext: Context
}
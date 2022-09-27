package me.s097t0r1.ktcast.core.utils.resource_provider

import android.graphics.drawable.Drawable

interface ResourceProvider {
    fun getString(id: Int): String
    fun getDrawable(id: Int): Drawable
}
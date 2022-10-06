package me.s097t0r1.ktcast.libraries.resource_provider

import android.content.Context
import android.graphics.drawable.Drawable

class AndroidResourceProvider(
    private val context: Context
) : ResourceProvider {

    override fun getString(id: Int): String = context.getString(id)

    override fun getDrawable(id: Int): Drawable = context.getDrawable(id)
        ?: error("This drawable doesn't exist")
}
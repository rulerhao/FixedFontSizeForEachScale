package com.rulhouse.fixedfontsizeforeachscale

import android.content.Context

object FontMethods {
    fun getSameSizeForEachFontSize(fontSize: Float, context: Context): Float {
        val density = ScreenMethods.getDensity(context)
        val scale: Float = context.resources.configuration.fontScale
        return fontSize / density / scale
    }
}
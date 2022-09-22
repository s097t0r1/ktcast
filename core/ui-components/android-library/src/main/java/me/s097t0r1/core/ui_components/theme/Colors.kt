package me.s097t0r1.core.ui_components.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Immutable
class KtCastColors(

    // Background
    backgroundPrimaryColor: Color,
    backgroundSecondaryColor: Color,

    // Text
    textPrimaryColor: Color,
    textSecodaryColor: Color,

    // Icons
    iconPrimaryColor: Color,
    iconSecondaryColor: Color,
    iconSuccessColor: Color,
    iconNegativeColor: Color,
    iconAccentColor: Color

) {
    var backgroundPrimaryColor by mutableStateOf(backgroundPrimaryColor, structuralEqualityPolicy())
        internal set
    var backgroundSecondaryColor by mutableStateOf(backgroundSecondaryColor, structuralEqualityPolicy())
        internal set

    var textPrimaryColor by mutableStateOf(textPrimaryColor, structuralEqualityPolicy())
        internal set
    var textSecondaryColor by mutableStateOf(textSecodaryColor, structuralEqualityPolicy())
        internal set

    var iconPrimaryColor by mutableStateOf(iconPrimaryColor, structuralEqualityPolicy())
        internal set
    var iconSecondaryColor by mutableStateOf(iconSecondaryColor, structuralEqualityPolicy())
        internal set
    var iconSuccessColor by mutableStateOf(iconSuccessColor, structuralEqualityPolicy())
        internal set
    var iconNegativeColor by mutableStateOf(iconNegativeColor, structuralEqualityPolicy())
        internal set
    var iconAccentColor by mutableStateOf(iconAccentColor, structuralEqualityPolicy())
        internal set

    fun copy(
        backgroundPrimaryColor: Color = this.backgroundPrimaryColor,
        backgroundSecondaryColor: Color = this.backgroundSecondaryColor,
        textPrimaryColor: Color = this.textPrimaryColor,
        textSecodaryColor: Color = this.textSecondaryColor,
        iconPrimaryColor: Color = this.iconPrimaryColor,
        iconSecondaryColor: Color = this.iconSecondaryColor,
        iconSuccessColor: Color = this.iconSuccessColor,
        iconNegativeColor: Color = this.iconNegativeColor,
        iconAccentColor: Color = this.iconAccentColor
    ) = KtCastColors(
        backgroundPrimaryColor,
        backgroundSecondaryColor,
        textPrimaryColor,
        textSecodaryColor,
        iconPrimaryColor,
        iconSecondaryColor,
        iconSuccessColor,
        iconNegativeColor,
        iconAccentColor
    )
}

fun lightColors(
    backgroundPrimaryColor: Color = Color(0xFF09121C),
    backgroundSecondaryColor: Color = Color(0xFF19232F),
    textPrimaryColor: Color = Color(0xFFFFFFFF),
    textSecodaryColor: Color = Color(0xFF898F97),
    iconPrimaryColor: Color = Color(0xFF3369FF),
    iconSecondaryColor: Color = Color(0xFFDADADA),
    iconSuccessColor: Color = Color(0xFF459221),
    iconNegativeColor: Color = Color(0xFFFF334B),
    iconAccentColor: Color = Color(0xFFFF334B)
) = KtCastColors(
    backgroundPrimaryColor = backgroundPrimaryColor,
    backgroundSecondaryColor = backgroundSecondaryColor,
    textPrimaryColor = textPrimaryColor,
    textSecodaryColor = textSecodaryColor,
    iconPrimaryColor = iconPrimaryColor,
    iconSecondaryColor = iconSecondaryColor,
    iconSuccessColor = iconSuccessColor,
    iconNegativeColor = iconNegativeColor,
    iconAccentColor = iconAccentColor
)

fun darkColors(
    backgroundPrimaryColor: Color = Color(0xFF09121C),
    backgroundSecondaryColor: Color = Color(0xFF19232F),
    textPrimaryColor: Color = Color(0xFFFFFFFF),
    textSecodaryColor: Color = Color(0xFF898F97),
    iconPrimaryColor: Color = Color(0xFF3369FF),
    iconSecondaryColor: Color = Color(0xFFDADADA),
    iconSuccessColor: Color = Color(0xFF459221),
    iconNegativeColor: Color = Color(0xFFFF334B),
    iconAccentColor: Color = Color(0xFFFF334B)
) = KtCastColors(
    backgroundPrimaryColor = backgroundPrimaryColor,
    backgroundSecondaryColor = backgroundSecondaryColor,
    textPrimaryColor = textPrimaryColor,
    textSecodaryColor = textSecodaryColor,
    iconPrimaryColor = iconPrimaryColor,
    iconSecondaryColor = iconSecondaryColor,
    iconSuccessColor = iconSuccessColor,
    iconNegativeColor = iconNegativeColor,
    iconAccentColor = iconAccentColor
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }
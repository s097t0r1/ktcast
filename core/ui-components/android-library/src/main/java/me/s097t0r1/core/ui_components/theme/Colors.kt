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
    iconAccentColor: Color,

    buttonPrimaryColor: Color,
    buttonSecondaryColor: Color,

    fieldBasicColor: Color,
    fieldActiveColor: Color,
    fieldErrorColor: Color,
    fieldDisabledColor: Color,

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

    var buttonPrimaryColor by mutableStateOf(buttonPrimaryColor, structuralEqualityPolicy())
        internal set
    var buttonSecondaryColor by mutableStateOf(buttonSecondaryColor, structuralEqualityPolicy())
        internal set

    var fieldActiveColor by mutableStateOf(fieldActiveColor, structuralEqualityPolicy())
        internal set
    var fieldBasicColor by mutableStateOf(fieldBasicColor, structuralEqualityPolicy())
        internal set
    var fieldErrorColor by mutableStateOf(fieldErrorColor, structuralEqualityPolicy())
        internal set
    var fieldDisabledColor by mutableStateOf(fieldDisabledColor, structuralEqualityPolicy())
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
        iconAccentColor: Color = this.iconAccentColor,
        buttonPrimaryColor: Color = this.buttonPrimaryColor,
        buttonSecondaryColor: Color = this.buttonSecondaryColor,
        fieldBasicColor: Color = this.fieldBasicColor,
        fieldActiveColor: Color = this.fieldActiveColor,
        fieldDisabledColor: Color = this.fieldDisabledColor,
        fieldErrorColor: Color = this.fieldErrorColor
    ) = KtCastColors(
        backgroundPrimaryColor,
        backgroundSecondaryColor,
        textPrimaryColor,
        textSecodaryColor,
        iconPrimaryColor,
        iconSecondaryColor,
        iconSuccessColor,
        iconNegativeColor,
        iconAccentColor,
        buttonPrimaryColor,
        buttonSecondaryColor,
        fieldBasicColor,
        fieldActiveColor,
        fieldErrorColor,
        fieldDisabledColor
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
    iconAccentColor: Color = Color(0xFFFF334B),

    buttonPrimaryColor: Color = Color(0xFF3369FF),
    buttonSecondaryColor: Color = Color(0xFFFF334B),

    fieldBasicColor: Color = Color(0xFF898F97),
    fieldActiveColor: Color = Color(0xFF3369FF),
    fieldErrorColor: Color = Color(0xFFFF334B),
    fieldDisabledColor: Color = Color(0xFF656A70)

) = KtCastColors(
    backgroundPrimaryColor = backgroundPrimaryColor,
    backgroundSecondaryColor = backgroundSecondaryColor,

    textPrimaryColor = textPrimaryColor,
    textSecodaryColor = textSecodaryColor,

    iconPrimaryColor = iconPrimaryColor,
    iconSecondaryColor = iconSecondaryColor,
    iconSuccessColor = iconSuccessColor,
    iconNegativeColor = iconNegativeColor,
    iconAccentColor = iconAccentColor,

    buttonPrimaryColor = buttonPrimaryColor,
    buttonSecondaryColor = buttonSecondaryColor,

    fieldBasicColor = fieldBasicColor,
    fieldActiveColor = fieldActiveColor,
    fieldDisabledColor = fieldDisabledColor,
    fieldErrorColor = fieldErrorColor
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
    iconAccentColor: Color = Color(0xFFFF334B),

    buttonPrimaryColor: Color = Color(0xFF3369FF),
    buttonSecondaryColor: Color = Color(0xFFFF334B),

    fieldBasicColor: Color = Color(0xFF898F97),
    fieldActiveColor: Color = Color(0xFF3369FF),
    fieldErrorColor: Color = Color(0xFFFF334B),
    fieldDisabledColor: Color = Color(0xFF656A70)

) = KtCastColors(
    backgroundPrimaryColor = backgroundPrimaryColor,
    backgroundSecondaryColor = backgroundSecondaryColor,

    textPrimaryColor = textPrimaryColor,
    textSecodaryColor = textSecodaryColor,

    iconPrimaryColor = iconPrimaryColor,
    iconSecondaryColor = iconSecondaryColor,
    iconSuccessColor = iconSuccessColor,
    iconNegativeColor = iconNegativeColor,
    iconAccentColor = iconAccentColor,

    buttonPrimaryColor = buttonPrimaryColor,
    buttonSecondaryColor = buttonSecondaryColor,

    fieldBasicColor = fieldBasicColor,
    fieldActiveColor = fieldActiveColor,
    fieldDisabledColor = fieldDisabledColor,
    fieldErrorColor = fieldErrorColor
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }

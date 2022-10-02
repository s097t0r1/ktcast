package me.s097t0r1.core.ui_components.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Immutable
class KtCastColors(

    isLight: Boolean,

    // Brand colors
    primaryColor: Color,
    secondaryColor: Color,

    // Background
    backgroundPrimaryColor: Color,

    // Text
    textPrimaryColor: Color,
    textPlaceholderColor: Color,

    buttonPrimaryBackgroundColor: Color,
    buttonSecondaryBackgroundColor: Color,
    buttonDisabledBackgroundColor: Color,
    buttonPrimaryContentColor: Color,
    buttonSecondaryContentColor: Color,
    buttonDisabledContentColor: Color,

    fieldDefaultBackgroundColor: Color,
    fieldActiveBackgroundColor: Color,

    dividerColor: Color,
) {

    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

    var primaryColor by mutableStateOf(primaryColor, structuralEqualityPolicy())
        internal set
    var secondaryColor by mutableStateOf(secondaryColor, structuralEqualityPolicy())
        internal set

    var backgroundPrimaryColor by mutableStateOf(backgroundPrimaryColor, structuralEqualityPolicy())
        internal set

    var textPrimaryColor by mutableStateOf(textPrimaryColor, structuralEqualityPolicy())
        internal set
    var textPlaceholderColor by mutableStateOf(textPlaceholderColor, structuralEqualityPolicy())
        internal set

    var buttonPrimaryBackgroundColor by mutableStateOf(buttonPrimaryBackgroundColor, structuralEqualityPolicy())
        internal set
    var buttonSecondaryBackgroundColor by mutableStateOf(buttonSecondaryBackgroundColor, structuralEqualityPolicy())
        internal set
    var buttonDisabledBackgroundColor by mutableStateOf(buttonDisabledBackgroundColor, structuralEqualityPolicy())
        internal set
    var buttonPrimaryContentColor by mutableStateOf(buttonPrimaryContentColor, structuralEqualityPolicy())
        internal set
    var buttonSecondaryContentColor by mutableStateOf(buttonSecondaryContentColor, structuralEqualityPolicy())
        internal set
    var buttonDisabledContentColor by mutableStateOf(buttonDisabledContentColor, structuralEqualityPolicy())
        internal set

    var fieldDefaultBackgroundColor by mutableStateOf(fieldDefaultBackgroundColor, structuralEqualityPolicy())
        internal set
    var fieldActiveBackgroundColor by mutableStateOf(fieldActiveBackgroundColor, structuralEqualityPolicy())
        internal set

    var dividerColor by mutableStateOf(dividerColor, structuralEqualityPolicy())
        internal set

    fun updateFrom(other: KtCastColors) {
        isLight = other.isLight
        primaryColor = other.primaryColor
        secondaryColor = other.secondaryColor
        backgroundPrimaryColor = other.backgroundPrimaryColor
        textPrimaryColor = other.textPrimaryColor
        textPlaceholderColor = other.textPlaceholderColor
        buttonPrimaryBackgroundColor = other.buttonPrimaryBackgroundColor
        buttonSecondaryBackgroundColor = other.buttonSecondaryBackgroundColor
        buttonDisabledBackgroundColor = other.buttonDisabledBackgroundColor
        buttonPrimaryContentColor = other.buttonPrimaryContentColor
        buttonSecondaryContentColor = other.buttonSecondaryContentColor
        buttonDisabledContentColor = other.buttonDisabledContentColor
    }

    fun copy(
        isLight: Boolean = this.isLight,
        primaryColor: Color = this.primaryColor,
        secondaryColor: Color = this.secondaryColor,
        backgroundPrimaryColor: Color = this.backgroundPrimaryColor,
        textPrimaryColor: Color = this.textPrimaryColor,
        textPlaceholderColor: Color = this.textPlaceholderColor,
        buttonPrimaryBackgroundColor: Color = this.buttonPrimaryBackgroundColor,
        buttonSecondaryBackgroundColor: Color = this.buttonSecondaryBackgroundColor,
        buttonDisabledBackgroundColor: Color = this.buttonDisabledBackgroundColor,
        buttonPrimaryContentColor: Color = this.buttonPrimaryContentColor,
        buttonSecondaryContentColor: Color = this.buttonSecondaryContentColor,
        buttonDisabledContentColor: Color = this.buttonDisabledContentColor,
        fieldDefaultBackgroundColor: Color = this.fieldDefaultBackgroundColor,
        fieldActiveBackgroundColor: Color = this.fieldActiveBackgroundColor,
        dividerColor: Color = this.dividerColor
    ) = KtCastColors(
        isLight,
        primaryColor,
        secondaryColor,
        backgroundPrimaryColor,
        textPrimaryColor,
        textPlaceholderColor,
        buttonPrimaryBackgroundColor,
        buttonSecondaryBackgroundColor,
        buttonDisabledBackgroundColor,
        buttonPrimaryContentColor,
        buttonSecondaryContentColor,
        buttonDisabledContentColor,
        fieldDefaultBackgroundColor,
        fieldActiveBackgroundColor,
        dividerColor
    )
}

fun lightColors(
    primaryColor: Color = KtCastColorPallete.primaryColor,
    secondaryColor: Color = KtCastColorPallete.secondaryColor,

    backgroundPrimaryColor: Color = KtCastColorPallete.otherWhiteColor,

    textPrimaryColor: Color = KtCastColorPallete.grayScale900Color,
    textPlaceholderColor: Color = KtCastColorPallete.grayScale500Color,

    buttonPrimaryBackgroundColor: Color = KtCastColorPallete.primaryColor,
    buttonSecondaryBackgroundColor: Color = KtCastColorPallete.primary100Color,
    buttonDisabledBackgroundColor: Color = KtCastColorPallete.statusDisabledButton,
    buttonPrimaryContentColor: Color = KtCastColorPallete.otherWhiteColor,
    buttonSecondaryContentColor: Color = KtCastColorPallete.primaryColor,
    buttonDisabledContentColor: Color = KtCastColorPallete.otherWhiteColor,

    fieldDefaultBackgroundColor: Color = KtCastColorPallete.grayScale50Color,
    fieldActiveBackgroundColor: Color = KtCastColorPallete.transperentPurpleColor,

    dividerColor: Color = KtCastColorPallete.grayScale200Color
) = KtCastColors(
    isLight = true,

    primaryColor = primaryColor,
    secondaryColor = secondaryColor,

    backgroundPrimaryColor = backgroundPrimaryColor,

    textPrimaryColor = textPrimaryColor,
    textPlaceholderColor = textPlaceholderColor,

    buttonPrimaryBackgroundColor = buttonPrimaryBackgroundColor,
    buttonSecondaryBackgroundColor = buttonSecondaryBackgroundColor,
    buttonDisabledBackgroundColor = buttonDisabledBackgroundColor,
    buttonPrimaryContentColor = buttonPrimaryContentColor,
    buttonSecondaryContentColor = buttonSecondaryContentColor,
    buttonDisabledContentColor = buttonDisabledContentColor,

    fieldDefaultBackgroundColor = fieldDefaultBackgroundColor,
    fieldActiveBackgroundColor = fieldActiveBackgroundColor,

    dividerColor = dividerColor,
)

fun darkColors(
    primaryColor: Color = KtCastColorPallete.primaryColor,
    secondaryColor: Color = KtCastColorPallete.secondaryColor,

    backgroundPrimaryColor: Color = KtCastColorPallete.dark1Color,

    textPrimaryColor: Color = KtCastColorPallete.otherWhiteColor,
    textPlaceholderColor: Color = KtCastColorPallete.grayScale500Color,

    buttonPrimaryBackgroundColor: Color = KtCastColorPallete.primaryColor,
    buttonSecondaryBackgroundColor: Color = KtCastColorPallete.dark3Color,
    buttonDisabledBackgroundColor: Color = KtCastColorPallete.statusDisabledButton,
    buttonPrimaryContentColor: Color = KtCastColorPallete.otherWhiteColor,
    buttonSecondaryContentColor: Color = KtCastColorPallete.otherWhiteColor,
    buttonDisabledContentColor: Color = KtCastColorPallete.otherWhiteColor,

    fieldDefaultBackgroundColor: Color = KtCastColorPallete.dark2Color,
    fieldActiveBackgroundColor: Color = KtCastColorPallete.transperentPurpleColor,

    dividerColor: Color = KtCastColorPallete.dark3Color
) = KtCastColors(
    isLight = false,

    primaryColor = primaryColor,
    secondaryColor = secondaryColor,

    backgroundPrimaryColor = backgroundPrimaryColor,

    textPrimaryColor = textPrimaryColor,

    buttonPrimaryBackgroundColor = buttonPrimaryBackgroundColor,
    buttonSecondaryBackgroundColor = buttonSecondaryBackgroundColor,
    buttonDisabledBackgroundColor = buttonDisabledBackgroundColor,
    buttonPrimaryContentColor = buttonPrimaryContentColor,
    buttonSecondaryContentColor = buttonSecondaryContentColor,
    buttonDisabledContentColor = buttonDisabledContentColor,

    fieldDefaultBackgroundColor = fieldDefaultBackgroundColor,
    fieldActiveBackgroundColor = fieldActiveBackgroundColor,
    textPlaceholderColor = textPlaceholderColor,

    dividerColor = dividerColor,
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }

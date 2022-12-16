package me.s097t0r1.core.ui_components.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class KtCastTypography(

    val Heading1: TextStyle = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),
    val Heading2: TextStyle = Heading1.copy(
        fontSize = 40.sp
    ),
    val Heading3: TextStyle = Heading1.copy(
        fontSize = 32.sp
    ),
    val Heading4: TextStyle = Heading1.copy(
        fontSize = 24.sp
    ),
    val Heading5: TextStyle = Heading1.copy(
        fontSize = 24.sp
    ),
    val Heading6: TextStyle = Heading1.copy(
        fontSize = 18.sp
    ),

    val BodyXLarge: TextStyle = TextStyle(
        fontFamily = Urbanist,
        fontSize = 18.sp
    ),
    val BodyLarge: TextStyle = BodyXLarge.copy(
        fontSize = 16.sp
    ),
    val BodyMedium: TextStyle = BodyXLarge.copy(
        fontSize = 14.sp
    ),
    val BodySmall: TextStyle = BodyXLarge.copy(
        fontSize = 12.sp
    ),
    val BodyXSmall: TextStyle = BodyXLarge.copy(
        fontSize = 10.sp
    ),

)

internal val Urbanist = FontFamily(
    Font(me.s097t0r1.core.ui_components.res.R.font.urbanist_regular, FontWeight.Normal, FontStyle.Normal),
    Font(me.s097t0r1.core.ui_components.res.R.font.urbanist_medium, FontWeight.Medium, FontStyle.Normal),
    Font(me.s097t0r1.core.ui_components.res.R.font.urbanist_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(me.s097t0r1.core.ui_components.res.R.font.urbanist_bold, FontWeight.Bold, FontStyle.Normal)
)

internal val LocalTypography = staticCompositionLocalOf { KtCastTypography() }

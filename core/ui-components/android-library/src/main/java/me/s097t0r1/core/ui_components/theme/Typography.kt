package me.s097t0r1.core.ui_components.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.s097t0r1.core.ui_components.R

@Immutable
@Suppress("LongParameterList")
class KtCastTypography(

    val heading1: TextStyle = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),
    val heading2: TextStyle = heading1.copy(
        fontSize = 40.sp
    ),
    val heading3: TextStyle = heading1.copy(
        fontSize = 32.sp
    ),
    val heading4: TextStyle = heading1.copy(
        fontSize = 24.sp
    ),
    val heading5: TextStyle = heading1.copy(
        fontSize = 24.sp
    ),
    val heading6: TextStyle = heading1.copy(
        fontSize = 18.sp
    ),

    val bodyXLarge: TextStyle = TextStyle(
        fontFamily = Urbanist,
        fontSize = 18.sp
    ),
    val bodyLarge: TextStyle = bodyXLarge.copy(
        fontSize = 16.sp
    ),
    val bodyMedium: TextStyle = bodyXLarge.copy(
        fontSize = 14.sp
    ),
    val bodySmall: TextStyle = bodyXLarge.copy(
        fontSize = 12.sp
    ),
    val bodyXSmall: TextStyle = bodyXLarge.copy(
        fontSize = 10.sp
    ),

)

internal val Urbanist = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.urbanist_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.urbanist_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.urbanist_bold, FontWeight.Bold, FontStyle.Normal)
)

internal val LocalTypography = staticCompositionLocalOf { KtCastTypography() }

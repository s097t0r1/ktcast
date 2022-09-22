package me.s097t0r1.core.ui_components.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import me.s097t0r1.core.ui_components.R

@Immutable
class KtCastTypography(
    val mediumStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(RobotoMedium),
        fontWeight = FontWeight.Medium,
    ),
    val boldStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(RobotoBold),
        fontWeight = FontWeight.Bold
    ),
    val regularStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(RobotoRegular),
        fontWeight = FontWeight.Normal
    )
)

val RobotoBold = Font(R.font.roboto_bold)
val RobotoMedium = Font(R.font.roboto_medium)
val RobotoRegular = Font(R.font.roboto_regular)

internal val LocalTypography = staticCompositionLocalOf { KtCastTypography() }

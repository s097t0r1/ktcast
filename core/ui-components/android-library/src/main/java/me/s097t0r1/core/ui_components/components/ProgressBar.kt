package me.s097t0r1.core.ui_components.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun KtCastCircularProgressBar(
    modifier: Modifier = Modifier,
    color: Color = KtCastTheme.colors.primaryColor,
    strokeWidth: Dp = ProgressIndicatorDefaults.StrokeWidth
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        strokeWidth = strokeWidth
    )
}
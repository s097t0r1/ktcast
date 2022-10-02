package me.s097t0r1.core.ui_components.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun KtCastCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = KtCastTheme.colors.primaryColor,
        uncheckedColor = KtCastTheme.colors.primaryColor,
        checkmarkColor = KtCastColorPallete.otherWhiteColor,
        disabledColor = KtCastTheme.colors.buttonDisabledBackgroundColor,
        disabledIndeterminateColor = KtCastTheme.colors.buttonDisabledBackgroundColor
    )
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        colors = colors
    )
}
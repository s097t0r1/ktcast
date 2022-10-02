package me.s097t0r1.core.ui_components.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun KtCastPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = KtCastTheme.colors.buttonPrimaryBackgroundColor,
        contentColor = KtCastTheme.colors.buttonPrimaryContentColor,
        disabledBackgroundColor = KtCastTheme.colors.buttonDisabledBackgroundColor,
        disabledContentColor = KtCastTheme.colors.buttonDisabledContentColor
    ),
    contentPadding: PaddingValues = PaddingValues(vertical = 18.dp),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
    ) {
        ProvideTextStyle(KtCastTheme.typography.BodyLarge.copy(fontWeight = FontWeight.Bold)) {
            content()
        }
    }
}

@Composable
fun KtCastSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = KtCastTheme.colors.buttonSecondaryBackgroundColor,
        contentColor = KtCastTheme.colors.buttonSecondaryContentColor,
        disabledBackgroundColor = KtCastTheme.colors.buttonDisabledBackgroundColor,
        disabledContentColor = KtCastTheme.colors.buttonDisabledContentColor
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
    ) {
        ProvideTextStyle(
            KtCastTheme.typography.BodyLarge
                .copy(fontWeight = FontWeight.Bold)
        ) { content() }
    }
}

@Preview
@Composable
private fun KtCastPrimaryButtonPreview() {
    KtCastTheme {
        KtCastPrimaryButton(onClick = { /*TODO*/ }) { Text("Button") }
    }
}

@Preview
@Composable
private fun KtCastSecndaryButtonPreview() {
    KtCastTheme {
        KtCastSecondaryButton(onClick = { /*TODO*/ }) { Text("Button") }
    }
}

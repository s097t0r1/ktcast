package me.s097t0r1.ktcast.feature.authorization.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun SocialButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = null,
        shape = RoundedCornerShape(16.dp),
        contentPadding = contentPadding,
        border = BorderStroke(
            1.dp,
            if (KtCastTheme.colors.isLight) {
                KtCastColorPallete.grayScale200Color
            } else {
                KtCastColorPallete.dark3Color
            }
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (KtCastTheme.colors.isLight) {
                KtCastColorPallete.otherWhiteColor
            } else {
                KtCastColorPallete.dark2Color
            },
            contentColor = if(KtCastTheme.colors.isLight) {
                KtCastColorPallete.grayScale900Color
            } else {
                KtCastColorPallete.otherWhiteColor
            }
        ),
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides KtCastTheme.typography.BodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SocialButtonPreview() {
    KtCastTheme(true) {
        SocialButton(onClick = { /*TODO*/ }) {
            Text("Google")
        }
    }
}
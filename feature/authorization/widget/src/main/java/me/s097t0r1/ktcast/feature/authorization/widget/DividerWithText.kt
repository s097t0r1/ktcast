package me.s097t0r1.ktcast.feature.authorization.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun DividerWithText(
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Row(modifier) {
        Divider(
            modifier = Modifier
                .weight(0.4f)
                .align(Alignment.CenterVertically),
            color = KtCastTheme.colors.dividerColor
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center,
            text = text,
            color = if (KtCastTheme.colors.isLight) {
                KtCastColorPallete.grayScale700Color
            } else {
                KtCastColorPallete.otherWhiteColor
            },
            style = KtCastTheme.typography.BodyXLarge.copy(fontWeight = FontWeight.SemiBold)
        )
        Divider(
            modifier = Modifier
                .weight(0.4f)
                .align(Alignment.CenterVertically),
            color = KtCastTheme.colors.dividerColor
        )
    }
}

package me.s097t0r1.core.ui_components.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import me.s097t0r1.core.ui_components.theme.KtCastColorPallete
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@Composable
fun AlertSnackBar(
    alertSnackBarHost: AlertSnackBarHost,
    modifier: Modifier = Modifier
) {

    val currentAlertState = alertSnackBarHost.alertSnackBarState

    LaunchedEffect(currentAlertState) {
        if (currentAlertState == null) return@LaunchedEffect
        delay(currentAlertState.durationInMillis)
        alertSnackBarHost.dismiss()
    }

    AnimatedVisibility(
        visible = currentAlertState != null,
        enter = expandIn(),
        exit = shrinkOut()
    ) {

        if (currentAlertState == null) return@AnimatedVisibility

        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(16.dp),
            color = currentAlertState.alertType.color.copy(alpha = 0.2f),
            contentColor = currentAlertState.alertType.color
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = me.s097t0r1.core.ui_components.res.R.drawable.ic_info_circle),
                    tint = currentAlertState.alertType.color,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = currentAlertState.message,
                    style = KtCastTheme.typography.BodyMedium.copy(fontWeight = FontWeight.Normal)
                )
            }
        }
    }
}

@Stable
class AlertSnackBarHost {

    var alertSnackBarState: Inner? by mutableStateOf(null)

    fun show(
        message: String,
        alertType: AlertType,
        durationInMillis: Long
    ) {
        alertSnackBarState = Inner(message, alertType, durationInMillis)
    }

    fun dismiss() {
        alertSnackBarState = null
    }

    class Inner(
        val message: String,
        val alertType: AlertType,
        val durationInMillis: Long
    )

    enum class AlertType(val color: Color) {
        SUCCESS(KtCastColorPallete.statusSuccessColor),
        INFO(KtCastColorPallete.statusInfoColor),
        WARNING(KtCastColorPallete.statusWarningColor),
        ERROR(KtCastColorPallete.statusErrorColor)
    }

}
